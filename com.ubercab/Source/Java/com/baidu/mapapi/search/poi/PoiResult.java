package com.baidu.mapapi.search.poi;

import com.baidu.mapapi.search.core.CityInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import java.util.List;

public class PoiResult extends SearchResult
{
  private int a = 0;
  private int b = 0;
  private int c = 0;
  private int d = 0;
  private List<PoiInfo> e;
  private List<CityInfo> f;

  PoiResult()
  {
  }

  PoiResult(SearchResult.ERRORNO paramERRORNO)
  {
    super(paramERRORNO);
  }

  void a(int paramInt)
  {
    this.a = paramInt;
  }

  void a(List<PoiInfo> paramList)
  {
    this.e = paramList;
  }

  void b(int paramInt)
  {
    this.b = paramInt;
  }

  void b(List<CityInfo> paramList)
  {
    this.f = paramList;
  }

  void c(int paramInt)
  {
    this.c = paramInt;
  }

  void d(int paramInt)
  {
    this.d = paramInt;
  }

  public List<PoiInfo> getAllPoi()
  {
    return this.e;
  }

  public int getCurrentPageCapacity()
  {
    return this.c;
  }

  public int getCurrentPageNum()
  {
    return this.a;
  }

  public List<CityInfo> getSuggestCityList()
  {
    return this.f;
  }

  public int getTotalPageNum()
  {
    return this.b;
  }

  public int getTotalPoiNum()
  {
    return this.d;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.search.poi.PoiResult
 * JD-Core Version:    0.6.2
 */