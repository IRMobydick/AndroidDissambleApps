package com.ubercab.client.feature.signin;

import com.ubercab.client.core.app.RiderPublicActivity;
import com.ubercab.client.core.network.RiderClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class SignInActivity$$InjectAdapter extends Binding<SignInActivity>
  implements Provider<SignInActivity>, MembersInjector<SignInActivity>
{
  private Binding<RiderClient> mRiderClient;
  private Binding<RiderPublicActivity> supertype;

  public SignInActivity$$InjectAdapter()
  {
    super("com.ubercab.client.feature.signin.SignInActivity", "members/com.ubercab.client.feature.signin.SignInActivity", false, SignInActivity.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mRiderClient = paramLinker.requestBinding("com.ubercab.client.core.network.RiderClient", SignInActivity.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderPublicActivity", SignInActivity.class, getClass().getClassLoader(), false, true);
  }

  public SignInActivity get()
  {
    SignInActivity localSignInActivity = new SignInActivity();
    injectMembers(localSignInActivity);
    return localSignInActivity;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mRiderClient);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(SignInActivity paramSignInActivity)
  {
    paramSignInActivity.mRiderClient = ((RiderClient)this.mRiderClient.get());
    this.supertype.injectMembers(paramSignInActivity);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signin.SignInActivity..InjectAdapter
 * JD-Core Version:    0.6.2
 */