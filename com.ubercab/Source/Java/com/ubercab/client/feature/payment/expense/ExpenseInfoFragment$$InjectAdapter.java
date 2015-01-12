package com.ubercab.client.feature.payment.expense;

import android.app.ActionBar;
import com.squareup.otto.Bus;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.content.PingProvider;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class ExpenseInfoFragment$$InjectAdapter extends Binding<ExpenseInfoFragment>
  implements Provider<ExpenseInfoFragment>, MembersInjector<ExpenseInfoFragment>
{
  private Binding<ActionBar> mActionBar;
  private Binding<Bus> mBus;
  private Binding<PingProvider> mPingProvider;
  private Binding<RiderFragment> supertype;

  public ExpenseInfoFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.payment.expense.ExpenseInfoFragment", "members/com.ubercab.client.feature.payment.expense.ExpenseInfoFragment", false, ExpenseInfoFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mActionBar = paramLinker.requestBinding("android.app.ActionBar", ExpenseInfoFragment.class, getClass().getClassLoader());
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", ExpenseInfoFragment.class, getClass().getClassLoader());
    this.mPingProvider = paramLinker.requestBinding("com.ubercab.client.core.content.PingProvider", ExpenseInfoFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderFragment", ExpenseInfoFragment.class, getClass().getClassLoader(), false, true);
  }

  public ExpenseInfoFragment get()
  {
    ExpenseInfoFragment localExpenseInfoFragment = new ExpenseInfoFragment();
    injectMembers(localExpenseInfoFragment);
    return localExpenseInfoFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mActionBar);
    paramSet2.add(this.mBus);
    paramSet2.add(this.mPingProvider);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(ExpenseInfoFragment paramExpenseInfoFragment)
  {
    paramExpenseInfoFragment.mActionBar = ((ActionBar)this.mActionBar.get());
    paramExpenseInfoFragment.mBus = ((Bus)this.mBus.get());
    paramExpenseInfoFragment.mPingProvider = ((PingProvider)this.mPingProvider.get());
    this.supertype.injectMembers(paramExpenseInfoFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.expense.ExpenseInfoFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */