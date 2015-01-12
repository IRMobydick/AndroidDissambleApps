package com.google.android.gms.internal;

import android.os.Bundle;

@ez
public class ge
{
  private final Object mw = new Object();
  private final String vA;
  private final gb vx;
  private int wc;
  private int wd;

  ge(gb paramgb, String paramString)
  {
    this.vx = paramgb;
    this.vA = paramString;
  }

  public ge(String paramString)
  {
    this(gb.cU(), paramString);
  }

  public void d(int paramInt1, int paramInt2)
  {
    synchronized (this.mw)
    {
      this.wc = paramInt1;
      this.wd = paramInt2;
      this.vx.a(this.vA, this);
      return;
    }
  }

  public Bundle toBundle()
  {
    synchronized (this.mw)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("pmnli", this.wc);
      localBundle.putInt("pmnll", this.wd);
      return localBundle;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ge
 * JD-Core Version:    0.6.2
 */