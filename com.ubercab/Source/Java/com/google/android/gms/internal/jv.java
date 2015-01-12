package com.google.android.gms.internal;

import android.database.CharArrayBuffer;

public final class jv
{
  public static void b(String paramString, CharArrayBuffer paramCharArrayBuffer)
  {
    if ((paramCharArrayBuffer.data == null) || (paramCharArrayBuffer.data.length < paramString.length()))
      paramCharArrayBuffer.data = paramString.toCharArray();
    while (true)
    {
      paramCharArrayBuffer.sizeCopied = paramString.length();
      return;
      paramString.getChars(0, paramString.length(), paramCharArrayBuffer.data, 0);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jv
 * JD-Core Version:    0.6.2
 */