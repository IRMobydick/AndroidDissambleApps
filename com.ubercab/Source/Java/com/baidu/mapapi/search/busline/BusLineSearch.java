package com.baidu.mapapi.search.busline;

import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.platform.comapi.b.b;
import com.baidu.platform.comapi.b.d;

public class BusLineSearch
{
  private d a = null;
  private OnGetBusLineSearchResultListener b = null;
  private boolean c = false;

  BusLineSearch()
  {
    this.a.a(new a(null));
  }

  public static BusLineSearch newInstance()
  {
    com.baidu.mapapi.a.a().b();
    return new BusLineSearch();
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

  public boolean searchBusLine(BusLineSearchOption paramBusLineSearchOption)
  {
    if (this.a == null)
      throw new IllegalStateException("searcher has been destroyed");
    if ((paramBusLineSearchOption == null) || (paramBusLineSearchOption.b == null) || (paramBusLineSearchOption.a == null))
      throw new IllegalArgumentException("option or city or uid can not be null");
    return this.a.a(paramBusLineSearchOption.b, paramBusLineSearchOption.a);
  }

  public void setOnGetBusLineSearchResultListener(OnGetBusLineSearchResultListener paramOnGetBusLineSearchResultListener)
  {
    this.b = paramOnGetBusLineSearchResultListener;
  }

  private class a
    implements b
  {
    private a()
    {
    }

    public void a(int paramInt)
    {
      if ((BusLineSearch.a(BusLineSearch.this)) || (BusLineSearch.b(BusLineSearch.this) == null))
        return;
      BusLineSearch.b(BusLineSearch.this).onGetBusLineResult(new BusLineResult(SearchResult.ERRORNO.RESULT_NOT_FOUND));
    }

    public void a(String paramString)
    {
    }

    public void b(String paramString)
    {
    }

    public void c(String paramString)
    {
    }

    public void d(String paramString)
    {
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
      if ((BusLineSearch.a(BusLineSearch.this)) || (paramString == null) || (paramString.length() <= 0) || (BusLineSearch.b(BusLineSearch.this) == null))
        return;
      BusLineSearch.b(BusLineSearch.this).onGetBusLineResult(a.a(paramString));
    }

    public void k(String paramString)
    {
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.search.busline.BusLineSearch
 * JD-Core Version:    0.6.2
 */