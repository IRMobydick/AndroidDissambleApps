package com.google.android.gms.internal;

import com.google.android.gms.ads.AdListener;

@ez
public final class at extends bc.a
{
  private final AdListener nR;

  public at(AdListener paramAdListener)
  {
    this.nR = paramAdListener;
  }

  public void onAdClosed()
  {
    this.nR.onAdClosed();
  }

  public void onAdFailedToLoad(int paramInt)
  {
    this.nR.onAdFailedToLoad(paramInt);
  }

  public void onAdLeftApplication()
  {
    this.nR.onAdLeftApplication();
  }

  public void onAdLoaded()
  {
    this.nR.onAdLoaded();
  }

  public void onAdOpened()
  {
    this.nR.onAdOpened();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.at
 * JD-Core Version:    0.6.2
 */