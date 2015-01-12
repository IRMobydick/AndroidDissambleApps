package com.paypal.android.sdk.payments;

import android.content.Intent;
import android.util.Log;

abstract class o
{
  private Intent a;
  private PayPalConfiguration b;

  o(Intent paramIntent, PayPalConfiguration paramPayPalConfiguration)
  {
    this.a = paramIntent;
    this.b = paramPayPalConfiguration;
  }

  abstract String a();

  protected final void a(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean)
      Log.e(a(), paramString + " is invalid.  Please see the docs.");
  }

  final Intent b()
  {
    return this.a;
  }

  final PayPalConfiguration c()
  {
    return this.b;
  }

  protected final boolean d()
  {
    if (!this.b.o())
    {
      Log.e(a(), "Service extra invalid.");
      return false;
    }
    return true;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.o
 * JD-Core Version:    0.6.2
 */