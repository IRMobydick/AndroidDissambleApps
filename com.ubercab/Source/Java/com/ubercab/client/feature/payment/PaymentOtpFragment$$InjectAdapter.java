package com.ubercab.client.feature.payment;

import android.app.ActionBar;
import com.squareup.otto.Bus;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.network.PaymentClient;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class PaymentOtpFragment$$InjectAdapter extends Binding<PaymentOtpFragment>
  implements Provider<PaymentOtpFragment>, MembersInjector<PaymentOtpFragment>
{
  private Binding<ActionBar> mActionBar;
  private Binding<AnalyticsClient> mAnalyticsClient;
  private Binding<Bus> mBus;
  private Binding<PaymentClient> mPaymentClient;
  private Binding<RiderClient> mRiderClient;
  private Binding<RiderFragment> supertype;

  public PaymentOtpFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.payment.PaymentOtpFragment", "members/com.ubercab.client.feature.payment.PaymentOtpFragment", false, PaymentOtpFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mActionBar = paramLinker.requestBinding("android.app.ActionBar", PaymentOtpFragment.class, getClass().getClassLoader());
    this.mAnalyticsClient = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.AnalyticsClient", PaymentOtpFragment.class, getClass().getClassLoader());
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", PaymentOtpFragment.class, getClass().getClassLoader());
    this.mPaymentClient = paramLinker.requestBinding("com.ubercab.client.core.network.PaymentClient", PaymentOtpFragment.class, getClass().getClassLoader());
    this.mRiderClient = paramLinker.requestBinding("com.ubercab.client.core.network.RiderClient", PaymentOtpFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderFragment", PaymentOtpFragment.class, getClass().getClassLoader(), false, true);
  }

  public PaymentOtpFragment get()
  {
    PaymentOtpFragment localPaymentOtpFragment = new PaymentOtpFragment();
    injectMembers(localPaymentOtpFragment);
    return localPaymentOtpFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mActionBar);
    paramSet2.add(this.mAnalyticsClient);
    paramSet2.add(this.mBus);
    paramSet2.add(this.mPaymentClient);
    paramSet2.add(this.mRiderClient);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(PaymentOtpFragment paramPaymentOtpFragment)
  {
    paramPaymentOtpFragment.mActionBar = ((ActionBar)this.mActionBar.get());
    paramPaymentOtpFragment.mAnalyticsClient = ((AnalyticsClient)this.mAnalyticsClient.get());
    paramPaymentOtpFragment.mBus = ((Bus)this.mBus.get());
    paramPaymentOtpFragment.mPaymentClient = ((PaymentClient)this.mPaymentClient.get());
    paramPaymentOtpFragment.mRiderClient = ((RiderClient)this.mRiderClient.get());
    this.supertype.injectMembers(paramPaymentOtpFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.PaymentOtpFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */