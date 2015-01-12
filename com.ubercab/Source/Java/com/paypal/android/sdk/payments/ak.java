package com.paypal.android.sdk.payments;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

final class ak
  implements ServiceConnection
{
  ak(PaymentConfirmActivity paramPaymentConfirmActivity)
  {
  }

  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    new StringBuilder().append(PaymentConfirmActivity.class.getSimpleName()).append(".onServiceConnected").toString();
    PaymentConfirmActivity.a(this.a, ((W)paramIBinder).a());
    PaymentConfirmActivity.b(this.a);
    PaymentConfirmActivity.c(this.a);
    PaymentConfirmActivity.d(this.a);
    PaymentConfirmActivity.e(this.a).a(new al(this));
  }

  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    PaymentConfirmActivity.a(this.a, null);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.ak
 * JD-Core Version:    0.6.2
 */