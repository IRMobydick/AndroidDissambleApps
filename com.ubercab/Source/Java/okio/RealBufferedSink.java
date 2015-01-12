package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

final class RealBufferedSink
  implements BufferedSink
{
  public final Buffer buffer;
  private boolean closed;
  public final Sink sink;

  public RealBufferedSink(Sink paramSink)
  {
    this(paramSink, new Buffer());
  }

  public RealBufferedSink(Sink paramSink, Buffer paramBuffer)
  {
    if (paramSink == null)
      throw new IllegalArgumentException("sink == null");
    this.buffer = paramBuffer;
    this.sink = paramSink;
  }

  public Buffer buffer()
  {
    return this.buffer;
  }

  public void close()
    throws IOException
  {
    if (this.closed);
    while (true)
    {
      return;
      try
      {
        boolean bool = this.buffer.size < 0L;
        localObject = null;
        if (bool)
          this.sink.write(this.buffer, this.buffer.size);
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          while (true)
          {
            this.sink.close();
            this.closed = true;
            if (localObject == null)
              break;
            Util.sneakyRethrow((Throwable)localObject);
            return;
            localThrowable1 = localThrowable1;
            localObject = localThrowable1;
          }
        }
        catch (Throwable localThrowable2)
        {
          while (true)
          {
            Object localObject;
            if (localObject == null)
              localObject = localThrowable2;
          }
        }
      }
    }
  }

  public BufferedSink emitCompleteSegments()
    throws IOException
  {
    if (this.closed)
      throw new IllegalStateException("closed");
    long l = this.buffer.completeSegmentByteCount();
    if (l > 0L)
      this.sink.write(this.buffer, l);
    return this;
  }

  public void flush()
    throws IOException
  {
    if (this.closed)
      throw new IllegalStateException("closed");
    if (this.buffer.size > 0L)
      this.sink.write(this.buffer, this.buffer.size);
    this.sink.flush();
  }

  public OutputStream outputStream()
  {
    return new OutputStream()
    {
      public void close()
        throws IOException
      {
        RealBufferedSink.this.close();
      }

      public void flush()
        throws IOException
      {
        if (!RealBufferedSink.this.closed)
          RealBufferedSink.this.flush();
      }

      public String toString()
      {
        return RealBufferedSink.this + ".outputStream()";
      }

      public void write(int paramAnonymousInt)
        throws IOException
      {
        if (RealBufferedSink.this.closed)
          throw new IOException("closed");
        RealBufferedSink.this.buffer.writeByte((byte)paramAnonymousInt);
        RealBufferedSink.this.emitCompleteSegments();
      }

      public void write(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
        throws IOException
      {
        if (RealBufferedSink.this.closed)
          throw new IOException("closed");
        RealBufferedSink.this.buffer.write(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
        RealBufferedSink.this.emitCompleteSegments();
      }
    };
  }

  public Timeout timeout()
  {
    return this.sink.timeout();
  }

  public String toString()
  {
    return "buffer(" + this.sink + ")";
  }

  public BufferedSink write(ByteString paramByteString)
    throws IOException
  {
    if (this.closed)
      throw new IllegalStateException("closed");
    this.buffer.write(paramByteString);
    return emitCompleteSegments();
  }

  public BufferedSink write(byte[] paramArrayOfByte)
    throws IOException
  {
    if (this.closed)
      throw new IllegalStateException("closed");
    this.buffer.write(paramArrayOfByte);
    return emitCompleteSegments();
  }

  public BufferedSink write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.closed)
      throw new IllegalStateException("closed");
    this.buffer.write(paramArrayOfByte, paramInt1, paramInt2);
    return emitCompleteSegments();
  }

  public void write(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    if (this.closed)
      throw new IllegalStateException("closed");
    this.buffer.write(paramBuffer, paramLong);
    emitCompleteSegments();
  }

  public long writeAll(Source paramSource)
    throws IOException
  {
    if (paramSource == null)
      throw new IllegalArgumentException("source == null");
    long l1 = 0L;
    while (true)
    {
      long l2 = paramSource.read(this.buffer, 2048L);
      if (l2 == -1L)
        break;
      l1 += l2;
      emitCompleteSegments();
    }
    return l1;
  }

  public BufferedSink writeByte(int paramInt)
    throws IOException
  {
    if (this.closed)
      throw new IllegalStateException("closed");
    this.buffer.writeByte(paramInt);
    return emitCompleteSegments();
  }

  public BufferedSink writeInt(int paramInt)
    throws IOException
  {
    if (this.closed)
      throw new IllegalStateException("closed");
    this.buffer.writeInt(paramInt);
    return emitCompleteSegments();
  }

  public BufferedSink writeIntLe(int paramInt)
    throws IOException
  {
    if (this.closed)
      throw new IllegalStateException("closed");
    this.buffer.writeIntLe(paramInt);
    return emitCompleteSegments();
  }

  public BufferedSink writeLong(long paramLong)
    throws IOException
  {
    if (this.closed)
      throw new IllegalStateException("closed");
    this.buffer.writeLong(paramLong);
    return emitCompleteSegments();
  }

  public BufferedSink writeLongLe(long paramLong)
    throws IOException
  {
    if (this.closed)
      throw new IllegalStateException("closed");
    this.buffer.writeLongLe(paramLong);
    return emitCompleteSegments();
  }

  public BufferedSink writeShort(int paramInt)
    throws IOException
  {
    if (this.closed)
      throw new IllegalStateException("closed");
    this.buffer.writeShort(paramInt);
    return emitCompleteSegments();
  }

  public BufferedSink writeShortLe(int paramInt)
    throws IOException
  {
    if (this.closed)
      throw new IllegalStateException("closed");
    this.buffer.writeShortLe(paramInt);
    return emitCompleteSegments();
  }

  public BufferedSink writeString(String paramString, Charset paramCharset)
    throws IOException
  {
    if (this.closed)
      throw new IllegalStateException("closed");
    this.buffer.writeString(paramString, paramCharset);
    return emitCompleteSegments();
  }

  public BufferedSink writeUtf8(String paramString)
    throws IOException
  {
    if (this.closed)
      throw new IllegalStateException("closed");
    this.buffer.writeUtf8(paramString);
    return emitCompleteSegments();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     okio.RealBufferedSink
 * JD-Core Version:    0.6.2
 */