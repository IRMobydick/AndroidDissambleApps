package com.ubercab.client.feature.trip;

import android.content.Context;
import com.squareup.otto.Bus;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.RiderLocationProvider;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.core.network.LocationClient;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.client.feature.mobilemessage.MobileMessageManager;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class TripFragment$$InjectAdapter extends Binding<TripFragment>
  implements Provider<TripFragment>, MembersInjector<TripFragment>
{
  private Binding<AnalyticsClient> mAnalyticsClient;
  private Binding<AnalyticsManager> mAnalyticsManager;
  private Binding<Bus> mBus;
  private Binding<Context> mContext;
  private Binding<LegacyFareEstimateManager> mLegacyFareEstimateManager;
  private Binding<LocationClient> mLocationClient;
  private Binding<RiderLocationProvider> mLocationProvider;
  private Binding<MobileMessageManager> mMobileMessageManager;
  private Binding<MultiFareEstimateManager> mMultiFareEstimateManager;
  private Binding<PingProvider> mPingProvider;
  private Binding<RiderClient> mRiderClient;
  private Binding<SessionPreferences> mSessionPreferences;
  private Binding<TripUIStateManager> mTripUIStateManager;
  private Binding<RiderFragment> supertype;

  public TripFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.trip.TripFragment", "members/com.ubercab.client.feature.trip.TripFragment", false, TripFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mAnalyticsClient = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.AnalyticsClient", TripFragment.class, getClass().getClassLoader());
    this.mAnalyticsManager = paramLinker.requestBinding("com.ubercab.client.core.analytics.AnalyticsManager", TripFragment.class, getClass().getClassLoader());
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", TripFragment.class, getClass().getClassLoader());
    this.mContext = paramLinker.requestBinding("@com.ubercab.library.app.annotation.ForActivity()/android.content.Context", TripFragment.class, getClass().getClassLoader());
    this.mLocationClient = paramLinker.requestBinding("com.ubercab.client.core.network.LocationClient", TripFragment.class, getClass().getClassLoader());
    this.mLocationProvider = paramLinker.requestBinding("com.ubercab.client.core.content.RiderLocationProvider", TripFragment.class, getClass().getClassLoader());
    this.mMobileMessageManager = paramLinker.requestBinding("com.ubercab.client.feature.mobilemessage.MobileMessageManager", TripFragment.class, getClass().getClassLoader());
    this.mMultiFareEstimateManager = paramLinker.requestBinding("com.ubercab.client.feature.trip.MultiFareEstimateManager", TripFragment.class, getClass().getClassLoader());
    this.mLegacyFareEstimateManager = paramLinker.requestBinding("com.ubercab.client.feature.trip.LegacyFareEstimateManager", TripFragment.class, getClass().getClassLoader());
    this.mPingProvider = paramLinker.requestBinding("com.ubercab.client.core.content.PingProvider", TripFragment.class, getClass().getClassLoader());
    this.mRiderClient = paramLinker.requestBinding("com.ubercab.client.core.network.RiderClient", TripFragment.class, getClass().getClassLoader());
    this.mSessionPreferences = paramLinker.requestBinding("com.ubercab.client.core.content.SessionPreferences", TripFragment.class, getClass().getClassLoader());
    this.mTripUIStateManager = paramLinker.requestBinding("com.ubercab.client.feature.trip.TripUIStateManager", TripFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderFragment", TripFragment.class, getClass().getClassLoader(), false, true);
  }

  public TripFragment get()
  {
    TripFragment localTripFragment = new TripFragment();
    injectMembers(localTripFragment);
    return localTripFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mAnalyticsClient);
    paramSet2.add(this.mAnalyticsManager);
    paramSet2.add(this.mBus);
    paramSet2.add(this.mContext);
    paramSet2.add(this.mLocationClient);
    paramSet2.add(this.mLocationProvider);
    paramSet2.add(this.mMobileMessageManager);
    paramSet2.add(this.mMultiFareEstimateManager);
    paramSet2.add(this.mLegacyFareEstimateManager);
    paramSet2.add(this.mPingProvider);
    paramSet2.add(this.mRiderClient);
    paramSet2.add(this.mSessionPreferences);
    paramSet2.add(this.mTripUIStateManager);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(TripFragment paramTripFragment)
  {
    paramTripFragment.mAnalyticsClient = ((AnalyticsClient)this.mAnalyticsClient.get());
    paramTripFragment.mAnalyticsManager = ((AnalyticsManager)this.mAnalyticsManager.get());
    paramTripFragment.mBus = ((Bus)this.mBus.get());
    paramTripFragment.mContext = ((Context)this.mContext.get());
    paramTripFragment.mLocationClient = ((LocationClient)this.mLocationClient.get());
    paramTripFragment.mLocationProvider = ((RiderLocationProvider)this.mLocationProvider.get());
    paramTripFragment.mMobileMessageManager = ((MobileMessageManager)this.mMobileMessageManager.get());
    paramTripFragment.mMultiFareEstimateManager = ((MultiFareEstimateManager)this.mMultiFareEstimateManager.get());
    paramTripFragment.mLegacyFareEstimateManager = ((LegacyFareEstimateManager)this.mLegacyFareEstimateManager.get());
    paramTripFragment.mPingProvider = ((PingProvider)this.mPingProvider.get());
    paramTripFragment.mRiderClient = ((RiderClient)this.mRiderClient.get());
    paramTripFragment.mSessionPreferences = ((SessionPreferences)this.mSessionPreferences.get());
    paramTripFragment.mTripUIStateManager = ((TripUIStateManager)this.mTripUIStateManager.get());
    this.supertype.injectMembers(paramTripFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.TripFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */