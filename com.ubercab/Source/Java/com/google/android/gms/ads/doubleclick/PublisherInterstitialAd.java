package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.internal.bi;

public final class PublisherInterstitialAd
{
  private final bi lj = new bi(paramContext, this);

  public PublisherInterstitialAd(Context paramContext)
  {
  }

  public AdListener getAdListener()
  {
    return this.lj.getAdListener();
  }

  public String getAdUnitId()
  {
    return this.lj.getAdUnitId();
  }

  public AppEventListener getAppEventListener()
  {
    return this.lj.getAppEventListener();
  }

  public String getMediationAdapterClassName()
  {
    return this.lj.getMediationAdapterClassName();
  }

  public boolean isLoaded()
  {
    return this.lj.isLoaded();
  }

  public void loadAd(PublisherAdRequest paramPublisherAdRequest)
  {
    this.lj.a(paramPublisherAdRequest.V());
  }

  public void setAdListener(AdListener paramAdListener)
  {
    this.lj.setAdListener(paramAdListener);
  }

  public void setAdUnitId(String paramString)
  {
    this.lj.setAdUnitId(paramString);
  }

  public void setAppEventListener(AppEventListener paramAppEventListener)
  {
    this.lj.setAppEventListener(paramAppEventListener);
  }

  public void show()
  {
    this.lj.show();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.doubleclick.PublisherInterstitialAd
 * JD-Core Version:    0.6.2
 */