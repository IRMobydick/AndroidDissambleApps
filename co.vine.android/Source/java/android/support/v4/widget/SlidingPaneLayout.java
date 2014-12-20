package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.ArrayList;

public class SlidingPaneLayout extends ViewGroup
{
  private static final int DEFAULT_FADE_COLOR = -858993460;
  private static final int DEFAULT_OVERHANG_SIZE = 32;
  static final SlidingPanelLayoutImpl IMPL;
  private static final int MIN_FLING_VELOCITY = 400;
  private static final String TAG = "SlidingPaneLayout";
  private boolean mCanSlide;
  private int mCoveredFadeColor;
  private final ViewDragHelper mDragHelper;
  private boolean mFirstLayout = true;
  private float mInitialMotionX;
  private float mInitialMotionY;
  private boolean mIsUnableToDrag;
  private final int mOverhangSize;
  private PanelSlideListener mPanelSlideListener;
  private int mParallaxBy;
  private float mParallaxOffset;
  private final ArrayList<DisableLayerRunnable> mPostedRunnables = new ArrayList();
  private boolean mPreservedOpenState;
  private Drawable mShadowDrawable;
  private float mSlideOffset;
  private int mSlideRange;
  private View mSlideableView;
  private int mSliderFadeColor = -858993460;
  private final Rect mTmpRect = new Rect();

  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 17)
      IMPL = new SlidingPaneLayout.SlidingPanelLayoutImplJBMR1();
    while (true)
    {
      return;
      if (i >= 16)
      {
        IMPL = new SlidingPaneLayout.SlidingPanelLayoutImplJB();
        continue;
      }
      IMPL = new SlidingPaneLayout.SlidingPanelLayoutImplBase();
    }
  }

  public SlidingPaneLayout(Context paramContext)
  {
    this(paramContext, null);
  }

  public SlidingPaneLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public SlidingPaneLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.mOverhangSize = (int)(0.5F + 32.0F * f);
    ViewConfiguration.get(paramContext);
    setWillNotDraw(false);
    ViewCompat.setAccessibilityDelegate(this, new SlidingPaneLayout.AccessibilityDelegate(this));
    ViewCompat.setImportantForAccessibility(this, 1);
    this.mDragHelper = ViewDragHelper.create(this, 0.5F, new SlidingPaneLayout.DragHelperCallback(this, null));
    this.mDragHelper.setEdgeTrackingEnabled(1);
    this.mDragHelper.setMinVelocity(400.0F * f);
  }

  private boolean closePane(View paramView, int paramInt)
  {
    int i = 0;
    if ((this.mFirstLayout) || (smoothSlideTo(0.0F, paramInt)))
    {
      this.mPreservedOpenState = false;
      i = 1;
    }
    return i;
  }

  private void dimChildView(View paramView, float paramFloat, int paramInt)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if ((paramFloat > 0.0F) && (paramInt != 0))
    {
      int i = (int)(paramFloat * ((0xFF000000 & paramInt) >>> 24)) << 24 | 0xFFFFFF & paramInt;
      if (localLayoutParams.dimPaint == null)
        localLayoutParams.dimPaint = new Paint();
      localLayoutParams.dimPaint.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_OVER));
      if (ViewCompat.getLayerType(paramView) != 2)
        ViewCompat.setLayerType(paramView, 2, localLayoutParams.dimPaint);
      invalidateChildRegion(paramView);
    }
    while (true)
    {
      return;
      if (ViewCompat.getLayerType(paramView) != 0)
      {
        if (localLayoutParams.dimPaint != null)
          localLayoutParams.dimPaint.setColorFilter(null);
        DisableLayerRunnable localDisableLayerRunnable = new DisableLayerRunnable(paramView);
        this.mPostedRunnables.add(localDisableLayerRunnable);
        ViewCompat.postOnAnimation(this, localDisableLayerRunnable);
        continue;
      }
    }
  }

  private void invalidateChildRegion(View paramView)
  {
    IMPL.invalidateChildRegion(this, paramView);
  }

  private void onPanelDragged(int paramInt)
  {
    if (this.mSlideableView == null)
      this.mSlideOffset = 0.0F;
    while (true)
    {
      return;
      LayoutParams localLayoutParams = (LayoutParams)this.mSlideableView.getLayoutParams();
      this.mSlideOffset = ((paramInt - (getPaddingLeft() + localLayoutParams.leftMargin)) / this.mSlideRange);
      if (this.mParallaxBy != 0)
        parallaxOtherViews(this.mSlideOffset);
      if (localLayoutParams.dimWhenOffset)
        dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
      dispatchOnPanelSlide(this.mSlideableView);
    }
  }

  private boolean openPane(View paramView, int paramInt)
  {
    boolean bool = true;
    if ((this.mFirstLayout) || (smoothSlideTo(1.0F, paramInt)))
      this.mPreservedOpenState = bool;
    while (true)
    {
      return bool;
      bool = false;
    }
  }

  private void parallaxOtherViews(float paramFloat)
  {
    LayoutParams localLayoutParams = (LayoutParams)this.mSlideableView.getLayoutParams();
    int i;
    int k;
    label36: View localView;
    if ((localLayoutParams.dimWhenOffset) && (localLayoutParams.leftMargin <= 0))
    {
      i = 1;
      int j = getChildCount();
      k = 0;
      if (k >= j)
        return;
      localView = getChildAt(k);
      if (localView != this.mSlideableView)
        break label71;
    }
    while (true)
    {
      k++;
      break label36;
      i = 0;
      break;
      label71: int m = (int)((1.0F - this.mParallaxOffset) * this.mParallaxBy);
      this.mParallaxOffset = paramFloat;
      localView.offsetLeftAndRight(m - (int)((1.0F - paramFloat) * this.mParallaxBy));
      if (i == 0)
        continue;
      dimChildView(localView, 1.0F - this.mParallaxOffset, this.mCoveredFadeColor);
    }
  }

  private static boolean viewIsOpaque(View paramView)
  {
    int i = 1;
    if (ViewCompat.isOpaque(paramView));
    while (true)
    {
      return i;
      if (Build.VERSION.SDK_INT >= 18)
      {
        i = 0;
        continue;
      }
      Drawable localDrawable = paramView.getBackground();
      if (localDrawable != null)
      {
        if (localDrawable.getOpacity() == -1)
          continue;
        i = 0;
        continue;
      }
      i = 0;
    }
  }

  protected boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
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
        if ((paramInt2 + j >= localView.getLeft()) && (paramInt2 + j < localView.getRight()) && (paramInt3 + k >= localView.getTop()) && (paramInt3 + k < localView.getBottom()) && (canScroll(localView, true, paramInt1, paramInt2 + j - localView.getLeft(), paramInt3 + k - localView.getTop())))
          i = 1;
      }
    }
    while (true)
    {
      return i;
      m--;
      break;
      if ((paramBoolean) && (ViewCompat.canScrollHorizontally(paramView, -paramInt1)))
      {
        i = 1;
        continue;
      }
      i = 0;
    }
  }

  @Deprecated
  public boolean canSlide()
  {
    return this.mCanSlide;
  }

  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams)));
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean closePane()
  {
    return closePane(this.mSlideableView, 0);
  }

  public void computeScroll()
  {
    if (this.mDragHelper.continueSettling(true))
    {
      if (this.mCanSlide)
        break label26;
      this.mDragHelper.abort();
    }
    while (true)
    {
      return;
      label26: ViewCompat.postInvalidateOnAnimation(this);
    }
  }

  void dispatchOnPanelClosed(View paramView)
  {
    if (this.mPanelSlideListener != null)
      this.mPanelSlideListener.onPanelClosed(paramView);
    sendAccessibilityEvent(32);
  }

  void dispatchOnPanelOpened(View paramView)
  {
    if (this.mPanelSlideListener != null)
      this.mPanelSlideListener.onPanelOpened(paramView);
    sendAccessibilityEvent(32);
  }

  void dispatchOnPanelSlide(View paramView)
  {
    if (this.mPanelSlideListener != null)
      this.mPanelSlideListener.onPanelSlide(paramView, this.mSlideOffset);
  }

  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    View localView;
    if (getChildCount() > 1)
    {
      localView = getChildAt(1);
      if ((localView != null) && (this.mShadowDrawable != null))
        break label36;
    }
    while (true)
    {
      return;
      localView = null;
      break;
      label36: int i = this.mShadowDrawable.getIntrinsicWidth();
      int j = localView.getLeft();
      int k = localView.getTop();
      int m = localView.getBottom();
      int n = j - i;
      this.mShadowDrawable.setBounds(n, k, j, m);
      this.mShadowDrawable.draw(paramCanvas);
    }
  }

  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = paramCanvas.save(2);
    if ((this.mCanSlide) && (!localLayoutParams.slideable) && (this.mSlideableView != null))
    {
      paramCanvas.getClipBounds(this.mTmpRect);
      this.mTmpRect.right = Math.min(this.mTmpRect.right, this.mSlideableView.getLeft());
      paramCanvas.clipRect(this.mTmpRect);
    }
    boolean bool;
    if (Build.VERSION.SDK_INT >= 11)
      bool = super.drawChild(paramCanvas, paramView, paramLong);
    while (true)
    {
      paramCanvas.restoreToCount(i);
      return bool;
      if ((localLayoutParams.dimWhenOffset) && (this.mSlideOffset > 0.0F))
      {
        if (!paramView.isDrawingCacheEnabled())
          paramView.setDrawingCacheEnabled(true);
        Bitmap localBitmap = paramView.getDrawingCache();
        if (localBitmap != null)
        {
          paramCanvas.drawBitmap(localBitmap, paramView.getLeft(), paramView.getTop(), localLayoutParams.dimPaint);
          bool = false;
          continue;
        }
        Log.e("SlidingPaneLayout", "drawChild: child view " + paramView + " returned null drawing cache");
        bool = super.drawChild(paramCanvas, paramView, paramLong);
        continue;
      }
      if (paramView.isDrawingCacheEnabled())
        paramView.setDrawingCacheEnabled(false);
      bool = super.drawChild(paramCanvas, paramView, paramLong);
    }
  }

  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams();
  }

  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }

  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams));
    for (LayoutParams localLayoutParams = new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams); ; localLayoutParams = new LayoutParams(paramLayoutParams))
      return localLayoutParams;
  }

  public int getCoveredFadeColor()
  {
    return this.mCoveredFadeColor;
  }

  public int getParallaxDistance()
  {
    return this.mParallaxBy;
  }

  public int getSliderFadeColor()
  {
    return this.mSliderFadeColor;
  }

  boolean isDimmed(View paramView)
  {
    int i = 0;
    if (paramView == null);
    while (true)
    {
      return i;
      LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
      if ((!this.mCanSlide) || (!localLayoutParams.dimWhenOffset) || (this.mSlideOffset <= 0.0F))
        continue;
      i = 1;
    }
  }

  public boolean isOpen()
  {
    if ((!this.mCanSlide) || (this.mSlideOffset == 1.0F));
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean isSlideable()
  {
    return this.mCanSlide;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mFirstLayout = true;
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mFirstLayout = true;
    int i = 0;
    int j = this.mPostedRunnables.size();
    while (i < j)
    {
      ((DisableLayerRunnable)this.mPostedRunnables.get(i)).run();
      i++;
    }
    this.mPostedRunnables.clear();
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    boolean bool2;
    if ((!this.mCanSlide) && (i == 0) && (getChildCount() > 1))
    {
      View localView = getChildAt(1);
      if (localView != null)
      {
        if (this.mDragHelper.isViewUnder(localView, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
          break label100;
        bool2 = true;
        this.mPreservedOpenState = bool2;
      }
    }
    boolean bool1;
    if ((!this.mCanSlide) || ((this.mIsUnableToDrag) && (i != 0)))
    {
      this.mDragHelper.cancel();
      bool1 = super.onInterceptTouchEvent(paramMotionEvent);
    }
    while (true)
    {
      return bool1;
      label100: bool2 = false;
      break;
      if ((i == 3) || (i == 1))
      {
        this.mDragHelper.cancel();
        bool1 = false;
        continue;
      }
      int j = 0;
      switch (i)
      {
      case 1:
      default:
      case 0:
      case 2:
      }
      float f3;
      float f4;
      do
      {
        while (true)
        {
          if ((!this.mDragHelper.shouldInterceptTouchEvent(paramMotionEvent)) && (j == 0))
            break label322;
          bool1 = true;
          break;
          this.mIsUnableToDrag = false;
          float f5 = paramMotionEvent.getX();
          float f6 = paramMotionEvent.getY();
          this.mInitialMotionX = f5;
          this.mInitialMotionY = f6;
          if ((!this.mDragHelper.isViewUnder(this.mSlideableView, (int)f5, (int)f6)) || (!isDimmed(this.mSlideableView)))
            continue;
          j = 1;
        }
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        f3 = Math.abs(f1 - this.mInitialMotionX);
        f4 = Math.abs(f2 - this.mInitialMotionY);
      }
      while ((f3 <= this.mDragHelper.getTouchSlop()) || (f4 <= f3));
      this.mDragHelper.cancel();
      this.mIsUnableToDrag = true;
      bool1 = false;
      continue;
      label322: bool1 = false;
    }
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt3 - paramInt1;
    int j = getPaddingLeft();
    int k = getPaddingRight();
    int m = getPaddingTop();
    int n = getChildCount();
    int i1 = j;
    int i2 = i1;
    float f;
    if (this.mFirstLayout)
    {
      if ((!this.mCanSlide) || (!this.mPreservedOpenState))
        break label102;
      f = 1.0F;
    }
    while (true)
    {
      this.mSlideOffset = f;
      int i3 = 0;
      View localView;
      while (true)
      {
        if (i3 >= n)
          break label340;
        localView = getChildAt(i3);
        if (localView.getVisibility() == 8)
        {
          i3++;
          continue;
          label102: f = 0.0F;
          break;
        }
      }
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      int i5 = localView.getMeasuredWidth();
      int i6 = 0;
      boolean bool;
      if (localLayoutParams.slideable)
      {
        int i8 = localLayoutParams.leftMargin + localLayoutParams.rightMargin;
        int i9 = Math.min(i2, i - k - this.mOverhangSize) - i1 - i8;
        this.mSlideRange = i9;
        if (i9 + (i1 + localLayoutParams.leftMargin) + i5 / 2 > i - k)
        {
          bool = true;
          label205: localLayoutParams.dimWhenOffset = bool;
          int i10 = (int)(i9 * this.mSlideOffset);
          i1 += i10 + localLayoutParams.leftMargin;
          this.mSlideOffset = (i10 / this.mSlideRange);
        }
      }
      while (true)
      {
        int i7 = i1 - i6;
        localView.layout(i7, m, i7 + i5, m + localView.getMeasuredHeight());
        i2 += localView.getWidth();
        break;
        bool = false;
        break label205;
        if ((this.mCanSlide) && (this.mParallaxBy != 0))
        {
          i6 = (int)((1.0F - this.mSlideOffset) * this.mParallaxBy);
          i1 = i2;
          continue;
        }
        i1 = i2;
      }
    }
    label340: if (this.mFirstLayout)
    {
      if (!this.mCanSlide)
        break label415;
      if (this.mParallaxBy != 0)
        parallaxOtherViews(this.mSlideOffset);
      if (((LayoutParams)this.mSlideableView.getLayoutParams()).dimWhenOffset)
        dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
    }
    while (true)
    {
      updateObscuredViewsVisibility(this.mSlideableView);
      this.mFirstLayout = false;
      return;
      label415: for (int i4 = 0; i4 < n; i4++)
        dimChildView(getChildAt(i4), 0.0F, this.mSliderFadeColor);
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    int m = View.MeasureSpec.getSize(paramInt2);
    int n;
    int i1;
    label80: float f;
    boolean bool1;
    int i2;
    int i3;
    int i4;
    label129: View localView2;
    LayoutParams localLayoutParams2;
    if (i != 1073741824)
      if (isInEditMode())
        if (i == -2147483648)
        {
          n = 0;
          i1 = -1;
          switch (k)
          {
          default:
            f = 0.0F;
            bool1 = false;
            i2 = j - getPaddingLeft() - getPaddingRight();
            i3 = getChildCount();
            if (i3 > 2)
              Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
            this.mSlideableView = null;
            i4 = 0;
            if (i4 >= i3)
              break label542;
            localView2 = getChildAt(i4);
            localLayoutParams2 = (LayoutParams)localView2.getLayoutParams();
            if (localView2.getVisibility() != 8)
              break;
            localLayoutParams2.dimWhenOffset = false;
          case 1073741824:
          case -2147483648:
          }
        }
    do
    {
      i4++;
      break label129;
      if (i != 0)
        break;
      j = 300;
      break;
      throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
      if (k != 0)
        break;
      if (isInEditMode())
      {
        if (k != 0)
          break;
        k = -2147483648;
        m = 300;
        break;
      }
      throw new IllegalStateException("Height must not be UNSPECIFIED");
      i1 = m - getPaddingTop() - getPaddingBottom();
      n = i1;
      break label80;
      i1 = m - getPaddingTop() - getPaddingBottom();
      break label80;
      if (localLayoutParams2.weight <= 0.0F)
        break label306;
      f += localLayoutParams2.weight;
    }
    while (localLayoutParams2.width == 0);
    label306: int i14 = localLayoutParams2.leftMargin + localLayoutParams2.rightMargin;
    int i15;
    label342: int i16;
    if (localLayoutParams2.width == -2)
    {
      i15 = View.MeasureSpec.makeMeasureSpec(j - i14, -2147483648);
      if (localLayoutParams2.height != -2)
        break label497;
      i16 = View.MeasureSpec.makeMeasureSpec(i1, -2147483648);
      label362: localView2.measure(i15, i16);
      int i17 = localView2.getMeasuredWidth();
      int i18 = localView2.getMeasuredHeight();
      if ((k == -2147483648) && (i18 > n))
        n = Math.min(i18, i1);
      i2 -= i17;
      if (i2 >= 0)
        break label536;
    }
    label536: for (boolean bool2 = true; ; bool2 = false)
    {
      localLayoutParams2.slideable = bool2;
      bool1 |= bool2;
      if (!localLayoutParams2.slideable)
        break;
      this.mSlideableView = localView2;
      break;
      if (localLayoutParams2.width == -1)
      {
        i15 = View.MeasureSpec.makeMeasureSpec(j - i14, 1073741824);
        break label342;
      }
      i15 = View.MeasureSpec.makeMeasureSpec(localLayoutParams2.width, 1073741824);
      break label342;
      label497: if (localLayoutParams2.height == -1)
      {
        i16 = View.MeasureSpec.makeMeasureSpec(i1, 1073741824);
        break label362;
      }
      i16 = View.MeasureSpec.makeMeasureSpec(localLayoutParams2.height, 1073741824);
      break label362;
    }
    label542: if ((bool1) || (f > 0.0F))
    {
      int i5 = j - this.mOverhangSize;
      int i6 = 0;
      if (i6 < i3)
      {
        View localView1 = getChildAt(i6);
        if (localView1.getVisibility() == 8);
        while (true)
        {
          i6++;
          break;
          LayoutParams localLayoutParams1 = (LayoutParams)localView1.getLayoutParams();
          if (localView1.getVisibility() == 8)
            continue;
          int i7;
          label638: int i8;
          int i13;
          if ((localLayoutParams1.width == 0) && (localLayoutParams1.weight > 0.0F))
          {
            i7 = 1;
            if (i7 == 0)
              break label734;
            i8 = 0;
            if ((!bool1) || (localView1 == this.mSlideableView))
              break label799;
            if ((localLayoutParams1.width >= 0) || ((i8 <= i5) && (localLayoutParams1.weight <= 0.0F)))
              continue;
            if (i7 == 0)
              break label783;
            if (localLayoutParams1.height != -2)
              break label744;
            i13 = View.MeasureSpec.makeMeasureSpec(i1, -2147483648);
          }
          while (true)
          {
            localView1.measure(View.MeasureSpec.makeMeasureSpec(i5, 1073741824), i13);
            break;
            i7 = 0;
            break label638;
            label734: i8 = localView1.getMeasuredWidth();
            break label646;
            label744: if (localLayoutParams1.height == -1)
            {
              i13 = View.MeasureSpec.makeMeasureSpec(i1, 1073741824);
              continue;
            }
            i13 = View.MeasureSpec.makeMeasureSpec(localLayoutParams1.height, 1073741824);
            continue;
            i13 = View.MeasureSpec.makeMeasureSpec(localView1.getMeasuredHeight(), 1073741824);
          }
          label799: if (localLayoutParams1.weight <= 0.0F)
            continue;
          int i9;
          if (localLayoutParams1.width == 0)
            if (localLayoutParams1.height == -2)
              i9 = View.MeasureSpec.makeMeasureSpec(i1, -2147483648);
          while (true)
          {
            if (!bool1)
              break label942;
            int i11 = j - (localLayoutParams1.leftMargin + localLayoutParams1.rightMargin);
            int i12 = View.MeasureSpec.makeMeasureSpec(i11, 1073741824);
            if (i8 == i11)
              break;
            localView1.measure(i12, i9);
            break;
            if (localLayoutParams1.height == -1)
            {
              i9 = View.MeasureSpec.makeMeasureSpec(i1, 1073741824);
              continue;
            }
            i9 = View.MeasureSpec.makeMeasureSpec(localLayoutParams1.height, 1073741824);
            continue;
            i9 = View.MeasureSpec.makeMeasureSpec(localView1.getMeasuredHeight(), 1073741824);
          }
          label942: int i10 = Math.max(0, i2);
          localView1.measure(View.MeasureSpec.makeMeasureSpec(i8 + (int)(localLayoutParams1.weight * i10 / f), 1073741824), i9);
        }
      }
    }
    label646: label783: setMeasuredDimension(j, n);
    this.mCanSlide = bool1;
    if ((this.mDragHelper.getViewDragState() != 0) && (!bool1))
      this.mDragHelper.abort();
  }

  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    SavedState localSavedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    if (localSavedState.isOpen)
      openPane();
    while (true)
    {
      this.mPreservedOpenState = localSavedState.isOpen;
      return;
      closePane();
    }
  }

  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if (isSlideable());
    for (boolean bool = isOpen(); ; bool = this.mPreservedOpenState)
    {
      localSavedState.isOpen = bool;
      return localSavedState;
    }
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3)
      this.mFirstLayout = true;
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool;
    if (!this.mCanSlide)
      bool = super.onTouchEvent(paramMotionEvent);
    while (true)
    {
      return bool;
      this.mDragHelper.processTouchEvent(paramMotionEvent);
      int i = paramMotionEvent.getAction();
      bool = true;
      switch (i & 0xFF)
      {
      default:
        break;
      case 0:
        float f5 = paramMotionEvent.getX();
        float f6 = paramMotionEvent.getY();
        this.mInitialMotionX = f5;
        this.mInitialMotionY = f6;
        break;
      case 1:
        if (!isDimmed(this.mSlideableView))
          continue;
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        float f3 = f1 - this.mInitialMotionX;
        float f4 = f2 - this.mInitialMotionY;
        int j = this.mDragHelper.getTouchSlop();
        if ((f3 * f3 + f4 * f4 >= j * j) || (!this.mDragHelper.isViewUnder(this.mSlideableView, (int)f1, (int)f2)))
          continue;
        closePane(this.mSlideableView, 0);
      }
    }
  }

  public boolean openPane()
  {
    return openPane(this.mSlideableView, 0);
  }

  public void requestChildFocus(View paramView1, View paramView2)
  {
    super.requestChildFocus(paramView1, paramView2);
    if ((!isInTouchMode()) && (!this.mCanSlide))
      if (paramView1 != this.mSlideableView)
        break label36;
    label36: for (boolean bool = true; ; bool = false)
    {
      this.mPreservedOpenState = bool;
      return;
    }
  }

  void setAllChildrenVisible()
  {
    int i = 0;
    int j = getChildCount();
    while (i < j)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 4)
        localView.setVisibility(0);
      i++;
    }
  }

  public void setCoveredFadeColor(int paramInt)
  {
    this.mCoveredFadeColor = paramInt;
  }

  public void setPanelSlideListener(PanelSlideListener paramPanelSlideListener)
  {
    this.mPanelSlideListener = paramPanelSlideListener;
  }

  public void setParallaxDistance(int paramInt)
  {
    this.mParallaxBy = paramInt;
    requestLayout();
  }

  public void setShadowDrawable(Drawable paramDrawable)
  {
    this.mShadowDrawable = paramDrawable;
  }

  public void setShadowResource(int paramInt)
  {
    setShadowDrawable(getResources().getDrawable(paramInt));
  }

  public void setSliderFadeColor(int paramInt)
  {
    this.mSliderFadeColor = paramInt;
  }

  @Deprecated
  public void smoothSlideClosed()
  {
    closePane();
  }

  @Deprecated
  public void smoothSlideOpen()
  {
    openPane();
  }

  boolean smoothSlideTo(float paramFloat, int paramInt)
  {
    int i = 0;
    if (!this.mCanSlide);
    while (true)
    {
      return i;
      LayoutParams localLayoutParams = (LayoutParams)this.mSlideableView.getLayoutParams();
      int j = (int)(getPaddingLeft() + localLayoutParams.leftMargin + paramFloat * this.mSlideRange);
      if (!this.mDragHelper.smoothSlideViewTo(this.mSlideableView, j, this.mSlideableView.getTop()))
        continue;
      setAllChildrenVisible();
      ViewCompat.postInvalidateOnAnimation(this);
      i = 1;
    }
  }

  void updateObscuredViewsVisibility(View paramView)
  {
    int i = getPaddingLeft();
    int j = getWidth() - getPaddingRight();
    int k = getPaddingTop();
    int m = getHeight() - getPaddingBottom();
    int i3;
    int i2;
    int i1;
    int n;
    if ((paramView != null) && (viewIsOpaque(paramView)))
    {
      i3 = paramView.getLeft();
      i2 = paramView.getRight();
      i1 = paramView.getTop();
      n = paramView.getBottom();
    }
    int i4;
    View localView;
    while (true)
    {
      i4 = 0;
      int i5 = getChildCount();
      if (i4 < i5)
      {
        localView = getChildAt(i4);
        if (localView != paramView)
          break;
      }
      return;
      n = 0;
      i1 = 0;
      i2 = 0;
      i3 = 0;
    }
    int i6 = Math.max(i, localView.getLeft());
    int i7 = Math.max(k, localView.getTop());
    int i8 = Math.min(j, localView.getRight());
    int i9 = Math.min(m, localView.getBottom());
    if ((i6 >= i3) && (i7 >= i1) && (i8 <= i2) && (i9 <= n));
    for (int i10 = 4; ; i10 = 0)
    {
      localView.setVisibility(i10);
      i4++;
      break;
    }
  }

  private class DisableLayerRunnable
    implements Runnable
  {
    final View mChildView;

    DisableLayerRunnable(View arg2)
    {
      Object localObject;
      this.mChildView = localObject;
    }

    public void run()
    {
      if (this.mChildView.getParent() == SlidingPaneLayout.this)
      {
        ViewCompat.setLayerType(this.mChildView, 0, null);
        SlidingPaneLayout.this.invalidateChildRegion(this.mChildView);
      }
      SlidingPaneLayout.this.mPostedRunnables.remove(this);
    }
  }

  public static class LayoutParams extends ViewGroup.MarginLayoutParams
  {
    private static final int[] ATTRS;
    Paint dimPaint;
    boolean dimWhenOffset;
    boolean slideable;
    public float weight = 0.0F;

    static
    {
      int[] arrayOfInt = new int[1];
      arrayOfInt[0] = 16843137;
      ATTRS = arrayOfInt;
    }

    public LayoutParams()
    {
      super(-1);
    }

    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }

    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, ATTRS);
      this.weight = localTypedArray.getFloat(0, 0.0F);
      localTypedArray.recycle();
    }

    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.weight = paramLayoutParams.weight;
    }

    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }

    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
  }

  public static abstract interface PanelSlideListener
  {
    public abstract void onPanelClosed(View paramView);

    public abstract void onPanelOpened(View paramView);

    public abstract void onPanelSlide(View paramView, float paramFloat);
  }

  static class SavedState extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new SlidingPaneLayout.SavedState.1();
    boolean isOpen;

    private SavedState(Parcel paramParcel)
    {
      super();
      if (paramParcel.readInt() != 0);
      for (boolean bool = true; ; bool = false)
      {
        this.isOpen = bool;
        return;
      }
    }

    SavedState(Parcelable paramParcelable)
    {
      super();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      if (this.isOpen);
      for (int i = 1; ; i = 0)
      {
        paramParcel.writeInt(i);
        return;
      }
    }
  }

  static abstract interface SlidingPanelLayoutImpl
  {
    public abstract void invalidateChildRegion(SlidingPaneLayout paramSlidingPaneLayout, View paramView);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.SlidingPaneLayout
 * JD-Core Version:    0.6.0
 */