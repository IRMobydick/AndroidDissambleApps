package com.ubercab.client.core.app;

import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.squareup.otto.Bus;
import com.squareup.otto.Produce;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.analytics.event.AppEvent;
import com.ubercab.client.core.analytics.event.NearestCabEvent;
import com.ubercab.client.core.analytics.event.SessionEvent;
import com.ubercab.client.core.app.event.RiderServiceReadyEvent;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.core.model.AppConfig;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.Session;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.library.app.UberApplication;
import com.ubercab.library.app.UberPreferences;
import com.ubercab.library.app.UberService;
import com.ubercab.library.app.annotation.ForCn;
import com.ubercab.library.location.event.NoLocationEvent;
import com.ubercab.library.location.model.UberLocation;
import com.ubercab.library.network.FailoverStrategy;
import com.ubercab.library.network.UberEndpoint;
import com.ubercab.library.network.cn.strategy.CnListFailoverStrategy;
import com.ubercab.library.network.cn.strategy.CnRedirectFailoverStrategy;
import com.ubercab.library.network.dispatch.DispatchCallback;
import com.ubercab.library.network.dispatch.DispatchClient;
import com.ubercab.library.network.dispatch.DispatchRequest;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class RiderService extends UberService
  implements DispatchCallback<Ping>
{
  private static final int PING_TIMER_INTERVAL_DEFAULT = 4000;
  private static final int PING_TIMER_INTERVAL_MINIMUM = 1000;
  private static final TimeUnit PING_TIMER_INTERVAL_UNITS = TimeUnit.MILLISECONDS;

  @Inject
  AnalyticsManager mAnalyticsManager;

  @Inject
  Bus mBus;

  @Inject
  DispatchClient mCnClient;

  @ForCn
  @Inject
  FailoverStrategy mDefaultFailoverStrategy;

  @Inject
  Gson mGson;
  private boolean mHasSentFirstPing;
  private ScheduledExecutorService mPingExecutor = Executors.newSingleThreadScheduledExecutor();
  private ScheduledFuture<?> mPingFuture;
  private Runnable mPingRunnable = new Runnable()
  {
    public void run()
    {
      if ((RiderService.this.mPingFuture == null) || (RiderService.this.mPingFuture.isCancelled()));
      do
      {
        return;
        RiderService.access$002(RiderService.this, null);
      }
      while (!RiderService.this.mSessionPreferences.hasToken());
      RiderService.this.mRiderClient.pingClient();
      RiderService.this.mAnalyticsManager.nearestCabEvent().ping();
    }
  };
  private long mPingUpdateInterval;

  @Inject
  RiderClient mRiderClient;

  @Inject
  SessionPreferences mSessionPreferences;

  @ForCn
  @Inject
  UberEndpoint mUberEndpoint;

  @Inject
  UberPreferences mUberPreferences;

  private void schedulePing(DispatchRequest paramDispatchRequest, long paramLong)
  {
    if (!paramDispatchRequest.isExpectingPingResults())
      return;
    stopPing();
    this.mPingFuture = this.mPingExecutor.schedule(this.mPingRunnable, paramLong, PING_TIMER_INTERVAL_UNITS);
  }

  private void startPing()
  {
    if (this.mSessionPreferences.hasToken())
    {
      this.mRiderClient.pingClient();
      this.mAnalyticsManager.nearestCabEvent().ping();
    }
  }

  private void stopPing()
  {
    if (this.mPingFuture != null)
    {
      this.mPingFuture.cancel(true);
      this.mPingFuture = null;
    }
  }

  public IBinder onBind(Intent paramIntent)
  {
    return new RiderServiceBinder(this);
  }

  public void onCreate()
  {
    super.onCreate();
    UberApplication.get(this).inject(this);
    this.mCnClient.addCallback(this);
    this.mAnalyticsManager.sessionEvent().sessionStart();
    this.mPingUpdateInterval = 4000L;
  }

  public void onDestroy()
  {
    super.onDestroy();
    stopPing();
    this.mCnClient.removeCallback(this);
    this.mAnalyticsManager.sessionEvent().sessionEnd();
  }

  public void onDispatchError(DispatchRequest paramDispatchRequest, Ping paramPing, Response paramResponse)
  {
    schedulePing(paramDispatchRequest, this.mPingUpdateInterval);
  }

  public void onDispatchNetworkError(DispatchRequest paramDispatchRequest, RetrofitError paramRetrofitError)
  {
    schedulePing(paramDispatchRequest, this.mPingUpdateInterval);
  }

  public void onDispatchSuccess(DispatchRequest paramDispatchRequest, Ping paramPing, Response paramResponse)
  {
    if (PingUtils.hasSession(paramPing))
    {
      String str2 = paramPing.getSession().getSessionHash();
      if ((!TextUtils.isEmpty(str2)) && (!str2.equals(this.mSessionPreferences.getSessionHash())))
        this.mSessionPreferences.setSessionHash(str2);
    }
    String str1;
    if (PingUtils.hasPingUpdateInterval(paramPing))
    {
      this.mPingUpdateInterval = paramPing.getAppConfig().getPingUpdateIntervalMs().longValue();
      if (this.mPingUpdateInterval < 1000L)
        this.mPingUpdateInterval = 1000L;
      if (PingUtils.hasAppConfig(paramPing))
      {
        this.mUberPreferences.setAnalyticsV2Disabled(paramPing.getAppConfig().getAnalyticsV2Disabled());
        this.mUberPreferences.setMonitoringEnabled(paramPing.getAppConfig().isNetworkMonitoringEnabled());
      }
      if (!PingUtils.hasFailoverStrategy(paramPing))
        break label289;
      str1 = paramPing.getAppConfig().getFailoverStrategy();
      if (!this.mUberEndpoint.getFailoverStrategy().getName().equals(str1))
      {
        if (!str1.equals("cnRedirect"))
          break label256;
        this.mUberEndpoint.setFailoverStrategy(new CnRedirectFailoverStrategy());
      }
      label183: if ((!paramPing.isForceUpgrade()) || (TextUtils.isEmpty(paramPing.getForceUpgradeUrl())))
        break label303;
      startActivity(new Intent("com.ubercab.intent.ForceUpgrade").setFlags(268468224).putExtra("forceUpgradeUrl", paramPing.getForceUpgradeUrl()));
      stopPing();
    }
    while (true)
    {
      this.mAnalyticsManager.nearestCabEvent().updateVehicleDataFromPing(paramPing);
      return;
      this.mPingUpdateInterval = 4000L;
      break;
      label256: if (!str1.equals("cnList"))
        break label183;
      this.mUberEndpoint.setFailoverStrategy(new CnListFailoverStrategy(this, this.mGson));
      break label183;
      label289: this.mUberEndpoint.setFailoverStrategy(this.mDefaultFailoverStrategy);
      break label183;
      label303: schedulePing(paramDispatchRequest, this.mPingUpdateInterval);
    }
  }

  public void onLocationChanged(UberLocation paramUberLocation)
  {
    super.onLocationChanged(paramUberLocation);
    if (!this.mHasSentFirstPing)
    {
      this.mHasSentFirstPing = true;
      startPing();
    }
  }

  @Subscribe
  public void onNoLocationEvent(NoLocationEvent paramNoLocationEvent)
  {
    this.mAnalyticsManager.appEvent().noLocationFound();
    if (!this.mHasSentFirstPing)
    {
      this.mHasSentFirstPing = true;
      startPing();
    }
  }

  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    this.mBus.post(produceRiderServiceReadyEvent());
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }

  @Produce
  public NoLocationEvent produceNoLocationEvent()
  {
    return super.produceNoLocationEvent();
  }

  @Produce
  public RiderServiceReadyEvent produceRiderServiceReadyEvent()
  {
    return new RiderServiceReadyEvent();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.app.RiderService
 * JD-Core Version:    0.6.2
 */