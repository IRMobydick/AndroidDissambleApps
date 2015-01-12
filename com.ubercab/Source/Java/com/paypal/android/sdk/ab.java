package com.paypal.android.sdk;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class ab extends al
{
  public ab(a parama, L paramL, d paramd, h paramh, String paramString)
  {
    super(parama, paramL, paramd, paramh);
    a("Authorization", paramString);
    a("User-Agent", t().d());
  }

  protected final void a(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.getString("name");
    String str2 = paramJSONObject.getString("message");
    String str3 = "";
    String str4 = "";
    try
    {
      JSONObject localJSONObject = paramJSONObject.getJSONArray("details").getJSONObject(0);
      str3 = localJSONObject.getString("field");
      str4 = localJSONObject.getString("issue");
      if ((str1.equals("VALIDATION_ERROR")) && (str3.contains("amount.currency")))
        str1 = "pp_service_error_bad_currency";
      String str8 = str4;
      str6 = str3;
      str7 = str1;
      localObject = str8;
      a(str7, str2, "field:" + str6 + ", issue:" + (String)localObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      while (true)
      {
        String str5 = str4;
        String str6 = str3;
        String str7 = str1;
        Object localObject = str5;
      }
    }
  }

  protected final void b(JSONObject paramJSONObject)
  {
    a(paramJSONObject.getString("error"), paramJSONObject.getString("error_description"), null);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.ab
 * JD-Core Version:    0.6.2
 */