package com.baidu.mapapi.search.share;

import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;

public class ShareUrlResult extends SearchResult
{
  private String a;
  private int b;

  ShareUrlResult()
  {
  }

  ShareUrlResult(SearchResult.ERRORNO paramERRORNO)
  {
    super(paramERRORNO);
  }

  void a(int paramInt)
  {
    this.b = paramInt;
  }

  void a(String paramString)
  {
    this.a = paramString;
  }

  public String getUrl()
  {
    return this.a;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.search.share.ShareUrlResult
 * JD-Core Version:    0.6.2
 */