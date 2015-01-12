package com.ubercab.client.feature.trip.overlay;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.View;

public class CoachMarkPathView extends View
{
  private static final int STROKE_WIDTH = 3;
  private final AnimatorSet mAnimations = new AnimatorSet();
  private final ValueAnimator mCircle = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
  private final Paint mCirclePaint = new Paint(1);
  private final int mCircleRadiusPx = getResources().getDimensionPixelSize(2131362016);
  private RectF mCircleRect;
  private final ValueAnimator mLine = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
  private final int mLineHeightPx = getResources().getDimensionPixelSize(2131362017);
  private final Paint mLinePaint = new Paint(1);
  private LinearGradient mShader;
  private final int mUberBlue = getResources().getColor(2131296333);
  private final int mUberLightBlue = getResources().getColor(2131296340);

  public CoachMarkPathView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public CoachMarkPathView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mLinePaint.setStyle(Paint.Style.STROKE);
    this.mLinePaint.setStrokeWidth(3.0F);
    this.mLinePaint.setColor(this.mUberBlue);
    this.mCirclePaint.setStyle(Paint.Style.STROKE);
    this.mCirclePaint.setStrokeWidth(3.0F);
    this.mCirclePaint.setColor(this.mUberBlue);
    int i = getAnimationDuration();
    this.mLine.setDuration(i);
    this.mCircle.setDuration(i);
    AnimatorSet localAnimatorSet = this.mAnimations;
    Animator[] arrayOfAnimator = new Animator[2];
    arrayOfAnimator[0] = this.mLine;
    arrayOfAnimator[1] = this.mCircle;
    localAnimatorSet.playSequentially(arrayOfAnimator);
  }

  int getAnimationDuration()
  {
    return getResources().getInteger(2131492869);
  }

  AnimatorSet getAnimations()
  {
    return this.mAnimations;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getWidth() / 2;
    int j = this.mLineHeightPx;
    int k = i - this.mCircleRadiusPx;
    int m = this.mLineHeightPx;
    int n = 2 * this.mCircleRadiusPx;
    int i1 = k + n;
    int i2 = n + this.mLineHeightPx;
    if (this.mCircleRect == null)
      this.mCircleRect = new RectF(k, m, i1, i2);
    if (this.mShader == null)
    {
      Shader.TileMode localTileMode = Shader.TileMode.REPEAT;
      this.mShader = new LinearGradient(i, 0, i, j, this.mUberLightBlue, this.mUberBlue, localTileMode);
      this.mLinePaint.setShader(this.mShader);
    }
    if (this.mLine.isRunning())
    {
      float f2 = ((Float)this.mLine.getAnimatedValue()).floatValue();
      paramCanvas.drawLine(i, 0, i, f2 * j, this.mLinePaint);
    }
    while (true)
    {
      invalidate();
      return;
      float f1 = 360.0F * ((Float)this.mCircle.getAnimatedValue()).floatValue();
      paramCanvas.drawLine(i, 0, i, j, this.mLinePaint);
      paramCanvas.drawArc(this.mCircleRect, -90.0F, -f1, false, this.mCirclePaint);
    }
  }

  public void reset()
  {
    this.mAnimations.cancel();
  }

  public void start()
  {
    this.mAnimations.start();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.overlay.CoachMarkPathView
 * JD-Core Version:    0.6.2
 */