package com.ubercab.client.feature.search;

import android.app.ActionBar;
import android.content.Context;
import android.view.LayoutInflater;
import com.squareup.otto.Bus;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.app.RiderPreferences;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.RiderLocationProvider;
import com.ubercab.client.core.network.LocationClient;
import com.ubercab.geo.GeoManager;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class LocationSearchFragment$$InjectAdapter extends Binding<LocationSearchFragment>
  implements Provider<LocationSearchFragment>, MembersInjector<LocationSearchFragment>
{
  private Binding<ActionBar> mActionBar;
  private Binding<AnalyticsClient> mAnalyticsClient;
  private Binding<AnalyticsManager> mAnalyticsManager;
  private Binding<Bus> mBus;
  private Binding<Context> mContext;
  private Binding<GeoManager> mGeoManager;
  private Binding<LayoutInflater> mLayoutInflater;
  private Binding<LocationClient> mLocationClient;
  private Binding<RiderLocationProvider> mLocationProvider;
  private Binding<PingProvider> mPingProvider;
  private Binding<RiderPreferences> mRiderPreferences;
  private Binding<RiderFragment> supertype;

  public LocationSearchFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.search.LocationSearchFragment", "members/com.ubercab.client.feature.search.LocationSearchFragment", false, LocationSearchFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mActionBar = paramLinker.requestBinding("android.app.ActionBar", LocationSearchFragment.class, getClass().getClassLoader());
    this.mAnalyticsManager = paramLinker.requestBinding("com.ubercab.client.core.analytics.AnalyticsManager", LocationSearchFragment.class, getClass().getClassLoader());
    this.mAnalyticsClient = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.AnalyticsClient", LocationSearchFragment.class, getClass().getClassLoader());
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", LocationSearchFragment.class, getClass().getClassLoader());
    this.mContext = paramLinker.requestBinding("@com.ubercab.library.app.annotation.ForActivity()/android.content.Context", LocationSearchFragment.class, getClass().getClassLoader());
    this.mGeoManager = paramLinker.requestBinding("com.ubercab.geo.GeoManager", LocationSearchFragment.class, getClass().getClassLoader());
    this.mLayoutInflater = paramLinker.requestBinding("android.view.LayoutInflater", LocationSearchFragment.class, getClass().getClassLoader());
    this.mLocationClient = paramLinker.requestBinding("com.ubercab.client.core.network.LocationClient", LocationSearchFragment.class, getClass().getClassLoader());
    this.mPingProvider = paramLinker.requestBinding("com.ubercab.client.core.content.PingProvider", LocationSearchFragment.class, getClass().getClassLoader());
    this.mLocationProvider = paramLinker.requestBinding("com.ubercab.client.core.content.RiderLocationProvider", LocationSearchFragment.class, getClass().getClassLoader());
    this.mRiderPreferences = paramLinker.requestBinding("com.ubercab.client.core.app.RiderPreferences", LocationSearchFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderFragment", LocationSearchFragment.class, getClass().getClassLoader(), false, true);
  }

  public LocationSearchFragment get()
  {
    LocationSearchFragment localLocationSearchFragment = new LocationSearchFragment();
    injectMembers(localLocationSearchFragment);
    return localLocationSearchFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mActionBar);
    paramSet2.add(this.mAnalyticsManager);
    paramSet2.add(this.mAnalyticsClient);
    paramSet2.add(this.mBus);
    paramSet2.add(this.mContext);
    paramSet2.add(this.mGeoManager);
    paramSet2.add(this.mLayoutInflater);
    paramSet2.add(this.mLocationClient);
    paramSet2.add(this.mPingProvider);
    paramSet2.add(this.mLocationProvider);
    paramSet2.add(this.mRiderPreferences);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(LocationSearchFragment paramLocationSearchFragment)
  {
    paramLocationSearchFragment.mActionBar = ((ActionBar)this.mActionBar.get());
    paramLocationSearchFragment.mAnalyticsManager = ((AnalyticsManager)this.mAnalyticsManager.get());
    paramLocationSearchFragment.mAnalyticsClient = ((AnalyticsClient)this.mAnalyticsClient.get());
    paramLocationSearchFragment.mBus = ((Bus)this.mBus.get());
    paramLocationSearchFragment.mContext = ((Context)this.mContext.get());
    paramLocationSearchFragment.mGeoManager = ((GeoManager)this.mGeoManager.get());
    paramLocationSearchFragment.mLayoutInflater = ((LayoutInflater)this.mLayoutInflater.get());
    paramLocationSearchFragment.mLocationClient = ((LocationClient)this.mLocationClient.get());
    paramLocationSearchFragment.mPingProvider = ((PingProvider)this.mPingProvider.get());
    paramLocationSearchFragment.mLocationProvider = ((RiderLocationProvider)this.mLocationProvider.get());
    paramLocationSearchFragment.mRiderPreferences = ((RiderPreferences)this.mRiderPreferences.get());
    this.supertype.injectMembers(paramLocationSearchFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.search.LocationSearchFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */