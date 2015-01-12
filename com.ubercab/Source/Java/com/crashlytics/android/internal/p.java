package com.crashlytics.android.internal;

import android.content.Context;

public abstract class p
{
  private Context a;
  private boolean b;

  protected final void a(Context paramContext)
  {
    while (true)
    {
      try
      {
        boolean bool = this.b;
        if (bool)
          return;
        if (paramContext == null)
          throw new IllegalArgumentException("context cannot be null.");
      }
      finally
      {
      }
      this.a = new z(paramContext.getApplicationContext(), getName());
      this.b = true;
      c();
    }
  }

  protected abstract void c();

  public String getComponentPath()
  {
    return ".TwitterSdk/" + getName();
  }

  public final Context getContext()
  {
    return this.a;
  }

  public final String getName()
  {
    return getClass().getSimpleName().toLowerCase();
  }

  public abstract String getVersion();

  public final boolean isInitialized()
  {
    try
    {
      boolean bool = this.b;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.internal.p
 * JD-Core Version:    0.6.2
 */