package com.ubercab.client.feature.signup;

import android.app.ActionBar;
import com.squareup.otto.Bus;
import com.ubercab.client.core.app.RiderFragment;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class SignupPendingFragment$$InjectAdapter extends Binding<SignupPendingFragment>
  implements Provider<SignupPendingFragment>, MembersInjector<SignupPendingFragment>
{
  private Binding<ActionBar> mActionBar;
  private Binding<Bus> mBus;
  private Binding<RiderFragment> supertype;

  public SignupPendingFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.signup.SignupPendingFragment", "members/com.ubercab.client.feature.signup.SignupPendingFragment", false, SignupPendingFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", SignupPendingFragment.class, getClass().getClassLoader());
    this.mActionBar = paramLinker.requestBinding("android.app.ActionBar", SignupPendingFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderFragment", SignupPendingFragment.class, getClass().getClassLoader(), false, true);
  }

  public SignupPendingFragment get()
  {
    SignupPendingFragment localSignupPendingFragment = new SignupPendingFragment();
    injectMembers(localSignupPendingFragment);
    return localSignupPendingFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mBus);
    paramSet2.add(this.mActionBar);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(SignupPendingFragment paramSignupPendingFragment)
  {
    paramSignupPendingFragment.mBus = ((Bus)this.mBus.get());
    paramSignupPendingFragment.mActionBar = ((ActionBar)this.mActionBar.get());
    this.supertype.injectMembers(paramSignupPendingFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signup.SignupPendingFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */