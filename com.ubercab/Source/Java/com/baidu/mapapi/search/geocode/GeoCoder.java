package com.baidu.mapapi.search.geocode;

import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.platform.comapi.b.b;
import com.baidu.platform.comapi.b.d;

public class GeoCoder
{
  private d a = null;
  private OnGetGeoCoderResultListener b = null;
  private boolean c = false;
  private int d = 0;
  private int e = 0;

  GeoCoder()
  {
    this.a.a(new a(null));
  }

  public static GeoCoder newInstance()
  {
    com.baidu.mapapi.a.a().b();
    return new GeoCoder();
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

  public boolean geocode(GeoCodeOption paramGeoCodeOption)
  {
    if (this.a == null)
      throw new IllegalStateException("searcher has been destroyed");
    if ((paramGeoCodeOption == null) || (paramGeoCodeOption.b == null) || (paramGeoCodeOption.a == null))
      throw new IllegalArgumentException("option or address or city can not be null");
    this.d = this.e;
    this.e = 1;
    return this.a.b(paramGeoCodeOption.b, paramGeoCodeOption.a);
  }

  public boolean reverseGeoCode(ReverseGeoCodeOption paramReverseGeoCodeOption)
  {
    if (this.a == null)
      throw new IllegalStateException("searcher has been destroyed");
    if ((paramReverseGeoCodeOption == null) || (paramReverseGeoCodeOption.a == null))
      throw new IllegalArgumentException("option or mLocation can not be null");
    this.d = this.e;
    this.e = 2;
    return this.a.a(com.baidu.mapapi.model.a.b(paramReverseGeoCodeOption.a));
  }

  public void setOnGetGeoCodeResultListener(OnGetGeoCoderResultListener paramOnGetGeoCoderResultListener)
  {
    this.b = paramOnGetGeoCoderResultListener;
  }

  private class a
    implements b
  {
    private a()
    {
    }

    public void a(int paramInt)
    {
      if ((GeoCoder.a(GeoCoder.this)) || (GeoCoder.b(GeoCoder.this) == null))
        return;
      switch (GeoCoder.c(GeoCoder.this))
      {
      default:
        return;
      case 1:
        GeoCoder.b(GeoCoder.this).onGetGeoCodeResult(new GeoCodeResult(SearchResult.ERRORNO.RESULT_NOT_FOUND));
        return;
      case 2:
      }
      GeoCoder.b(GeoCoder.this).onGetReverseGeoCodeResult(new ReverseGeoCodeResult(SearchResult.ERRORNO.RESULT_NOT_FOUND));
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
      if ((GeoCoder.a(GeoCoder.this)) || (GeoCoder.b(GeoCoder.this) == null) || (paramString == null) || (paramString.length() <= 0))
        return;
      switch (GeoCoder.c(GeoCoder.this))
      {
      default:
        return;
      case 1:
        GeoCoder.b(GeoCoder.this).onGetGeoCodeResult(a.b(paramString));
        return;
      case 2:
      }
      GeoCoder.b(GeoCoder.this).onGetReverseGeoCodeResult(a.a(paramString));
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
 * Qualified Name:     com.baidu.mapapi.search.geocode.GeoCoder
 * JD-Core Version:    0.6.2
 */