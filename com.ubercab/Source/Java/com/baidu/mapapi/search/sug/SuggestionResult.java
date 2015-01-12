package com.baidu.mapapi.search.sug;

import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import java.util.ArrayList;
import java.util.List;

public class SuggestionResult extends SearchResult
{
  private ArrayList<SuggestionInfo> a;

  public SuggestionResult()
  {
  }

  SuggestionResult(SearchResult.ERRORNO paramERRORNO)
  {
    super(paramERRORNO);
  }

  void a(ArrayList<SuggestionInfo> paramArrayList)
  {
    this.a = paramArrayList;
  }

  public List<SuggestionInfo> getAllSuggestions()
  {
    return this.a;
  }

  public static class SuggestionInfo
  {
    public String city;
    public String district;
    public String key;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.search.sug.SuggestionResult
 * JD-Core Version:    0.6.2
 */