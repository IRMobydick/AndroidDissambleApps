package com.inauth.utilities.ndk;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class InAuthNDK
{
  private static InAuthNDK instance;

  static
  {
    System.loadLibrary("InauthMMENDK");
  }

  private synchronized native byte[] dynamicID2(String paramString);

  public static InAuthNDK getInstance()
  {
    if (instance == null)
      instance = new InAuthNDK();
    return instance;
  }

  private synchronized native int getMalwareReasonCode();

  private synchronized native int getReasonCode();

  private synchronized native int getRootReasonCode();

  private synchronized native byte[] inAuthPullNDK(String paramString);

  private synchronized native byte[] inAuthPullNDK(byte[] paramArrayOfByte);

  private synchronized native int inAuthStoreNDK(String paramString1, String paramString2);

  private synchronized native int inAuthStoreNDKbyte(byte[] paramArrayOfByte, String paramString);

  private synchronized native byte[] inAuthmwNDK(String paramString);

  private synchronized native byte[] inAuthrootNDK(String paramString);

  private synchronized native byte[] inauthIdNDK(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);

  private synchronized native byte[] inauthPacking(byte[] paramArrayOfByte);

  public byte[] NDKPacking(byte[] paramArrayOfByte)
    throws IOException
  {
    byte[] arrayOfByte = inauthPacking(NDKhelper.pack(paramArrayOfByte));
    if (arrayOfByte == null)
      arrayOfByte = null;
    return arrayOfByte;
  }

  public String getDynamicIDNDK(String paramString)
  {
    byte[] arrayOfByte = dynamicID2(paramString);
    if (arrayOfByte == null)
      return null;
    try
    {
      String str = new String(arrayOfByte, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    return null;
  }

  public int getMalwareReturnCodeNDK()
  {
    return getMalwareReasonCode();
  }

  public int getReturnCodeNDK()
  {
    return getReasonCode();
  }

  public int getRootReturnCodeNDK()
  {
    return getRootReasonCode();
  }

  public String inAuthMW(String paramString)
  {
    byte[] arrayOfByte = inAuthmwNDK(paramString);
    if (arrayOfByte == null)
      return null;
    try
    {
      String str = new String(arrayOfByte, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    return null;
  }

  public byte[] inAuthPull(String paramString)
  {
    return inAuthPullNDK(paramString);
  }

  public byte[] inAuthPull(byte[] paramArrayOfByte)
  {
    return inAuthPullNDK(paramArrayOfByte);
  }

  public int inAuthStore(String paramString1, String paramString2)
  {
    return inAuthStoreNDK(paramString1, paramString2);
  }

  public int inAuthStore(byte[] paramArrayOfByte, String paramString)
  {
    return inAuthStoreNDKbyte(paramArrayOfByte, paramString);
  }

  public String inAuthroot(String paramString)
  {
    byte[] arrayOfByte = inAuthrootNDK(paramString);
    if (arrayOfByte == null)
      return null;
    try
    {
      String str = new String(arrayOfByte, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    return null;
  }

  public byte[] inauthid(String paramString1, String paramString2)
  {
    if (paramString1 == null)
      paramString1 = "inauth";
    byte[] arrayOfByte1 = null;
    if (paramString1 != null);
    try
    {
      arrayOfByte1 = paramString1.getBytes("UTF-8");
      Object localObject = null;
      if (paramString2 != null)
      {
        String[] arrayOfString = paramString2.split(":");
        String str1 = "";
        int i = arrayOfString.length;
        for (int j = 0; j < i; j++)
        {
          String str2 = arrayOfString[j];
          str1 = str1 + str2;
        }
        byte[] arrayOfByte2 = str1.getBytes("UTF-8");
        localObject = arrayOfByte2;
      }
      return inauthIdNDK(arrayOfByte1, localObject);
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    return null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.utilities.ndk.InAuthNDK
 * JD-Core Version:    0.6.2
 */