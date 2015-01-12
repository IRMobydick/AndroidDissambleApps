package io.card.payment;

import android.util.Log;
import java.io.IOException;
import java.net.ConnectException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

final class ak
  implements Runnable
{
  private final AbstractHttpClient a;
  private final HttpContext b;
  private final HttpUriRequest c;
  private final f d;
  private int e;

  public ak(AbstractHttpClient paramAbstractHttpClient, HttpContext paramHttpContext, HttpUriRequest paramHttpUriRequest, f paramf)
  {
    this.a = paramAbstractHttpClient;
    this.b = paramHttpContext;
    this.c = paramHttpUriRequest;
    this.d = paramf;
  }

  public final void run()
  {
    try
    {
      if (this.d != null)
        this.d.a();
      HttpRequestRetryHandler localHttpRequestRetryHandler = this.a.getHttpRequestRetryHandler();
      boolean bool = true;
      Object localObject1 = null;
      Object localObject2;
      while (bool)
        try
        {
          if (!Thread.currentThread().isInterrupted())
          {
            HttpResponse localHttpResponse = this.a.execute(this.c, this.b);
            if ((!Thread.currentThread().isInterrupted()) && (this.d != null))
              this.d.a(localHttpResponse);
          }
          if (this.d == null)
            return;
          this.d.b();
          return;
        }
        catch (IOException localIOException2)
        {
          Log.w("AsyncHttpRequest", "problem making request... retrying: " + localIOException2.getMessage());
          int j = 1 + this.e;
          this.e = j;
          bool = localHttpRequestRetryHandler.retryRequest(localIOException2, j, this.b);
        }
        catch (NullPointerException localNullPointerException)
        {
          IOException localIOException3 = new IOException("NPE in HttpClient " + localNullPointerException.getMessage());
          int i = 1 + this.e;
          this.e = i;
          bool = localHttpRequestRetryHandler.retryRequest(localIOException3, i, this.b);
          localObject2 = localIOException3;
        }
      ConnectException localConnectException = new ConnectException();
      localConnectException.initCause(localObject2);
      throw localConnectException;
    }
    catch (IOException localIOException1)
    {
      if (this.d != null)
      {
        this.d.b();
        this.d.a(localIOException1, null);
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     io.card.payment.ak
 * JD-Core Version:    0.6.2
 */