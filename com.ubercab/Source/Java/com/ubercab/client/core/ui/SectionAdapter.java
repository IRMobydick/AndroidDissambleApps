package com.ubercab.client.core.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.SelectionBoundsAdjuster;
import android.widget.BaseAdapter;

abstract class SectionAdapter<T> extends BaseAdapter
{
  private static final int VIEW_TYPE_FOOTER = 2;
  private static final int VIEW_TYPE_HEADER = 0;
  private static final int VIEW_TYPE_ITEM = 1;
  private Context mContext;
  private Drawable mDivider;
  private int mDividerHeight;
  private int mPaddingX;
  private RecycleBin mRecycleBin;

  SectionAdapter(Context paramContext)
  {
    this.mContext = paramContext;
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(2131624109, new int[] { 16843284 });
    this.mDivider = localTypedArray.getDrawable(0);
    this.mDividerHeight = this.mDivider.getIntrinsicHeight();
    localTypedArray.recycle();
    this.mRecycleBin = new RecycleBin();
    this.mRecycleBin.setViewTypeCount(3);
  }

  private View prepareFooterView(SectionAdapter<T>.WrapperView paramSectionAdapter, int paramInt)
  {
    int i = getSectionForPosition(paramInt);
    View localView = paramSectionAdapter.mFooter;
    if (localView == null)
      localView = this.mRecycleBin.getScrapView(i, 2);
    return getSectionFooterView(i, localView, paramSectionAdapter);
  }

  private View prepareHeaderView(SectionAdapter<T>.WrapperView paramSectionAdapter, int paramInt)
  {
    int i = getSectionForPosition(paramInt);
    View localView = paramSectionAdapter.mHeader;
    if (localView == null)
      localView = this.mRecycleBin.getScrapView(i, 0);
    return getSectionHeaderView(i, localView, paramSectionAdapter);
  }

  private View prepareItemView(SectionAdapter<T>.WrapperView paramSectionAdapter, int paramInt)
  {
    View localView = paramSectionAdapter.mItem;
    if (localView == null)
      localView = this.mRecycleBin.getScrapView(paramInt, 1);
    return getItemView(paramInt, localView, paramSectionAdapter);
  }

