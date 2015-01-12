package com.braintreegateway.encryption;

import com.braintree.org.bouncycastle.util.encoders.Base64;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.util.ByteArrayBuffer;

public final class Aes
{
  private static final String ALGORITHM = "AES";
  public static final int IV_LENGTH = 16;
  public static final int KEY_LENGTH = 32;
  private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";

  private static Cipher aesCipher()
    throws BraintreeEncryptionException
  {
    try
    {
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      return localCipher;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new BraintreeEncryptionException("No Such Algorithm: " + localNoSuchAlgorithmException.getMessage());
    }
    catch (NoSuchPaddingException localNoSuchPaddingException)
    {
      throw new BraintreeEncryptionException("No Such Padding: " + localNoSuchPaddingException.getMessage());
    }
  }

  public static String encrypt(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws BraintreeEncryptionException
  {
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramArrayOfByte1, "AES");
    Cipher localCipher = aesCipher();
    try
    {
      localCipher.init(1, localSecretKeySpec, new IvParameterSpec(paramArrayOfByte2));
      byte[] arrayOfByte = localCipher.doFinal(paramString.getBytes());
      ByteArrayBuffer localByteArrayBuffer = new ByteArrayBuffer(arrayOfByte.length + paramArrayOfByte2.length);
      localByteArrayBuffer.append(paramArrayOfByte2, 0, paramArrayOfByte2.length);
      localByteArrayBuffer.append(arrayOfByte, 0, arrayOfByte.length);
      String str = new String(Base64.encode(localByteArrayBuffer.toByteArray()));
      return str;
    }
    catch (InvalidKeyException localInvalidKeyException)
    {
      throw new BraintreeEncryptionException("Invalid Key: " + localInvalidKeyException.getMessage());
    }
    catch (BadPaddingException localBadPaddingException)
    {
      throw new BraintreeEncryptionException("Bad Padding: " + localBadPaddingException.getMessage());
    }
    catch (IllegalBlockSizeException localIllegalBlockSizeException)
    {
      throw new BraintreeEncryptionException("Illegal Block Size: " + localIllegalBlockSizeException.getMessage());
    }
    catch (InvalidAlgorithmParameterException localInvalidAlgorithmParameterException)
    {
      throw new BraintreeEncryptionException("Invalid Algorithm: " + localInvalidAlgorithmParameterException.getMessage());
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.braintreegateway.encryption.Aes
 * JD-Core Version:    0.6.2
 */