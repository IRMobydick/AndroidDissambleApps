package com.ubercab.client.feature.trip;

import com.google.gson.Gson;
import com.squareup.otto.Bus;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.app.RiderPingActivity;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.RiderLocationProvider;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.client.core.network.TunesClient;
import com.ubercab.library.app.BuildConfigProxy;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class TripActivity$$InjectAdapter extends Binding<TripActivity>
  implements Provider<TripActivity>, MembersInjector<TripActivity>
{
  private Binding<AnalyticsClient> mAnalyticsClient;
  private Binding<AnalyticsManager> mAnalyticsManager;
  private Binding<BuildConfigProxy> mBuildConfig;
  private Binding<Bus> mBus;
  private Binding<Gson> mGson;
  private Binding<RiderLocationProvider> mLocationProvider;
  private Binding<PingProvider> mPingProvider;
  private Binding<RiderClient> mRiderClient;
  private Binding<TripUIStateManager> mTripUIStateManager;
  private Binding<TunesClient> mTunesClient;
  private Binding<RiderPingActivity> supertype;

  public TripActivity$$InjectAdapter()
  {
    super("com.ubercab.client.feature.trip.TripActivity", "members/com.ubercab.client.feature.trip.TripActivity", false, TripActivity.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mAnalyticsClient = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.AnalyticsClient", TripActivity.class, getClass().getClassLoader());
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", TripActivity.class, getClass().getClassLoader());
    this.mGson = paramLinker.requestBinding("com.google.gson.Gson", TripActivity.class, getClass().getClassLoader());
    this.mRiderClient = paramLinker.requestBinding("com.ubercab.client.core.network.RiderClient", TripActivity.class, getClass().getClassLoader());
    this.mTunesClient = paramLinker.requestBinding("com.ubercab.client.core.network.TunesClient", TripActivity.class, getClass().getClassLoader());
    this.mPingProvider = paramLinker.requestBinding("com.ubercab.client.core.content.PingProvider", TripActivity.class, getClass().getClassLoader());
    this.mAnalyticsManager = paramLinker.requestBinding("com.ubercab.client.core.analytics.AnalyticsManager", TripActivity.class, getClass().getClassLoader());
    this.mLocationProvider = paramLinker.requestBinding("com.ubercab.client.core.content.RiderLocationProvider", TripActivity.class, getClass().getClassLoader());
    this.mTripUIStateManager = paramLinker.requestBinding("com.ubercab.client.feature.trip.TripUIStateManager", TripActivity.class, getClass().getClassLoader());
    this.mBuildConfig = paramLinker.requestBinding("@com.ubercab.library.app.annotation.ForApp()/com.ubercab.library.app.BuildConfigProxy", TripActivity.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderPingActivity", TripActivity.class, getClass().getClassLoader(), false, true);
  }

  public TripActivity get()
  {
    TripActivity localTripActivity = new TripActivity();
    injectMembers(localTripActivity);
    return localTripActivity;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mAnalyticsClient);
    paramSet2.add(this.mBus);
    paramSet2.add(this.mGson);
    paramSet2.add(this.mRiderClient);
    paramSet2.add(this.mTunesClient);
    paramSet2.add(this.mPingProvider);
    paramSet2.add(this.mAnalyticsManager);
    paramSet2.add(this.mLocationProvider);
    paramSet2.add(this.mTripUIStateManager);
    paramSet2.add(this.mBuildConfig);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(TripActivity paramTripActivity)
  {
    paramTripActivity.mAnalyticsClient = ((AnalyticsClient)this.mAnalyticsClient.get());
    paramTripActivity.mBus = ((Bus)this.mBus.get());
    paramTripActivity.mGson = ((Gson)this.mGson.get());
    paramTripActivity.mRiderClient = ((RiderClient)this.mRiderClient.get());
    paramTripActivity.mTunesClient = ((TunesClient)this.mTunesClient.get());
    paramTripActivity.mPingProvider = ((PingProvider)this.mPingProvider.get());
    paramTripActivity.mAnalyticsManager = ((AnalyticsManager)this.mAnalyticsManager.get());
    paramTripActivity.mLocationProvider = ((RiderLocationProvider)this.mLocationProvider.get());
    paramTripActivity.mTripUIStateManager = ((TripUIStateManager)this.mTripUIStateManager.get());
    paramTripActivity.mBuildConfig = ((BuildConfigProxy)this.mBuildConfig.get());
    this.supertype.injectMembers(paramTripActivity);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.TripActivity..InjectAdapter
 * JD-Core Version:    0.6.2
 */