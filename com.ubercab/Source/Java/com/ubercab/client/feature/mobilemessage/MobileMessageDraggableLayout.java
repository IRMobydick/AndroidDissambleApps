package com.ubercab.client.feature.mobilemessage;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.support.v4.widget.ViewDragHelper.Callback;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import com.ubercab.library.util.DisplayUtils;

public class MobileMessageDraggableLayout extends LinearLayout
{
  private static final int BOUNCE_BACK_MAX_DISTANCE = 0;
  private static final int OUT_OF_WINDOW_MARGINS = 0;
  private static final float SENSITIVITY_DRAG_HELPER = 0.8F;
  private boolean mActionStartedOutside = false;
  private LinearLayout mContentLayout;
  private boolean mDismissable = false;
  private ViewDragHelper mDragHelper;
  private float mFlingVelocityMax;
  private float mFlingVelocitySlow;
  private OnSwipeListener mListener;
  private int mStartingTopPosition = -1;

  public MobileMessageDraggableLayout(Context paramContext)
  {
    this(paramContext, null);
  }

  public MobileMessageDraggableLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public MobileMessageDraggableLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramContext);
    this.mFlingVelocitySlow = (2 * localViewConfiguration.getScaledMinimumFlingVelocity());
    this.mFlingVelocityMax = localViewConfiguration.getScaledMaximumFlingVelocity();
    this.mContentLayout = new LinearLayout(paramContext, paramAttributeSet, paramInt);
    super.addView(this.mContentLayout);
    this.mDragHelper = ViewDragHelper.create(this, 0.8F, new DragHelperCallback(null));
  }

  private boolean isActionOutside(MotionEvent paramMotionEvent)
  {
    return !new Rect(this.mContentLayout.getLeft(), this.mContentLayout.getTop(), this.mContentLayout.getRight(), this.mContentLayout.getBottom()).contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
  }

  public void addView(View paramView)
  {
    this.mContentLayout.addView(paramView);
  }

  public void computeScroll()
  {
    if (this.mDragHelper.continueSettling(true))
      ViewCompat.postInvalidateOnAnimation(this);
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mStartingTopPosition == -1)
    {
      this.mStartingTopPosition = this.mContentLayout.getTop();
      this.mDismissable = true;
    }
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    if (i == 0)
      this.mActionStartedOutside = false;
    do
    {
      boolean bool = this.mDragHelper.shouldInterceptTouchEvent(paramMotionEvent);
      do
      {
        return bool;
        bool = false;
      }
      while (i == 3);
    }
    while (i != 1);
    return false;
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.mDragHelper.processTouchEvent(paramMotionEvent);
    if ((paramMotionEvent.getActionMasked() == 0) && (isActionOutside(paramMotionEvent)))
    {
      this.mActionStartedOutside = true;
      return true;
    }
    if ((paramMotionEvent.getActionMasked() == 1) && (this.mActionStartedOutside) && (isActionOutside(paramMotionEvent)))
    {
      this.mListener.onClickOutside();
      return true;
    }
    return false;
  }

  public void removeAllViews()
  {
    this.mContentLayout.removeAllViews();
  }

  public void setOnSwipeListner(OnSwipeListener paramOnSwipeListener)
  {
    this.mListener = paramOnSwipeListener;
  }

  private class DragHelperCallback extends ViewDragHelper.Callback
  {
    private DragHelperCallback()
    {
    }

    public int clampViewPositionVertical(View paramView, int paramInt1, int paramInt2)
    {
      int i = -MobileMessageDraggableLayout.this.mContentLayout.getHeight();
      int j = MobileMessageDraggableLayout.this.getHeight();
      return Math.min(Math.max(paramInt1, i), j);
    }

    public int getViewVerticalDragRange(View paramView)
    {
      return MobileMessageDraggableLayout.this.getHeight();
    }

    public void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if ((MobileMessageDraggableLayout.this.mDismissable) && (MobileMessageDraggableLayout.this.mListener != null))
      {
        if (paramInt2 > -paramView.getHeight())
          break label58;
        MobileMessageDraggableLayout.this.mListener.onSwipeUp();
        MobileMessageDraggableLayout.access$902(MobileMessageDraggableLayout.this, false);
      }
      while (true)
      {
        MobileMessageDraggableLayout.this.invalidate();
        return;
        label58: if (paramInt2 >= MobileMessageDraggableLayout.this.getHeight())
        {
          MobileMessageDraggableLayout.this.mListener.onSwipeDown();
          MobileMessageDraggableLayout.access$902(MobileMessageDraggableLayout.this, false);
        }
      }
    }

    public void onViewReleased(View paramView, float paramFloat1, float paramFloat2)
    {
      int i = MobileMessageDraggableLayout.this.mStartingTopPosition - paramView.getTop();
      if (((Math.abs(paramFloat2) < MobileMessageDraggableLayout.this.mFlingVelocitySlow) && (Math.abs(i) <= MobileMessageDraggableLayout.BOUNCE_BACK_MAX_DISTANCE)) || (Math.abs(paramFloat2) >= MobileMessageDraggableLayout.this.mFlingVelocityMax))
        MobileMessageDraggableLayout.this.mDragHelper.settleCapturedViewAt(MobileMessageDraggableLayout.this.mContentLayout.getLeft(), MobileMessageDraggableLayout.this.mStartingTopPosition);
      while (true)
      {
        ViewCompat.postInvalidateOnAnimation(paramView);
        MobileMessageDraggableLayout.this.invalidate();
        return;
        if ((paramFloat2 > MobileMessageDraggableLayout.this.mFlingVelocitySlow) || ((i < MobileMessageDraggableLayout.BOUNCE_BACK_MAX_DISTANCE) && (Math.abs(paramFloat2) < MobileMessageDraggableLayout.this.mFlingVelocitySlow)))
          MobileMessageDraggableLayout.this.mDragHelper.smoothSlideViewTo(MobileMessageDraggableLayout.this.mContentLayout, MobileMessageDraggableLayout.this.mContentLayout.getLeft(), MobileMessageDraggableLayout.this.getHeight() + MobileMessageDraggableLayout.OUT_OF_WINDOW_MARGINS);
        else if ((paramFloat2 < -MobileMessageDraggableLayout.this.mFlingVelocitySlow) || ((i > MobileMessageDraggableLayout.BOUNCE_BACK_MAX_DISTANCE) && (Math.abs(paramFloat2) < MobileMessageDraggableLayout.this.mFlingVelocitySlow)))
          MobileMessageDraggableLayout.this.mDragHelper.smoothSlideViewTo(MobileMessageDraggableLayout.this.mContentLayout, MobileMessageDraggableLayout.this.mContentLayout.getLeft(), -MobileMessageDraggableLayout.this.mContentLayout.getHeight() - MobileMessageDraggableLayout.OUT_OF_WINDOW_MARGINS);
      }
    }

    public boolean tryCaptureView(View paramView, int paramInt)
    {
      return (!MobileMessageDraggableLayout.this.mActionStartedOutside) && (paramView == MobileMessageDraggableLayout.this.mContentLayout);
    }
  }

  public static abstract interface OnSwipeListener
  {
    public abstract void onClickOutside();

    public abstract void onSwipeDown();

    public abstract void onSwipeUp();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.mobilemessage.MobileMessageDraggableLayout
 * JD-Core Version:    0.6.2
 */