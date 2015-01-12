package com.squareup.okhttp;

import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.RouteDatabase;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.AuthenticatorAdapter;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.Transport;
import com.squareup.okhttp.internal.tls.OkHostnameVerifier;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public final class OkHttpClient
  implements Cloneable
{
  private static SSLSocketFactory defaultSslSocketFactory;
  private Authenticator authenticator;
  private Cache cache;
  private int connectTimeout;
  private ConnectionPool connectionPool;
  private CookieHandler cookieHandler;
  private Dispatcher dispatcher = new Dispatcher();
  private boolean followSslRedirects = true;
  private HostnameVerifier hostnameVerifier;
  private InternalCache internalCache;
  private List<Protocol> protocols;
  private Proxy proxy;
  private ProxySelector proxySelector;
  private int readTimeout;
  private final RouteDatabase routeDatabase = new RouteDatabase();
  private SocketFactory socketFactory;
  private SSLSocketFactory sslSocketFactory;
  private int writeTimeout;

  static
  {
    Internal.instance = new Internal()
    {
      public void addLine(Headers.Builder paramAnonymousBuilder, String paramAnonymousString)
      {
        paramAnonymousBuilder.addLine(paramAnonymousString);
      }

      public boolean clearOwner(Connection paramAnonymousConnection)
      {
        return paramAnonymousConnection.clearOwner();
      }

      public void closeIfOwnedBy(Connection paramAnonymousConnection, Object paramAnonymousObject)
        throws IOException
      {
        paramAnonymousConnection.closeIfOwnedBy(paramAnonymousObject);
      }

      public void connect(Connection paramAnonymousConnection, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, Request paramAnonymousRequest)
        throws IOException
      {
        paramAnonymousConnection.connect(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousRequest);
      }

      public Object getOwner(Connection paramAnonymousConnection)
      {
        return paramAnonymousConnection.getOwner();
      }

      public InternalCache internalCache(OkHttpClient paramAnonymousOkHttpClient)
      {
        return paramAnonymousOkHttpClient.internalCache();
      }

      public boolean isConnected(Connection paramAnonymousConnection)
      {
        return paramAnonymousConnection.isConnected();
      }

      public boolean isReadable(Connection paramAnonymousConnection)
      {
        return paramAnonymousConnection.isReadable();
      }

      public boolean isSpdy(Connection paramAnonymousConnection)
      {
        return paramAnonymousConnection.isSpdy();
      }

      public Transport newTransport(Connection paramAnonymousConnection, HttpEngine paramAnonymousHttpEngine)
        throws IOException
      {
        return paramAnonymousConnection.newTransport(paramAnonymousHttpEngine);
      }

      public void recycle(ConnectionPool paramAnonymousConnectionPool, Connection paramAnonymousConnection)
      {
        paramAnonymousConnectionPool.recycle(paramAnonymousConnection);
      }

      public int recycleCount(Connection paramAnonymousConnection)
      {
        return paramAnonymousConnection.recycleCount();
      }

      public RouteDatabase routeDatabase(OkHttpClient paramAnonymousOkHttpClient)
      {
        return paramAnonymousOkHttpClient.routeDatabase;
      }

      public void setCache(OkHttpClient paramAnonymousOkHttpClient, InternalCache paramAnonymousInternalCache)
      {
        paramAnonymousOkHttpClient.setInternalCache(paramAnonymousInternalCache);
      }

      public void setOwner(Connection paramAnonymousConnection, HttpEngine paramAnonymousHttpEngine)
      {
        paramAnonymousConnection.setOwner(paramAnonymousHttpEngine);
      }

      public void setProtocol(Connection paramAnonymousConnection, Protocol paramAnonymousProtocol)
      {
        paramAnonymousConnection.setProtocol(paramAnonymousProtocol);
      }

      public void setTimeouts(Connection paramAnonymousConnection, int paramAnonymousInt1, int paramAnonymousInt2)
        throws IOException
      {
        paramAnonymousConnection.setTimeouts(paramAnonymousInt1, paramAnonymousInt2);
      }

      public void share(ConnectionPool paramAnonymousConnectionPool, Connection paramAnonymousConnection)
      {
        paramAnonymousConnectionPool.share(paramAnonymousConnection);
      }
    };
  }

  private SSLSocketFactory getDefaultSSLSocketFactory()
  {
    try
    {
      SSLSocketFactory localSSLSocketFactory1 = defaultSslSocketFactory;
      if (localSSLSocketFactory1 == null);
      try
      {
        SSLContext localSSLContext = SSLContext.getInstance("TLS");
        localSSLContext.init(null, null, null);
        defaultSslSocketFactory = localSSLContext.getSocketFactory();
        SSLSocketFactory localSSLSocketFactory2 = defaultSslSocketFactory;
        return localSSLSocketFactory2;
      }
      catch (GeneralSecurityException localGeneralSecurityException)
      {
        throw new AssertionError();
      }
    }
    finally
    {
    }
  }

  public OkHttpClient cancel(Object paramObject)
  {
    this.dispatcher.cancel(paramObject);
    return this;
  }

  public OkHttpClient clone()
  {
    try
    {
      OkHttpClient localOkHttpClient = (OkHttpClient)super.clone();
      return localOkHttpClient;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
    }
    throw new AssertionError();
  }

  OkHttpClient copyWithDefaults()
  {
    OkHttpClient localOkHttpClient = clone();
    if (localOkHttpClient.proxySelector == null)
      localOkHttpClient.proxySelector = ProxySelector.getDefault();
    if (localOkHttpClient.cookieHandler == null)
      localOkHttpClient.cookieHandler = CookieHandler.getDefault();
    if (localOkHttpClient.socketFactory == null)
      localOkHttpClient.socketFactory = SocketFactory.getDefault();
    if (localOkHttpClient.sslSocketFactory == null)
      localOkHttpClient.sslSocketFactory = getDefaultSSLSocketFactory();
    if (localOkHttpClient.hostnameVerifier == null)
      localOkHttpClient.hostnameVerifier = OkHostnameVerifier.INSTANCE;
    if (localOkHttpClient.authenticator == null)
      localOkHttpClient.authenticator = AuthenticatorAdapter.INSTANCE;
    if (localOkHttpClient.connectionPool == null)
      localOkHttpClient.connectionPool = ConnectionPool.getDefault();
    if (localOkHttpClient.protocols == null)
    {
      Protocol[] arrayOfProtocol = new Protocol[3];
      arrayOfProtocol[0] = Protocol.HTTP_2;
      arrayOfProtocol[1] = Protocol.SPDY_3;
      arrayOfProtocol[2] = Protocol.HTTP_1_1;
      localOkHttpClient.protocols = Util.immutableList(arrayOfProtocol);
    }
    return localOkHttpClient;
  }

  public Authenticator getAuthenticator()
  {
    return this.authenticator;
  }

  public Cache getCache()
  {
    return this.cache;
  }

  public int getConnectTimeout()
  {
    return this.connectTimeout;
  }

  public ConnectionPool getConnectionPool()
  {
    return this.connectionPool;
  }

  public CookieHandler getCookieHandler()
  {
    return this.cookieHandler;
  }

  public Dispatcher getDispatcher()
  {
    return this.dispatcher;
  }

  public boolean getFollowSslRedirects()
  {
    return this.followSslRedirects;
  }

  public HostnameVerifier getHostnameVerifier()
  {
    return this.hostnameVerifier;
  }

  public List<Protocol> getProtocols()
  {
    return this.protocols;
  }

  public Proxy getProxy()
  {
    return this.proxy;
  }

  public ProxySelector getProxySelector()
  {
    return this.proxySelector;
  }

  public int getReadTimeout()
  {
    return this.readTimeout;
  }

  RouteDatabase getRoutesDatabase()
  {
    return this.routeDatabase;
  }

  public SocketFactory getSocketFactory()
  {
    return this.socketFactory;
  }

  public SSLSocketFactory getSslSocketFactory()
  {
    return this.sslSocketFactory;
  }

  public int getWriteTimeout()
  {
    return this.writeTimeout;
  }

  InternalCache internalCache()
  {
    return this.internalCache;
  }

  public Call newCall(Request paramRequest)
  {
    return new Call(copyWithDefaults(), this.dispatcher, paramRequest);
  }

  public OkHttpClient setAuthenticator(Authenticator paramAuthenticator)
  {
    this.authenticator = paramAuthenticator;
    return this;
  }

  public OkHttpClient setCache(Cache paramCache)
  {
    this.cache = paramCache;
    if (paramCache != null);
    for (InternalCache localInternalCache = paramCache.internalCache; ; localInternalCache = null)
    {
      this.internalCache = localInternalCache;
      return this;
    }
  }

  public void setConnectTimeout(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong < 0L)
      throw new IllegalArgumentException("timeout < 0");
    if (paramTimeUnit == null)
      throw new IllegalArgumentException("unit == null");
    long l = paramTimeUnit.toMillis(paramLong);
    if (l > 2147483647L)
      throw new IllegalArgumentException("Timeout too large.");
    this.connectTimeout = ((int)l);
  }

  public OkHttpClient setConnectionPool(ConnectionPool paramConnectionPool)
  {
    this.connectionPool = paramConnectionPool;
    return this;
  }

  public OkHttpClient setCookieHandler(CookieHandler paramCookieHandler)
  {
    this.cookieHandler = paramCookieHandler;
    return this;
  }

  public OkHttpClient setDispatcher(Dispatcher paramDispatcher)
  {
    if (paramDispatcher == null)
      throw new IllegalArgumentException("dispatcher == null");
    this.dispatcher = paramDispatcher;
    return this;
  }

  public OkHttpClient setFollowSslRedirects(boolean paramBoolean)
  {
    this.followSslRedirects = paramBoolean;
    return this;
  }

  public OkHttpClient setHostnameVerifier(HostnameVerifier paramHostnameVerifier)
  {
    this.hostnameVerifier = paramHostnameVerifier;
    return this;
  }

  void setInternalCache(InternalCache paramInternalCache)
  {
    this.internalCache = paramInternalCache;
    this.cache = null;
  }

  public OkHttpClient setProtocols(List<Protocol> paramList)
  {
    List localList = Util.immutableList(paramList);
    if (!localList.contains(Protocol.HTTP_1_1))
      throw new IllegalArgumentException("protocols doesn't contain http/1.1: " + localList);
    if (localList.contains(null))
      throw new IllegalArgumentException("protocols must not contain null");
    this.protocols = Util.immutableList(localList);
    return this;
  }

  public OkHttpClient setProxy(Proxy paramProxy)
  {
    this.proxy = paramProxy;
    return this;
  }

  public OkHttpClient setProxySelector(ProxySelector paramProxySelector)
  {
    this.proxySelector = paramProxySelector;
    return this;
  }

  public void setReadTimeout(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong < 0L)
      throw new IllegalArgumentException("timeout < 0");
    if (paramTimeUnit == null)
      throw new IllegalArgumentException("unit == null");
    long l = paramTimeUnit.toMillis(paramLong);
    if (l > 2147483647L)
      throw new IllegalArgumentException("Timeout too large.");
    this.readTimeout = ((int)l);
  }

  public OkHttpClient setSocketFactory(SocketFactory paramSocketFactory)
  {
    this.socketFactory = paramSocketFactory;
    return this;
  }

  public OkHttpClient setSslSocketFactory(SSLSocketFactory paramSSLSocketFactory)
  {
    this.sslSocketFactory = paramSSLSocketFactory;
    return this;
  }

  public void setWriteTimeout(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong < 0L)
      throw new IllegalArgumentException("timeout < 0");
    if (paramTimeUnit == null)
      throw new IllegalArgumentException("unit == null");
    long l = paramTimeUnit.toMillis(paramLong);
    if (l > 2147483647L)
      throw new IllegalArgumentException("Timeout too large.");
    this.writeTimeout = ((int)l);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.okhttp.OkHttpClient
 * JD-Core Version:    0.6.2
 */