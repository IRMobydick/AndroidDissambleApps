package com.crashlytics.android.internal;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public abstract class aA<V> extends aE<V>
{
  private final Closeable a;
  private final boolean b;

  protected aA(Closeable paramCloseable, boolean paramBoolean)
  {
    this.a = paramCloseable;
    this.b = paramBoolean;
  }

  protected final void b()
    throws IOException
  {
    if ((this.a instanceof Flushable))
      ((Flushable)this.a).flush();
    if (this.b);
    try
    {
      this.a.close();
      return;
      this.a.close();
      return;
    }
    catch (IOException localIOException)
    {
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.internal.aA
 * JD-Core Version:    0.6.2
 */