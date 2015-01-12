package com.ubercab.client.core.util;

import com.ubercab.library.location.model.UberLatLng;

public final class LatLngInterpolator
{
  public static UberLatLng linear(float paramFloat, UberLatLng paramUberLatLng1, UberLatLng paramUberLatLng2)
  {
    return new UberLatLng((paramUberLatLng2.getLatitude() - paramUberLatLng1.getLatitude()) * paramFloat + paramUberLatLng1.getLatitude(), (paramUberLatLng2.getLongitude() - paramUberLatLng1.getLongitude()) * paramFloat + paramUberLatLng1.getLongitude());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.util.LatLngInterpolator
 * JD-Core Version:    0.6.2
 */