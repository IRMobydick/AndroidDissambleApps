package com.baidu.lbsapi.auth;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

class b
{
  protected static String a(Context paramContext)
  {
    String str1 = paramContext.getPackageName();
    String str2 = a(paramContext, str1);
    return str2 + ";" + str1;
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

  static String b(Context paramContext)
  {
    Object localObject;
    String str1;
    if (0 != 0)
    {
      boolean bool = "".equals(null);
      localObject = null;
      if (!bool);
    }
    else
    {
      str1 = paramContext.getSharedPreferences("mac", 0).getString("macaddr", null);
      if (str1 != null)
        break label122;
      String str2 = c(paramContext);
      localObject = null;
      if (str2 != null)
      {
        localObject = Base64.encodeToString(str2.getBytes(), 0);
        if (!TextUtils.isEmpty((CharSequence)localObject))
          paramContext.getSharedPreferences("mac", 0).edit().putString("macaddr", (String)localObject).commit();
      }
    }
    while (true)
    {
      if (a.a)
        a.a("getMacID mac_adress: " + (String)localObject);
      return localObject;
      label122: localObject = str1;
    }
  }

  private static boolean b(Context paramContext, String paramString)
  {
    if (paramContext.checkCallingOrSelfPermission(paramString) != -1);
    for (boolean bool = true; ; bool = false)
    {
      if (a.a)
        a.a("hasPermission " + bool + " | " + paramString);
      return bool;
    }
  }

  // ERROR //
  static String c(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 204
    //   3: invokestatic 206	com/baidu/lbsapi/auth/b:b	(Landroid/content/Context;Ljava/lang/String;)Z
    //   6: ifeq +85 -> 91
    //   9: aload_0
    //   10: ldc 208
    //   12: invokevirtual 212	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   15: checkcast 214	android/net/wifi/WifiManager
    //   18: invokevirtual 218	android/net/wifi/WifiManager:getConnectionInfo	()Landroid/net/wifi/WifiInfo;
    //   21: astore 4
    //   23: aload 4
    //   25: invokevirtual 223	android/net/wifi/WifiInfo:getMacAddress	()Ljava/lang/String;
    //   28: astore 5
    //   30: aload 5
    //   32: astore_2
    //   33: aload_2
    //   34: invokestatic 164	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   37: ifne +12 -> 49
    //   40: aload_2
    //   41: invokevirtual 152	java/lang/String:getBytes	()[B
    //   44: iconst_0
    //   45: invokestatic 227	android/util/Base64:encode	([BI)[B
    //   48: pop
    //   49: getstatic 183	com/baidu/lbsapi/auth/a:a	Z
    //   52: ifeq +37 -> 89
    //   55: iconst_2
    //   56: anewarray 4	java/lang/Object
    //   59: astore 6
    //   61: aload 6
    //   63: iconst_0
    //   64: aload 4
    //   66: invokevirtual 230	android/net/wifi/WifiInfo:getSSID	()Ljava/lang/String;
    //   69: aastore
    //   70: aload 6
    //   72: iconst_1
    //   73: aload 4
    //   75: invokevirtual 223	android/net/wifi/WifiInfo:getMacAddress	()Ljava/lang/String;
    //   78: aastore
    //   79: ldc 232
    //   81: aload 6
    //   83: invokestatic 236	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   86: invokestatic 188	com/baidu/lbsapi/auth/a:a	(Ljava/lang/String;)V
    //   89: aload_2
    //   90: areturn
    //   91: getstatic 183	com/baidu/lbsapi/auth/a:a	Z
    //   94: ifeq +8 -> 102
    //   97: ldc 238
    //   99: invokestatic 188	com/baidu/lbsapi/auth/a:a	(Ljava/lang/String;)V
    //   102: aconst_null
    //   103: areturn
    //   104: astore_1
    //   105: aconst_null
    //   106: astore_2
    //   107: aload_1
    //   108: astore_3
    //   109: getstatic 183	com/baidu/lbsapi/auth/a:a	Z
    //   112: ifeq -23 -> 89
    //   115: aload_3
    //   116: invokevirtual 239	java/lang/Exception:toString	()Ljava/lang/String;
    //   119: invokestatic 188	com/baidu/lbsapi/auth/a:a	(Ljava/lang/String;)V
    //   122: aload_2
    //   123: areturn
    //   124: astore_3
    //   125: goto -16 -> 109
    //
    // Exception table:
    //   from	to	target	type
    //   0	30	104	java/lang/Exception
    //   91	102	104	java/lang/Exception
    //   33	49	124	java/lang/Exception
    //   49	89	124	java/lang/Exception
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
 * Qualified Name:     com.baidu.lbsapi.auth.b
 * JD-Core Version:    0.6.2
 */