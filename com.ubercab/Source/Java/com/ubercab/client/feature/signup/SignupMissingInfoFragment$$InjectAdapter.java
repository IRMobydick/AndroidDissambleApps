package com.ubercab.client.feature.signup;

import android.app.ActionBar;
import com.squareup.otto.Bus;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.network.SignupClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class SignupMissingInfoFragment$$InjectAdapter extends Binding<SignupMissingInfoFragment>
  implements Provider<SignupMissingInfoFragment>, MembersInjector<SignupMissingInfoFragment>
{
  private Binding<ActionBar> mActionBar;
  private Binding<AnalyticsManager> mAnalyticsManager;
  private Binding<Bus> mBus;
  private Binding<SignupClient> mSignupClient;
  private Binding<RiderFragment> supertype;

  public SignupMissingInfoFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.signup.SignupMissingInfoFragment", "members/com.ubercab.client.feature.signup.SignupMissingInfoFragment", false, SignupMissingInfoFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", SignupMissingInfoFragment.class, getClass().getClassLoader());
    this.mSignupClient = paramLinker.requestBinding("com.ubercab.client.core.network.SignupClient", SignupMissingInfoFragment.class, getClass().getClassLoader());
    this.mActionBar = paramLinker.requestBinding("android.app.ActionBar", SignupMissingInfoFragment.class, getClass().getClassLoader());
    this.mAnalyticsManager = paramLinker.requestBinding("com.ubercab.client.core.analytics.AnalyticsManager", SignupMissingInfoFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderFragment", SignupMissingInfoFragment.class, getClass().getClassLoader(), false, true);
  }

  public SignupMissingInfoFragment get()
  {
    SignupMissingInfoFragment localSignupMissingInfoFragment = new SignupMissingInfoFragment();
    injectMembers(localSignupMissingInfoFragment);
    return localSignupMissingInfoFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mBus);
    paramSet2.add(this.mSignupClient);
    paramSet2.add(this.mActionBar);
    paramSet2.add(this.mAnalyticsManager);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(SignupMissingInfoFragment paramSignupMissingInfoFragment)
  {
    paramSignupMissingInfoFragment.mBus = ((Bus)this.mBus.get());
    paramSignupMissingInfoFragment.mSignupClient = ((SignupClient)this.mSignupClient.get());
    paramSignupMissingInfoFragment.mActionBar = ((ActionBar)this.mActionBar.get());
    paramSignupMissingInfoFragment.mAnalyticsManager = ((AnalyticsManager)this.mAnalyticsManager.get());
    this.supertype.injectMembers(paramSignupMissingInfoFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signup.SignupMissingInfoFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */