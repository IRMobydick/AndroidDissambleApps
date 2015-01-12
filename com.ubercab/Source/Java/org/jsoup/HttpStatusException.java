package org.jsoup;

import java.io.IOException;

public class HttpStatusException extends IOException
{
  private int statusCode;
  private String url;

  public HttpStatusException(String paramString1, int paramInt, String paramString2)
  {
    super(paramString1);
    this.statusCode = paramInt;
    this.url = paramString2;
  }

  public int getStatusCode()
  {
    return this.statusCode;
  }

  public String getUrl()
  {
    return this.url;
  }

  public String toString()
  {
    return super.toString() + ". Status=" + this.statusCode + ", URL=" + this.url;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     org.jsoup.HttpStatusException
 * JD-Core Version:    0.6.2
 */