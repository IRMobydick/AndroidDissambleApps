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

public final class VerifyFacebookProfileFragment$$InjectAdapter extends Binding<VerifyFacebookProfileFragment>
  implements Provider<VerifyFacebookProfileFragment>, MembersInjector<VerifyFacebookProfileFragment>
{
  private Binding<ActionBar> mActionBar;
  private Binding<AnalyticsManager> mAnalyticsManager;
  private Binding<Bus> mBus;
  private Binding<SignupClient> mSignupClient;
  private Binding<RiderFragment> supertype;

  public VerifyFacebookProfileFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.signup.VerifyFacebookProfileFragment", "members/com.ubercab.client.feature.signup.VerifyFacebookProfileFragment", false, VerifyFacebookProfileFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mActionBar = paramLinker.requestBinding("android.app.ActionBar", VerifyFacebookProfileFragment.class, getClass().getClassLoader());
    this.mAnalyticsManager = paramLinker.requestBinding("com.ubercab.client.core.analytics.AnalyticsManager", VerifyFacebookProfileFragment.class, getClass().getClassLoader());
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", VerifyFacebookProfileFragment.class, getClass().getClassLoader());
    this.mSignupClient = paramLinker.requestBinding("com.ubercab.client.core.network.SignupClient", VerifyFacebookProfileFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderFragment", VerifyFacebookProfileFragment.class, getClass().getClassLoader(), false, true);
  }

  public VerifyFacebookProfileFragment get()
  {
    VerifyFacebookProfileFragment localVerifyFacebookProfileFragment = new VerifyFacebookProfileFragment();
    injectMembers(localVerifyFacebookProfileFragment);
    return localVerifyFacebookProfileFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mActionBar);
    paramSet2.add(this.mAnalyticsManager);
    paramSet2.add(this.mBus);
    paramSet2.add(this.mSignupClient);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(VerifyFacebookProfileFragment paramVerifyFacebookProfileFragment)
  {
    paramVerifyFacebookProfileFragment.mActionBar = ((ActionBar)this.mActionBar.get());
    paramVerifyFacebookProfileFragment.mAnalyticsManager = ((AnalyticsManager)this.mAnalyticsManager.get());
    paramVerifyFacebookProfileFragment.mBus = ((Bus)this.mBus.get());
    paramVerifyFacebookProfileFragment.mSignupClient = ((SignupClient)this.mSignupClient.get());
    this.supertype.injectMembers(paramVerifyFacebookProfileFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signup.VerifyFacebookProfileFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */