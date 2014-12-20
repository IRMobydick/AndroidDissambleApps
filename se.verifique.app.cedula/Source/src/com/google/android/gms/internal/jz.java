package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;

final class jz
  implements ServiceConnection
{
  jz(jr paramjr)
  {
  }

  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.a.c(paramIBinder);
  }

  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.a.b.sendMessage(this.a.b.obtainMessage(4, Integer.valueOf(1)));
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jz
 * JD-Core Version:    0.6.0
 */