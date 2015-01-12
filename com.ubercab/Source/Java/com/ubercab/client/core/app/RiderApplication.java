package com.ubercab.client.core.app;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import com.crashlytics.android.Crashlytics;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.mobileapptracker.MobileAppTracker;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.app.event.SignoutEvent;
import com.ubercab.client.core.content.CachePreferences;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.core.content.event.PingEvent;
import com.ubercab.client.core.metrics.monitoring.RiderMonitoringProperties;
import com.ubercab.client.core.model.AppConfig;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.RiderAppConfig;
import com.ubercab.client.core.network.AppConfigClient;
import com.ubercab.client.core.network.events.AppConfigResponseEvent;
import com.ubercab.client.core.push.RiderPushManager;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.core.util.RiderUtil;
import com.ubercab.client.feature.mobilemessage.LegacyMobileMessageManager;
import com.ubercab.client.feature.mobilemessage.MobileMessageManager;
import com.ubercab.client.feature.notification.RiderNotificationManager;
import com.ubercab.common.base.Preconditions;
import com.ubercab.library.app.UberApplication;
import com.ubercab.library.metrics.analytics.session.UberSessionGenerator;
import com.ubercab.library.metrics.monitoring.MonitoringClient;
import com.ubercab.ui.FontUtils;
import dagger.Lazy;
import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import timber.log.Timber;
import timber.log.Timber.Tree;

public class RiderApplication extends UberApplication
{

  @Inject
  AppConfigClient mAppConfigClient;

  @Inject
  Bus mBus;

  @Inject
  CachePreferences mCachePreferences;

  @Inject
  ExecutorService mExecutorService;

  @Inject
  LegacyMobileMessageManager mLegacyMobileMessageManager;

  @Inject
  MobileAppTracker mMobileAppTracker;

  @Inject
  MobileMessageManager mMobileMessageManager;

  @Inject
  MonitoringClient mMonitoringClient;
  private boolean mNotificationsEnabled;

  @Inject
  PingProvider mPingProvider;

  @Inject
  RiderMonitoringProperties mRiderMonitoringProperties;

  @Inject
  Lazy<RiderNotificationManager> mRiderNotificationManager;

  @Inject
  RiderPreferences mRiderPreferences;

  @Inject
  RiderPushManager mRiderPushManager;

  @Inject
  SessionPreferences mSessionPreferences;

  @Inject
  UberSessionGenerator mUberSessionGenerator;

  private void checkUpgradePath()
  {
    RiderUtil.upgradeFromGravy(this, this.mSessionPreferences);
  }

