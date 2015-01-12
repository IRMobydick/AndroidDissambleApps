package com.baidu.mapapi.search.geocode;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;

public class GeoCodeResult extends SearchResult
{
  private LatLng a;
  private String b;

  GeoCodeResult()
  {
  }

  GeoCodeResult(SearchResult.ERRORNO paramERRORNO)
  {
    super(paramERRORNO);
  }

  void a(LatLng paramLatLng)
  {
    this.a = paramLatLng;
  }

  public String getAddress()
  {
    return this.b;
  }

  public LatLng getLocation()
  {
    return this.a;
  }

  public void setAddress(String paramString)
  {
    this.b = paramString;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.search.geocode.GeoCodeResult
 * JD-Core Version:    0.6.2
 */