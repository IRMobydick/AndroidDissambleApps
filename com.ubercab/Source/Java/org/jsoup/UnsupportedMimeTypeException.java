package org.jsoup;

import java.io.IOException;

public class UnsupportedMimeTypeException extends IOException
{
  private String mimeType;
  private String url;

  public UnsupportedMimeTypeException(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1);
    this.mimeType = paramString2;
    this.url = paramString3;
  }

  public String getMimeType()
  {
    return this.mimeType;
  }

  public String getUrl()
  {
    return this.url;
  }

  public String toString()
  {
    return super.toString() + ". Mimetype=" + this.mimeType + ", URL=" + this.url;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     org.jsoup.UnsupportedMimeTypeException
 * JD-Core Version:    0.6.2
 */