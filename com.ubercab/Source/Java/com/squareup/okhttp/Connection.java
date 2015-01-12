package com.squareup.okhttp;

import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.http.HttpConnection;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.HttpTransport;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.SpdyTransport;
import com.squareup.okhttp.internal.http.Transport;
import com.squareup.okhttp.internal.spdy.SpdyConnection;
import com.squareup.okhttp.internal.spdy.SpdyConnection.Builder;
import java.io.IOException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.URL;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public final class Connection
{
  private boolean connected = false;
  private Handshake handshake;
  private HttpConnection httpConnection;
  private long idleStartTimeNs;
  private Object owner;
  private final ConnectionPool pool;
  private Protocol protocol = Protocol.HTTP_1_1;
  private int recycleCount;
  private final Route route;
  private Socket socket;
  private SpdyConnection spdyConnection;

  public Connection(ConnectionPool paramConnectionPool, Route paramRoute)
  {
    this.pool = paramConnectionPool;
    this.route = paramRoute;
  }

  private void makeTunnel(Request paramRequest, int paramInt1, int paramInt2)
    throws IOException
  {
    HttpConnection localHttpConnection = new HttpConnection(this.pool, this, this.socket);
    localHttpConnection.setTimeouts(paramInt1, paramInt2);
    URL localURL = paramRequest.url();
    String str = "CONNECT " + localURL.getHost() + ":" + localURL.getPort() + " HTTP/1.1";
    do
    {
      localHttpConnection.writeRequest(paramRequest.headers(), str);
      localHttpConnection.flush();
      Response localResponse = localHttpConnection.readResponse().request(paramRequest).build();
      localHttpConnection.emptyResponseBody();
      switch (localResponse.code())
      {
      default:
        throw new IOException("Unexpected response code for CONNECT: " + localResponse.code());
      case 200:
        if (localHttpConnection.bufferSize() <= 0L)
          break;
        throw new IOException("TLS tunnel buffered too many bytes!");
      case 407:
        paramRequest = OkHeaders.processAuthHeader(this.route.address.authenticator, localResponse, this.route.proxy);
      }
    }
    while (paramRequest != null);
    throw new IOException("Failed to authenticate with proxy");
  }

  private void upgradeToTls(Request paramRequest, int paramInt1, int paramInt2)
    throws IOException
  {
    Platform localPlatform = Platform.get();
    if (paramRequest != null)
      makeTunnel(paramRequest, paramInt1, paramInt2);
    this.socket = this.route.address.sslSocketFactory.createSocket(this.socket, this.route.address.uriHost, this.route.address.uriPort, true);
    SSLSocket localSSLSocket = (SSLSocket)this.socket;
    localPlatform.configureTls(localSSLSocket, this.route.address.uriHost, this.route.tlsVersion);
    boolean bool = this.route.supportsNpn();
    if (bool)
      localPlatform.setProtocols(localSSLSocket, this.route.address.protocols);
    localSSLSocket.startHandshake();
    if (!this.route.address.hostnameVerifier.verify(this.route.address.uriHost, localSSLSocket.getSession()))
      throw new IOException("Hostname '" + this.route.address.uriHost + "' was not verified");
    this.handshake = Handshake.get(localSSLSocket.getSession());
    if (bool)
    {
      String str = localPlatform.getSelectedProtocol(localSSLSocket);
      if (str != null)
        this.protocol = Protocol.get(str);
    }
    if ((this.protocol == Protocol.SPDY_3) || (this.protocol == Protocol.HTTP_2))
    {
      localSSLSocket.setSoTimeout(0);
      this.spdyConnection = new SpdyConnection.Builder(this.route.address.getUriHost(), true, this.socket).protocol(this.protocol).build();
      this.spdyConnection.sendConnectionPreface();
      return;
    }
    this.httpConnection = new HttpConnection(this.pool, this, this.socket);
  }

  boolean clearOwner()
  {
    synchronized (this.pool)
    {
      if (this.owner == null)
        return false;
      this.owner = null;
      return true;
    }
  }

  void closeIfOwnedBy(Object paramObject)
    throws IOException
  {
    if (isSpdy())
      throw new IllegalStateException();
    synchronized (this.pool)
    {
      if (this.owner != paramObject)
        return;
      this.owner = null;
      this.socket.close();
      return;
    }
  }

  void connect(int paramInt1, int paramInt2, int paramInt3, Request paramRequest)
    throws IOException
  {
    if (this.connected)
      throw new IllegalStateException("already connected");
    if (this.route.proxy.type() != Proxy.Type.HTTP)
    {
      this.socket = new Socket(this.route.proxy);
      this.socket.setSoTimeout(paramInt2);
      Platform.get().connectSocket(this.socket, this.route.inetSocketAddress, paramInt1);
      if (this.route.address.sslSocketFactory == null)
        break label125;
      upgradeToTls(paramRequest, paramInt2, paramInt3);
    }
    while (true)
    {
      this.connected = true;
      return;
      this.socket = this.route.address.socketFactory.createSocket();
      break;
      label125: this.httpConnection = new HttpConnection(this.pool, this, this.socket);
    }
  }

  public Handshake getHandshake()
  {
    return this.handshake;
  }

  long getIdleStartTimeNs()
  {
    if (this.spdyConnection == null)
      return this.idleStartTimeNs;
    return this.spdyConnection.getIdleStartTimeNs();
  }

  Object getOwner()
  {
    synchronized (this.pool)
    {
      Object localObject2 = this.owner;
      return localObject2;
    }
  }

  public Protocol getProtocol()
  {
    return this.protocol;
  }

  public Route getRoute()
  {
    return this.route;
  }

  public Socket getSocket()
  {
    return this.socket;
  }

  void incrementRecycleCount()
  {
    this.recycleCount = (1 + this.recycleCount);
  }

  boolean isAlive()
  {
    return (!this.socket.isClosed()) && (!this.socket.isInputShutdown()) && (!this.socket.isOutputShutdown());
  }

  boolean isConnected()
  {
    return this.connected;
  }

  boolean isExpired(long paramLong)
  {
    return getIdleStartTimeNs() < System.nanoTime() - paramLong;
  }

  boolean isIdle()
  {
    return (this.spdyConnection == null) || (this.spdyConnection.isIdle());
  }

  boolean isReadable()
  {
    if (this.httpConnection != null)
      return this.httpConnection.isReadable();
    return true;
  }

  boolean isSpdy()
  {
    return this.spdyConnection != null;
  }

  Transport newTransport(HttpEngine paramHttpEngine)
    throws IOException
  {
    if (this.spdyConnection != null)
      return new SpdyTransport(paramHttpEngine, this.spdyConnection);
    return new HttpTransport(paramHttpEngine, this.httpConnection);
  }

  int recycleCount()
  {
    return this.recycleCount;
  }

  void resetIdleStartTime()
  {
    if (this.spdyConnection != null)
      throw new IllegalStateException("spdyConnection != null");
    this.idleStartTimeNs = System.nanoTime();
  }

  void setOwner(Object paramObject)
  {
    if (isSpdy())
      return;
    synchronized (this.pool)
    {
      if (this.owner != null)
        throw new IllegalStateException("Connection already has an owner!");
    }
    this.owner = paramObject;
  }

  void setProtocol(Protocol paramProtocol)
  {
    if (paramProtocol == null)
      throw new IllegalArgumentException("protocol == null");
    this.protocol = paramProtocol;
  }

  void setTimeouts(int paramInt1, int paramInt2)
    throws IOException
  {
    if (!this.connected)
      throw new IllegalStateException("setTimeouts - not connected");
    if (this.httpConnection != null)
    {
      this.socket.setSoTimeout(paramInt1);
      this.httpConnection.setTimeouts(paramInt1, paramInt2);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.okhttp.Connection
 * JD-Core Version:    0.6.2
 */