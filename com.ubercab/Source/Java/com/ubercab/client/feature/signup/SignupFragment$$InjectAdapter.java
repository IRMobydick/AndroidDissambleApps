package com.ubercab.client.feature.signup;

import android.app.ActionBar;
import android.content.Context;
import com.squareup.otto.Bus;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.client.core.network.SignupClient;
import com.ubercab.geo.GeoManager;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class SignupFragment$$InjectAdapter extends Binding<SignupFragment>
  implements Provider<SignupFragment>, MembersInjector<SignupFragment>
{
  private Binding<ActionBar> mActionBar;
  private Binding<AnalyticsClient> mAnalyticsClient;
  private Binding<AnalyticsManager> mAnalyticsManager;
  private Binding<Bus> mBus;
  private Binding<Context> mContext;
  private Binding<GeoManager> mGeoManager;
  private Binding<PingProvider> mPingProvider;
  private Binding<RiderClient> mRiderClient;
  private Binding<SignupClient> mSignupClient;
  private Binding<RiderFragment> supertype;

  public SignupFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.signup.SignupFragment", "members/com.ubercab.client.feature.signup.SignupFragment", false, SignupFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mActionBar = paramLinker.requestBinding("android.app.ActionBar", SignupFragment.class, getClass().getClassLoader());
    this.mContext = paramLinker.requestBinding("@com.ubercab.library.app.annotation.ForApp()/android.content.Context", SignupFragment.class, getClass().getClassLoader());
    this.mAnalyticsManager = paramLinker.requestBinding("com.ubercab.client.core.analytics.AnalyticsManager", SignupFragment.class, getClass().getClassLoader());
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", SignupFragment.class, getClass().getClassLoader());
    this.mGeoManager = paramLinker.requestBinding("com.ubercab.geo.GeoManager", SignupFragment.class, getClass().getClassLoader());
    this.mPingProvider = paramLinker.requestBinding("com.ubercab.client.core.content.PingProvider", SignupFragment.class, getClass().getClassLoader());
    this.mRiderClient = paramLinker.requestBinding("com.ubercab.client.core.network.RiderClient", SignupFragment.class, getClass().getClassLoader());
    this.mAnalyticsClient = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.AnalyticsClient", SignupFragment.class, getClass().getClassLoader());
    this.mSignupClient = paramLinker.requestBinding("com.ubercab.client.core.network.SignupClient", SignupFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderFragment", SignupFragment.class, getClass().getClassLoader(), false, true);
  }

  public SignupFragment get()
  {
    SignupFragment localSignupFragment = new SignupFragment();
    injectMembers(localSignupFragment);
    return localSignupFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mActionBar);
    paramSet2.add(this.mContext);
    paramSet2.add(this.mAnalyticsManager);
    paramSet2.add(this.mBus);
    paramSet2.add(this.mGeoManager);
    paramSet2.add(this.mPingProvider);
    paramSet2.add(this.mRiderClient);
    paramSet2.add(this.mAnalyticsClient);
    paramSet2.add(this.mSignupClient);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(SignupFragment paramSignupFragment)
  {
    paramSignupFragment.mActionBar = ((ActionBar)this.mActionBar.get());
    paramSignupFragment.mContext = ((Context)this.mContext.get());
    paramSignupFragment.mAnalyticsManager = ((AnalyticsManager)this.mAnalyticsManager.get());
    paramSignupFragment.mBus = ((Bus)this.mBus.get());
    paramSignupFragment.mGeoManager = ((GeoManager)this.mGeoManager.get());
    paramSignupFragment.mPingProvider = ((PingProvider)this.mPingProvider.get());
    paramSignupFragment.mRiderClient = ((RiderClient)this.mRiderClient.get());
    paramSignupFragment.mAnalyticsClient = ((AnalyticsClient)this.mAnalyticsClient.get());
    paramSignupFragment.mSignupClient = ((SignupClient)this.mSignupClient.get());
    this.supertype.injectMembers(paramSignupFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signup.SignupFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */