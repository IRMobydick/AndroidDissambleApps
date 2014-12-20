package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class ActionBarContainer extends FrameLayout
{
  private ActionBarView mActionBarView;
  private Drawable mBackground;
  private boolean mIsSplit;
  private boolean mIsStacked;
  private boolean mIsTransitioning;
  private Drawable mSplitBackground;
  private Drawable mStackedBackground;
  private View mTabContainer;

  public ActionBarContainer(Context paramContext)
  {
    this(paramContext, null);
  }

  public ActionBarContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setBackgroundDrawable(null);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ActionBar);
    this.mBackground = localTypedArray.getDrawable(10);
    this.mStackedBackground = localTypedArray.getDrawable(11);
    if (getId() == R.id.split_action_bar)
    {
      this.mIsSplit = bool;
      this.mSplitBackground = localTypedArray.getDrawable(12);
    }
    localTypedArray.recycle();
    if (this.mIsSplit)
      if (this.mSplitBackground != null);
    while (true)
    {
      setWillNotDraw(bool);
      return;
      bool = false;
      continue;
      if ((this.mBackground == null) && (this.mStackedBackground == null))
        continue;
      bool = false;
    }
  }

  private void drawBackgroundDrawable(Drawable paramDrawable, Canvas paramCanvas)
  {
    Rect localRect = paramDrawable.getBounds();
    if (((paramDrawable instanceof ColorDrawable)) && (!localRect.isEmpty()) && (Build.VERSION.SDK_INT < 11))
    {
      paramCanvas.save();
      paramCanvas.clipRect(localRect);
      paramDrawable.draw(paramCanvas);
      paramCanvas.restore();
    }
    while (true)
    {
      return;
      paramDrawable.draw(paramCanvas);
    }
  }

  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if ((this.mBackground != null) && (this.mBackground.isStateful()))
      this.mBackground.setState(getDrawableState());
    if ((this.mStackedBackground != null) && (this.mStackedBackground.isStateful()))
      this.mStackedBackground.setState(getDrawableState());
    if ((this.mSplitBackground != null) && (this.mSplitBackground.isStateful()))
      this.mSplitBackground.setState(getDrawableState());
  }

  public View getTabContainer()
  {
    return this.mTabContainer;
  }

  public void onDraw(Canvas paramCanvas)
  {
    if ((getWidth() == 0) || (getHeight() == 0));
    while (true)
    {
      return;
      if (this.mIsSplit)
      {
        if (this.mSplitBackground == null)
          continue;
        drawBackgroundDrawable(this.mSplitBackground, paramCanvas);
        continue;
      }
      if (this.mBackground != null)
        drawBackgroundDrawable(this.mBackground, paramCanvas);
      if ((this.mStackedBackground == null) || (!this.mIsStacked))
        continue;
      drawBackgroundDrawable(this.mStackedBackground, paramCanvas);
    }
  }

  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.mActionBarView = ((ActionBarView)findViewById(R.id.action_bar));
  }

  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.mIsTransitioning) || (super.onInterceptTouchEvent(paramMotionEvent)));
    for (int i = 1; ; i = 0)
      return i;
  }

  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    int i;
    int k;
    int m;
    int i1;
    label88: View localView;
    if ((this.mTabContainer != null) && (this.mTabContainer.getVisibility() != 8))
    {
      i = 1;
      if ((this.mTabContainer == null) || (this.mTabContainer.getVisibility() == 8))
        break label157;
      k = getMeasuredHeight();
      m = this.mTabContainer.getMeasuredHeight();
      if ((0x2 & this.mActionBarView.getDisplayOptions()) != 0)
        break label204;
      int n = getChildCount();
      i1 = 0;
      if (i1 >= n)
        break label144;
      localView = getChildAt(i1);
      if (localView != this.mTabContainer)
        break label124;
    }
    while (true)
    {
      i1++;
      break label88;
      i = 0;
      break;
      label124: if (this.mActionBarView.isCollapsed())
        continue;
      localView.offsetTopAndBottom(m);
    }
    label144: this.mTabContainer.layout(paramInt1, 0, paramInt3, m);
    label157: int j;
    while (true)
    {
      j = 0;
      if (!this.mIsSplit)
        break;
      if (this.mSplitBackground != null)
      {
        this.mSplitBackground.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        j = 1;
      }
      if (j != 0)
        invalidate();
      return;
      label204: this.mTabContainer.layout(paramInt1, k - m, paramInt3, k);
    }
    if (this.mBackground != null)
    {
      this.mBackground.setBounds(this.mActionBarView.getLeft(), this.mActionBarView.getTop(), this.mActionBarView.getRight(), this.mActionBarView.getBottom());
      j = 1;
    }
    if ((i != 0) && (this.mStackedBackground != null));
    for (boolean bool = true; ; bool = false)
    {
      this.mIsStacked = bool;
      if (!bool)
        break;
      this.mStackedBackground.setBounds(this.mTabContainer.getLeft(), this.mTabContainer.getTop(), this.mTabContainer.getRight(), this.mTabContainer.getBottom());
      j = 1;
      break;
    }
  }

  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.mActionBarView == null);
    label118: 
    while (true)
    {
      return;
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mActionBarView.getLayoutParams();
      if (this.mActionBarView.isCollapsed());
      for (int i = 0; ; i = this.mActionBarView.getMeasuredHeight() + localLayoutParams.topMargin + localLayoutParams.bottomMargin)
      {
        if ((this.mTabContainer == null) || (this.mTabContainer.getVisibility() == 8) || (View.MeasureSpec.getMode(paramInt2) != -2147483648))
          break label118;
        int j = View.MeasureSpec.getSize(paramInt2);
        setMeasuredDimension(getMeasuredWidth(), Math.min(i + this.mTabContainer.getMeasuredHeight(), j));
        break;
      }
    }
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return true;
  }

  public void setPrimaryBackground(Drawable paramDrawable)
  {
    boolean bool = true;
    if (this.mBackground != null)
    {
      this.mBackground.setCallback(null);
      unscheduleDrawable(this.mBackground);
    }
    this.mBackground = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if (this.mActionBarView != null)
        this.mBackground.setBounds(this.mActionBarView.getLeft(), this.mActionBarView.getTop(), this.mActionBarView.getRight(), this.mActionBarView.getBottom());
    }
    if (this.mIsSplit)
      if (this.mSplitBackground != null);
    while (true)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
      bool = false;
      continue;
      if ((this.mBackground == null) && (this.mStackedBackground == null))
        continue;
      bool = false;
    }
  }

  public void setSplitBackground(Drawable paramDrawable)
  {
    boolean bool = true;
    if (this.mSplitBackground != null)
    {
      this.mSplitBackground.setCallback(null);
      unscheduleDrawable(this.mSplitBackground);
    }
    this.mSplitBackground = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if ((this.mIsSplit) && (this.mSplitBackground != null))
        this.mSplitBackground.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }
    if (this.mIsSplit)
      if (this.mSplitBackground != null);
    while (true)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
      bool = false;
      continue;
      if ((this.mBackground == null) && (this.mStackedBackground == null))
        continue;
      bool = false;
    }
  }

  public void setStackedBackground(Drawable paramDrawable)
  {
    boolean bool = true;
    if (this.mStackedBackground != null)
    {
      this.mStackedBackground.setCallback(null);
      unscheduleDrawable(this.mStackedBackground);
    }
    this.mStackedBackground = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if ((this.mIsStacked) && (this.mStackedBackground != null))
        this.mStackedBackground.setBounds(this.mTabContainer.getLeft(), this.mTabContainer.getTop(), this.mTabContainer.getRight(), this.mTabContainer.getBottom());
    }
    if (this.mIsSplit)
      if (this.mSplitBackground != null);
    while (true)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
      bool = false;
      continue;
      if ((this.mBackground == null) && (this.mStackedBackground == null))
        continue;
      bool = false;
    }
  }

  public void setTabContainer(ScrollingTabContainerView paramScrollingTabContainerView)
  {
    if (this.mTabContainer != null)
      removeView(this.mTabContainer);
    this.mTabContainer = paramScrollingTabContainerView;
    if (paramScrollingTabContainerView != null)
    {
      addView(paramScrollingTabContainerView);
      ViewGroup.LayoutParams localLayoutParams = paramScrollingTabContainerView.getLayoutParams();
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      paramScrollingTabContainerView.setAllowCollapse(false);
    }
  }

  public void setTransitioning(boolean paramBoolean)
  {
    this.mIsTransitioning = paramBoolean;
    if (paramBoolean);
    for (int i = 393216; ; i = 262144)
    {
      setDescendantFocusability(i);
      return;
    }
  }

  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0);
    for (boolean bool = true; ; bool = false)
    {
      if (this.mBackground != null)
        this.mBackground.setVisible(bool, false);
      if (this.mStackedBackground != null)
        this.mStackedBackground.setVisible(bool, false);
      if (this.mSplitBackground != null)
        this.mSplitBackground.setVisible(bool, false);
      return;
    }
  }

  public ActionMode startActionModeForChild(View paramView, ActionMode.Callback paramCallback)
  {
    return null;
  }

  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    if (((paramDrawable == this.mBackground) && (!this.mIsSplit)) || ((paramDrawable == this.mStackedBackground) && (this.mIsStacked)) || ((paramDrawable == this.mSplitBackground) && (this.mIsSplit)) || (super.verifyDrawable(paramDrawable)));
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ActionBarContainer
 * JD-Core Version:    0.6.0
 */