package com.ubercab.client.feature.surge;

import com.squareup.otto.Bus;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class SurgeFragment$$InjectAdapter extends Binding<SurgeFragment>
  implements Provider<SurgeFragment>, MembersInjector<SurgeFragment>
{
  private Binding<AnalyticsClient> mAnalyticsClient;
  private Binding<Bus> mBus;
  private Binding<PingProvider> mPingProvider;
  private Binding<SessionPreferences> mSessionPreferences;
  private Binding<RiderFragment> supertype;

  public SurgeFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.surge.SurgeFragment", "members/com.ubercab.client.feature.surge.SurgeFragment", false, SurgeFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mAnalyticsClient = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.AnalyticsClient", SurgeFragment.class, getClass().getClassLoader());
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", SurgeFragment.class, getClass().getClassLoader());
    this.mSessionPreferences = paramLinker.requestBinding("com.ubercab.client.core.content.SessionPreferences", SurgeFragment.class, getClass().getClassLoader());
    this.mPingProvider = paramLinker.requestBinding("com.ubercab.client.core.content.PingProvider", SurgeFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderFragment", SurgeFragment.class, getClass().getClassLoader(), false, true);
  }

  public SurgeFragment get()
  {
    SurgeFragment localSurgeFragment = new SurgeFragment();
    injectMembers(localSurgeFragment);
    return localSurgeFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mAnalyticsClient);
    paramSet2.add(this.mBus);
    paramSet2.add(this.mSessionPreferences);
    paramSet2.add(this.mPingProvider);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(SurgeFragment paramSurgeFragment)
  {
    paramSurgeFragment.mAnalyticsClient = ((AnalyticsClient)this.mAnalyticsClient.get());
    paramSurgeFragment.mBus = ((Bus)this.mBus.get());
    paramSurgeFragment.mSessionPreferences = ((SessionPreferences)this.mSessionPreferences.get());
    paramSurgeFragment.mPingProvider = ((PingProvider)this.mPingProvider.get());
    this.supertype.injectMembers(paramSurgeFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.surge.SurgeFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */