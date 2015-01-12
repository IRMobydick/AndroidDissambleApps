package com.paypal.android.sdk.payments;

import android.view.View;
import android.view.View.OnClickListener;

final class aj
  implements View.OnClickListener
{
  aj(PaymentConfirmActivity paramPaymentConfirmActivity)
  {
  }

  public final void onClick(View paramView)
  {
    paramView.setEnabled(false);
    PaymentConfirmActivity.a(this.a);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.aj
 * JD-Core Version:    0.6.2
 */