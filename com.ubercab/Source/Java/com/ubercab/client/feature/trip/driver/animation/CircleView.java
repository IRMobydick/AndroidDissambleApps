package com.ubercab.client.feature.trip.driver.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;

public class CircleView extends View
  implements Animation.AnimationListener, Animator.AnimatorListener
{
  private static final int CIRCLE_COLOR = 2131296333;
  private Paint mPaint = new Paint(1);
  private boolean mStopAnimating;

  public CircleView(Context paramContext)
  {
    this(paramContext, null);
  }

  public CircleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public CircleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mPaint.setColor(getResources().getColor(2131296333));
  }

  public void animateRotation(float paramFloat1, float paramFloat2, int paramInt1, float paramFloat3, int paramInt2, float paramFloat4, long paramLong1, long paramLong2, int paramInt3, Interpolator paramInterpolator)
  {
    this.mStopAnimating = false;
    RotateAnimation localRotateAnimation = new RotateAnimation(paramFloat1, paramFloat2, paramInt1, paramFloat3, paramInt2, paramFloat4);
    localRotateAnimation.setRepeatMode(1);
    localRotateAnimation.setRepeatCount(paramInt3);
    localRotateAnimation.setDuration(paramLong1);
    localRotateAnimation.setStartOffset(paramLong2);
    localRotateAnimation.setInterpolator(paramInterpolator);
    localRotateAnimation.setAnimationListener(this);
    setAnimation(localRotateAnimation);
  }

  public void animateScale(float paramFloat1, float paramFloat2, long paramLong1, long paramLong2, int paramInt, Interpolator paramInterpolator)
  {
    this.mStopAnimating = false;
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this, "scaleX", new float[] { paramFloat1, paramFloat2 });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this, "scaleY", new float[] { paramFloat1, paramFloat2 });
    localObjectAnimator1.setRepeatCount(paramInt);
    localObjectAnimator2.setRepeatCount(paramInt);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2);
    localAnimatorSet.setDuration(paramLong1);
    localAnimatorSet.setStartDelay(paramLong2);
    localAnimatorSet.setInterpolator(paramInterpolator);
    localAnimatorSet.addListener(this);
    localAnimatorSet.start();
  }

  public void animateScaleAndAlpha(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, long paramLong1, long paramLong2, int paramInt, Interpolator paramInterpolator)
  {
    this.mStopAnimating = false;
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this, "scaleX", new float[] { paramFloat1, paramFloat2 });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this, "scaleY", new float[] { paramFloat1, paramFloat2 });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this, "alpha", new float[] { paramFloat3, paramFloat4 });
    localObjectAnimator3.setRepeatCount(paramInt);
    localObjectAnimator1.setRepeatCount(paramInt);
    localObjectAnimator2.setRepeatCount(paramInt);
    localObjectAnimator3.addListener(this);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator3).with(localObjectAnimator1).with(localObjectAnimator2);
    localAnimatorSet.setDuration(paramLong1);
    localAnimatorSet.setStartDelay(paramLong2);
    localAnimatorSet.setInterpolator(paramInterpolator);
    localAnimatorSet.start();
  }

  public void onAnimationCancel(Animator paramAnimator)
  {
  }

  public void onAnimationEnd(Animator paramAnimator)
  {
  }

  public void onAnimationEnd(Animation paramAnimation)
  {
  }

  public void onAnimationRepeat(final Animator paramAnimator)
  {
    if (this.mStopAnimating)
    {
      post(new Runnable()
      {
        public void run()
        {
          paramAnimator.end();
        }
      });
      setVisibility(8);
    }
  }

  public void onAnimationRepeat(Animation paramAnimation)
  {
    if (this.mStopAnimating)
    {
      paramAnimation.cancel();
      setVisibility(8);
    }
  }

  public void onAnimationStart(Animator paramAnimator)
  {
  }

  public void onAnimationStart(Animation paramAnimation)
  {
  }

  protected void onDraw(Canvas paramCanvas)
  {
    if (getVisibility() == 0)
    {
      int i = getWidth() / 2;
      int j = getHeight() / 2;
      paramCanvas.drawCircle(i, j, i, this.mPaint);
    }
  }

  public void setCircleColor(int paramInt)
  {
    this.mPaint.setColor(getResources().getColor(paramInt));
  }

  public void stopAnimating()
  {
    this.mStopAnimating = true;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.driver.animation.CircleView
 * JD-Core Version:    0.6.2
 */