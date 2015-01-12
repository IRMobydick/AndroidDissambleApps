package com.ubercab.client.feature.trip.map;

import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.util.LocationUtils;
import java.util.List;
import timber.log.Timber;
import timber.log.Timber.Tree;

public final class MapUtils
{
  public static List<UberLatLng> decodePolyline(String paramString)
  {
    try
    {
      List localList = LocationUtils.decode(paramString);
      return localList;
    }
    catch (Exception localException)
    {
      Timber.tag("MapFragment").e(localException, "Failed to decode polyline: %s", new Object[] { paramString });
    }
    return null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.map.MapUtils
 * JD-Core Version:    0.6.2
 */