package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.Locale;

public final class ik
{
  public static <T> boolean a(T paramT1, T paramT2)
  {
    return ((paramT1 == null) && (paramT2 == null)) || ((paramT1 != null) && (paramT2 != null) && (paramT1.equals(paramT2)));
  }

  public static void aF(String paramString)
    throws IllegalArgumentException
  {
    if (TextUtils.isEmpty(paramString))
      throw new IllegalArgumentException("Namespace cannot be null or empty");
    if (paramString.length() > 128)
      throw new IllegalArgumentException("Invalid namespace length");
    if (!paramString.startsWith("urn:x-cast:"))
      throw new IllegalArgumentException("Namespace must begin with the prefix \"urn:x-cast:\"");
    if (paramString.length() == "urn:x-cast:".length())
      throw new IllegalArgumentException("Namespace must begin with the prefix \"urn:x-cast:\" and have non-empty suffix");
  }

  public static String aG(String paramString)
  {
    return "urn:x-cast:" + paramString;
  }

  public static long b(double paramDouble)
  {
    return ()(1000.0D * paramDouble);
  }

  public static String b(Locale paramLocale)
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

  public static double o(long paramLong)
  {
    return paramLong / 1000.0D;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ik
 * JD-Core Version:    0.6.2
 */