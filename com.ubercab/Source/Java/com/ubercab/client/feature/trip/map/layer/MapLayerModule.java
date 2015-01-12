package com.ubercab.client.feature.trip.map.layer;

import android.content.Context;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.otto.Bus;
import com.ubercab.client.core.vendor.google.network.DirectionsClient;
import com.ubercab.client.feature.trip.map.MapModule;
import com.ubercab.client.feature.trip.map.MapPolylineStyle;
import com.ubercab.client.feature.trip.map.layer.directions.DirectionsMapLayer;
import com.ubercab.client.feature.trip.map.layer.pins.LocationPinsMapLayer;
import com.ubercab.client.feature.trip.map.layer.route.MultiLegRouteMapLayer;
import com.ubercab.client.feature.trip.map.layer.route.SingleLegRouteMapLayer;
import com.ubercab.client.feature.trip.map.layer.vehicles.VehiclesMapLayer;
import com.ubercab.library.map.UberBitmapDescriptorFactory;
import com.ubercab.library.map.UberMap;
import com.ubercab.library.map.UberMarkerOptions;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module(addsTo=MapModule.class, injects={DirectionsMapLayer.class, LocationPinsMapLayer.class, MultiLegRouteMapLayer.class, SingleLegRouteMapLayer.class, VehiclesMapLayer.class})
public class MapLayerModule
{
  private final UberMap mMap;

  public MapLayerModule(UberMap paramUberMap)
  {
    this.mMap = paramUberMap;
  }

  @Provides
  @Singleton
  public DirectionsClient provideDirectionsClient(Bus paramBus, OkHttpClient paramOkHttpClient)
  {
    return new DirectionsClient(paramBus, paramOkHttpClient);
  }

  @Provides
  @Singleton
  public UberMap provideMap()
  {
    return this.mMap;
  }

  @Provides
  @Singleton
  public MapPolylineStyle provideMapPolylineStyle(Context paramContext)
  {
    return new MapPolylineStyle(paramContext);
  }

  @Provides
  @Singleton
  public UberBitmapDescriptorFactory provideUberBitmapDescriptorFactory()
  {
    return new UberBitmapDescriptorFactory();
  }

  @Provides
  UberMarkerOptions provideUberMarkerOptions()
  {
    return new UberMarkerOptions();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.map.layer.MapLayerModule
 * JD-Core Version:    0.6.2
 */