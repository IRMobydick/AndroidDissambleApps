package com.ubercab.client.feature.launch;

import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.app.RiderPreferences;
import com.ubercab.client.core.app.RiderPublicActivity;
import com.ubercab.client.core.content.RiderLocationProvider;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.geo.GeoManager;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class LauncherActivity$$InjectAdapter extends Binding<LauncherActivity>
  implements Provider<LauncherActivity>, MembersInjector<LauncherActivity>
{
  private Binding<AnalyticsManager> mAnalyticsManager;
  private Binding<GeoManager> mGeoManager;
  private Binding<RiderLocationProvider> mLocationProvider;
  private Binding<RiderPreferences> mRiderPreferences;
  private Binding<SessionPreferences> mSessionPreferences;
  private Binding<RiderPublicActivity> supertype;

  public LauncherActivity$$InjectAdapter()
  {
    super("com.ubercab.client.feature.launch.LauncherActivity", "members/com.ubercab.client.feature.launch.LauncherActivity", false, LauncherActivity.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mSessionPreferences = paramLinker.requestBinding("com.ubercab.client.core.content.SessionPreferences", LauncherActivity.class, getClass().getClassLoader());
    this.mAnalyticsManager = paramLinker.requestBinding("com.ubercab.client.core.analytics.AnalyticsManager", LauncherActivity.class, getClass().getClassLoader());
    this.mLocationProvider = paramLinker.requestBinding("com.ubercab.client.core.content.RiderLocationProvider", LauncherActivity.class, getClass().getClassLoader());
    this.mRiderPreferences = paramLinker.requestBinding("com.ubercab.client.core.app.RiderPreferences", LauncherActivity.class, getClass().getClassLoader());
    this.mGeoManager = paramLinker.requestBinding("com.ubercab.geo.GeoManager", LauncherActivity.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderPublicActivity", LauncherActivity.class, getClass().getClassLoader(), false, true);
  }

  public LauncherActivity get()
  {
    LauncherActivity localLauncherActivity = new LauncherActivity();
    injectMembers(localLauncherActivity);
    return localLauncherActivity;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mSessionPreferences);
    paramSet2.add(this.mAnalyticsManager);
    paramSet2.add(this.mLocationProvider);
    paramSet2.add(this.mRiderPreferences);
    paramSet2.add(this.mGeoManager);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(LauncherActivity paramLauncherActivity)
  {
    paramLauncherActivity.mSessionPreferences = ((SessionPreferences)this.mSessionPreferences.get());
    paramLauncherActivity.mAnalyticsManager = ((AnalyticsManager)this.mAnalyticsManager.get());
    paramLauncherActivity.mLocationProvider = ((RiderLocationProvider)this.mLocationProvider.get());
    paramLauncherActivity.mRiderPreferences = ((RiderPreferences)this.mRiderPreferences.get());
    paramLauncherActivity.mGeoManager = ((GeoManager)this.mGeoManager.get());
    this.supertype.injectMembers(paramLauncherActivity);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.launch.LauncherActivity..InjectAdapter
 * JD-Core Version:    0.6.2
 */