package com.paypal.android.sdk.payments;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.paypal.android.sdk.bE;

final class az
  implements ServiceConnection
{
  az(PaymentMethodActivity paramPaymentMethodActivity)
  {
  }

  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    new StringBuilder().append(PaymentMethodActivity.class.getSimpleName()).append(".onServiceConnected").toString();
    if (this.a.isFinishing())
    {
      new StringBuilder().append(PaymentMethodActivity.class.getSimpleName()).append(".onServiceConnected exit - isFinishing").toString();
      return;
    }
    PaymentMethodActivity.a(this.a, ((W)paramIBinder).a());
    if (!PaymentMethodActivity.g(this.a))
    {
      PaymentMethodActivity.a(this.a, true);
      PaymentMethodActivity.e(this.a).a(bE.c);
    }
    PaymentMethodActivity.h(this.a);
    PaymentMethodActivity.f(this.a);
  }

  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    PaymentMethodActivity.a(this.a, null);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.az
 * JD-Core Version:    0.6.2
 */