  private void forceOverflowMenu()
  {
    try
    {
      ViewConfiguration localViewConfiguration = ViewConfiguration.get(this);
      Field localField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
      if (localField != null)
      {
        localField.setAccessible(true);
        localField.setBoolean(localViewConfiguration, false);
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public static RiderApplication get(Context paramContext)
  {
    return (RiderApplication)paramContext.getApplicationContext();
  }

  private void initAnalytics()
  {
    this.mUberSessionGenerator.init("rider_app");
  }

  private void initAnonAppConfig()
  {
    this.mAppConfigClient.getAnonymousAppConfig();
  }

  private void initCrashlyticsUserInfo()
  {
    Crashlytics.setUserIdentifier(this.mSessionPreferences.getUserUuid());
  }

  private void initMobileAppTracking()
  {
    this.mExecutorService.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          AdvertisingIdClient.Info localInfo = AdvertisingIdClient.getAdvertisingIdInfo(RiderApplication.this);
          RiderApplication.this.mMobileAppTracker.setGoogleAdvertisingId(localInfo.getId(), localInfo.isLimitAdTrackingEnabled());
          return;
        }
        catch (Exception localException)
        {
        }
      }
    });
    this.mMobileAppTracker.measureSession();
  }

  private void initMobileMessaging()
  {
    this.mLegacyMobileMessageManager.init();
    this.mMobileMessageManager.init();
  }

  private void initMonitoring()
  {
    this.mMonitoringClient.setMonitoringProperties(this.mRiderMonitoringProperties);
  }

  private void initNotifications()
  {
    if ((this.mRiderPreferences.isNotificationsEnabled()) && (this.mSessionPreferences.hasToken()))
      setNotificationsEnabled(true);
  }

  private void initStrictMode()
  {
  }

  private void initUiFont()
  {
    FontUtils.init(this);
  }

  private void registerBus()
  {
    this.mBus.register(this);
  }

  private void setNotificationsEnabled(boolean paramBoolean)
  {
    if (paramBoolean == this.mNotificationsEnabled)
      return;
    this.mNotificationsEnabled = paramBoolean;
    this.mRiderPreferences.setNotificationsEnabled(paramBoolean);
    if (paramBoolean)
    {
      ((RiderNotificationManager)this.mRiderNotificationManager.get()).start();
      this.mRiderPushManager.register();
      return;
    }
    ((RiderNotificationManager)this.mRiderNotificationManager.get()).stop();
    this.mRiderPushManager.unregister(this.mSessionPreferences.getToken());
  }

  protected Timber.Tree getLoggingTree()
  {
    return new LoggingTree();
  }

  protected Object[] getModules()
  {
    return RiderModules.list(this);
  }

  public boolean isRunningInTests()
  {
    return (0x100 & getApplicationInfo().flags) != 0;
  }

  @Subscribe
  public void onAppConfigResponseEvent(AppConfigResponseEvent paramAppConfigResponseEvent)
  {
    if (paramAppConfigResponseEvent.isSuccess())
    {
      AppConfig localAppConfig = (AppConfig)paramAppConfigResponseEvent.getModel();
      if (localAppConfig != null)
        this.mRiderPreferences.setPayTmSignupEnabled(localAppConfig.isPayTmSignupEnabled().booleanValue());
    }
  }

  public void onCreate()
  {
    super.onCreate();
    initStrictMode();
    initUiFont();
    initCrashlyticsUserInfo();
    initMobileAppTracking();
    initMobileMessaging();
    initAnalytics();
    initAnonAppConfig();
    initMonitoring();
    initNotifications();
    checkUpgradePath();
    forceOverflowMenu();
    registerBus();
  }

  @Subscribe
  public void onPingEvent(PingEvent paramPingEvent)
  {
    if (!this.mSessionPreferences.hasToken());
    Ping localPing;
    do
    {
      return;
      localPing = paramPingEvent.getPing();
    }
    while (!PingUtils.hasRiderAppConfig(localPing));
    RiderAppConfig localRiderAppConfig = localPing.getAppConfig().getRiderConfig();
    setNotificationsEnabled(localRiderAppConfig.androidNotificationsEnabled());
    this.mRiderPreferences.setNewConfirmationEnabled(localRiderAppConfig.isNewConfirmationEnabled());
    this.mRiderPreferences.setLocationSearch(localRiderAppConfig.getLocationSearch());
  }

  public void setCurrentUser(String paramString1, String paramString2, String paramString3)
  {
    Preconditions.checkNotNull(paramString1);
    Preconditions.checkNotNull(paramString2);
    Preconditions.checkNotNull(paramString3);
    this.mSessionPreferences.setUserUuid(paramString1);
    if (TextUtils.isEmpty(paramString2));
    for (String str = "Set empty token."; ; str = "Set non-empty token.")
    {
      Timber.d(str, new Object[0]);
      this.mSessionPreferences.setToken(paramString2);
      this.mCachePreferences.addUserSignInName(paramString3);
      initCrashlyticsUserInfo();
      return;
    }
  }

  public void signout()
  {
    String str = this.mSessionPreferences.getToken();
    if (TextUtils.isEmpty(str))
      return;
    this.mSessionPreferences.clear();
    this.mRiderPreferences.clear();
    this.mPingProvider.clear();
    initCrashlyticsUserInfo();
    this.mRiderPushManager.unregister(str);
    ((RiderNotificationManager)this.mRiderNotificationManager.get()).stop();
    this.mBus.post(new SignoutEvent());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.app.RiderApplication
 * JD-Core Version:    0.6.2
 */