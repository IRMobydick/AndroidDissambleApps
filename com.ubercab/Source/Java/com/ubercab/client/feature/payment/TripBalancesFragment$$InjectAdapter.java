package com.ubercab.client.feature.payment;

import android.app.ActionBar;
import com.ubercab.client.core.app.RiderFragment;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class TripBalancesFragment$$InjectAdapter extends Binding<TripBalancesFragment>
  implements Provider<TripBalancesFragment>, MembersInjector<TripBalancesFragment>
{
  private Binding<ActionBar> mActionBar;
  private Binding<RiderFragment> supertype;

  public TripBalancesFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.payment.TripBalancesFragment", "members/com.ubercab.client.feature.payment.TripBalancesFragment", false, TripBalancesFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mActionBar = paramLinker.requestBinding("android.app.ActionBar", TripBalancesFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderFragment", TripBalancesFragment.class, getClass().getClassLoader(), false, true);
  }

  public TripBalancesFragment get()
  {
    TripBalancesFragment localTripBalancesFragment = new TripBalancesFragment();
    injectMembers(localTripBalancesFragment);
    return localTripBalancesFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mActionBar);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(TripBalancesFragment paramTripBalancesFragment)
  {
    paramTripBalancesFragment.mActionBar = ((ActionBar)this.mActionBar.get());
    this.supertype.injectMembers(paramTripBalancesFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.TripBalancesFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */