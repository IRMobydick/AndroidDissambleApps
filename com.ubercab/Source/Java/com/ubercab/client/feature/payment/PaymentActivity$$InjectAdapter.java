package com.ubercab.client.feature.payment;

import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class PaymentActivity$$InjectAdapter extends Binding<PaymentActivity>
  implements Provider<PaymentActivity>, MembersInjector<PaymentActivity>
{
  private Binding<AnalyticsClient> mAnalyticsClient;
  private Binding<AnalyticsManager> mAnalyticsManager;
  private Binding<PayPalConfiguration> mPayPalConfiguration;
  private Binding<RiderClient> mRiderClient;
  private Binding<PaymentBaseActivity> supertype;

  public PaymentActivity$$InjectAdapter()
  {
    super("com.ubercab.client.feature.payment.PaymentActivity", "members/com.ubercab.client.feature.payment.PaymentActivity", false, PaymentActivity.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mAnalyticsClient = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.AnalyticsClient", PaymentActivity.class, getClass().getClassLoader());
    this.mAnalyticsManager = paramLinker.requestBinding("com.ubercab.client.core.analytics.AnalyticsManager", PaymentActivity.class, getClass().getClassLoader());
    this.mRiderClient = paramLinker.requestBinding("com.ubercab.client.core.network.RiderClient", PaymentActivity.class, getClass().getClassLoader());
    this.mPayPalConfiguration = paramLinker.requestBinding("com.paypal.android.sdk.payments.PayPalConfiguration", PaymentActivity.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.feature.payment.PaymentBaseActivity", PaymentActivity.class, getClass().getClassLoader(), false, true);
  }

  public PaymentActivity get()
  {
    PaymentActivity localPaymentActivity = new PaymentActivity();
    injectMembers(localPaymentActivity);
    return localPaymentActivity;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mAnalyticsClient);
    paramSet2.add(this.mAnalyticsManager);
    paramSet2.add(this.mRiderClient);
    paramSet2.add(this.mPayPalConfiguration);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(PaymentActivity paramPaymentActivity)
  {
    paramPaymentActivity.mAnalyticsClient = ((AnalyticsClient)this.mAnalyticsClient.get());
    paramPaymentActivity.mAnalyticsManager = ((AnalyticsManager)this.mAnalyticsManager.get());
    paramPaymentActivity.mRiderClient = ((RiderClient)this.mRiderClient.get());
    paramPaymentActivity.mPayPalConfiguration = ((PayPalConfiguration)this.mPayPalConfiguration.get());
    this.supertype.injectMembers(paramPaymentActivity);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.PaymentActivity..InjectAdapter
 * JD-Core Version:    0.6.2
 */