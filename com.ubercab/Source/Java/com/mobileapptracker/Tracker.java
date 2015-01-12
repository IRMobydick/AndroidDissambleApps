package com.mobileapptracker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import java.net.URLDecoder;

public class Tracker extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null);
    try
    {
      if (paramIntent.getAction().equals("com.android.vending.INSTALL_REFERRER"))
      {
        String str1 = paramIntent.getStringExtra("referrer");
        if (str1 != null)
        {
          String str2 = URLDecoder.decode(str1, "UTF-8");
          Log.d("MobileAppTracker", "MAT received referrer " + str2);
          paramContext.getSharedPreferences("mat_referrer", 0).edit().putString("referrer", str2).commit();
          MobileAppTracker localMobileAppTracker = MobileAppTracker.getInstance();
          if (localMobileAppTracker != null)
            localMobileAppTracker.a();
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.mobileapptracker.Tracker
 * JD-Core Version:    0.6.2
 */