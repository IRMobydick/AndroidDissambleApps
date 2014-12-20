package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

public class ViewDragHelper
{
  private static final int BASE_SETTLE_DURATION = 256;
  public static final int DIRECTION_ALL = 3;
  public static final int DIRECTION_HORIZONTAL = 1;
  public static final int DIRECTION_VERTICAL = 2;
  public static final int EDGE_ALL = 15;
  public static final int EDGE_BOTTOM = 8;
  public static final int EDGE_LEFT = 1;
  public static final int EDGE_RIGHT = 2;
  private static final int EDGE_SIZE = 20;
  public static final int EDGE_TOP = 4;
  public static final int INVALID_POINTER = -1;
  private static final int MAX_SETTLE_DURATION = 600;
  public static final int STATE_DRAGGING = 1;
  public static final int STATE_IDLE = 0;
  public static final int STATE_SETTLING = 2;
  private static final String TAG = "ViewDragHelper";
  private static final Interpolator sInterpolator = new Interpolator()
  {
    public float getInterpolation(float paramFloat)
    {
      float f = paramFloat - 1.0F;
      return 1.0F + f * (f * (f * (f * f)));
    }
  };
  private int mActivePointerId = -1;
  private final Callback mCallback;
  private View mCapturedView;
  private int mDragState;
  private int[] mEdgeDragsInProgress;
  private int[] mEdgeDragsLocked;
  private int mEdgeSize;
  private int[] mInitialEdgesTouched;
  private float[] mInitialMotionX;
  private float[] mInitialMotionY;
  private float[] mLastMotionX;
  private float[] mLastMotionY;
  private float mMaxVelocity;
  private float mMinVelocity;
  private final ViewGroup mParentView;
  private int mPointersDown;
  private boolean mReleaseInProgress;
  private ScrollerCompat mScroller;
  private final Runnable mSetIdleRunnable = new Runnable()
  {
    public void run()
    {
      ViewDragHelper.this.setDragState(0);
    }
  };
  private int mTouchSlop;
  private int mTrackingEdges;
  private VelocityTracker mVelocityTracker;

