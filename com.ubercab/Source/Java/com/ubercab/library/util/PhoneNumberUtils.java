package com.ubercab.library.util;

import android.text.TextUtils;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import java.util.Locale;

public final class PhoneNumberUtils
{
  public static String getCountryIso2ForPhoneNumber(String paramString1, String paramString2)
  {
    try
    {
      PhoneNumberUtil localPhoneNumberUtil = PhoneNumberUtil.getInstance();
      String str = localPhoneNumberUtil.getRegionCodeForCountryCode(localPhoneNumberUtil.parse(paramString1, paramString2).getCountryCode());
      boolean bool = str.equals("ZZ");
      if (!bool)
        return str;
    }
    catch (NumberParseException localNumberParseException)
    {
    }
    return null;
  }

  public static String getDisplayPhoneNumber(String paramString1, String paramString2)
  {
    try
    {
      String str1 = Locale.getDefault().getCountry().toUpperCase(Locale.US);
      if (TextUtils.isEmpty(paramString2));
      PhoneNumberUtil localPhoneNumberUtil;
      Phonenumber.PhoneNumber localPhoneNumber;
      for (String str2 = str1; ; str2 = paramString2.toUpperCase(Locale.US))
      {
        localPhoneNumberUtil = PhoneNumberUtil.getInstance();
        localPhoneNumber = localPhoneNumberUtil.parse(paramString1, str2);
        if (!str2.equals(str1))
          break;
        return localPhoneNumberUtil.format(localPhoneNumber, PhoneNumberUtil.PhoneNumberFormat.NATIONAL);
      }
      String str3 = localPhoneNumberUtil.format(localPhoneNumber, PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL);
      return str3;
    }
    catch (NumberParseException localNumberParseException)
    {
    }
    return paramString1;
  }

  public static String getE164PhoneNumber(String paramString1, String paramString2)
  {
    try
    {
      if (TextUtils.isEmpty(paramString2))
        paramString2 = Locale.getDefault().getCountry();
      String str1 = paramString2.toUpperCase(Locale.US);
      PhoneNumberUtil localPhoneNumberUtil = PhoneNumberUtil.getInstance();
      String str2 = localPhoneNumberUtil.format(localPhoneNumberUtil.parse(paramString1, str1), PhoneNumberUtil.PhoneNumberFormat.E164);
      return str2;
    }
    catch (NumberParseException localNumberParseException)
    {
    }
    return paramString1;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.util.PhoneNumberUtils
 * JD-Core Version:    0.6.2
 */