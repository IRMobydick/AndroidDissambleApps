package com.baidu.mapapi.search.route;

import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.core.TaxiInfo;
import java.util.List;

public class WalkingRouteResult extends SearchResult
{
  private List<WalkingRouteLine> a;
  private TaxiInfo b;
  private SuggestAddrInfo c;

  WalkingRouteResult()
  {
  }

  WalkingRouteResult(SearchResult.ERRORNO paramERRORNO)
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

  void a(List<WalkingRouteLine> paramList)
  {
    this.a = paramList;
  }

  public List<WalkingRouteLine> getRouteLines()
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
 * Qualified Name:     com.baidu.mapapi.search.route.WalkingRouteResult
 * JD-Core Version:    0.6.2
 */