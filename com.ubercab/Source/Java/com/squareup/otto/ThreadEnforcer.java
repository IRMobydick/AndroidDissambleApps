package com.squareup.otto;

import android.os.Looper;

public abstract interface ThreadEnforcer
{
  public static final ThreadEnforcer ANY = new ThreadEnforcer()
  {
    public void enforce(Bus paramAnonymousBus)
    {
    }
  };
  public static final ThreadEnforcer MAIN = new ThreadEnforcer()
  {
    public void enforce(Bus paramAnonymousBus)
    {
      if (Looper.myLooper() != Looper.getMainLooper())
        throw new IllegalStateException("Event bus " + paramAnonymousBus + " accessed from non-main thread " + Looper.myLooper());
    }
  };

  public abstract void enforce(Bus paramBus);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.otto.ThreadEnforcer
 * JD-Core Version:    0.6.2
 */