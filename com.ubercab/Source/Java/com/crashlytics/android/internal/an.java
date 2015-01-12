package com.crashlytics.android.internal;

import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

final class an extends aa
{
  an(String paramString, ExecutorService paramExecutorService, long paramLong, TimeUnit paramTimeUnit)
  {
  }

  public final void a()
  {
    try
    {
      v.a().b().a("Crashlytics", "Executing shutdown hook for " + this.a);
      this.b.shutdown();
      if (!this.b.awaitTermination(this.c, this.d))
      {
        v.a().b().a("Crashlytics", this.a + " did not shut down in the allocated time. Requesting immediate shutdown.");
        this.b.shutdownNow();
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      q localq = v.a().b();
      Locale localLocale = Locale.US;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.a;
      localq.a("Crashlytics", String.format(localLocale, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", arrayOfObject));
      this.b.shutdownNow();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.internal.an
 * JD-Core Version:    0.6.2
 */