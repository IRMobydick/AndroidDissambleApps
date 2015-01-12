package com.ubercab.library.util;

public final class UberUtils
{
  public static String encryptLoginPassword(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (int i = 0; i < paramString.length(); i++)
      localStringBuilder.append(StringUtils.md5(Character.toString(paramString.charAt(i))));
    return StringUtils.md5(localStringBuilder.toString());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.util.UberUtils
 * JD-Core Version:    0.6.2
 */