package com.paypal.android.sdk.payments;

import android.widget.LinearLayout;
import com.paypal.android.sdk.bF;
import com.paypal.android.sdk.bK;

final class F
  implements Y
{
  F(LoginActivity paramLoginActivity)
  {
  }

  public final void a()
  {
    LoginActivity.b(this.a);
    LoginActivity.e(this.a);
  }

  public final void a(Z paramZ)
  {
    this.a.dismissDialog(2);
    d.a(this.a, bF.a(paramZ.b), 1);
    LoginActivity.f(this.a).f.setEnabled(true);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.F
 * JD-Core Version:    0.6.2
 */