package com.google.android.gms.internal;

import android.os.Handler;

final class cx
{
  private final Runnable a;
  private volatile boolean b = false;

  public cx(cw paramcw)
  {
    this.a = new cy(this, paramcw);
  }

  public void a()
  {
    this.b = true;
    hh.a.removeCallbacks(this.a);
  }

  public void b()
  {
    hh.a.postDelayed(this.a, 250L);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.cx
 * JD-Core Version:    0.6.0
 */