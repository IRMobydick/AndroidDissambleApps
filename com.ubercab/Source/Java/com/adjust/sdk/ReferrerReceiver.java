package com.adjust.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class ReferrerReceiver extends BroadcastReceiver
{
  protected static final String REFERRER_KEY = "AdjustInstallReferrer";

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("referrer");
    if (str1 == null)
      return;
    try
    {
      String str3 = URLDecoder.decode(str1, "UTF-8");
      str2 = str3;
      PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putString("AdjustInstallReferrer", str2).commit();
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      while (true)
        String str2 = "malformed";
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.ReferrerReceiver
 * JD-Core Version:    0.6.2
 */