package com.baidu.mapapi.search.geocode;

import com.baidu.mapapi.model.LatLng;

public class ReverseGeoCodeOption
{
  LatLng a = null;

  public ReverseGeoCodeOption location(LatLng paramLatLng)
  {
    this.a = paramLatLng;
    return this;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.search.geocode.ReverseGeoCodeOption
 * JD-Core Version:    0.6.2
 */