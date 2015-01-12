package com.paypal.android.sdk.payments;

import android.content.Intent;

final class ai
{
  private Intent a;

  ai(Intent paramIntent)
  {
    this.a = paramIntent;
  }

  final PayPalPayment a()
  {
    return (PayPalPayment)this.a.getParcelableExtra("com.paypal.android.sdk.payment");
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.ai
 * JD-Core Version:    0.6.2
 */