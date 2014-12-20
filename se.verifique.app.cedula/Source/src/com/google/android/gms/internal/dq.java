package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

public final class dq extends eh
  implements ServiceConnection
{
  private boolean a = false;
  private Context b;
  private int c;
  private Intent d;
  private dk e;
  private dp f;
  private String g;

  public dq(Context paramContext, String paramString, boolean paramBoolean, int paramInt, Intent paramIntent, dp paramdp)
  {
    this.g = paramString;
    this.c = paramInt;
    this.d = paramIntent;
    this.a = paramBoolean;
    this.b = paramContext;
    this.f = paramdp;
  }

  public boolean a()
  {
    return this.a;
  }

  public String b()
  {
    return this.g;
  }

  public Intent c()
  {
    return this.d;
  }

  public int d()
  {
    return this.c;
  }

  public void e()
  {
    int i = dv.a(this.d);
    if ((this.c != -1) || (i != 0));
    while (true)
    {
      return;
      this.e = new dk(this.b);
      Context localContext = this.b;
      Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
      localContext.bindService(localIntent, this, 1);
    }
  }

  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    hi.c("In-app billing service connected.");
    this.e.a(paramIBinder);
    String str = dv.b(dv.b(this.d));
    if (str == null);
    while (true)
    {
      return;
      if (this.e.a(this.b.getPackageName(), str) == 0)
        dr.a(this.b).a(this.f);
      this.b.unbindService(this);
      this.e.a();
    }
  }

  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    hi.c("In-app billing service disconnected.");
    this.e.a();
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.dq
 * JD-Core Version:    0.6.0
 */