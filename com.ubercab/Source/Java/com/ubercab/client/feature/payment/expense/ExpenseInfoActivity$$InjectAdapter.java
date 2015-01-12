package com.ubercab.client.feature.payment.expense;

import com.ubercab.client.core.app.RiderPingActivity;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class ExpenseInfoActivity$$InjectAdapter extends Binding<ExpenseInfoActivity>
  implements Provider<ExpenseInfoActivity>, MembersInjector<ExpenseInfoActivity>
{
  private Binding<AnalyticsClient> mAnalyticsClient;
  private Binding<RiderPingActivity> supertype;

  public ExpenseInfoActivity$$InjectAdapter()
  {
    super("com.ubercab.client.feature.payment.expense.ExpenseInfoActivity", "members/com.ubercab.client.feature.payment.expense.ExpenseInfoActivity", false, ExpenseInfoActivity.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mAnalyticsClient = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.AnalyticsClient", ExpenseInfoActivity.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderPingActivity", ExpenseInfoActivity.class, getClass().getClassLoader(), false, true);
  }

  public ExpenseInfoActivity get()
  {
    ExpenseInfoActivity localExpenseInfoActivity = new ExpenseInfoActivity();
    injectMembers(localExpenseInfoActivity);
    return localExpenseInfoActivity;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mAnalyticsClient);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(ExpenseInfoActivity paramExpenseInfoActivity)
  {
    paramExpenseInfoActivity.mAnalyticsClient = ((AnalyticsClient)this.mAnalyticsClient.get());
    this.supertype.injectMembers(paramExpenseInfoActivity);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.expense.ExpenseInfoActivity..InjectAdapter
 * JD-Core Version:    0.6.2
 */