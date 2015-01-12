package com.baidu.mapapi.search.busline;

public class BusLineSearchOption
{
  String a = null;
  String b = null;

  public BusLineSearchOption city(String paramString)
  {
    this.b = paramString;
    return this;
  }

  public BusLineSearchOption uid(String paramString)
  {
    this.a = paramString;
    return this;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.search.busline.BusLineSearchOption
 * JD-Core Version:    0.6.2
 */