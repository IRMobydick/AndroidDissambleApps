package com.paypal.android.sdk.payments;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

final class N
  implements Y
{
  N(PayPalFuturePaymentActivity paramPayPalFuturePaymentActivity)
  {
  }

  public final void a()
  {
    Date localDate = Calendar.getInstance().getTime();
    if (PayPalFuturePaymentActivity.d(this.a).compareTo(localDate) > 0)
    {
      long l = PayPalFuturePaymentActivity.d(this.a).getTime() - localDate.getTime();
      PayPalFuturePaymentActivity.a();
      new StringBuilder("Delaying ").append(l).append(" miliseconds so user doesn't see flicker.").toString();
      PayPalFuturePaymentActivity.a(this.a, new Timer());
      PayPalFuturePaymentActivity.e(this.a).schedule(new O(this), l);
      return;
    }
    PayPalFuturePaymentActivity.c(this.a);
  }

  public final void a(Z paramZ)
  {
    d.a(this.a, paramZ, 1, 2, 3);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.N
 * JD-Core Version:    0.6.2
 */