package com.paypal.android.sdk;

import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class n
{
  private static final String a = n.class.getSimpleName();
  private static Map b;

  static
  {
    HashMap localHashMap = new HashMap();
    b = localHashMap;
    localHashMap.put("device_identifier", R.b(b.a().c().e()));
    b.put("device_type", "Phone");
    b.put("device_name", R.b(Build.DEVICE));
    b.put("device_model", R.b(Build.MODEL));
    b.put("device_key_type", "ANDROIDCDMA_PHONE");
    b.put("device_os", "Android");
    b.put("device_os_version", R.b(String.valueOf(Build.VERSION.SDK_INT)));
    b.put("is_device_simulator", "false");
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
    return R.b(b.a().c().e());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.n
 * JD-Core Version:    0.6.2
 */