package com.baidu.mapapi.search.route;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.a;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import java.util.List;

public class WalkingRouteLine extends RouteLine<WalkingStep>
{
  public List<WalkingStep> getAllStep()
  {
    return super.getAllStep();
  }

  public static class WalkingStep extends RouteStep
  {
    private int c;
    private RouteNode d;
    private RouteNode e;
    private String f;
    private String g;
    private String h;
    private String i;

    void a(int paramInt)
    {
      this.c = paramInt;
    }

    void a(RouteNode paramRouteNode)
    {
      this.d = paramRouteNode;
    }

    void a(String paramString)
    {
      this.f = paramString;
    }

    void b(RouteNode paramRouteNode)
    {
      this.e = paramRouteNode;
    }

    void b(String paramString)
    {
      this.g = paramString;
    }

    void c(String paramString)
    {
      this.h = paramString;
    }

    void d(String paramString)
    {
      this.i = paramString;
    }

    public int getDirection()
    {
      return this.c;
    }

    public RouteNode getEntrace()
    {
      return this.d;
    }

    public String getEntraceInstructions()
    {
      return this.g;
    }

    public RouteNode getExit()
    {
      return this.e;
    }

    public String getExitInstructions()
    {
      return this.h;
    }

    public String getInstructions()
    {
      return this.i;
    }

    public List<LatLng> getWayPoints()
    {
      if (this.mWayPoints == null)
        this.mWayPoints = a.c(this.f);
      return this.mWayPoints;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.search.route.WalkingRouteLine
 * JD-Core Version:    0.6.2
 */