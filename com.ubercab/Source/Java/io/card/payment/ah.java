package io.card.payment;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

final class ah
  implements HttpRequestInterceptor
{
  ah(a parama)
  {
  }

  public final void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext)
  {
    Iterator localIterator = a.a(this.a).keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramHttpRequest.addHeader(str, (String)a.a(this.a).get(str));
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     io.card.payment.ah
 * JD-Core Version:    0.6.2
 */