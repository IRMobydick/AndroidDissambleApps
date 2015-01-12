package com.crashlytics.android;

import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

final class h
  implements Flushable
{
  private final byte[] a;
  private final int b;
  private int c;
  private final OutputStream d;

  private h(OutputStream paramOutputStream, byte[] paramArrayOfByte)
  {
    this.d = paramOutputStream;
    this.a = paramArrayOfByte;
    this.c = 0;
    this.b = paramArrayOfByte.length;
  }

  public static int a(int paramInt)
  {
    return c(ae.a(paramInt, 0));
  }

  public static h a(OutputStream paramOutputStream)
  {
    return new h(paramOutputStream, new byte[4096]);
  }

  private void a()
    throws IOException
  {
    if (this.d == null)
      throw new i();
    this.d.write(this.a, 0, this.c);
    this.c = 0;
  }

  private void a(long paramLong)
    throws IOException
  {
    while (true)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        d((int)paramLong);
        return;
      }
      d(0x80 | 0x7F & (int)paramLong);
      paramLong >>>= 7;
    }
  }

  public static int b(int paramInt, float paramFloat)
  {
    return 4 + a(1);
  }

  public static int b(int paramInt, long paramLong)
  {
    int i = a(paramInt);
    int j;
    if ((0xFFFFFF80 & paramLong) == 0L)
      j = 1;
    while (true)
    {
      return j + i;
      if ((0xFFFFC000 & paramLong) == 0L)
        j = 2;
      else if ((0xFFE00000 & paramLong) == 0L)
        j = 3;
      else if ((0xF0000000 & paramLong) == 0L)
        j = 4;
      else if ((0x0 & paramLong) == 0L)
        j = 5;
      else if ((0x0 & paramLong) == 0L)
        j = 6;
      else if ((0x0 & paramLong) == 0L)
        j = 7;
      else if ((0x0 & paramLong) == 0L)
        j = 8;
      else if ((0x0 & paramLong) == 0L)
        j = 9;
      else
        j = 10;
    }
  }

  public static int b(int paramInt, d paramd)
  {
    return a(paramInt) + (c(paramd.a()) + paramd.a());
  }

  public static int b(int paramInt, boolean paramBoolean)
  {
    return 1 + a(paramInt);
  }

  public static int c(int paramInt)
  {
    if ((paramInt & 0xFFFFFF80) == 0)
      return 1;
    if ((paramInt & 0xFFFFC000) == 0)
      return 2;
    if ((0xFFE00000 & paramInt) == 0)
      return 3;
    if ((0xF0000000 & paramInt) == 0)
      return 4;
    return 5;
  }

  public static int d(int paramInt1, int paramInt2)
  {
    return a(paramInt1) + c(paramInt2);
  }

  private void d(int paramInt)
    throws IOException
  {
    int i = (byte)paramInt;
    if (this.c == this.b)
      a();
    byte[] arrayOfByte = this.a;
    int j = this.c;
    this.c = (j + 1);
    arrayOfByte[j] = i;
  }

  private static int e(int paramInt)
  {
    return paramInt << 1 ^ paramInt >> 31;
  }

  public static int e(int paramInt1, int paramInt2)
  {
    int i = a(paramInt1);
    if (paramInt2 >= 0);
    for (int j = c(paramInt2); ; j = 10)
      return j + i;
  }

  public static int f(int paramInt1, int paramInt2)
  {
    return a(2) + c(e(paramInt2));
  }

  public final void a(int paramInt, float paramFloat)
    throws IOException
  {
    g(1, 5);
    int i = Float.floatToRawIntBits(paramFloat);
    d(i & 0xFF);
    d(0xFF & i >> 8);
    d(0xFF & i >> 16);
    d(i >>> 24);
  }

  public final void a(int paramInt1, int paramInt2)
    throws IOException
  {
    g(paramInt1, 0);
    b(paramInt2);
  }

  public final void a(int paramInt, long paramLong)
    throws IOException
  {
    g(paramInt, 0);
    a(paramLong);
  }

  public final void a(int paramInt, d paramd)
    throws IOException
  {
    g(paramInt, 2);
    b(paramd.a());
    int i = paramd.a();
    if (this.b - this.c >= i)
    {
      paramd.a(this.a, 0, this.c, i);
      this.c = (i + this.c);
      return;
    }
    int j = this.b - this.c;
    paramd.a(this.a, 0, this.c, j);
    int k = j + 0;
    int m = i - j;
    this.c = this.b;
    a();
    if (m <= this.b)
    {
      paramd.a(this.a, k, 0, m);
      this.c = m;
      return;
    }
    InputStream localInputStream = paramd.b();
    if (k != localInputStream.skip(k))
      throw new IllegalStateException("Skip failed.");
    int i1;
    int n;
    do
    {
      this.d.write(this.a, 0, i1);
      m -= i1;
      if (m <= 0)
        break;
      n = Math.min(m, this.b);
      i1 = localInputStream.read(this.a, 0, n);
    }
    while (i1 == n);
    throw new IllegalStateException("Read failed.");
  }

  public final void a(int paramInt, String paramString)
    throws IOException
  {
    g(1, 2);
    byte[] arrayOfByte = paramString.getBytes("UTF-8");
    b(arrayOfByte.length);
    a(arrayOfByte);
  }

  public final void a(int paramInt, boolean paramBoolean)
    throws IOException
  {
    g(paramInt, 0);
    int i = 0;
    if (paramBoolean)
      i = 1;
    d(i);
  }

  public final void a(byte[] paramArrayOfByte)
    throws IOException
  {
    int i = paramArrayOfByte.length;
    if (this.b - this.c >= i)
    {
      System.arraycopy(paramArrayOfByte, 0, this.a, this.c, i);
      this.c = (i + this.c);
      return;
    }
    int j = this.b - this.c;
    System.arraycopy(paramArrayOfByte, 0, this.a, this.c, j);
    int k = j + 0;
    int m = i - j;
    this.c = this.b;
    a();
    if (m <= this.b)
    {
      System.arraycopy(paramArrayOfByte, k, this.a, 0, m);
      this.c = m;
      return;
    }
    this.d.write(paramArrayOfByte, k, m);
  }

  public final void b(int paramInt)
    throws IOException
  {
    while (true)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        d(paramInt);
        return;
      }
      d(0x80 | paramInt & 0x7F);
      paramInt >>>= 7;
    }
  }

  public final void b(int paramInt1, int paramInt2)
    throws IOException
  {
    g(paramInt1, 0);
    if (paramInt2 >= 0)
    {
      b(paramInt2);
      return;
    }
    a(paramInt2);
  }

  public final void c(int paramInt1, int paramInt2)
    throws IOException
  {
    g(2, 0);
    b(e(paramInt2));
  }

  public final void flush()
    throws IOException
  {
    if (this.d != null)
      a();
  }

  public final void g(int paramInt1, int paramInt2)
    throws IOException
  {
    b(ae.a(paramInt1, paramInt2));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.h
 * JD-Core Version:    0.6.2
 */