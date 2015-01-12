package com.paypal.android.sdk.payments;

import java.util.TimerTask;

final class aw extends TimerTask
{
  aw(PaymentMethodActivity paramPaymentMethodActivity)
  {
  }

  public final void run()
  {
    this.a.removeDialog(3);
    PaymentConfirmActivity.a(this.a, 2, aq.a, null);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.aw
 * JD-Core Version:    0.6.2
 */