  private boolean shouldShowDividerAtPosition(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt < -1 + getCount());
  }

  private boolean shouldShowFooterAtPosition(int paramInt)
  {
    return (paramInt + 1 == getCount()) || (getSectionForPosition(paramInt) != getSectionForPosition(paramInt + 1));
  }

  private boolean shouldShowHeaderAtPosition(int paramInt)
  {
    return (paramInt == 0) || (getSectionForPosition(paramInt) != getSectionForPosition(paramInt - 1));
  }

  public abstract T getItem(int paramInt);

  public abstract View getItemView(int paramInt, View paramView, ViewGroup paramViewGroup);

  public abstract View getSectionFooterView(int paramInt, View paramView, ViewGroup paramViewGroup);

  public abstract int getSectionForPosition(int paramInt);

  public abstract View getSectionHeaderView(int paramInt, View paramView, ViewGroup paramViewGroup);

  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    WrapperView localWrapperView;
    boolean bool2;
    boolean bool3;
    if (paramView == null)
    {
      localWrapperView = new WrapperView(this.mContext);
      boolean bool1 = shouldShowHeaderAtPosition(paramInt);
      bool2 = shouldShowFooterAtPosition(paramInt);
      bool3 = shouldShowDividerAtPosition(paramInt, bool2);
      if (!bool1)
        break label112;
    }
    label112: for (View localView1 = prepareHeaderView(localWrapperView, paramInt); ; localView1 = null)
    {
      View localView2 = null;
      if (bool2)
        localView2 = prepareFooterView(localWrapperView, paramInt);
      View localView3 = prepareItemView(localWrapperView, paramInt);
      localWrapperView.update(paramInt, getSectionForPosition(paramInt), localView1, localView3, localView2, bool3);
      return localWrapperView;
      localWrapperView = (WrapperView)paramView;
      break;
    }
  }

  public void setItemPaddingHorizontal(int paramInt)
  {
    this.mPaddingX = paramInt;
    notifyDataSetChanged();
  }

  private class WrapperView extends ViewGroup
    implements AbsListView.SelectionBoundsAdjuster
  {
    private View mFooter;
    private View mHeader;
    private View mItem;
    private boolean mShowDivider;

    WrapperView(Context arg2)
    {
      super();
    }

    private int measureHeight(View paramView, int paramInt)
    {
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      if ((localLayoutParams != null) && (localLayoutParams.height > 0))
        paramView.measure(paramInt, View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824));
      while (true)
      {
        return paramView.getMeasuredHeight();
        paramView.measure(paramInt, View.MeasureSpec.makeMeasureSpec(0, 0));
      }
    }

    public void adjustListItemSelectionBounds(Rect paramRect)
    {
      if (this.mHeader != null)
        paramRect.top += this.mHeader.getHeight();
      if (this.mShowDivider)
        paramRect.bottom -= SectionAdapter.this.mDividerHeight;
      paramRect.left += SectionAdapter.this.mPaddingX;
      paramRect.right -= SectionAdapter.this.mPaddingX;
    }

    protected void dispatchDraw(Canvas paramCanvas)
    {
      super.dispatchDraw(paramCanvas);
      if (this.mShowDivider)
      {
        int i = SectionAdapter.this.mPaddingX;
        int j = getWidth() - SectionAdapter.this.mPaddingX;
        SectionAdapter.this.mDivider.setBounds(i, getHeight() - SectionAdapter.this.mDividerHeight, j, getHeight());
        SectionAdapter.this.mDivider.draw(paramCanvas);
      }
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      int i = SectionAdapter.this.mPaddingX;
      int j = getWidth() - SectionAdapter.this.mPaddingX;
      int k = getHeight();
      View localView1 = this.mHeader;
      int m = 0;
      if (localView1 != null)
      {
        m = this.mHeader.getMeasuredHeight();
        this.mHeader.layout(i, 0, j, m);
      }
      View localView2 = this.mFooter;
      int n = 0;
      if (localView2 != null)
      {
        n = this.mFooter.getMeasuredHeight();
        if (this.mItem == null)
          break label153;
      }
      label153: for (int i1 = this.mItem.getMeasuredHeight(); ; i1 = 0)
      {
        this.mFooter.layout(i, i1 + (0 + m), j, k);
        if (this.mItem != null)
          this.mItem.layout(i, 0 + m, j, k - n);
        return;
      }
    }

    protected void onMeasure(int paramInt1, int paramInt2)
    {
      int i = View.MeasureSpec.getSize(paramInt1);
      int j = View.MeasureSpec.makeMeasureSpec(i - 2 * SectionAdapter.this.mPaddingX, 1073741824);
      View localView = this.mHeader;
      int k = 0;
      if (localView != null)
      {
        int m = this.mHeader.getVisibility();
        k = 0;
        if (m == 0)
          k = 0 + measureHeight(this.mHeader, j);
      }
      if ((this.mItem != null) && (this.mItem.getVisibility() == 0))
        k += measureHeight(this.mItem, j);
      if ((this.mFooter != null) && (this.mFooter.getVisibility() == 0))
        k += measureHeight(this.mFooter, j);
      if (this.mShowDivider)
        k += SectionAdapter.this.mDividerHeight;
      setMeasuredDimension(i, k);
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      if ((this.mHeader == null) || (paramMotionEvent.getY() > this.mHeader.getBottom()))
        return super.onTouchEvent(paramMotionEvent);
      return true;
    }

    void update(int paramInt1, int paramInt2, View paramView1, View paramView2, View paramView3, boolean paramBoolean)
    {
      if ((this.mHeader != null) && (this.mHeader != paramView1))
      {
        removeView(this.mHeader);
        SectionAdapter.this.mRecycleBin.addScrapView(this.mHeader, paramInt2, 0);
      }
      if ((this.mItem != null) && (this.mItem != paramView2))
      {
        removeView(this.mItem);
        SectionAdapter.this.mRecycleBin.addScrapView(this.mItem, paramInt1, 1);
      }
      if ((this.mFooter != null) && (this.mFooter != paramView3))
      {
        removeView(this.mFooter);
        SectionAdapter.this.mRecycleBin.addScrapView(this.mFooter, paramInt2, 2);
      }
      if ((paramView1 != null) && (paramView1 != this.mHeader))
        addView(paramView1);
      if ((paramView2 != null) && (paramView2 != this.mItem))
        addView(paramView2);
      if ((paramView3 != null) && (paramView3 != this.mFooter))
        addView(paramView3);
      this.mHeader = paramView1;
      this.mItem = paramView2;
      this.mFooter = paramView3;
      this.mShowDivider = paramBoolean;
      invalidate();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.ui.SectionAdapter
 * JD-Core Version:    0.6.2
 */