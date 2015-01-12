package com.baidu.mapapi.search.poi;

import com.baidu.mapapi.model.LatLng;

public class PoiNearbySearchOption
{
  String a = null;
  LatLng b = null;
  int c = -1;
  float d = 12.0F;
  int e = 0;
  int f = 10;

  public PoiNearbySearchOption keyword(String paramString)
  {
    this.a = paramString;
    return this;
  }

  public PoiNearbySearchOption location(LatLng paramLatLng)
  {
    this.b = paramLatLng;
    return this;
  }

  public PoiNearbySearchOption pageCapacity(int paramInt)
  {
    this.f = paramInt;
    return this;
  }

  public PoiNearbySearchOption pageNum(int paramInt)
  {
    this.e = paramInt;
    return this;
  }

  public PoiNearbySearchOption radius(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.search.poi.PoiNearbySearchOption
 * JD-Core Version:    0.6.2
 */