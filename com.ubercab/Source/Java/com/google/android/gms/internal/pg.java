package com.google.android.gms.internal;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class pg
{
  private final int awI;
  private final byte[] buffer;
  private int position;

  private pg(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.buffer = paramArrayOfByte;
    this.position = paramInt1;
    this.awI = (paramInt1 + paramInt2);
  }

  public static int D(long paramLong)
  {
    return G(paramLong);
  }

  public static int E(long paramLong)
  {
    return G(I(paramLong));
  }

  public static int G(long paramLong)
  {
    if ((0xFFFFFF80 & paramLong) == 0L)
      return 1;
    if ((0xFFFFC000 & paramLong) == 0L)
      return 2;
    if ((0xFFE00000 & paramLong) == 0L)
      return 3;
    if ((0xF0000000 & paramLong) == 0L)
      return 4;
    if ((0x0 & paramLong) == 0L)
      return 5;
    if ((0x0 & paramLong) == 0L)
      return 6;
    if ((0x0 & paramLong) == 0L)
      return 7;
    if ((0x0 & paramLong) == 0L)
      return 8;
    if ((0x0 & paramLong) == 0L)
      return 9;
    return 10;
  }

  public static long I(long paramLong)
  {
    return paramLong << 1 ^ paramLong >> 63;
  }

  public static int V(boolean paramBoolean)
  {
    return 1;
  }

  public static int b(int paramInt, double paramDouble)
  {
    return gz(paramInt) + f(paramDouble);
  }

  public static int b(int paramInt, pn parampn)
  {
    return 2 * gz(paramInt) + d(parampn);
  }

  public static int b(int paramInt, byte[] paramArrayOfByte)
  {
    return gz(paramInt) + s(paramArrayOfByte);
  }

  public static pg b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new pg(paramArrayOfByte, paramInt1, paramInt2);
  }

  public static int c(int paramInt, float paramFloat)
  {
    return gz(paramInt) + e(paramFloat);
  }

  public static int c(int paramInt, pn parampn)
  {
    return gz(paramInt) + e(parampn);
  }

  public static int c(int paramInt, boolean paramBoolean)
  {
    return gz(paramInt) + V(paramBoolean);
  }

  public static int d(int paramInt, long paramLong)
  {
    return gz(paramInt) + D(paramLong);
  }

  public static int d(pn parampn)
  {
    return parampn.qI();
  }

  public static int di(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("UTF-8");
      int i = gB(arrayOfByte.length);
      int j = arrayOfByte.length;
      return j + i;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    throw new RuntimeException("UTF-8 not supported.");
  }

  public static int e(float paramFloat)
  {
    return 4;
  }

  public static int e(int paramInt, long paramLong)
  {
    return gz(paramInt) + E(paramLong);
  }

  public static int e(pn parampn)
  {
    int i = parampn.qI();
    return i + gB(i);
  }

  public static int f(double paramDouble)
  {
    return 8;
  }

  public static int gB(int paramInt)
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

  public static int gD(int paramInt)
  {
    return paramInt << 1 ^ paramInt >> 31;
  }

  public static int gw(int paramInt)
  {
    if (paramInt >= 0)
      return gB(paramInt);
    return 10;
  }

  public static int gx(int paramInt)
  {
    return gB(gD(paramInt));
  }

  public static int gz(int paramInt)
  {
    return gB(pq.x(paramInt, 0));
  }

  public static int j(int paramInt, String paramString)
  {
    return gz(paramInt) + di(paramString);
  }

  public static pg q(byte[] paramArrayOfByte)
  {
    return b(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public static int s(byte[] paramArrayOfByte)
  {
    return gB(paramArrayOfByte.length) + paramArrayOfByte.length;
  }

  public static int u(int paramInt1, int paramInt2)
  {
    return gz(paramInt1) + gw(paramInt2);
  }

  public static int v(int paramInt1, int paramInt2)
  {
    return gz(paramInt1) + gx(paramInt2);
  }

  public void B(long paramLong)
    throws IOException
  {
    F(paramLong);
  }

  public void C(long paramLong)
    throws IOException
  {
    F(I(paramLong));
  }

  public void F(long paramLong)
    throws IOException
  {
    while (true)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        gy((int)paramLong);
        return;
      }
      gy(0x80 | 0x7F & (int)paramLong);
      paramLong >>>= 7;
    }
  }

  public void H(long paramLong)
    throws IOException
  {
    gy(0xFF & (int)paramLong);
    gy(0xFF & (int)(paramLong >> 8));
    gy(0xFF & (int)(paramLong >> 16));
    gy(0xFF & (int)(paramLong >> 24));
    gy(0xFF & (int)(paramLong >> 32));
    gy(0xFF & (int)(paramLong >> 40));
    gy(0xFF & (int)(paramLong >> 48));
    gy(0xFF & (int)(paramLong >> 56));
  }

  public void U(boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      gy(i);
      return;
    }
  }

  public void a(int paramInt, double paramDouble)
    throws IOException
  {
    w(paramInt, 1);
    e(paramDouble);
  }

  public void a(int paramInt, pn parampn)
    throws IOException
  {
    w(paramInt, 2);
    c(parampn);
  }

  public void a(int paramInt, byte[] paramArrayOfByte)
    throws IOException
  {
    w(paramInt, 2);
    r(paramArrayOfByte);
  }

  public void b(byte paramByte)
    throws IOException
  {
    if (this.position == this.awI)
      throw new a(this.position, this.awI);
    byte[] arrayOfByte = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    arrayOfByte[i] = paramByte;
  }

  public void b(int paramInt, float paramFloat)
    throws IOException
  {
    w(paramInt, 5);
    d(paramFloat);
  }

  public void b(int paramInt, long paramLong)
    throws IOException
  {
    w(paramInt, 0);
    B(paramLong);
  }

  public void b(int paramInt, String paramString)
    throws IOException
  {
    w(paramInt, 2);
    dh(paramString);
  }

  public void b(int paramInt, boolean paramBoolean)
    throws IOException
  {
    w(paramInt, 0);
    U(paramBoolean);
  }

  public void b(pn parampn)
    throws IOException
  {
    parampn.a(this);
  }

  public void c(int paramInt, long paramLong)
    throws IOException
  {
    w(paramInt, 0);
    C(paramLong);
  }

  public void c(pn parampn)
    throws IOException
  {
    gA(parampn.qH());
    parampn.a(this);
  }

  public void c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.awI - this.position >= paramInt2)
    {
      System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, this.position, paramInt2);
      this.position = (paramInt2 + this.position);
      return;
    }
    throw new a(this.position, this.awI);
  }

  public void d(float paramFloat)
    throws IOException
  {
    gC(Float.floatToIntBits(paramFloat));
  }

  public void dh(String paramString)
    throws IOException
  {
    byte[] arrayOfByte = paramString.getBytes("UTF-8");
    gA(arrayOfByte.length);
    t(arrayOfByte);
  }

  public void e(double paramDouble)
    throws IOException
  {
    H(Double.doubleToLongBits(paramDouble));
  }

  public void gA(int paramInt)
    throws IOException
  {
    while (true)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        gy(paramInt);
        return;
      }
      gy(0x80 | paramInt & 0x7F);
      paramInt >>>= 7;
    }
  }

  public void gC(int paramInt)
    throws IOException
  {
    gy(paramInt & 0xFF);
    gy(0xFF & paramInt >> 8);
    gy(0xFF & paramInt >> 16);
    gy(0xFF & paramInt >> 24);
  }

  public void gu(int paramInt)
    throws IOException
  {
    if (paramInt >= 0)
    {
      gA(paramInt);
      return;
    }
    F(paramInt);
  }

  public void gv(int paramInt)
    throws IOException
  {
    gA(gD(paramInt));
  }

  public void gy(int paramInt)
    throws IOException
  {
    b((byte)paramInt);
  }

  public int qx()
  {
    return this.awI - this.position;
  }

  public void qy()
  {
    if (qx() != 0)
      throw new IllegalStateException("Did not write as much data as expected.");
  }

  public void r(byte[] paramArrayOfByte)
    throws IOException
  {
    gA(paramArrayOfByte.length);
    t(paramArrayOfByte);
  }

  public void s(int paramInt1, int paramInt2)
    throws IOException
  {
    w(paramInt1, 0);
    gu(paramInt2);
  }

  public void t(int paramInt1, int paramInt2)
    throws IOException
  {
    w(paramInt1, 0);
    gv(paramInt2);
  }

  public void t(byte[] paramArrayOfByte)
    throws IOException
  {
    c(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public void w(int paramInt1, int paramInt2)
    throws IOException
  {
    gA(pq.x(paramInt1, paramInt2));
  }

  public static class a extends IOException
  {
    a(int paramInt1, int paramInt2)
    {
      super();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.pg
 * JD-Core Version:    0.6.2
 */