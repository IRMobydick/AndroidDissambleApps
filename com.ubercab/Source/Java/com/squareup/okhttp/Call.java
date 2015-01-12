package com.squareup.okhttp;

import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.HttpMethod;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.RetryableSink;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.URL;
import okio.BufferedSink;
import okio.BufferedSource;

public final class Call
{
  volatile boolean canceled;
  private final OkHttpClient client;
  private final Dispatcher dispatcher;
  HttpEngine engine;
  private boolean executed;
  private int redirectionCount;
  private Request request;

  Call(OkHttpClient paramOkHttpClient, Dispatcher paramDispatcher, Request paramRequest)
  {
    this.client = paramOkHttpClient;
    this.dispatcher = paramDispatcher;
    this.request = paramRequest;
  }

  private Response getResponse()
    throws IOException
  {
    RequestBody localRequestBody = this.request.body();
    RetryableSink localRetryableSink = null;
    Request.Builder localBuilder;
    if (localRequestBody != null)
    {
      localBuilder = this.request.newBuilder();
      MediaType localMediaType = localRequestBody.contentType();
      if (localMediaType != null)
        localBuilder.header("Content-Type", localMediaType.toString());
      long l = localRequestBody.contentLength();
      if (l != -1L)
      {
        localBuilder.header("Content-Length", Long.toString(l));
        localBuilder.removeHeader("Transfer-Encoding");
        this.request = localBuilder.build();
      }
    }
    label92: Response localResponse;
    Connection localConnection;
    for (this.engine = new HttpEngine(this.client, this.request, false, null, null, localRetryableSink, null); ; this.engine = new HttpEngine(this.client, this.request, false, localConnection, null, null, localResponse))
    {
      Request localRequest;
      while (true)
      {
        if (this.canceled)
        {
          return null;
          localBuilder.header("Transfer-Encoding", "chunked");
          localBuilder.removeHeader("Content-Length");
          break;
          boolean bool = HttpMethod.hasRequestBody(this.request.method());
          localRetryableSink = null;
          if (!bool)
            break label92;
          localRetryableSink = Util.emptySink();
          break label92;
        }
        try
        {
          this.engine.sendRequest();
          if (this.request.body() != null)
          {
            BufferedSink localBufferedSink = this.engine.getBufferedRequestBody();
            this.request.body().writeTo(localBufferedSink);
          }
          this.engine.readResponse();
          localResponse = this.engine.getResponse();
          localRequest = this.engine.followUpRequest();
          if (localRequest == null)
          {
            this.engine.releaseConnection();
            return localResponse.newBuilder().body(new RealResponseBody(localResponse, this.engine.getResponseBody())).build();
          }
        }
        catch (IOException localIOException)
        {
          HttpEngine localHttpEngine = this.engine.recover(localIOException, null);
          if (localHttpEngine != null)
            this.engine = localHttpEngine;
          else
            throw localIOException;
        }
      }
      if (this.engine.getResponse().isRedirect())
      {
        int i = 1 + this.redirectionCount;
        this.redirectionCount = i;
        if (i > 20)
          throw new ProtocolException("Too many redirects: " + this.redirectionCount);
      }
      if (!this.engine.sameConnection(localRequest.url()))
        this.engine.releaseConnection();
      localConnection = this.engine.close();
      this.request = localRequest;
    }
  }

  public void cancel()
  {
    this.canceled = true;
    if (this.engine != null)
      this.engine.disconnect();
  }

  public void enqueue(Callback paramCallback)
  {
    try
    {
      if (this.executed)
        throw new IllegalStateException("Already Executed");
    }
    finally
    {
    }
    this.executed = true;
    this.dispatcher.enqueue(new AsyncCall(paramCallback, null));
  }

  public Response execute()
    throws IOException
  {
    try
    {
      if (this.executed)
        throw new IllegalStateException("Already Executed");
    }
    finally
    {
    }
    this.executed = true;
    Response localResponse = getResponse();
    this.engine.releaseConnection();
    if (localResponse == null)
      throw new IOException("Canceled");
    return localResponse;
  }

  final class AsyncCall extends NamedRunnable
  {
    private final Callback responseCallback;

    private AsyncCall(Callback arg2)
    {
      super(arrayOfObject);
      Object localObject;
      this.responseCallback = localObject;
    }

    protected void execute()
    {
      int i = 0;
      try
      {
        Response localResponse = Call.this.getResponse();
        if (Call.this.canceled)
        {
          i = 1;
          this.responseCallback.onFailure(Call.this.request, new IOException("Canceled"));
        }
        while (true)
        {
          return;
          i = 1;
          Call.this.engine.releaseConnection();
          this.responseCallback.onResponse(localResponse);
        }
      }
      catch (IOException localIOException)
      {
        if (i != 0)
          throw new RuntimeException(localIOException);
      }
      finally
      {
        Call.this.dispatcher.finished(this);
      }
      this.responseCallback.onFailure(Call.this.request, localIOException);
      Call.this.dispatcher.finished(this);
    }

    Call get()
    {
      return Call.this;
    }

    String host()
    {
      return Call.this.request.url().getHost();
    }

    Request request()
    {
      return Call.this.request;
    }

    Object tag()
    {
      return Call.this.request.tag();
    }
  }

  private static class RealResponseBody extends ResponseBody
  {
    private final Response response;
    private final BufferedSource source;

    RealResponseBody(Response paramResponse, BufferedSource paramBufferedSource)
    {
      this.response = paramResponse;
      this.source = paramBufferedSource;
    }

    public long contentLength()
    {
      return OkHeaders.contentLength(this.response);
    }

    public MediaType contentType()
    {
      String str = this.response.header("Content-Type");
      if (str != null)
        return MediaType.parse(str);
      return null;
    }

    public BufferedSource source()
    {
      return this.source;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.okhttp.Call
 * JD-Core Version:    0.6.2
 */