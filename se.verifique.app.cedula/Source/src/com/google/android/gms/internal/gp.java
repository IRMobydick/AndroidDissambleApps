package com.google.android.gms.internal;

import android.os.Bundle;

public class gp
{
  private final Object a = new Object();
  private int b;
  private int c;
  private final gm d;
  private final String e;

  gp(gm paramgm, String paramString)
  {
    this.d = paramgm;
    this.e = paramString;
  }

  public gp(String paramString)
  {
    this(gm.a(), paramString);
  }

  public Bundle a()
  {
    synchronized (this.a)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("pmnli", this.b);
      localBundle.putInt("pmnll", this.c);
      return localBundle;
    }
  }

  public void a(int paramInt1, int paramInt2)
  {
    synchronized (this.a)
    {
      this.b = paramInt1;
      this.c = paramInt2;
      this.d.a(this.e, this);
      return;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gp
 * JD-Core Version:    0.6.0
 */