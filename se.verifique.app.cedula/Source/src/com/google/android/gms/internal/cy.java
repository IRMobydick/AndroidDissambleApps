package com.google.android.gms.internal;

import java.lang.ref.WeakReference;

class cy
  implements Runnable
{
  private final WeakReference c = new WeakReference(this.a);

  cy(cx paramcx, cw paramcw)
  {
  }

  public void run()
  {
    cw localcw = (cw)this.c.get();
    if ((!cx.a(this.b)) && (localcw != null))
    {
      localcw.e();
      this.b.b();
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.cy
 * JD-Core Version:    0.6.0
 */