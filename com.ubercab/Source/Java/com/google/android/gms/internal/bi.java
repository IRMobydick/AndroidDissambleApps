package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.doubleclick.c;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;

public class bi
{
  private final Context mContext;
  private AdListener nR;
  private String oA;
  private InAppPurchaseListener oC;
  private PlayStorePurchaseListener oD;
  private PublisherInterstitialAd oF;
  private c oG;
  private AppEventListener oi;
  private String ok;
  private final cs ox = new cs();
  private final ax oy;
  private bd oz;

  public bi(Context paramContext)
  {
    this(paramContext, ax.bb(), null);
  }

  public bi(Context paramContext, PublisherInterstitialAd paramPublisherInterstitialAd)
  {
    this(paramContext, ax.bb(), paramPublisherInterstitialAd);
  }

  public bi(Context paramContext, ax paramax, PublisherInterstitialAd paramPublisherInterstitialAd)
  {
    this.mContext = paramContext;
    this.oy = paramax;
    this.oF = paramPublisherInterstitialAd;
  }

  private void v(String paramString)
    throws RemoteException
  {
    if (this.ok == null)
      w(paramString);
    this.oz = au.a(this.mContext, new ay(), this.ok, this.ox);
    if (this.nR != null)
      this.oz.a(new at(this.nR));
    if (this.oi != null)
      this.oz.a(new ba(this.oi));
    if (this.oC != null)
      this.oz.a(new em(this.oC));
    if (this.oD != null)
      this.oz.a(new eq(this.oD), this.oA);
    if (this.oG != null)
      this.oz.a(new ex(this.oG, this.oF));
  }

  private void w(String paramString)
  {
    if (this.oz == null)
      throw new IllegalStateException("The ad unit ID must be set on InterstitialAd before " + paramString + " is called.");
  }

  public void a(bg parambg)
  {
    try
    {
      if (this.oz == null)
        v("loadAd");
      if (this.oz.a(this.oy.a(this.mContext, parambg)))
        this.ox.d(parambg.be());
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gs.d("Failed to load ad.", localRemoteException);
    }
  }

  public AdListener getAdListener()
  {
    return this.nR;
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

  public boolean isLoaded()
  {
    try
    {
      if (this.oz == null)
        return false;
      boolean bool = this.oz.isReady();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      gs.d("Failed to check if ad is ready.", localRemoteException);
    }
    return false;
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

  public void setAdUnitId(String paramString)
  {
    if (this.ok != null)
      throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
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
          break label57;
      }
      label57: for (em localem = new em(paramInAppPurchaseListener); ; localem = null)
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
    try
    {
      this.oD = paramPlayStorePurchaseListener;
      bd localbd;
      if (this.oz != null)
      {
        localbd = this.oz;
        if (paramPlayStorePurchaseListener == null)
          break label43;
      }
      label43: for (eq localeq = new eq(paramPlayStorePurchaseListener); ; localeq = null)
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

  public void show()
  {
    try
    {
      w("show");
      this.oz.showInterstitial();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gs.d("Failed to show interstitial.", localRemoteException);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.bi
 * JD-Core Version:    0.6.2
 */