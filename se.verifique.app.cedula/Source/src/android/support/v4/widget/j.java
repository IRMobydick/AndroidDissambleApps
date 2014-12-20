package android.support.v4.widget;

import android.os.Build.VERSION;

public class j
{
  static final k b;
  Object a;

  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 14)
      b = new n();
    while (true)
    {
      return;
      if (i >= 9)
      {
        b = new m();
        continue;
      }
      b = new l();
    }
  }

  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    b.a(this.a, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }

  public boolean a()
  {
    return b.a(this.a);
  }

  public int b()
  {
    return b.b(this.a);
  }

  public int c()
  {
    return b.c(this.a);
  }

  public int d()
  {
    return b.f(this.a);
  }

  public int e()
  {
    return b.g(this.a);
  }

  public boolean f()
  {
    return b.d(this.a);
  }

  public void g()
  {
    b.e(this.a);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.j
 * JD-Core Version:    0.6.0
 */