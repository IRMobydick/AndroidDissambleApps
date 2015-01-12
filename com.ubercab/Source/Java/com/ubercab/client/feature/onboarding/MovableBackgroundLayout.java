package com.ubercab.client.feature.onboarding;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class MovableBackgroundLayout extends LinearLayout
{
  private Bitmap mBackground;
  private int mBackgroundId;
  private Context mContext;
  private int mLeft;
  private Paint mPaint;

  public MovableBackgroundLayout(Context paramContext)
  {
    this(paramContext, null);
  }

  public MovableBackgroundLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public MovableBackgroundLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    this.mPaint = new Paint();
    setWillNotDraw(false);
  }

  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.mBackground != null)
    {
      paramCanvas.drawBitmap(this.mBackground, this.mLeft, 0.0F, this.mPaint);
      invalidate();
    }
  }

  void setBackground(int paramInt)
  {
    if (paramInt == -1)
    {
      this.mBackgroundId = -1;
      this.mBackground = null;
    }
    while (this.mBackgroundId == paramInt)
      return;
    this.mBackgroundId = paramInt;
    this.mBackground = ((BitmapDrawable)this.mContext.getResources().getDrawable(paramInt)).getBitmap();
  }

  void setBackgroundLeft(int paramInt)
  {
    this.mLeft = paramInt;
  }

  void setBackgroundRight(int paramInt)
  {
    this.mLeft = (getWidth() - paramInt);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.onboarding.MovableBackgroundLayout
 * JD-Core Version:    0.6.2
 */