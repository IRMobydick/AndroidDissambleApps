package com.baidu.platform.comapi.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.telephony.TelephonyManager;
import com.baidu.platform.comjni.engine.AppEngine;

public class b
{
  public static boolean a = false;
  public static String b = "";
  public static int c = 0;

  public static void a(Context paramContext)
  {
    NetworkInfo localNetworkInfo = b(paramContext);
    String str1;
    if ((localNetworkInfo != null) && (localNetworkInfo.isAvailable()))
    {
      str1 = localNetworkInfo.getTypeName().toLowerCase();
      if ((!str1.equals("wifi")) || (!localNetworkInfo.isConnected()))
        break label50;
      AppEngine.SetProxyInfo(null, 0);
      a = false;
    }
    label50: 
    while ((!str1.equals("mobile")) && ((!str1.equals("wifi")) || (a(localNetworkInfo))))
      return;
    String str2 = localNetworkInfo.getExtraInfo();
    a = false;
    String str4;
    if (str2 != null)
    {
      str4 = str2.toLowerCase();
      if ((str4.startsWith("cmwap")) || (str4.startsWith("uniwap")) || (str4.startsWith("3gwap")))
      {
        b = "10.0.0.172";
        c = 80;
        a = true;
      }
    }
    while (a == true)
    {
      AppEngine.SetProxyInfo(b, c);
      return;
      if (str4.startsWith("ctwap"))
      {
        b = "10.0.0.200";
        c = 80;
        a = true;
      }
      else if ((str4.startsWith("cmnet")) || (str4.startsWith("uninet")) || (str4.startsWith("ctnet")) || (str4.startsWith("3gnet")))
      {
        a = false;
        continue;
        String str3 = Proxy.getDefaultHost();
        int i = Proxy.getDefaultPort();
        if ((str3 != null) && (str3.length() > 0))
          if ("10.0.0.172".equals(str3.trim()))
          {
            b = "10.0.0.172";
            c = i;
            a = true;
          }
          else if ("10.0.0.200".equals(str3.trim()))
          {
            b = "10.0.0.200";
            c = 80;
            a = true;
          }
      }
    }
    AppEngine.SetProxyInfo(null, 0);
  }

  private static boolean a(NetworkInfo paramNetworkInfo)
  {
    int i = 1;
    if (paramNetworkInfo != null);
    while (true)
    {
      try
      {
        if (i == paramNetworkInfo.getType())
        {
          boolean bool = paramNetworkInfo.isConnected();
          if (bool)
            return i;
        }
        j = 0;
        continue;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return false;
      }
      int j = 0;
    }
  }

  public static NetworkInfo b(Context paramContext)
  {
    ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    try
    {
      NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
      return localNetworkInfo;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static String c(Context paramContext)
  {
    int i = 1;
    NetworkInfo localNetworkInfo = b(paramContext);
    if (localNetworkInfo != null)
      if (localNetworkInfo.getType() != i);
    while (true)
    {
      return Integer.toString(i);
      switch (((TelephonyManager)paramContext.getSystemService("phone")).getNetworkType())
      {
      default:
        i = 0;
        break;
      case 11:
        i = 2;
        break;
      case 13:
        i = 4;
        break;
      case 4:
        i = 5;
        break;
      case 1:
      case 2:
        i = 6;
        break;
      case 5:
      case 6:
      case 7:
      case 12:
        i = 7;
        break;
      case 8:
        i = 8;
        break;
      case 3:
      case 9:
      case 10:
      case 15:
        i = 9;
        break;
      case 14:
        i = 10;
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.platform.comapi.c.b
 * JD-Core Version:    0.6.2
 */