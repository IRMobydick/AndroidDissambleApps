package com.google.android.gms.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@ez
public class gk<T>
  implements Future<T>
{
  private final Object mw = new Object();
  private boolean pS = false;
  private T wq = null;
  private boolean wr = false;

  public void a(T paramT)
  {
    synchronized (this.mw)
    {
      if (this.wr)
        throw new IllegalStateException("Provided CallbackFuture with multiple values.");
    }
    this.wr = true;
    this.wq = paramT;
    this.mw.notifyAll();
  }

  public boolean cancel(boolean paramBoolean)
  {
    if (!paramBoolean)
      return false;
    synchronized (this.mw)
    {
      if (this.wr)
        return false;
    }
    this.pS = true;
    this.wr = true;
    this.mw.notifyAll();
    return true;
  }

  public T get()
  {
    synchronized (this.mw)
    {
      boolean bool = this.wr;
      if (bool);
    }
    try
    {
      this.mw.wait();
      label23: if (this.pS)
      {
        throw new CancellationException("CallbackFuture was cancelled.");
        localObject2 = finally;
        throw localObject2;
      }
      Object localObject3 = this.wq;
      return localObject3;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label23;
    }
  }

  public T get(long paramLong, TimeUnit paramTimeUnit)
    throws TimeoutException
  {
    synchronized (this.mw)
    {
      boolean bool = this.wr;
      if (bool);
    }
    try
    {
      long l = paramTimeUnit.toMillis(paramLong);
      if (l != 0L)
        this.mw.wait(l);
      label43: if (!this.wr)
      {
        throw new TimeoutException("CallbackFuture timed out.");
        localObject2 = finally;
        throw localObject2;
      }
      if (this.pS)
        throw new CancellationException("CallbackFuture was cancelled.");
      Object localObject3 = this.wq;
      return localObject3;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label43;
    }
  }

  public boolean isCancelled()
  {
    synchronized (this.mw)
    {
      boolean bool = this.pS;
      return bool;
    }
  }

  public boolean isDone()
  {
    synchronized (this.mw)
    {
      boolean bool = this.wr;
      return bool;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gk
 * JD-Core Version:    0.6.2
 */