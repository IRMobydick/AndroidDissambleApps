package com.ubercab.library.map;

import com.ubercab.geo.GeoManager;

public class MapVendor
{
  private GeoManager mGeoManager;

  public MapVendor(GeoManager paramGeoManager)
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
 * Qualified Name:     com.ubercab.library.map.MapVendor
 * JD-Core Version:    0.6.2
 */