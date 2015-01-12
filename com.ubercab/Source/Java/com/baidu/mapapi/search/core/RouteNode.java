package com.baidu.mapapi.search.core;

import com.baidu.mapapi.model.LatLng;

public class RouteNode
{
  private String a;
  private LatLng b;
  private String c;

  public static RouteNode location(LatLng paramLatLng)
  {
    RouteNode localRouteNode = new RouteNode();
    localRouteNode.setLocation(paramLatLng);
    return localRouteNode;
  }

  public static RouteNode titleAndLocation(String paramString, LatLng paramLatLng)
  {
    RouteNode localRouteNode = new RouteNode();
    localRouteNode.setTitle(paramString);
    localRouteNode.setLocation(paramLatLng);
    return localRouteNode;
  }

  public LatLng getLocation()
  {
    return this.b;
  }

  public String getTitle()
  {
    return this.a;
  }

  public String getUid()
  {
    return this.c;
  }

  public void setLocation(LatLng paramLatLng)
  {
    this.b = paramLatLng;
  }

  public void setTitle(String paramString)
  {
    this.a = paramString;
  }

  public void setUid(String paramString)
  {
    this.c = paramString;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.search.core.RouteNode
 * JD-Core Version:    0.6.2
 */