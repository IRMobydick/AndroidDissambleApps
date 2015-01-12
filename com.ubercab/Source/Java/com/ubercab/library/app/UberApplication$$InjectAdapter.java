package com.ubercab.library.app;

import com.ubercab.library.map.MapVendor;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

public final class UberApplication$$InjectAdapter extends Binding<UberApplication>
  implements MembersInjector<UberApplication>
{
  private Binding<AnalyticsClient> mAnalyticsClient;
  private Binding<BuildConfigProxy> mAppBuildConfig;
  private Binding<LifecycleTracker> mAppLifecycleTracker;
  private Binding<MapVendor> mMapVendor;

  public UberApplication$$InjectAdapter()
  {
    super(null, "members/com.ubercab.library.app.UberApplication", false, UberApplication.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mAppBuildConfig = paramLinker.requestBinding("@com.ubercab.library.app.annotation.ForApp()/com.ubercab.library.app.BuildConfigProxy", UberApplication.class, getClass().getClassLoader());
    this.mAppLifecycleTracker = paramLinker.requestBinding("com.ubercab.library.app.LifecycleTracker", UberApplication.class, getClass().getClassLoader());
    this.mAnalyticsClient = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.AnalyticsClient", UberApplication.class, getClass().getClassLoader());
    this.mMapVendor = paramLinker.requestBinding("com.ubercab.library.map.MapVendor", UberApplication.class, getClass().getClassLoader());
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mAppBuildConfig);
    paramSet2.add(this.mAppLifecycleTracker);
    paramSet2.add(this.mAnalyticsClient);
    paramSet2.add(this.mMapVendor);
  }

  public void injectMembers(UberApplication paramUberApplication)
  {
    paramUberApplication.mAppBuildConfig = ((BuildConfigProxy)this.mAppBuildConfig.get());
    paramUberApplication.mAppLifecycleTracker = ((LifecycleTracker)this.mAppLifecycleTracker.get());
    paramUberApplication.mAnalyticsClient = ((AnalyticsClient)this.mAnalyticsClient.get());
    paramUberApplication.mMapVendor = ((MapVendor)this.mMapVendor.get());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.app.UberApplication..InjectAdapter
 * JD-Core Version:    0.6.2
 */