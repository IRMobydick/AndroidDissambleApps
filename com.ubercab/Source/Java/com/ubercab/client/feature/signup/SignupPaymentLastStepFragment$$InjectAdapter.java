package com.ubercab.client.feature.signup;

import android.app.ActionBar;
import android.content.Context;
import com.squareup.otto.Bus;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class SignupPaymentLastStepFragment$$InjectAdapter extends Binding<SignupPaymentLastStepFragment>
  implements Provider<SignupPaymentLastStepFragment>, MembersInjector<SignupPaymentLastStepFragment>
{
  private Binding<ActionBar> mActionBar;
  private Binding<AnalyticsClient> mAnalyticsClient;
  private Binding<Bus> mBus;
  private Binding<Context> mContext;
  private Binding<RiderFragment> supertype;

  public SignupPaymentLastStepFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.signup.SignupPaymentLastStepFragment", "members/com.ubercab.client.feature.signup.SignupPaymentLastStepFragment", false, SignupPaymentLastStepFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mActionBar = paramLinker.requestBinding("android.app.ActionBar", SignupPaymentLastStepFragment.class, getClass().getClassLoader());
    this.mAnalyticsClient = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.AnalyticsClient", SignupPaymentLastStepFragment.class, getClass().getClassLoader());
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", SignupPaymentLastStepFragment.class, getClass().getClassLoader());
    this.mContext = paramLinker.requestBinding("android.content.Context", SignupPaymentLastStepFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderFragment", SignupPaymentLastStepFragment.class, getClass().getClassLoader(), false, true);
  }

  public SignupPaymentLastStepFragment get()
  {
    SignupPaymentLastStepFragment localSignupPaymentLastStepFragment = new SignupPaymentLastStepFragment();
    injectMembers(localSignupPaymentLastStepFragment);
    return localSignupPaymentLastStepFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mActionBar);
    paramSet2.add(this.mAnalyticsClient);
    paramSet2.add(this.mBus);
    paramSet2.add(this.mContext);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(SignupPaymentLastStepFragment paramSignupPaymentLastStepFragment)
  {
    paramSignupPaymentLastStepFragment.mActionBar = ((ActionBar)this.mActionBar.get());
    paramSignupPaymentLastStepFragment.mAnalyticsClient = ((AnalyticsClient)this.mAnalyticsClient.get());
    paramSignupPaymentLastStepFragment.mBus = ((Bus)this.mBus.get());
    paramSignupPaymentLastStepFragment.mContext = ((Context)this.mContext.get());
    this.supertype.injectMembers(paramSignupPaymentLastStepFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signup.SignupPaymentLastStepFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */