package com.ubercab.client.feature.signup;

import android.app.ActionBar;
import com.squareup.otto.Bus;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.client.core.network.SignupClient;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class SignupChoosePaymentFragment$$InjectAdapter extends Binding<SignupChoosePaymentFragment>
  implements Provider<SignupChoosePaymentFragment>, MembersInjector<SignupChoosePaymentFragment>
{
  private Binding<ActionBar> mActionBar;
  private Binding<AnalyticsClient> mAnalyticsClient;
  private Binding<Bus> mBus;
  private Binding<RiderClient> mRiderClient;
  private Binding<SignupClient> mSignupClient;
  private Binding<RiderFragment> supertype;

  public SignupChoosePaymentFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.signup.SignupChoosePaymentFragment", "members/com.ubercab.client.feature.signup.SignupChoosePaymentFragment", false, SignupChoosePaymentFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mActionBar = paramLinker.requestBinding("android.app.ActionBar", SignupChoosePaymentFragment.class, getClass().getClassLoader());
    this.mAnalyticsClient = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.AnalyticsClient", SignupChoosePaymentFragment.class, getClass().getClassLoader());
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", SignupChoosePaymentFragment.class, getClass().getClassLoader());
    this.mRiderClient = paramLinker.requestBinding("com.ubercab.client.core.network.RiderClient", SignupChoosePaymentFragment.class, getClass().getClassLoader());
    this.mSignupClient = paramLinker.requestBinding("com.ubercab.client.core.network.SignupClient", SignupChoosePaymentFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderFragment", SignupChoosePaymentFragment.class, getClass().getClassLoader(), false, true);
  }

  public SignupChoosePaymentFragment get()
  {
    SignupChoosePaymentFragment localSignupChoosePaymentFragment = new SignupChoosePaymentFragment();
    injectMembers(localSignupChoosePaymentFragment);
    return localSignupChoosePaymentFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mActionBar);
    paramSet2.add(this.mAnalyticsClient);
    paramSet2.add(this.mBus);
    paramSet2.add(this.mRiderClient);
    paramSet2.add(this.mSignupClient);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(SignupChoosePaymentFragment paramSignupChoosePaymentFragment)
  {
    paramSignupChoosePaymentFragment.mActionBar = ((ActionBar)this.mActionBar.get());
    paramSignupChoosePaymentFragment.mAnalyticsClient = ((AnalyticsClient)this.mAnalyticsClient.get());
    paramSignupChoosePaymentFragment.mBus = ((Bus)this.mBus.get());
    paramSignupChoosePaymentFragment.mRiderClient = ((RiderClient)this.mRiderClient.get());
    paramSignupChoosePaymentFragment.mSignupClient = ((SignupClient)this.mSignupClient.get());
    this.supertype.injectMembers(paramSignupChoosePaymentFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signup.SignupChoosePaymentFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */