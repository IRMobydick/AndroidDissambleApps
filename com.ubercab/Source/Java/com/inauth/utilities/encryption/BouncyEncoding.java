package com.inauth.utilities.encryption;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class BouncyEncoding
{
  private byte[] cipherData;
  private byte[] data = null;
  private String iv;
  private String secretKey;

  public BouncyEncoding()
  {
    this.secretKey = "~S.@*8Y7d(I%^Fj0v=^'4qMl!K]8zU.4";
    this.iv = "hqp%7!13a9@B.0Tj";
  }

  public BouncyEncoding(String paramString)
  {
    this.secretKey = paramString;
  }

  public byte[] decrypt()
    throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException, ShortBufferException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, UnsupportedEncodingException
  {
    Security.addProvider(new BouncyCastleProvider());
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(this.secretKey.getBytes("UTF-8"), "AES");
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
    localCipher.init(2, localSecretKeySpec, new IvParameterSpec(this.iv.getBytes()));
    return localCipher.doFinal(this.cipherData);
  }

  public void encrypt()
    throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException, ShortBufferException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, UnsupportedEncodingException
  {
    Security.addProvider(new BouncyCastleProvider());
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(this.secretKey.getBytes("UTF-8"), "AES");
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
    localCipher.init(1, localSecretKeySpec, new IvParameterSpec(this.iv.getBytes()));
    this.cipherData = localCipher.doFinal(this.data);
  }

  public byte[] getCipherData()
  {
    return this.cipherData;
  }

  public byte[] getData()
  {
    return this.data;
  }

  public String getString(byte[] paramArrayOfByte)
  {
    return Base64.encodeToString(paramArrayOfByte, 0);
  }

  public void setCipherData(byte[] paramArrayOfByte)
  {
    this.cipherData = paramArrayOfByte;
  }

  public void setData(byte[] paramArrayOfByte)
  {
    this.data = paramArrayOfByte;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.utilities.encryption.BouncyEncoding
 * JD-Core Version:    0.6.2
 */