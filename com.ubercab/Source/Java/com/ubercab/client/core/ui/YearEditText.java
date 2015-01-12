package com.ubercab.client.core.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.ubercab.client.core.app.RiderApplication;
import com.ubercab.ui.UberEditText;

public class YearEditText extends UberEditText
{
  private boolean mIsValid;
  private String mLastYear;
  private Listener mListener;

  public YearEditText(Context paramContext)
  {
    this(paramContext, null);
  }

  public YearEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842862);
  }

  public YearEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (!isInEditMode())
      RiderApplication.get(paramContext).inject(this);
    setInputType(2);
    setHint(paramContext.getString(2131558991));
  }

  public boolean isValid()
  {
    return this.mIsValid;
  }

  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    String str = paramCharSequence.toString();
    if (str.equals(this.mLastYear))
      return;
    if (str.length() > 2)
      str = str.substring(0, 2);
    try
    {
      if (Integer.parseInt(paramCharSequence.toString()) > 0);
      for (boolean bool = true; ; bool = false)
      {
        this.mIsValid = bool;
        this.mLastYear = str;
        if (this.mListener != null)
          this.mListener.onYearChanged(this, this.mIsValid);
        setText(str);
        if ((paramInt2 <= 0) || (paramInt1 > this.mLastYear.length()))
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
        paramInt1 = this.mLastYear.length();
      }
    }
  }

  public void setListener(Listener paramListener)
  {
    this.mListener = paramListener;
  }

  public static abstract interface Listener
  {
    public abstract void onYearChanged(YearEditText paramYearEditText, boolean paramBoolean);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.ui.YearEditText
 * JD-Core Version:    0.6.2
 */