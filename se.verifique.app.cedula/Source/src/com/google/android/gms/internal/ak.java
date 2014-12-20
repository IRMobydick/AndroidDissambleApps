package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.d.b;
import com.google.android.gms.ads.e;

public final class ak
{
  private final bu a = new bu();
  private final q b;
  private com.google.android.gms.ads.a c;
  private y d;
  private e[] e;
  private String f;
  private String g;
  private ViewGroup h;
  private com.google.android.gms.ads.a.a i;
  private b j;
  private com.google.android.gms.ads.d.d k;

  public ak(ViewGroup paramViewGroup)
  {
    this(paramViewGroup, null, false, q.a());
  }

  ak(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean, q paramq)
  {
    this.h = paramViewGroup;
    this.b = paramq;
    Context localContext;
    if (paramAttributeSet != null)
      localContext = paramViewGroup.getContext();
    try
    {
      t localt = new t(localContext, paramAttributeSet);
      this.e = localt.a(paramBoolean);
      this.f = localt.a();
      if (paramViewGroup.isInEditMode())
        hh.a(paramViewGroup, new al(localContext, this.e[0]), "Ads by Google");
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (true)
        hh.a(paramViewGroup, new al(localContext, e.a), localIllegalArgumentException.getMessage(), localIllegalArgumentException.getMessage());
    }
  }

  private void h()
  {
    try
    {
      com.google.android.gms.a.a locala = this.d.a();
      if (locala != null)
        this.h.addView((View)com.google.android.gms.a.d.a(locala));
    }
    catch (RemoteException localRemoteException)
    {
      hi.c("Failed to get an ad frame.", localRemoteException);
    }
  }

  private void i()
  {
    if (((this.e == null) || (this.f == null)) && (this.d == null))
      throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
    Context localContext = this.h.getContext();
    this.d = o.a(localContext, new al(localContext, this.e), this.f, this.a);
    if (this.c != null)
      this.d.a(new n(this.c));
    if (this.i != null)
      this.d.a(new s(this.i));
    if (this.j != null)
      this.d.a(new em(this.j));
    if (this.k != null)
      this.d.a(new ep(this.k), this.g);
    h();
  }

  public void a()
  {
    try
    {
      if (this.d != null)
        this.d.b();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        hi.c("Failed to destroy AdView.", localRemoteException);
    }
  }

  public void a(com.google.android.gms.ads.a parama)
  {
    try
    {
      this.c = parama;
      y localy;
      if (this.d != null)
      {
        localy = this.d;
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

  public void a(b paramb)
  {
    if (this.k != null)
      throw new IllegalStateException("Play store purchase parameter has already been set.");
    try
    {
      this.j = paramb;
      y localy;
      if (this.d != null)
      {
        localy = this.d;
        if (paramb == null)
          break label57;
      }
      label57: for (em localem = new em(paramb); ; localem = null)
      {
        localy.a(localem);
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        hi.c("Failed to set the InAppPurchaseListener.", localRemoteException);
    }
  }

  public void a(ah paramah)
  {
    try
    {
      if (this.d == null)
        i();
      if (this.d.a(this.b.a(this.h.getContext(), paramah)))
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
      throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
    this.f = paramString;
  }

  public void a(e[] paramArrayOfe)
  {
    if (this.e != null)
      throw new IllegalStateException("The ad size can only be set once on AdView.");
    b(paramArrayOfe);
  }

  public com.google.android.gms.ads.a b()
  {
    return this.c;
  }

  public void b(e[] paramArrayOfe)
  {
    this.e = paramArrayOfe;
    try
    {
      if (this.d != null)
        this.d.a(new al(this.h.getContext(), this.e));
      this.h.requestLayout();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        hi.c("Failed to set the ad size.", localRemoteException);
    }
  }

  public e c()
  {
    try
    {
      if (this.d != null)
      {
        e locale2 = this.d.i().a();
        locale1 = locale2;
        return locale1;
      }
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
      {
        hi.c("Failed to get the current AdSize.", localRemoteException);
        if (this.e != null)
        {
          locale1 = this.e[0];
          continue;
        }
        e locale1 = null;
      }
    }
  }

  public String d()
  {
    return this.f;
  }

  public b e()
  {
    return this.j;
  }

  public void f()
  {
    try
    {
      if (this.d != null)
        this.d.d();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        hi.c("Failed to call pause.", localRemoteException);
    }
  }

  public void g()
  {
    try
    {
      if (this.d != null)
        this.d.e();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        hi.c("Failed to call resume.", localRemoteException);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ak
 * JD-Core Version:    0.6.0
 */