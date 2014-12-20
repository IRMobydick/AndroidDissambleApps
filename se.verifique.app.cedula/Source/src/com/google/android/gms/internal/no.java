package com.google.android.gms.internal;

import java.io.UnsupportedEncodingException;

public final class no
{
  private final byte[] a;
  private final int b;
  private int c;

  private no(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a = paramArrayOfByte;
    this.c = paramInt1;
    this.b = (paramInt1 + paramInt2);
  }

  public static no a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public static no a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new no(paramArrayOfByte, paramInt1, paramInt2);
  }

  public static int b(int paramInt)
  {
    if (paramInt >= 0);
    for (int i = f(paramInt); ; i = 10)
      return i;
  }

  public static int b(int paramInt1, int paramInt2)
  {
    return d(paramInt1) + b(paramInt2);
  }

  public static int b(int paramInt, String paramString)
  {
    return d(paramInt) + b(paramString);
  }

  public static int b(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("UTF-8");
      int i = f(arrayOfByte.length);
      int j = arrayOfByte.length;
      return j + i;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    throw new RuntimeException("UTF-8 not supported.");
  }

  public static int c(int paramInt, long paramLong)
  {
    return d(paramInt) + c(paramLong);
  }

  public static int c(long paramLong)
  {
    return e(f(paramLong));
  }

  public static int d(int paramInt)
  {
    return f(nv.a(paramInt, 0));
  }

  public static int e(long paramLong)
  {
    int i;
    if ((0xFFFFFF80 & paramLong) == 0L)
      i = 1;
    while (true)
    {
      return i;
      if ((0xFFFFC000 & paramLong) == 0L)
      {
        i = 2;
        continue;
      }
      if ((0xFFE00000 & paramLong) == 0L)
      {
        i = 3;
        continue;
      }
      if ((0xF0000000 & paramLong) == 0L)
      {
        i = 4;
        continue;
      }
      if ((0x0 & paramLong) == 0L)
      {
        i = 5;
        continue;
      }
      if ((0x0 & paramLong) == 0L)
      {
        i = 6;
        continue;
      }
      if ((0x0 & paramLong) == 0L)
      {
        i = 7;
        continue;
      }
      if ((0x0 & paramLong) == 0L)
      {
        i = 8;
        continue;
      }
      if ((0x0 & paramLong) == 0L)
      {
        i = 9;
        continue;
      }
      i = 10;
    }
  }

  public static int f(int paramInt)
  {
    int i;
    if ((paramInt & 0xFFFFFF80) == 0)
      i = 1;
    while (true)
    {
      return i;
      if ((paramInt & 0xFFFFC000) == 0)
      {
        i = 2;
        continue;
      }
      if ((0xFFE00000 & paramInt) == 0)
      {
        i = 3;
        continue;
      }
      if ((0xF0000000 & paramInt) == 0)
      {
        i = 4;
        continue;
      }
      i = 5;
    }
  }

  public static long f(long paramLong)
  {
    return paramLong << 1 ^ paramLong >> 63;
  }

  public int a()
  {
    return this.b - this.c;
  }

  public void a(byte paramByte)
  {
    if (this.c == this.b)
      throw new np(this.c, this.b);
    byte[] arrayOfByte = this.a;
    int i = this.c;
    this.c = (i + 1);
    arrayOfByte[i] = paramByte;
  }

  public void a(int paramInt)
  {
    if (paramInt >= 0)
      e(paramInt);
    while (true)
    {
      return;
      d(paramInt);
    }
  }

  public void a(int paramInt1, int paramInt2)
  {
    c(paramInt1, 0);
    a(paramInt2);
  }

  public void a(int paramInt, long paramLong)
  {
    c(paramInt, 0);
    a(paramLong);
  }

  public void a(int paramInt, String paramString)
  {
    c(paramInt, 2);
    a(paramString);
  }

  public void a(long paramLong)
  {
    d(paramLong);
  }

  public void a(String paramString)
  {
    byte[] arrayOfByte = paramString.getBytes("UTF-8");
    e(arrayOfByte.length);
    b(arrayOfByte);
  }

  public void b()
  {
    if (a() != 0)
      throw new IllegalStateException("Did not write as much data as expected.");
  }

  public void b(int paramInt, long paramLong)
  {
    c(paramInt, 0);
    b(paramLong);
  }

  public void b(long paramLong)
  {
    d(f(paramLong));
  }

  public void b(byte[] paramArrayOfByte)
  {
    b(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.b - this.c >= paramInt2)
    {
      System.arraycopy(paramArrayOfByte, paramInt1, this.a, this.c, paramInt2);
      this.c = (paramInt2 + this.c);
      return;
    }
    throw new np(this.c, this.b);
  }

  public void c(int paramInt)
  {
    a((byte)paramInt);
  }

  public void c(int paramInt1, int paramInt2)
  {
    e(nv.a(paramInt1, paramInt2));
  }

  public void d(long paramLong)
  {
    while (true)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        c((int)paramLong);
        return;
      }
      c(0x80 | 0x7F & (int)paramLong);
      paramLong >>>= 7;
    }
  }

  public void e(int paramInt)
  {
    while (true)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        c(paramInt);
        return;
      }
      c(0x80 | paramInt & 0x7F);
      paramInt >>>= 7;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.no
 * JD-Core Version:    0.6.0
 */