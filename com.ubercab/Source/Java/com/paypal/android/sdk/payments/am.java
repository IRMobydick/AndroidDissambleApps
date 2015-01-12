package com.paypal.android.sdk.payments;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class am
  implements DialogInterface.OnClickListener
{
  am(PaymentConfirmActivity paramPaymentConfirmActivity)
  {
  }

  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    PaymentConfirmActivity.a(this.a, true);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.am
 * JD-Core Version:    0.6.2
 */