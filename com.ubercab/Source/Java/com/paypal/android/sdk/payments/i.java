package com.paypal.android.sdk.payments;

import com.paypal.android.sdk.bE;

final class i
  implements l
{
  private k a;
  private j b;

  public i(PayPalService paramPayPalService)
  {
    this.a = new k(paramPayPalService);
    this.b = new j(paramPayPalService);
  }

  public final void a(bE parambE, boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    this.a.a(parambE, paramBoolean, paramString1, paramString2, null);
    this.b.a(parambE, paramBoolean, paramString1, paramString2, paramString3);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.i
 * JD-Core Version:    0.6.2
 */