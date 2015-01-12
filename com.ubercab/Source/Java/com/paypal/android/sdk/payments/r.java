package com.paypal.android.sdk.payments;

import android.view.View;
import android.view.View.OnClickListener;

final class r
  implements View.OnClickListener
{
  r(FuturePaymentConsentActivity paramFuturePaymentConsentActivity)
  {
  }

  public final void onClick(View paramView)
  {
    paramView.setEnabled(false);
    FuturePaymentConsentActivity.d(this.a);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.r
 * JD-Core Version:    0.6.2
 */