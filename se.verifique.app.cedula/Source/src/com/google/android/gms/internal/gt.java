package com.google.android.gms.internal;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class gt
{
  private static final ThreadFactory a = new gv();
  private static final ThreadPoolExecutor b = new ThreadPoolExecutor(0, 10, 65L, TimeUnit.SECONDS, new SynchronousQueue(true), a);

  public static int a()
  {
    return b.getPoolSize();
  }

  public static void a(Runnable paramRunnable)
  {
    try
    {
      b.execute(new gu(paramRunnable));
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      while (true)
        hi.c("Too many background threads already running. Aborting task.  Current pool size: " + a(), localRejectedExecutionException);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gt
 * JD-Core Version:    0.6.0
 */