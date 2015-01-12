package com.baidu.mapapi.search.route;

import com.baidu.mapapi.model.LatLng;

public class PlanNode
{
  private LatLng a = null;
  private String b = null;
  private String c = null;

  PlanNode(LatLng paramLatLng, String paramString1, String paramString2)
  {
    this.a = paramLatLng;
    this.b = paramString1;
    this.c = paramString2;
  }

  public static PlanNode withCityNameAndPlaceName(String paramString1, String paramString2)
  {
    return new PlanNode(null, paramString1, paramString2);
  }

  public static PlanNode withLocation(LatLng paramLatLng)
  {
    return new PlanNode(paramLatLng, null, null);
  }

  LatLng a()
  {
    return this.a;
  }

  String b()
  {
    return this.b;
  }

  String c()
  {
    return this.c;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.search.route.PlanNode
 * JD-Core Version:    0.6.2
 */