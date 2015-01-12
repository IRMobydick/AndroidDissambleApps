package com.squareup.okhttp;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

public final class Route
{
  final Address address;
  final InetSocketAddress inetSocketAddress;
  final Proxy proxy;
  final String tlsVersion;

  public Route(Address paramAddress, Proxy paramProxy, InetSocketAddress paramInetSocketAddress, String paramString)
  {
    if (paramAddress == null)
      throw new NullPointerException("address == null");
    if (paramProxy == null)
      throw new NullPointerException("proxy == null");
    if (paramInetSocketAddress == null)
      throw new NullPointerException("inetSocketAddress == null");
    if (paramString == null)
      throw new NullPointerException("tlsVersion == null");
    this.address = paramAddress;
    this.proxy = paramProxy;
    this.inetSocketAddress = paramInetSocketAddress;
    this.tlsVersion = paramString;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof Route;
    boolean bool2 = false;
    if (bool1)
    {
      Route localRoute = (Route)paramObject;
      boolean bool3 = this.address.equals(localRoute.address);
      bool2 = false;
      if (bool3)
      {
        boolean bool4 = this.proxy.equals(localRoute.proxy);
        bool2 = false;
        if (bool4)
        {
          boolean bool5 = this.inetSocketAddress.equals(localRoute.inetSocketAddress);
          bool2 = false;
          if (bool5)
          {
            boolean bool6 = this.tlsVersion.equals(localRoute.tlsVersion);
            bool2 = false;
            if (bool6)
              bool2 = true;
          }
        }
      }
    }
    return bool2;
  }

  public Address getAddress()
  {
    return this.address;
  }

  public Proxy getProxy()
  {
    return this.proxy;
  }

  public InetSocketAddress getSocketAddress()
  {
    return this.inetSocketAddress;
  }

  public String getTlsVersion()
  {
    return this.tlsVersion;
  }

  public int hashCode()
  {
    return 31 * (31 * (31 * (527 + this.address.hashCode()) + this.proxy.hashCode()) + this.inetSocketAddress.hashCode()) + this.tlsVersion.hashCode();
  }

  public boolean requiresTunnel()
  {
    return (this.address.sslSocketFactory != null) && (this.proxy.type() == Proxy.Type.HTTP);
  }

  boolean supportsNpn()
  {
    return !this.tlsVersion.equals("SSLv3");
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.okhttp.Route
 * JD-Core Version:    0.6.2
 */