package com.ubercab.client.feature.trip.map.layer;

import android.os.Bundle;
import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.map.UberMarker;
import java.util.List;

public abstract class BaseMapLayer
  implements MapLayer
{
  public List<UberLatLng> getAdditionalRouteBounds()
  {
    return null;
  }

  public List<UberLatLng> getRoutePoints()
  {
    return null;
  }

  public void onMarkerClick(UberMarker paramUberMarker)
  {
  }

  public void saveInstanceState(Bundle paramBundle)
  {
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.map.layer.BaseMapLayer
 * JD-Core Version:    0.6.2
 */