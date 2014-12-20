package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class i
  implements ServiceConnection
{
  boolean a = false;
  private final BlockingQueue b = new LinkedBlockingQueue();

  public IBinder a()
  {
    if (this.a)
      throw new IllegalStateException();
    this.a = true;
    return (IBinder)this.b.take();
  }

  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      this.b.put(paramIBinder);
      label10: return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label10;
    }
  }

  public void onServiceDisconnected(ComponentName paramComponentName)
  {
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.i
 * JD-Core Version:    0.6.0
 */