package com.squareup.picasso;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

final class MarkableInputStream extends InputStream
{
  private static final int DEFAULT_BUFFER_SIZE = 4096;
  private long defaultMark = -1L;
  private final InputStream in;
  private long limit;
  private long offset;
  private long reset;

  public MarkableInputStream(InputStream paramInputStream)
  {
    this(paramInputStream, 4096);
  }

  public MarkableInputStream(InputStream paramInputStream, int paramInt)
  {
    if (!paramInputStream.markSupported())
      paramInputStream = new BufferedInputStream(paramInputStream, paramInt);
    this.in = paramInputStream;
  }

  private void setLimit(long paramLong)
  {
    try
    {
      if ((this.reset < this.offset) && (this.offset <= this.limit))
      {
        this.in.reset();
        this.in.mark((int)(paramLong - this.reset));
        skip(this.reset, this.offset);
      }
      while (true)
      {
        this.limit = paramLong;
        return;
        this.reset = this.offset;
        this.in.mark((int)(paramLong - this.offset));
      }
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException("Unable to mark: " + localIOException);
    }
  }

  private void skip(long paramLong1, long paramLong2)
    throws IOException
  {
    while (true)
    {
      if (paramLong1 < paramLong2)
      {
        l = this.in.skip(paramLong2 - paramLong1);
        if (l != 0L)
          break label37;
        if (read() != -1);
      }
      else
      {
        return;
      }
      long l = 1L;
      label37: paramLong1 += l;
    }
  }

  public int available()
    throws IOException
  {
    return this.in.available();
  }

  public void close()
    throws IOException
  {
    this.in.close();
  }

  public void mark(int paramInt)
  {
    this.defaultMark = savePosition(paramInt);
  }

  public boolean markSupported()
  {
    return this.in.markSupported();
  }

  public int read()
    throws IOException
  {
    int i = this.in.read();
    if (i != -1)
      this.offset = (1L + this.offset);
    return i;
  }

  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    int i = this.in.read(paramArrayOfByte);
    if (i != -1)
      this.offset += i;
    return i;
  }

  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = this.in.read(paramArrayOfByte, paramInt1, paramInt2);
    if (i != -1)
      this.offset += i;
    return i;
  }

  public void reset()
    throws IOException
  {
    reset(this.defaultMark);
  }

  public void reset(long paramLong)
    throws IOException
  {
    if ((this.offset > this.limit) || (paramLong < this.reset))
      throw new IOException("Cannot reset");
    this.in.reset();
    skip(this.reset, paramLong);
    this.offset = paramLong;
  }

  public long savePosition(int paramInt)
  {
    long l = this.offset + paramInt;
    if (this.limit < l)
      setLimit(l);
    return this.offset;
  }

  public long skip(long paramLong)
    throws IOException
  {
    long l = this.in.skip(paramLong);
    this.offset = (l + this.offset);
    return l;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.MarkableInputStream
 * JD-Core Version:    0.6.2
 */