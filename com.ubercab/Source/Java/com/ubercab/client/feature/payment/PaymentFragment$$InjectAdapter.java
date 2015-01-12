package com.ubercab.client.feature.payment;

import android.app.ActionBar;
import android.content.Context;
import com.squareup.otto.Bus;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.network.PaymentClient;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class PaymentFragment$$InjectAdapter extends Binding<PaymentFragment>
  implements Provider<PaymentFragment>, MembersInjector<PaymentFragment>
{
  private Binding<ActionBar> mActionBar;
  private Binding<AnalyticsClient> mAnalyticsClient;
  private Binding<AnalyticsManager> mAnalyticsManager;
  private Binding<Bus> mBus;
  private Binding<Context> mContext;
  private Binding<PaymentClient> mPaymentClient;
  private Binding<PingProvider> mPingProvider;
  private Binding<RiderClient> mRiderClient;
  private Binding<RiderFragment> supertype;

  public PaymentFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.payment.PaymentFragment", "members/com.ubercab.client.feature.payment.PaymentFragment", false, PaymentFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mActionBar = paramLinker.requestBinding("android.app.ActionBar", PaymentFragment.class, getClass().getClassLoader());
    this.mAnalyticsClient = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.AnalyticsClient", PaymentFragment.class, getClass().getClassLoader());
    this.mAnalyticsManager = paramLinker.requestBinding("com.ubercab.client.core.analytics.AnalyticsManager", PaymentFragment.class, getClass().getClassLoader());
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", PaymentFragment.class, getClass().getClassLoader());
    this.mContext = paramLinker.requestBinding("@com.ubercab.library.app.annotation.ForActivity()/android.content.Context", PaymentFragment.class, getClass().getClassLoader());
    this.mPaymentClient = paramLinker.requestBinding("com.ubercab.client.core.network.PaymentClient", PaymentFragment.class, getClass().getClassLoader());
    this.mPingProvider = paramLinker.requestBinding("com.ubercab.client.core.content.PingProvider", PaymentFragment.class, getClass().getClassLoader());
    this.mRiderClient = paramLinker.requestBinding("com.ubercab.client.core.network.RiderClient", PaymentFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderFragment", PaymentFragment.class, getClass().getClassLoader(), false, true);
  }

  public PaymentFragment get()
  {
    PaymentFragment localPaymentFragment = new PaymentFragment();
    injectMembers(localPaymentFragment);
    return localPaymentFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mActionBar);
    paramSet2.add(this.mAnalyticsClient);
    paramSet2.add(this.mAnalyticsManager);
    paramSet2.add(this.mBus);
    paramSet2.add(this.mContext);
    paramSet2.add(this.mPaymentClient);
    paramSet2.add(this.mPingProvider);
    paramSet2.add(this.mRiderClient);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(PaymentFragment paramPaymentFragment)
  {
    paramPaymentFragment.mActionBar = ((ActionBar)this.mActionBar.get());
    paramPaymentFragment.mAnalyticsClient = ((AnalyticsClient)this.mAnalyticsClient.get());
    paramPaymentFragment.mAnalyticsManager = ((AnalyticsManager)this.mAnalyticsManager.get());
    paramPaymentFragment.mBus = ((Bus)this.mBus.get());
    paramPaymentFragment.mContext = ((Context)this.mContext.get());
    paramPaymentFragment.mPaymentClient = ((PaymentClient)this.mPaymentClient.get());
    paramPaymentFragment.mPingProvider = ((PingProvider)this.mPingProvider.get());
    paramPaymentFragment.mRiderClient = ((RiderClient)this.mRiderClient.get());
    this.supertype.injectMembers(paramPaymentFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.PaymentFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */