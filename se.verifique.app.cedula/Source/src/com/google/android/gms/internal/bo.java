package com.google.android.gms.internal;

public final class bo extends cc
{
  private final Object a = new Object();
  private bs b;
  private bn c;

  public void a()
  {
    synchronized (this.a)
    {
      if (this.c != null)
        this.c.j();
      return;
    }
  }

  public void a(int paramInt)
  {
    while (true)
    {
      synchronized (this.a)
      {
        if (this.b == null)
          continue;
        if (paramInt == 3)
        {
          i = 1;
          this.b.a(i);
          this.b = null;
          return;
        }
      }
      int i = 2;
    }
  }

  public void a(bn parambn)
  {
    synchronized (this.a)
    {
      this.c = parambn;
      return;
    }
  }

  public void a(bs parambs)
  {
    synchronized (this.a)
    {
      this.b = parambs;
      return;
    }
  }

  public void b()
  {
    synchronized (this.a)
    {
      if (this.c != null)
        this.c.k();
      return;
    }
  }

  public void c()
  {
    synchronized (this.a)
    {
      if (this.c != null)
        this.c.l();
      return;
    }
  }

  public void d()
  {
    synchronized (this.a)
    {
      if (this.c != null)
        this.c.m();
      return;
    }
  }

  public void e()
  {
    synchronized (this.a)
    {
      if (this.b != null)
      {
        this.b.a(0);
        this.b = null;
      }
      else if (this.c != null)
      {
        this.c.n();
      }
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.bo
 * JD-Core Version:    0.6.0
 */