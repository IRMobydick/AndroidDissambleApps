package android.support.v4.view;

import android.graphics.Paint;
import android.os.Build.VERSION;
import android.view.View;

public class x
{
  static final af a;

  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 17)
      a = new ae();
    while (true)
    {
      return;
      if (i >= 16)
      {
        a = new ad();
        continue;
      }
      if (i >= 14)
      {
        a = new ac();
        continue;
      }
      if (i >= 11)
      {
        a = new ab();
        continue;
      }
      if (i >= 9)
      {
        a = new aa();
        continue;
      }
      a = new y();
    }
  }

  public static int a(View paramView)
  {
    return a.a(paramView);
  }

  public static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a.a(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public static void a(View paramView, int paramInt, Paint paramPaint)
  {
    a.a(paramView, paramInt, paramPaint);
  }

  public static void a(View paramView, Paint paramPaint)
  {
    a.a(paramView, paramPaint);
  }

  public static void a(View paramView, Runnable paramRunnable)
  {
    a.a(paramView, paramRunnable);
  }

  public static boolean a(View paramView, int paramInt)
  {
    return a.a(paramView, paramInt);
  }

  public static void b(View paramView)
  {
    a.b(paramView);
  }

  public static int c(View paramView)
  {
    return a.c(paramView);
  }

  public static int d(View paramView)
  {
    return a.d(paramView);
  }

  public static boolean e(View paramView)
  {
    return a.e(paramView);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.x
 * JD-Core Version:    0.6.0
 */