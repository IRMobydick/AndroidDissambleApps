package com.ubercab.client.feature.search;

import com.ubercab.client.core.app.RiderPingActivity;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class LocationSearchActivity$$InjectAdapter extends Binding<LocationSearchActivity>
  implements Provider<LocationSearchActivity>, MembersInjector<LocationSearchActivity>
{
  private Binding<AnalyticsClient> mAnalyticsClient;
  private Binding<PingProvider> mPingProvider;
  private Binding<RiderPingActivity> supertype;

  public LocationSearchActivity$$InjectAdapter()
  {
    super("com.ubercab.client.feature.search.LocationSearchActivity", "members/com.ubercab.client.feature.search.LocationSearchActivity", false, LocationSearchActivity.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mAnalyticsClient = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.AnalyticsClient", LocationSearchActivity.class, getClass().getClassLoader());
    this.mPingProvider = paramLinker.requestBinding("com.ubercab.client.core.content.PingProvider", LocationSearchActivity.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderPingActivity", LocationSearchActivity.class, getClass().getClassLoader(), false, true);
  }

  public LocationSearchActivity get()
  {
    LocationSearchActivity localLocationSearchActivity = new LocationSearchActivity();
    injectMembers(localLocationSearchActivity);
    return localLocationSearchActivity;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mAnalyticsClient);
    paramSet2.add(this.mPingProvider);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(LocationSearchActivity paramLocationSearchActivity)
  {
    paramLocationSearchActivity.mAnalyticsClient = ((AnalyticsClient)this.mAnalyticsClient.get());
    paramLocationSearchActivity.mPingProvider = ((PingProvider)this.mPingProvider.get());
    this.supertype.injectMembers(paramLocationSearchActivity);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.search.LocationSearchActivity..InjectAdapter
 * JD-Core Version:    0.6.2
 */