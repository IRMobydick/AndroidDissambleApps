package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.doubleclick.b;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;

public final class bh
{
  private AdListener nR;
  private String oA;
  private ViewGroup oB;
  private InAppPurchaseListener oC;
  private PlayStorePurchaseListener oD;
  private b oE;
  private AppEventListener oi;
  private AdSize[] oj;
  private String ok;
  private final cs ox = new cs();
  private final ax oy;
  private bd oz;

  public bh(ViewGroup paramViewGroup)
  {
    this(paramViewGroup, null, false, ax.bb());
  }

  public bh(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    this(paramViewGroup, paramAttributeSet, paramBoolean, ax.bb());
  }

  bh(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean, ax paramax)
  {
    this(paramViewGroup, paramAttributeSet, paramBoolean, paramax, null);
  }

  bh(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean, ax paramax, bd parambd)
  {
    this.oB = paramViewGroup;
    this.oy = paramax;
    if (paramAttributeSet != null)
    {
      Context localContext = paramViewGroup.getContext();
      try
      {
        bb localbb = new bb(localContext, paramAttributeSet);
        this.oj = localbb.f(paramBoolean);
        this.ok = localbb.getAdUnitId();
        if (paramViewGroup.isInEditMode())
        {
          gr.a(paramViewGroup, new ay(localContext, this.oj[0]), "Ads by Google");
          return;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        gr.a(paramViewGroup, new ay(localContext, AdSize.BANNER), localIllegalArgumentException.getMessage(), localIllegalArgumentException.getMessage());
        return;
      }
    }
    this.oz = parambd;
  }

  private void bh()
  {
    try
    {
      d locald = this.oz.X();
      if (locald == null)
        return;
      this.oB.addView((View)e.f(locald));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gs.d("Failed to get an ad frame.", localRemoteException);
    }
  }

  private void bi()
    throws RemoteException
  {
    if (((this.oj == null) || (this.ok == null)) && (this.oz == null))
      throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
    Context localContext = this.oB.getContext();
    this.oz = au.a(localContext, new ay(localContext, this.oj), this.ok, this.ox);
    if (this.nR != null)
      this.oz.a(new at(this.nR));
    if (this.oi != null)
      this.oz.a(new ba(this.oi));
    if (this.oC != null)
      this.oz.a(new em(this.oC));
    if (this.oD != null)
      this.oz.a(new eq(this.oD), this.oA);
    if (this.oE != null)
      this.oz.a(new ew(this.oE, (PublisherAdView)this.oB));
    bh();
  }

  public void a(bg parambg)
  {
    try
    {
      if (this.oz == null)
        bi();
      if (this.oz.a(this.oy.a(this.oB.getContext(), parambg)))
        this.ox.d(parambg.be());
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gs.d("Failed to load ad.", localRemoteException);
    }
  }

  public void a(AdSize[] paramArrayOfAdSize)
  {
    this.oj = paramArrayOfAdSize;
    try
    {
      if (this.oz != null)
        this.oz.a(new ay(this.oB.getContext(), this.oj));
      this.oB.requestLayout();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        gs.d("Failed to set the ad size.", localRemoteException);
    }
  }

  public void destroy()
  {
    try
    {
      if (this.oz != null)
        this.oz.destroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gs.d("Failed to destroy AdView.", localRemoteException);
    }
  }

  public AdListener getAdListener()
  {
    return this.nR;
  }

  public AdSize getAdSize()
  {
    try
    {
      if (this.oz != null)
      {
        AdSize localAdSize = this.oz.Y().bc();
        return localAdSize;
      }
    }
    catch (RemoteException localRemoteException)
    {
      gs.d("Failed to get the current AdSize.", localRemoteException);
      if (this.oj != null)
        return this.oj[0];
    }
    return null;
  }

  public AdSize[] getAdSizes()
  {
    return this.oj;
  }

  public String getAdUnitId()
  {
    return this.ok;
  }

  public AppEventListener getAppEventListener()
  {
    return this.oi;
  }

  public InAppPurchaseListener getInAppPurchaseListener()
  {
    return this.oC;
  }

  public String getMediationAdapterClassName()
  {
    try
    {
      if (this.oz != null)
      {
        String str = this.oz.getMediationAdapterClassName();
        return str;
      }
    }
    catch (RemoteException localRemoteException)
    {
      gs.d("Failed to get the mediation adapter class name.", localRemoteException);
    }
    return null;
  }

  public void pause()
  {
    try
    {
      if (this.oz != null)
        this.oz.pause();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gs.d("Failed to call pause.", localRemoteException);
    }
  }

  public void recordManualImpression()
  {
    try
    {
      if (this.oz != null)
        this.oz.aj();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gs.d("Failed to record impression.", localRemoteException);
    }
  }

  public void resume()
  {
    try
    {
      if (this.oz != null)
        this.oz.resume();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gs.d("Failed to call resume.", localRemoteException);
    }
  }

  public void setAdListener(AdListener paramAdListener)
  {
    try
    {
      this.nR = paramAdListener;
      bd localbd;
      if (this.oz != null)
      {
        localbd = this.oz;
        if (paramAdListener == null)
          break label40;
      }
      label40: for (at localat = new at(paramAdListener); ; localat = null)
      {
        localbd.a(localat);
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      gs.d("Failed to set the AdListener.", localRemoteException);
    }
  }

  public void setAdSizes(AdSize[] paramArrayOfAdSize)
  {
    if (this.oj != null)
      throw new IllegalStateException("The ad size can only be set once on AdView.");
    a(paramArrayOfAdSize);
  }

  public void setAdUnitId(String paramString)
  {
    if (this.ok != null)
      throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
    this.ok = paramString;
  }

  public void setAppEventListener(AppEventListener paramAppEventListener)
  {
    try
    {
      this.oi = paramAppEventListener;
      bd localbd;
      if (this.oz != null)
      {
        localbd = this.oz;
        if (paramAppEventListener == null)
          break label40;
      }
      label40: for (ba localba = new ba(paramAppEventListener); ; localba = null)
      {
        localbd.a(localba);
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      gs.d("Failed to set the AppEventListener.", localRemoteException);
    }
  }

  public void setInAppPurchaseListener(InAppPurchaseListener paramInAppPurchaseListener)
  {
    if (this.oD != null)
      throw new IllegalStateException("Play store purchase parameter has already been set.");
    try
    {
      this.oC = paramInAppPurchaseListener;
      bd localbd;
      if (this.oz != null)
      {
        localbd = this.oz;
        if (paramInAppPurchaseListener == null)
          break label58;
      }
      label58: for (em localem = new em(paramInAppPurchaseListener); ; localem = null)
      {
        localbd.a(localem);
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      gs.d("Failed to set the InAppPurchaseListener.", localRemoteException);
    }
  }

  public void setPlayStorePurchaseParams(PlayStorePurchaseListener paramPlayStorePurchaseListener, String paramString)
  {
    if (this.oC != null)
      throw new IllegalStateException("InAppPurchaseListener has already been set.");
    try
    {
      this.oD = paramPlayStorePurchaseListener;
      this.oA = paramString;
      bd localbd;
      if (this.oz != null)
      {
        localbd = this.oz;
        if (paramPlayStorePurchaseListener == null)
          break label66;
      }
      label66: for (eq localeq = new eq(paramPlayStorePurchaseListener); ; localeq = null)
      {
        localbd.a(localeq, paramString);
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      gs.d("Failed to set the play store purchase parameter.", localRemoteException);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.bh
 * JD-Core Version:    0.6.2
 */