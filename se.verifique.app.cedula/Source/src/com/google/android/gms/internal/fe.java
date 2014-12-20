package com.google.android.gms.internal;

import android.os.RemoteException;

public abstract class fe extends gr
{
  private final ds a;
  private final fc b;

  public fe(ds paramds, fc paramfc)
  {
    this.a = paramds;
    this.b = paramfc;
  }

  private static du a(fq paramfq, ds paramds)
  {
    Object localObject = null;
    try
    {
      du localdu = paramfq.a(paramds);
      localObject = localdu;
      return localObject;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        hi.c("Could not fetch ad response from ad request service.", localRemoteException);
    }
    catch (NullPointerException localNullPointerException)
    {
      while (true)
        hi.c("Could not fetch ad response from ad request service due to an Exception.", localNullPointerException);
    }
    catch (SecurityException localSecurityException)
    {
      while (true)
        hi.c("Could not fetch ad response from ad request service due to an Exception.", localSecurityException);
    }
  }

  public final void a()
  {
    try
    {
      fq localfq = d();
      du localdu;
      if (localfq == null)
        localdu = new du(0);
      while (true)
      {
        c();
        this.b.a(localdu);
        return;
        localdu = a(localfq, this.a);
        if (localdu != null)
          continue;
        localdu = new du(0);
      }
    }
    finally
    {
      c();
    }
    throw localObject;
  }

  public final void b()
  {
    c();
  }

  public abstract void c();

  public abstract fq d();
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fe
 * JD-Core Version:    0.6.0
 */