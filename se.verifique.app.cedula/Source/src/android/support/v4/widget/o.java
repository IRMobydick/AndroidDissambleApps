package android.support.v4.widget;

import android.widget.OverScroller;

class o
{
  public static void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    ((OverScroller)paramObject).startScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }

  public static boolean a(Object paramObject)
  {
    return ((OverScroller)paramObject).isFinished();
  }

  public static int b(Object paramObject)
  {
    return ((OverScroller)paramObject).getCurrX();
  }

  public static int c(Object paramObject)
  {
    return ((OverScroller)paramObject).getCurrY();
  }

  public static boolean d(Object paramObject)
  {
    return ((OverScroller)paramObject).computeScrollOffset();
  }

  public static void e(Object paramObject)
  {
    ((OverScroller)paramObject).abortAnimation();
  }

  public static int f(Object paramObject)
  {
    return ((OverScroller)paramObject).getFinalX();
  }

  public static int g(Object paramObject)
  {
    return ((OverScroller)paramObject).getFinalY();
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.o
 * JD-Core Version:    0.6.0
 */