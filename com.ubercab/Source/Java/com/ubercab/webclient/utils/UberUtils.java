package com.ubercab.webclient.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build.VERSION;

public final class UberUtils
{
  public static String getAndClearGravyToken(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("ubercab_prefs_file", 0);
    String str = localSharedPreferences.getString("client.token", "");
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    localEditor.clear();
    if (Build.VERSION.SDK_INT < 9)
    {
      localEditor.commit();
      return str;
    }
    localEditor.apply();
    return str;
  }

  public static boolean isUberUrl(String paramString)
  {
    Uri localUri1 = Uri.parse("https://m.uber.com");
    Uri localUri2 = Uri.parse(paramString);
    String str = localUri1.getHost();
    return (str != null) && (str.equals(localUri2.getHost()));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.webclient.utils.UberUtils
 * JD-Core Version:    0.6.2
 */