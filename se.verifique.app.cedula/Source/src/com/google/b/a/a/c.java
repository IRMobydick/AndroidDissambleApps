package com.google.b.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

final class c
  implements ServiceConnection
{
  c(b paramb)
  {
  }

  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    ar.c("service connected, binder: " + paramIBinder);
    try
    {
      if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(paramIBinder.getInterfaceDescriptor()))
      {
        ar.c("bound to service");
        b.a(this.a, com.google.android.gms.analytics.internal.c.a(paramIBinder));
        b.a(this.a);
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
      {
        b.b(this.a).unbindService(this);
        b.a(this.a, null);
        b.c(this.a).a(2, null);
      }
    }
  }

  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    ar.c("service disconnected: " + paramComponentName);
    b.a(this.a, null);
    b.d(this.a).b();
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.b.a.a.c
 * JD-Core Version:    0.6.0
 */