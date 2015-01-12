package com.baidu.mapapi.search.core;

import java.util.List;

public class RouteLine<T extends RouteStep>
{
  private RouteNode a;
  private RouteNode b;
  private String c;
  private List<T> d;
  private int e;
  private int f;

  public List<T> getAllStep()
  {
    return this.d;
  }

  public int getDistance()
  {
    return this.e;
  }

  public int getDuration()
  {
    return this.f;
  }

  public RouteNode getStarting()
  {
    return this.a;
  }

  public RouteNode getTerminal()
  {
    return this.b;
  }

  public String getTitle()
  {
    return this.c;
  }

  public void setDistance(int paramInt)
  {
    this.e = paramInt;
  }

  public void setDuration(int paramInt)
  {
    this.f = paramInt;
  }

  public void setStarting(RouteNode paramRouteNode)
  {
    this.a = paramRouteNode;
  }

  public void setSteps(List<T> paramList)
  {
    this.d = paramList;
  }

  public void setTerminal(RouteNode paramRouteNode)
  {
    this.b = paramRouteNode;
  }

  public void setTitle(String paramString)
  {
    this.c = paramString;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.search.core.RouteLine
 * JD-Core Version:    0.6.2
 */