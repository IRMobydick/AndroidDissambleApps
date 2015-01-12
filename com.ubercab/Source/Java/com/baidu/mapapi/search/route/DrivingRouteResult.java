package com.baidu.mapapi.search.route;

import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.core.TaxiInfo;
import java.util.List;

public final class DrivingRouteResult extends SearchResult
{
  private List<DrivingRouteLine> a;
  private TaxiInfo b;
  private SuggestAddrInfo c;

  DrivingRouteResult()
  {
  }

  DrivingRouteResult(SearchResult.ERRORNO paramERRORNO)
  {
    super(paramERRORNO);
  }

  void a(TaxiInfo paramTaxiInfo)
  {
    this.b = paramTaxiInfo;
  }

  void a(SuggestAddrInfo paramSuggestAddrInfo)
  {
    this.c = paramSuggestAddrInfo;
  }

  void a(List<DrivingRouteLine> paramList)
  {
    this.a = paramList;
  }

  public List<DrivingRouteLine> getRouteLines()
  {
    return this.a;
  }

  public SuggestAddrInfo getSuggestAddrInfo()
  {
    return this.c;
  }

  public TaxiInfo getTaxiInfo()
  {
    return this.b;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.search.route.DrivingRouteResult
 * JD-Core Version:    0.6.2
 */