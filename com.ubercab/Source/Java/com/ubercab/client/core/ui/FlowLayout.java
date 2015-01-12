package com.ubercab.client.core.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.ubercab.R.styleable;

public class FlowLayout extends ViewGroup
{
  private int mHorizontalSpacing;
  private Paint mPaint;
  private int mVerticalSpacing;

  public FlowLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FlowLayout);
    try
    {
      this.mHorizontalSpacing = localTypedArray.getDimensionPixelSize(0, 0);
      this.mVerticalSpacing = localTypedArray.getDimensionPixelSize(1, 0);
      localTypedArray.recycle();
      this.mPaint = new Paint();
      this.mPaint.setAntiAlias(true);
      this.mPaint.setColor(-65536);
      this.mPaint.setStrokeWidth(2.0F);
      return;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }

  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }

  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams.horizontalSpacing > 0)
    {
      float f3 = paramView.getRight();
      float f4 = paramView.getTop() + paramView.getHeight() / 2.0F;
      paramCanvas.drawLine(f3, f4 - 4.0F, f3, f4 + 4.0F, this.mPaint);
      paramCanvas.drawLine(f3, f4, f3 + localLayoutParams.horizontalSpacing, f4, this.mPaint);
      paramCanvas.drawLine(f3 + localLayoutParams.horizontalSpacing, f4 - 4.0F, f3 + localLayoutParams.horizontalSpacing, f4 + 4.0F, this.mPaint);
    }
    if (localLayoutParams.breakLine)
    {
      float f1 = paramView.getRight();
      float f2 = paramView.getTop() + paramView.getHeight() / 2.0F;
      paramCanvas.drawLine(f1, f2, f1, f2 + 6.0F, this.mPaint);
      paramCanvas.drawLine(f1, f2 + 6.0F, f1 + 6.0F, f2 + 6.0F, this.mPaint);
    }
    return bool;
  }

  protected LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-2, -2);
  }

  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }

  protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams.width, paramLayoutParams.height);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView = getChildAt(j);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      localView.layout(localLayoutParams.x, localLayoutParams.y, localLayoutParams.x + localView.getMeasuredWidth(), localLayoutParams.y + localView.getMeasuredHeight());
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = i - getPaddingLeft() - getPaddingRight();
    int k = getPaddingTop() + getPaddingBottom();
    int m = getPaddingLeft();
    int n = getPaddingTop();
    int i1 = 0;
    int i2 = 0;
    if (i2 < getChildCount())
    {
      View localView = getChildAt(i2);
      measureChild(localView, paramInt1, paramInt2);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      int i3 = this.mHorizontalSpacing;
      if (localLayoutParams.horizontalSpacing >= 0)
        i3 = localLayoutParams.horizontalSpacing;
      int i4 = i3 + localView.getMeasuredWidth();
      int i5 = localView.getMeasuredHeight() + this.mVerticalSpacing;
      if ((i1 > 0) && ((localLayoutParams.breakLine) || (m + i4 > i)));
      for (int i6 = 1; ; i6 = 0)
      {
        if (i6 != 0)
        {
          m = getPaddingLeft();
          n += i1;
        }
        localLayoutParams.x = m;
        localLayoutParams.y = n;
        m += i4;
        i1 = i5;
        j = Math.max(j, i4);
        k = Math.max(k, n + i5);
        i2++;
        break;
      }
    }
    setMeasuredDimension(resolveSize(j, paramInt1), resolveSize(k, paramInt2));
  }

  public static class LayoutParams extends ViewGroup.LayoutParams
  {
    public boolean breakLine;
    public int horizontalSpacing;
    int x;
    int y;

    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }

    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FlowLayout_LayoutParams);
      try
      {
        this.horizontalSpacing = localTypedArray.getDimensionPixelSize(1, -1);
        this.breakLine = localTypedArray.getBoolean(0, false);
        return;
      }
      finally
      {
        localTypedArray.recycle();
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.ui.FlowLayout
 * JD-Core Version:    0.6.2
 */