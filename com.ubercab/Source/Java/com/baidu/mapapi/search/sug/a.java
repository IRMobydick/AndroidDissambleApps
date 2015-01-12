package com.baidu.mapapi.search.sug;

import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  public static SuggestionResult a(String paramString)
  {
    SuggestionResult localSuggestionResult = new SuggestionResult();
    if ((paramString == null) || (paramString.equals("")))
      localSuggestionResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
    while (true)
    {
      return localSuggestionResult;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        JSONArray localJSONArray1 = localJSONObject.optJSONArray("cityname");
        JSONArray localJSONArray2 = localJSONObject.optJSONArray("poiname");
        JSONArray localJSONArray3 = localJSONObject.optJSONArray("districtname");
        if ((localJSONArray2 != null) && (localJSONArray2.length() > 0))
        {
          ArrayList localArrayList = new ArrayList();
          localSuggestionResult.a(localArrayList);
          int i = localJSONArray2.length();
          for (int j = 0; j < i; j++)
          {
            SuggestionResult.SuggestionInfo localSuggestionInfo = new SuggestionResult.SuggestionInfo();
            localSuggestionInfo.city = localJSONArray1.optString(j);
            localSuggestionInfo.key = localJSONArray2.optString(j);
            localSuggestionInfo.district = localJSONArray3.optString(j);
            localArrayList.add(localSuggestionInfo);
          }
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        localSuggestionResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
      }
    }
    return localSuggestionResult;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.search.sug.a
 * JD-Core Version:    0.6.2
 */