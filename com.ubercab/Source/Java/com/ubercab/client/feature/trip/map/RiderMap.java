package com.ubercab.client.feature.trip.map;

import com.ubercab.library.location.model.UberLatLng;
import java.util.List;

abstract interface RiderMap
{
  public abstract void applyCameraUpdate(RiderCameraUpdate paramRiderCameraUpdate);

  public abstract List<UberLatLng> getAdditionalRouteBounds();

  public abstract List<UberLatLng> getRoutePoints();

  public abstract void onMapCameraTrackingChanged(boolean paramBoolean);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.map.RiderMap
 * JD-Core Version:    0.6.2
 */