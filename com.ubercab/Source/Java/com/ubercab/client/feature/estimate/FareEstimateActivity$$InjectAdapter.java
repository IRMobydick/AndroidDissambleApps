package com.ubercab.client.feature.estimate;

import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.app.RiderPingActivity;
import com.ubercab.client.core.content.RiderLocationProvider;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class FareEstimateActivity$$InjectAdapter extends Binding<FareEstimateActivity>
  implements Provider<FareEstimateActivity>, MembersInjector<FareEstimateActivity>
{
  private Binding<AnalyticsManager> mAnalyticsManager;
  private Binding<RiderLocationProvider> mLocationProvider;
  private Binding<RiderPingActivity> supertype;

  public FareEstimateActivity$$InjectAdapter()
  {
    super("com.ubercab.client.feature.estimate.FareEstimateActivity", "members/com.ubercab.client.feature.estimate.FareEstimateActivity", false, FareEstimateActivity.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mAnalyticsManager = paramLinker.requestBinding("com.ubercab.client.core.analytics.AnalyticsManager", FareEstimateActivity.class, getClass().getClassLoader());
    this.mLocationProvider = paramLinker.requestBinding("com.ubercab.client.core.content.RiderLocationProvider", FareEstimateActivity.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderPingActivity", FareEstimateActivity.class, getClass().getClassLoader(), false, true);
  }

  public FareEstimateActivity get()
  {
    FareEstimateActivity localFareEstimateActivity = new FareEstimateActivity();
    injectMembers(localFareEstimateActivity);
    return localFareEstimateActivity;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mAnalyticsManager);
    paramSet2.add(this.mLocationProvider);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(FareEstimateActivity paramFareEstimateActivity)
  {
    paramFareEstimateActivity.mAnalyticsManager = ((AnalyticsManager)this.mAnalyticsManager.get());
    paramFareEstimateActivity.mLocationProvider = ((RiderLocationProvider)this.mLocationProvider.get());
    this.supertype.injectMembers(paramFareEstimateActivity);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.estimate.FareEstimateActivity..InjectAdapter
 * JD-Core Version:    0.6.2
 */