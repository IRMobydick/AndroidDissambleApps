package com.mobileapptracker;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Encryption
{
  private IvParameterSpec a;
  private SecretKeySpec b;
  private Cipher c;

  public Encryption(String paramString1, String paramString2)
  {
    this.a = new IvParameterSpec(paramString2.getBytes());
    this.b = new SecretKeySpec(paramString1.getBytes(), "AES");
    try
    {
      this.c = Cipher.getInstance("AES/CBC/NoPadding");
      return;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      localNoSuchAlgorithmException.printStackTrace();
      return;
    }
    catch (NoSuchPaddingException localNoSuchPaddingException)
    {
      localNoSuchPaddingException.printStackTrace();
    }
  }

  private static String a(String paramString)
  {
    int i = 16 - paramString.length() % 16;
    for (int j = 0; j < i; j++)
      paramString = paramString + ' ';
    return paramString;
  }

  public static String bytesToHex(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      str = null;
      return str;
    }
    int i = paramArrayOfByte.length;
    String str = "";
    int j = 0;
    label16: if (j < i)
      if ((0xFF & paramArrayOfByte[j]) >= 16)
        break label72;
    label72: for (str = str + "0" + Integer.toHexString(0xFF & paramArrayOfByte[j]); ; str = str + Integer.toHexString(0xFF & paramArrayOfByte[j]))
    {
      j++;
      break label16;
      break;
    }
  }

  public static byte[] hexToBytes(String paramString)
  {
    byte[] arrayOfByte = null;
    if (paramString == null);
    while (true)
    {
      return arrayOfByte;
      int i = paramString.length();
      arrayOfByte = null;
      if (i >= 2)
      {
        int j = paramString.length() / 2;
        arrayOfByte = new byte[j];
        for (int k = 0; k < j; k++)
          arrayOfByte[k] = ((byte)Integer.parseInt(paramString.substring(k * 2, 2 + k * 2), 16));
      }
    }
  }

  public static String md5(String paramString)
  {
    if (paramString == null)
      return "";
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes());
      String str = bytesToHex(localMessageDigest.digest());
      return str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      localNoSuchAlgorithmException.printStackTrace();
    }
    return "";
  }

  public static String sha1(String paramString)
  {
    if (paramString == null)
      return "";
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      localMessageDigest.update(paramString.getBytes());
      String str = bytesToHex(localMessageDigest.digest());
      return str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      localNoSuchAlgorithmException.printStackTrace();
    }
    return "";
  }

  public static String sha256(String paramString)
  {
    if (paramString == null)
      return "";
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-256");
      localMessageDigest.update(paramString.getBytes());
      String str = bytesToHex(localMessageDigest.digest());
      return str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      localNoSuchAlgorithmException.printStackTrace();
    }
    return "";
  }

  public byte[] decrypt(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      throw new Exception("Empty string");
    try
    {
      this.c.init(2, this.b, this.a);
      byte[] arrayOfByte = this.c.doFinal(hexToBytes(paramString));
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      throw new Exception("[decrypt] " + localException.getMessage());
    }
  }

  public byte[] encrypt(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      throw new Exception("Empty string");
    try
    {
      this.c.init(1, this.b, this.a);
      byte[] arrayOfByte = this.c.doFinal(a(paramString).getBytes());
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      throw new Exception("[encrypt] " + localException.getMessage());
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.mobileapptracker.Encryption
 * JD-Core Version:    0.6.2
 */