package com.paypal.android.sdk.payments;

import com.paypal.android.sdk.J;
import com.paypal.android.sdk.bs;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

final class ac
{
  private PayPalService a;
  private String b;

  public ac(PayPalService paramPayPalService)
  {
    this.a = paramPayPalService;
    this.b = Integer.toString(new GregorianCalendar().getTimeZone().getRawOffset() / 1000 / 60);
  }

  public final bs a()
  {
    return this.a.b();
  }

  public final String b()
  {
    return this.a.e();
  }

  public final J c()
  {
    return this.a.a();
  }

  public final String d()
  {
    return this.a.d();
  }

  public final String e()
  {
    return this.b;
  }

  public final String f()
  {
    return this.a.s();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.ac
 * JD-Core Version:    0.6.2
 */