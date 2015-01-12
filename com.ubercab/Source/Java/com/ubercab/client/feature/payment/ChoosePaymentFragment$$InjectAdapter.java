package com.ubercab.client.feature.payment;

import android.app.ActionBar;
import android.content.Context;
import com.squareup.otto.Bus;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.network.RiderClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class ChoosePaymentFragment$$InjectAdapter extends Binding<ChoosePaymentFragment>
  implements Provider<ChoosePaymentFragment>, MembersInjector<ChoosePaymentFragment>
{
  private Binding<ActionBar> mActionBar;
  private Binding<Bus> mBus;
  private Binding<Context> mContext;
  private Binding<RiderClient> mRiderClient;
  private Binding<RiderFragment> supertype;

  public ChoosePaymentFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.payment.ChoosePaymentFragment", "members/com.ubercab.client.feature.payment.ChoosePaymentFragment", false, ChoosePaymentFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mActionBar = paramLinker.requestBinding("android.app.ActionBar", ChoosePaymentFragment.class, getClass().getClassLoader());
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", ChoosePaymentFragment.class, getClass().getClassLoader());
    this.mContext = paramLinker.requestBinding("android.content.Context", ChoosePaymentFragment.class, getClass().getClassLoader());
    this.mRiderClient = paramLinker.requestBinding("com.ubercab.client.core.network.RiderClient", ChoosePaymentFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderFragment", ChoosePaymentFragment.class, getClass().getClassLoader(), false, true);
  }

  public ChoosePaymentFragment get()
  {
    ChoosePaymentFragment localChoosePaymentFragment = new ChoosePaymentFragment();
    injectMembers(localChoosePaymentFragment);
    return localChoosePaymentFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mActionBar);
    paramSet2.add(this.mBus);
    paramSet2.add(this.mContext);
    paramSet2.add(this.mRiderClient);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(ChoosePaymentFragment paramChoosePaymentFragment)
  {
    paramChoosePaymentFragment.mActionBar = ((ActionBar)this.mActionBar.get());
    paramChoosePaymentFragment.mBus = ((Bus)this.mBus.get());
    paramChoosePaymentFragment.mContext = ((Context)this.mContext.get());
    paramChoosePaymentFragment.mRiderClient = ((RiderClient)this.mRiderClient.get());
    this.supertype.injectMembers(paramChoosePaymentFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.ChoosePaymentFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */