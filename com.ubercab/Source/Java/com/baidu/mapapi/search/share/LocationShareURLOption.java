package com.baidu.mapapi.search.share;

import com.baidu.mapapi.model.LatLng;

public class LocationShareURLOption
{
  LatLng a = null;
  String b = null;
  String c = null;

  public LocationShareURLOption location(LatLng paramLatLng)
  {
    this.a = paramLatLng;
    return this;
  }

  public LocationShareURLOption name(String paramString)
  {
    this.b = paramString;
    return this;
  }

  public LocationShareURLOption snippet(String paramString)
  {
    this.c = paramString;
    return this;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.search.share.LocationShareURLOption
 * JD-Core Version:    0.6.2
 */