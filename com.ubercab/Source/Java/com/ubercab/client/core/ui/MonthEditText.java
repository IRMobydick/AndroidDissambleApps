package com.ubercab.client.core.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.ubercab.client.core.app.RiderApplication;
import com.ubercab.ui.UberEditText;

public class MonthEditText extends UberEditText
{
  private boolean mIsValid;
  private String mLastMonth;
  private Listener mListener;

  public MonthEditText(Context paramContext)
  {
    this(paramContext, null);
  }

  public MonthEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842862);
  }

  public MonthEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (!isInEditMode())
      RiderApplication.get(paramContext).inject(this);
    setInputType(2);
    setHint(paramContext.getString(2131558989));
  }

  public boolean isValid()
  {
    return this.mIsValid;
  }

  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    String str = paramCharSequence.toString();
    if (str.equals(this.mLastMonth))
      return;
    if (str.length() > 2)
      str = str.substring(0, 2);
    try
    {
      int i = Integer.parseInt(paramCharSequence.toString());
      if ((i > 0) && (i <= 12));
      for (boolean bool = true; ; bool = false)
      {
        this.mIsValid = bool;
        this.mLastMonth = str;
        if (this.mListener != null)
          this.mListener.onMonthChanged(this, this.mIsValid);
        setText(str);
        if ((paramInt2 <= 0) || (paramInt1 > this.mLastMonth.length()))
          break;
        setSelection(paramInt1);
        return;
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        this.mIsValid = false;
        continue;
        paramInt1 = this.mLastMonth.length();
      }
    }
  }

  public void setListener(Listener paramListener)
  {
    this.mListener = paramListener;
  }

  public static abstract interface Listener
  {
    public abstract void onMonthChanged(MonthEditText paramMonthEditText, boolean paramBoolean);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.ui.MonthEditText
 * JD-Core Version:    0.6.2
 */