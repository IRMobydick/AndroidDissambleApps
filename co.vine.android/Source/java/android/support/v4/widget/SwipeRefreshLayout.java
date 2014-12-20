package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;

public class SwipeRefreshLayout extends ViewGroup
{
  private static final float ACCELERATE_INTERPOLATION_FACTOR = 1.5F;
  private static final float DECELERATE_INTERPOLATION_FACTOR = 2.0F;
  private static final int[] LAYOUT_ATTRS;
  private static final float MAX_SWIPE_DISTANCE_FACTOR = 0.6F;
  private static final float PROGRESS_BAR_HEIGHT = 4.0F;
  private static final int REFRESH_TRIGGER_DISTANCE = 120;
  private static final long RETURN_TO_ORIGINAL_POSITION_TIMEOUT = 300L;
  private final AccelerateInterpolator mAccelerateInterpolator;
  private final Animation mAnimateToStartPosition = new Animation()
  {
    public void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      int i = 0;
      if (SwipeRefreshLayout.this.mFrom != SwipeRefreshLayout.this.mOriginalOffsetTop)
        i = SwipeRefreshLayout.this.mFrom + (int)(paramFloat * (SwipeRefreshLayout.this.mOriginalOffsetTop - SwipeRefreshLayout.this.mFrom));
      int j = i - SwipeRefreshLayout.this.mTarget.getTop();
      int k = SwipeRefreshLayout.this.mTarget.getTop();
      if (j + k < 0)
        j = 0 - k;
      SwipeRefreshLayout.this.setTargetOffsetTopAndBottom(j);
    }
  };
  private final Runnable mCancel = new Runnable()
  {
    public void run()
    {
      SwipeRefreshLayout.access$902(SwipeRefreshLayout.this, true);
      if (SwipeRefreshLayout.this.mProgressBar != null)
      {
        SwipeRefreshLayout.access$402(SwipeRefreshLayout.this, SwipeRefreshLayout.this.mCurrPercentage);
        SwipeRefreshLayout.this.mShrinkTrigger.setDuration(SwipeRefreshLayout.this.mMediumAnimationDuration);
        SwipeRefreshLayout.this.mShrinkTrigger.setAnimationListener(SwipeRefreshLayout.this.mShrinkAnimationListener);
        SwipeRefreshLayout.this.mShrinkTrigger.reset();
        SwipeRefreshLayout.this.mShrinkTrigger.setInterpolator(SwipeRefreshLayout.this.mDecelerateInterpolator);
        SwipeRefreshLayout.this.startAnimation(SwipeRefreshLayout.this.mShrinkTrigger);
      }
      SwipeRefreshLayout.this.animateOffsetToStartPosition(SwipeRefreshLayout.this.mCurrentTargetOffsetTop + SwipeRefreshLayout.this.getPaddingTop(), SwipeRefreshLayout.this.mReturnToStartPositionListener);
    }
  };
  private float mCurrPercentage = 0.0F;
  private int mCurrentTargetOffsetTop;
  private final DecelerateInterpolator mDecelerateInterpolator;
  private float mDistanceToTriggerSync = -1.0F;
  private MotionEvent mDownEvent;
  private int mFrom;
  private float mFromPercentage = 0.0F;
  private OnRefreshListener mListener;
  private int mMediumAnimationDuration;
  private int mOriginalOffsetTop;
  private float mPrevY;
  private SwipeProgressBar mProgressBar;
  private int mProgressBarHeight;
  private boolean mRefreshing = false;
  private final Runnable mReturnToStartPosition = new Runnable()
  {
    public void run()
    {
      SwipeRefreshLayout.access$902(SwipeRefreshLayout.this, true);
      SwipeRefreshLayout.this.animateOffsetToStartPosition(SwipeRefreshLayout.this.mCurrentTargetOffsetTop + SwipeRefreshLayout.this.getPaddingTop(), SwipeRefreshLayout.this.mReturnToStartPositionListener);
    }
  };
  private final Animation.AnimationListener mReturnToStartPositionListener = new SwipeRefreshLayout.3(this);
  private boolean mReturningToStart;
  private final Animation.AnimationListener mShrinkAnimationListener = new SwipeRefreshLayout.4(this);
  private Animation mShrinkTrigger = new Animation()
  {
    public void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      float f = SwipeRefreshLayout.this.mFromPercentage + paramFloat * (0.0F - SwipeRefreshLayout.this.mFromPercentage);
      SwipeRefreshLayout.this.mProgressBar.setTriggerPercentage(f);
    }
  };
  private View mTarget;
  private int mTouchSlop;

  static
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = 16842766;
    LAYOUT_ATTRS = arrayOfInt;
  }

  public SwipeRefreshLayout(Context paramContext)
  {
    this(paramContext, null);
  }

  public SwipeRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.mMediumAnimationDuration = getResources().getInteger(17694721);
    setWillNotDraw(false);
    this.mProgressBar = new SwipeProgressBar(this);
    this.mProgressBarHeight = (int)(4.0F * getResources().getDisplayMetrics().density);
    this.mDecelerateInterpolator = new DecelerateInterpolator(2.0F);
    this.mAccelerateInterpolator = new AccelerateInterpolator(1.5F);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, LAYOUT_ATTRS);
    setEnabled(localTypedArray.getBoolean(0, true));
    localTypedArray.recycle();
  }

  private void animateOffsetToStartPosition(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    this.mFrom = paramInt;
    this.mAnimateToStartPosition.reset();
    this.mAnimateToStartPosition.setDuration(this.mMediumAnimationDuration);
    this.mAnimateToStartPosition.setAnimationListener(paramAnimationListener);
    this.mAnimateToStartPosition.setInterpolator(this.mDecelerateInterpolator);
    this.mTarget.startAnimation(this.mAnimateToStartPosition);
  }

  private void ensureTarget()
  {
    if (this.mTarget == null)
    {
      if ((getChildCount() > 1) && (!isInEditMode()))
        throw new IllegalStateException("SwipeRefreshLayout can host only one direct child");
      this.mTarget = getChildAt(0);
      this.mOriginalOffsetTop = (this.mTarget.getTop() + getPaddingTop());
    }
    if ((this.mDistanceToTriggerSync == -1.0F) && (getParent() != null) && (((View)getParent()).getHeight() > 0))
    {
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      this.mDistanceToTriggerSync = (int)Math.min(0.6F * ((View)getParent()).getHeight(), 120.0F * localDisplayMetrics.density);
    }
  }

  private void setTargetOffsetTopAndBottom(int paramInt)
  {
    this.mTarget.offsetTopAndBottom(paramInt);
    this.mCurrentTargetOffsetTop = this.mTarget.getTop();
  }

  private void setTriggerPercentage(float paramFloat)
  {
    if (paramFloat == 0.0F)
      this.mCurrPercentage = 0.0F;
    while (true)
    {
      return;
      this.mCurrPercentage = paramFloat;
      this.mProgressBar.setTriggerPercentage(paramFloat);
    }
  }

  private void startRefresh()
  {
    removeCallbacks(this.mCancel);
    this.mReturnToStartPosition.run();
    setRefreshing(true);
    this.mListener.onRefresh();
  }

  private void updateContentOffsetTop(int paramInt)
  {
    int i = this.mTarget.getTop();
    if (paramInt > this.mDistanceToTriggerSync)
      paramInt = (int)this.mDistanceToTriggerSync;
    while (true)
    {
      setTargetOffsetTopAndBottom(paramInt - i);
      return;
      if (paramInt >= 0)
        continue;
      paramInt = 0;
    }
  }

  private void updatePositionTimeout()
  {
    removeCallbacks(this.mCancel);
    postDelayed(this.mCancel, 300L);
  }

  public boolean canChildScrollUp()
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT < 14)
      if ((this.mTarget instanceof AbsListView))
      {
        AbsListView localAbsListView = (AbsListView)this.mTarget;
        if ((localAbsListView.getChildCount() <= 0) || ((localAbsListView.getFirstVisiblePosition() <= 0) && (localAbsListView.getChildAt(0).getTop() >= localAbsListView.getPaddingTop())));
      }
    while (true)
    {
      return bool;
      bool = false;
      continue;
      if (this.mTarget.getScrollY() > 0)
        continue;
      bool = false;
      continue;
      bool = ViewCompat.canScrollVertically(this.mTarget, -1);
    }
  }

  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    this.mProgressBar.draw(paramCanvas);
  }

  public boolean isRefreshing()
  {
    return this.mRefreshing;
  }

  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    removeCallbacks(this.mCancel);
    removeCallbacks(this.mReturnToStartPosition);
  }

  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this.mReturnToStartPosition);
    removeCallbacks(this.mCancel);
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    ensureTarget();
    boolean bool = false;
    if ((this.mReturningToStart) && (paramMotionEvent.getAction() == 0))
      this.mReturningToStart = false;
    if ((isEnabled()) && (!this.mReturningToStart) && (!canChildScrollUp()))
      bool = onTouchEvent(paramMotionEvent);
    if (!bool)
      bool = super.onInterceptTouchEvent(paramMotionEvent);
    return bool;
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getMeasuredWidth();
    int j = getMeasuredHeight();
    this.mProgressBar.setBounds(0, 0, i, this.mProgressBarHeight);
    if (getChildCount() == 0);
    while (true)
    {
      return;
      View localView = getChildAt(0);
      int k = getPaddingLeft();
      int m = this.mCurrentTargetOffsetTop + getPaddingTop();
      int n = i - getPaddingLeft() - getPaddingRight();
      int i1 = j - getPaddingTop() - getPaddingBottom();
      localView.layout(k, m, k + n, m + i1);
    }
  }

  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((getChildCount() > 1) && (!isInEditMode()))
      throw new IllegalStateException("SwipeRefreshLayout can host only one direct child");
    if (getChildCount() > 0)
      getChildAt(0).measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), 1073741824));
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    int j = 0;
    switch (i)
    {
    default:
    case 0:
    case 2:
    case 1:
    case 3:
    }
    while (true)
    {
      return j;
      this.mCurrPercentage = 0.0F;
      this.mDownEvent = MotionEvent.obtain(paramMotionEvent);
      this.mPrevY = this.mDownEvent.getY();
      continue;
      if ((this.mDownEvent == null) || (this.mReturningToStart))
        continue;
      float f1 = paramMotionEvent.getY();
      float f2 = f1 - this.mDownEvent.getY();
      if (f2 <= this.mTouchSlop)
        continue;
      if (f2 > this.mDistanceToTriggerSync)
      {
        startRefresh();
        j = 1;
        continue;
      }
      setTriggerPercentage(this.mAccelerateInterpolator.getInterpolation(f2 / this.mDistanceToTriggerSync));
      float f3 = f2;
      if (this.mPrevY > f1)
        f3 = f2 - this.mTouchSlop;
      updateContentOffsetTop((int)f3);
      if ((this.mPrevY > f1) && (this.mTarget.getTop() < this.mTouchSlop))
        removeCallbacks(this.mCancel);
      while (true)
      {
        this.mPrevY = paramMotionEvent.getY();
        j = 1;
        break;
        updatePositionTimeout();
      }
      if (this.mDownEvent == null)
        continue;
      this.mDownEvent.recycle();
      this.mDownEvent = null;
    }
  }

  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
  }

  public void setColorScheme(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ensureTarget();
    Resources localResources = getResources();
    int i = localResources.getColor(paramInt1);
    int j = localResources.getColor(paramInt2);
    int k = localResources.getColor(paramInt3);
    int m = localResources.getColor(paramInt4);
    this.mProgressBar.setColorScheme(i, j, k, m);
  }

  public void setOnRefreshListener(OnRefreshListener paramOnRefreshListener)
  {
    this.mListener = paramOnRefreshListener;
  }

  public void setRefreshing(boolean paramBoolean)
  {
    if (this.mRefreshing != paramBoolean)
    {
      ensureTarget();
      this.mCurrPercentage = 0.0F;
      this.mRefreshing = paramBoolean;
      if (!this.mRefreshing)
        break label37;
      this.mProgressBar.start();
    }
    while (true)
    {
      return;
      label37: this.mProgressBar.stop();
    }
  }

  private class BaseAnimationListener
    implements Animation.AnimationListener
  {
    private BaseAnimationListener()
    {
    }

    public void onAnimationEnd(Animation paramAnimation)
    {
    }

    public void onAnimationRepeat(Animation paramAnimation)
    {
    }

    public void onAnimationStart(Animation paramAnimation)
    {
    }
  }

  public static abstract interface OnRefreshListener
  {
    public abstract void onRefresh();
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.SwipeRefreshLayout
 * JD-Core Version:    0.6.0
 */