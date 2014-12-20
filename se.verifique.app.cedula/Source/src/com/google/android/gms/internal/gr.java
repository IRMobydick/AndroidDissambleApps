package com.google.android.gms.internal;

public abstract class gr
{
  private final Runnable a = new gs(this);
  private volatile Thread b;

  public abstract void a();

  public abstract void b();

  public final void e()
  {
    gt.a(this.a);
  }

  public final void f()
  {
    b();
    if (this.b != null)
      this.b.interrupt();
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gr
 * JD-Core Version:    0.6.0
 */