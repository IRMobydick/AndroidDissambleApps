package com.squareup.picasso;

import android.graphics.Bitmap;
import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;

public abstract interface Downloader
{
  public abstract Response load(Uri paramUri, boolean paramBoolean)
    throws IOException;

  public static class Response
  {
    final Bitmap bitmap;
    final boolean cached;
    final long contentLength;
    final InputStream stream;

    @Deprecated
    public Response(Bitmap paramBitmap, boolean paramBoolean)
    {
      this(paramBitmap, paramBoolean, -1L);
    }

    public Response(Bitmap paramBitmap, boolean paramBoolean, long paramLong)
    {
      if (paramBitmap == null)
        throw new IllegalArgumentException("Bitmap may not be null.");
      this.stream = null;
      this.bitmap = paramBitmap;
      this.cached = paramBoolean;
      this.contentLength = paramLong;
    }

    @Deprecated
    public Response(InputStream paramInputStream, boolean paramBoolean)
    {
      this(paramInputStream, paramBoolean, -1L);
    }

    public Response(InputStream paramInputStream, boolean paramBoolean, long paramLong)
    {
      if (paramInputStream == null)
        throw new IllegalArgumentException("Stream may not be null.");
      this.stream = paramInputStream;
      this.bitmap = null;
      this.cached = paramBoolean;
      this.contentLength = paramLong;
    }

    public Bitmap getBitmap()
    {
      return this.bitmap;
    }

    public long getContentLength()
    {
      return this.contentLength;
    }

    public InputStream getInputStream()
    {
      return this.stream;
    }
  }

  public static class ResponseException extends IOException
  {
    public ResponseException(String paramString)
    {
      super();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.Downloader
 * JD-Core Version:    0.6.2
 */