package com.squareup.okhttp.internal;

import java.net.InetAddress;
import java.net.UnknownHostException;

public abstract interface Dns
{
  public static final Dns DEFAULT = new Dns()
  {
    public InetAddress[] getAllByName(String paramAnonymousString)
      throws UnknownHostException
    {
      if (paramAnonymousString == null)
        throw new UnknownHostException("host == null");
      return InetAddress.getAllByName(paramAnonymousString);
    }
  };

  public abstract InetAddress[] getAllByName(String paramString)
    throws UnknownHostException;
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.okhttp.internal.Dns
 * JD-Core Version:    0.6.2
 */