  private ViewDragHelper(Context paramContext, ViewGroup paramViewGroup, Callback paramCallback)
  {
    if (paramViewGroup == null)
      throw new IllegalArgumentException("Parent view may not be null");
    if (paramCallback == null)
      throw new IllegalArgumentException("Callback may not be null");
    this.mParentView = paramViewGroup;
    this.mCallback = paramCallback;
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramContext);
    this.mEdgeSize = (int)(0.5F + 20.0F * paramContext.getResources().getDisplayMetrics().density);
    this.mTouchSlop = localViewConfiguration.getScaledTouchSlop();
    this.mMaxVelocity = localViewConfiguration.getScaledMaximumFlingVelocity();
    this.mMinVelocity = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.mScroller = ScrollerCompat.create(paramContext, sInterpolator);
  }

  private boolean checkNewEdgeDrag(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    int i = 0;
    float f1 = Math.abs(paramFloat1);
    float f2 = Math.abs(paramFloat2);
    if (((paramInt2 & this.mInitialEdgesTouched[paramInt1]) != paramInt2) || ((paramInt2 & this.mTrackingEdges) == 0) || ((paramInt2 & this.mEdgeDragsLocked[paramInt1]) == paramInt2) || ((paramInt2 & this.mEdgeDragsInProgress[paramInt1]) == paramInt2) || ((f1 <= this.mTouchSlop) && (f2 <= this.mTouchSlop)));
    while (true)
    {
      return i;
      if ((f1 < 0.5F * f2) && (this.mCallback.onEdgeLock(paramInt2)))
      {
        int[] arrayOfInt = this.mEdgeDragsLocked;
        arrayOfInt[paramInt1] = (paramInt2 | arrayOfInt[paramInt1]);
        continue;
      }
      if (((paramInt2 & this.mEdgeDragsInProgress[paramInt1]) != 0) || (f1 <= this.mTouchSlop))
        continue;
      i = 1;
    }
  }

  private boolean checkTouchSlop(View paramView, float paramFloat1, float paramFloat2)
  {
    int i = 1;
    if (paramView == null)
      i = 0;
    while (true)
    {
      return i;
      int j;
      if (this.mCallback.getViewHorizontalDragRange(paramView) > 0)
      {
        j = i;
        label28: if (this.mCallback.getViewVerticalDragRange(paramView) <= 0)
          break label86;
      }
      label86: for (int k = i; ; k = 0)
      {
        if ((j == 0) || (k == 0))
          break label92;
        if (paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 > this.mTouchSlop * this.mTouchSlop)
          break;
        i = 0;
        break;
        j = 0;
        break label28;
      }
      label92: if (j != 0)
      {
        if (Math.abs(paramFloat1) > this.mTouchSlop)
          continue;
        i = 0;
        continue;
      }
      if (k != 0)
      {
        if (Math.abs(paramFloat2) > this.mTouchSlop)
          continue;
        i = 0;
        continue;
      }
      i = 0;
    }
  }

  private float clampMag(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f = Math.abs(paramFloat1);
    if (f < paramFloat2)
      paramFloat3 = 0.0F;
    while (true)
    {
      return paramFloat3;
      if (f > paramFloat3)
      {
        if (paramFloat1 > 0.0F)
          continue;
        paramFloat3 = -paramFloat3;
        continue;
      }
      paramFloat3 = paramFloat1;
    }
  }

  private int clampMag(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = Math.abs(paramInt1);
    if (i < paramInt2)
      paramInt3 = 0;
    while (true)
    {
      return paramInt3;
      if (i > paramInt3)
      {
        if (paramInt1 > 0)
          continue;
        paramInt3 = -paramInt3;
        continue;
      }
      paramInt3 = paramInt1;
    }
  }

  private void clearMotionHistory()
  {
    if (this.mInitialMotionX == null);
    while (true)
    {
      return;
      Arrays.fill(this.mInitialMotionX, 0.0F);
      Arrays.fill(this.mInitialMotionY, 0.0F);
      Arrays.fill(this.mLastMotionX, 0.0F);
      Arrays.fill(this.mLastMotionY, 0.0F);
      Arrays.fill(this.mInitialEdgesTouched, 0);
      Arrays.fill(this.mEdgeDragsInProgress, 0);
      Arrays.fill(this.mEdgeDragsLocked, 0);
      this.mPointersDown = 0;
    }
  }

  private void clearMotionHistory(int paramInt)
  {
    if (this.mInitialMotionX == null);
    while (true)
    {
      return;
      this.mInitialMotionX[paramInt] = 0.0F;
      this.mInitialMotionY[paramInt] = 0.0F;
      this.mLastMotionX[paramInt] = 0.0F;
      this.mLastMotionY[paramInt] = 0.0F;
      this.mInitialEdgesTouched[paramInt] = 0;
      this.mEdgeDragsInProgress[paramInt] = 0;
      this.mEdgeDragsLocked[paramInt] = 0;
      this.mPointersDown &= (0xFFFFFFFF ^ 1 << paramInt);
    }
  }

  private int computeAxisDuration(int paramInt1, int paramInt2, int paramInt3)
  {
    int n;
    if (paramInt1 == 0)
    {
      n = 0;
      return n;
    }
    int i = this.mParentView.getWidth();
    int j = i / 2;
    float f1 = Math.min(1.0F, Math.abs(paramInt1) / i);
    float f2 = j + j * distanceInfluenceForSnapDuration(f1);
    int k = Math.abs(paramInt2);
    if (k > 0);
    for (int m = 4 * Math.round(1000.0F * Math.abs(f2 / k)); ; m = (int)(256.0F * (1.0F + Math.abs(paramInt1) / paramInt3)))
    {
      n = Math.min(m, 600);
      break;
    }
  }

  private int computeSettleDuration(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = clampMag(paramInt3, (int)this.mMinVelocity, (int)this.mMaxVelocity);
    int j = clampMag(paramInt4, (int)this.mMinVelocity, (int)this.mMaxVelocity);
    int k = Math.abs(paramInt1);
    int m = Math.abs(paramInt2);
    int n = Math.abs(i);
    int i1 = Math.abs(j);
    int i2 = n + i1;
    int i3 = k + m;
    float f1;
    float f2;
    if (i != 0)
    {
      f1 = n / i2;
      if (j == 0)
        break label165;
      f2 = i1 / i2;
    }
    while (true)
    {
      int i4 = computeAxisDuration(paramInt1, i, this.mCallback.getViewHorizontalDragRange(paramView));
      int i5 = computeAxisDuration(paramInt2, j, this.mCallback.getViewVerticalDragRange(paramView));
      return (int)(f1 * i4 + f2 * i5);
      f1 = k / i3;
      break;
      label165: f2 = m / i3;
    }
  }

  public static ViewDragHelper create(ViewGroup paramViewGroup, float paramFloat, Callback paramCallback)
  {
    ViewDragHelper localViewDragHelper = create(paramViewGroup, paramCallback);
    localViewDragHelper.mTouchSlop = (int)(localViewDragHelper.mTouchSlop * (1.0F / paramFloat));
    return localViewDragHelper;
  }

  public static ViewDragHelper create(ViewGroup paramViewGroup, Callback paramCallback)
  {
    return new ViewDragHelper(paramViewGroup.getContext(), paramViewGroup, paramCallback);
  }

  private void dispatchViewReleased(float paramFloat1, float paramFloat2)
  {
    this.mReleaseInProgress = true;
    this.mCallback.onViewReleased(this.mCapturedView, paramFloat1, paramFloat2);
    this.mReleaseInProgress = false;
    if (this.mDragState == 1)
      setDragState(0);
  }

  private float distanceInfluenceForSnapDuration(float paramFloat)
  {
    return (float)Math.sin((float)(0.47123891676382D * (paramFloat - 0.5F)));
  }

  private void dragTo(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt1;
    int j = paramInt2;
    int k = this.mCapturedView.getLeft();
    int m = this.mCapturedView.getTop();
    if (paramInt3 != 0)
    {
      i = this.mCallback.clampViewPositionHorizontal(this.mCapturedView, paramInt1, paramInt3);
      this.mCapturedView.offsetLeftAndRight(i - k);
    }
    if (paramInt4 != 0)
    {
      j = this.mCallback.clampViewPositionVertical(this.mCapturedView, paramInt2, paramInt4);
      this.mCapturedView.offsetTopAndBottom(j - m);
    }
    if ((paramInt3 != 0) || (paramInt4 != 0))
    {
      int n = i - k;
      int i1 = j - m;
      this.mCallback.onViewPositionChanged(this.mCapturedView, i, j, n, i1);
    }
  }

  private void ensureMotionHistorySizeForId(int paramInt)
  {
    if ((this.mInitialMotionX == null) || (this.mInitialMotionX.length <= paramInt))
    {
      float[] arrayOfFloat1 = new float[paramInt + 1];
      float[] arrayOfFloat2 = new float[paramInt + 1];
      float[] arrayOfFloat3 = new float[paramInt + 1];
      float[] arrayOfFloat4 = new float[paramInt + 1];
      int[] arrayOfInt1 = new int[paramInt + 1];
      int[] arrayOfInt2 = new int[paramInt + 1];
      int[] arrayOfInt3 = new int[paramInt + 1];
      if (this.mInitialMotionX != null)
      {
        System.arraycopy(this.mInitialMotionX, 0, arrayOfFloat1, 0, this.mInitialMotionX.length);
        System.arraycopy(this.mInitialMotionY, 0, arrayOfFloat2, 0, this.mInitialMotionY.length);
        System.arraycopy(this.mLastMotionX, 0, arrayOfFloat3, 0, this.mLastMotionX.length);
        System.arraycopy(this.mLastMotionY, 0, arrayOfFloat4, 0, this.mLastMotionY.length);
        System.arraycopy(this.mInitialEdgesTouched, 0, arrayOfInt1, 0, this.mInitialEdgesTouched.length);
        System.arraycopy(this.mEdgeDragsInProgress, 0, arrayOfInt2, 0, this.mEdgeDragsInProgress.length);
        System.arraycopy(this.mEdgeDragsLocked, 0, arrayOfInt3, 0, this.mEdgeDragsLocked.length);
      }
      this.mInitialMotionX = arrayOfFloat1;
      this.mInitialMotionY = arrayOfFloat2;
      this.mLastMotionX = arrayOfFloat3;
      this.mLastMotionY = arrayOfFloat4;
      this.mInitialEdgesTouched = arrayOfInt1;
      this.mEdgeDragsInProgress = arrayOfInt2;
      this.mEdgeDragsLocked = arrayOfInt3;
    }
  }

  private boolean forceSettleCapturedViewAt(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 0;
    int j = this.mCapturedView.getLeft();
    int k = this.mCapturedView.getTop();
    int m = paramInt1 - j;
    int n = paramInt2 - k;
    if ((m == 0) && (n == 0))
    {
      this.mScroller.abortAnimation();
      setDragState(0);
    }
    while (true)
    {
      return i;
      int i1 = computeSettleDuration(this.mCapturedView, m, n, paramInt3, paramInt4);
      this.mScroller.startScroll(j, k, m, n, i1);
      setDragState(2);
      i = 1;
    }
  }

  private int getEdgesTouched(int paramInt1, int paramInt2)
  {
    int i = 0;
    if (paramInt1 < this.mParentView.getLeft() + this.mEdgeSize)
      i = 0x0 | 0x1;
    if (paramInt2 < this.mParentView.getTop() + this.mEdgeSize)
      i |= 4;
    if (paramInt1 > this.mParentView.getRight() - this.mEdgeSize)
      i |= 2;
    if (paramInt2 > this.mParentView.getBottom() - this.mEdgeSize)
      i |= 8;
    return i;
  }

  private void releaseViewForPointerUp()
  {
    this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxVelocity);
    dispatchViewReleased(clampMag(VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity), clampMag(VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity));
  }

  private void reportNewEdgeDrags(float paramFloat1, float paramFloat2, int paramInt)
  {
    int i = 0;
    if (checkNewEdgeDrag(paramFloat1, paramFloat2, paramInt, 1))
      i = 0x0 | 0x1;
    if (checkNewEdgeDrag(paramFloat2, paramFloat1, paramInt, 4))
      i |= 4;
    if (checkNewEdgeDrag(paramFloat1, paramFloat2, paramInt, 2))
      i |= 2;
    if (checkNewEdgeDrag(paramFloat2, paramFloat1, paramInt, 8))
      i |= 8;
    if (i != 0)
    {
      int[] arrayOfInt = this.mEdgeDragsInProgress;
      arrayOfInt[paramInt] = (i | arrayOfInt[paramInt]);
      this.mCallback.onEdgeDragStarted(i, paramInt);
    }
  }

  private void saveInitialMotion(float paramFloat1, float paramFloat2, int paramInt)
  {
    ensureMotionHistorySizeForId(paramInt);
    float[] arrayOfFloat1 = this.mInitialMotionX;
    this.mLastMotionX[paramInt] = paramFloat1;
    arrayOfFloat1[paramInt] = paramFloat1;
    float[] arrayOfFloat2 = this.mInitialMotionY;
    this.mLastMotionY[paramInt] = paramFloat2;
    arrayOfFloat2[paramInt] = paramFloat2;
    this.mInitialEdgesTouched[paramInt] = getEdgesTouched((int)paramFloat1, (int)paramFloat2);
    this.mPointersDown |= 1 << paramInt;
  }

  private void saveLastMotion(MotionEvent paramMotionEvent)
  {
    int i = MotionEventCompat.getPointerCount(paramMotionEvent);
    for (int j = 0; j < i; j++)
    {
      int k = MotionEventCompat.getPointerId(paramMotionEvent, j);
      float f1 = MotionEventCompat.getX(paramMotionEvent, j);
      float f2 = MotionEventCompat.getY(paramMotionEvent, j);
      this.mLastMotionX[k] = f1;
      this.mLastMotionY[k] = f2;
    }
  }

  public void abort()
  {
    cancel();
    if (this.mDragState == 2)
    {
      int i = this.mScroller.getCurrX();
      int j = this.mScroller.getCurrY();
      this.mScroller.abortAnimation();
      int k = this.mScroller.getCurrX();
      int m = this.mScroller.getCurrY();
      this.mCallback.onViewPositionChanged(this.mCapturedView, k, m, k - i, m - j);
    }
    setDragState(0);
  }

  protected boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int m;
    int i;
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int j = paramView.getScrollX();
      int k = paramView.getScrollY();
      m = -1 + localViewGroup.getChildCount();
      if (m >= 0)
      {
        View localView = localViewGroup.getChildAt(m);
        if ((paramInt3 + j >= localView.getLeft()) && (paramInt3 + j < localView.getRight()) && (paramInt4 + k >= localView.getTop()) && (paramInt4 + k < localView.getBottom()) && (canScroll(localView, true, paramInt1, paramInt2, paramInt3 + j - localView.getLeft(), paramInt4 + k - localView.getTop())))
          i = 1;
      }
    }
    while (true)
    {
      return i;
      m--;
      break;
      if ((paramBoolean) && ((ViewCompat.canScrollHorizontally(paramView, -paramInt1)) || (ViewCompat.canScrollVertically(paramView, -paramInt2))))
      {
        i = 1;
        continue;
      }
      i = 0;
    }
  }

  public void cancel()
  {
    this.mActivePointerId = -1;
    clearMotionHistory();
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }

  public void captureChildView(View paramView, int paramInt)
  {
    if (paramView.getParent() != this.mParentView)
      throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.mParentView + ")");
    this.mCapturedView = paramView;
    this.mActivePointerId = paramInt;
    this.mCallback.onViewCaptured(paramView, paramInt);
    setDragState(1);
  }

  public boolean checkTouchSlop(int paramInt)
  {
    int i = this.mInitialMotionX.length;
    int j = 0;
    if (j < i)
      if (!checkTouchSlop(paramInt, j));
    for (int k = 1; ; k = 0)
    {
      return k;
      j++;
      break;
    }
  }

  public boolean checkTouchSlop(int paramInt1, int paramInt2)
  {
    int i = 1;
    if (!isPointerDown(paramInt2))
      i = 0;
    while (true)
    {
      return i;
      int j;
      if ((paramInt1 & 0x1) == i)
      {
        j = i;
        label24: if ((paramInt1 & 0x2) != 2)
          break label110;
      }
      float f1;
      float f2;
      label110: for (int k = i; ; k = 0)
      {
        f1 = this.mLastMotionX[paramInt2] - this.mInitialMotionX[paramInt2];
        f2 = this.mLastMotionY[paramInt2] - this.mInitialMotionY[paramInt2];
        if ((j == 0) || (k == 0))
          break label116;
        if (f1 * f1 + f2 * f2 > this.mTouchSlop * this.mTouchSlop)
          break;
        i = 0;
        break;
        j = 0;
        break label24;
      }
      label116: if (j != 0)
      {
        if (Math.abs(f1) > this.mTouchSlop)
          continue;
        i = 0;
        continue;
      }
      if (k != 0)
      {
        if (Math.abs(f2) > this.mTouchSlop)
          continue;
        i = 0;
        continue;
      }
      i = 0;
    }
  }

  public boolean continueSettling(boolean paramBoolean)
  {
    if (this.mDragState == 2)
    {
      boolean bool = this.mScroller.computeScrollOffset();
      int j = this.mScroller.getCurrX();
      int k = this.mScroller.getCurrY();
      int m = j - this.mCapturedView.getLeft();
      int n = k - this.mCapturedView.getTop();
      if (m != 0)
        this.mCapturedView.offsetLeftAndRight(m);
      if (n != 0)
        this.mCapturedView.offsetTopAndBottom(n);
      if ((m != 0) || (n != 0))
        this.mCallback.onViewPositionChanged(this.mCapturedView, j, k, m, n);
      if ((bool) && (j == this.mScroller.getFinalX()) && (k == this.mScroller.getFinalY()))
      {
        this.mScroller.abortAnimation();
        bool = this.mScroller.isFinished();
      }
      if (!bool)
      {
        if (!paramBoolean)
          break label190;
        this.mParentView.post(this.mSetIdleRunnable);
      }
    }
    if (this.mDragState == 2);
    for (int i = 1; ; i = 0)
    {
      return i;
      label190: setDragState(0);
      break;
    }
  }

  public View findTopChildUnder(int paramInt1, int paramInt2)
  {
    int i = -1 + this.mParentView.getChildCount();
    View localView;
    if (i >= 0)
    {
      localView = this.mParentView.getChildAt(this.mCallback.getOrderedChildIndex(i));
      if ((paramInt1 < localView.getLeft()) || (paramInt1 >= localView.getRight()) || (paramInt2 < localView.getTop()) || (paramInt2 >= localView.getBottom()));
    }
    while (true)
    {
      return localView;
      i--;
      break;
      localView = null;
    }
  }

  public void flingCapturedView(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.mReleaseInProgress)
      throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
    this.mScroller.fling(this.mCapturedView.getLeft(), this.mCapturedView.getTop(), (int)VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), (int)VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId), paramInt1, paramInt3, paramInt2, paramInt4);
    setDragState(2);
  }

  public int getActivePointerId()
  {
    return this.mActivePointerId;
  }

  public View getCapturedView()
  {
    return this.mCapturedView;
  }

  public int getEdgeSize()
  {
    return this.mEdgeSize;
  }

  public float getMinVelocity()
  {
    return this.mMinVelocity;
  }

  public int getTouchSlop()
  {
    return this.mTouchSlop;
  }

  public int getViewDragState()
  {
    return this.mDragState;
  }

  public boolean isCapturedViewUnder(int paramInt1, int paramInt2)
  {
    return isViewUnder(this.mCapturedView, paramInt1, paramInt2);
  }

  public boolean isEdgeTouched(int paramInt)
  {
    int i = this.mInitialEdgesTouched.length;
    int j = 0;
    if (j < i)
      if (!isEdgeTouched(paramInt, j));
    for (int k = 1; ; k = 0)
    {
      return k;
      j++;
      break;
    }
  }

  public boolean isEdgeTouched(int paramInt1, int paramInt2)
  {
    if ((isPointerDown(paramInt2)) && ((paramInt1 & this.mInitialEdgesTouched[paramInt2]) != 0));
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean isPointerDown(int paramInt)
  {
    int i = 1;
    if ((this.mPointersDown & i << paramInt) != 0);
    while (true)
    {
      return i;
      i = 0;
    }
  }

  public boolean isViewUnder(View paramView, int paramInt1, int paramInt2)
  {
    int i = 0;
    if (paramView == null);
    while (true)
    {
      return i;
      if ((paramInt1 < paramView.getLeft()) || (paramInt1 >= paramView.getRight()) || (paramInt2 < paramView.getTop()) || (paramInt2 >= paramView.getBottom()))
        continue;
      i = 1;
    }
  }

  public void processTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    int j = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (i == 0)
      cancel();
    if (this.mVelocityTracker == null)
      this.mVelocityTracker = VelocityTracker.obtain();
    this.mVelocityTracker.addMovement(paramMotionEvent);
    switch (i)
    {
    case 4:
    default:
    case 0:
    case 5:
    case 2:
    case 6:
    case 1:
    case 3:
    }
    while (true)
    {
      return;
      float f11 = paramMotionEvent.getX();
      float f12 = paramMotionEvent.getY();
      int i11 = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      View localView2 = findTopChildUnder((int)f11, (int)f12);
      saveInitialMotion(f11, f12, i11);
      tryCaptureViewForDrag(localView2, i11);
      int i12 = this.mInitialEdgesTouched[i11];
      if ((i12 & this.mTrackingEdges) == 0)
        continue;
      this.mCallback.onEdgeTouched(i12 & this.mTrackingEdges, i11);
      continue;
      int i9 = MotionEventCompat.getPointerId(paramMotionEvent, j);
      float f9 = MotionEventCompat.getX(paramMotionEvent, j);
      float f10 = MotionEventCompat.getY(paramMotionEvent, j);
      saveInitialMotion(f9, f10, i9);
      if (this.mDragState == 0)
      {
        tryCaptureViewForDrag(findTopChildUnder((int)f9, (int)f10), i9);
        int i10 = this.mInitialEdgesTouched[i9];
        if ((i10 & this.mTrackingEdges) == 0)
          continue;
        this.mCallback.onEdgeTouched(i10 & this.mTrackingEdges, i9);
        continue;
      }
      if (!isCapturedViewUnder((int)f9, (int)f10))
        continue;
      tryCaptureViewForDrag(this.mCapturedView, i9);
      continue;
      if (this.mDragState == 1)
      {
        int i6 = MotionEventCompat.findPointerIndex(paramMotionEvent, this.mActivePointerId);
        float f7 = MotionEventCompat.getX(paramMotionEvent, i6);
        float f8 = MotionEventCompat.getY(paramMotionEvent, i6);
        int i7 = (int)(f7 - this.mLastMotionX[this.mActivePointerId]);
        int i8 = (int)(f8 - this.mLastMotionY[this.mActivePointerId]);
        dragTo(i7 + this.mCapturedView.getLeft(), i8 + this.mCapturedView.getTop(), i7, i8);
        saveLastMotion(paramMotionEvent);
        continue;
      }
      int i3 = MotionEventCompat.getPointerCount(paramMotionEvent);
      for (int i4 = 0; ; i4++)
      {
        int i5;
        float f3;
        float f4;
        float f5;
        float f6;
        if (i4 < i3)
        {
          i5 = MotionEventCompat.getPointerId(paramMotionEvent, i4);
          f3 = MotionEventCompat.getX(paramMotionEvent, i4);
          f4 = MotionEventCompat.getY(paramMotionEvent, i4);
          f5 = f3 - this.mInitialMotionX[i5];
          f6 = f4 - this.mInitialMotionY[i5];
          reportNewEdgeDrags(f5, f6, i5);
          if (this.mDragState != 1)
            break label483;
        }
        label483: View localView1;
        do
        {
          saveLastMotion(paramMotionEvent);
          break;
          localView1 = findTopChildUnder((int)f3, (int)f4);
        }
        while ((checkTouchSlop(localView1, f5, f6)) && (tryCaptureViewForDrag(localView1, i5)));
      }
      int k = MotionEventCompat.getPointerId(paramMotionEvent, j);
      if ((this.mDragState == 1) && (k == this.mActivePointerId))
      {
        int m = -1;
        int n = MotionEventCompat.getPointerCount(paramMotionEvent);
        int i1 = 0;
        if (i1 < n)
        {
          int i2 = MotionEventCompat.getPointerId(paramMotionEvent, i1);
          if (i2 == this.mActivePointerId);
          float f1;
          float f2;
          do
          {
            i1++;
            break;
            f1 = MotionEventCompat.getX(paramMotionEvent, i1);
            f2 = MotionEventCompat.getY(paramMotionEvent, i1);
          }
          while ((findTopChildUnder((int)f1, (int)f2) != this.mCapturedView) || (!tryCaptureViewForDrag(this.mCapturedView, i2)));
          m = this.mActivePointerId;
        }
        if (m == -1)
          releaseViewForPointerUp();
      }
      clearMotionHistory(k);
      continue;
      if (this.mDragState == 1)
        releaseViewForPointerUp();
      cancel();
      continue;
      if (this.mDragState == 1)
        dispatchViewReleased(0.0F, 0.0F);
      cancel();
    }
  }

  void setDragState(int paramInt)
  {
    if (this.mDragState != paramInt)
    {
      this.mDragState = paramInt;
      this.mCallback.onViewDragStateChanged(paramInt);
      if (paramInt == 0)
        this.mCapturedView = null;
    }
  }

  public void setEdgeTrackingEnabled(int paramInt)
  {
    this.mTrackingEdges = paramInt;
  }

  public void setMinVelocity(float paramFloat)
  {
    this.mMinVelocity = paramFloat;
  }

  public boolean settleCapturedViewAt(int paramInt1, int paramInt2)
  {
    if (!this.mReleaseInProgress)
      throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    return forceSettleCapturedViewAt(paramInt1, paramInt2, (int)VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), (int)VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId));
  }

  public boolean shouldInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    int j = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (i == 0)
      cancel();
    if (this.mVelocityTracker == null)
      this.mVelocityTracker = VelocityTracker.obtain();
    this.mVelocityTracker.addMovement(paramMotionEvent);
    switch (i)
    {
    case 4:
    default:
      if (this.mDragState != 1)
        break;
    case 0:
    case 5:
    case 2:
    case 6:
    case 1:
    case 3:
    }
    for (int k = 1; ; k = 0)
    {
      return k;
      float f7 = paramMotionEvent.getX();
      float f8 = paramMotionEvent.getY();
      int i4 = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      saveInitialMotion(f7, f8, i4);
      View localView3 = findTopChildUnder((int)f7, (int)f8);
      if ((localView3 == this.mCapturedView) && (this.mDragState == 2))
        tryCaptureViewForDrag(localView3, i4);
      int i5 = this.mInitialEdgesTouched[i4];
      if ((i5 & this.mTrackingEdges) == 0)
        break;
      this.mCallback.onEdgeTouched(i5 & this.mTrackingEdges, i4);
      break;
      int i2 = MotionEventCompat.getPointerId(paramMotionEvent, j);
      float f5 = MotionEventCompat.getX(paramMotionEvent, j);
      float f6 = MotionEventCompat.getY(paramMotionEvent, j);
      saveInitialMotion(f5, f6, i2);
      if (this.mDragState == 0)
      {
        int i3 = this.mInitialEdgesTouched[i2];
        if ((i3 & this.mTrackingEdges) == 0)
          break;
        this.mCallback.onEdgeTouched(i3 & this.mTrackingEdges, i2);
        break;
      }
      if (this.mDragState != 2)
        break;
      View localView2 = findTopChildUnder((int)f5, (int)f6);
      if (localView2 != this.mCapturedView)
        break;
      tryCaptureViewForDrag(localView2, i2);
      break;
      int m = MotionEventCompat.getPointerCount(paramMotionEvent);
      for (int n = 0; ; n++)
      {
        int i1;
        float f1;
        float f2;
        float f3;
        float f4;
        if (n < m)
        {
          i1 = MotionEventCompat.getPointerId(paramMotionEvent, n);
          f1 = MotionEventCompat.getX(paramMotionEvent, n);
          f2 = MotionEventCompat.getY(paramMotionEvent, n);
          f3 = f1 - this.mInitialMotionX[i1];
          f4 = f2 - this.mInitialMotionY[i1];
          reportNewEdgeDrags(f3, f4, i1);
          if (this.mDragState != 1)
            break label410;
        }
        label410: View localView1;
        do
        {
          saveLastMotion(paramMotionEvent);
          break;
          localView1 = findTopChildUnder((int)f1, (int)f2);
        }
        while ((localView1 != null) && (checkTouchSlop(localView1, f3, f4)) && (tryCaptureViewForDrag(localView1, i1)));
      }
      clearMotionHistory(MotionEventCompat.getPointerId(paramMotionEvent, j));
      break;
      cancel();
      break;
    }
  }

  public boolean smoothSlideViewTo(View paramView, int paramInt1, int paramInt2)
  {
    this.mCapturedView = paramView;
    this.mActivePointerId = -1;
    return forceSettleCapturedViewAt(paramInt1, paramInt2, 0, 0);
  }

  boolean tryCaptureViewForDrag(View paramView, int paramInt)
  {
    int i = 1;
    if ((paramView == this.mCapturedView) && (this.mActivePointerId == paramInt));
    while (true)
    {
      return i;
      if ((paramView != null) && (this.mCallback.tryCaptureView(paramView, paramInt)))
      {
        this.mActivePointerId = paramInt;
        captureChildView(paramView, paramInt);
        continue;
      }
      i = 0;
    }
  }

  public static abstract class Callback
  {
    public int clampViewPositionHorizontal(View paramView, int paramInt1, int paramInt2)
    {
      return 0;
    }

    public int clampViewPositionVertical(View paramView, int paramInt1, int paramInt2)
    {
      return 0;
    }

    public int getOrderedChildIndex(int paramInt)
    {
      return paramInt;
    }

    public int getViewHorizontalDragRange(View paramView)
    {
      return 0;
    }

    public int getViewVerticalDragRange(View paramView)
    {
      return 0;
    }

    public void onEdgeDragStarted(int paramInt1, int paramInt2)
    {
    }

    public boolean onEdgeLock(int paramInt)
    {
      return false;
    }

    public void onEdgeTouched(int paramInt1, int paramInt2)
    {
    }

    public void onViewCaptured(View paramView, int paramInt)
    {
    }

    public void onViewDragStateChanged(int paramInt)
    {
    }

    public void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
    }

    public void onViewReleased(View paramView, float paramFloat1, float paramFloat2)
    {
    }

    public abstract boolean tryCaptureView(View paramView, int paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.ViewDragHelper
 * JD-Core Version:    0.6.0
 */