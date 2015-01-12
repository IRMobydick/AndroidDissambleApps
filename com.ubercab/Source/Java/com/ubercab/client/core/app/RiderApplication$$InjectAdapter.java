package com.ubercab.client.core.app;

import com.mobileapptracker.MobileAppTracker;
import com.squareup.otto.Bus;
import com.ubercab.client.core.content.CachePreferences;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.core.metrics.monitoring.RiderMonitoringProperties;
import com.ubercab.client.core.network.AppConfigClient;
import com.ubercab.client.core.push.RiderPushManager;
import com.ubercab.client.feature.mobilemessage.LegacyMobileMessageManager;
import com.ubercab.client.feature.mobilemessage.MobileMessageManager;
import com.ubercab.client.feature.notification.RiderNotificationManager;
import com.ubercab.library.app.UberApplication;
import com.ubercab.library.metrics.analytics.session.UberSessionGenerator;
import com.ubercab.library.metrics.monitoring.MonitoringClient;
import dagger.Lazy;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import javax.inject.Provider;

public final class RiderApplication$$InjectAdapter extends Binding<RiderApplication>
  implements Provider<RiderApplication>, MembersInjector<RiderApplication>
{
  private Binding<AppConfigClient> mAppConfigClient;
  private Binding<Bus> mBus;
  private Binding<CachePreferences> mCachePreferences;
  private Binding<ExecutorService> mExecutorService;
  private Binding<LegacyMobileMessageManager> mLegacyMobileMessageManager;
  private Binding<MobileAppTracker> mMobileAppTracker;
  private Binding<MobileMessageManager> mMobileMessageManager;
  private Binding<MonitoringClient> mMonitoringClient;
  private Binding<PingProvider> mPingProvider;
  private Binding<RiderMonitoringProperties> mRiderMonitoringProperties;
  private Binding<Lazy<RiderNotificationManager>> mRiderNotificationManager;
  private Binding<RiderPreferences> mRiderPreferences;
  private Binding<RiderPushManager> mRiderPushManager;
  private Binding<SessionPreferences> mSessionPreferences;
  private Binding<UberSessionGenerator> mUberSessionGenerator;
  private Binding<UberApplication> supertype;

  public RiderApplication$$InjectAdapter()
  {
    super("com.ubercab.client.core.app.RiderApplication", "members/com.ubercab.client.core.app.RiderApplication", false, RiderApplication.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mAppConfigClient = paramLinker.requestBinding("com.ubercab.client.core.network.AppConfigClient", RiderApplication.class, getClass().getClassLoader());
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", RiderApplication.class, getClass().getClassLoader());
    this.mCachePreferences = paramLinker.requestBinding("com.ubercab.client.core.content.CachePreferences", RiderApplication.class, getClass().getClassLoader());
    this.mExecutorService = paramLinker.requestBinding("java.util.concurrent.ExecutorService", RiderApplication.class, getClass().getClassLoader());
    this.mLegacyMobileMessageManager = paramLinker.requestBinding("com.ubercab.client.feature.mobilemessage.LegacyMobileMessageManager", RiderApplication.class, getClass().getClassLoader());
    this.mMobileAppTracker = paramLinker.requestBinding("com.mobileapptracker.MobileAppTracker", RiderApplication.class, getClass().getClassLoader());
    this.mMobileMessageManager = paramLinker.requestBinding("com.ubercab.client.feature.mobilemessage.MobileMessageManager", RiderApplication.class, getClass().getClassLoader());
    this.mMonitoringClient = paramLinker.requestBinding("com.ubercab.library.metrics.monitoring.MonitoringClient", RiderApplication.class, getClass().getClassLoader());
    this.mPingProvider = paramLinker.requestBinding("com.ubercab.client.core.content.PingProvider", RiderApplication.class, getClass().getClassLoader());
    this.mRiderMonitoringProperties = paramLinker.requestBinding("com.ubercab.client.core.metrics.monitoring.RiderMonitoringProperties", RiderApplication.class, getClass().getClassLoader());
    this.mRiderNotificationManager = paramLinker.requestBinding("dagger.Lazy<com.ubercab.client.feature.notification.RiderNotificationManager>", RiderApplication.class, getClass().getClassLoader());
    this.mRiderPreferences = paramLinker.requestBinding("com.ubercab.client.core.app.RiderPreferences", RiderApplication.class, getClass().getClassLoader());
    this.mRiderPushManager = paramLinker.requestBinding("com.ubercab.client.core.push.RiderPushManager", RiderApplication.class, getClass().getClassLoader());
    this.mSessionPreferences = paramLinker.requestBinding("com.ubercab.client.core.content.SessionPreferences", RiderApplication.class, getClass().getClassLoader());
    this.mUberSessionGenerator = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.session.UberSessionGenerator", RiderApplication.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.library.app.UberApplication", RiderApplication.class, getClass().getClassLoader(), false, true);
  }

  public RiderApplication get()
  {
    RiderApplication localRiderApplication = new RiderApplication();
    injectMembers(localRiderApplication);
    return localRiderApplication;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mAppConfigClient);
    paramSet2.add(this.mBus);
    paramSet2.add(this.mCachePreferences);
    paramSet2.add(this.mExecutorService);
    paramSet2.add(this.mLegacyMobileMessageManager);
    paramSet2.add(this.mMobileAppTracker);
    paramSet2.add(this.mMobileMessageManager);
    paramSet2.add(this.mMonitoringClient);
    paramSet2.add(this.mPingProvider);
    paramSet2.add(this.mRiderMonitoringProperties);
    paramSet2.add(this.mRiderNotificationManager);
    paramSet2.add(this.mRiderPreferences);
    paramSet2.add(this.mRiderPushManager);
    paramSet2.add(this.mSessionPreferences);
    paramSet2.add(this.mUberSessionGenerator);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(RiderApplication paramRiderApplication)
  {
    paramRiderApplication.mAppConfigClient = ((AppConfigClient)this.mAppConfigClient.get());
    paramRiderApplication.mBus = ((Bus)this.mBus.get());
    paramRiderApplication.mCachePreferences = ((CachePreferences)this.mCachePreferences.get());
    paramRiderApplication.mExecutorService = ((ExecutorService)this.mExecutorService.get());
    paramRiderApplication.mLegacyMobileMessageManager = ((LegacyMobileMessageManager)this.mLegacyMobileMessageManager.get());
    paramRiderApplication.mMobileAppTracker = ((MobileAppTracker)this.mMobileAppTracker.get());
    paramRiderApplication.mMobileMessageManager = ((MobileMessageManager)this.mMobileMessageManager.get());
    paramRiderApplication.mMonitoringClient = ((MonitoringClient)this.mMonitoringClient.get());
    paramRiderApplication.mPingProvider = ((PingProvider)this.mPingProvider.get());
    paramRiderApplication.mRiderMonitoringProperties = ((RiderMonitoringProperties)this.mRiderMonitoringProperties.get());
    paramRiderApplication.mRiderNotificationManager = ((Lazy)this.mRiderNotificationManager.get());
    paramRiderApplication.mRiderPreferences = ((RiderPreferences)this.mRiderPreferences.get());
    paramRiderApplication.mRiderPushManager = ((RiderPushManager)this.mRiderPushManager.get());
    paramRiderApplication.mSessionPreferences = ((SessionPreferences)this.mSessionPreferences.get());
    paramRiderApplication.mUberSessionGenerator = ((UberSessionGenerator)this.mUberSessionGenerator.get());
    this.supertype.injectMembers(paramRiderApplication);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.app.RiderApplication..InjectAdapter
 * JD-Core Version:    0.6.2
 */