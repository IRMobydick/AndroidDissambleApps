package com.baidu.android.bbalbs.common.a;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class a
{
  public static byte[] a(String paramString1, String paramString2, byte[] paramArrayOfByte)
    throws Exception
  {
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramString2.getBytes(), "AES");
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    localCipher.init(1, localSecretKeySpec, new IvParameterSpec(paramString1.getBytes()));
    return localCipher.doFinal(paramArrayOfByte);
  }

  public static byte[] b(String paramString1, String paramString2, byte[] paramArrayOfByte)
    throws Exception
  {
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramString2.getBytes(), "AES");
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    localCipher.init(2, localSecretKeySpec, new IvParameterSpec(paramString1.getBytes()));
    return localCipher.doFinal(paramArrayOfByte);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.android.bbalbs.common.a.a
 * JD-Core Version:    0.6.2
 */