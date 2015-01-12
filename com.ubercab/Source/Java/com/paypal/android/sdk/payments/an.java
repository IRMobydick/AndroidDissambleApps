package com.paypal.android.sdk.payments;

import android.widget.LinearLayout;
import com.paypal.android.sdk.bF;
import com.paypal.android.sdk.bL;

final class an
  implements Y
{
  an(PaymentConfirmActivity paramPaymentConfirmActivity)
  {
  }

  public final void a()
  {
    PaymentConfirmActivity.a();
    PaymentConfirmActivity.k(this.a);
  }

  public final void a(Z paramZ)
  {
    this.a.dismissDialog(2);
    d.a(this.a, bF.a(paramZ.b), 1);
    PaymentConfirmActivity.j(this.a).d.setEnabled(true);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.an
 * JD-Core Version:    0.6.2
 */