package com.ubercab.client.core.util;

import android.text.TextUtils;
import java.util.Locale;

public final class UrlUtils
{
  public static String localizeUrl(String paramString)
  {
    String str = Locale.getDefault().getISO3Country();
    if (TextUtils.isEmpty(str))
      str = Locale.US.getISO3Country();
    return String.format(paramString, new Object[] { str }).toLowerCase();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.util.UrlUtils
 * JD-Core Version:    0.6.2
 */