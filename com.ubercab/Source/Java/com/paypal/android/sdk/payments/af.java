package com.paypal.android.sdk.payments;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

final class af
  implements Y
{
  af(PaymentActivity paramPaymentActivity)
  {
  }

  public final void a()
  {
    Date localDate = Calendar.getInstance().getTime();
    if (PaymentActivity.d(this.a).compareTo(localDate) > 0)
    {
      long l = PaymentActivity.d(this.a).getTime() - localDate.getTime();
      PaymentActivity.a();
      new StringBuilder("Delaying ").append(l).append(" miliseconds so user doesn't see flicker.").toString();
      PaymentActivity.a(this.a, new Timer());
      PaymentActivity.e(this.a).schedule(new ag(this), l);
      return;
    }
    PaymentActivity.c(this.a);
  }

  public final void a(Z paramZ)
  {
    d.a(this.a, paramZ, 1, 2, 3);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.af
 * JD-Core Version:    0.6.2
 */