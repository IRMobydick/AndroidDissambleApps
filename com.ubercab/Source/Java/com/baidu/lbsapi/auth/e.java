package com.baidu.lbsapi.auth;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.baidu.android.bbalbs.common.util.CommonParam;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class e
{
  private static Context b;
  private static j d = null;
  private static int e = 0;
  private static Hashtable<String, i> f = new Hashtable();
  private boolean a = true;
  private c c = null;
  private final Handler g = new f(this, Looper.getMainLooper());

  public e(Context paramContext)
  {
    b = paramContext;
    if ((d != null) && (!d.isAlive()))
      d = null;
    c();
  }

  private int a(String paramString)
  {
    int i = -1;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (!localJSONObject.has("status"))
        localJSONObject.put("status", -1);
      i = localJSONObject.getInt("status");
      long l1;
      long l2;
      if ((localJSONObject.has("current")) && (i == 0))
      {
        l1 = localJSONObject.getLong("current");
        l2 = System.currentTimeMillis();
        if ((l2 - l1) / 3600000.0D < 24.0D)
          break label128;
        i = 601;
      }
      while ((localJSONObject.has("current")) && (i == 602))
      {
        long l3 = localJSONObject.getLong("current");
        if ((System.currentTimeMillis() - l3) / 1000L <= 180.0D)
          break;
        return 601;
        label128: SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        boolean bool = localSimpleDateFormat.format(Long.valueOf(l2)).equals(localSimpleDateFormat.format(Long.valueOf(l1)));
        if (!bool)
          i = 601;
      }
    }
    catch (JSONException localJSONException)
    {
      int j = i;
      localJSONException.printStackTrace();
      return j;
    }
    return i;
  }

  private String a(Context paramContext)
  {
    int i = Process.myPid();
    Iterator localIterator = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (localIterator.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
      if (localRunningAppProcessInfo.pid == i)
        return localRunningAppProcessInfo.processName;
    }
    return null;
  }

  private String a(Context paramContext, String paramString)
  {
    String str1 = "";
    String str2 = paramContext.getPackageName();
    try
    {
      ApplicationInfo localApplicationInfo = paramContext.getPackageManager().getApplicationInfo(str2, 128);
      if (localApplicationInfo.metaData == null)
      {
        i locali3 = (i)f.get(paramString);
        if (locali3 != null)
          locali3.a(-1, ErrorMessage.a("AndroidManifest.xml的application中没有meta-data标签"));
      }
      else
      {
        str1 = localApplicationInfo.metaData.getString("com.baidu.lbsapi.API_KEY");
        if ((str1 == null) || (str1.equals("")))
        {
          i locali2 = (i)f.get(paramString);
          if (locali2 != null)
            locali2.a(-1, ErrorMessage.a("无法在AndroidManifest.xml中获取com.baidu.android.lbs.API_KEY的值"));
        }
        return str1;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
      {
        i locali1 = (i)f.get(paramString);
        if (locali1 != null)
          locali1.a(-1, ErrorMessage.a("无法在AndroidManifest.xml中获取com.baidu.android.lbs.API_KEY的值"));
      }
    }
    return str1;
  }

  private void a(String paramString1, String paramString2)
  {
    int i = -1;
    if (paramString1 == null);
    try
    {
      paramString1 = d();
      Message localMessage = this.g.obtainMessage();
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString1);
        if (!localJSONObject.has("status"))
          localJSONObject.put("status", -1);
        if (!localJSONObject.has("current"))
          localJSONObject.put("current", System.currentTimeMillis());
        c(localJSONObject.toString());
        if (localJSONObject.has("current"))
          localJSONObject.remove("current");
        i = localJSONObject.getInt("status");
        localMessage.what = i;
        localMessage.obj = localJSONObject.toString();
        Bundle localBundle2 = new Bundle();
        localBundle2.putString("listenerKey", paramString2);
        localMessage.setData(localBundle2);
        this.g.sendMessage(localMessage);
        d.c();
        e = -1 + e;
        if (a.a)
          a.a("httpRequest called mAuthCounter-- = " + e);
        if (e == 0)
        {
          d.a();
          if (d != null)
            d = null;
        }
        return;
      }
      catch (JSONException localJSONException)
      {
        while (true)
        {
          localJSONException.printStackTrace();
          localMessage.what = i;
          localMessage.obj = new JSONObject();
          Bundle localBundle1 = new Bundle();
          localBundle1.putString("listenerKey", paramString2);
          localMessage.setData(localBundle1);
          this.g.sendMessage(localMessage);
        }
      }
    }
    finally
    {
    }
  }

  private void a(boolean paramBoolean, String paramString1, Hashtable<String, String> paramHashtable, String paramString2)
  {
    String str1 = a(b, paramString2);
    if ((str1 == null) || (str1.equals("")))
      return;
    HashMap localHashMap = new HashMap();
    localHashMap.put("url", "https://sapi.map.baidu.com/sdkcs/verify");
    localHashMap.put("output", "json");
    localHashMap.put("ak", str1);
    localHashMap.put("mcode", b.a(b));
    localHashMap.put("from", "lbs_yunsdk");
    if ((paramHashtable != null) && (paramHashtable.size() > 0))
    {
      Iterator localIterator = paramHashtable.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localHashMap.put((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
    localHashMap.put("cuid", CommonParam.a(b));
    localHashMap.put("pcn", b.getPackageName());
    localHashMap.put("version", "1.0.4");
    localHashMap.put("macaddr", b.b(b));
    if (paramBoolean)
      if (!paramBoolean)
        break label296;
    label296: for (String str2 = "1"; ; str2 = "0")
    {
      localHashMap.put("force", str2);
      localHashMap.put("from_service", paramString1);
      this.c = new c(b);
      this.c.a(localHashMap, new h(this, paramString2));
      return;
    }
  }

  private boolean b(String paramString)
  {
    String str1 = a(b, paramString);
    String str2 = d();
    try
    {
      JSONObject localJSONObject = new JSONObject(str2);
      if (!localJSONObject.has("ak"))
        return true;
      String str4 = localJSONObject.getString("ak");
      str3 = str4;
      if ((str1 == null) || (str3 == null) || (str1.equals(str3)))
        return false;
    }
    catch (JSONException localJSONException)
    {
      while (true)
      {
        localJSONException.printStackTrace();
        String str3 = "";
      }
    }
    return true;
  }

  private void c()
  {
    try
    {
      if (d == null)
      {
        d = new j("auth");
        d.start();
        while (true)
        {
          Handler localHandler = d.a;
          if (localHandler != null)
            break;
          try
          {
            if (a.a)
              a.a("wait for create auth thread.");
            Thread.sleep(3L);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    }
    finally
    {
    }
  }

  private void c(String paramString)
  {
    b.getSharedPreferences("authStatus_" + a(b), 0).edit().putString("status", paramString).commit();
  }

  private String d()
  {
    return b.getSharedPreferences("authStatus_" + a(b), 0).getString("status", "{\"status\":601}");
  }

  // ERROR //
  public int a(boolean paramBoolean, String paramString, Hashtable<String, String> paramHashtable, i parami)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 278	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 279	java/lang/StringBuilder:<init>	()V
    //   10: invokestatic 94	java/lang/System:currentTimeMillis	()J
    //   13: invokevirtual 431	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16: ldc 176
    //   18: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: astore 6
    //   26: aload 4
    //   28: ifnull +14 -> 42
    //   31: getstatic 32	com/baidu/lbsapi/auth/e:f	Ljava/util/Hashtable;
    //   34: aload 6
    //   36: aload 4
    //   38: invokevirtual 432	java/util/Hashtable:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   41: pop
    //   42: aload_0
    //   43: getstatic 53	com/baidu/lbsapi/auth/e:b	Landroid/content/Context;
    //   46: aload 6
    //   48: invokespecial 296	com/baidu/lbsapi/auth/e:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   51: astore 8
    //   53: aload 8
    //   55: ifnull +13 -> 68
    //   58: aload 8
    //   60: ldc 176
    //   62: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   65: ifeq +8 -> 73
    //   68: ldc 2
    //   70: monitorexit
    //   71: iconst_m1
    //   72: ireturn
    //   73: iconst_1
    //   74: getstatic 25	com/baidu/lbsapi/auth/e:e	I
    //   77: iadd
    //   78: putstatic 25	com/baidu/lbsapi/auth/e:e	I
    //   81: getstatic 276	com/baidu/lbsapi/auth/a:a	Z
    //   84: ifeq +28 -> 112
    //   87: new 278	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 279	java/lang/StringBuilder:<init>	()V
    //   94: ldc_w 434
    //   97: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: getstatic 25	com/baidu/lbsapi/auth/e:e	I
    //   103: invokevirtual 288	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   106: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 291	com/baidu/lbsapi/auth/a:a	(Ljava/lang/String;)V
    //   112: aload_0
    //   113: aload_0
    //   114: invokespecial 232	com/baidu/lbsapi/auth/e:d	()Ljava/lang/String;
    //   117: invokespecial 436	com/baidu/lbsapi/auth/e:a	(Ljava/lang/String;)I
    //   120: istore 9
    //   122: iload 9
    //   124: sipush 601
    //   127: if_icmpne +25 -> 152
    //   130: aload_0
    //   131: new 66	org/json/JSONObject
    //   134: dup
    //   135: invokespecial 294	org/json/JSONObject:<init>	()V
    //   138: ldc 71
    //   140: sipush 602
    //   143: invokevirtual 79	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   146: invokevirtual 244	org/json/JSONObject:toString	()Ljava/lang/String;
    //   149: invokespecial 246	com/baidu/lbsapi/auth/e:c	(Ljava/lang/String;)V
    //   152: aload_0
    //   153: invokespecial 61	com/baidu/lbsapi/auth/e:c	()V
    //   156: getstatic 276	com/baidu/lbsapi/auth/a:a	Z
    //   159: ifeq +31 -> 190
    //   162: new 278	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 279	java/lang/StringBuilder:<init>	()V
    //   169: ldc_w 438
    //   172: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: getstatic 23	com/baidu/lbsapi/auth/e:d	Lcom/baidu/lbsapi/auth/j;
    //   178: getfield 390	com/baidu/lbsapi/auth/j:a	Landroid/os/Handler;
    //   181: invokevirtual 441	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 291	com/baidu/lbsapi/auth/a:a	(Ljava/lang/String;)V
    //   190: getstatic 23	com/baidu/lbsapi/auth/e:d	Lcom/baidu/lbsapi/auth/j;
    //   193: getfield 390	com/baidu/lbsapi/auth/j:a	Landroid/os/Handler;
    //   196: new 443	com/baidu/lbsapi/auth/g
    //   199: dup
    //   200: aload_0
    //   201: iload 9
    //   203: iload_1
    //   204: aload 6
    //   206: aload_2
    //   207: aload_3
    //   208: invokespecial 446	com/baidu/lbsapi/auth/g:<init>	(Lcom/baidu/lbsapi/auth/e;IZLjava/lang/String;Ljava/lang/String;Ljava/util/Hashtable;)V
    //   211: invokevirtual 450	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   214: pop
    //   215: ldc 2
    //   217: monitorexit
    //   218: iload 9
    //   220: ireturn
    //   221: astore 5
    //   223: ldc 2
    //   225: monitorexit
    //   226: aload 5
    //   228: athrow
    //   229: astore 11
    //   231: aload 11
    //   233: invokevirtual 126	org/json/JSONException:printStackTrace	()V
    //   236: goto -84 -> 152
    //
    // Exception table:
    //   from	to	target	type
    //   3	26	221	finally
    //   31	42	221	finally
    //   42	53	221	finally
    //   58	68	221	finally
    //   68	71	221	finally
    //   73	112	221	finally
    //   112	122	221	finally
    //   130	152	221	finally
    //   152	190	221	finally
    //   190	218	221	finally
    //   223	226	221	finally
    //   231	236	221	finally
    //   130	152	229	org/json/JSONException
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.lbsapi.auth.e
 * JD-Core Version:    0.6.2
 */