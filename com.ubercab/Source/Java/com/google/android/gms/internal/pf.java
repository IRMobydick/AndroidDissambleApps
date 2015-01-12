package com.google.android.gms.internal;

import java.io.IOException;

public final class pf
{
  private int awA;
  private int awB;
  private int awC;
  private int awD;
  private int awE = 2147483647;
  private int awF;
  private int awG = 64;
  private int awH = 67108864;
  private int awz;
  private final byte[] buffer;

  private pf(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.buffer = paramArrayOfByte;
    this.awz = paramInt1;
    this.awA = (paramInt1 + paramInt2);
    this.awC = paramInt1;
  }

  public static long A(long paramLong)
  {
    return paramLong >>> 1 ^ -(1L & paramLong);
  }

  public static pf a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new pf(paramArrayOfByte, paramInt1, paramInt2);
  }

  public static int go(int paramInt)
  {
    return paramInt >>> 1 ^ -(paramInt & 0x1);
  }

  public static pf p(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  private void qt()
  {
    this.awA += this.awB;
    int i = this.awA;
    if (i > this.awE)
    {
      this.awB = (i - this.awE);
      this.awA -= this.awB;
      return;
    }
    this.awB = 0;
  }

  public void a(pn parampn)
    throws IOException
  {
    int i = qp();
    if (this.awF >= this.awG)
      throw pm.qG();
    int j = gp(i);
    this.awF = (1 + this.awF);
    parampn.b(this);
    gm(0);
    this.awF = (-1 + this.awF);
    gq(j);
  }

  public void a(pn parampn, int paramInt)
    throws IOException
  {
    if (this.awF >= this.awG)
      throw pm.qG();
    this.awF = (1 + this.awF);
    parampn.b(this);
    gm(pq.x(paramInt, 4));
    this.awF = (-1 + this.awF);
  }

  public int getPosition()
  {
    return this.awC - this.awz;
  }

  public void gm(int paramInt)
    throws pm
  {
    if (this.awD != paramInt)
      throw pm.qE();
  }

  public boolean gn(int paramInt)
    throws IOException
  {
    switch (pq.gH(paramInt))
    {
    default:
      throw pm.qF();
    case 0:
      ql();
      return true;
    case 1:
      qs();
      return true;
    case 2:
      gt(qp());
      return true;
    case 3:
      qj();
      gm(pq.x(pq.gI(paramInt), 4));
      return true;
    case 4:
      return false;
    case 5:
    }
    qr();
    return true;
  }

  public int gp(int paramInt)
    throws pm
  {
    if (paramInt < 0)
      throw pm.qB();
    int i = paramInt + this.awC;
    int j = this.awE;
    if (i > j)
      throw pm.qA();
    this.awE = i;
    qt();
    return j;
  }

  public void gq(int paramInt)
  {
    this.awE = paramInt;
    qt();
  }

  public void gr(int paramInt)
  {
    if (paramInt > this.awC - this.awz)
      throw new IllegalArgumentException("Position " + paramInt + " is beyond current " + (this.awC - this.awz));
    if (paramInt < 0)
      throw new IllegalArgumentException("Bad position " + paramInt);
    this.awC = (paramInt + this.awz);
  }

  public byte[] gs(int paramInt)
    throws IOException
  {
    if (paramInt < 0)
      throw pm.qB();
    if (paramInt + this.awC > this.awE)
    {
      gt(this.awE - this.awC);
      throw pm.qA();
    }
    if (paramInt <= this.awA - this.awC)
    {
      byte[] arrayOfByte = new byte[paramInt];
      System.arraycopy(this.buffer, this.awC, arrayOfByte, 0, paramInt);
      this.awC = (paramInt + this.awC);
      return arrayOfByte;
    }
    throw pm.qA();
  }

  public void gt(int paramInt)
    throws IOException
  {
    if (paramInt < 0)
      throw pm.qB();
    if (paramInt + this.awC > this.awE)
    {
      gt(this.awE - this.awC);
      throw pm.qA();
    }
    if (paramInt <= this.awA - this.awC)
    {
      this.awC = (paramInt + this.awC);
      return;
    }
    throw pm.qA();
  }

  public int qi()
    throws IOException
  {
    if (qv())
    {
      this.awD = 0;
      return 0;
    }
    this.awD = qp();
    if (this.awD == 0)
      throw pm.qD();
    return this.awD;
  }

  public void qj()
    throws IOException
  {
    int i;
    do
      i = qi();
    while ((i != 0) && (gn(i)));
  }

  public long qk()
    throws IOException
  {
    return qq();
  }

  public int ql()
    throws IOException
  {
    return qp();
  }

  public boolean qm()
    throws IOException
  {
    return qp() != 0;
  }

  public int qn()
    throws IOException
  {
    return go(qp());
  }

  public long qo()
    throws IOException
  {
    return A(qq());
  }

  public int qp()
    throws IOException
  {
    int i = qw();
    if (i >= 0);
    int i4;
    do
    {
      return i;
      int j = i & 0x7F;
      int k = qw();
      if (k >= 0)
        return j | k << 7;
      int m = j | (k & 0x7F) << 7;
      int n = qw();
      if (n >= 0)
        return m | n << 14;
      int i1 = m | (n & 0x7F) << 14;
      int i2 = qw();
      if (i2 >= 0)
        return i1 | i2 << 21;
      int i3 = i1 | (i2 & 0x7F) << 21;
      i4 = qw();
      i = i3 | i4 << 28;
    }
    while (i4 >= 0);
    for (int i5 = 0; ; i5++)
    {
      if (i5 >= 5)
        break label151;
      if (qw() >= 0)
        break;
    }
    label151: throw pm.qC();
  }

  public long qq()
    throws IOException
  {
    int i = 0;
    long l = 0L;
    while (i < 64)
    {
      int j = qw();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0)
        return l;
      i += 7;
    }
    throw pm.qC();
  }

  public int qr()
    throws IOException
  {
    int i = qw();
    int j = qw();
    int k = qw();
    int m = qw();
    return i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16 | (m & 0xFF) << 24;
  }

  public long qs()
    throws IOException
  {
    int i = qw();
    int j = qw();
    int k = qw();
    int m = qw();
    int n = qw();
    int i1 = qw();
    int i2 = qw();
    int i3 = qw();
    return 0xFF & i | (0xFF & j) << 8 | (0xFF & k) << 16 | (0xFF & m) << 24 | (0xFF & n) << 32 | (0xFF & i1) << 40 | (0xFF & i2) << 48 | (0xFF & i3) << 56;
  }

  public int qu()
  {
    if (this.awE == 2147483647)
      return -1;
    int i = this.awC;
    return this.awE - i;
  }

  public boolean qv()
  {
    return this.awC == this.awA;
  }

  public byte qw()
    throws IOException
  {
    if (this.awC == this.awA)
      throw pm.qA();
    byte[] arrayOfByte = this.buffer;
    int i = this.awC;
    this.awC = (i + 1);
    return arrayOfByte[i];
  }

  public byte[] r(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
      return pq.axd;
    byte[] arrayOfByte = new byte[paramInt2];
    int i = paramInt1 + this.awz;
    System.arraycopy(this.buffer, i, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }

  public byte[] readBytes()
    throws IOException
  {
    int i = qp();
    if ((i <= this.awA - this.awC) && (i > 0))
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(this.buffer, this.awC, arrayOfByte, 0, i);
      this.awC = (i + this.awC);
      return arrayOfByte;
    }
    return gs(i);
  }

  public double readDouble()
    throws IOException
  {
    return Double.longBitsToDouble(qs());
  }

  public float readFloat()
    throws IOException
  {
    return Float.intBitsToFloat(qr());
  }

  public String readString()
    throws IOException
  {
    int i = qp();
    if ((i <= this.awA - this.awC) && (i > 0))
    {
      String str = new String(this.buffer, this.awC, i, "UTF-8");
      this.awC = (i + this.awC);
      return str;
    }
    return new String(gs(i), "UTF-8");
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.pf
 * JD-Core Version:    0.6.2
 */