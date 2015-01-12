package com.baidu.mapapi.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.baidu.lbsapi.auth.e;
import com.baidu.lbsapi.auth.i;
import com.baidu.platform.comapi.c.c;
import java.util.Hashtable;
import org.json.JSONException;
import org.json.JSONObject;

public class PermissionCheck
{
  private static final String a = PermissionCheck.class.getSimpleName();
  private static Context b;
  private static Hashtable<String, String> c;
  private static e d = null;
  private static i e = null;
  private static c f = null;

  public static void destory()
  {
    f = null;
    b = null;
    d = null;
    e = null;
  }

  public static void init(Context paramContext)
  {
    b = paramContext;
    if (c == null)
      c = new Hashtable();
    if (d == null)
      d = new e(b);
    if (e == null)
      e = new a(null);
    Object localObject = "";
    try
    {
      String str = paramContext.getPackageManager().getPackageInfo(b.getPackageName(), 0).applicationInfo.loadLabel(b.getPackageManager()).toString();
      localObject = str;
      Log.d("auth info", "mcode: " + a.a(b));
      Bundle localBundle = c.c();
      c.put("mb", localBundle.getString("mb"));
      c.put("os", localBundle.getString("os"));
      c.put("sv", localBundle.getString("sv"));
      c.put("imt", "1");
      c.put("im", localBundle.getString("im"));
      c.put("imrand", localBundle.getString("imrand"));
      c.put("net", localBundle.getString("net"));
      c.put("cpu", localBundle.getString("cpu"));
      c.put("glr", localBundle.getString("glr"));
      c.put("glv", localBundle.getString("glv"));
      c.put("resid", localBundle.getString("resid"));
      c.put("appid", "-1");
      c.put("ver", "1");
      Hashtable localHashtable1 = c;
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = Integer.valueOf(localBundle.getInt("screen_x"));
      arrayOfObject1[1] = Integer.valueOf(localBundle.getInt("screen_y"));
      localHashtable1.put("screen", String.format("(%d,%d)", arrayOfObject1));
      Hashtable localHashtable2 = c;
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = Integer.valueOf(localBundle.getInt("dpi_x"));
      arrayOfObject2[1] = Integer.valueOf(localBundle.getInt("dpi_y"));
      localHashtable2.put("dpi", String.format("(%d,%d)", arrayOfObject2));
      c.put("pcn", localBundle.getString("pcn"));
      c.put("cuid", localBundle.getString("cuid"));
      c.put("name", localObject);
      return;
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }

  public static int permissionCheck()
  {
    try
    {
      e locale = d;
      int i = 0;
      if (locale != null)
      {
        i locali = e;
        i = 0;
        if (locali != null)
        {
          Context localContext = b;
          i = 0;
          if (localContext != null)
            break label40;
        }
      }
      while (true)
      {
        return i;
        label40: int j = d.a(false, "lbs_androidsdk", c, e);
        i = j;
      }
    }
    finally
    {
    }
  }

  public static void setPermissionCheckResultListener(c paramc)
  {
    f = paramc;
  }

  private static class a
    implements i
  {
    public void a(int paramInt, String paramString)
    {
      if (paramString == null);
      while (true)
      {
        return;
        PermissionCheck.b localb = new PermissionCheck.b();
        try
        {
          JSONObject localJSONObject = new JSONObject(paramString);
          if (localJSONObject.has("status"))
            localb.a = localJSONObject.optInt("status");
          if (localJSONObject.has("appid"))
            localb.c = localJSONObject.optString("appid");
          if (localJSONObject.has("uid"))
            localb.b = localJSONObject.optString("uid");
          if (localJSONObject.has("message"))
            localb.d = localJSONObject.optString("message");
          if (localJSONObject.has("token"))
            localb.e = localJSONObject.optString("token");
          if (PermissionCheck.a() == null)
            continue;
          PermissionCheck.a().a(localb);
          return;
        }
        catch (JSONException localJSONException)
        {
          while (true)
            localJSONException.printStackTrace();
        }
      }
    }
  }

  public static class b
  {
    public int a = 0;
    public String b = "-1";
    public String c = "-1";
    public String d = "";
    public String e;

    public String toString()
    {
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = Integer.valueOf(this.a);
      arrayOfObject[1] = this.b;
      arrayOfObject[2] = this.c;
      arrayOfObject[3] = this.d;
      return String.format("errorcode: %d uid: %s appid %s msg: %s", arrayOfObject);
    }
  }

  public static abstract interface c
  {
    public abstract void a(PermissionCheck.b paramb);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.utils.PermissionCheck
 * JD-Core Version:    0.6.2
 */