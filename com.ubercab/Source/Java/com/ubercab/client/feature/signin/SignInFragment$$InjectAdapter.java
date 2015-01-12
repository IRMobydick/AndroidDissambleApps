package com.ubercab.client.feature.signin;

import com.squareup.otto.Bus;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.content.CachePreferences;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.geo.GeoManager;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class SignInFragment$$InjectAdapter extends Binding<SignInFragment>
  implements Provider<SignInFragment>, MembersInjector<SignInFragment>
{
  private Binding<AnalyticsManager> mAnalyticsManager;
  private Binding<Bus> mBus;
  private Binding<CachePreferences> mCachePreferences;
  private Binding<GeoManager> mGeoManager;
  private Binding<RiderClient> mRiderClient;
  private Binding<RiderFragment> supertype;

  public SignInFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.signin.SignInFragment", "members/com.ubercab.client.feature.signin.SignInFragment", false, SignInFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", SignInFragment.class, getClass().getClassLoader());
    this.mCachePreferences = paramLinker.requestBinding("com.ubercab.client.core.content.CachePreferences", SignInFragment.class, getClass().getClassLoader());
    this.mRiderClient = paramLinker.requestBinding("com.ubercab.client.core.network.RiderClient", SignInFragment.class, getClass().getClassLoader());
    this.mGeoManager = paramLinker.requestBinding("com.ubercab.geo.GeoManager", SignInFragment.class, getClass().getClassLoader());
    this.mAnalyticsManager = paramLinker.requestBinding("com.ubercab.client.core.analytics.AnalyticsManager", SignInFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderFragment", SignInFragment.class, getClass().getClassLoader(), false, true);
  }

  public SignInFragment get()
  {
    SignInFragment localSignInFragment = new SignInFragment();
    injectMembers(localSignInFragment);
    return localSignInFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mBus);
    paramSet2.add(this.mCachePreferences);
    paramSet2.add(this.mRiderClient);
    paramSet2.add(this.mGeoManager);
    paramSet2.add(this.mAnalyticsManager);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(SignInFragment paramSignInFragment)
  {
    paramSignInFragment.mBus = ((Bus)this.mBus.get());
    paramSignInFragment.mCachePreferences = ((CachePreferences)this.mCachePreferences.get());
    paramSignInFragment.mRiderClient = ((RiderClient)this.mRiderClient.get());
    paramSignInFragment.mGeoManager = ((GeoManager)this.mGeoManager.get());
    paramSignInFragment.mAnalyticsManager = ((AnalyticsManager)this.mAnalyticsManager.get());
    this.supertype.injectMembers(paramSignInFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signin.SignInFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */