package io.card.payment;

import android.os.SystemClock;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

final class am
  implements HttpRequestRetryHandler
{
  private static HashSet a = new HashSet();
  private static HashSet b = new HashSet();
  private final int c = 2;

  static
  {
    a.add(NoHttpResponseException.class);
    a.add(UnknownHostException.class);
    a.add(SocketException.class);
    b.add(InterruptedIOException.class);
    b.add(SSLHandshakeException.class);
  }

  public final boolean retryRequest(IOException paramIOException, int paramInt, HttpContext paramHttpContext)
  {
    Boolean localBoolean = (Boolean)paramHttpContext.getAttribute("http.request_sent");
    int i;
    boolean bool;
    if ((localBoolean != null) && (localBoolean.booleanValue()))
    {
      i = 1;
      if ((paramInt > 2) || (b.contains(paramIOException.getClass())))
        break label124;
      if (!a.contains(paramIOException.getClass()))
        break label83;
      bool = true;
    }
    while (true)
    {
      if (!bool)
        break label130;
      SystemClock.sleep(1500L);
      return bool;
      i = 0;
      break;
      label83: if (i == 0)
        bool = true;
      else if (!((HttpUriRequest)paramHttpContext.getAttribute("http.request")).getMethod().equals("POST"))
        bool = true;
      else
        label124: bool = false;
    }
    label130: paramIOException.printStackTrace();
    return bool;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     io.card.payment.am
 * JD-Core Version:    0.6.2
 */