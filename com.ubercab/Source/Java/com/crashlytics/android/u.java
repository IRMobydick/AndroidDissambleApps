package com.crashlytics.android;

import java.util.concurrent.CountDownLatch;

final class u
{
  private boolean a = false;
  private final CountDownLatch b = new CountDownLatch(1);

  private u(Crashlytics paramCrashlytics)
  {
  }

  final void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
    this.b.countDown();
  }

  final boolean a()
  {
    return this.a;
  }

  final void b()
  {
    try
    {
      this.b.await();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.u
 * JD-Core Version:    0.6.2
 */