package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.bi;

public final class InterstitialAd
{
  private final bi lj;

  public InterstitialAd(Context paramContext)
  {
    this.lj = new bi(paramContext);
  }

  public AdListener getAdListener()
  {
    return this.lj.getAdListener();
  }

  public String getAdUnitId()
  {
    return this.lj.getAdUnitId();
  }

  public InAppPurchaseListener getInAppPurchaseListener()
  {
    return this.lj.getInAppPurchaseListener();
  }

  public String getMediationAdapterClassName()
  {
    return this.lj.getMediationAdapterClassName();
  }

  public boolean isLoaded()
  {
    return this.lj.isLoaded();
  }

  public void loadAd(AdRequest paramAdRequest)
  {
    this.lj.a(paramAdRequest.V());
  }

  public void setAdListener(AdListener paramAdListener)
  {
    this.lj.setAdListener(paramAdListener);
  }

  public void setAdUnitId(String paramString)
  {
    this.lj.setAdUnitId(paramString);
  }

  public void setInAppPurchaseListener(InAppPurchaseListener paramInAppPurchaseListener)
  {
    this.lj.setInAppPurchaseListener(paramInAppPurchaseListener);
  }

  public void setPlayStorePurchaseParams(PlayStorePurchaseListener paramPlayStorePurchaseListener, String paramString)
  {
    this.lj.setPlayStorePurchaseParams(paramPlayStorePurchaseListener, paramString);
  }

  public void show()
  {
    this.lj.show();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.InterstitialAd
 * JD-Core Version:    0.6.2
 */