package net.photopay.base;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import net.photopay.recognition.Right;
import net.photopay.recognition.RightsManager;

final class llIIlIlIIl
{
  private static final byte[] IlIllIlIIl;
  private static final byte[] IllIIIllII;
  private static final byte[] llIIlIlIIl;

  static
  {
    byte[] arrayOfByte1 = new byte[20];
    arrayOfByte1[0] = -54;
    arrayOfByte1[1] = 1;
    arrayOfByte1[2] = -60;
    arrayOfByte1[3] = -19;
    arrayOfByte1[4] = 22;
    arrayOfByte1[5] = 117;
    arrayOfByte1[6] = -54;
    arrayOfByte1[7] = -31;
    arrayOfByte1[8] = 110;
    arrayOfByte1[9] = -122;
    arrayOfByte1[10] = -59;
    arrayOfByte1[11] = 24;
    arrayOfByte1[12] = 92;
    arrayOfByte1[13] = -118;
    arrayOfByte1[14] = -100;
    arrayOfByte1[15] = 37;
    arrayOfByte1[16] = 54;
    arrayOfByte1[17] = -122;
    arrayOfByte1[18] = -39;
    arrayOfByte1[19] = -44;
    llIIlIlIIl = arrayOfByte1;
    byte[] arrayOfByte2 = new byte[20];
    arrayOfByte2[0] = -15;
    arrayOfByte2[1] = -81;
    arrayOfByte2[2] = 75;
    arrayOfByte2[3] = 118;
    arrayOfByte2[4] = -61;
    arrayOfByte2[5] = 122;
    arrayOfByte2[6] = -40;
    arrayOfByte2[7] = -9;
    arrayOfByte2[8] = -62;
    arrayOfByte2[9] = 51;
    arrayOfByte2[10] = 13;
    arrayOfByte2[11] = 72;
    arrayOfByte2[12] = 123;
    arrayOfByte2[13] = -67;
    arrayOfByte2[14] = -109;
    arrayOfByte2[15] = -13;
    arrayOfByte2[16] = -95;
    arrayOfByte2[17] = 52;
    arrayOfByte2[18] = -18;
    arrayOfByte2[19] = -50;
    IlIllIlIIl = arrayOfByte2;
    byte[] arrayOfByte3 = new byte[20];
    arrayOfByte3[0] = -83;
    arrayOfByte3[1] = -95;
    arrayOfByte3[2] = -91;
    arrayOfByte3[3] = -117;
    arrayOfByte3[4] = -55;
    arrayOfByte3[5] = 61;
    arrayOfByte3[6] = -83;
    arrayOfByte3[7] = 32;
    arrayOfByte3[8] = -57;
    arrayOfByte3[9] = 84;
    arrayOfByte3[10] = -4;
    arrayOfByte3[11] = 72;
    arrayOfByte3[12] = -80;
    arrayOfByte3[13] = 16;
    arrayOfByte3[14] = 98;
    arrayOfByte3[15] = 72;
    arrayOfByte3[16] = 39;
    arrayOfByte3[17] = -18;
    arrayOfByte3[18] = -93;
    arrayOfByte3[19] = 116;
    IllIIIllII = arrayOfByte3;
  }

  private static boolean llIIlIlIIl(Object paramObject)
  {
    int i = 0;
    String str = paramObject.getClass().getName();
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      localMessageDigest.update(str.getBytes("iso-8859-1"), 0, str.length());
      byte[] arrayOfByte = localMessageDigest.digest();
      if ((!llIIlIlIIl(arrayOfByte, IllIIIllII)) && (!llIIlIlIIl(arrayOfByte, llIIlIlIIl)))
      {
        boolean bool = llIIlIlIIl(arrayOfByte, IlIllIlIIl);
        if (!bool);
      }
      else
      {
        i = 1;
      }
      return i;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      while (true)
        localNoSuchAlgorithmException.printStackTrace();
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      while (true)
        localUnsupportedEncodingException.printStackTrace();
    }
  }

  static boolean llIIlIlIIl(RightsManager paramRightsManager, Object paramObject)
  {
    boolean bool;
    if (paramRightsManager.lIllIIlIIl())
      if (paramRightsManager.llIIlIlIIl(Right.llIIlIlIIl))
        bool = true;
    while (true)
    {
      return bool;
      bool = llIIlIlIIl(paramObject);
      continue;
      bool = false;
    }
  }

  private static boolean llIIlIlIIl(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = 0;
    if (paramArrayOfByte1.length != paramArrayOfByte2.length);
    while (true)
    {
      return i;
      for (int j = 0; ; j++)
      {
        if (j >= paramArrayOfByte1.length)
          break label34;
        if (paramArrayOfByte1[j] != paramArrayOfByte2[j])
          break;
      }
      label34: i = 1;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.base.llIIlIlIIl
 * JD-Core Version:    0.6.0
 */