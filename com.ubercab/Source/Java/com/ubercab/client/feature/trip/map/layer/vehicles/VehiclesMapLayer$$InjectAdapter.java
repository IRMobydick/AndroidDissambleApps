package com.ubercab.client.feature.trip.map.layer.vehicles;

import android.content.Context;
import com.squareup.otto.Bus;
import com.squareup.picasso.Picasso;
import com.ubercab.client.core.app.RiderPreferences;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.feature.trip.TripUIStateManager;
import com.ubercab.client.feature.trip.map.MapCameraStateManager;
import com.ubercab.client.feature.trip.map.layer.BaseMapLayer;
import com.ubercab.library.map.UberBitmapDescriptorFactory;
import com.ubercab.library.map.UberMap;
import com.ubercab.library.map.UberMarkerOptions;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class VehiclesMapLayer$$InjectAdapter extends Binding<VehiclesMapLayer>
  implements Provider<VehiclesMapLayer>, MembersInjector<VehiclesMapLayer>
{
  private Binding<Bus> mBus;
  private Binding<Context> mContext;
  private Binding<UberMap> mMap;
  private Binding<MapCameraStateManager> mMapCameraStateManager;
  private Binding<Provider<UberMarkerOptions>> mMarkerOptionsProvider;
  private Binding<Picasso> mPicasso;
  private Binding<PingProvider> mPingProvider;
  private Binding<RiderPreferences> mRiderPreferences;
  private Binding<SessionPreferences> mSessionPreferences;
  private Binding<TripUIStateManager> mTripUIStateManager;
  private Binding<UberBitmapDescriptorFactory> mUberBitmapDescriptorFactory;
  private Binding<BaseMapLayer> supertype;

  public VehiclesMapLayer$$InjectAdapter()
  {
    super("com.ubercab.client.feature.trip.map.layer.vehicles.VehiclesMapLayer", "members/com.ubercab.client.feature.trip.map.layer.vehicles.VehiclesMapLayer", false, VehiclesMapLayer.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", VehiclesMapLayer.class, getClass().getClassLoader());
    this.mContext = paramLinker.requestBinding("android.content.Context", VehiclesMapLayer.class, getClass().getClassLoader());
    this.mMapCameraStateManager = paramLinker.requestBinding("com.ubercab.client.feature.trip.map.MapCameraStateManager", VehiclesMapLayer.class, getClass().getClassLoader());
    this.mPicasso = paramLinker.requestBinding("com.squareup.picasso.Picasso", VehiclesMapLayer.class, getClass().getClassLoader());
    this.mPingProvider = paramLinker.requestBinding("com.ubercab.client.core.content.PingProvider", VehiclesMapLayer.class, getClass().getClassLoader());
    this.mMarkerOptionsProvider = paramLinker.requestBinding("javax.inject.Provider<com.ubercab.library.map.UberMarkerOptions>", VehiclesMapLayer.class, getClass().getClassLoader());
    this.mRiderPreferences = paramLinker.requestBinding("com.ubercab.client.core.app.RiderPreferences", VehiclesMapLayer.class, getClass().getClassLoader());
    this.mSessionPreferences = paramLinker.requestBinding("com.ubercab.client.core.content.SessionPreferences", VehiclesMapLayer.class, getClass().getClassLoader());
    this.mTripUIStateManager = paramLinker.requestBinding("com.ubercab.client.feature.trip.TripUIStateManager", VehiclesMapLayer.class, getClass().getClassLoader());
    this.mUberBitmapDescriptorFactory = paramLinker.requestBinding("com.ubercab.library.map.UberBitmapDescriptorFactory", VehiclesMapLayer.class, getClass().getClassLoader());
    this.mMap = paramLinker.requestBinding("com.ubercab.library.map.UberMap", VehiclesMapLayer.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.feature.trip.map.layer.BaseMapLayer", VehiclesMapLayer.class, getClass().getClassLoader(), false, true);
  }

  public VehiclesMapLayer get()
  {
    VehiclesMapLayer localVehiclesMapLayer = new VehiclesMapLayer();
    injectMembers(localVehiclesMapLayer);
    return localVehiclesMapLayer;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mBus);
    paramSet2.add(this.mContext);
    paramSet2.add(this.mMapCameraStateManager);
    paramSet2.add(this.mPicasso);
    paramSet2.add(this.mPingProvider);
    paramSet2.add(this.mMarkerOptionsProvider);
    paramSet2.add(this.mRiderPreferences);
    paramSet2.add(this.mSessionPreferences);
    paramSet2.add(this.mTripUIStateManager);
    paramSet2.add(this.mUberBitmapDescriptorFactory);
    paramSet2.add(this.mMap);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(VehiclesMapLayer paramVehiclesMapLayer)
  {
    paramVehiclesMapLayer.mBus = ((Bus)this.mBus.get());
    paramVehiclesMapLayer.mContext = ((Context)this.mContext.get());
    paramVehiclesMapLayer.mMapCameraStateManager = ((MapCameraStateManager)this.mMapCameraStateManager.get());
    paramVehiclesMapLayer.mPicasso = ((Picasso)this.mPicasso.get());
    paramVehiclesMapLayer.mPingProvider = ((PingProvider)this.mPingProvider.get());
    paramVehiclesMapLayer.mMarkerOptionsProvider = ((Provider)this.mMarkerOptionsProvider.get());
    paramVehiclesMapLayer.mRiderPreferences = ((RiderPreferences)this.mRiderPreferences.get());
    paramVehiclesMapLayer.mSessionPreferences = ((SessionPreferences)this.mSessionPreferences.get());
    paramVehiclesMapLayer.mTripUIStateManager = ((TripUIStateManager)this.mTripUIStateManager.get());
    paramVehiclesMapLayer.mUberBitmapDescriptorFactory = ((UberBitmapDescriptorFactory)this.mUberBitmapDescriptorFactory.get());
    paramVehiclesMapLayer.mMap = ((UberMap)this.mMap.get());
    this.supertype.injectMembers(paramVehiclesMapLayer);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.map.layer.vehicles.VehiclesMapLayer..InjectAdapter
 * JD-Core Version:    0.6.2
 */