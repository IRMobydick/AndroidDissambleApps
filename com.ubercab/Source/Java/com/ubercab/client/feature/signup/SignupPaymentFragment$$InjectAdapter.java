package com.ubercab.client.feature.signup;

import android.app.ActionBar;
import com.squareup.otto.Bus;
import com.squareup.picasso.Picasso;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.client.core.network.SignupClient;
import com.ubercab.client.feature.payment.UberBraintree;
import com.ubercab.geo.GeoManager;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class SignupPaymentFragment$$InjectAdapter extends Binding<SignupPaymentFragment>
  implements Provider<SignupPaymentFragment>, MembersInjector<SignupPaymentFragment>
{
  private Binding<ActionBar> mActionBar;
  private Binding<AnalyticsClient> mAnalyticsClient;
  private Binding<AnalyticsManager> mAnalyticsManager;
  private Binding<UberBraintree> mBraintree;
  private Binding<Bus> mBus;
  private Binding<GeoManager> mGeoManager;
  private Binding<Picasso> mPicasso;
  private Binding<RiderClient> mRiderClient;
  private Binding<SignupClient> mSignupClient;
  private Binding<RiderFragment> supertype;

  public SignupPaymentFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.signup.SignupPaymentFragment", "members/com.ubercab.client.feature.signup.SignupPaymentFragment", false, SignupPaymentFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", SignupPaymentFragment.class, getClass().getClassLoader());
    this.mRiderClient = paramLinker.requestBinding("com.ubercab.client.core.network.RiderClient", SignupPaymentFragment.class, getClass().getClassLoader());
    this.mSignupClient = paramLinker.requestBinding("com.ubercab.client.core.network.SignupClient", SignupPaymentFragment.class, getClass().getClassLoader());
    this.mPicasso = paramLinker.requestBinding("com.squareup.picasso.Picasso", SignupPaymentFragment.class, getClass().getClassLoader());
    this.mActionBar = paramLinker.requestBinding("android.app.ActionBar", SignupPaymentFragment.class, getClass().getClassLoader());
    this.mGeoManager = paramLinker.requestBinding("com.ubercab.geo.GeoManager", SignupPaymentFragment.class, getClass().getClassLoader());
    this.mBraintree = paramLinker.requestBinding("com.ubercab.client.feature.payment.UberBraintree", SignupPaymentFragment.class, getClass().getClassLoader());
    this.mAnalyticsManager = paramLinker.requestBinding("com.ubercab.client.core.analytics.AnalyticsManager", SignupPaymentFragment.class, getClass().getClassLoader());
    this.mAnalyticsClient = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.AnalyticsClient", SignupPaymentFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderFragment", SignupPaymentFragment.class, getClass().getClassLoader(), false, true);
  }

  public SignupPaymentFragment get()
  {
    SignupPaymentFragment localSignupPaymentFragment = new SignupPaymentFragment();
    injectMembers(localSignupPaymentFragment);
    return localSignupPaymentFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mBus);
    paramSet2.add(this.mRiderClient);
    paramSet2.add(this.mSignupClient);
    paramSet2.add(this.mPicasso);
    paramSet2.add(this.mActionBar);
    paramSet2.add(this.mGeoManager);
    paramSet2.add(this.mBraintree);
    paramSet2.add(this.mAnalyticsManager);
    paramSet2.add(this.mAnalyticsClient);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(SignupPaymentFragment paramSignupPaymentFragment)
  {
    paramSignupPaymentFragment.mBus = ((Bus)this.mBus.get());
    paramSignupPaymentFragment.mRiderClient = ((RiderClient)this.mRiderClient.get());
    paramSignupPaymentFragment.mSignupClient = ((SignupClient)this.mSignupClient.get());
    paramSignupPaymentFragment.mPicasso = ((Picasso)this.mPicasso.get());
    paramSignupPaymentFragment.mActionBar = ((ActionBar)this.mActionBar.get());
    paramSignupPaymentFragment.mGeoManager = ((GeoManager)this.mGeoManager.get());
    paramSignupPaymentFragment.mBraintree = ((UberBraintree)this.mBraintree.get());
    paramSignupPaymentFragment.mAnalyticsManager = ((AnalyticsManager)this.mAnalyticsManager.get());
    paramSignupPaymentFragment.mAnalyticsClient = ((AnalyticsClient)this.mAnalyticsClient.get());
    this.supertype.injectMembers(paramSignupPaymentFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signup.SignupPaymentFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */