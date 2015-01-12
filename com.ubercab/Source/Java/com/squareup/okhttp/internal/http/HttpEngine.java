package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Headers.Builder;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Response.Builder;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.Dns;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.RouteDatabase;
import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.io.InputStream;
import java.net.CacheRequest;
import java.net.CookieHandler;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSocketFactory;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class HttpEngine
{
  private static final ResponseBody EMPTY_BODY = new ResponseBody()
  {
    public long contentLength()
    {
      return 0L;
    }

    public MediaType contentType()
    {
      return null;
    }

    public BufferedSource source()
    {
      return new Buffer();
    }
  };
  public static final int MAX_REDIRECTS = 20;
  public final boolean bufferRequestBody;
  private BufferedSink bufferedRequestBody;
  private Response cacheResponse;
  private CacheStrategy cacheStrategy;
  final OkHttpClient client;
  private Connection connection;
  private Request networkRequest;
  private Response networkResponse;
  private final Response priorResponse;
  private Sink requestBodyOut;
  private BufferedSource responseBody;
  private InputStream responseBodyBytes;
  private Source responseTransferSource;
  private Route route;
  private RouteSelector routeSelector;
  long sentRequestMillis = -1L;
  private CacheRequest storeRequest;
  private boolean transparentGzip;
  private Transport transport;
  private final Request userRequest;
  private Response userResponse;

  public HttpEngine(OkHttpClient paramOkHttpClient, Request paramRequest, boolean paramBoolean, Connection paramConnection, RouteSelector paramRouteSelector, RetryableSink paramRetryableSink, Response paramResponse)
  {
    this.client = paramOkHttpClient;
    this.userRequest = paramRequest;
    this.bufferRequestBody = paramBoolean;
    this.connection = paramConnection;
    this.routeSelector = paramRouteSelector;
    this.requestBodyOut = paramRetryableSink;
    this.priorResponse = paramResponse;
    if (paramConnection != null)
    {
      Internal.instance.setOwner(paramConnection, this);
      this.route = paramConnection.getRoute();
      return;
    }
    this.route = null;
  }

  private static Headers combine(Headers paramHeaders1, Headers paramHeaders2)
    throws IOException
  {
    Headers.Builder localBuilder = new Headers.Builder();
    int i = 0;
    if (i < paramHeaders1.size())
    {
      String str2 = paramHeaders1.name(i);
      String str3 = paramHeaders1.value(i);
      if (("Warning".equals(str2)) && (str3.startsWith("1")));
      while (true)
      {
        i++;
        break;
        if ((!OkHeaders.isEndToEnd(str2)) || (paramHeaders2.get(str2) == null))
          localBuilder.add(str2, str3);
      }
    }
    for (int j = 0; j < paramHeaders2.size(); j++)
    {
      String str1 = paramHeaders2.name(j);
      if (OkHeaders.isEndToEnd(str1))
        localBuilder.add(str1, paramHeaders2.value(j));
    }
    return localBuilder.build();
  }

  private void connect(Request paramRequest)
    throws IOException
  {
    if (this.connection != null)
      throw new IllegalStateException();
    if (this.routeSelector == null)
    {
      String str = paramRequest.url().getHost();
      if ((str == null) || (str.length() == 0))
        throw new UnknownHostException(paramRequest.url().toString());
      boolean bool = paramRequest.isHttps();
      SSLSocketFactory localSSLSocketFactory = null;
      HostnameVerifier localHostnameVerifier = null;
      if (bool)
      {
        localSSLSocketFactory = this.client.getSslSocketFactory();
        localHostnameVerifier = this.client.getHostnameVerifier();
      }
      this.routeSelector = new RouteSelector(new Address(str, Util.getEffectivePort(paramRequest.url()), this.client.getSocketFactory(), localSSLSocketFactory, localHostnameVerifier, this.client.getAuthenticator(), this.client.getProxy(), this.client.getProtocols()), paramRequest.uri(), this.client.getProxySelector(), this.client.getConnectionPool(), Dns.DEFAULT, Internal.instance.routeDatabase(this.client));
    }
    this.connection = this.routeSelector.next(paramRequest.method());
    Internal.instance.setOwner(this.connection, this);
    if (!Internal.instance.isConnected(this.connection))
    {
      Internal.instance.connect(this.connection, this.client.getConnectTimeout(), this.client.getReadTimeout(), this.client.getWriteTimeout(), tunnelRequest(this.connection, paramRequest));
      if (Internal.instance.isSpdy(this.connection))
        Internal.instance.share(this.client.getConnectionPool(), this.connection);
      Internal.instance.routeDatabase(this.client).connected(this.connection.getRoute());
    }
    Internal.instance.setTimeouts(this.connection, this.client.getReadTimeout(), this.client.getWriteTimeout());
    this.route = this.connection.getRoute();
  }

  public static String hostHeader(URL paramURL)
  {
    if (Util.getEffectivePort(paramURL) != Util.getDefaultPort(paramURL.getProtocol()))
      return paramURL.getHost() + ":" + paramURL.getPort();
    return paramURL.getHost();
  }

  private void initContentStream(Source paramSource)
    throws IOException
  {
    this.responseTransferSource = paramSource;
    if ((this.transparentGzip) && ("gzip".equalsIgnoreCase(this.userResponse.header("Content-Encoding"))))
    {
      this.userResponse = this.userResponse.newBuilder().removeHeader("Content-Encoding").removeHeader("Content-Length").build();
      this.responseBody = Okio.buffer(new GzipSource(paramSource));
      return;
    }
    this.responseBody = Okio.buffer(paramSource);
  }

  private boolean isRecoverable(IOException paramIOException)
  {
    if (((paramIOException instanceof SSLHandshakeException)) && ((paramIOException.getCause() instanceof CertificateException)));
    for (int i = 1; ; i = 0)
    {
      boolean bool = paramIOException instanceof ProtocolException;
      if ((i != 0) || (bool))
        break;
      return true;
    }
    return false;
  }

  private void maybeCache()
    throws IOException
  {
    InternalCache localInternalCache = Internal.instance.internalCache(this.client);
    if (localInternalCache == null);
    do
    {
      return;
      if (CacheStrategy.isCacheable(this.userResponse, this.networkRequest))
        break;
    }
    while (!HttpMethod.invalidatesCache(this.networkRequest.method()));
    try
    {
      localInternalCache.remove(this.networkRequest);
      return;
    }
    catch (IOException localIOException)
    {
      return;
    }
    this.storeRequest = localInternalCache.put(stripBody(this.userResponse));
  }

  private Request networkRequest(Request paramRequest)
    throws IOException
  {
    Request.Builder localBuilder = paramRequest.newBuilder();
    if (paramRequest.header("Host") == null)
      localBuilder.header("Host", hostHeader(paramRequest.url()));
    if (((this.connection == null) || (this.connection.getProtocol() != Protocol.HTTP_1_0)) && (paramRequest.header("Connection") == null))
      localBuilder.header("Connection", "Keep-Alive");
    if (paramRequest.header("Accept-Encoding") == null)
    {
      this.transparentGzip = true;
      localBuilder.header("Accept-Encoding", "gzip");
    }
    CookieHandler localCookieHandler = this.client.getCookieHandler();
    if (localCookieHandler != null)
    {
      Map localMap = OkHeaders.toMultimap(localBuilder.build().headers(), null);
      OkHeaders.addCookies(localBuilder, localCookieHandler.get(paramRequest.uri(), localMap));
    }
    return localBuilder.build();
  }

  private static Response stripBody(Response paramResponse)
  {
    if ((paramResponse != null) && (paramResponse.body() != null))
      paramResponse = paramResponse.newBuilder().body(null).build();
    return paramResponse;
  }

  private Request tunnelRequest(Connection paramConnection, Request paramRequest)
    throws IOException
  {
    if (!paramConnection.getRoute().requiresTunnel())
      return null;
    String str1 = paramRequest.url().getHost();
    int i = Util.getEffectivePort(paramRequest.url());
    if (i == Util.getDefaultPort("https"));
    for (String str2 = str1; ; str2 = str1 + ":" + i)
    {
      Request.Builder localBuilder = new Request.Builder().url(new URL("https", str1, i, "/")).header("Host", str2).header("Proxy-Connection", "Keep-Alive");
      String str3 = paramRequest.header("User-Agent");
      if (str3 != null)
        localBuilder.header("User-Agent", str3);
      String str4 = paramRequest.header("Proxy-Authorization");
      if (str4 != null)
        localBuilder.header("Proxy-Authorization", str4);
      return localBuilder.build();
    }
  }

  private static boolean validate(Response paramResponse1, Response paramResponse2)
  {
    if (paramResponse2.code() == 304);
    Date localDate1;
    Date localDate2;
    do
    {
      return true;
      localDate1 = paramResponse1.headers().getDate("Last-Modified");
      if (localDate1 == null)
        break;
      localDate2 = paramResponse2.headers().getDate("Last-Modified");
    }
    while ((localDate2 != null) && (localDate2.getTime() < localDate1.getTime()));
    return false;
  }

  public Connection close()
  {
    if (this.bufferedRequestBody != null)
      Util.closeQuietly(this.bufferedRequestBody);
    while (this.responseBody == null)
    {
      if (this.connection != null)
        Util.closeQuietly(this.connection.getSocket());
      this.connection = null;
      return null;
      if (this.requestBodyOut != null)
        Util.closeQuietly(this.requestBodyOut);
    }
    Util.closeQuietly(this.responseBody);
    Util.closeQuietly(this.responseBodyBytes);
    if ((this.transport != null) && (this.connection != null) && (!this.transport.canReuseConnection()))
    {
      Util.closeQuietly(this.connection.getSocket());
      this.connection = null;
      return null;
    }
    if ((this.connection != null) && (!Internal.instance.clearOwner(this.connection)))
      this.connection = null;
    Connection localConnection = this.connection;
    this.connection = null;
    return localConnection;
  }

  public void disconnect()
  {
    if (this.transport != null);
    try
    {
      this.transport.disconnect(this);
      return;
    }
    catch (IOException localIOException)
    {
    }
  }

  public Request followUpRequest()
    throws IOException
  {
    if (this.userResponse == null)
      throw new IllegalStateException();
    Proxy localProxy;
    if (getRoute() != null)
    {
      localProxy = getRoute().getProxy();
      switch (this.userResponse.code())
      {
      default:
      case 407:
      case 401:
      case 307:
      case 300:
      case 301:
      case 302:
      case 303:
      }
    }
    URL localURL;
    do
    {
      String str;
      do
      {
        do
        {
          return null;
          localProxy = this.client.getProxy();
          break;
          if (localProxy.type() != Proxy.Type.HTTP)
            throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
          return OkHeaders.processAuthHeader(this.client.getAuthenticator(), this.userResponse, localProxy);
        }
        while ((!this.userRequest.method().equals("GET")) && (!this.userRequest.method().equals("HEAD")));
        str = this.userResponse.header("Location");
      }
      while (str == null);
      localURL = new URL(this.userRequest.url(), str);
    }
    while (((!localURL.getProtocol().equals("https")) && (!localURL.getProtocol().equals("http"))) || ((!localURL.getProtocol().equals(this.userRequest.url().getProtocol())) && (!this.client.getFollowSslRedirects())));
    Request.Builder localBuilder = this.userRequest.newBuilder();
    if (HttpMethod.hasRequestBody(this.userRequest.method()))
    {
      localBuilder.method("GET", null);
      localBuilder.removeHeader("Transfer-Encoding");
      localBuilder.removeHeader("Content-Length");
      localBuilder.removeHeader("Content-Type");
    }
    if (!sameConnection(localURL))
      localBuilder.removeHeader("Authorization");
    return localBuilder.url(localURL).build();
  }

  public BufferedSink getBufferedRequestBody()
  {
    BufferedSink localBufferedSink1 = this.bufferedRequestBody;
    if (localBufferedSink1 != null)
      return localBufferedSink1;
    Sink localSink = getRequestBody();
    BufferedSink localBufferedSink2;
    if (localSink != null)
    {
      localBufferedSink2 = Okio.buffer(localSink);
      this.bufferedRequestBody = localBufferedSink2;
    }
    while (true)
    {
      return localBufferedSink2;
      localBufferedSink2 = null;
    }
  }

  public Connection getConnection()
  {
    return this.connection;
  }

  public Request getRequest()
  {
    return this.userRequest;
  }

  public Sink getRequestBody()
  {
    if (this.cacheStrategy == null)
      throw new IllegalStateException();
    return this.requestBodyOut;
  }

  public Response getResponse()
  {
    if (this.userResponse == null)
      throw new IllegalStateException();
    return this.userResponse;
  }

  public BufferedSource getResponseBody()
  {
    if (this.userResponse == null)
      throw new IllegalStateException();
    return this.responseBody;
  }

  public InputStream getResponseBodyBytes()
  {
    InputStream localInputStream1 = this.responseBodyBytes;
    if (localInputStream1 != null)
      return localInputStream1;
    InputStream localInputStream2 = Okio.buffer(getResponseBody()).inputStream();
    this.responseBodyBytes = localInputStream2;
    return localInputStream2;
  }

  public Route getRoute()
  {
    return this.route;
  }

  boolean hasRequestBody()
  {
    return (HttpMethod.hasRequestBody(this.userRequest.method())) && (!Util.emptySink().equals(this.requestBodyOut));
  }

  public boolean hasResponse()
  {
    return this.userResponse != null;
  }

  public boolean hasResponseBody()
  {
    if (this.userRequest.method().equals("HEAD"));
    do
    {
      return false;
      int i = this.userResponse.code();
      if (((i < 100) || (i >= 200)) && (i != 204) && (i != 304))
        return true;
    }
    while ((OkHeaders.contentLength(this.networkResponse) == -1L) && (!"chunked".equalsIgnoreCase(this.networkResponse.header("Transfer-Encoding"))));
    return true;
  }

  public void readResponse()
    throws IOException
  {
    if (this.userResponse != null);
    do
    {
      return;
      if ((this.networkRequest == null) && (this.cacheResponse == null))
        throw new IllegalStateException("call sendRequest() first!");
    }
    while (this.networkRequest == null);
    if ((this.bufferedRequestBody != null) && (this.bufferedRequestBody.buffer().size() > 0L))
      this.bufferedRequestBody.flush();
    if (this.sentRequestMillis == -1L)
    {
      if ((OkHeaders.contentLength(this.networkRequest) == -1L) && ((this.requestBodyOut instanceof RetryableSink)))
      {
        long l = ((RetryableSink)this.requestBodyOut).contentLength();
        this.networkRequest = this.networkRequest.newBuilder().header("Content-Length", Long.toString(l)).build();
      }
      this.transport.writeRequestHeaders(this.networkRequest);
    }
    if (this.requestBodyOut != null)
    {
      if (this.bufferedRequestBody == null)
        break label477;
      this.bufferedRequestBody.close();
    }
    while (true)
    {
      if (((this.requestBodyOut instanceof RetryableSink)) && (!Util.emptySink().equals(this.requestBodyOut)))
        this.transport.writeRequestBody((RetryableSink)this.requestBodyOut);
      this.transport.flushRequest();
      this.networkResponse = this.transport.readResponseHeaders().request(this.networkRequest).handshake(this.connection.getHandshake()).header(OkHeaders.SENT_MILLIS, Long.toString(this.sentRequestMillis)).header(OkHeaders.RECEIVED_MILLIS, Long.toString(System.currentTimeMillis())).build();
      Internal.instance.setProtocol(this.connection, this.networkResponse.protocol());
      receiveHeaders(this.networkResponse.headers());
      if (this.cacheResponse == null)
        break label499;
      if (!validate(this.cacheResponse, this.networkResponse))
        break label489;
      this.userResponse = this.cacheResponse.newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).headers(combine(this.cacheResponse.headers(), this.networkResponse.headers())).cacheResponse(stripBody(this.cacheResponse)).networkResponse(stripBody(this.networkResponse)).build();
      this.transport.emptyTransferStream();
      releaseConnection();
      InternalCache localInternalCache = Internal.instance.internalCache(this.client);
      localInternalCache.trackConditionalCacheHit();
      localInternalCache.update(this.cacheResponse, stripBody(this.userResponse));
      if (this.cacheResponse.body() == null)
        break;
      initContentStream(this.cacheResponse.body().source());
      return;
      label477: this.requestBodyOut.close();
    }
    label489: Util.closeQuietly(this.cacheResponse.body());
    label499: this.userResponse = this.networkResponse.newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).cacheResponse(stripBody(this.cacheResponse)).networkResponse(stripBody(this.networkResponse)).build();
    if (!hasResponseBody())
    {
      this.responseTransferSource = this.transport.getTransferStream(this.storeRequest);
      this.responseBody = Okio.buffer(this.responseTransferSource);
      return;
    }
    maybeCache();
    initContentStream(this.transport.getTransferStream(this.storeRequest));
  }

  public void receiveHeaders(Headers paramHeaders)
    throws IOException
  {
    CookieHandler localCookieHandler = this.client.getCookieHandler();
    if (localCookieHandler != null)
      localCookieHandler.put(this.userRequest.uri(), OkHeaders.toMultimap(paramHeaders, null));
  }

  public HttpEngine recover(IOException paramIOException)
  {
    return recover(paramIOException, this.requestBodyOut);
  }

  public HttpEngine recover(IOException paramIOException, Sink paramSink)
  {
    if ((this.routeSelector != null) && (this.connection != null))
      this.routeSelector.connectFailed(this.connection, paramIOException);
    if ((paramSink == null) || ((paramSink instanceof RetryableSink)));
    for (int i = 1; ((this.routeSelector == null) && (this.connection == null)) || ((this.routeSelector != null) && (!this.routeSelector.hasNext())) || (!isRecoverable(paramIOException)) || (i == 0); i = 0)
      return null;
    Connection localConnection = close();
    return new HttpEngine(this.client, this.userRequest, this.bufferRequestBody, localConnection, this.routeSelector, (RetryableSink)paramSink, this.priorResponse);
  }

  public void releaseConnection()
    throws IOException
  {
    if ((this.transport != null) && (this.connection != null))
      this.transport.releaseConnectionOnIdle();
    this.connection = null;
  }

  public boolean sameConnection(URL paramURL)
  {
    URL localURL = this.userRequest.url();
    return (localURL.getHost().equals(paramURL.getHost())) && (Util.getEffectivePort(localURL) == Util.getEffectivePort(paramURL)) && (localURL.getProtocol().equals(paramURL.getProtocol()));
  }

  public void sendRequest()
    throws IOException
  {
    if (this.cacheStrategy != null);
    while (true)
    {
      return;
      if (this.transport != null)
        throw new IllegalStateException();
      Request localRequest = networkRequest(this.userRequest);
      InternalCache localInternalCache = Internal.instance.internalCache(this.client);
      if (localInternalCache != null);
      for (Response localResponse = localInternalCache.get(localRequest); ; localResponse = null)
      {
        this.cacheStrategy = new CacheStrategy.Factory(System.currentTimeMillis(), localRequest, localResponse).get();
        this.networkRequest = this.cacheStrategy.networkRequest;
        this.cacheResponse = this.cacheStrategy.cacheResponse;
        if (localInternalCache != null)
          localInternalCache.trackResponse(this.cacheStrategy);
        if ((localResponse != null) && (this.cacheResponse == null))
          Util.closeQuietly(localResponse.body());
        if (this.networkRequest == null)
          break label234;
        if (this.connection == null)
          connect(this.networkRequest);
        if ((Internal.instance.getOwner(this.connection) == this) || (Internal.instance.isSpdy(this.connection)))
          break;
        throw new AssertionError();
      }
      this.transport = Internal.instance.newTransport(this.connection, this);
      if ((hasRequestBody()) && (this.requestBodyOut == null))
      {
        this.requestBodyOut = this.transport.createRequestBody(localRequest);
        return;
        label234: if (this.connection != null)
        {
          Internal.instance.recycle(this.client.getConnectionPool(), this.connection);
          this.connection = null;
        }
        if (this.cacheResponse != null);
        for (this.userResponse = this.cacheResponse.newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).cacheResponse(stripBody(this.cacheResponse)).build(); this.userResponse.body() != null; this.userResponse = new Response.Builder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(EMPTY_BODY).build())
        {
          initContentStream(this.userResponse.body().source());
          return;
        }
      }
    }
  }

  public void writingRequestHeaders()
  {
    if (this.sentRequestMillis != -1L)
      throw new IllegalStateException();
    this.sentRequestMillis = System.currentTimeMillis();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.okhttp.internal.http.HttpEngine
 * JD-Core Version:    0.6.2
 */