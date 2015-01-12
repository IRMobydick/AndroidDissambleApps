package com.google.android.gms.maps.model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public abstract class UrlTileProvider
  implements TileProvider
{
  private final int lf;
  private final int lg;

  public UrlTileProvider(int paramInt1, int paramInt2)
  {
    this.lf = paramInt1;
    this.lg = paramInt2;
  }

  private static long a(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte[4096];
    int i;
    for (long l = 0L; ; l += i)
    {
      i = paramInputStream.read(arrayOfByte);
      if (i == -1)
        return l;
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }

  private static byte[] e(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    a(paramInputStream, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }

  public final Tile getTile(int paramInt1, int paramInt2, int paramInt3)
  {
    URL localURL = getTileUrl(paramInt1, paramInt2, paramInt3);
    if (localURL == null)
      return NO_TILE;
    try
    {
      Tile localTile = new Tile(this.lf, this.lg, e(localURL.openStream()));
      return localTile;
    }
    catch (IOException localIOException)
    {
    }
    return null;
  }

  public abstract URL getTileUrl(int paramInt1, int paramInt2, int paramInt3);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.UrlTileProvider
 * JD-Core Version:    0.6.2
 */