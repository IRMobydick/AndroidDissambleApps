package com.ubercab.client.feature.faresplit.master;

import android.app.ActionBar;
import com.squareup.otto.Bus;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.network.RiderClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class FareSplitInviteFragment$$InjectAdapter extends Binding<FareSplitInviteFragment>
  implements Provider<FareSplitInviteFragment>, MembersInjector<FareSplitInviteFragment>
{
  private Binding<ActionBar> mActionBar;
  private Binding<AnalyticsManager> mAnalyticsManager;
  private Binding<Bus> mBus;
  private Binding<PingProvider> mPingProvider;
  private Binding<RiderClient> mRiderClient;
  private Binding<RiderFragment> supertype;

  public FareSplitInviteFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.faresplit.master.FareSplitInviteFragment", "members/com.ubercab.client.feature.faresplit.master.FareSplitInviteFragment", false, FareSplitInviteFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", FareSplitInviteFragment.class, getClass().getClassLoader());
    this.mRiderClient = paramLinker.requestBinding("com.ubercab.client.core.network.RiderClient", FareSplitInviteFragment.class, getClass().getClassLoader());
    this.mActionBar = paramLinker.requestBinding("android.app.ActionBar", FareSplitInviteFragment.class, getClass().getClassLoader());
    this.mPingProvider = paramLinker.requestBinding("com.ubercab.client.core.content.PingProvider", FareSplitInviteFragment.class, getClass().getClassLoader());
    this.mAnalyticsManager = paramLinker.requestBinding("com.ubercab.client.core.analytics.AnalyticsManager", FareSplitInviteFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderFragment", FareSplitInviteFragment.class, getClass().getClassLoader(), false, true);
  }

  public FareSplitInviteFragment get()
  {
    FareSplitInviteFragment localFareSplitInviteFragment = new FareSplitInviteFragment();
    injectMembers(localFareSplitInviteFragment);
    return localFareSplitInviteFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mBus);
    paramSet2.add(this.mRiderClient);
    paramSet2.add(this.mActionBar);
    paramSet2.add(this.mPingProvider);
    paramSet2.add(this.mAnalyticsManager);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(FareSplitInviteFragment paramFareSplitInviteFragment)
  {
    paramFareSplitInviteFragment.mBus = ((Bus)this.mBus.get());
    paramFareSplitInviteFragment.mRiderClient = ((RiderClient)this.mRiderClient.get());
    paramFareSplitInviteFragment.mActionBar = ((ActionBar)this.mActionBar.get());
    paramFareSplitInviteFragment.mPingProvider = ((PingProvider)this.mPingProvider.get());
    paramFareSplitInviteFragment.mAnalyticsManager = ((AnalyticsManager)this.mAnalyticsManager.get());
    this.supertype.injectMembers(paramFareSplitInviteFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.faresplit.master.FareSplitInviteFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */