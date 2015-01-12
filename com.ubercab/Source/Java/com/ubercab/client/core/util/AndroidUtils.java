package com.ubercab.client.core.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import com.ubercab.common.base.Preconditions;

public final class AndroidUtils
{
  public static int getThemeAttributeDimensionSize(Context paramContext, int paramInt)
  {
    TypedValue localTypedValue = new TypedValue();
    if (paramContext.getTheme().resolveAttribute(paramInt, localTypedValue, true))
      return TypedValue.complexToDimensionPixelSize(localTypedValue.data, paramContext.getResources().getDisplayMetrics());
    return 0;
  }

  public static boolean isPackageInstalled(Context paramContext, String paramString)
  {
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      boolean bool1 = false;
      if (localPackageInfo != null)
      {
        ApplicationInfo localApplicationInfo = localPackageInfo.applicationInfo;
        bool1 = false;
        if (localApplicationInfo != null)
        {
          boolean bool2 = localPackageInfo.applicationInfo.enabled;
          bool1 = false;
          if (bool2)
            bool1 = true;
        }
      }
      return bool1;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return false;
  }

  public static boolean isWindowValid(Window paramWindow)
  {
    return (paramWindow != null) && (paramWindow.getDecorView() != null) && (paramWindow.getDecorView().getWindowToken() != null);
  }

  public static Integer versionCompare(String paramString1, String paramString2)
  {
    Preconditions.checkNotNull(paramString1);
    Preconditions.checkNotNull(paramString2);
    String[] arrayOfString1 = paramString1.split("\\.");
    String[] arrayOfString2 = paramString2.split("\\.");
    for (int i = 0; (i < arrayOfString1.length) && (i < arrayOfString2.length) && (arrayOfString1[i].equals(arrayOfString2[i])); i++);
    if ((i < arrayOfString1.length) && (i < arrayOfString2.length))
      return Integer.valueOf(Integer.signum(Integer.valueOf(arrayOfString1[i]).compareTo(Integer.valueOf(arrayOfString2[i]))));
    return Integer.valueOf(Integer.signum(arrayOfString1.length - arrayOfString2.length));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.util.AndroidUtils
 * JD-Core Version:    0.6.2
 */