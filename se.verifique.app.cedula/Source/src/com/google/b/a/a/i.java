package com.google.b.a.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

class i
  implements n
{
  private static i e;
  private static Object f = new Object();
  protected String a;
  protected String b;
  protected String c;
  protected String d;

  protected i()
  {
  }

  private i(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    this.c = paramContext.getPackageName();
    this.d = localPackageManager.getInstallerPackageName(this.c);
    String str1 = this.c;
    String str2 = null;
    try
    {
      PackageInfo localPackageInfo = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0);
      if (localPackageInfo != null)
      {
        str1 = localPackageManager.getApplicationLabel(localPackageInfo.applicationInfo).toString();
        str2 = localPackageInfo.versionName;
      }
      this.a = str1;
      this.b = str2;
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
        ar.a("Error retrieving package info: appName set to " + str1);
    }
  }

  public static i a()
  {
    return e;
  }

  public static void a(Context paramContext)
  {
    synchronized (f)
    {
      if (e == null)
        e = new i(paramContext);
      return;
    }
  }

  public String a(String paramString)
  {
    String str = null;
    if (paramString == null);
    while (true)
    {
      return str;
      if (paramString.equals("&an"))
      {
        str = this.a;
        continue;
      }
      if (paramString.equals("&av"))
      {
        str = this.b;
        continue;
      }
      if (paramString.equals("&aid"))
      {
        str = this.c;
        continue;
      }
      if (!paramString.equals("&aiid"))
        continue;
      str = this.d;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.b.a.a.i
 * JD-Core Version:    0.6.0
 */