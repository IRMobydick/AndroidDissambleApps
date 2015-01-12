package com.ubercab.client.core.ui;

import com.google.i18n.phonenumbers.AsYouTypeFormatter;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberCountryTextWatcher extends PhoneNumberTextWatcher
{
  private Listener mListener;

  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    String str1 = null;
    PhoneNumberUtil localPhoneNumberUtil = PhoneNumberUtil.getInstance();
    AsYouTypeFormatter localAsYouTypeFormatter = localPhoneNumberUtil.getAsYouTypeFormatter(getCountryCode());
    for (int i = 0; i < paramCharSequence.length(); i++)
      str1 = localAsYouTypeFormatter.inputDigit(paramCharSequence.charAt(i));
    if (str1 == null);
    String str2;
    do
    {
      Matcher localMatcher;
      do
      {
        return;
        localMatcher = Pattern.compile("^\\+(\\d\\d?\\d?).*$").matcher(str1);
      }
      while (!localMatcher.matches());
      str2 = localPhoneNumberUtil.getRegionCodeForCountryCode(Integer.parseInt(localMatcher.group(1)));
    }
    while ((str2.equals("ZZ")) || (this.mListener == null));
    this.mListener.onPhoneTextWatcherCountryChanged(str2);
  }

  public void setListener(Listener paramListener)
  {
    this.mListener = paramListener;
  }

  public static abstract interface Listener
  {
    public abstract void onPhoneTextWatcherCountryChanged(String paramString);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.ui.PhoneNumberCountryTextWatcher
 * JD-Core Version:    0.6.2
 */