package com.google.android.gms.internal;

import android.content.Intent;
import android.os.RemoteException;

class dm
  implements Runnable
{
  dm(dl paramdl, dp paramdp, Intent paramIntent)
  {
  }

  public void run()
  {
    try
    {
      if (dl.a(this.c).a(this.a.b, -1, this.b))
        dl.c(this.c).a(new dq(dl.b(this.c), this.a.c, true, -1, this.b, this.a));
      else
        dl.c(this.c).a(new dq(dl.b(this.c), this.a.c, false, -1, this.b, this.a));
    }
    catch (RemoteException localRemoteException)
    {
      hi.e("Fail to verify and dispatch pending transaction");
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.dm
 * JD-Core Version:    0.6.0
 */