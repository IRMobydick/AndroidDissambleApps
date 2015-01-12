package com.ubercab.client.feature.payment;

import com.ubercab.client.feature.payment.expense.ExpenseLinkResources;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

public final class ExpenseAdapter$$InjectAdapter extends Binding<ExpenseAdapter>
  implements MembersInjector<ExpenseAdapter>
{
  private Binding<ExpenseLinkResources> mExpenseLinkResources;

  public ExpenseAdapter$$InjectAdapter()
  {
    super(null, "members/com.ubercab.client.feature.payment.ExpenseAdapter", false, ExpenseAdapter.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mExpenseLinkResources = paramLinker.requestBinding("com.ubercab.client.feature.payment.expense.ExpenseLinkResources", ExpenseAdapter.class, getClass().getClassLoader());
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mExpenseLinkResources);
  }

  public void injectMembers(ExpenseAdapter paramExpenseAdapter)
  {
    paramExpenseAdapter.mExpenseLinkResources = ((ExpenseLinkResources)this.mExpenseLinkResources.get());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.ExpenseAdapter..InjectAdapter
 * JD-Core Version:    0.6.2
 */