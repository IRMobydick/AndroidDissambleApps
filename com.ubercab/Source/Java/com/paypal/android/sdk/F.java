package com.paypal.android.sdk;

import android.util.Log;
import java.io.IOException;
import java.util.Locale;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;

final class F extends bW
{
  private final al a;

  private F(D paramD, al paramal)
  {
    this.a = paramal;
  }

  private String a(String paramString)
  {
    Locale localLocale = Locale.US;
    String str = this.a.A() + " PayPal Debug-ID: %s [%s, %s]";
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = paramString;
    arrayOfObject[1] = D.b(this.b);
    arrayOfObject[2] = (D.c(this.b).a() + ";release");
    return String.format(localLocale, str, arrayOfObject);
  }

  public final void a(String paramString1, String paramString2)
  {
    this.a.b(paramString1);
    this.a.c(paramString2);
    D.c();
    new StringBuilder().append(this.a.A()).append(" success. response: ").append(this.a.v()).toString();
    if (R.d(paramString2))
      Log.w("paypal.sdk", a(paramString2));
    if (this.a.D())
      D.a(this.a);
    D.a(this.b).a(this.a);
  }

  public final void a(Throwable paramThrowable, String paramString1, String paramString2)
  {
    this.a.b(paramString1);
    if (R.d(paramString2))
      Log.w("paypal.sdk", a(paramString2));
    if ((paramThrowable instanceof NoHttpResponseException))
    {
      D.d(this.b).a().getConnectionManager().closeExpiredConnections();
      this.b.b(this.a);
      return;
    }
    D.a(this.b, this.a, (IOException)paramThrowable);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.F
 * JD-Core Version:    0.6.2
 */