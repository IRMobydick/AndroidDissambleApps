package com.ubercab.client.feature.signup;

import android.app.ActionBar;
import android.content.Context;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.network.PaymentClient;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class SignupPaymentOtpFragment$$InjectAdapter extends Binding<SignupPaymentOtpFragment>
  implements Provider<SignupPaymentOtpFragment>, MembersInjector<SignupPaymentOtpFragment>
{
  private Binding<ActionBar> mActionBar;
  private Binding<AnalyticsClient> mAnalyticsClient;
  private Binding<Context> mContext;
  private Binding<PaymentClient> mPaymentClient;
  private Binding<RiderClient> mRiderClient;
  private Binding<RiderFragment> supertype;

  public SignupPaymentOtpFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.signup.SignupPaymentOtpFragment", "members/com.ubercab.client.feature.signup.SignupPaymentOtpFragment", false, SignupPaymentOtpFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mActionBar = paramLinker.requestBinding("android.app.ActionBar", SignupPaymentOtpFragment.class, getClass().getClassLoader());
    this.mAnalyticsClient = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.AnalyticsClient", SignupPaymentOtpFragment.class, getClass().getClassLoader());
    this.mContext = paramLinker.requestBinding("android.content.Context", SignupPaymentOtpFragment.class, getClass().getClassLoader());
    this.mPaymentClient = paramLinker.requestBinding("com.ubercab.client.core.network.PaymentClient", SignupPaymentOtpFragment.class, getClass().getClassLoader());
    this.mRiderClient = paramLinker.requestBinding("com.ubercab.client.core.network.RiderClient", SignupPaymentOtpFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderFragment", SignupPaymentOtpFragment.class, getClass().getClassLoader(), false, true);
  }

  public SignupPaymentOtpFragment get()
  {
    SignupPaymentOtpFragment localSignupPaymentOtpFragment = new SignupPaymentOtpFragment();
    injectMembers(localSignupPaymentOtpFragment);
    return localSignupPaymentOtpFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mActionBar);
    paramSet2.add(this.mAnalyticsClient);
    paramSet2.add(this.mContext);
    paramSet2.add(this.mPaymentClient);
    paramSet2.add(this.mRiderClient);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(SignupPaymentOtpFragment paramSignupPaymentOtpFragment)
  {
    paramSignupPaymentOtpFragment.mActionBar = ((ActionBar)this.mActionBar.get());
    paramSignupPaymentOtpFragment.mAnalyticsClient = ((AnalyticsClient)this.mAnalyticsClient.get());
    paramSignupPaymentOtpFragment.mContext = ((Context)this.mContext.get());
    paramSignupPaymentOtpFragment.mPaymentClient = ((PaymentClient)this.mPaymentClient.get());
    paramSignupPaymentOtpFragment.mRiderClient = ((RiderClient)this.mRiderClient.get());
    this.supertype.injectMembers(paramSignupPaymentOtpFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signup.SignupPaymentOtpFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */