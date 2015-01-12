package com.ubercab.library.app;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.squareup.otto.Bus;
import com.squareup.otto.Produce;
import com.ubercab.geo.GeoManager;
import com.ubercab.geo.GeoManager.Listener;
import com.ubercab.library.app.event.UberServiceStartEvent;
import com.ubercab.library.location.LocationProvider;
import com.ubercab.library.location.client.LocationClientVendor;
import com.ubercab.library.location.client.UberLocationClient;
import com.ubercab.library.location.client.UberLocationClientError;
import com.ubercab.library.location.client.UberLocationListener;
import com.ubercab.library.location.event.NoLocationEvent;
import com.ubercab.library.location.model.UberLocation;
import com.ubercab.library.location.model.UberLocationRequest;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import com.ubercab.library.metrics.monitoring.MonitoringClient;
import com.ubercab.library.vendor.google.GoogleUtils;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

public class UberService extends Service
  implements UberLocationListener, GeoManager.Listener
{
  private static final int ANALYTICS_INTERVAL_MS = 5000;

  @Inject
  AnalyticsClient mAnalyticsClient;
  private final ScheduledExecutorService mAnalyticsExecutor = Executors.newSingleThreadScheduledExecutor();

  @Inject
  Bus mBus;

  @Inject
  GeoManager mGeoManager;
  private final Handler mHandler = new Handler();
  private final Object mLocationClientLock = new Object();

  @Inject
  LocationClientVendor mLocationClientVendor;

  @Inject
  LocationProvider mLocationProvider;
  private LocationTimeoutRunnable mLocationTimeoutRunnable;

  @Inject
  MonitoringClient mMonitoringClient;
  private Runnable mRunnableAnalytics = new Runnable()
  {
    public void run()
    {
      UberService.this.mAnalyticsClient.sendEvents();
      UberService.this.mMonitoringClient.sendEvents();
    }
  };
  private UberLocationClient mUberLocationClient;

  @Inject
  UberPreferences mUberPreferences;

  private void initAnalytics()
  {
    this.mAnalyticsExecutor.scheduleAtFixedRate(this.mRunnableAnalytics, 0L, 5000L, TimeUnit.MILLISECONDS);
  }

  private void initLocationTimeout()
  {
    if (GoogleUtils.isLocationProviderAvailable(this))
    {
      this.mLocationTimeoutRunnable = new LocationTimeoutRunnable(null);
      this.mHandler.postDelayed(new LocationTimeoutRunnable(null), getLocationTimeoutLength());
      return;
    }
    this.mBus.post(produceNoLocationEvent());
  }

  protected void connectLocationClient()
  {
    synchronized (this.mLocationClientLock)
    {
      if ((this.mUberLocationClient != null) && (!this.mUberLocationClient.isConnected()))
      {
        this.mUberLocationClient.registerLocationListener(this);
        this.mUberLocationClient.connect();
      }
      return;
    }
  }

  protected void disconnectLocationClient()
  {
    synchronized (this.mLocationClientLock)
    {
      if ((this.mUberLocationClient != null) && (this.mUberLocationClient.isConnected()))
      {
        this.mUberLocationClient.unregisterLocationListener(this);
        this.mUberLocationClient.disconnect();
      }
      return;
    }
  }

  protected UberLocationRequest getLocationRequestBackoff()
  {
    return UberLocationRequest.create().setPriority(0).setFastestInterval(3000L).setInterval(5000L);
  }

  protected UberLocationRequest getLocationRequestInitial()
  {
    return UberLocationRequest.create().setPriority(1).setFastestInterval(16L).setInterval(5000L);
  }

  protected int getLocationTimeoutLength()
  {
    return 4000;
  }

  public IBinder onBind(Intent paramIntent)
  {
    return new UberServiceBinder(this);
  }

  public void onCreate()
  {
    super.onCreate();
    UberApplication.get(this).inject(this);
    this.mGeoManager.addListener(this);
    this.mGeoManager.fetch();
    initAnalytics();
    this.mBus.register(this);
  }

  public void onDestroy()
  {
    super.onDestroy();
    if (this.mLocationTimeoutRunnable != null);
    synchronized (this.mHandler)
    {
      this.mHandler.removeCallbacks(this.mLocationTimeoutRunnable);
      this.mLocationTimeoutRunnable = null;
      this.mBus.unregister(this);
      disconnectLocationClient();
      return;
    }
  }

  public void onGeoDetermined(int paramInt)
  {
    this.mGeoManager.removeListener(this);
    this.mUberLocationClient = new UberLocationClient(this, this.mLocationClientVendor);
    synchronized (this.mLocationClientLock)
    {
      this.mUberLocationClient.registerLocationListener(this);
      this.mUberLocationClient.setLocationRequest(getLocationRequestInitial());
      this.mUberLocationClient.connect();
      initLocationTimeout();
      return;
    }
  }

  public void onLocationChanged(UberLocation paramUberLocation)
  {
    synchronized (this.mLocationClientLock)
    {
      if ((this.mUberLocationClient.isConnected()) && (this.mUberLocationClient.getLastKnownLocation() == null))
        this.mUberLocationClient.setLocationRequest(getLocationRequestBackoff());
      if (this.mUberPreferences.hasFakeLocation())
        paramUberLocation = this.mUberPreferences.getFakeLocation();
      this.mLocationProvider.update(paramUberLocation);
      return;
    }
  }

  public void onLocationFailed(UberLocationClientError paramUberLocationClientError)
  {
  }

  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    this.mBus.post(produceUberServiceReadyEvent());
    return 1;
  }

  @Produce
  public NoLocationEvent produceNoLocationEvent()
  {
    NoLocationEvent localNoLocationEvent;
    if (!GoogleUtils.isLocationProviderAvailable(this))
      localNoLocationEvent = new NoLocationEvent();
    UberLocation localUberLocation;
    do
    {
      LocationTimeoutRunnable localLocationTimeoutRunnable;
      do
      {
        return localNoLocationEvent;
        localLocationTimeoutRunnable = this.mLocationTimeoutRunnable;
        localNoLocationEvent = null;
      }
      while (localLocationTimeoutRunnable != null);
      localUberLocation = this.mLocationProvider.getLocation();
      localNoLocationEvent = null;
    }
    while (localUberLocation != null);
    return new NoLocationEvent();
  }

  @Produce
  public UberServiceStartEvent produceUberServiceReadyEvent()
  {
    return new UberServiceStartEvent();
  }

  protected void updateLocationRequest(UberLocationRequest paramUberLocationRequest)
  {
    synchronized (this.mLocationClientLock)
    {
      if ((this.mUberLocationClient != null) && (this.mUberLocationClient.isConnected()))
        this.mUberLocationClient.setLocationRequest(paramUberLocationRequest);
      return;
    }
  }

  private class LocationTimeoutRunnable
    implements Runnable
  {
    private LocationTimeoutRunnable()
    {
    }

    public void run()
    {
      synchronized (UberService.this.mHandler)
      {
        if (UberService.this.mLocationTimeoutRunnable == null)
          return;
        UberService.access$202(UberService.this, null);
        if (UberService.this.mLocationProvider.getLocation() != null)
          return;
      }
      UberLocation localUberLocation = UberService.this.mUberLocationClient.getLastKnownLocation();
      if (localUberLocation == null)
        UberService.this.mBus.post(new NoLocationEvent());
      while (true)
      {
        return;
        UberService.this.onLocationChanged(localUberLocation);
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.app.UberService
 * JD-Core Version:    0.6.2
 */