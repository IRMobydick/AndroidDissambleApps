package com.baidu.mapapi.search.poi;

import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.platform.comapi.a.c;
import com.baidu.platform.comapi.b.b;
import java.util.HashMap;
import java.util.Map;

public class PoiSearch
{
  private com.baidu.platform.comapi.b.d a = null;
  private OnGetPoiSearchResultListener b = null;
  private boolean c = false;
  private int d = 0;
  private int e = 0;
  private boolean f;
  private int g = 0;

  PoiSearch()
  {
    this.a.a(new a(null));
  }

  public static PoiSearch newInstance()
  {
    com.baidu.mapapi.a.a().b();
    return new PoiSearch();
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

  public boolean searchInBound(PoiBoundSearchOption paramPoiBoundSearchOption)
  {
    if (this.a == null)
      throw new IllegalStateException("searcher has been destroyed");
    if ((paramPoiBoundSearchOption == null) || (paramPoiBoundSearchOption.a == null) || (paramPoiBoundSearchOption.b == null))
      throw new IllegalArgumentException("option or bound or keyworld can not be null");
    this.d = this.e;
    this.e = 2;
    this.g = paramPoiBoundSearchOption.d;
    this.a.a(paramPoiBoundSearchOption.e);
    c localc = new c();
    localc.b(com.baidu.mapapi.model.a.b(paramPoiBoundSearchOption.a.northeast));
    localc.a(com.baidu.mapapi.model.a.b(paramPoiBoundSearchOption.a.southwest));
    return this.a.a(paramPoiBoundSearchOption.b, 1, paramPoiBoundSearchOption.d, localc, (int)paramPoiBoundSearchOption.c, null, null);
  }

  public boolean searchInCity(PoiCitySearchOption paramPoiCitySearchOption)
  {
    if (this.a == null)
      throw new IllegalStateException("searcher has been destroyed");
    if ((paramPoiCitySearchOption == null) || (paramPoiCitySearchOption.a == null) || (paramPoiCitySearchOption.b == null))
      throw new IllegalArgumentException("option or city or keyworld can not be null");
    this.d = this.e;
    this.e = 1;
    this.g = paramPoiCitySearchOption.e;
    this.a.a(paramPoiCitySearchOption.f);
    return this.a.a(paramPoiCitySearchOption.b, paramPoiCitySearchOption.a, paramPoiCitySearchOption.e, null, (int)paramPoiCitySearchOption.c, null);
  }

  public boolean searchNearby(PoiNearbySearchOption paramPoiNearbySearchOption)
  {
    if (this.a == null)
      throw new IllegalStateException("searcher has been destroyed");
    if ((paramPoiNearbySearchOption == null) || (paramPoiNearbySearchOption.b == null) || (paramPoiNearbySearchOption.a == null))
      throw new IllegalArgumentException("option or location or keyworld can not be null");
    this.d = this.e;
    this.e = 3;
    this.g = paramPoiNearbySearchOption.e;
    this.a.a(paramPoiNearbySearchOption.f);
    com.baidu.platform.comapi.a.d locald1 = com.baidu.mapapi.model.a.b(paramPoiNearbySearchOption.b);
    com.baidu.platform.comapi.a.d locald2 = new com.baidu.platform.comapi.a.d(locald1.a - paramPoiNearbySearchOption.c, locald1.b - paramPoiNearbySearchOption.c);
    com.baidu.platform.comapi.a.d locald3 = new com.baidu.platform.comapi.a.d(locald1.a + paramPoiNearbySearchOption.c, locald1.b + paramPoiNearbySearchOption.c);
    c localc = new c();
    localc.a(locald2);
    localc.b(locald3);
    HashMap localHashMap = new HashMap();
    localHashMap.put("distance", Integer.valueOf(paramPoiNearbySearchOption.c));
    return this.a.a(paramPoiNearbySearchOption.a, 1, paramPoiNearbySearchOption.e, (int)paramPoiNearbySearchOption.d, localc, localc, localHashMap);
  }

  public boolean searchPoiDetail(PoiDetailSearchOption paramPoiDetailSearchOption)
  {
    if (this.a == null)
      throw new IllegalStateException("searcher has been destroyed");
    if ((paramPoiDetailSearchOption == null) || (paramPoiDetailSearchOption.a == null))
      throw new IllegalArgumentException("option or uid can not be null");
    this.d = this.e;
    this.e = 4;
    this.f = paramPoiDetailSearchOption.b;
    return this.a.a(paramPoiDetailSearchOption.a);
  }

  public void setOnGetPoiSearchResultListener(OnGetPoiSearchResultListener paramOnGetPoiSearchResultListener)
  {
    this.b = paramOnGetPoiSearchResultListener;
  }

  private class a
    implements b
  {
    private a()
    {
    }

    public void a(int paramInt)
    {
      if ((PoiSearch.a(PoiSearch.this)) || (PoiSearch.b(PoiSearch.this) == null))
        return;
      if (PoiSearch.d(PoiSearch.this) == 4)
      {
        PoiSearch.b(PoiSearch.this).onGetPoiDetailResult(new PoiDetailResult(SearchResult.ERRORNO.RESULT_NOT_FOUND));
        return;
      }
      PoiSearch.b(PoiSearch.this).onGetPoiResult(new PoiResult(SearchResult.ERRORNO.RESULT_NOT_FOUND));
    }

    public void a(String paramString)
    {
      if ((PoiSearch.a(PoiSearch.this)) || (paramString == null) || (paramString.length() <= 0) || (PoiSearch.b(PoiSearch.this) == null))
        return;
      PoiSearch.b(PoiSearch.this).onGetPoiResult(a.a(paramString, PoiSearch.c(PoiSearch.this)));
    }

    public void b(String paramString)
    {
      if ((paramString == null) || (paramString.length() <= 0) || (PoiSearch.b(PoiSearch.this) == null))
        return;
      PoiSearch.b(PoiSearch.this).onGetPoiResult(a.a(paramString));
    }

    public void c(String paramString)
    {
    }

    public void d(String paramString)
    {
      if ((PoiSearch.a(PoiSearch.this)) || (paramString == null) || (paramString.length() <= 0) || (PoiSearch.b(PoiSearch.this) == null))
        return;
      PoiDetailResult localPoiDetailResult = new PoiDetailResult();
      if (localPoiDetailResult.a(paramString))
      {
        PoiSearch.b(PoiSearch.this).onGetPoiDetailResult(localPoiDetailResult);
        return;
      }
      PoiSearch.b(PoiSearch.this).onGetPoiDetailResult(new PoiDetailResult(SearchResult.ERRORNO.RESULT_NOT_FOUND));
    }

    public void e(String paramString)
    {
    }

    public void f(String paramString)
    {
    }

    public void g(String paramString)
    {
    }

    public void h(String paramString)
    {
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
 * Qualified Name:     com.baidu.mapapi.search.poi.PoiSearch
 * JD-Core Version:    0.6.2
 */