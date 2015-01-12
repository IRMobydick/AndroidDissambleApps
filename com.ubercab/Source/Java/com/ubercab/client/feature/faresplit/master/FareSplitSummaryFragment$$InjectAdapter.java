package com.ubercab.client.feature.faresplit.master;

import com.squareup.otto.Bus;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.app.RiderDialogFragment;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class FareSplitSummaryFragment$$InjectAdapter extends Binding<FareSplitSummaryFragment>
  implements Provider<FareSplitSummaryFragment>, MembersInjector<FareSplitSummaryFragment>
{
  private Binding<AnalyticsClient> mAnalyticsClient;
  private Binding<AnalyticsManager> mAnalyticsManager;
  private Binding<Bus> mBus;
  private Binding<PingProvider> mPingProvider;
  private Binding<RiderClient> mRiderClient;
  private Binding<RiderDialogFragment> supertype;

  public FareSplitSummaryFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.faresplit.master.FareSplitSummaryFragment", "members/com.ubercab.client.feature.faresplit.master.FareSplitSummaryFragment", false, FareSplitSummaryFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mAnalyticsClient = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.AnalyticsClient", FareSplitSummaryFragment.class, getClass().getClassLoader());
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", FareSplitSummaryFragment.class, getClass().getClassLoader());
    this.mRiderClient = paramLinker.requestBinding("com.ubercab.client.core.network.RiderClient", FareSplitSummaryFragment.class, getClass().getClassLoader());
    this.mPingProvider = paramLinker.requestBinding("com.ubercab.client.core.content.PingProvider", FareSplitSummaryFragment.class, getClass().getClassLoader());
    this.mAnalyticsManager = paramLinker.requestBinding("com.ubercab.client.core.analytics.AnalyticsManager", FareSplitSummaryFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderDialogFragment", FareSplitSummaryFragment.class, getClass().getClassLoader(), false, true);
  }

  public FareSplitSummaryFragment get()
  {
    FareSplitSummaryFragment localFareSplitSummaryFragment = new FareSplitSummaryFragment();
    injectMembers(localFareSplitSummaryFragment);
    return localFareSplitSummaryFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mAnalyticsClient);
    paramSet2.add(this.mBus);
    paramSet2.add(this.mRiderClient);
    paramSet2.add(this.mPingProvider);
    paramSet2.add(this.mAnalyticsManager);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(FareSplitSummaryFragment paramFareSplitSummaryFragment)
  {
    paramFareSplitSummaryFragment.mAnalyticsClient = ((AnalyticsClient)this.mAnalyticsClient.get());
    paramFareSplitSummaryFragment.mBus = ((Bus)this.mBus.get());
    paramFareSplitSummaryFragment.mRiderClient = ((RiderClient)this.mRiderClient.get());
    paramFareSplitSummaryFragment.mPingProvider = ((PingProvider)this.mPingProvider.get());
    paramFareSplitSummaryFragment.mAnalyticsManager = ((AnalyticsManager)this.mAnalyticsManager.get());
    this.supertype.injectMembers(paramFareSplitSummaryFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.faresplit.master.FareSplitSummaryFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */