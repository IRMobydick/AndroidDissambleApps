package android.support.v4.widget;

import android.view.View;

class d extends aa
{
  private final int b;
  private y c;
  private final Runnable d;

  private void b()
  {
    int i = 3;
    if (this.b == i)
      i = 5;
    View localView = this.a.a(i);
    if (localView != null)
      this.a.i(localView);
  }

  public int a(View paramView)
  {
    return paramView.getWidth();
  }

  public int a(View paramView, int paramInt1, int paramInt2)
  {
    if (this.a.a(paramView, 3));
    int i;
    for (int j = Math.max(-paramView.getWidth(), Math.min(paramInt1, 0)); ; j = Math.max(i - paramView.getWidth(), Math.min(paramInt1, i)))
    {
      return j;
      i = this.a.getWidth();
    }
  }

  public void a()
  {
    this.a.removeCallbacks(this.d);
  }

  public void a(int paramInt)
  {
    this.a.a(this.b, paramInt, this.c.c());
  }

  public void a(int paramInt1, int paramInt2)
  {
    this.a.postDelayed(this.d, 160L);
  }

  public void a(View paramView, float paramFloat1, float paramFloat2)
  {
    float f = this.a.d(paramView);
    int i = paramView.getWidth();
    int j;
    if (this.a.a(paramView, 3))
      if ((paramFloat1 > 0.0F) || ((paramFloat1 == 0.0F) && (f > 0.5F)))
        j = 0;
    while (true)
    {
      this.c.a(j, paramView.getTop());
      this.a.invalidate();
      return;
      j = -i;
      continue;
      j = this.a.getWidth();
      if ((paramFloat1 >= 0.0F) && ((paramFloat1 != 0.0F) || (f >= 0.5F)))
        continue;
      j -= i;
    }
  }

  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramView.getWidth();
    float f;
    if (this.a.a(paramView, 3))
    {
      f = (i + paramInt1) / i;
      this.a.b(paramView, f);
      if (f != 0.0F)
        break label82;
    }
    label82: for (int j = 4; ; j = 0)
    {
      paramView.setVisibility(j);
      this.a.invalidate();
      return;
      f = (this.a.getWidth() - paramInt1) / i;
      break;
    }
  }

  public boolean a(View paramView, int paramInt)
  {
    if ((this.a.g(paramView)) && (this.a.a(paramView, this.b)) && (this.a.a(paramView) == 0));
    for (int i = 1; ; i = 0)
      return i;
  }

  public int b(View paramView, int paramInt1, int paramInt2)
  {
    return paramView.getTop();
  }

  public void b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 & 0x1) == 1);
    for (View localView = this.a.a(3); ; localView = this.a.a(5))
    {
      if ((localView != null) && (this.a.a(localView) == 0))
        this.c.a(localView, paramInt2);
      return;
    }
  }

  public void b(View paramView, int paramInt)
  {
    ((b)paramView.getLayoutParams()).c = false;
    b();
  }

  public boolean b(int paramInt)
  {
    return false;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.d
 * JD-Core Version:    0.6.0
 */