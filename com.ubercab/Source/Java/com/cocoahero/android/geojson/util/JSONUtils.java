package com.cocoahero.android.geojson.util;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONUtils
{
  public static boolean isEmpty(JSONArray paramJSONArray)
  {
    return (paramJSONArray == null) || (paramJSONArray.length() <= 0);
  }

  public static boolean isEmpty(JSONObject paramJSONObject)
  {
    return (paramJSONObject == null) || (paramJSONObject.length() <= 0);
  }

  public static String optString(JSONArray paramJSONArray, int paramInt)
  {
    return optString(paramJSONArray, paramInt, null);
  }

  public static String optString(JSONArray paramJSONArray, int paramInt, String paramString)
  {
    if (paramJSONArray != null)
    {
      if (!paramJSONArray.isNull(paramInt))
        paramString = paramJSONArray.optString(paramInt, paramString);
      return paramString;
    }
    return null;
  }

  public static String optString(JSONObject paramJSONObject, String paramString)
  {
    return optString(paramJSONObject, paramString, null);
  }

  public static String optString(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if (paramJSONObject != null)
    {
      if (!paramJSONObject.isNull(paramString1))
        paramString2 = paramJSONObject.optString(paramString1, paramString2);
      return paramString2;
    }
    return null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.cocoahero.android.geojson.util.JSONUtils
 * JD-Core Version:    0.6.2
 */