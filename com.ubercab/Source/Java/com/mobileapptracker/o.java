package com.mobileapptracker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class o extends BroadcastReceiver
{
  o(MobileAppTracker paramMobileAppTracker)
  {
  }

  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.a.isRegistered)
      this.a.dumpQueue();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.mobileapptracker.o
 * JD-Core Version:    0.6.2
 */