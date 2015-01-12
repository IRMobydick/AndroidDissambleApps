package com.ubercab.client.core.util;

import android.text.TextUtils;

public final class NumberUtils
{
  public static double tryParseDouble(String paramString, double paramDouble)
  {
    if (TextUtils.isEmpty(paramString))
      return paramDouble;
    try
    {
      double d = Double.parseDouble(paramString);
      return d;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return paramDouble;
  }

  public static float tryParseFloat(String paramString, float paramFloat)
  {
    if (TextUtils.isEmpty(paramString))
      return paramFloat;
    try
    {
      float f = Float.parseFloat(paramString);
      return f;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return paramFloat;
  }

  public static int tryParseInteger(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
      return paramInt;
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return paramInt;
  }

  public static long tryParseLong(String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString))
      return paramLong;
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return paramLong;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.util.NumberUtils
 * JD-Core Version:    0.6.2
 */