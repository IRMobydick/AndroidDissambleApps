package com.ubercab.client.feature.trip.map;

import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.content.RiderLocationProvider;
import com.ubercab.client.feature.trip.TripUIStateManager;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class MapFragment$$InjectAdapter extends Binding<MapFragment>
  implements Provider<MapFragment>, MembersInjector<MapFragment>
{
  private Binding<AnalyticsClient> mAnalyticsClient;
  private Binding<AnalyticsManager> mAnalyticsManager;
  private Binding<RiderLocationProvider> mLocationProvider;
  private Binding<MapCameraStateManager> mMapCameraStateManager;
  private Binding<TripUIStateManager> mTripUIStateManager;
  private Binding<RiderFragment> supertype;

  public MapFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.trip.map.MapFragment", "members/com.ubercab.client.feature.trip.map.MapFragment", false, MapFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mAnalyticsClient = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.AnalyticsClient", MapFragment.class, getClass().getClassLoader());
    this.mAnalyticsManager = paramLinker.requestBinding("com.ubercab.client.core.analytics.AnalyticsManager", MapFragment.class, getClass().getClassLoader());
    this.mLocationProvider = paramLinker.requestBinding("com.ubercab.client.core.content.RiderLocationProvider", MapFragment.class, getClass().getClassLoader());
    this.mTripUIStateManager = paramLinker.requestBinding("com.ubercab.client.feature.trip.TripUIStateManager", MapFragment.class, getClass().getClassLoader());
    this.mMapCameraStateManager = paramLinker.requestBinding("com.ubercab.client.feature.trip.map.MapCameraStateManager", MapFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderFragment", MapFragment.class, getClass().getClassLoader(), false, true);
  }

  public MapFragment get()
  {
    MapFragment localMapFragment = new MapFragment();
    injectMembers(localMapFragment);
    return localMapFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mAnalyticsClient);
    paramSet2.add(this.mAnalyticsManager);
    paramSet2.add(this.mLocationProvider);
    paramSet2.add(this.mTripUIStateManager);
    paramSet2.add(this.mMapCameraStateManager);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(MapFragment paramMapFragment)
  {
    paramMapFragment.mAnalyticsClient = ((AnalyticsClient)this.mAnalyticsClient.get());
    paramMapFragment.mAnalyticsManager = ((AnalyticsManager)this.mAnalyticsManager.get());
    paramMapFragment.mLocationProvider = ((RiderLocationProvider)this.mLocationProvider.get());
    paramMapFragment.mTripUIStateManager = ((TripUIStateManager)this.mTripUIStateManager.get());
    paramMapFragment.mMapCameraStateManager = ((MapCameraStateManager)this.mMapCameraStateManager.get());
    this.supertype.injectMembers(paramMapFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.map.MapFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */