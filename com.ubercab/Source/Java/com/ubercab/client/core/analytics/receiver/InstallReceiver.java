package com.ubercab.client.core.analytics.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.adjust.sdk.ReferrerReceiver;
import com.mobileapptracker.Tracker;

public class InstallReceiver extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    new Tracker().onReceive(paramContext, paramIntent);
    new ReferrerReceiver().onReceive(paramContext, paramIntent);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.analytics.receiver.InstallReceiver
 * JD-Core Version:    0.6.2
 */