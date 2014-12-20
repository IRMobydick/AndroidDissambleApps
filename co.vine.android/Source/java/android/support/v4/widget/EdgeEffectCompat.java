package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;

public class EdgeEffectCompat
{
  private static final EdgeEffectImpl IMPL;
  private Object mEdgeEffect;

  static
  {
    if (Build.VERSION.SDK_INT >= 14)
      IMPL = new EdgeEffectCompat.EdgeEffectIcsImpl();
    while (true)
    {
      return;
      IMPL = new EdgeEffectCompat.BaseEdgeEffectImpl();
    }
  }

  public EdgeEffectCompat(Context paramContext)
  {
    this.mEdgeEffect = IMPL.newEdgeEffect(paramContext);
  }

  public boolean draw(Canvas paramCanvas)
  {
    return IMPL.draw(this.mEdgeEffect, paramCanvas);
  }

  public void finish()
  {
    IMPL.finish(this.mEdgeEffect);
  }

  public boolean isFinished()
  {
    return IMPL.isFinished(this.mEdgeEffect);
  }

  public boolean onAbsorb(int paramInt)
  {
    return IMPL.onAbsorb(this.mEdgeEffect, paramInt);
  }

  public boolean onPull(float paramFloat)
  {
    return IMPL.onPull(this.mEdgeEffect, paramFloat);
  }

  public boolean onRelease()
  {
    return IMPL.onRelease(this.mEdgeEffect);
  }

  public void setSize(int paramInt1, int paramInt2)
  {
    IMPL.setSize(this.mEdgeEffect, paramInt1, paramInt2);
  }

  static abstract interface EdgeEffectImpl
  {
    public abstract boolean draw(Object paramObject, Canvas paramCanvas);

    public abstract void finish(Object paramObject);

    public abstract boolean isFinished(Object paramObject);

    public abstract Object newEdgeEffect(Context paramContext);

    public abstract boolean onAbsorb(Object paramObject, int paramInt);

    public abstract boolean onPull(Object paramObject, float paramFloat);

    public abstract boolean onRelease(Object paramObject);

    public abstract void setSize(Object paramObject, int paramInt1, int paramInt2);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.EdgeEffectCompat
 * JD-Core Version:    0.6.0
 */