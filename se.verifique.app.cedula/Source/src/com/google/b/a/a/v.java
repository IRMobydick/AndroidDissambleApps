package com.google.b.a.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

class v extends BroadcastReceiver
{
  static final String a = v.class.getName();
  private final bd b;

  v(bd parambd)
  {
    this.b = parambd;
  }

  public static void b(Context paramContext)
  {
    Intent localIntent = new Intent("com.google.analytics.RADIO_POWERED");
    localIntent.addCategory(paramContext.getPackageName());
    localIntent.putExtra(a, true);
    paramContext.sendBroadcast(localIntent);
  }

  public void a(Context paramContext)
  {
    IntentFilter localIntentFilter1 = new IntentFilter();
    localIntentFilter1.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    paramContext.registerReceiver(this, localIntentFilter1);
    IntentFilter localIntentFilter2 = new IntentFilter();
    localIntentFilter2.addAction("com.google.analytics.RADIO_POWERED");
    localIntentFilter2.addCategory(paramContext.getPackageName());
    paramContext.registerReceiver(this, localIntentFilter2);
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool1 = false;
    String str = paramIntent.getAction();
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(str))
    {
      boolean bool2 = paramIntent.getBooleanExtra("noConnectivity", false);
      bd localbd = this.b;
      if (!bool2)
        bool1 = true;
      localbd.a(bool1);
    }
    while (true)
    {
      return;
      if (("com.google.analytics.RADIO_POWERED".equals(str)) && (!paramIntent.hasExtra(a)))
      {
        this.b.e();
        continue;
      }
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.b.a.a.v
 * JD-Core Version:    0.6.0
 */