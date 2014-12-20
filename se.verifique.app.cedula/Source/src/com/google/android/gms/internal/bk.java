package com.google.android.gms.internal;

import android.os.RemoteException;

class bk
  implements Runnable
{
  bk(bj parambj, br parambr)
  {
  }

  public void run()
  {
    try
    {
      this.a.c.c();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        hi.c("Could not destroy mediation adapter.", localRemoteException);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.bk
 * JD-Core Version:    0.6.0
 */