package com.ubercab.client.feature.surge;

import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.app.RiderPingActivity;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.RiderLocationProvider;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class SurgeActivity$$InjectAdapter extends Binding<SurgeActivity>
  implements Provider<SurgeActivity>, MembersInjector<SurgeActivity>
{
  private Binding<AnalyticsClient> mAnalyticsClient;
  private Binding<AnalyticsManager> mAnalyticsManager;
  private Binding<RiderLocationProvider> mLocationProvider;
  private Binding<PingProvider> mPingProvider;
  private Binding<RiderClient> mRiderClient;
  private Binding<RiderPingActivity> supertype;

  public SurgeActivity$$InjectAdapter()
  {
    super("com.ubercab.client.feature.surge.SurgeActivity", "members/com.ubercab.client.feature.surge.SurgeActivity", false, SurgeActivity.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mAnalyticsClient = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.AnalyticsClient", SurgeActivity.class, getClass().getClassLoader());
    this.mRiderClient = paramLinker.requestBinding("com.ubercab.client.core.network.RiderClient", SurgeActivity.class, getClass().getClassLoader());
    this.mPingProvider = paramLinker.requestBinding("com.ubercab.client.core.content.PingProvider", SurgeActivity.class, getClass().getClassLoader());
    this.mAnalyticsManager = paramLinker.requestBinding("com.ubercab.client.core.analytics.AnalyticsManager", SurgeActivity.class, getClass().getClassLoader());
    this.mLocationProvider = paramLinker.requestBinding("com.ubercab.client.core.content.RiderLocationProvider", SurgeActivity.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderPingActivity", SurgeActivity.class, getClass().getClassLoader(), false, true);
  }

  public SurgeActivity get()
  {
    SurgeActivity localSurgeActivity = new SurgeActivity();
    injectMembers(localSurgeActivity);
    return localSurgeActivity;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mAnalyticsClient);
    paramSet2.add(this.mRiderClient);
    paramSet2.add(this.mPingProvider);
    paramSet2.add(this.mAnalyticsManager);
    paramSet2.add(this.mLocationProvider);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(SurgeActivity paramSurgeActivity)
  {
    paramSurgeActivity.mAnalyticsClient = ((AnalyticsClient)this.mAnalyticsClient.get());
    paramSurgeActivity.mRiderClient = ((RiderClient)this.mRiderClient.get());
    paramSurgeActivity.mPingProvider = ((PingProvider)this.mPingProvider.get());
    paramSurgeActivity.mAnalyticsManager = ((AnalyticsManager)this.mAnalyticsManager.get());
    paramSurgeActivity.mLocationProvider = ((RiderLocationProvider)this.mLocationProvider.get());
    this.supertype.injectMembers(paramSurgeActivity);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.surge.SurgeActivity..InjectAdapter
 * JD-Core Version:    0.6.2
 */