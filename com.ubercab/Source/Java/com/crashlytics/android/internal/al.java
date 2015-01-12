package com.crashlytics.android.internal;

import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

final class al
  implements ThreadFactory
{
  al(String paramString, AtomicLong paramAtomicLong)
  {
  }

  public final Thread newThread(Runnable paramRunnable)
  {
    Thread localThread = Executors.defaultThreadFactory().newThread(new am(this, paramRunnable));
    Locale localLocale = Locale.US;
    String str = this.a;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Long.valueOf(this.b.getAndIncrement());
    localThread.setName(String.format(localLocale, str, arrayOfObject));
    return localThread;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.internal.al
 * JD-Core Version:    0.6.2
 */