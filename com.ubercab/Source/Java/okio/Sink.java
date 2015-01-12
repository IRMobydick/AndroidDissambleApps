package okio;

import java.io.Closeable;
import java.io.IOException;

public abstract interface Sink extends Closeable
{
  public abstract void close()
    throws IOException;

  public abstract void flush()
    throws IOException;

  public abstract Timeout timeout();

  public abstract void write(Buffer paramBuffer, long paramLong)
    throws IOException;
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     okio.Sink
 * JD-Core Version:    0.6.2
 */