package com.baidu.location;

import com.baidu.location.b.b.b;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class CommonEncrypt
{
  public static boolean a;

  static
  {
    try
    {
      System.loadLibrary("locSDK4d");
      a = true;
      a = true;
      return;
    }
    catch (Exception localException)
    {
      while (true)
        a = false;
    }
  }

  public static String a(String paramString)
  {
    if (!a)
      return null;
    String str1 = a(encrypt(paramString.getBytes()));
    try
    {
      String str2 = URLEncoder.encode(str1, "UTF-8");
      return str2;
    }
    catch (Exception localException)
    {
    }
    return "";
  }

  public static String a(byte[] paramArrayOfByte)
  {
    try
    {
      String str = b.a(paramArrayOfByte, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    return "";
  }

  public static native byte[] encrypt(byte[] paramArrayOfByte);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.CommonEncrypt
 * JD-Core Version:    0.6.2
 */