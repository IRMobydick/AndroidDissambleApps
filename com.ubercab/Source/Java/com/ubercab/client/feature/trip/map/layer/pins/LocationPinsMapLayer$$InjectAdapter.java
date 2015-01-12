package com.ubercab.client.feature.trip.map.layer.pins;

import com.squareup.otto.Bus;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.RiderLocationProvider;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.feature.trip.TripUIStateManager;
import com.ubercab.client.feature.trip.map.layer.BaseMapLayer;
import com.ubercab.library.map.UberBitmapDescriptorFactory;
import com.ubercab.library.map.UberMap;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

public final class LocationPinsMapLayer$$InjectAdapter extends Binding<LocationPinsMapLayer>
  implements MembersInjector<LocationPinsMapLayer>
{
  private Binding<Bus> mBus;
  private Binding<RiderLocationProvider> mLocationProvider;
  private Binding<UberMap> mMap;
  private Binding<PingProvider> mPingProvider;
  private Binding<SessionPreferences> mSessionPreferences;
  private Binding<TripUIStateManager> mTripUIStateManager;
  private Binding<UberBitmapDescriptorFactory> mUberBitmapDescriptorFactory;
  private Binding<BaseMapLayer> supertype;

  public LocationPinsMapLayer$$InjectAdapter()
  {
    super(null, "members/com.ubercab.client.feature.trip.map.layer.pins.LocationPinsMapLayer", false, LocationPinsMapLayer.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", LocationPinsMapLayer.class, getClass().getClassLoader());
    this.mPingProvider = paramLinker.requestBinding("com.ubercab.client.core.content.PingProvider", LocationPinsMapLayer.class, getClass().getClassLoader());
    this.mLocationProvider = paramLinker.requestBinding("com.ubercab.client.core.content.RiderLocationProvider", LocationPinsMapLayer.class, getClass().getClassLoader());
    this.mSessionPreferences = paramLinker.requestBinding("com.ubercab.client.core.content.SessionPreferences", LocationPinsMapLayer.class, getClass().getClassLoader());
    this.mTripUIStateManager = paramLinker.requestBinding("com.ubercab.client.feature.trip.TripUIStateManager", LocationPinsMapLayer.class, getClass().getClassLoader());
    this.mUberBitmapDescriptorFactory = paramLinker.requestBinding("com.ubercab.library.map.UberBitmapDescriptorFactory", LocationPinsMapLayer.class, getClass().getClassLoader());
    this.mMap = paramLinker.requestBinding("com.ubercab.library.map.UberMap", LocationPinsMapLayer.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.feature.trip.map.layer.BaseMapLayer", LocationPinsMapLayer.class, getClass().getClassLoader(), false, true);
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mBus);
    paramSet2.add(this.mPingProvider);
    paramSet2.add(this.mLocationProvider);
    paramSet2.add(this.mSessionPreferences);
    paramSet2.add(this.mTripUIStateManager);
    paramSet2.add(this.mUberBitmapDescriptorFactory);
    paramSet2.add(this.mMap);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(LocationPinsMapLayer paramLocationPinsMapLayer)
  {
    paramLocationPinsMapLayer.mBus = ((Bus)this.mBus.get());
    paramLocationPinsMapLayer.mPingProvider = ((PingProvider)this.mPingProvider.get());
    paramLocationPinsMapLayer.mLocationProvider = ((RiderLocationProvider)this.mLocationProvider.get());
    paramLocationPinsMapLayer.mSessionPreferences = ((SessionPreferences)this.mSessionPreferences.get());
    paramLocationPinsMapLayer.mTripUIStateManager = ((TripUIStateManager)this.mTripUIStateManager.get());
    paramLocationPinsMapLayer.mUberBitmapDescriptorFactory = ((UberBitmapDescriptorFactory)this.mUberBitmapDescriptorFactory.get());
    paramLocationPinsMapLayer.mMap = ((UberMap)this.mMap.get());
    this.supertype.injectMembers(paramLocationPinsMapLayer);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.map.layer.pins.LocationPinsMapLayer..InjectAdapter
 * JD-Core Version:    0.6.2
 */