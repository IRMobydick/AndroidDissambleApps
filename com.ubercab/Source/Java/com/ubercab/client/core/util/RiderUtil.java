package com.ubercab.client.core.util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.text.TextUtils;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.feature.launch.Preload;
import com.ubercab.library.location.model.UberLocation;
import com.ubercab.library.util.LocationUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import timber.log.Timber;

public final class RiderUtil
{
  public static String getUberSlogan(Context paramContext, UberLocation paramUberLocation)
  {
    if (!LocationUtils.isInGermany(paramUberLocation));
    for (int i = 1; ; i = 0)
    {
      String str = paramContext.getString(2131559311);
      if (i != 0)
        str = str + paramContext.getString(2131559308);
      return str;
    }
  }

  public static boolean isPreload()
  {
    Iterator localIterator = Preload.CONFIG_PATHS.iterator();
    while (localIterator.hasNext())
      if (((File)localIterator.next()).exists())
        return true;
    return false;
  }

  public static void openGooglePlayStore(Context paramContext)
  {
    paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.ubercab")));
  }

  public static void upgradeFromGravy(Context paramContext, SessionPreferences paramSessionPreferences)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("ubercab_prefs_file", 0);
    String str = localSharedPreferences.getString("client.token", "");
    if (!TextUtils.isEmpty(str))
    {
      Timber.d("Set token from upgrade.", new Object[0]);
      paramSessionPreferences.setToken(str);
    }
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    localEditor.clear();
    localEditor.apply();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.util.RiderUtil
 * JD-Core Version:    0.6.2
 */