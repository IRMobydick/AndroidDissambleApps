package com.google.android.gms.internal;

import android.content.Context;

final class gx
  implements Runnable
{
  gx(Context paramContext)
  {
  }

  public void run()
  {
    synchronized (gw.e())
    {
      gw.b(gw.d(this.a));
      gw.e().notifyAll();
      return;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gx
 * JD-Core Version:    0.6.0
 */