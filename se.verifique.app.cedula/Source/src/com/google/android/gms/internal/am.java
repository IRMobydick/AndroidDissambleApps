package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.d.b;
import com.google.android.gms.ads.d.d;

public final class am
{
  private final bu a = new bu();
  private final Context b;
  private final q c;
  private com.google.android.gms.ads.a d;
  private y e;
  private String f;
  private String g;
  private com.google.android.gms.ads.a.a h;
  private d i;
  private b j;

  public am(Context paramContext)
  {
    this(paramContext, q.a());
  }

  public am(Context paramContext, q paramq)
  {
    this.b = paramContext;
    this.c = paramq;
  }

  private void b(String paramString)
  {
    if (this.f == null)
      c(paramString);
    this.e = o.a(this.b, new al(), this.f, this.a);
    if (this.d != null)
      this.e.a(new n(this.d));
    if (this.h != null)
      this.e.a(new s(this.h));
    if (this.j != null)
      this.e.a(new em(this.j));
    if (this.i != null)
      this.e.a(new ep(this.i), this.g);
  }

  private void c(String paramString)
  {
    if (this.e == null)
      throw new IllegalStateException("The ad unit ID must be set on InterstitialAd before " + paramString + " is called.");
  }

  public void a(com.google.android.gms.ads.a parama)
  {
    try
    {
      this.d = parama;
      y localy;
      if (this.e != null)
      {
        localy = this.e;
        if (parama == null)
          break label40;
      }
      label40: for (n localn = new n(parama); ; localn = null)
      {
        localy.a(localn);
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        hi.c("Failed to set the AdListener.", localRemoteException);
    }
  }

  public void a(ah paramah)
  {
    try
    {
      if (this.e == null)
        b("loadAd");
      if (this.e.a(this.c.a(this.b, paramah)))
        this.a.a(paramah.i());
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        hi.c("Failed to load ad.", localRemoteException);
    }
  }

  public void a(String paramString)
  {
    if (this.f != null)
      throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
    this.f = paramString;
  }

  public boolean a()
  {
    int k = 0;
    try
    {
      if (this.e != null)
      {
        boolean bool = this.e.c();
        k = bool;
      }
    }
    catch (RemoteException localRemoteException)
    {
      hi.c("Failed to check if ad is ready.", localRemoteException);
    }
    return k;
  }

  public void b()
  {
    try
    {
      c("show");
      this.e.f();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        hi.c("Failed to show interstitial.", localRemoteException);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.am
 * JD-Core Version:    0.6.0
 */