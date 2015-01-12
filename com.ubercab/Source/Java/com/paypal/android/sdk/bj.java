package com.paypal.android.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

public final class bj
{
  private static final boolean a = Boolean.valueOf(System.getProperty("dyson.debug.mode", Boolean.FALSE.toString())).booleanValue();

  // ERROR //
  public static android.location.Location a(android.location.LocationManager paramLocationManager)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: iconst_1
    //   4: invokevirtual 45	android/location/LocationManager:getProviders	(Z)Ljava/util/List;
    //   7: astore 4
    //   9: aload 4
    //   11: invokeinterface 51 1 0
    //   16: istore 5
    //   18: iload 5
    //   20: iconst_1
    //   21: isub
    //   22: istore 6
    //   24: iload 6
    //   26: iflt +45 -> 71
    //   29: aload_0
    //   30: aload 4
    //   32: iload 6
    //   34: invokeinterface 55 2 0
    //   39: checkcast 57	java/lang/String
    //   42: invokevirtual 61	android/location/LocationManager:getLastKnownLocation	(Ljava/lang/String;)Landroid/location/Location;
    //   45: astore 8
    //   47: aload 8
    //   49: astore_3
    //   50: aload_3
    //   51: ifnonnull +14 -> 65
    //   54: iinc 6 255
    //   57: aload_3
    //   58: astore_1
    //   59: goto -35 -> 24
    //   62: astore_2
    //   63: aconst_null
    //   64: astore_3
    //   65: aload_3
    //   66: areturn
    //   67: astore 7
    //   69: aload_1
    //   70: areturn
    //   71: aload_1
    //   72: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   2	18	62	java/lang/RuntimeException
    //   29	47	67	java/lang/RuntimeException
  }

  public static aS a(Context paramContext)
  {
    aS localaS = new aS();
    localaS.a(paramContext.getPackageName());
    try
    {
      localaS.b(paramContext.getPackageManager().getPackageInfo(localaS.a(), 0).versionName);
      return localaS;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return localaS;
  }

  public static String a()
  {
    aU localaU = new aU();
    localaU.a(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/com.ebay.lid/");
    String str = localaU.b("fb.bin");
    if ("".equals(str.trim()))
    {
      str = UUID.randomUUID().toString();
      localaU.a("fb.bin", str.getBytes("UTF-8"));
    }
    return str;
  }

  public static List a(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    while (true)
    {
      String str;
      try
      {
        Enumeration localEnumeration1 = NetworkInterface.getNetworkInterfaces();
        if (localEnumeration1.hasMoreElements())
        {
          Enumeration localEnumeration2 = ((NetworkInterface)localEnumeration1.nextElement()).getInetAddresses();
          if (localEnumeration2.hasMoreElements())
          {
            InetAddress localInetAddress = (InetAddress)localEnumeration2.nextElement();
            if (localInetAddress.isLoopbackAddress())
              continue;
            str = localInetAddress.getHostAddress();
            if (!(localInetAddress instanceof Inet6Address))
              break label103;
            if (!paramBoolean)
              continue;
            localArrayList.add(str);
            continue;
          }
          continue;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return localArrayList;
      label103: localArrayList.add(str);
    }
  }

  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
  }

  public static boolean a(Context paramContext, String paramString)
  {
    String str = "android.permission." + paramString;
    return paramContext.getApplicationContext().checkCallingOrSelfPermission(str) == 0;
  }

  public static boolean a(PackageManager paramPackageManager, Intent paramIntent)
  {
    List localList = paramPackageManager.queryIntentActivities(paramIntent, 65536);
    return (localList != null) && (localList.size() > 0);
  }

  public static String b()
  {
    List localList = a(false);
    if (localList.isEmpty())
      return "";
    return (String)localList.get(0);
  }

  public static long c()
  {
    StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
    return localStatFs.getBlockSize() * localStatFs.getBlockCount();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.bj
 * JD-Core Version:    0.6.2
 */