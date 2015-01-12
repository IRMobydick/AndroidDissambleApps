package com.paypal.android.sdk.payments;

import android.widget.LinearLayout;
import com.paypal.android.sdk.bF;
import com.paypal.android.sdk.bG;
import com.paypal.android.sdk.bI;

final class p
  implements V
{
  p(FuturePaymentConsentActivity paramFuturePaymentConsentActivity)
  {
  }

  public final void a(Z paramZ)
  {
    FuturePaymentConsentActivity.b(this.a).h.setEnabled(true);
    this.a.dismissDialog(2);
    if (paramZ.b.equals("invalid_request"))
    {
      d.a(this.a, bF.a(bG.O), 4);
      return;
    }
    d.a(this.a, bF.a(paramZ.b), 1);
  }

  public final void a(Object paramObject)
  {
    String str1 = FuturePaymentConsentActivity.a(this.a).d();
    String str2 = (String)paramObject;
    PayPalAuthorization localPayPalAuthorization = new PayPalAuthorization(str1, str2);
    FuturePaymentConsentActivity.a(this.a, -1, localPayPalAuthorization);
    this.a.finish();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.p
 * JD-Core Version:    0.6.2
 */