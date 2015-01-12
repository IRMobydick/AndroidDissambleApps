package com.baidu.location.b.a;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class c
{
  public static String a(byte[] paramArrayOfByte, String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramArrayOfByte.length;
    for (int j = 0; j < i; j++)
    {
      String str = Integer.toHexString(0xFF & paramArrayOfByte[j]);
      if (paramBoolean)
        str = str.toUpperCase();
      if (str.length() == 1)
        localStringBuilder.append("0");
      localStringBuilder.append(str).append(paramString);
    }
    return localStringBuilder.toString();
  }

  public static String a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.reset();
      localMessageDigest.update(paramArrayOfByte);
      String str = a(localMessageDigest.digest(), "", paramBoolean);
      return str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new RuntimeException(localNoSuchAlgorithmException);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.b.a.c
 * JD-Core Version:    0.6.2
 */