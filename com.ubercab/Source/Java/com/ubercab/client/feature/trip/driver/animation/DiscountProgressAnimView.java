package com.ubercab.client.feature.trip.driver.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;

public class DiscountProgressAnimView extends FrameLayout
{
  private static final int BACKGROUND_COLOR = 2131296348;
  private static final int CHECK_DRAWABLE = 2130837680;
  private static final float CIRCLE_WIDTH_FRACTION = 0.1F;
  private static final long DURATION = 1000L;
  private static final long FRAME_DELAY = 50L;
  private static final long HALF_DURATION = 500L;
  private static final int ICON_INITIAL_SIZE = 5;
  private static final int MAX_CIRCLE_ROTATION = 358;
  private static final float MAX_ICON_SCALE = 6.0F;
  private static final float MAX_PULSE_SCALE = 4.0F;
  private static final float MIN_WIDTH_FRACTION = 0.25F;
  private static final int NUM_CIRCLES = 4;
  private static final long SMALL_DELAY = 300L;
  private CircleView mCenterView;
  private boolean mCheckOutQueued;
  private CircleView[] mCircles = new CircleView[4];
  private CircleView mFakeClipView;
  private boolean mHasCheckInEnded;
  private ImageView mIconView;
  private boolean mInitialLayoutFinished;
  private boolean mPulseQueued;
  private CircleView mPulseView;

  public DiscountProgressAnimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private void showCheckInAnimation()
  {
    this.mFakeClipView.setVisibility(0);
    DecelerateInterpolator localDecelerateInterpolator = new DecelerateInterpolator(1.5F);
    this.mCenterView.animateScale(1.0F, 4.0F, 500L, 0L, 0, localDecelerateInterpolator);
    this.mFakeClipView.animateScale(1.0F, 3.0F, 200L, 300L, 0, localDecelerateInterpolator);
    this.mIconView.setVisibility(0);
    this.mIconView.setImageDrawable(getResources().getDrawable(2130837680));
    this.mIconView.animate().scaleX(6.0F).scaleY(6.0F).setDuration(300L).setStartDelay(200L).setInterpolator(localDecelerateInterpolator).setListener(new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        DiscountProgressAnimView.access$102(DiscountProgressAnimView.this, true);
        if (DiscountProgressAnimView.this.mCheckOutQueued)
          DiscountProgressAnimView.this.startCheckOutAnimation();
      }

      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        DiscountProgressAnimView.access$102(DiscountProgressAnimView.this, true);
        if (DiscountProgressAnimView.this.mCheckOutQueued)
          DiscountProgressAnimView.this.startCheckOutAnimation();
      }

      public void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
      }
    }).start();
  }

  private void stopPulseAnimations()
  {
    if (this.mPulseView != null)
      this.mPulseView.stopAnimating();
    CircleView[] arrayOfCircleView = this.mCircles;
    int i = arrayOfCircleView.length;
    for (int j = 0; j < i; j++)
      arrayOfCircleView[j].stopAnimating();
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    FrameLayout.LayoutParams localLayoutParams1 = new FrameLayout.LayoutParams(-2, -2, 49);
    for (int i = 0; i < 4; i++)
    {
      CircleView localCircleView = new CircleView(getContext());
      localCircleView.setAlpha(1.0F / (i + 1));
      localCircleView.setVisibility(8);
      this.mCircles[i] = localCircleView;
      addView(localCircleView, localLayoutParams1);
    }
    this.mPulseView = new CircleView(getContext());
    FrameLayout.LayoutParams localLayoutParams2 = new FrameLayout.LayoutParams(-2, -2, 17);
    this.mPulseView.setVisibility(8);
    addView(this.mPulseView, localLayoutParams2);
    this.mCenterView = new CircleView(getContext());
    addView(this.mCenterView, localLayoutParams2);
    this.mFakeClipView = new CircleView(getContext());
    this.mFakeClipView.setCircleColor(2131296348);
    this.mFakeClipView.setVisibility(8);
    addView(this.mFakeClipView, localLayoutParams2);
    this.mIconView = new ImageView(getContext());
    FrameLayout.LayoutParams localLayoutParams3 = new FrameLayout.LayoutParams(5, 5, 17);
    this.mIconView.setVisibility(8);
    addView(this.mIconView, localLayoutParams3);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.mInitialLayoutFinished = true;
    if (this.mPulseQueued)
      startPulseAnimation();
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt2);
    int k = Math.min(i, j);
    int m = (int)(0.1F * k);
    int n = (int)(0.25F * (k - m * 2));
    for (CircleView localCircleView : this.mCircles)
      if (localCircleView.getVisibility() != 8)
        measureChild(localCircleView, View.MeasureSpec.makeMeasureSpec(m, 1073741824), View.MeasureSpec.makeMeasureSpec(m, 1073741824));
    if (this.mPulseView.getVisibility() != 8)
      measureChild(this.mPulseView, View.MeasureSpec.makeMeasureSpec(n, 1073741824), View.MeasureSpec.makeMeasureSpec(n, 1073741824));
    if (this.mCenterView.getVisibility() != 8)
      measureChild(this.mCenterView, View.MeasureSpec.makeMeasureSpec(n, 1073741824), View.MeasureSpec.makeMeasureSpec(n, 1073741824));
    if (this.mFakeClipView.getVisibility() != 8)
      measureChild(this.mFakeClipView, View.MeasureSpec.makeMeasureSpec(n, 1073741824), View.MeasureSpec.makeMeasureSpec(n, 1073741824));
    if (this.mIconView.getVisibility() != 8)
      measureChild(this.mIconView, View.MeasureSpec.makeMeasureSpec(5, 1073741824), View.MeasureSpec.makeMeasureSpec(5, 1073741824));
    setMeasuredDimension(i, j);
  }

  public void startCheckInAnimation()
  {
    stopPulseAnimations();
    postDelayed(new Runnable()
    {
      public void run()
      {
        DiscountProgressAnimView.this.showCheckInAnimation();
      }
    }
    , 1000L);
  }

  public void startCheckOutAnimation()
  {
    if (!this.mHasCheckInEnded)
    {
      this.mCheckOutQueued = true;
      return;
    }
    this.mCheckOutQueued = false;
    DecelerateInterpolator localDecelerateInterpolator = new DecelerateInterpolator(1.5F);
    this.mIconView.animate().scaleX(0.0F).scaleY(0.0F).setDuration(500L).setStartDelay(0L).setInterpolator(localDecelerateInterpolator).start();
    this.mFakeClipView.animateScale(3.0F, 0.0F, 500L, 0L, 0, localDecelerateInterpolator);
    this.mCenterView.animateScale(4.0F, 0.0F, 200L, 300L, 0, localDecelerateInterpolator);
  }

  public void startPulseAnimation()
  {
    if (!this.mInitialLayoutFinished)
      this.mPulseQueued = true;
    while (true)
    {
      return;
      this.mPulseQueued = false;
      int i = 0;
      this.mPulseView.setVisibility(0);
      this.mPulseView.animateScaleAndAlpha(1.0F, 4.0F, 1.0F, 0.0F, 1000L, 0, -1, new DecelerateInterpolator());
      for (int j = 0; j < 4; j++)
      {
        this.mCircles[j].setVisibility(0);
        this.mCircles[j].animateRotation(0.0F, 358.0F, 1, 0.5F, 2, 0.5F, 1000L - i, i, -1, new AccelerateDecelerateInterpolator());
        i = (int)(50L + i);
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.driver.animation.DiscountProgressAnimView
 * JD-Core Version:    0.6.2
 */