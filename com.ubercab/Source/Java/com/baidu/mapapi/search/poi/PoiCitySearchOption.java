package com.baidu.mapapi.search.poi;

import com.baidu.mapapi.model.LatLng;

public class PoiCitySearchOption
{
  String a = null;
  String b = null;
  float c = 12.0F;
  LatLng d = null;
  int e = 0;
  int f = 10;

  public PoiCitySearchOption city(String paramString)
  {
    this.a = paramString;
    return this;
  }

  public PoiCitySearchOption keyword(String paramString)
  {
    this.b = paramString;
    return this;
  }

  public PoiCitySearchOption pageCapacity(int paramInt)
  {
    this.f = paramInt;
    return this;
  }

  public PoiCitySearchOption pageNum(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.search.poi.PoiCitySearchOption
 * JD-Core Version:    0.6.2
 */