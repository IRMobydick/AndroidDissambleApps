package com.google.b.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import java.util.List;
import java.util.Map;

class b
  implements a
{
  private ServiceConnection a;
  private d b;
  private e c;
  private Context d;
  private com.google.android.gms.analytics.internal.b e;

  public b(Context paramContext, d paramd, e parame)
  {
    this.d = paramContext;
    if (paramd == null)
      throw new IllegalArgumentException("onConnectedListener cannot be null");
    this.b = paramd;
    if (parame == null)
      throw new IllegalArgumentException("onConnectionFailedListener cannot be null");
    this.c = parame;
  }

  private com.google.android.gms.analytics.internal.b f()
  {
    d();
    return this.e;
  }

  private void g()
  {
    h();
  }

  private void h()
  {
    this.b.a();
  }

  public void a()
  {
    try
    {
      f().a();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        ar.a("clear hits failed: " + localRemoteException);
    }
  }

  public void a(Map paramMap, long paramLong, String paramString, List paramList)
  {
    try
    {
      f().a(paramMap, paramLong, paramString, paramList);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        ar.a("sendHit failed: " + localRemoteException);
    }
  }

  public void b()
  {
    Intent localIntent = new Intent("com.google.android.gms.analytics.service.START");
    localIntent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
    localIntent.putExtra("app_package_name", this.d.getPackageName());
    if (this.a != null)
      ar.a("Calling connect() while still connected, missing disconnect().");
    while (true)
    {
      return;
      this.a = new c(this);
      boolean bool = this.d.bindService(localIntent, this.a, 129);
      ar.c("connect: bindService returned " + bool + " for " + localIntent);
      if (bool)
        continue;
      this.a = null;
      this.c.a(1, null);
    }
  }

  public void c()
  {
    this.e = null;
    if (this.a != null);
    try
    {
      this.d.unbindService(this.a);
      label23: this.a = null;
      this.b.b();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label23;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      break label23;
    }
  }

  protected void d()
  {
    if (!e())
      throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
  }

  public boolean e()
  {
    if (this.e != null);
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.b.a.a.b
 * JD-Core Version:    0.6.0
 */