package com.google.android.gms.ads.purchase;

import android.content.Intent;

public abstract interface InAppPurchaseResult
{
  public abstract void finishPurchase();

  public abstract String getProductId();

  public abstract Intent getPurchaseData();

  public abstract int getResultCode();

  public abstract boolean isVerified();
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.purchase.InAppPurchaseResult
 * JD-Core Version:    0.6.2
 */