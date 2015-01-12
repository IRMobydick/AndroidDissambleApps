package com.ubercab.webclient.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class StringUtils
{
  private static final String MD5 = "md5";

  public static String md5(String paramString)
  {
    try
    {
      byte[] arrayOfByte = MessageDigest.getInstance("md5").digest(paramString.getBytes());
      StringBuilder localStringBuilder = new StringBuilder();
      int i = arrayOfByte.length;
      for (int j = 0; j < i; j++)
        localStringBuilder.append(Integer.toHexString(0x100 | 0xFF & arrayOfByte[j]).substring(1, 3));
      String str = localStringBuilder.toString();
      return str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
    }
    return null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.webclient.utils.StringUtils
 * JD-Core Version:    0.6.2
 */