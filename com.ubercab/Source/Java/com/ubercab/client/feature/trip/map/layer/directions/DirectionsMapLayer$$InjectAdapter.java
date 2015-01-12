package com.ubercab.client.feature.trip.map.layer.directions;

import com.squareup.otto.Bus;
import com.ubercab.client.core.content.RiderLocationProvider;
import com.ubercab.client.core.vendor.google.network.DirectionsClient;
import com.ubercab.client.feature.trip.TripUIStateManager;
import com.ubercab.client.feature.trip.map.MapCameraStateManager;
import com.ubercab.client.feature.trip.map.MapPolylineStyle;
import com.ubercab.client.feature.trip.map.layer.BaseMapLayer;
import com.ubercab.library.map.UberMap;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class DirectionsMapLayer$$InjectAdapter extends Binding<DirectionsMapLayer>
  implements Provider<DirectionsMapLayer>, MembersInjector<DirectionsMapLayer>
{
  private Binding<Bus> mBus;
  private Binding<DirectionsClient> mDirectionsClient;
  private Binding<RiderLocationProvider> mLocationProvider;
  private Binding<UberMap> mMap;
  private Binding<MapCameraStateManager> mMapCameraStateManager;
  private Binding<MapPolylineStyle> mPolylineStyle;
  private Binding<TripUIStateManager> mTripUIStateManager;
  private Binding<BaseMapLayer> supertype;

  public DirectionsMapLayer$$InjectAdapter()
  {
    super("com.ubercab.client.feature.trip.map.layer.directions.DirectionsMapLayer", "members/com.ubercab.client.feature.trip.map.layer.directions.DirectionsMapLayer", false, DirectionsMapLayer.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", DirectionsMapLayer.class, getClass().getClassLoader());
    this.mDirectionsClient = paramLinker.requestBinding("com.ubercab.client.core.vendor.google.network.DirectionsClient", DirectionsMapLayer.class, getClass().getClassLoader());
    this.mMapCameraStateManager = paramLinker.requestBinding("com.ubercab.client.feature.trip.map.MapCameraStateManager", DirectionsMapLayer.class, getClass().getClassLoader());
    this.mPolylineStyle = paramLinker.requestBinding("com.ubercab.client.feature.trip.map.MapPolylineStyle", DirectionsMapLayer.class, getClass().getClassLoader());
    this.mLocationProvider = paramLinker.requestBinding("com.ubercab.client.core.content.RiderLocationProvider", DirectionsMapLayer.class, getClass().getClassLoader());
    this.mTripUIStateManager = paramLinker.requestBinding("com.ubercab.client.feature.trip.TripUIStateManager", DirectionsMapLayer.class, getClass().getClassLoader());
    this.mMap = paramLinker.requestBinding("com.ubercab.library.map.UberMap", DirectionsMapLayer.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.feature.trip.map.layer.BaseMapLayer", DirectionsMapLayer.class, getClass().getClassLoader(), false, true);
  }

  public DirectionsMapLayer get()
  {
    DirectionsMapLayer localDirectionsMapLayer = new DirectionsMapLayer();
    injectMembers(localDirectionsMapLayer);
    return localDirectionsMapLayer;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mBus);
    paramSet2.add(this.mDirectionsClient);
    paramSet2.add(this.mMapCameraStateManager);
    paramSet2.add(this.mPolylineStyle);
    paramSet2.add(this.mLocationProvider);
    paramSet2.add(this.mTripUIStateManager);
    paramSet2.add(this.mMap);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(DirectionsMapLayer paramDirectionsMapLayer)
  {
    paramDirectionsMapLayer.mBus = ((Bus)this.mBus.get());
    paramDirectionsMapLayer.mDirectionsClient = ((DirectionsClient)this.mDirectionsClient.get());
    paramDirectionsMapLayer.mMapCameraStateManager = ((MapCameraStateManager)this.mMapCameraStateManager.get());
    paramDirectionsMapLayer.mPolylineStyle = ((MapPolylineStyle)this.mPolylineStyle.get());
    paramDirectionsMapLayer.mLocationProvider = ((RiderLocationProvider)this.mLocationProvider.get());
    paramDirectionsMapLayer.mTripUIStateManager = ((TripUIStateManager)this.mTripUIStateManager.get());
    paramDirectionsMapLayer.mMap = ((UberMap)this.mMap.get());
    this.supertype.injectMembers(paramDirectionsMapLayer);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.map.layer.directions.DirectionsMapLayer..InjectAdapter
 * JD-Core Version:    0.6.2
 */