package com.ubercab.client.feature.signup;

import com.ubercab.client.core.app.RiderDialogFragment;
import com.ubercab.client.core.network.RiderClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class SignupPromoFragment$$InjectAdapter extends Binding<SignupPromoFragment>
  implements Provider<SignupPromoFragment>, MembersInjector<SignupPromoFragment>
{
  private Binding<RiderClient> mRiderClient;
  private Binding<RiderDialogFragment> supertype;

  public SignupPromoFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.signup.SignupPromoFragment", "members/com.ubercab.client.feature.signup.SignupPromoFragment", false, SignupPromoFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mRiderClient = paramLinker.requestBinding("com.ubercab.client.core.network.RiderClient", SignupPromoFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderDialogFragment", SignupPromoFragment.class, getClass().getClassLoader(), false, true);
  }

  public SignupPromoFragment get()
  {
    SignupPromoFragment localSignupPromoFragment = new SignupPromoFragment();
    injectMembers(localSignupPromoFragment);
    return localSignupPromoFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mRiderClient);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(SignupPromoFragment paramSignupPromoFragment)
  {
    paramSignupPromoFragment.mRiderClient = ((RiderClient)this.mRiderClient.get());
    this.supertype.injectMembers(paramSignupPromoFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signup.SignupPromoFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */