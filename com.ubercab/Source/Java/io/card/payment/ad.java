package io.card.payment;

import org.apache.http.client.HttpResponseException;

final class ad extends f
{
  ad(c paramc)
  {
  }

  public final void a(String paramString)
  {
    this.a.authorizeScanSuccessful();
  }

  public final void a(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof HttpResponseException))
    {
      if (((HttpResponseException)paramThrowable).getStatusCode() == 401)
      {
        this.a.authorizeScanUnsuccessful();
        return;
      }
      this.a.authorizeScanFailed(paramThrowable);
      return;
    }
    this.a.authorizeScanFailed(paramThrowable);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     io.card.payment.ad
 * JD-Core Version:    0.6.2
 */