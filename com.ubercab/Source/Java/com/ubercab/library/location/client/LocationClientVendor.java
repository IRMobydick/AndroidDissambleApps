package com.ubercab.library.location.client;

import com.ubercab.geo.GeoManager;

public class LocationClientVendor
{
  private GeoManager mGeoManager;

  public LocationClientVendor(GeoManager paramGeoManager)
  {
    this.mGeoManager = paramGeoManager;
  }

  public String getName()
  {
    switch (this.mGeoManager.getGeo())
    {
    default:
      return "google";
    case 3:
    }
    return "baidu";
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.location.client.LocationClientVendor
 * JD-Core Version:    0.6.2
 */