package com.ubercab.library.network.cn.model;

public final class Cn
{
  public static final String DEFAULT_HOST = "cn.uber.com";
  public static final int DEFAULT_PORT = 443;
  public static final boolean DEFAULT_SSL = true;
  private String host;
  private int port;
  private boolean ssl;

  public Cn()
  {
  }

  public Cn(boolean paramBoolean, String paramString, int paramInt)
  {
    this.ssl = paramBoolean;
    this.host = paramString;
    this.port = paramInt;
  }

  public static Cn createDefault()
  {
    return new Cn(true, "cn.uber.com", 443);
  }

  public static String createDefaultEndpoint()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = "https://";
    arrayOfObject[1] = "cn.uber.com";
    arrayOfObject[2] = Integer.valueOf(443);
    return String.format("%s%s:%s", arrayOfObject);
  }

  public String createEndpoint()
  {
    Object[] arrayOfObject = new Object[3];
    if (this.ssl);
    for (String str = "https://"; ; str = "http://")
    {
      arrayOfObject[0] = str;
      arrayOfObject[1] = this.host;
      arrayOfObject[2] = Integer.valueOf(this.port);
      return String.format("%s%s:%s", arrayOfObject);
    }
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    Cn localCn;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localCn = (Cn)paramObject;
      if (this.port != localCn.port)
        return false;
      if (this.ssl != localCn.ssl)
        return false;
      if (this.host == null)
        break;
    }
    while (this.host.equals(localCn.host));
    while (true)
    {
      return false;
      if (localCn.host == null)
        break;
    }
  }

  public String getHost()
  {
    return this.host;
  }

  public int getPort()
  {
    return this.port;
  }

  public int hashCode()
  {
    int i = 31 * this.port;
    if (this.ssl);
    for (int j = 1; ; j = 0)
    {
      int k = 31 * (i + j);
      String str = this.host;
      int m = 0;
      if (str != null)
        m = this.host.hashCode();
      return k + m;
    }
  }

  public boolean isSsl()
  {
    return this.ssl;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.network.cn.model.Cn
 * JD-Core Version:    0.6.2
 */