package com.baidu.mapapi.search.route;

import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.core.TaxiInfo;
import java.util.List;

public final class TransitRouteResult extends SearchResult
{
  private TaxiInfo a;
  private List<TransitRouteLine> b;
  private SuggestAddrInfo c;

  TransitRouteResult()
  {
  }

  TransitRouteResult(SearchResult.ERRORNO paramERRORNO)
  {
    super(paramERRORNO);
  }

  void a(TaxiInfo paramTaxiInfo)
  {
    this.a = paramTaxiInfo;
  }

  void a(SuggestAddrInfo paramSuggestAddrInfo)
  {
    this.c = paramSuggestAddrInfo;
  }

  void a(List<TransitRouteLine> paramList)
  {
    this.b = paramList;
  }

  public List<TransitRouteLine> getRouteLines()
  {
    return this.b;
  }

  public SuggestAddrInfo getSuggestAddrInfo()
  {
    return this.c;
  }

  public TaxiInfo getTaxiInfo()
  {
    return this.a;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.search.route.TransitRouteResult
 * JD-Core Version:    0.6.2
 */