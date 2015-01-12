package com.baidu.mapapi.search.share;

import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.platform.comapi.b.b;
import com.baidu.platform.comapi.b.d;

public class ShareUrlSearch
{
  private d a = null;
  private OnGetShareUrlResultListener b = null;
  private boolean c = false;
  private int d = 0;
  private int e = 0;

  ShareUrlSearch()
  {
    this.a.a(new a(null));
  }

  public static ShareUrlSearch newInstance()
  {
    com.baidu.mapapi.a.a().b();
    return new ShareUrlSearch();
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

  public boolean requestLocationShareUrl(LocationShareURLOption paramLocationShareURLOption)
  {
    if (this.a == null)
      throw new IllegalStateException("searcher has been destroyed");
    if ((paramLocationShareURLOption == null) || (paramLocationShareURLOption.a == null) || (paramLocationShareURLOption.b == null) || (paramLocationShareURLOption.c == null))
      throw new IllegalArgumentException("option or name or snippet  can not be null");
    this.d = this.e;
    this.e = 2;
    return this.a.a(com.baidu.mapapi.model.a.b(paramLocationShareURLOption.a), paramLocationShareURLOption.b, paramLocationShareURLOption.c);
  }

  public boolean requestPoiDetailShareUrl(PoiDetailShareURLOption paramPoiDetailShareURLOption)
  {
    if (this.a == null)
      throw new IllegalStateException("searcher has been destroyed");
    if ((paramPoiDetailShareURLOption == null) || (paramPoiDetailShareURLOption.a == null))
      throw new IllegalArgumentException("option or uid can not be null");
    this.d = this.e;
    this.e = 1;
    return this.a.b(paramPoiDetailShareURLOption.a);
  }

  public void setOnGetShareUrlResultListener(OnGetShareUrlResultListener paramOnGetShareUrlResultListener)
  {
    this.b = paramOnGetShareUrlResultListener;
  }

  private class a
    implements b
  {
    private a()
    {
    }

    public void a(int paramInt)
    {
      if ((ShareUrlSearch.a(ShareUrlSearch.this)) || (ShareUrlSearch.b(ShareUrlSearch.this) == null))
        return;
      switch (ShareUrlSearch.c(ShareUrlSearch.this))
      {
      default:
        return;
      case 1:
        ShareUrlSearch.b(ShareUrlSearch.this).onGetPoiDetailShareUrlResult(new ShareUrlResult(SearchResult.ERRORNO.RESULT_NOT_FOUND));
        return;
      case 2:
      }
      ShareUrlSearch.b(ShareUrlSearch.this).onGetLocationShareUrlResult(new ShareUrlResult(SearchResult.ERRORNO.RESULT_NOT_FOUND));
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
      if ((ShareUrlSearch.a(ShareUrlSearch.this)) || (ShareUrlSearch.b(ShareUrlSearch.this) == null))
        return;
      switch (ShareUrlSearch.c(ShareUrlSearch.this))
      {
      default:
        return;
      case 1:
        ShareUrlSearch.b(ShareUrlSearch.this).onGetPoiDetailShareUrlResult(a.a(paramString));
        return;
      case 2:
      }
      ShareUrlSearch.b(ShareUrlSearch.this).onGetLocationShareUrlResult(a.a(paramString));
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
 * Qualified Name:     com.baidu.mapapi.search.share.ShareUrlSearch
 * JD-Core Version:    0.6.2
 */