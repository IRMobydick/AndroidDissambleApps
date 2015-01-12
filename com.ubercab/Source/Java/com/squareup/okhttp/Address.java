package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.net.Proxy;
import java.net.UnknownHostException;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class Address
{
  final Authenticator authenticator;
  final HostnameVerifier hostnameVerifier;
  final List<Protocol> protocols;
  final Proxy proxy;
  final SocketFactory socketFactory;
  final SSLSocketFactory sslSocketFactory;
  final String uriHost;
  final int uriPort;

  public Address(String paramString, int paramInt, SocketFactory paramSocketFactory, SSLSocketFactory paramSSLSocketFactory, HostnameVerifier paramHostnameVerifier, Authenticator paramAuthenticator, Proxy paramProxy, List<Protocol> paramList)
    throws UnknownHostException
  {
    if (paramString == null)
      throw new NullPointerException("uriHost == null");
    if (paramInt <= 0)
      throw new IllegalArgumentException("uriPort <= 0: " + paramInt);
    if (paramAuthenticator == null)
      throw new IllegalArgumentException("authenticator == null");
    if (paramList == null)
      throw new IllegalArgumentException("protocols == null");
    this.proxy = paramProxy;
    this.uriHost = paramString;
    this.uriPort = paramInt;
    this.socketFactory = paramSocketFactory;
    this.sslSocketFactory = paramSSLSocketFactory;
    this.hostnameVerifier = paramHostnameVerifier;
    this.authenticator = paramAuthenticator;
    this.protocols = Util.immutableList(paramList);
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof Address;
    boolean bool2 = false;
    if (bool1)
    {
      Address localAddress = (Address)paramObject;
      boolean bool3 = Util.equal(this.proxy, localAddress.proxy);
      bool2 = false;
      if (bool3)
      {
        boolean bool4 = this.uriHost.equals(localAddress.uriHost);
        bool2 = false;
        if (bool4)
        {
          int i = this.uriPort;
          int j = localAddress.uriPort;
          bool2 = false;
          if (i == j)
          {
            boolean bool5 = Util.equal(this.sslSocketFactory, localAddress.sslSocketFactory);
            bool2 = false;
            if (bool5)
            {
              boolean bool6 = Util.equal(this.hostnameVerifier, localAddress.hostnameVerifier);
              bool2 = false;
              if (bool6)
              {
                boolean bool7 = Util.equal(this.authenticator, localAddress.authenticator);
                bool2 = false;
                if (bool7)
                {
                  boolean bool8 = Util.equal(this.protocols, localAddress.protocols);
                  bool2 = false;
                  if (bool8)
                    bool2 = true;
                }
              }
            }
          }
        }
      }
    }
    return bool2;
  }

  public Authenticator getAuthenticator()
  {
    return this.authenticator;
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

  public SocketFactory getSocketFactory()
  {
    return this.socketFactory;
  }

  public SSLSocketFactory getSslSocketFactory()
  {
    return this.sslSocketFactory;
  }

  public String getUriHost()
  {
    return this.uriHost;
  }

  public int getUriPort()
  {
    return this.uriPort;
  }

  public int hashCode()
  {
    int i = 31 * (31 * (527 + this.uriHost.hashCode()) + this.uriPort);
    int j;
    int k;
    if (this.sslSocketFactory != null)
    {
      j = this.sslSocketFactory.hashCode();
      k = 31 * (i + j);
      if (this.hostnameVerifier == null)
        break label128;
    }
    label128: for (int m = this.hostnameVerifier.hashCode(); ; m = 0)
    {
      int n = 31 * (31 * (k + m) + this.authenticator.hashCode());
      Proxy localProxy = this.proxy;
      int i1 = 0;
      if (localProxy != null)
        i1 = this.proxy.hashCode();
      return 31 * (n + i1) + this.protocols.hashCode();
      j = 0;
      break;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.okhttp.Address
 * JD-Core Version:    0.6.2
 */