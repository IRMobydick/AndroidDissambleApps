package com.google.android.gms.internal;

import java.security.MessageDigest;

public class ar extends ao
{
  private MessageDigest nP;

  byte[] a(String[] paramArrayOfString)
  {
    byte[] arrayOfByte = new byte[paramArrayOfString.length];
    for (int i = 0; i < paramArrayOfString.length; i++)
      arrayOfByte[i] = ((byte)(0xFF & aq.o(paramArrayOfString[i])));
    return arrayOfByte;
  }

  public byte[] l(String paramString)
  {
    byte[] arrayOfByte1 = a(paramString.split(" "));
    this.nP = ba();
    while (true)
    {
      byte[] arrayOfByte3;
      synchronized (this.mw)
      {
        if (this.nP == null)
        {
          byte[] arrayOfByte2 = new byte[0];
          return arrayOfByte2;
        }
        this.nP.reset();
        this.nP.update(arrayOfByte1);
        arrayOfByte3 = this.nP.digest();
        i = 4;
        if (arrayOfByte3.length > i)
        {
          byte[] arrayOfByte4 = new byte[i];
          System.arraycopy(arrayOfByte3, 0, arrayOfByte4, 0, arrayOfByte4.length);
          return arrayOfByte4;
        }
      }
      int i = arrayOfByte3.length;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ar
 * JD-Core Version:    0.6.2
 */