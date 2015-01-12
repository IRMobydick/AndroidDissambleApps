package com.baidu.mapapi.search.core;

import com.baidu.mapapi.model.LatLng;
import java.util.List;

public class RouteStep
{
  int a;
  int b;
  protected List<LatLng> mWayPoints;

  public int getDistance()
  {
    return this.a;
  }

  public int getDuration()
  {
    return this.b;
  }

  public List<LatLng> getWayPoints()
  {
    return this.mWayPoints;
  }

  public void setDistance(int paramInt)
  {
    this.a = paramInt;
  }

  public void setDuration(int paramInt)
  {
    this.b = paramInt;
  }

  public void setWayPoints(List<LatLng> paramList)
  {
    this.mWayPoints = paramList;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.search.core.RouteStep
 * JD-Core Version:    0.6.2
 */