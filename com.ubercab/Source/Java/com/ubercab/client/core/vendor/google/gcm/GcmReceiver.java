package com.ubercab.client.core.vendor.google.gcm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;

public class GcmReceiver extends WakefulBroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent.setComponent(new ComponentName(paramContext.getPackageName(), GcmService.class.getName()));
    startWakefulService(paramContext, paramIntent);
    setResultCode(-1);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.vendor.google.gcm.GcmReceiver
 * JD-Core Version:    0.6.2
 */