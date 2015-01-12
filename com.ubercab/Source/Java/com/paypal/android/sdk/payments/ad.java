package com.paypal.android.sdk.payments;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class ad
  implements DialogInterface.OnClickListener
{
  ad(PaymentActivity paramPaymentActivity)
  {
  }

  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    PaymentActivity.b(this.a).a(PaymentActivity.a(this.a), true);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.ad
 * JD-Core Version:    0.6.2
 */