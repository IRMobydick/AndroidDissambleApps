package com.ubercab.client.feature.launch;

import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.app.RiderPublicActivity;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.RiderLocationProvider;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.library.app.UberPreferences;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class MagicActivity$$InjectAdapter extends Binding<MagicActivity>
  implements Provider<MagicActivity>, MembersInjector<MagicActivity>
{
  private Binding<AnalyticsClient> mAnalyticsClient;
  private Binding<AnalyticsManager> mAnalyticsManager;
  private Binding<RiderLocationProvider> mLocationProvider;
  private Binding<PingProvider> mPingProvider;
  private Binding<SessionPreferences> mSessionPreferences;
  private Binding<UberPreferences> mUberPreferences;
  private Binding<RiderPublicActivity> supertype;

  public MagicActivity$$InjectAdapter()
  {
    super("com.ubercab.client.feature.launch.MagicActivity", "members/com.ubercab.client.feature.launch.MagicActivity", false, MagicActivity.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mAnalyticsClient = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.AnalyticsClient", MagicActivity.class, getClass().getClassLoader());
    this.mAnalyticsManager = paramLinker.requestBinding("com.ubercab.client.core.analytics.AnalyticsManager", MagicActivity.class, getClass().getClassLoader());
    this.mLocationProvider = paramLinker.requestBinding("com.ubercab.client.core.content.RiderLocationProvider", MagicActivity.class, getClass().getClassLoader());
    this.mPingProvider = paramLinker.requestBinding("com.ubercab.client.core.content.PingProvider", MagicActivity.class, getClass().getClassLoader());
    this.mSessionPreferences = paramLinker.requestBinding("com.ubercab.client.core.content.SessionPreferences", MagicActivity.class, getClass().getClassLoader());
    this.mUberPreferences = paramLinker.requestBinding("com.ubercab.library.app.UberPreferences", MagicActivity.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderPublicActivity", MagicActivity.class, getClass().getClassLoader(), false, true);
  }

  public MagicActivity get()
  {
    MagicActivity localMagicActivity = new MagicActivity();
    injectMembers(localMagicActivity);
    return localMagicActivity;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mAnalyticsClient);
    paramSet2.add(this.mAnalyticsManager);
    paramSet2.add(this.mLocationProvider);
    paramSet2.add(this.mPingProvider);
    paramSet2.add(this.mSessionPreferences);
    paramSet2.add(this.mUberPreferences);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(MagicActivity paramMagicActivity)
  {
    paramMagicActivity.mAnalyticsClient = ((AnalyticsClient)this.mAnalyticsClient.get());
    paramMagicActivity.mAnalyticsManager = ((AnalyticsManager)this.mAnalyticsManager.get());
    paramMagicActivity.mLocationProvider = ((RiderLocationProvider)this.mLocationProvider.get());
    paramMagicActivity.mPingProvider = ((PingProvider)this.mPingProvider.get());
    paramMagicActivity.mSessionPreferences = ((SessionPreferences)this.mSessionPreferences.get());
    paramMagicActivity.mUberPreferences = ((UberPreferences)this.mUberPreferences.get());
    this.supertype.injectMembers(paramMagicActivity);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.launch.MagicActivity..InjectAdapter
 * JD-Core Version:    0.6.2
 */