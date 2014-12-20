package com.google.android.gms.internal;

import android.os.Handler;

public class oo
{
  private final Handler a;

  public oo(Handler paramHandler)
  {
    this.a = paramHandler;
  }

  public void a(Runnable paramRunnable)
  {
    this.a.removeCallbacks(paramRunnable);
  }

  public boolean a(Runnable paramRunnable, long paramLong)
  {
    return this.a.postDelayed(paramRunnable, paramLong);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.oo
 * JD-Core Version:    0.6.0
 */