package io.card.payment;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;

class ac extends ViewGroup
{
  private int a = 480;
  private int b = 640;
  private SurfaceView c;

  static
  {
    if (!ac.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      d = bool;
      return;
    }
  }

  public ac(Context paramContext)
  {
    super(paramContext, null);
    this.c = new SurfaceView(paramContext);
    addView(this.c);
  }

  public final SurfaceView a()
  {
    if ((!d) && (this.c == null))
      throw new AssertionError();
    return this.c;
  }

  final SurfaceHolder b()
  {
    SurfaceHolder localSurfaceHolder = a().getHolder();
    if ((!d) && (localSurfaceHolder == null))
      throw new AssertionError();
    return localSurfaceHolder;
  }

  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawARGB(255, 255, 0, 0);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    new StringBuilder("- isSurfaceValid: false").toString();
    int i;
    int j;
    if ((paramBoolean) && (getChildCount() > 0))
    {
      if ((!d) && (this.c == null))
        throw new AssertionError();
      i = paramInt3 - paramInt1;
      j = paramInt4 - paramInt2;
      if (i * this.b > j * this.a)
      {
        int m = j * this.a / this.b;
        this.c.layout((i - m) / 2, 0, (i + m) / 2, j);
      }
    }
    else
    {
      return;
    }
    int k = i * this.b / this.a;
    this.c.layout(0, (j - k) / 2, i, (j + k) / 2);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = resolveSize(getSuggestedMinimumWidth(), paramInt1);
    int j = resolveSize(getSuggestedMinimumHeight(), paramInt2);
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Integer.valueOf(paramInt1);
    arrayOfObject[1] = Integer.valueOf(paramInt2);
    arrayOfObject[2] = Integer.valueOf(i);
    arrayOfObject[3] = Integer.valueOf(j);
    String.format("Preview.onMeasure(w:%d, h:%d) setMeasuredDimension(w:%d, h:%d)", arrayOfObject);
    setMeasuredDimension(i, j);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     io.card.payment.ac
 * JD-Core Version:    0.6.2
 */