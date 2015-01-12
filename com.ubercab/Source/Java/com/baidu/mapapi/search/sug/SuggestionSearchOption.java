package com.baidu.mapapi.search.sug;

import com.baidu.mapapi.model.LatLng;

public class SuggestionSearchOption
{
  String a = null;
  String b = null;
  LatLng c = null;

  public SuggestionSearchOption city(String paramString)
  {
    this.a = paramString;
    return this;
  }

  public SuggestionSearchOption keyword(String paramString)
  {
    this.b = paramString;
    return this;
  }

  public SuggestionSearchOption location(LatLng paramLatLng)
  {
    this.c = paramLatLng;
    return this;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.search.sug.SuggestionSearchOption
 * JD-Core Version:    0.6.2
 */