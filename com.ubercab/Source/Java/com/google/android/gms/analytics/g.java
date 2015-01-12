package com.google.android.gms.analytics;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

class g
  implements l
{
  private static g xP;
  private static Object xz = new Object();
  protected String xL;
  protected String xM;
  protected String xN;
  protected String xO;

  protected g()
  {
  }

  private g(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    this.xN = paramContext.getPackageName();
    this.xO = localPackageManager.getInstallerPackageName(this.xN);
    String str1 = this.xN;
    try
    {
      PackageInfo localPackageInfo = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0);
      str2 = null;
      if (localPackageInfo != null)
      {
        str1 = localPackageManager.getApplicationLabel(localPackageInfo.applicationInfo).toString();
        str2 = localPackageInfo.versionName;
      }
      this.xL = str1;
      this.xM = str2;
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
      {
        z.T("Error retrieving package info: appName set to " + str1);
        String str2 = null;
      }
    }
  }

  public static g dP()
  {
    return xP;
  }

  public static void y(Context paramContext)
  {
    synchronized (xz)
    {
      if (xP == null)
        xP = new g(paramContext);
      return;
    }
  }

  public boolean ac(String paramString)
  {
    return ("&an".equals(paramString)) || ("&av".equals(paramString)) || ("&aid".equals(paramString)) || ("&aiid".equals(paramString));
  }

  public String getValue(String paramString)
  {
    if (paramString == null);
    do
    {
      return null;
      if (paramString.equals("&an"))
        return this.xL;
      if (paramString.equals("&av"))
        return this.xM;
      if (paramString.equals("&aid"))
        return this.xN;
    }
    while (!paramString.equals("&aiid"));
    return this.xO;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.g
 * JD-Core Version:    0.6.2
 */