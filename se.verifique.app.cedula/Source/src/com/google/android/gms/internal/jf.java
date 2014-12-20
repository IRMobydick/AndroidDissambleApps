package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.Locale;

public final class jf
{
  public static String a(Locale paramLocale)
  {
    StringBuilder localStringBuilder = new StringBuilder(20);
    localStringBuilder.append(paramLocale.getLanguage());
    String str1 = paramLocale.getCountry();
    if (!TextUtils.isEmpty(str1))
      localStringBuilder.append('-').append(str1);
    String str2 = paramLocale.getVariant();
    if (!TextUtils.isEmpty(str2))
      localStringBuilder.append('-').append(str2);
    return localStringBuilder.toString();
  }

  public static boolean a(Object paramObject1, Object paramObject2)
  {
    if (((paramObject1 == null) && (paramObject2 == null)) || ((paramObject1 != null) && (paramObject2 != null) && (paramObject1.equals(paramObject2))));
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jf
 * JD-Core Version:    0.6.0
 */