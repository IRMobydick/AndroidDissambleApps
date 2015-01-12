package com.google.android.gms.ads.purchase;

public abstract interface PlayStorePurchaseListener
{
  public abstract boolean isValidPurchase(String paramString);

  public abstract void onInAppPurchaseFinished(InAppPurchaseResult paramInAppPurchaseResult);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.purchase.PlayStorePurchaseListener
 * JD-Core Version:    0.6.2
 */