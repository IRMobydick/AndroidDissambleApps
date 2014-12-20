package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.a;

public final class kc extends jv
{
  public final int b;
  public final Bundle c;
  public final IBinder d;

  public kc(jr paramjr, int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    super(paramjr, Boolean.valueOf(true));
    this.b = paramInt;
    this.d = paramIBinder;
    this.c = paramBundle;
  }

  protected void a()
  {
  }

  protected void a(Boolean paramBoolean)
  {
    if (paramBoolean == null)
    {
      jr.a(this.e, 1);
      return;
    }
    switch (this.b)
    {
    default:
      if (this.c == null)
        break;
    case 0:
    case 10:
    }
    for (PendingIntent localPendingIntent = (PendingIntent)this.c.getParcelable("pendingIntent"); ; localPendingIntent = null)
    {
      while (true)
      {
        if (jr.d(this.e) != null)
        {
          kg.a(jr.e(this.e)).b(this.e.a(), jr.d(this.e));
          jr.a(this.e, null);
        }
        jr.a(this.e, 1);
        jr.a(this.e, null);
        jr.a(this.e).a(new a(this.b, localPendingIntent));
        break;
        try
        {
          String str = this.d.getInterfaceDescriptor();
          if (this.e.b().equals(str))
          {
            jr.a(this.e, this.e.b(this.d));
            if (jr.c(this.e) != null)
            {
              jr.a(this.e, 3);
              jr.a(this.e).a();
            }
          }
        }
        catch (RemoteException localRemoteException)
        {
          kg.a(jr.e(this.e)).b(this.e.a(), jr.d(this.e));
          jr.a(this.e, null);
          jr.a(this.e, 1);
          jr.a(this.e, null);
          jr.a(this.e).a(new a(8, null));
        }
      }
      break;
      jr.a(this.e, 1);
      throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.kc
 * JD-Core Version:    0.6.0
 */