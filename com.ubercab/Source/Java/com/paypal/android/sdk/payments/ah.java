package com.paypal.android.sdk.payments;

import android.content.Intent;

final class ah extends o
{
  ah(Intent paramIntent, PayPalConfiguration paramPayPalConfiguration)
  {
    super(paramIntent, paramPayPalConfiguration);
  }

  protected final String a()
  {
    return PaymentActivity.class.getSimpleName();
  }

  final boolean e()
  {
    ai localai = new ai(b());
    if ((localai.a() != null) && (localai.a().isProcessable()));
    for (boolean bool = true; ; bool = false)
    {
      a(bool, "PaymentActivity.EXTRA_PAYMENT");
      return bool;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.ah
 * JD-Core Version:    0.6.2
 */