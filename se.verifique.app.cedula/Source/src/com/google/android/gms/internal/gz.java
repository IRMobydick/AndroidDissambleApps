package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class gz extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.intent.action.USER_PRESENT".equals(paramIntent.getAction()))
      gw.a(true);
    while (true)
    {
      return;
      if ("android.intent.action.SCREEN_OFF".equals(paramIntent.getAction()))
      {
        gw.a(false);
        continue;
      }
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gz
 * JD-Core Version:    0.6.0
 */