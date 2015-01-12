package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;

@ez
public final class eq extends el.a
{
  private final PlayStorePurchaseListener oD;

  public eq(PlayStorePurchaseListener paramPlayStorePurchaseListener)
  {
    this.oD = paramPlayStorePurchaseListener;
  }

  public void a(ek paramek)
  {
    this.oD.onInAppPurchaseFinished(new eo(paramek));
  }

  public boolean isValidPurchase(String paramString)
  {
    return this.oD.isValidPurchase(paramString);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.eq
 * JD-Core Version:    0.6.2
 */