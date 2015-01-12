package com.ubercab.client.feature.payment;

import com.squareup.otto.Bus;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

public final class PaymentFooterView$$InjectAdapter extends Binding<PaymentFooterView>
  implements MembersInjector<PaymentFooterView>
{
  private Binding<AnalyticsClient> mAnalyticsClient;
  private Binding<Bus> mBus;

  public PaymentFooterView$$InjectAdapter()
  {
    super(null, "members/com.ubercab.client.feature.payment.PaymentFooterView", false, PaymentFooterView.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mAnalyticsClient = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.AnalyticsClient", PaymentFooterView.class, getClass().getClassLoader());
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", PaymentFooterView.class, getClass().getClassLoader());
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mAnalyticsClient);
    paramSet2.add(this.mBus);
  }

  public void injectMembers(PaymentFooterView paramPaymentFooterView)
  {
    paramPaymentFooterView.mAnalyticsClient = ((AnalyticsClient)this.mAnalyticsClient.get());
    paramPaymentFooterView.mBus = ((Bus)this.mBus.get());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.PaymentFooterView..InjectAdapter
 * JD-Core Version:    0.6.2
 */