package com.ubercab.client.feature.payment;

import android.app.ActionBar;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.network.RiderClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class RewardInfoFragment$$InjectAdapter extends Binding<RewardInfoFragment>
  implements Provider<RewardInfoFragment>, MembersInjector<RewardInfoFragment>
{
  private Binding<ActionBar> mActionBar;
  private Binding<RiderClient> mRiderClient;
  private Binding<RiderFragment> supertype;

  public RewardInfoFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.payment.RewardInfoFragment", "members/com.ubercab.client.feature.payment.RewardInfoFragment", false, RewardInfoFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mActionBar = paramLinker.requestBinding("android.app.ActionBar", RewardInfoFragment.class, getClass().getClassLoader());
    this.mRiderClient = paramLinker.requestBinding("com.ubercab.client.core.network.RiderClient", RewardInfoFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderFragment", RewardInfoFragment.class, getClass().getClassLoader(), false, true);
  }

  public RewardInfoFragment get()
  {
    RewardInfoFragment localRewardInfoFragment = new RewardInfoFragment();
    injectMembers(localRewardInfoFragment);
    return localRewardInfoFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mActionBar);
    paramSet2.add(this.mRiderClient);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(RewardInfoFragment paramRewardInfoFragment)
  {
    paramRewardInfoFragment.mActionBar = ((ActionBar)this.mActionBar.get());
    paramRewardInfoFragment.mRiderClient = ((RiderClient)this.mRiderClient.get());
    this.supertype.injectMembers(paramRewardInfoFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.RewardInfoFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */