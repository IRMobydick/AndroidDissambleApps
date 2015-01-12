package com.ubercab.library.util;

import android.text.TextUtils;
import android.util.Patterns;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringUtils
{
  public static boolean isEmailAddress(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (Patterns.EMAIL_ADDRESS.matcher(paramString).matches());
  }

  public static String md5(String paramString)
  {
    if (paramString == null)
      return "";
    return md5(paramString.getBytes());
  }

  public static String md5(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      return "";
    try
    {
      byte[] arrayOfByte = MessageDigest.getInstance("MD5").digest(new String(paramArrayOfByte).getBytes("UTF-8"));
      StringBuilder localStringBuilder = new StringBuilder();
      for (int i = 0; i < arrayOfByte.length; i++)
        localStringBuilder.append(Integer.toHexString(0x100 | 0xFF & arrayOfByte[i]).substring(1, 3));
      String str = localStringBuilder.toString();
      return str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      return "";
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    return "";
  }

  public static String trimPeriod(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return "";
    return paramString.replaceAll("\\.$", "");
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.util.StringUtils
 * JD-Core Version:    0.6.2
 */