package com.baidu.mapapi.search.route;

import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.platform.comapi.b.b;
import com.baidu.platform.comapi.b.d;
import com.baidu.platform.comapi.b.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class RoutePlanSearch
{
  private d a = null;
  private OnGetRoutePlanResultListener b = null;
  private boolean c = false;
  private int d = 0;
  private int e = 0;

  RoutePlanSearch()
  {
    this.a.a(new a(null));
  }

  private ArrayList<f> a(DrivingRoutePlanOption paramDrivingRoutePlanOption)
  {
    if (paramDrivingRoutePlanOption.d == null)
      return null;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramDrivingRoutePlanOption.d.iterator();
    while (localIterator.hasNext())
    {
      PlanNode localPlanNode = (PlanNode)localIterator.next();
      if ((localPlanNode != null) && ((localPlanNode.a() != null) || ((localPlanNode.c() != null) && (localPlanNode.b() != null) && (localPlanNode.c().length() > 0) && (localPlanNode.b().length() > 0))))
      {
        f localf = new f();
        if (localPlanNode.c() != null)
          localf.b = localPlanNode.c();
        if (localPlanNode.a() != null)
          localf.a = com.baidu.mapapi.model.a.b(localPlanNode.a());
        if (localPlanNode.b() == null);
        for (localf.c = ""; ; localf.c = localPlanNode.b())
        {
          localArrayList.add(localf);
          break;
        }
      }
    }
    return localArrayList;
  }

  public static RoutePlanSearch newInstance()
  {
    com.baidu.mapapi.a.a().b();
    return new RoutePlanSearch();
  }

  public void destroy()
  {
    if (this.c)
      return;
    this.c = true;
    this.b = null;
    this.a.a();
    this.a = null;
    com.baidu.mapapi.a.a().c();
  }

  public boolean drivingSearch(DrivingRoutePlanOption paramDrivingRoutePlanOption)
  {
    if (this.a == null)
      throw new IllegalStateException("searcher has been destroyed");
    if ((paramDrivingRoutePlanOption == null) || (paramDrivingRoutePlanOption.b == null) || (paramDrivingRoutePlanOption.a == null))
      throw new IllegalArgumentException("route plan option , origin or destination can not be null");
    if (paramDrivingRoutePlanOption.c == null)
      paramDrivingRoutePlanOption.c = DrivingRoutePlanOption.DrivingPolicy.ECAR_TIME_FIRST;
    com.baidu.platform.comapi.b.a locala1 = new com.baidu.platform.comapi.b.a();
    if (paramDrivingRoutePlanOption.a.c() != null)
      locala1.c = paramDrivingRoutePlanOption.a.c();
    if (paramDrivingRoutePlanOption.a.a() != null)
    {
      locala1.b = com.baidu.mapapi.model.a.b(paramDrivingRoutePlanOption.a.a());
      locala1.a = 1;
    }
    com.baidu.platform.comapi.b.a locala2 = new com.baidu.platform.comapi.b.a();
    if (paramDrivingRoutePlanOption.b.c() != null)
      locala2.c = paramDrivingRoutePlanOption.b.c();
    if (paramDrivingRoutePlanOption.b.a() != null)
    {
      locala2.b = com.baidu.mapapi.model.a.b(paramDrivingRoutePlanOption.b.a());
      locala2.a = 1;
    }
    this.d = this.e;
    this.e = 2;
    return this.a.a(locala1, locala2, null, paramDrivingRoutePlanOption.a.b(), paramDrivingRoutePlanOption.b.b(), null, 12, paramDrivingRoutePlanOption.c.getInt(), 0, a(paramDrivingRoutePlanOption), null);
  }

  public void setOnGetRoutePlanResultListener(OnGetRoutePlanResultListener paramOnGetRoutePlanResultListener)
  {
    this.b = paramOnGetRoutePlanResultListener;
  }

  public boolean transitSearch(TransitRoutePlanOption paramTransitRoutePlanOption)
  {
    if (this.a == null)
      throw new IllegalStateException("searcher has been destroyed");
    if ((paramTransitRoutePlanOption == null) || (paramTransitRoutePlanOption.c == null) || (paramTransitRoutePlanOption.b == null) || (paramTransitRoutePlanOption.a == null))
      throw new IllegalArgumentException("route plan option,origin or destination or city can not be null");
    if (paramTransitRoutePlanOption.d == null)
      paramTransitRoutePlanOption.d = TransitRoutePlanOption.TransitPolicy.EBUS_TIME_FIRST;
    com.baidu.platform.comapi.b.a locala1 = new com.baidu.platform.comapi.b.a();
    if (paramTransitRoutePlanOption.a.c() != null)
      locala1.c = paramTransitRoutePlanOption.a.c();
    if (paramTransitRoutePlanOption.a.a() != null)
    {
      locala1.b = com.baidu.mapapi.model.a.b(paramTransitRoutePlanOption.a.a());
      locala1.a = 1;
    }
    com.baidu.platform.comapi.b.a locala2 = new com.baidu.platform.comapi.b.a();
    if (paramTransitRoutePlanOption.b.c() != null)
      locala2.c = paramTransitRoutePlanOption.b.c();
    if (paramTransitRoutePlanOption.b.a() != null)
    {
      locala2.b = com.baidu.mapapi.model.a.b(paramTransitRoutePlanOption.b.a());
      locala2.a = 1;
    }
    this.d = this.e;
    this.e = 0;
    return this.a.a(locala1, locala2, paramTransitRoutePlanOption.c, null, 12, paramTransitRoutePlanOption.d.getInt(), null);
  }

  public boolean walkingSearch(WalkingRoutePlanOption paramWalkingRoutePlanOption)
  {
    if (this.a == null)
      throw new IllegalStateException("searcher has been destroyed");
    if ((paramWalkingRoutePlanOption == null) || (paramWalkingRoutePlanOption.b == null) || (paramWalkingRoutePlanOption.a == null))
      throw new IllegalArgumentException("option , origin or destination can not be null");
    com.baidu.platform.comapi.b.a locala1 = new com.baidu.platform.comapi.b.a();
    if (paramWalkingRoutePlanOption.a.c() != null)
      locala1.c = paramWalkingRoutePlanOption.a.c();
    if (paramWalkingRoutePlanOption.a.a() != null)
    {
      locala1.b = com.baidu.mapapi.model.a.b(paramWalkingRoutePlanOption.a.a());
      locala1.a = 1;
    }
    com.baidu.platform.comapi.b.a locala2 = new com.baidu.platform.comapi.b.a();
    if (paramWalkingRoutePlanOption.b.c() != null)
      locala2.c = paramWalkingRoutePlanOption.b.c();
    if (paramWalkingRoutePlanOption.b.a() != null)
    {
      locala2.b = com.baidu.mapapi.model.a.b(paramWalkingRoutePlanOption.b.a());
      locala2.a = 1;
    }
    this.d = this.e;
    this.e = 1;
    return this.a.a(locala1, locala2, null, paramWalkingRoutePlanOption.a.b(), paramWalkingRoutePlanOption.b.b(), null, 12, null);
  }

  private class a
    implements b
  {
    private a()
    {
    }

    public void a(int paramInt)
    {
      if ((RoutePlanSearch.a(RoutePlanSearch.this)) || (RoutePlanSearch.b(RoutePlanSearch.this) == null))
        return;
      SearchResult.ERRORNO localERRORNO = null;
      switch (paramInt)
      {
      default:
      case 11:
      case 12:
      case 13:
      case 14:
      case 3:
      }
      while (localERRORNO != null)
        switch (RoutePlanSearch.c(RoutePlanSearch.this))
        {
        default:
          return;
        case 0:
          RoutePlanSearch.b(RoutePlanSearch.this).onGetTransitRouteResult(new TransitRouteResult(localERRORNO));
          return;
          localERRORNO = SearchResult.ERRORNO.RESULT_NOT_FOUND;
          continue;
          localERRORNO = SearchResult.ERRORNO.NOT_SUPPORT_BUS;
          continue;
          localERRORNO = SearchResult.ERRORNO.NOT_SUPPORT_BUS_2CITY;
          continue;
          localERRORNO = SearchResult.ERRORNO.ST_EN_TOO_NEAR;
          continue;
          localERRORNO = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        case 2:
        case 1:
        }
      RoutePlanSearch.b(RoutePlanSearch.this).onGetDrivingRouteResult(new DrivingRouteResult(localERRORNO));
      return;
      RoutePlanSearch.b(RoutePlanSearch.this).onGetWalkingRouteResult(new WalkingRouteResult(localERRORNO));
    }

    public void a(String paramString)
    {
    }

    public void b(String paramString)
    {
    }

    public void c(String paramString)
    {
      if ((RoutePlanSearch.a(RoutePlanSearch.this)) || (paramString == null) || (paramString.length() == 0) || (RoutePlanSearch.b(RoutePlanSearch.this) == null))
        return;
      switch (RoutePlanSearch.c(RoutePlanSearch.this))
      {
      default:
        return;
      case 0:
        TransitRouteResult localTransitRouteResult = new TransitRouteResult(SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR);
        localTransitRouteResult.a(a.f(paramString));
        RoutePlanSearch.b(RoutePlanSearch.this).onGetTransitRouteResult(localTransitRouteResult);
        return;
      case 2:
        DrivingRouteResult localDrivingRouteResult = new DrivingRouteResult(SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR);
        localDrivingRouteResult.a(a.f(paramString));
        RoutePlanSearch.b(RoutePlanSearch.this).onGetDrivingRouteResult(localDrivingRouteResult);
        return;
      case 1:
      }
      WalkingRouteResult localWalkingRouteResult = new WalkingRouteResult(SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR);
      localWalkingRouteResult.a(a.f(paramString));
      RoutePlanSearch.b(RoutePlanSearch.this).onGetWalkingRouteResult(localWalkingRouteResult);
    }

    public void d(String paramString)
    {
    }

    public void e(String paramString)
    {
    }

    public void f(String paramString)
    {
      if ((RoutePlanSearch.a(RoutePlanSearch.this)) || (paramString == null) || (paramString.length() == 0) || (RoutePlanSearch.b(RoutePlanSearch.this) == null))
        return;
      RoutePlanSearch.b(RoutePlanSearch.this).onGetDrivingRouteResult(a.b(paramString));
    }

    public void g(String paramString)
    {
      if ((RoutePlanSearch.a(RoutePlanSearch.this)) || (paramString == null) || (paramString.length() == 0) || (RoutePlanSearch.b(RoutePlanSearch.this) == null))
        return;
      RoutePlanSearch.b(RoutePlanSearch.this).onGetWalkingRouteResult(a.c(paramString));
    }

    public void h(String paramString)
    {
      if ((RoutePlanSearch.a(RoutePlanSearch.this)) || (paramString == null) || (paramString.length() == 0) || (RoutePlanSearch.b(RoutePlanSearch.this) == null))
        return;
      RoutePlanSearch.b(RoutePlanSearch.this).onGetTransitRouteResult(a.a(paramString));
    }

    public void i(String paramString)
    {
    }

    public void j(String paramString)
    {
    }

    public void k(String paramString)
    {
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.search.route.RoutePlanSearch
 * JD-Core Version:    0.6.2
 */