package com.ubercab.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class UberTextView extends TextView
  implements UberViewSupport
{
  private static final float SHRINK_INCREMENT = 0.5F;
  private static final float SHRINK_MIN_SIZE_PX = 2.0F;
  private boolean mAdjustSizeOnLayout;
  private int mAutoResizeTextSizeMaxSp;
  private int mAutoResizeTextSizeMinSp;
  private boolean mIsAutoResize;
  private boolean mIsAutoShrink;
  private int mMinHeight;
  private Set<View.OnClickListener> mOnClickListeners;
  private final float mOriginalPaintSize;
  private final Paint mPaint;
  private AutoResizeWatcher mTextWatcherAutoResize;

  public UberTextView(Context paramContext)
  {
    this(paramContext, null);
  }

  public UberTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public UberTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mPaint = new Paint(getPaint());
    this.mOriginalPaintSize = getPaint().getTextSize();
    init(paramContext, paramAttributeSet);
  }

  UberTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, Paint paramPaint)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mPaint = new Paint(paramPaint);
    this.mOriginalPaintSize = paramPaint.getTextSize();
    init(paramContext, paramAttributeSet);
  }

  private void checkForAndResolveConflictingAttributes()
  {
    if ((this.mIsAutoShrink) && (this.mIsAutoResize))
      throw new IllegalStateException("Auto shrink and auto resize cannot be on at the same time");
    if (this.mIsAutoShrink)
      setEllipsize(null);
  }

  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.UberText);
    if (localTypedArray != null)
    {
      this.mIsAutoShrink = localTypedArray.getBoolean(R.styleable.UberText_autoShrink, false);
      this.mIsAutoResize = localTypedArray.getBoolean(R.styleable.UberText_autoResize, false);
      float f1 = localTypedArray.getDimension(R.styleable.UberText_autoResizeTextSizeMin, 1.4E-45F);
      float f2 = localTypedArray.getDimension(R.styleable.UberText_autoResizeTextSizeMax, 3.4028235E+38F);
      int i = UiUtils.convertPixelToSp(f1);
      int j = UiUtils.convertPixelToSp(f2);
      setAutoResizeEnabled(this.mIsAutoResize);
      setAutoResizeMin(i);
      setAutoResizeMax(j);
      localTypedArray.recycle();
    }
    this.mOnClickListeners = new CopyOnWriteArraySet();
    checkForAndResolveConflictingAttributes();
  }

  private void shrinkToFit()
  {
    int i = getWidth() - getCompoundPaddingLeft() - getCompoundPaddingRight();
    if (i <= 0)
      return;
    CharSequence localCharSequence = getText();
    Drawable[] arrayOfDrawable = getCompoundDrawables();
    if (arrayOfDrawable[0] != null)
      i -= arrayOfDrawable[0].getIntrinsicWidth() + getCompoundDrawablePadding();
    if (arrayOfDrawable[2] != null)
      i -= arrayOfDrawable[2].getIntrinsicWidth() + getCompoundDrawablePadding();
    if (getTransformationMethod() != null)
      localCharSequence = getTransformationMethod().getTransformation(localCharSequence, this);
    this.mPaint.setTypeface(getTypeface());
    this.mPaint.setTextSize(this.mOriginalPaintSize);
    while (true)
    {
      float f;
      if (this.mPaint.measureText(localCharSequence, 0, localCharSequence.length()) > i)
      {
        f = this.mPaint.getTextSize() - 0.5F;
        if (f > 2.0F);
      }
      else
      {
        setTextSize(0, this.mPaint.getTextSize());
        return;
      }
      this.mPaint.setTextSize(f);
    }
  }

  private void updateClickListener()
  {
    super.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Iterator localIterator = UberTextView.this.mOnClickListeners.iterator();
        while (localIterator.hasNext())
          ((View.OnClickListener)localIterator.next()).onClick(paramAnonymousView);
      }
    });
  }

  public void addOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnClickListeners.add(paramOnClickListener);
    updateClickListener();
  }

  void adjustTextSize(String paramString)
  {
    int i = getWidth();
    if (i <= 0)
      this.mAdjustSizeOnLayout = true;
    float f1;
    do
    {
      int j;
      int k;
      do
      {
        return;
        TextPaint localTextPaint = getPaint();
        j = (int)localTextPaint.measureText(paramString);
        k = (int)localTextPaint.measureText("W");
        if (j > i)
        {
          float f2 = UiUtils.convertPixelToSp(getTextSize());
          if (f2 > this.mAutoResizeTextSizeMinSp)
          {
            setTextSize(f2 - 1.0F);
            adjustTextSize(paramString);
            return;
          }
        }
      }
      while (j + k >= i);
      f1 = UiUtils.convertPixelToSp(getTextSize());
    }
    while (f1 >= this.mAutoResizeTextSizeMaxSp);
    setTextSize(f1 + 1.0F);
    adjustTextSize(paramString);
  }

  public int getAutoResizeMax()
  {
    return this.mAutoResizeTextSizeMaxSp;
  }

  public int getAutoResizeMin()
  {
    return this.mAutoResizeTextSizeMinSp;
  }

  boolean isAutoResize()
  {
    return this.mIsAutoResize;
  }

  boolean isAutoShrink()
  {
    return this.mIsAutoShrink;
  }

  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    CharSequence localCharSequence = getText();
    if ((this.mAdjustSizeOnLayout) && (localCharSequence != null))
    {
      this.mAdjustSizeOnLayout = false;
      adjustTextSize(localCharSequence.toString());
      invalidate();
    }
    if (this.mIsAutoShrink)
    {
      int i = paramInt4 - paramInt2;
      setMinHeight(Math.max(this.mMinHeight, i));
      this.mMinHeight = i;
      shrinkToFit();
    }
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.mIsAutoShrink) && (paramInt1 != paramInt3))
      shrinkToFit();
  }

  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mIsAutoShrink)
      shrinkToFit();
  }

  public void removeOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnClickListeners.remove(paramOnClickListener);
  }

  public void setAutoResizeEnabled(boolean paramBoolean)
  {
    this.mIsAutoResize = paramBoolean;
    checkForAndResolveConflictingAttributes();
    if (!paramBoolean)
    {
      removeTextChangedListener(this.mTextWatcherAutoResize);
      this.mTextWatcherAutoResize = null;
    }
    while (this.mTextWatcherAutoResize != null)
      return;
    this.mTextWatcherAutoResize = new AutoResizeWatcher(null);
    addTextChangedListener(this.mTextWatcherAutoResize);
  }

  public void setAutoResizeMax(int paramInt)
  {
    this.mAutoResizeTextSizeMaxSp = paramInt;
  }

  public void setAutoResizeMin(int paramInt)
  {
    this.mAutoResizeTextSizeMinSp = paramInt;
  }

  public void setAutoShrink(boolean paramBoolean)
  {
    this.mIsAutoShrink = paramBoolean;
    checkForAndResolveConflictingAttributes();
  }

  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    addOnClickListener(paramOnClickListener);
    updateClickListener();
  }

  private class AutoResizeWatcher extends TextWatcherAdapter
  {
    private AutoResizeWatcher()
    {
    }

    public void afterTextChanged(Editable paramEditable)
    {
      UberTextView.this.adjustTextSize(paramEditable.toString());
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.ui.UberTextView
 * JD-Core Version:    0.6.2
 */