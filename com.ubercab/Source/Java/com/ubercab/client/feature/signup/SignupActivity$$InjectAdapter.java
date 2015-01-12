package com.ubercab.client.feature.signup;

import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.ubercab.client.core.app.RiderPublicActivity;
import com.ubercab.client.core.network.AppConfigClient;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.geo.GeoManager;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class SignupActivity$$InjectAdapter extends Binding<SignupActivity>
  implements Provider<SignupActivity>, MembersInjector<SignupActivity>
{
  private Binding<AppConfigClient> mAppConfigClient;
  private Binding<GeoManager> mGeoManager;
  private Binding<PayPalConfiguration> mPayPalConfiguration;
  private Binding<RiderClient> mRiderClient;
  private Binding<RiderPublicActivity> supertype;

  public SignupActivity$$InjectAdapter()
  {
    super("com.ubercab.client.feature.signup.SignupActivity", "members/com.ubercab.client.feature.signup.SignupActivity", false, SignupActivity.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mAppConfigClient = paramLinker.requestBinding("com.ubercab.client.core.network.AppConfigClient", SignupActivity.class, getClass().getClassLoader());
    this.mGeoManager = paramLinker.requestBinding("com.ubercab.geo.GeoManager", SignupActivity.class, getClass().getClassLoader());
    this.mPayPalConfiguration = paramLinker.requestBinding("com.paypal.android.sdk.payments.PayPalConfiguration", SignupActivity.class, getClass().getClassLoader());
    this.mRiderClient = paramLinker.requestBinding("com.ubercab.client.core.network.RiderClient", SignupActivity.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderPublicActivity", SignupActivity.class, getClass().getClassLoader(), false, true);
  }

  public SignupActivity get()
  {
    SignupActivity localSignupActivity = new SignupActivity();
    injectMembers(localSignupActivity);
    return localSignupActivity;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mAppConfigClient);
    paramSet2.add(this.mGeoManager);
    paramSet2.add(this.mPayPalConfiguration);
    paramSet2.add(this.mRiderClient);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(SignupActivity paramSignupActivity)
  {
    paramSignupActivity.mAppConfigClient = ((AppConfigClient)this.mAppConfigClient.get());
    paramSignupActivity.mGeoManager = ((GeoManager)this.mGeoManager.get());
    paramSignupActivity.mPayPalConfiguration = ((PayPalConfiguration)this.mPayPalConfiguration.get());
    paramSignupActivity.mRiderClient = ((RiderClient)this.mRiderClient.get());
    this.supertype.injectMembers(paramSignupActivity);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signup.SignupActivity..InjectAdapter
 * JD-Core Version:    0.6.2
 */