package com.crashlytics.android.internal;

import android.os.Handler;
import android.os.Looper;

public final class B extends b
{
  private final Handler b = new Handler(Looper.getMainLooper());

  public B(m paramm)
  {
    super(paramm);
  }

  public final void c(Object paramObject)
  {
    if ((paramObject instanceof t))
    {
      t localt = (t)paramObject;
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        super.c(localt);
        return;
      }
      this.b.post(new C(this, localt));
      return;
    }
    if (((paramObject instanceof s)) || ((paramObject instanceof f)))
    {
      super.c(paramObject);
      return;
    }
    throw new IllegalArgumentException("Posted argument must implement Event interface");
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.internal.B
 * JD-Core Version:    0.6.2
 */