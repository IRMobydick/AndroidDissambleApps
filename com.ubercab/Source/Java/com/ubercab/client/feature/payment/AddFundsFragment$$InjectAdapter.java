package com.ubercab.client.feature.payment;

import android.content.Context;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.network.PaymentClient;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class AddFundsFragment$$InjectAdapter extends Binding<AddFundsFragment>
  implements Provider<AddFundsFragment>, MembersInjector<AddFundsFragment>
{
  private Binding<AnalyticsClient> mAnalyticsClient;
  private Binding<Context> mContext;
  private Binding<PaymentClient> mPaymentClient;
  private Binding<RiderFragment> supertype;

  public AddFundsFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.payment.AddFundsFragment", "members/com.ubercab.client.feature.payment.AddFundsFragment", false, AddFundsFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mAnalyticsClient = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.AnalyticsClient", AddFundsFragment.class, getClass().getClassLoader());
    this.mContext = paramLinker.requestBinding("android.content.Context", AddFundsFragment.class, getClass().getClassLoader());
    this.mPaymentClient = paramLinker.requestBinding("com.ubercab.client.core.network.PaymentClient", AddFundsFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderFragment", AddFundsFragment.class, getClass().getClassLoader(), false, true);
  }

  public AddFundsFragment get()
  {
    AddFundsFragment localAddFundsFragment = new AddFundsFragment();
    injectMembers(localAddFundsFragment);
    return localAddFundsFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mAnalyticsClient);
    paramSet2.add(this.mContext);
    paramSet2.add(this.mPaymentClient);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(AddFundsFragment paramAddFundsFragment)
  {
    paramAddFundsFragment.mAnalyticsClient = ((AnalyticsClient)this.mAnalyticsClient.get());
    paramAddFundsFragment.mContext = ((Context)this.mContext.get());
    paramAddFundsFragment.mPaymentClient = ((PaymentClient)this.mPaymentClient.get());
    this.supertype.injectMembers(paramAddFundsFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.AddFundsFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */