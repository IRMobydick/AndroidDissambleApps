package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.appcompat.R.styleable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class LinearLayoutICS extends LinearLayout
{
  private static final int SHOW_DIVIDER_BEGINNING = 1;
  private static final int SHOW_DIVIDER_END = 4;
  private static final int SHOW_DIVIDER_MIDDLE = 2;
  private static final int SHOW_DIVIDER_NONE;
  private final Drawable mDivider;
  private final int mDividerHeight;
  private final int mDividerPadding;
  private final int mDividerWidth;
  private final int mShowDividers;

  public LinearLayoutICS(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.LinearLayoutICS);
    this.mDivider = localTypedArray.getDrawable(0);
    if (this.mDivider != null)
    {
      this.mDividerWidth = this.mDivider.getIntrinsicWidth();
      this.mDividerHeight = this.mDivider.getIntrinsicHeight();
      this.mShowDividers = localTypedArray.getInt(i, 0);
      this.mDividerPadding = localTypedArray.getDimensionPixelSize(2, 0);
      localTypedArray.recycle();
      if (this.mDivider != null)
        break label110;
    }
    while (true)
    {
      setWillNotDraw(i);
      return;
      this.mDividerWidth = 0;
      this.mDividerHeight = 0;
      break;
      label110: int j = 0;
    }
  }

  void drawSupportDividersHorizontal(Canvas paramCanvas)
  {
    int i = getChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView2 = getChildAt(j);
      if ((localView2 == null) || (localView2.getVisibility() == 8) || (!hasSupportDividerBeforeChildAt(j)))
        continue;
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView2.getLayoutParams();
      drawSupportVerticalDivider(paramCanvas, localView2.getLeft() - localLayoutParams.leftMargin);
    }
    View localView1;
    if (hasSupportDividerBeforeChildAt(i))
    {
      localView1 = getChildAt(i - 1);
      if (localView1 != null)
        break label120;
    }
    label120: for (int k = getWidth() - getPaddingRight() - this.mDividerWidth; ; k = localView1.getRight())
    {
      drawSupportVerticalDivider(paramCanvas, k);
      return;
    }
  }

  void drawSupportDividersVertical(Canvas paramCanvas)
  {
    int i = getChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView2 = getChildAt(j);
      if ((localView2 == null) || (localView2.getVisibility() == 8) || (!hasSupportDividerBeforeChildAt(j)))
        continue;
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView2.getLayoutParams();
      drawSupportHorizontalDivider(paramCanvas, localView2.getTop() - localLayoutParams.topMargin);
    }
    View localView1;
    if (hasSupportDividerBeforeChildAt(i))
    {
      localView1 = getChildAt(i - 1);
      if (localView1 != null)
        break label120;
    }
    label120: for (int k = getHeight() - getPaddingBottom() - this.mDividerHeight; ; k = localView1.getBottom())
    {
      drawSupportHorizontalDivider(paramCanvas, k);
      return;
    }
  }

  void drawSupportHorizontalDivider(Canvas paramCanvas, int paramInt)
  {
    this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, paramInt, getWidth() - getPaddingRight() - this.mDividerPadding, paramInt + this.mDividerHeight);
    this.mDivider.draw(paramCanvas);
  }

  void drawSupportVerticalDivider(Canvas paramCanvas, int paramInt)
  {
    this.mDivider.setBounds(paramInt, getPaddingTop() + this.mDividerPadding, paramInt + this.mDividerWidth, getHeight() - getPaddingBottom() - this.mDividerPadding);
    this.mDivider.draw(paramCanvas);
  }

  public int getSupportDividerWidth()
  {
    return this.mDividerWidth;
  }

  protected boolean hasSupportDividerBeforeChildAt(int paramInt)
  {
    int i = 1;
    if (paramInt == 0)
      if ((0x1 & this.mShowDividers) == 0);
    while (true)
    {
      return i;
      i = 0;
      continue;
      if (paramInt == getChildCount())
      {
        if ((0x4 & this.mShowDividers) != 0)
          continue;
        i = 0;
        continue;
      }
      if ((0x2 & this.mShowDividers) != 0)
      {
        int j = 0;
        for (int k = paramInt - 1; ; k--)
        {
          if (k >= 0)
          {
            if (getChildAt(k).getVisibility() == 8)
              continue;
            j = 1;
          }
          i = j;
          break;
        }
      }
      i = 0;
    }
  }

  protected void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i;
    int j;
    LinearLayout.LayoutParams localLayoutParams;
    if (this.mDivider != null)
    {
      i = indexOfChild(paramView);
      j = getChildCount();
      localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
      if (getOrientation() != 1)
        break label97;
      if (!hasSupportDividerBeforeChildAt(i))
        break label67;
      localLayoutParams.topMargin = this.mDividerHeight;
    }
    while (true)
    {
      super.measureChildWithMargins(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
      label67: if ((i != j - 1) || (!hasSupportDividerBeforeChildAt(j)))
        continue;
      localLayoutParams.bottomMargin = this.mDividerHeight;
      continue;
      label97: if (hasSupportDividerBeforeChildAt(i))
      {
        localLayoutParams.leftMargin = this.mDividerWidth;
        continue;
      }
      if ((i != j - 1) || (!hasSupportDividerBeforeChildAt(j)))
        continue;
      localLayoutParams.rightMargin = this.mDividerWidth;
    }
  }

  protected void onDraw(Canvas paramCanvas)
  {
    if (this.mDivider == null);
    while (true)
    {
      return;
      if (getOrientation() == 1)
      {
        drawSupportDividersVertical(paramCanvas);
        continue;
      }
      drawSupportDividersHorizontal(paramCanvas);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.LinearLayoutICS
 * JD-Core Version:    0.6.0
 */