package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import java.util.regex.Pattern;

public final class lp
{
  private static Pattern a = null;

  public static int a(int paramInt)
  {
    return paramInt / 1000;
  }

  public static boolean a(Context paramContext)
  {
    return paramContext.getPackageManager().hasSystemFeature("android.hardware.type.watch");
  }

  public static int b(int paramInt)
  {
    return paramInt % 1000 / 100;
  }

  public static boolean c(int paramInt)
  {
    if (b(paramInt) == 3);
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.lp
 * JD-Core Version:    0.6.0
 */