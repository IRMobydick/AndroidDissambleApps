package com.ubercab.client.core.util;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;

public final class CharacterUtils
{
  public static String capitalizeFirstLetter(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return paramString;
    if (paramString.length() == 1)
      return paramString.toUpperCase();
    return Character.toUpperCase(paramString.charAt(0)) + paramString.substring(1);
  }

  public static CharSequence convertToUpperCase(CharSequence paramCharSequence)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramCharSequence);
    for (int i = 0; i < paramCharSequence.length(); i++)
    {
      char c = paramCharSequence.charAt(i);
      if (Character.isLowerCase(c))
        localSpannableStringBuilder.replace(i, i + 1, String.valueOf(Character.toUpperCase(c)));
    }
    return localSpannableStringBuilder;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.util.CharacterUtils
 * JD-Core Version:    0.6.2
 */