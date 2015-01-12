package com.google.android.gms.internal;

import android.util.Base64;

public final class js
{
  public static String d(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      return null;
    return Base64.encodeToString(paramArrayOfByte, 0);
  }

  public static String e(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      return null;
    return Base64.encodeToString(paramArrayOfByte, 10);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.js
 * JD-Core Version:    0.6.2
 */