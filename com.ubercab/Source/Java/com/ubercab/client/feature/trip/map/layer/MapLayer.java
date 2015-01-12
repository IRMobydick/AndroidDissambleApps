package com.ubercab.client.feature.trip.map.layer;

import android.os.Bundle;
import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.map.UberMarker;
import java.util.List;

public abstract interface MapLayer
{
  public abstract List<UberLatLng> getAdditionalRouteBounds();

  public abstract List<UberLatLng> getRoutePoints();

  public abstract void onMarkerClick(UberMarker paramUberMarker);

  public abstract void saveInstanceState(Bundle paramBundle);

  public abstract void start();

  public abstract void stop();
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.map.layer.MapLayer
 * JD-Core Version:    0.6.2
 */