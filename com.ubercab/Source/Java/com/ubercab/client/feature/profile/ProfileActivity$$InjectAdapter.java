package com.ubercab.client.feature.profile;

import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.app.RiderPingActivity;
import com.ubercab.client.core.content.RiderLocationProvider;
import com.ubercab.client.core.network.RiderClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class ProfileActivity$$InjectAdapter extends Binding<ProfileActivity>
  implements Provider<ProfileActivity>, MembersInjector<ProfileActivity>
{
  private Binding<AnalyticsManager> mAnalyticsManager;
  private Binding<RiderLocationProvider> mLocationProvider;
  private Binding<RiderClient> mRiderClient;
  private Binding<RiderPingActivity> supertype;

  public ProfileActivity$$InjectAdapter()
  {
    super("com.ubercab.client.feature.profile.ProfileActivity", "members/com.ubercab.client.feature.profile.ProfileActivity", false, ProfileActivity.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mAnalyticsManager = paramLinker.requestBinding("com.ubercab.client.core.analytics.AnalyticsManager", ProfileActivity.class, getClass().getClassLoader());
    this.mRiderClient = paramLinker.requestBinding("com.ubercab.client.core.network.RiderClient", ProfileActivity.class, getClass().getClassLoader());
    this.mLocationProvider = paramLinker.requestBinding("com.ubercab.client.core.content.RiderLocationProvider", ProfileActivity.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderPingActivity", ProfileActivity.class, getClass().getClassLoader(), false, true);
  }

  public ProfileActivity get()
  {
    ProfileActivity localProfileActivity = new ProfileActivity();
    injectMembers(localProfileActivity);
    return localProfileActivity;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mAnalyticsManager);
    paramSet2.add(this.mRiderClient);
    paramSet2.add(this.mLocationProvider);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(ProfileActivity paramProfileActivity)
  {
    paramProfileActivity.mAnalyticsManager = ((AnalyticsManager)this.mAnalyticsManager.get());
    paramProfileActivity.mRiderClient = ((RiderClient)this.mRiderClient.get());
    paramProfileActivity.mLocationProvider = ((RiderLocationProvider)this.mLocationProvider.get());
    this.supertype.injectMembers(paramProfileActivity);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.profile.ProfileActivity..InjectAdapter
 * JD-Core Version:    0.6.2
 */