package com.baidu.mapapi.search.geocode;

public class GeoCodeOption
{
  String a = null;
  String b = null;

  public GeoCodeOption address(String paramString)
  {
    this.b = paramString;
    return this;
  }

  public GeoCodeOption city(String paramString)
  {
    this.a = paramString;
    return this;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.search.geocode.GeoCodeOption
 * JD-Core Version:    0.6.2
 */