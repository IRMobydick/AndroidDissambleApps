package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

@ez
public final class ed
{
  public static String D(String paramString)
  {
    if (paramString == null)
      return null;
    try
    {
      String str = new JSONObject(paramString).getString("developerPayload");
      return str;
    }
    catch (JSONException localJSONException)
    {
      gs.W("Fail to parse purchase data");
    }
    return null;
  }

  public static String E(String paramString)
  {
    if (paramString == null)
      return null;
    try
    {
      String str = new JSONObject(paramString).getString("purchaseToken");
      return str;
    }
    catch (JSONException localJSONException)
    {
      gs.W("Fail to parse purchase data");
    }
    return null;
  }

  public static int b(Bundle paramBundle)
  {
    Object localObject = paramBundle.get("RESPONSE_CODE");
    if (localObject == null)
    {
      gs.W("Bundle with null response code, assuming OK (known issue)");
      return 0;
    }
    if ((localObject instanceof Integer))
      return ((Integer)localObject).intValue();
    if ((localObject instanceof Long))
      return (int)((Long)localObject).longValue();
    gs.W("Unexpected type for intent response code. " + localObject.getClass().getName());
    return 5;
  }

  public static int d(Intent paramIntent)
  {
    Object localObject = paramIntent.getExtras().get("RESPONSE_CODE");
    if (localObject == null)
    {
      gs.W("Intent with no response code, assuming OK (known issue)");
      return 0;
    }
    if ((localObject instanceof Integer))
      return ((Integer)localObject).intValue();
    if ((localObject instanceof Long))
      return (int)((Long)localObject).longValue();
    gs.W("Unexpected type for intent response code. " + localObject.getClass().getName());
    return 5;
  }

  public static String e(Intent paramIntent)
  {
    if (paramIntent == null)
      return null;
    return paramIntent.getStringExtra("INAPP_PURCHASE_DATA");
  }

  public static String f(Intent paramIntent)
  {
    if (paramIntent == null)
      return null;
    return paramIntent.getStringExtra("INAPP_DATA_SIGNATURE");
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ed
 * JD-Core Version:    0.6.2
 */