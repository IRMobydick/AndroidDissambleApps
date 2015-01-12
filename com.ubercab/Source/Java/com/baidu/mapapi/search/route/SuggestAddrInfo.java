package com.baidu.mapapi.search.route;

import com.baidu.mapapi.search.core.CityInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import java.util.List;

public class SuggestAddrInfo
{
  private List<PoiInfo> a;
  private List<PoiInfo> b;
  private List<List<PoiInfo>> c;
  private List<CityInfo> d;
  private List<CityInfo> e;
  private List<List<CityInfo>> f;

  void a(List<PoiInfo> paramList)
  {
    this.a = paramList;
  }

  void b(List<PoiInfo> paramList)
  {
    this.b = paramList;
  }

  void c(List<List<PoiInfo>> paramList)
  {
    this.c = paramList;
  }

  void d(List<CityInfo> paramList)
  {
    this.d = paramList;
  }

  void e(List<CityInfo> paramList)
  {
    this.e = paramList;
  }

  void f(List<List<CityInfo>> paramList)
  {
    this.f = paramList;
  }

  public List<CityInfo> getSuggestEndCity()
  {
    return this.e;
  }

  public List<PoiInfo> getSuggestEndNode()
  {
    return this.b;
  }

  public List<CityInfo> getSuggestStartCity()
  {
    return this.d;
  }

  public List<PoiInfo> getSuggestStartNode()
  {
    return this.a;
  }

  public List<List<CityInfo>> getSuggestWpCity()
  {
    return this.f;
  }

  public List<List<PoiInfo>> getSuggestWpNode()
  {
    return this.c;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.search.route.SuggestAddrInfo
 * JD-Core Version:    0.6.2
 */