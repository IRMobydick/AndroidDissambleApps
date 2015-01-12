package com.ubercab.client.core.util;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;

public final class TextMarkupUtils
{
  private static final String MARKUP_TOKEN_BOLD = "**";

  public static CharSequence parseMarkup(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString));
    int i;
    int j;
    int k;
    do
    {
      do
      {
        return paramString;
        i = paramString.indexOf("**");
      }
      while (i < 0);
      j = "**".length();
      k = paramString.indexOf("**", i + j);
    }
    while (k < 0);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(paramString, 0, i);
    localSpannableStringBuilder.append(paramString, i + j, k);
    localSpannableStringBuilder.append(paramString, k + j, paramString.length());
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(paramInt), i, k - j, 18);
    return localSpannableStringBuilder;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.util.TextMarkupUtils
 * JD-Core Version:    0.6.2
 */