package com.paypal.android.sdk.payments;

import com.paypal.android.sdk.bG;

public enum PayPalScope
{
  private String a;
  private bG b;

  static
  {
    PayPalScope[] arrayOfPayPalScope = new PayPalScope[2];
    arrayOfPayPalScope[0] = FUTURE_PAYMENTS;
    arrayOfPayPalScope[1] = PROFILE;
  }

  private PayPalScope(String arg3, bG arg4)
  {
    Object localObject1;
    this.a = localObject1;
    Object localObject2;
    this.b = localObject2;
  }

  final bG a()
  {
    return this.b;
  }

  public final String getScopeUri()
  {
    return this.a;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.PayPalScope
 * JD-Core Version:    0.6.2
 */