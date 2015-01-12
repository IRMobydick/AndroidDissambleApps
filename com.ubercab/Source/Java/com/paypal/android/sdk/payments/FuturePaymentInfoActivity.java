package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import com.paypal.android.sdk.R;
import com.paypal.android.sdk.bF;
import com.paypal.android.sdk.bG;

public final class FuturePaymentInfoActivity extends Activity
{
  private z a;

  protected final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    R.b(this);
    R.a(this);
    this.a = new z(this, bF.c(FuturePaymentConsentActivity.a));
    setContentView(this.a.a);
    d.a(this, this.a.b, null);
    this.a.c.setText(bF.a(bG.b));
    this.a.c.setOnClickListener(new y(this));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.FuturePaymentInfoActivity
 * JD-Core Version:    0.6.2
 */