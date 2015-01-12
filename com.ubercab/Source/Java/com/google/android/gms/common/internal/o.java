package com.google.android.gms.common.internal;

import android.os.Looper;
import android.text.TextUtils;

public final class o
{
  public static void I(boolean paramBoolean)
  {
    if (!paramBoolean)
      throw new IllegalStateException();
  }

  public static void K(boolean paramBoolean)
  {
    if (!paramBoolean)
      throw new IllegalArgumentException();
  }

  public static void a(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean)
      throw new IllegalStateException(String.valueOf(paramObject));
  }

  public static void a(boolean paramBoolean, String paramString, Object[] paramArrayOfObject)
  {
    if (!paramBoolean)
      throw new IllegalStateException(String.format(paramString, paramArrayOfObject));
  }

  public static void aT(String paramString)
  {
    if (Looper.myLooper() != Looper.getMainLooper())
      throw new IllegalStateException(paramString);
  }

  public static void aU(String paramString)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
      throw new IllegalStateException(paramString);
  }

  public static String aZ(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      throw new IllegalArgumentException("Given String is empty or null");
    return paramString;
  }

  public static <T> T b(T paramT, Object paramObject)
  {
    if (paramT == null)
      throw new NullPointerException(String.valueOf(paramObject));
    return paramT;
  }

  public static String b(String paramString, Object paramObject)
  {
    if (TextUtils.isEmpty(paramString))
      throw new IllegalArgumentException(String.valueOf(paramObject));
    return paramString;
  }

  public static void b(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean)
      throw new IllegalArgumentException(String.valueOf(paramObject));
  }

  public static void b(boolean paramBoolean, String paramString, Object[] paramArrayOfObject)
  {
    if (!paramBoolean)
      throw new IllegalArgumentException(String.format(paramString, paramArrayOfObject));
  }

  public static <T> T i(T paramT)
  {
    if (paramT == null)
      throw new NullPointerException("null reference");
    return paramT;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.o
 * JD-Core Version:    0.6.2
 */