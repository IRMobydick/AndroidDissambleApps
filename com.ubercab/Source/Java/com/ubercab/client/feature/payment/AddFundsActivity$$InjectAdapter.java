package com.ubercab.client.feature.payment;

import com.ubercab.library.metrics.analytics.AnalyticsClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class AddFundsActivity$$InjectAdapter extends Binding<AddFundsActivity>
  implements Provider<AddFundsActivity>, MembersInjector<AddFundsActivity>
{
  private Binding<AnalyticsClient> mAnalyticsClient;
  private Binding<PaymentBaseActivity> supertype;

  public AddFundsActivity$$InjectAdapter()
  {
    super("com.ubercab.client.feature.payment.AddFundsActivity", "members/com.ubercab.client.feature.payment.AddFundsActivity", false, AddFundsActivity.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mAnalyticsClient = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.AnalyticsClient", AddFundsActivity.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.feature.payment.PaymentBaseActivity", AddFundsActivity.class, getClass().getClassLoader(), false, true);
  }

  public AddFundsActivity get()
  {
    AddFundsActivity localAddFundsActivity = new AddFundsActivity();
    injectMembers(localAddFundsActivity);
    return localAddFundsActivity;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mAnalyticsClient);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(AddFundsActivity paramAddFundsActivity)
  {
    paramAddFundsActivity.mAnalyticsClient = ((AnalyticsClient)this.mAnalyticsClient.get());
    this.supertype.injectMembers(paramAddFundsActivity);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.AddFundsActivity..InjectAdapter
 * JD-Core Version:    0.6.2
 */