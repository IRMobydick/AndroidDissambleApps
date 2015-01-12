package com.paypal.android.sdk.payments;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class ax
  implements DialogInterface.OnClickListener
{
  ax(PaymentMethodActivity paramPaymentMethodActivity)
  {
  }

  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    PaymentMethodActivity.e(this.a).f();
    PaymentMethodActivity.f(this.a);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.ax
 * JD-Core Version:    0.6.2
 */