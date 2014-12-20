package android.support.v4.widget;

import android.graphics.Canvas;
import android.os.Build.VERSION;

public class e
{
  private static final h b;
  private Object a;

  static
  {
    if (Build.VERSION.SDK_INT >= 14)
      b = new g();
    while (true)
    {
      return;
      b = new f();
    }
  }

  public void a(int paramInt1, int paramInt2)
  {
    b.a(this.a, paramInt1, paramInt2);
  }

  public boolean a()
  {
    return b.a(this.a);
  }

  public boolean a(float paramFloat)
  {
    return b.a(this.a, paramFloat);
  }

  public boolean a(Canvas paramCanvas)
  {
    return b.a(this.a, paramCanvas);
  }

  public void b()
  {
    b.b(this.a);
  }

  public boolean c()
  {
    return b.c(this.a);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.e
 * JD-Core Version:    0.6.0
 */