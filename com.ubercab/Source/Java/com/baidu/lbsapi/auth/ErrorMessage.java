package com.baidu.lbsapi.auth;

import org.json.JSONException;
import org.json.JSONObject;

class ErrorMessage
{
  static String a(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("status", -1);
      localJSONObject.put("message", paramString);
      label24: return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      break label24;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.lbsapi.auth.ErrorMessage
 * JD-Core Version:    0.6.2
 */