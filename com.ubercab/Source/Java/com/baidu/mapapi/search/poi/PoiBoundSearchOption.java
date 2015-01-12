package com.baidu.mapapi.search.poi;

import com.baidu.mapapi.model.LatLngBounds;

public class PoiBoundSearchOption
{
  LatLngBounds a = null;
  String b = null;
  float c = 12.0F;
  int d = 0;
  int e = 10;

  public PoiBoundSearchOption bound(LatLngBounds paramLatLngBounds)
  {
    this.a = paramLatLngBounds;
    return this;
  }

  public PoiBoundSearchOption keyword(String paramString)
  {
    this.b = paramString;
    return this;
  }

  public PoiBoundSearchOption pageCapacity(int paramInt)
  {
    this.e = paramInt;
    return this;
  }

  public PoiBoundSearchOption pageNum(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.search.poi.PoiBoundSearchOption
 * JD-Core Version:    0.6.2
 */