package com.paypal.android.sdk.payments;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import java.util.Calendar;

final class ae
  implements ServiceConnection
{
  ae(PaymentActivity paramPaymentActivity)
  {
  }

  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    new StringBuilder().append(PaymentActivity.class.getSimpleName()).append(".onServiceConnected").toString();
    if (this.a.isFinishing())
    {
      new StringBuilder().append(PaymentActivity.class.getSimpleName()).append(".onServiceConnected exit - isFinishing").toString();
      return;
    }
    PaymentActivity.a(this.a, ((W)paramIBinder).a());
    if (PaymentActivity.b(this.a).c() == null)
    {
      Log.e(PaymentActivity.a(), "Service state invalid.  Did you start the PayPalService?");
      this.a.setResult(2);
      this.a.finish();
      return;
    }
    ah localah = new ah(this.a.getIntent(), PaymentActivity.b(this.a).c());
    if (!localah.d())
    {
      Log.e(PaymentActivity.a(), "Service extras invalid.  Please see the docs.");
      this.a.setResult(2);
      this.a.finish();
      return;
    }
    if (!localah.e())
    {
      Log.e(PaymentActivity.a(), "Extras invalid.  Please see the docs.");
      this.a.setResult(2);
      this.a.finish();
      return;
    }
    PaymentActivity.b(this.a).j();
    if (PaymentActivity.b(this.a).g())
    {
      PaymentActivity.c(this.a);
      return;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(13, 1);
    PaymentActivity.a(this.a, localCalendar.getTime());
    PaymentActivity.b(this.a).a(PaymentActivity.a(this.a), false);
  }

  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    PaymentActivity.a(this.a, null);
    PaymentActivity.a();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.ae
 * JD-Core Version:    0.6.2
 */