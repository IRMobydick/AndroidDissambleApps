package android.support.v4.widget;

import android.graphics.Canvas;
import android.widget.EdgeEffect;

class i
{
  public static void a(Object paramObject, int paramInt1, int paramInt2)
  {
    ((EdgeEffect)paramObject).setSize(paramInt1, paramInt2);
  }

  public static boolean a(Object paramObject)
  {
    return ((EdgeEffect)paramObject).isFinished();
  }

  public static boolean a(Object paramObject, float paramFloat)
  {
    ((EdgeEffect)paramObject).onPull(paramFloat);
    return true;
  }

  public static boolean a(Object paramObject, Canvas paramCanvas)
  {
    return ((EdgeEffect)paramObject).draw(paramCanvas);
  }

  public static void b(Object paramObject)
  {
    ((EdgeEffect)paramObject).finish();
  }

  public static boolean c(Object paramObject)
  {
    EdgeEffect localEdgeEffect = (EdgeEffect)paramObject;
    localEdgeEffect.onRelease();
    return localEdgeEffect.isFinished();
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.i
 * JD-Core Version:    0.6.0
 */