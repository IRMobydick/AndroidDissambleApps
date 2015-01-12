package com.paypal.android.sdk;

import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class i
{
  private static final String a = i.class.getSimpleName();
  private static Map b;

  static
  {
    HashMap localHashMap = new HashMap();
    b = localHashMap;
    localHashMap.put("app_version", "2.0");
    b.put("app_category", "1");
    c localc = b.a().c();
    if (localc.b() == 1)
      b.put("client_platform", "AndroidGSM");
    while (true)
    {
      b.put("device_app_id", localc.c());
      return;
      if (localc.b() == 2)
        b.put("client_platform", "AndroidCDMA");
      else
        b.put("client_platform", "AndroidOther");
    }
  }

  public static JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      Iterator localIterator = b.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localJSONObject.put(str, b.get(str));
      }
    }
    catch (JSONException localJSONException)
    {
      Log.e(a, "Error encoding JSON", localJSONException);
      return null;
    }
    return localJSONObject;
  }

  public static String b()
  {
    return (String)b.get("device_app_id");
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.i
 * JD-Core Version:    0.6.2
 */