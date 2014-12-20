package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.c.c;
import com.google.android.gms.ads.c.d;
import com.google.android.gms.ads.c.e;
import com.google.android.gms.ads.c.f;

public final class ci
  implements d, f
{
  private final cb a;

  public ci(cb paramcb)
  {
    this.a = paramcb;
  }

  public void a(c paramc)
  {
    kx.b("onAdLoaded must be called on the main UI thread.");
    hi.a("Adapter called onAdLoaded.");
    try
    {
      this.a.e();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        hi.c("Could not call onAdLoaded.", localRemoteException);
    }
  }

  public void a(c paramc, int paramInt)
  {
    kx.b("onAdFailedToLoad must be called on the main UI thread.");
    hi.a("Adapter called onAdFailedToLoad with error. " + paramInt);
    try
    {
      this.a.a(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        hi.c("Could not call onAdFailedToLoad.", localRemoteException);
    }
  }

  public void a(e parame)
  {
    kx.b("onAdLoaded must be called on the main UI thread.");
    hi.a("Adapter called onAdLoaded.");
    try
    {
      this.a.e();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        hi.c("Could not call onAdLoaded.", localRemoteException);
    }
  }

  public void a(e parame, int paramInt)
  {
    kx.b("onAdFailedToLoad must be called on the main UI thread.");
    hi.a("Adapter called onAdFailedToLoad with error " + paramInt + ".");
    try
    {
      this.a.a(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        hi.c("Could not call onAdFailedToLoad.", localRemoteException);
    }
  }

  public void b(c paramc)
  {
    kx.b("onAdOpened must be called on the main UI thread.");
    hi.a("Adapter called onAdOpened.");
    try
    {
      this.a.d();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        hi.c("Could not call onAdOpened.", localRemoteException);
    }
  }

  public void b(e parame)
  {
    kx.b("onAdOpened must be called on the main UI thread.");
    hi.a("Adapter called onAdOpened.");
    try
    {
      this.a.d();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        hi.c("Could not call onAdOpened.", localRemoteException);
    }
  }

  public void c(c paramc)
  {
    kx.b("onAdClosed must be called on the main UI thread.");
    hi.a("Adapter called onAdClosed.");
    try
    {
      this.a.b();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        hi.c("Could not call onAdClosed.", localRemoteException);
    }
  }

  public void c(e parame)
  {
    kx.b("onAdClosed must be called on the main UI thread.");
    hi.a("Adapter called onAdClosed.");
    try
    {
      this.a.b();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        hi.c("Could not call onAdClosed.", localRemoteException);
    }
  }

  public void d(c paramc)
  {
    kx.b("onAdLeftApplication must be called on the main UI thread.");
    hi.a("Adapter called onAdLeftApplication.");
    try
    {
      this.a.c();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        hi.c("Could not call onAdLeftApplication.", localRemoteException);
    }
  }

  public void d(e parame)
  {
    kx.b("onAdLeftApplication must be called on the main UI thread.");
    hi.a("Adapter called onAdLeftApplication.");
    try
    {
      this.a.c();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        hi.c("Could not call onAdLeftApplication.", localRemoteException);
    }
  }

  public void e(c paramc)
  {
    kx.b("onAdClicked must be called on the main UI thread.");
    hi.a("Adapter called onAdClicked.");
    try
    {
      this.a.a();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        hi.c("Could not call onAdClicked.", localRemoteException);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ci
 * JD-Core Version:    0.6.0
 */