package com.google.android.gms.internal;

import java.io.IOException;

class nz
  implements nw
{
  private no a;
  private byte[] b;
  private final int c;

  public nz(int paramInt)
  {
    this.c = paramInt;
    a();
  }

  public void a()
  {
    this.b = new byte[this.c];
    this.a = no.a(this.b);
  }

  public void a(int paramInt, long paramLong)
  {
    this.a.a(paramInt, paramLong);
  }

  public void a(int paramInt, String paramString)
  {
    this.a.a(paramInt, paramString);
  }

  public byte[] b()
  {
    int i = this.a.a();
    if (i < 0)
      throw new IOException();
    byte[] arrayOfByte;
    if (i == 0)
      arrayOfByte = this.b;
    while (true)
    {
      return arrayOfByte;
      arrayOfByte = new byte[this.b.length - i];
      System.arraycopy(this.b, 0, arrayOfByte, 0, arrayOfByte.length);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.nz
 * JD-Core Version:    0.6.0
 */