package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.SystemClock;

public final class iw extends Drawable
  implements Drawable.Callback
{
  private boolean KL = true;
  private int KR = 0;
  private long KS;
  private int KT;
  private int KU = 255;
  private int KV;
  private int KW = 0;
  private boolean KX;
  private b KY;
  private Drawable KZ;
  private Drawable La;
  private boolean Lb;
  private boolean Lc;
  private boolean Ld;
  private int Le;
  private int mFrom;

  public iw(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    this(null);
    if (paramDrawable1 == null)
      paramDrawable1 = a.gL();
    this.KZ = paramDrawable1;
    paramDrawable1.setCallback(this);
    b localb1 = this.KY;
    localb1.Li |= paramDrawable1.getChangingConfigurations();
    if (paramDrawable2 == null)
      paramDrawable2 = a.gL();
    this.La = paramDrawable2;
    paramDrawable2.setCallback(this);
    b localb2 = this.KY;
    localb2.Li |= paramDrawable2.getChangingConfigurations();
  }

  iw(b paramb)
  {
    this.KY = new b(paramb);
  }

  public boolean canConstantState()
  {
    if (!this.Lb)
      if ((this.KZ.getConstantState() == null) || (this.La.getConstantState() == null))
        break label44;
    label44: for (boolean bool = true; ; bool = false)
    {
      this.Lc = bool;
      this.Lb = true;
      return this.Lc;
    }
  }

  public void draw(Canvas paramCanvas)
  {
    int i = 1;
    switch (this.KR)
    {
    default:
    case 1:
    case 2:
    }
    int k;
    boolean bool;
    Drawable localDrawable1;
    Drawable localDrawable2;
    do
      for (int j = i; ; j = 0)
      {
        k = this.KW;
        bool = this.KL;
        localDrawable1 = this.KZ;
        localDrawable2 = this.La;
        if (j == 0)
          break;
        if ((!bool) || (k == 0))
          localDrawable1.draw(paramCanvas);
        if (k == this.KU)
        {
          localDrawable2.setAlpha(this.KU);
          localDrawable2.draw(paramCanvas);
        }
        return;
        this.KS = SystemClock.uptimeMillis();
        this.KR = 2;
      }
    while (this.KS < 0L);
    float f1 = (float)(SystemClock.uptimeMillis() - this.KS) / this.KV;
    if (f1 >= 1.0F);
    while (true)
    {
      if (i != 0)
        this.KR = 0;
      float f2 = Math.min(f1, 1.0F);
      this.KW = ((int)(this.mFrom + f2 * (this.KT - this.mFrom)));
      break;
      i = 0;
    }
    if (bool)
      localDrawable1.setAlpha(this.KU - k);
    localDrawable1.draw(paramCanvas);
    if (bool)
      localDrawable1.setAlpha(this.KU);
    if (k > 0)
    {
      localDrawable2.setAlpha(k);
      localDrawable2.draw(paramCanvas);
      localDrawable2.setAlpha(this.KU);
    }
    invalidateSelf();
  }

  public Drawable gK()
  {
    return this.La;
  }

  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.KY.Lh | this.KY.Li;
  }

  public Drawable.ConstantState getConstantState()
  {
    if (canConstantState())
    {
      this.KY.Lh = getChangingConfigurations();
      return this.KY;
    }
    return null;
  }

  public int getIntrinsicHeight()
  {
    return Math.max(this.KZ.getIntrinsicHeight(), this.La.getIntrinsicHeight());
  }

  public int getIntrinsicWidth()
  {
    return Math.max(this.KZ.getIntrinsicWidth(), this.La.getIntrinsicWidth());
  }

  public int getOpacity()
  {
    if (!this.Ld)
    {
      this.Le = Drawable.resolveOpacity(this.KZ.getOpacity(), this.La.getOpacity());
      this.Ld = true;
    }
    return this.Le;
  }

  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (kc.hB())
    {
      Drawable.Callback localCallback = getCallback();
      if (localCallback != null)
        localCallback.invalidateDrawable(this);
    }
  }

  public Drawable mutate()
  {
    if ((!this.KX) && (super.mutate() == this))
    {
      if (!canConstantState())
        throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
      this.KZ.mutate();
      this.La.mutate();
      this.KX = true;
    }
    return this;
  }

  protected void onBoundsChange(Rect paramRect)
  {
    this.KZ.setBounds(paramRect);
    this.La.setBounds(paramRect);
  }

  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    if (kc.hB())
    {
      Drawable.Callback localCallback = getCallback();
      if (localCallback != null)
        localCallback.scheduleDrawable(this, paramRunnable, paramLong);
    }
  }

  public void setAlpha(int paramInt)
  {
    if (this.KW == this.KU)
      this.KW = paramInt;
    this.KU = paramInt;
    invalidateSelf();
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.KZ.setColorFilter(paramColorFilter);
    this.La.setColorFilter(paramColorFilter);
  }

  public void startTransition(int paramInt)
  {
    this.mFrom = 0;
    this.KT = this.KU;
    this.KW = 0;
    this.KV = paramInt;
    this.KR = 1;
    invalidateSelf();
  }

  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    if (kc.hB())
    {
      Drawable.Callback localCallback = getCallback();
      if (localCallback != null)
        localCallback.unscheduleDrawable(this, paramRunnable);
    }
  }

  private static final class a extends Drawable
  {
    private static final a Lf = new a();
    private static final a Lg = new a(null);

    public void draw(Canvas paramCanvas)
    {
    }

    public Drawable.ConstantState getConstantState()
    {
      return Lg;
    }

    public int getOpacity()
    {
      return -2;
    }

    public void setAlpha(int paramInt)
    {
    }

    public void setColorFilter(ColorFilter paramColorFilter)
    {
    }

    private static final class a extends Drawable.ConstantState
    {
      public int getChangingConfigurations()
      {
        return 0;
      }

      public Drawable newDrawable()
      {
        return iw.a.gL();
      }
    }
  }

  static final class b extends Drawable.ConstantState
  {
    int Lh;
    int Li;

    b(b paramb)
    {
      if (paramb != null)
      {
        this.Lh = paramb.Lh;
        this.Li = paramb.Li;
      }
    }

    public int getChangingConfigurations()
    {
      return this.Lh;
    }

    public Drawable newDrawable()
    {
      return new iw(this);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.iw
 * JD-Core Version:    0.6.2
 */