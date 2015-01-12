package com.ubercab.payment.ui;

import android.content.Context;
import android.text.Selection;
import android.util.AttributeSet;
import android.widget.EditText;
import com.ubercab.payment.R.string;
import com.ubercab.payment.util.CreditCardUtils;

public final class CreditCardEditText extends EditText
{
  private boolean mIsValid;
  private String mLastNumber;
  private Listener mListener;

  public CreditCardEditText(Context paramContext)
  {
    this(paramContext, null);
  }

  public CreditCardEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842862);
  }

  public CreditCardEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setInputType(2);
    if (!isInEditMode())
      setHint(R.string.credit_card_number);
  }

  public boolean isValid()
  {
    return this.mIsValid;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mLastNumber = null;
    setText(getText());
  }

  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    String str1 = paramCharSequence.toString();
    if (str1.equals(this.mLastNumber))
      return;
    String str2 = CreditCardUtils.getType(str1);
    this.mIsValid = CreditCardUtils.isValidNumber(str2, str1);
    this.mLastNumber = CreditCardUtils.getFormattedNumber(str2, str1);
    Context localContext = getContext();
    if (localContext != null)
      setCompoundDrawablesWithIntrinsicBounds(CreditCardUtils.getImage(localContext, str2), null, null, null);
    if (this.mListener != null)
      this.mListener.onCreditCardNumberChanged(this, this.mIsValid, str2);
    setText(this.mLastNumber);
    if ((paramInt2 > 0) && (paramInt1 <= this.mLastNumber.length()));
    while (true)
    {
      setSelection(paramInt1);
      return;
      paramInt1 = this.mLastNumber.length();
    }
  }

  public void setListener(Listener paramListener)
  {
    this.mListener = paramListener;
  }

  public void setSelection(int paramInt)
  {
    Selection.setSelection(getText(), paramInt);
  }

  public static abstract interface Listener
  {
    public abstract void onCreditCardNumberChanged(CreditCardEditText paramCreditCardEditText, boolean paramBoolean, String paramString);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.payment.ui.CreditCardEditText
 * JD-Core Version:    0.6.2
 */