package io.card.payment;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.protocol.HttpContext;

final class ai
  implements HttpResponseInterceptor
{
  public final void process(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    Header localHeader = paramHttpResponse.getEntity().getContentEncoding();
    HeaderElement[] arrayOfHeaderElement;
    int i;
    if (localHeader != null)
    {
      arrayOfHeaderElement = localHeader.getElements();
      i = arrayOfHeaderElement.length;
    }
    for (int j = 0; ; j++)
      if (j < i)
      {
        if (arrayOfHeaderElement[j].getName().equalsIgnoreCase("gzip"))
          paramHttpResponse.setEntity(new aj(paramHttpResponse.getEntity()));
      }
      else
        return;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     io.card.payment.ai
 * JD-Core Version:    0.6.2
 */