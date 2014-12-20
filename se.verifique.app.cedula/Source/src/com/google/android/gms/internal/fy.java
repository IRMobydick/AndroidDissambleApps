package com.google.android.gms.internal;

public final class fy
{
  public final bb a = new fz(this);
  public final bb b = new ga(this);
  private final Object c = new Object();
  private hk d;
  private String e;
  private int f = -2;
  private gd g;

  public fy(String paramString)
  {
    this.e = paramString;
  }

  public int a()
  {
    synchronized (this.c)
    {
      int i = this.f;
      return i;
    }
  }

  public void a(hk paramhk)
  {
    synchronized (this.c)
    {
      this.d = paramhk;
      return;
    }
  }

  public gd b()
  {
    gd localgd;
    synchronized (this.c)
    {
      while (true)
        if (this.g == null)
        {
          int i = this.f;
          if (i == -2)
            try
            {
              this.c.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              hi.e("Ad request service was interrupted.");
              localgd = null;
              break label66;
            }
        }
      localgd = this.g;
    }
    label66: return localgd;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fy
 * JD-Core Version:    0.6.0
 */