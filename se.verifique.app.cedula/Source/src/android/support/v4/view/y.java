package android.support.v4.view;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;

class y
  implements af
{
  public int a(View paramView)
  {
    return 2;
  }

  long a()
  {
    return 10L;
  }

  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.postInvalidateDelayed(a(), paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public void a(View paramView, int paramInt, Paint paramPaint)
  {
  }

  public void a(View paramView, Paint paramPaint)
  {
  }

  public void a(View paramView, Runnable paramRunnable)
  {
    paramView.postDelayed(paramRunnable, a());
  }

  public boolean a(View paramView, int paramInt)
  {
    return false;
  }

  public void b(View paramView)
  {
    paramView.postInvalidateDelayed(a());
  }

  public int c(View paramView)
  {
    return 0;
  }

  public int d(View paramView)
  {
    return 0;
  }

  public boolean e(View paramView)
  {
    int i = 0;
    Drawable localDrawable = paramView.getBackground();
    if ((localDrawable != null) && (localDrawable.getOpacity() == -1))
      i = 1;
    return i;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.y
 * JD-Core Version:    0.6.0
 */