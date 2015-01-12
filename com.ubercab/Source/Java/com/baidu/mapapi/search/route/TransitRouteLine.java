package com.baidu.mapapi.search.route;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.a;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import com.baidu.mapapi.search.core.TaxiInfo;
import com.baidu.mapapi.search.core.VehicleInfo;
import java.util.List;

public final class TransitRouteLine extends RouteLine<TransitStep>
{
  private TaxiInfo a;

  @Deprecated
  public TaxiInfo getTaxitInfo()
  {
    return this.a;
  }

  public static class TransitStep extends RouteStep
  {
    private VehicleInfo c;
    private RouteNode d;
    private RouteNode e;
    private TransitRouteStepType f;
    private String g;
    private String h;

    void a(RouteNode paramRouteNode)
    {
      this.d = paramRouteNode;
    }

    void a(VehicleInfo paramVehicleInfo)
    {
      this.c = paramVehicleInfo;
    }

    void a(TransitRouteStepType paramTransitRouteStepType)
    {
      this.f = paramTransitRouteStepType;
    }

    void a(String paramString)
    {
      this.g = paramString;
    }

    void b(RouteNode paramRouteNode)
    {
      this.e = paramRouteNode;
    }

    void b(String paramString)
    {
      this.h = paramString;
    }

    public RouteNode getEntrace()
    {
      return this.d;
    }

    public RouteNode getExit()
    {
      return this.e;
    }

    public String getInstructions()
    {
      return this.g;
    }

    public TransitRouteStepType getStepType()
    {
      return this.f;
    }

    public VehicleInfo getVehicleInfo()
    {
      return this.c;
    }

    public List<LatLng> getWayPoints()
    {
      if (this.mWayPoints == null)
        this.mWayPoints = a.c(this.h);
      return this.mWayPoints;
    }

    public static enum TransitRouteStepType
    {
      static
      {
        TransitRouteStepType[] arrayOfTransitRouteStepType = new TransitRouteStepType[3];
        arrayOfTransitRouteStepType[0] = BUSLINE;
        arrayOfTransitRouteStepType[1] = SUBWAY;
        arrayOfTransitRouteStepType[2] = WAKLING;
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.search.route.TransitRouteLine
 * JD-Core Version:    0.6.2
 */