package com.ubercab.client.feature.signup;

import com.ubercab.client.core.network.RiderClient;
import com.ubercab.client.core.network.SignupClient;
import com.ubercab.client.core.vendor.google.GoogleApiActivity;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class SignupGoogleActivity$$InjectAdapter extends Binding<SignupGoogleActivity>
  implements Provider<SignupGoogleActivity>, MembersInjector<SignupGoogleActivity>
{
  private Binding<RiderClient> mRiderClient;
  private Binding<SignupClient> mSignupClient;
  private Binding<GoogleApiActivity> supertype;

  public SignupGoogleActivity$$InjectAdapter()
  {
    super("com.ubercab.client.feature.signup.SignupGoogleActivity", "members/com.ubercab.client.feature.signup.SignupGoogleActivity", false, SignupGoogleActivity.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mRiderClient = paramLinker.requestBinding("com.ubercab.client.core.network.RiderClient", SignupGoogleActivity.class, getClass().getClassLoader());
    this.mSignupClient = paramLinker.requestBinding("com.ubercab.client.core.network.SignupClient", SignupGoogleActivity.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.vendor.google.GoogleApiActivity", SignupGoogleActivity.class, getClass().getClassLoader(), false, true);
  }

  public SignupGoogleActivity get()
  {
    SignupGoogleActivity localSignupGoogleActivity = new SignupGoogleActivity();
    injectMembers(localSignupGoogleActivity);
    return localSignupGoogleActivity;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mRiderClient);
    paramSet2.add(this.mSignupClient);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(SignupGoogleActivity paramSignupGoogleActivity)
  {
    paramSignupGoogleActivity.mRiderClient = ((RiderClient)this.mRiderClient.get());
    paramSignupGoogleActivity.mSignupClient = ((SignupClient)this.mSignupClient.get());
    this.supertype.injectMembers(paramSignupGoogleActivity);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signup.SignupGoogleActivity..InjectAdapter
 * JD-Core Version:    0.6.2
 */