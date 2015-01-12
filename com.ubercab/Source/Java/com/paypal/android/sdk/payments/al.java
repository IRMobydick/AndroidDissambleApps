package com.paypal.android.sdk.payments;

import android.content.Intent;
import android.widget.LinearLayout;
import com.paypal.android.sdk.bF;
import com.paypal.android.sdk.bG;
import com.paypal.android.sdk.bL;
import com.paypal.android.sdk.bs;

final class al
  implements V
{
  al(ak paramak)
  {
  }

  public final void a(Z paramZ)
  {
    PaymentConfirmActivity.e(this.a.a).b().a();
    this.a.a.dismissDialog(2);
    if ((paramZ.a()) && (!"UNAUTHORIZED_PAYMENT".equals(paramZ.b)))
    {
      switch (ao.a[PaymentConfirmActivity.h(this.a.a).ordinal()])
      {
      default:
        return;
      case 1:
        d.a(this.a.a, bF.a(bG.O), 4);
        return;
      case 2:
      case 3:
      }
      this.a.a.showDialog(2);
      PaymentConfirmActivity.a();
      new StringBuilder("server thinks token is expired, get new one. AccessToken: ").append(PaymentConfirmActivity.e(this.a.a).b().c).toString();
      PaymentConfirmActivity.e(this.a.a).a(PaymentConfirmActivity.i(this.a.a), true);
      return;
    }
    PaymentConfirmActivity.j(this.a.a).d.setEnabled(true);
    d.a(this.a.a, bF.a(paramZ.b), 1);
  }

  public final void a(Object paramObject)
  {
    ProofOfPayment localProofOfPayment = (ProofOfPayment)paramObject;
    PaymentConfirmation localPaymentConfirmation = new PaymentConfirmation(PaymentConfirmActivity.e(this.a.a).d(), PaymentConfirmActivity.f(this.a.a).a(), localProofOfPayment);
    Intent localIntent = this.a.a.getIntent();
    localIntent.putExtra("com.paypal.android.sdk.paymentConfirmation", localPaymentConfirmation);
    PaymentConfirmActivity.g(this.a.a);
    this.a.a.setResult(-1, localIntent);
    this.a.a.finish();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.al
 * JD-Core Version:    0.6.2
 */