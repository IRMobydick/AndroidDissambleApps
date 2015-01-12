package com.baidu.mapapi.search.sug;

import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.platform.comapi.b.b;
import com.baidu.platform.comapi.b.d;

public class SuggestionSearch
{
  private d a = null;
  private OnGetSuggestionResultListener b = null;
  private boolean c = false;

  SuggestionSearch()
  {
    this.a.a(new a(null));
  }

  public static SuggestionSearch newInstance()
  {
    com.baidu.mapapi.a.a().b();
    return new SuggestionSearch();
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

  public boolean requestSuggestion(SuggestionSearchOption paramSuggestionSearchOption)
  {
    if (this.a == null)
      throw new IllegalStateException("searcher has been destroyed");
    if ((paramSuggestionSearchOption == null) || (paramSuggestionSearchOption.b == null) || (paramSuggestionSearchOption.a == null))
      throw new IllegalArgumentException("option or keyword or city can not be null");
    return this.a.a(paramSuggestionSearchOption.b, 0, paramSuggestionSearchOption.a, null, 12, com.baidu.mapapi.model.a.b(paramSuggestionSearchOption.c));
  }

  public void setOnGetSuggestionResultListener(OnGetSuggestionResultListener paramOnGetSuggestionResultListener)
  {
    this.b = paramOnGetSuggestionResultListener;
  }

  private class a
    implements b
  {
    private a()
    {
    }

    public void a(int paramInt)
    {
      if ((SuggestionSearch.a(SuggestionSearch.this)) || (SuggestionSearch.b(SuggestionSearch.this) == null))
        return;
      SuggestionSearch.b(SuggestionSearch.this).onGetSuggestionResult(new SuggestionResult(SearchResult.ERRORNO.RESULT_NOT_FOUND));
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
    }

    public void k(String paramString)
    {
      if ((SuggestionSearch.a(SuggestionSearch.this)) || (paramString == null) || (paramString.length() <= 0) || (SuggestionSearch.b(SuggestionSearch.this) == null))
        return;
      SuggestionSearch.b(SuggestionSearch.this).onGetSuggestionResult(a.a(paramString));
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.search.sug.SuggestionSearch
 * JD-Core Version:    0.6.2
 */