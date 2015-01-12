package com.baidu.mapapi.utils;

import android.content.Context;
import java.io.File;

public class b
{
  static String a;
  static String b;
  static String c;
  static int d;
  static int e;
  static int f;
  private static e g = null;

  public static String a()
  {
    String str1 = a;
    String str2 = str1 + "/BaiduMapSDK";
    if (str2.length() != 0)
    {
      File localFile = new File(str2);
      if (!localFile.exists())
        localFile.mkdirs();
    }
    return str2;
  }

  public static void a(Context paramContext)
  {
    if (g == null)
    {
      g = e.a();
      g.a(paramContext);
    }
    if ((a != null) && (a.length() > 0));
    for (b = a + File.separator + "BaiduMapSDK" + File.separator + "cache"; ; b = g.b().c())
    {
      c = g.b().d();
      d = 20971520;
      e = 52428800;
      f = 5242880;
      return;
      a = g.b().a();
    }
  }

  public static void a(String paramString)
  {
    a = paramString;
  }

  public static String b()
  {
    return b;
  }

  public static String c()
  {
    return c;
  }

  public static int d()
  {
    return d;
  }

  public static int e()
  {
    return e;
  }

  public static int f()
  {
    return f;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.utils.b
 * JD-Core Version:    0.6.2
 */