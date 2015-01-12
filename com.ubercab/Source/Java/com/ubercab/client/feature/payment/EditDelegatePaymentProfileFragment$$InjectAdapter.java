package com.ubercab.client.feature.payment;

import android.app.ActionBar;
import com.squareup.otto.Bus;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.content.PingProvider;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class EditDelegatePaymentProfileFragment$$InjectAdapter extends Binding<EditDelegatePaymentProfileFragment>
  implements Provider<EditDelegatePaymentProfileFragment>, MembersInjector<EditDelegatePaymentProfileFragment>
{
  private Binding<ActionBar> mActionBar;
  private Binding<Bus> mBus;
  private Binding<PingProvider> mPingProvider;
  private Binding<RiderFragment> supertype;

  public EditDelegatePaymentProfileFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.payment.EditDelegatePaymentProfileFragment", "members/com.ubercab.client.feature.payment.EditDelegatePaymentProfileFragment", false, EditDelegatePaymentProfileFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", EditDelegatePaymentProfileFragment.class, getClass().getClassLoader());
    this.mActionBar = paramLinker.requestBinding("android.app.ActionBar", EditDelegatePaymentProfileFragment.class, getClass().getClassLoader());
    this.mPingProvider = paramLinker.requestBinding("com.ubercab.client.core.content.PingProvider", EditDelegatePaymentProfileFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderFragment", EditDelegatePaymentProfileFragment.class, getClass().getClassLoader(), false, true);
  }

  public EditDelegatePaymentProfileFragment get()
  {
    EditDelegatePaymentProfileFragment localEditDelegatePaymentProfileFragment = new EditDelegatePaymentProfileFragment();
    injectMembers(localEditDelegatePaymentProfileFragment);
    return localEditDelegatePaymentProfileFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mBus);
    paramSet2.add(this.mActionBar);
    paramSet2.add(this.mPingProvider);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(EditDelegatePaymentProfileFragment paramEditDelegatePaymentProfileFragment)
  {
    paramEditDelegatePaymentProfileFragment.mBus = ((Bus)this.mBus.get());
    paramEditDelegatePaymentProfileFragment.mActionBar = ((ActionBar)this.mActionBar.get());
    paramEditDelegatePaymentProfileFragment.mPingProvider = ((PingProvider)this.mPingProvider.get());
    this.supertype.injectMembers(paramEditDelegatePaymentProfileFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.EditDelegatePaymentProfileFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */