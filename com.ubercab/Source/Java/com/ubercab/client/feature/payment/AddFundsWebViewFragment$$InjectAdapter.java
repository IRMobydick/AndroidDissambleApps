package com.ubercab.client.feature.payment;

import android.app.ActionBar;
import com.ubercab.client.core.app.RiderFragment;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class AddFundsWebViewFragment$$InjectAdapter extends Binding<AddFundsWebViewFragment>
  implements Provider<AddFundsWebViewFragment>, MembersInjector<AddFundsWebViewFragment>
{
  private Binding<ActionBar> mActionBar;
  private Binding<RiderFragment> supertype;

  public AddFundsWebViewFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.payment.AddFundsWebViewFragment", "members/com.ubercab.client.feature.payment.AddFundsWebViewFragment", false, AddFundsWebViewFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mActionBar = paramLinker.requestBinding("android.app.ActionBar", AddFundsWebViewFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderFragment", AddFundsWebViewFragment.class, getClass().getClassLoader(), false, true);
  }

  public AddFundsWebViewFragment get()
  {
    AddFundsWebViewFragment localAddFundsWebViewFragment = new AddFundsWebViewFragment();
    injectMembers(localAddFundsWebViewFragment);
    return localAddFundsWebViewFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mActionBar);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(AddFundsWebViewFragment paramAddFundsWebViewFragment)
  {
    paramAddFundsWebViewFragment.mActionBar = ((ActionBar)this.mActionBar.get());
    this.supertype.injectMembers(paramAddFundsWebViewFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.AddFundsWebViewFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */