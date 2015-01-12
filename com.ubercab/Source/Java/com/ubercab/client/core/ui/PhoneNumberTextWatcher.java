package com.ubercab.client.core.ui;

import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import com.google.i18n.phonenumbers.AsYouTypeFormatter;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.ubercab.common.base.Preconditions;
import java.util.Locale;

public class PhoneNumberTextWatcher
  implements TextWatcher
{
  private String mCountryCode;
  private AsYouTypeFormatter mFormatter;
  private boolean mSelfChange = false;
  private boolean mStopFormatting;

  public PhoneNumberTextWatcher()
  {
    this(Locale.getDefault().getCountry());
  }

  public PhoneNumberTextWatcher(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    this.mFormatter = PhoneNumberUtil.getInstance().getAsYouTypeFormatter(paramString);
    this.mCountryCode = paramString;
  }

  private String getFormattedNumber(char paramChar, boolean paramBoolean)
  {
    if (paramBoolean)
      return this.mFormatter.inputDigitAndRememberPosition(paramChar);
    return this.mFormatter.inputDigit(paramChar);
  }

  private boolean hasSeparator(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    for (int i = paramInt1; i < paramInt1 + paramInt2; i++)
      if (!PhoneNumberUtils.isNonSeparator(paramCharSequence.charAt(i)))
        return true;
    return false;
  }

  private String reformat(CharSequence paramCharSequence, int paramInt)
  {
    int i = paramInt - 1;
    String str = null;
    this.mFormatter.clear();
    char c1 = '\000';
    boolean bool = false;
    int j = paramCharSequence.length();
    for (int k = 0; k < j; k++)
    {
      char c2 = paramCharSequence.charAt(k);
      if (PhoneNumberUtils.isNonSeparator(c2))
      {
        if (c1 != 0)
        {
          str = getFormattedNumber(c1, bool);
          bool = false;
        }
        c1 = c2;
      }
      if (k == i)
        bool = true;
    }
    if (c1 != 0)
      str = getFormattedNumber(c1, bool);
    return str;
  }

  private void stopFormatting()
  {
    this.mStopFormatting = true;
    this.mFormatter.clear();
  }

  public void afterTextChanged(Editable paramEditable)
  {
    boolean bool = true;
    try
    {
      if (this.mStopFormatting)
        if (paramEditable.length() != 0)
          this.mStopFormatting = bool;
      while (true)
      {
        return;
        bool = false;
        break;
        if (!this.mSelfChange)
        {
          String str = reformat(paramEditable, Selection.getSelectionEnd(paramEditable));
          if (str != null)
          {
            int i = this.mFormatter.getRememberedPosition();
            this.mSelfChange = true;
            paramEditable.replace(0, paramEditable.length(), str, 0, str.length());
            if (str.equals(paramEditable.toString()))
              Selection.setSelection(paramEditable, i);
            this.mSelfChange = false;
          }
        }
      }
    }
    finally
    {
    }
  }

  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.mSelfChange) || (this.mStopFormatting));
    while ((paramInt2 <= 0) || (!hasSeparator(paramCharSequence, paramInt1, paramInt2)))
      return;
    stopFormatting();
  }

  public String getCountryCode()
  {
    return this.mCountryCode;
  }

  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.mSelfChange) || (this.mStopFormatting));
    while ((paramInt3 <= 0) || (!hasSeparator(paramCharSequence, paramInt1, paramInt3)))
      return;
    stopFormatting();
  }

  public void setCountryCode(String paramString)
  {
    this.mFormatter.clear();
    this.mFormatter = PhoneNumberUtil.getInstance().getAsYouTypeFormatter(paramString);
    this.mCountryCode = paramString;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.ui.PhoneNumberTextWatcher
 * JD-Core Version:    0.6.2
 */