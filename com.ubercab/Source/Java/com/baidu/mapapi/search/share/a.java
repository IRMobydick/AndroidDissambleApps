package com.baidu.mapapi.search.share;

import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  public static ShareUrlResult a(String paramString)
  {
    ShareUrlResult localShareUrlResult = new ShareUrlResult();
    if (paramString == null)
      localShareUrlResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
    while (true)
    {
      return localShareUrlResult;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (localJSONObject != null)
        {
          localShareUrlResult.a(localJSONObject.optString("url"));
          localShareUrlResult.a(localJSONObject.optInt("type"));
          return localShareUrlResult;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        localShareUrlResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
      }
    }
    return localShareUrlResult;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.search.share.a
 * JD-Core Version:    0.6.2
 */