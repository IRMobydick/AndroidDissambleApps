package android.support.v4.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;

public class ScrollerCompat
{
  static final ScrollerCompatImpl IMPL;
  Object mScroller;

  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 14)
      IMPL = new ScrollerCompat.ScrollerCompatImplIcs();
    while (true)
    {
      return;
      if (i >= 9)
      {
        IMPL = new ScrollerCompat.ScrollerCompatImplGingerbread();
        continue;
      }
      IMPL = new ScrollerCompat.ScrollerCompatImplBase();
    }
  }

  ScrollerCompat(Context paramContext, Interpolator paramInterpolator)
  {
    this.mScroller = IMPL.createScroller(paramContext, paramInterpolator);
  }

  public static ScrollerCompat create(Context paramContext)
  {
    return create(paramContext, null);
  }

  public static ScrollerCompat create(Context paramContext, Interpolator paramInterpolator)
  {
    return new ScrollerCompat(paramContext, paramInterpolator);
  }

  public void abortAnimation()
  {
    IMPL.abortAnimation(this.mScroller);
  }

  public boolean computeScrollOffset()
  {
    return IMPL.computeScrollOffset(this.mScroller);
  }

  public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    IMPL.fling(this.mScroller, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
  }

  public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    IMPL.fling(this.mScroller, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
  }

  public float getCurrVelocity()
  {
    return IMPL.getCurrVelocity(this.mScroller);
  }

  public int getCurrX()
  {
    return IMPL.getCurrX(this.mScroller);
  }

  public int getCurrY()
  {
    return IMPL.getCurrY(this.mScroller);
  }

  public int getFinalX()
  {
    return IMPL.getFinalX(this.mScroller);
  }

  public int getFinalY()
  {
    return IMPL.getFinalY(this.mScroller);
  }

  public boolean isFinished()
  {
    return IMPL.isFinished(this.mScroller);
  }

  public boolean isOverScrolled()
  {
    return IMPL.isOverScrolled(this.mScroller);
  }

  public void notifyHorizontalEdgeReached(int paramInt1, int paramInt2, int paramInt3)
  {
    IMPL.notifyHorizontalEdgeReached(this.mScroller, paramInt1, paramInt2, paramInt3);
  }

  public void notifyVerticalEdgeReached(int paramInt1, int paramInt2, int paramInt3)
  {
    IMPL.notifyVerticalEdgeReached(this.mScroller, paramInt1, paramInt2, paramInt3);
  }

  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    IMPL.startScroll(this.mScroller, paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    IMPL.startScroll(this.mScroller, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }

  static abstract interface ScrollerCompatImpl
  {
    public abstract void abortAnimation(Object paramObject);

    public abstract boolean computeScrollOffset(Object paramObject);

    public abstract Object createScroller(Context paramContext, Interpolator paramInterpolator);

    public abstract void fling(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8);

    public abstract void fling(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10);

    public abstract float getCurrVelocity(Object paramObject);

    public abstract int getCurrX(Object paramObject);

    public abstract int getCurrY(Object paramObject);

    public abstract int getFinalX(Object paramObject);

    public abstract int getFinalY(Object paramObject);

    public abstract boolean isFinished(Object paramObject);

    public abstract boolean isOverScrolled(Object paramObject);

    public abstract void notifyHorizontalEdgeReached(Object paramObject, int paramInt1, int paramInt2, int paramInt3);

    public abstract void notifyVerticalEdgeReached(Object paramObject, int paramInt1, int paramInt2, int paramInt3);

    public abstract void startScroll(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4);

    public abstract void startScroll(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.ScrollerCompat
 * JD-Core Version:    0.6.0
 */