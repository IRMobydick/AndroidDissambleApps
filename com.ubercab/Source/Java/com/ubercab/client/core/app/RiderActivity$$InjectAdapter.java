package com.ubercab.client.core.app;

import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.geo.GeoManager;
import com.ubercab.library.app.UberActivity;
import com.ubercab.library.network.dispatch.DispatchClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

public final class RiderActivity$$InjectAdapter extends Binding<RiderActivity>
  implements MembersInjector<RiderActivity>
{
  private Binding<AnalyticsManager> mAnalyticsManager;
  private Binding<DispatchClient> mClient;
  private Binding<GeoManager> mGeoManager;
  private Binding<SessionPreferences> mSessionPreferences;
  private Binding<UberActivity> supertype;

  public RiderActivity$$InjectAdapter()
  {
    super(null, "members/com.ubercab.client.core.app.RiderActivity", false, RiderActivity.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mSessionPreferences = paramLinker.requestBinding("com.ubercab.client.core.content.SessionPreferences", RiderActivity.class, getClass().getClassLoader());
    this.mClient = paramLinker.requestBinding("com.ubercab.library.network.dispatch.DispatchClient", RiderActivity.class, getClass().getClassLoader());
    this.mGeoManager = paramLinker.requestBinding("com.ubercab.geo.GeoManager", RiderActivity.class, getClass().getClassLoader());
    this.mAnalyticsManager = paramLinker.requestBinding("com.ubercab.client.core.analytics.AnalyticsManager", RiderActivity.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.library.app.UberActivity", RiderActivity.class, getClass().getClassLoader(), false, true);
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mSessionPreferences);
    paramSet2.add(this.mClient);
    paramSet2.add(this.mGeoManager);
    paramSet2.add(this.mAnalyticsManager);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(RiderActivity paramRiderActivity)
  {
    paramRiderActivity.mSessionPreferences = ((SessionPreferences)this.mSessionPreferences.get());
    paramRiderActivity.mClient = ((DispatchClient)this.mClient.get());
    paramRiderActivity.mGeoManager = ((GeoManager)this.mGeoManager.get());
    paramRiderActivity.mAnalyticsManager = ((AnalyticsManager)this.mAnalyticsManager.get());
    this.supertype.injectMembers(paramRiderActivity);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.app.RiderActivity..InjectAdapter
 * JD-Core Version:    0.6.2
 */