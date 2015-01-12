package com.ubercab.payment.ui;

import android.content.Context;
import android.graphics.Rect;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.AttributeSet;
import android.widget.EditText;
import com.ubercab.payment.R.string;
import com.ubercab.payment.util.CreditCardUtils;

public class SecurityCodeEditText extends EditText
{
  private String mCardType;
  private boolean mIsValid;
  private String mLastCvv;
  private Listener mListener;

  public SecurityCodeEditText(Context paramContext)
  {
    this(paramContext, null);
  }

  public SecurityCodeEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842862);
  }

  public SecurityCodeEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public boolean isValid()
  {
    return this.mIsValid;
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    setInputType(2);
    if (!isInEditMode())
      setHint(R.string.security_code_abbr);
  }

  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if (paramBoolean)
      setText(null);
  }

  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    String str = paramCharSequence.toString();
    if (str.equals(this.mLastCvv))
      return;
    int i = CreditCardUtils.getMaxLengthCvc(this.mCardType);
    if (str.length() > i)
      str = str.substring(0, i);
    this.mIsValid = CreditCardUtils.isValidCvc(this.mCardType, str);
    this.mLastCvv = str;
    if (this.mListener != null)
      this.mListener.onCreditCardCodeChanged(this, this.mIsValid);
    setText(str);
    if ((paramInt2 > 0) && (paramInt1 <= this.mLastCvv.length()));
    while (true)
    {
      setSelection(paramInt1);
      return;
      paramInt1 = this.mLastCvv.length();
    }
  }

  public void setCardType(String paramString)
  {
    this.mCardType = paramString;
    InputFilter[] arrayOfInputFilter = new InputFilter[1];
    arrayOfInputFilter[0] = new InputFilter.LengthFilter(CreditCardUtils.getMaxLengthCvc(paramString));
    setFilters(arrayOfInputFilter);
  }

  public void setListener(Listener paramListener)
  {
    this.mListener = paramListener;
  }

  public static abstract interface Listener
  {
    public abstract void onCreditCardCodeChanged(SecurityCodeEditText paramSecurityCodeEditText, boolean paramBoolean);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.payment.ui.SecurityCodeEditText
 * JD-Core Version:    0.6.2
 */