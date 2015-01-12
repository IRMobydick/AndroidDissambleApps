package com.ubercab.client.feature.trip.map.layer.route;

import com.squareup.otto.Bus;
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

public final class SingleLegRouteMapLayer$$InjectAdapter extends Binding<SingleLegRouteMapLayer>
  implements Provider<SingleLegRouteMapLayer>, MembersInjector<SingleLegRouteMapLayer>
{
  private Binding<Bus> mBus;
  private Binding<UberMap> mMap;
  private Binding<MapCameraStateManager> mMapCameraStateManager;
  private Binding<MapPolylineStyle> mMapPolylineStyle;
  private Binding<TripUIStateManager> mTripUIStateManager;
  private Binding<BaseMapLayer> supertype;

  public SingleLegRouteMapLayer$$InjectAdapter()
  {
    super("com.ubercab.client.feature.trip.map.layer.route.SingleLegRouteMapLayer", "members/com.ubercab.client.feature.trip.map.layer.route.SingleLegRouteMapLayer", false, SingleLegRouteMapLayer.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", SingleLegRouteMapLayer.class, getClass().getClassLoader());
    this.mMapCameraStateManager = paramLinker.requestBinding("com.ubercab.client.feature.trip.map.MapCameraStateManager", SingleLegRouteMapLayer.class, getClass().getClassLoader());
    this.mMapPolylineStyle = paramLinker.requestBinding("com.ubercab.client.feature.trip.map.MapPolylineStyle", SingleLegRouteMapLayer.class, getClass().getClassLoader());
    this.mTripUIStateManager = paramLinker.requestBinding("com.ubercab.client.feature.trip.TripUIStateManager", SingleLegRouteMapLayer.class, getClass().getClassLoader());
    this.mMap = paramLinker.requestBinding("com.ubercab.library.map.UberMap", SingleLegRouteMapLayer.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.feature.trip.map.layer.BaseMapLayer", SingleLegRouteMapLayer.class, getClass().getClassLoader(), false, true);
  }

  public SingleLegRouteMapLayer get()
  {
    SingleLegRouteMapLayer localSingleLegRouteMapLayer = new SingleLegRouteMapLayer();
    injectMembers(localSingleLegRouteMapLayer);
    return localSingleLegRouteMapLayer;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mBus);
    paramSet2.add(this.mMapCameraStateManager);
    paramSet2.add(this.mMapPolylineStyle);
    paramSet2.add(this.mTripUIStateManager);
    paramSet2.add(this.mMap);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(SingleLegRouteMapLayer paramSingleLegRouteMapLayer)
  {
    paramSingleLegRouteMapLayer.mBus = ((Bus)this.mBus.get());
    paramSingleLegRouteMapLayer.mMapCameraStateManager = ((MapCameraStateManager)this.mMapCameraStateManager.get());
    paramSingleLegRouteMapLayer.mMapPolylineStyle = ((MapPolylineStyle)this.mMapPolylineStyle.get());
    paramSingleLegRouteMapLayer.mTripUIStateManager = ((TripUIStateManager)this.mTripUIStateManager.get());
    paramSingleLegRouteMapLayer.mMap = ((UberMap)this.mMap.get());
    this.supertype.injectMembers(paramSingleLegRouteMapLayer);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.map.layer.route.SingleLegRouteMapLayer..InjectAdapter
 * JD-Core Version:    0.6.2
 */