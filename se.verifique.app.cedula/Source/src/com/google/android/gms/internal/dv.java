package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

public final class dv
{
  public static int a(Intent paramIntent)
  {
    Object localObject = paramIntent.getExtras().get("RESPONSE_CODE");
    int i;
    if (localObject == null)
    {
      hi.e("Intent with no response code, assuming OK (known issue)");
      i = 0;
    }
    while (true)
    {
      return i;
      if ((localObject instanceof Integer))
      {
        i = ((Integer)localObject).intValue();
        continue;
      }
      if ((localObject instanceof Long))
      {
        i = (int)((Long)localObject).longValue();
        continue;
      }
      hi.e("Unexpected type for intent response code. " + localObject.getClass().getName());
      i = 5;
    }
  }

  public static int a(Bundle paramBundle)
  {
    Object localObject = paramBundle.get("RESPONSE_CODE");
    int i;
    if (localObject == null)
    {
      hi.e("Bundle with null response code, assuming OK (known issue)");
      i = 0;
    }
    while (true)
    {
      return i;
      if ((localObject instanceof Integer))
      {
        i = ((Integer)localObject).intValue();
        continue;
      }
      if ((localObject instanceof Long))
      {
        i = (int)((Long)localObject).longValue();
        continue;
      }
      hi.e("Unexpected type for intent response code. " + localObject.getClass().getName());
      i = 5;
    }
  }

  public static String a(String paramString)
  {
    Object localObject = null;
    if (paramString == null);
    while (true)
    {
      return localObject;
      try
      {
        String str = new JSONObject(paramString).getString("developerPayload");
        localObject = str;
      }
      catch (JSONException localJSONException)
      {
        hi.e("Fail to parse purchase data");
      }
    }
  }

  public static String b(Intent paramIntent)
  {
    if (paramIntent == null);
    for (String str = null; ; str = paramIntent.getStringExtra("INAPP_PURCHASE_DATA"))
      return str;
  }

  public static String b(String paramString)
  {
    Object localObject = null;
    if (paramString == null);
    while (true)
    {
      return localObject;
      try
      {
        String str = new JSONObject(paramString).getString("purchaseToken");
        localObject = str;
      }
      catch (JSONException localJSONException)
      {
        hi.e("Fail to parse purchase data");
      }
    }
  }

  public static String c(Intent paramIntent)
  {
    if (paramIntent == null);
    for (String str = null; ; str = paramIntent.getStringExtra("INAPP_DATA_SIGNATURE"))
      return str;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.dv
 * JD-Core Version:    0.6.0
 */