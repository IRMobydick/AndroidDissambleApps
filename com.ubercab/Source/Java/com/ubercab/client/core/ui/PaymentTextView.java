package com.ubercab.client.core.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.util.AttributeSet;
import com.ubercab.R.styleable;
import com.ubercab.ui.UberTextView;

public class PaymentTextView extends UberTextView
{
  private static final int LEFT_DRAWABLE;
  private Drawable mDrawableRight;
  private final int mOriginalPaddingRight;
  private final int mRightDrawableSpacing;

  public PaymentTextView(Context paramContext)
  {
    this(paramContext, null);
  }

  public PaymentTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public PaymentTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.PaymentTextView);
    try
    {
      this.mRightDrawableSpacing = localTypedArray.getDimensionPixelSize(0, 0);
      localTypedArray.recycle();
      this.mOriginalPaddingRight = getPaddingRight();
      return;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }

  private void setDrawable(int paramInt, Drawable paramDrawable)
  {
    Drawable[] arrayOfDrawable = getCompoundDrawables();
    arrayOfDrawable[paramInt] = paramDrawable;
    setCompoundDrawablesWithIntrinsicBounds(arrayOfDrawable[0], arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Layout localLayout;
    if (this.mDrawableRight != null)
    {
      localLayout = getLayout();
      if (localLayout != null);
    }
    else
    {
      return;
    }
    float f1 = getCompoundPaddingLeft() + this.mRightDrawableSpacing + localLayout.getLineWidth(0);
    float f2 = getHeight() / 2.0F - this.mDrawableRight.getIntrinsicHeight() / 2.0F;
    paramCanvas.save();
    paramCanvas.translate(f1, f2);
    this.mDrawableRight.draw(paramCanvas);
    paramCanvas.restore();
  }

  public void setInlineRightDrawable(int paramInt)
  {
    int i = 0;
    if (paramInt == 0)
      this.mDrawableRight = null;
    while (true)
    {
      int j = i + (this.mOriginalPaddingRight + this.mRightDrawableSpacing);
      setPadding(getPaddingLeft(), getPaddingTop(), j, getPaddingBottom());
      invalidate();
      return;
      this.mDrawableRight = getResources().getDrawable(paramInt);
      this.mDrawableRight.setBounds(0, 0, this.mDrawableRight.getIntrinsicWidth(), this.mDrawableRight.getIntrinsicHeight());
      i = this.mDrawableRight.getIntrinsicWidth();
    }
  }

  public void setLeftDrawable(Drawable paramDrawable)
  {
    setDrawable(0, paramDrawable);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.ui.PaymentTextView
 * JD-Core Version:    0.6.2
 */