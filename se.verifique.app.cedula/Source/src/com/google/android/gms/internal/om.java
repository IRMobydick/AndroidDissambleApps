package com.google.android.gms.internal;

public final class om
{
  private final oo a;
  private final Runnable b;
  private ai c;
  private boolean d = false;
  private boolean e = false;
  private long f = 0L;

  public om(of paramof)
  {
    this(paramof, new oo(hh.a));
  }

  om(of paramof, oo paramoo)
  {
    this.a = paramoo;
    this.b = new on(this, paramof);
  }

  public void a()
  {
    this.d = false;
    this.a.a(this.b);
  }

  public void a(ai paramai)
  {
    a(paramai, 60000L);
  }

  public void a(ai paramai, long paramLong)
  {
    if (this.d)
      hi.e("An ad refresh is already scheduled.");
    while (true)
    {
      return;
      this.c = paramai;
      this.d = true;
      this.f = paramLong;
      if (this.e)
        continue;
      hi.c("Scheduling ad refresh " + paramLong + " milliseconds from now.");
      this.a.a(this.b, paramLong);
    }
  }

  public void b()
  {
    this.e = true;
    if (this.d)
      this.a.a(this.b);
  }

  public void c()
  {
    this.e = false;
    if (this.d)
    {
      this.d = false;
      a(this.c, this.f);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.om
 * JD-Core Version:    0.6.0
 */