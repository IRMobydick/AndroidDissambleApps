package com.paypal.android.sdk;

import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;

final class G extends bW
{
  private final al a;

  private G(D paramD, al paramal)
  {
    this.a = paramal;
  }

  public final void a(String paramString1, String paramString2)
  {
    this.a.b(paramString1);
    D.c();
    new StringBuilder().append(this.a.A()).append(" success").toString();
  }

  public final void a(Throwable paramThrowable, String paramString)
  {
    this.a.b(paramString);
    if ((paramThrowable instanceof NoHttpResponseException))
    {
      D.e(this.b).a().getConnectionManager().closeExpiredConnections();
      this.b.b(this.a);
      return;
    }
    D.c();
    new StringBuilder().append(this.a.A()).append(" failure").toString();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.G
 * JD-Core Version:    0.6.2
 */