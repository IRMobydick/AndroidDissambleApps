package com.google.android.gms.internal;

import java.lang.ref.WeakReference;

class on
  implements Runnable
{
  private final WeakReference c = new WeakReference(this.a);

  on(om paramom, of paramof)
  {
  }

  public void run()
  {
    om.a(this.b, false);
    of localof = (of)this.c.get();
    if (localof != null)
      localof.b(om.a(this.b));
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.on
 * JD-Core Version:    0.6.0
 */