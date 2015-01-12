package com.google.android.gms.analytics;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

class ad
  implements l
{
  private static ad Bi;
  private static Object xz = new Object();
  private final Context mContext;

  protected ad(Context paramContext)
  {
    this.mContext = paramContext;
  }

  public static ad eQ()
  {
    synchronized (xz)
    {
      ad localad = Bi;
      return localad;
    }
  }

  public static void y(Context paramContext)
  {
    synchronized (xz)
    {
      if (Bi == null)
        Bi = new ad(paramContext);
      return;
    }
  }

  public boolean ac(String paramString)
  {
    return "&sr".equals(paramString);
  }

  protected String eR()
  {
    DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
    return localDisplayMetrics.widthPixels + "x" + localDisplayMetrics.heightPixels;
  }

  public String getValue(String paramString)
  {
    if (paramString == null);
    while (!paramString.equals("&sr"))
      return null;
    return eR();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.ad
 * JD-Core Version:    0.6.2
 */