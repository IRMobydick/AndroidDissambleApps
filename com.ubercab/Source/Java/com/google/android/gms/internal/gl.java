package com.google.android.gms.internal;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@ez
public class gl<T>
  implements Future<T>
{
  private final T wq;

  public gl(T paramT)
  {
    this.wq = paramT;
  }

  public boolean cancel(boolean paramBoolean)
  {
    return false;
  }

  public T get()
  {
    return this.wq;
  }

  public T get(long paramLong, TimeUnit paramTimeUnit)
  {
    return this.wq;
  }

  public boolean isCancelled()
  {
    return false;
  }

  public boolean isDone()
  {
    return true;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gl
 * JD-Core Version:    0.6.2
 */