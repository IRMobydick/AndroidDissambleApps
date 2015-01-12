package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import okio.BufferedSource;

public abstract class ResponseBody
  implements Closeable
{
  private Reader reader;

  private Charset charset()
  {
    MediaType localMediaType = contentType();
    if (localMediaType != null)
      return localMediaType.charset(Util.UTF_8);
    return Util.UTF_8;
  }

  public final InputStream byteStream()
  {
    return source().inputStream();
  }

  public final byte[] bytes()
    throws IOException
  {
    long l = contentLength();
    if (l > 2147483647L)
      throw new IOException("Cannot buffer entire body for content length: " + l);
    BufferedSource localBufferedSource = source();
    byte[] arrayOfByte;
    try
    {
      arrayOfByte = localBufferedSource.readByteArray();
      Util.closeQuietly(localBufferedSource);
      if ((l != -1L) && (l != arrayOfByte.length))
        throw new IOException("Content-Length and stream length disagree");
    }
    finally
    {
      Util.closeQuietly(localBufferedSource);
    }
    return arrayOfByte;
  }

  public final Reader charStream()
  {
    Reader localReader = this.reader;
    if (localReader != null)
      return localReader;
    InputStreamReader localInputStreamReader = new InputStreamReader(byteStream(), charset());
    this.reader = localInputStreamReader;
    return localInputStreamReader;
  }

  public void close()
    throws IOException
  {
    source().close();
  }

  public abstract long contentLength();

  public abstract MediaType contentType();

  public abstract BufferedSource source();

  public final String string()
    throws IOException
  {
    return new String(bytes(), charset().name());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.okhttp.ResponseBody
 * JD-Core Version:    0.6.2
 */