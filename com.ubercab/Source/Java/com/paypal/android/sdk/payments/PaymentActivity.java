package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.paypal.android.sdk.R;
import com.paypal.android.sdk.bF;
import com.paypal.android.sdk.bG;
import com.paypal.android.sdk.bQ;
import java.util.Arrays;
import java.util.Date;
import java.util.Timer;

public final class PaymentActivity extends Activity
{
  public static final String EXTRA_PAYMENT = "com.paypal.android.sdk.payment";
  public static final String EXTRA_RESULT_CONFIRMATION = "com.paypal.android.sdk.paymentConfirmation";
  public static final int RESULT_EXTRAS_INVALID = 2;
  private static final String a = PaymentActivity.class.getSimpleName();
  private Timer b;
  private Date c;
  private PayPalService d;
  private final ServiceConnection e = new ae(this);
  private boolean f;

  public final void finish()
  {
    super.finish();
    new StringBuilder().append(getClass().getSimpleName()).append(".finish").toString();
  }

  protected final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    new StringBuilder().append(getClass().getSimpleName()).append(".onActivityResult").toString();
    if (paramInt1 == 1)
      switch (paramInt2)
      {
      default:
        Log.wtf(a, "unexpected request code " + paramInt1 + " call it a cancel");
      case 0:
      case -1:
      }
    while (true)
    {
      finish();
      return;
      if (paramIntent != null)
      {
        PaymentConfirmation localPaymentConfirmation = (PaymentConfirmation)paramIntent.getParcelableExtra("com.paypal.android.sdk.paymentConfirmation");
        if (localPaymentConfirmation != null)
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("com.paypal.android.sdk.paymentConfirmation", localPaymentConfirmation);
          setResult(-1, localIntent);
        }
        else
        {
          Log.e(a, "result was OK, have data, but no payment state in bundle, oops");
        }
      }
      else
      {
        Log.e(a, "result was OK, no intent data, oops");
      }
    }
  }

  protected final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    new StringBuilder().append(getClass().getSimpleName()).append(".onCreate").toString();
    new aB(this).a();
    b localb = new b(this);
    String[] arrayOfString = new String[4];
    arrayOfString[0] = PaymentActivity.class.getName();
    arrayOfString[1] = LoginActivity.class.getName();
    arrayOfString[2] = PaymentMethodActivity.class.getName();
    arrayOfString[3] = PaymentConfirmActivity.class.getName();
    localb.a(Arrays.asList(arrayOfString));
    this.f = bindService(d.b(this), this.e, 1);
    R.b(this);
    R.a(this);
    bQ localbQ = new bQ(this);
    setContentView(localbQ.a);
    localbQ.b.setText(bF.a(bG.d));
    d.a(this, null, bG.d);
  }

  protected final Dialog onCreateDialog(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default:
      return d.a(this, bG.U, paramBundle, paramInt);
    case 2:
      return d.a(this, new ad(this));
    case 3:
    }
    return d.a(this, bG.W, paramBundle, paramInt);
  }

  protected final void onDestroy()
  {
    new StringBuilder().append(getClass().getSimpleName()).append(".onDestroy").toString();
    if (this.d != null)
    {
      this.d.m();
      this.d.r();
    }
    if (this.f)
    {
      unbindService(this.e);
      this.f = false;
    }
    super.onDestroy();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.PaymentActivity
 * JD-Core Version:    0.6.2
 */