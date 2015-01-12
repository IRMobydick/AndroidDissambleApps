package com.ubercab.client.feature.trip.map.layer.route;

import com.squareup.otto.Bus;
import com.ubercab.client.feature.trip.map.MapCameraStateManager;
import com.ubercab.client.feature.trip.map.MapPolylineStyle;
import com.ubercab.client.feature.trip.map.layer.BaseMapLayer;
import com.ubercab.library.map.UberMap;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

public final class MultiLegRouteMapLayer$$InjectAdapter extends Binding<MultiLegRouteMapLayer>
  implements MembersInjector<MultiLegRouteMapLayer>
{
  private Binding<Bus> mBus;
  private Binding<UberMap> mMap;
  private Binding<MapCameraStateManager> mMapCameraStateManager;
  private Binding<MapPolylineStyle> mPolylineStyle;
  private Binding<BaseMapLayer> supertype;

  public MultiLegRouteMapLayer$$InjectAdapter()
  {
    super(null, "members/com.ubercab.client.feature.trip.map.layer.route.MultiLegRouteMapLayer", false, MultiLegRouteMapLayer.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", MultiLegRouteMapLayer.class, getClass().getClassLoader());
    this.mMap = paramLinker.requestBinding("com.ubercab.library.map.UberMap", MultiLegRouteMapLayer.class, getClass().getClassLoader());
    this.mPolylineStyle = paramLinker.requestBinding("com.ubercab.client.feature.trip.map.MapPolylineStyle", MultiLegRouteMapLayer.class, getClass().getClassLoader());
    this.mMapCameraStateManager = paramLinker.requestBinding("com.ubercab.client.feature.trip.map.MapCameraStateManager", MultiLegRouteMapLayer.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.feature.trip.map.layer.BaseMapLayer", MultiLegRouteMapLayer.class, getClass().getClassLoader(), false, true);
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mBus);
    paramSet2.add(this.mMap);
    paramSet2.add(this.mPolylineStyle);
    paramSet2.add(this.mMapCameraStateManager);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(MultiLegRouteMapLayer paramMultiLegRouteMapLayer)
  {
    paramMultiLegRouteMapLayer.mBus = ((Bus)this.mBus.get());
    paramMultiLegRouteMapLayer.mMap = ((UberMap)this.mMap.get());
    paramMultiLegRouteMapLayer.mPolylineStyle = ((MapPolylineStyle)this.mPolylineStyle.get());
    paramMultiLegRouteMapLayer.mMapCameraStateManager = ((MapCameraStateManager)this.mMapCameraStateManager.get());
    this.supertype.injectMembers(paramMultiLegRouteMapLayer);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.map.layer.route.MultiLegRouteMapLayer..InjectAdapter
 * JD-Core Version:    0.6.2
 */