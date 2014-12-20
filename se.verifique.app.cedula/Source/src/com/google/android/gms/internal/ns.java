package com.google.android.gms.internal;

import java.io.IOException;

public abstract class ns
{
  protected volatile int f = -1;

  public static final void a(ns paramns, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      no localno = no.a(paramArrayOfByte, paramInt1, paramInt2);
      paramns.a(localno);
      localno.b();
      return;
    }
    catch (IOException localIOException)
    {
    }
    throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", localIOException);
  }

  public static final byte[] a(ns paramns)
  {
    byte[] arrayOfByte = new byte[paramns.c()];
    a(paramns, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }

  public void a(no paramno)
  {
  }

  protected int b()
  {
    return 0;
  }

  public int c()
  {
    int i = b();
    this.f = i;
    return i;
  }

  public String toString()
  {
    return nt.a(this);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ns
 * JD-Core Version:    0.6.0
 */