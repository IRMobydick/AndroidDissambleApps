package com.inauth.utilities.ndk;

import com.inauth.utilities.encryption.BouncyEncoding;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.zip.GZIPOutputStream;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;

public class NDKhelper
{
  public static byte[] pack(byte[] paramArrayOfByte)
  {
    BouncyEncoding localBouncyEncoding = new BouncyEncoding();
    try
    {
      localBouncyEncoding.setData(paramArrayOfByte);
      localBouncyEncoding.encrypt();
      label17: return localBouncyEncoding.getCipherData();
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label17;
    }
    catch (InvalidAlgorithmParameterException localInvalidAlgorithmParameterException)
    {
      break label17;
    }
    catch (BadPaddingException localBadPaddingException)
    {
      break label17;
    }
    catch (IllegalBlockSizeException localIllegalBlockSizeException)
    {
      break label17;
    }
    catch (ShortBufferException localShortBufferException)
    {
      break label17;
    }
    catch (NoSuchPaddingException localNoSuchPaddingException)
    {
      break label17;
    }
    catch (NoSuchProviderException localNoSuchProviderException)
    {
      break label17;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      break label17;
    }
    catch (InvalidKeyException localInvalidKeyException)
    {
      break label17;
    }
  }

  public static byte[] unpack(byte[] paramArrayOfByte)
  {
    BouncyEncoding localBouncyEncoding = new BouncyEncoding();
    localBouncyEncoding.setCipherData(paramArrayOfByte);
    try
    {
      byte[] arrayOfByte = localBouncyEncoding.decrypt();
      return arrayOfByte;
    }
    catch (InvalidKeyException localInvalidKeyException)
    {
      return null;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      return null;
    }
    catch (NoSuchProviderException localNoSuchProviderException)
    {
      return null;
    }
    catch (NoSuchPaddingException localNoSuchPaddingException)
    {
      return null;
    }
    catch (ShortBufferException localShortBufferException)
    {
      return null;
    }
    catch (IllegalBlockSizeException localIllegalBlockSizeException)
    {
      return null;
    }
    catch (BadPaddingException localBadPaddingException)
    {
      return null;
    }
    catch (InvalidAlgorithmParameterException localInvalidAlgorithmParameterException)
    {
      return null;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    return null;
  }

  public static byte[] zipit(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
      localGZIPOutputStream.write(paramArrayOfByte);
      localGZIPOutputStream.close();
      return localByteArrayOutputStream.toByteArray();
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.utilities.ndk.NDKhelper
 * JD-Core Version:    0.6.2
 */