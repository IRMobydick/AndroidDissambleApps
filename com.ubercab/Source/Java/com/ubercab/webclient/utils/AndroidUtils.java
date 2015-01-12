package com.ubercab.webclient.utils;

import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.Locale;

public final class AndroidUtils
{
  public static String getLanguageCode()
  {
    Locale localLocale = Locale.getDefault();
    if ("es".equalsIgnoreCase(localLocale.getLanguage()))
      return "es_MX";
    if (!TextUtils.isEmpty(localLocale.getCountry()))
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = localLocale.getLanguage();
      arrayOfObject[1] = localLocale.getCountry();
      return String.format("%s_%s", arrayOfObject);
    }
    return localLocale.getLanguage();
  }

  public static boolean hasHoneycomb()
  {
    return Build.VERSION.SDK_INT >= 11;
  }

  public static boolean hasKitKat()
  {
    return Build.VERSION.SDK_INT >= 19;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.webclient.utils.AndroidUtils
 * JD-Core Version:    0.6.2
 */