package com.baidu.location;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Bundle;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class v
{
  public static String a(Context paramContext)
  {
    String str1 = paramContext.getPackageName();
    Object localObject = null;
    try
    {
      localObject = paramContext.getPackageManager().getApplicationInfo(str1, 128).metaData.getString("com.baidu.lbsapi.API_KEY");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        String str2 = Pattern.compile("[&=]").matcher((CharSequence)localObject).replaceAll("");
        localObject = str2;
      }
      return localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return localObject;
  }

  private static String a(Context paramContext, String paramString)
  {
    StringBuffer localStringBuffer;
    try
    {
      Signature[] arrayOfSignature = paramContext.getPackageManager().getPackageInfo(paramString, 64).signatures;
      String str2 = a((X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(arrayOfSignature[0].toByteArray())));
      str1 = str2;
      localStringBuffer = new StringBuffer();
      for (int i = 0; i < str1.length(); i++)
      {
        localStringBuffer.append(str1.charAt(i));
        if ((i > 0) && (i % 2 == 1) && (i < -1 + str1.length()))
          localStringBuffer.append(":");
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
        str1 = "";
    }
    catch (CertificateException localCertificateException)
    {
      while (true)
        String str1 = "";
    }
    return localStringBuffer.toString();
  }

  static String a(X509Certificate paramX509Certificate)
  {
    try
    {
      String str = a.a(a(paramX509Certificate.getEncoded()));
      return str;
    }
    catch (CertificateEncodingException localCertificateEncodingException)
    {
    }
    return null;
  }

  static byte[] a(byte[] paramArrayOfByte)
  {
    try
    {
      byte[] arrayOfByte = MessageDigest.getInstance("SHA1").digest(paramArrayOfByte);
      return arrayOfByte;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
    }
    return null;
  }

  public static String jdMethod_if(Context paramContext)
  {
    String str1 = paramContext.getPackageName();
    String str2 = a(paramContext, str1);
    return str2 + ";" + str1;
  }

  static class a
  {
    public static String a(byte[] paramArrayOfByte)
    {
      char[] arrayOfChar = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
      StringBuilder localStringBuilder = new StringBuilder(2 * paramArrayOfByte.length);
      for (int i = 0; i < paramArrayOfByte.length; i++)
      {
        localStringBuilder.append(arrayOfChar[((0xF0 & paramArrayOfByte[i]) >> 4)]);
        localStringBuilder.append(arrayOfChar[(0xF & paramArrayOfByte[i])]);
      }
      return localStringBuilder.toString();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.v
 * JD-Core Version:    0.6.2
 */