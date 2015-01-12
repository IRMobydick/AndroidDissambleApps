package com.ubercab.client.feature.trip.address;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import com.ubercab.ui.FontUtils;
import com.ubercab.ui.UberTextView;

public class AddressTextView extends UberTextView
{
  private Paint mDefaultTextPaint;
  private float mDefaultTextSize;
  private boolean mEditable;
  private Paint mMinSizeTextPaint;
  private CharSequence mSearchText = "";
  private float mSmallTextSize;

  public AddressTextView(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public AddressTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public AddressTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Typeface localTypeface = FontUtils.getTypefaceFromResource(paramContext, 2131559280);
    this.mDefaultTextSize = getResources().getDimension(2131362003);
    this.mSmallTextSize = getResources().getDimension(2131362030);
    this.mDefaultTextPaint = new Paint();
    this.mDefaultTextPaint.setTextSize(this.mDefaultTextSize);
    this.mDefaultTextPaint.setTypeface(localTypeface);
    this.mMinSizeTextPaint = new Paint();
    this.mMinSizeTextPaint.setTextSize(this.mSmallTextSize);
    this.mMinSizeTextPaint.setTypeface(localTypeface);
  }

  private boolean isDefaultSizeTextOverflowing()
  {
    if ((TextUtils.isEmpty(this.mSearchText)) || (getWidth() == 0));
    while (this.mDefaultTextPaint.measureText(this.mSearchText.toString()) <= getWidth())
      return false;
    return true;
  }

  private boolean isMinSizeTextOverflowing()
  {
    if ((TextUtils.isEmpty(this.mSearchText)) || (getWidth() == 0));
    while (this.mMinSizeTextPaint.measureText(this.mSearchText.toString()) <= getWidth())
      return false;
    return true;
  }

  private void updateTextProperties()
  {
    if (!isDefaultSizeTextOverflowing())
    {
      setTextSize(0, this.mDefaultTextSize);
      setAutoShrink(false);
      setSingleLine();
      return;
    }
    if (isMinSizeTextOverflowing())
    {
      setTextSize(0, this.mSmallTextSize);
      setSingleLine(false);
      setAutoShrink(false);
      return;
    }
    setSingleLine();
    setAutoShrink(true);
  }

  public void clearLeftDrawable()
  {
    setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
  }

  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (!this.mEditable))
      updateTextProperties();
  }

  public void setAddressText(CharSequence paramCharSequence)
  {
    this.mSearchText = paramCharSequence;
    if (this.mEditable)
    {
      setTextSize(0, this.mDefaultTextSize);
      setAutoShrink(false);
      setSingleLine();
      setEllipsize(TextUtils.TruncateAt.END);
    }
    while (true)
    {
      setText(this.mSearchText);
      return;
      updateTextProperties();
    }
  }

  public void setEditable(boolean paramBoolean)
  {
    this.mEditable = paramBoolean;
  }

  public void setLeftDrawable(int paramInt)
  {
    setCompoundDrawablesWithIntrinsicBounds(paramInt, 0, 0, 0);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.address.AddressTextView
 * JD-Core Version:    0.6.2
 */