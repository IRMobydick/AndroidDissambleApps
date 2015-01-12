package com.google.android.gms.internal;

import java.io.IOException;

public abstract class pn
{
  protected volatile int awU = -1;

  public static final <T extends pn> T a(T paramT, byte[] paramArrayOfByte)
    throws pm
  {
    return b(paramT, paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public static final void a(pn parampn, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      pg localpg = pg.b(paramArrayOfByte, paramInt1, paramInt2);
      parampn.a(localpg);
      localpg.qy();
      return;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", localIOException);
    }
  }

  public static final <T extends pn> T b(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws pm
  {
    try
    {
      pf localpf = pf.a(paramArrayOfByte, paramInt1, paramInt2);
      paramT.b(localpf);
      localpf.gm(0);
      return paramT;
    }
    catch (pm localpm)
    {
      throw localpm;
    }
    catch (IOException localIOException)
    {
    }
    throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
  }

  public static final byte[] f(pn parampn)
  {
    byte[] arrayOfByte = new byte[parampn.qI()];
    a(parampn, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }

  public void a(pg parampg)
    throws IOException
  {
  }

  public abstract pn b(pf parampf)
    throws IOException;

  protected int c()
  {
    return 0;
  }

  public int qH()
  {
    if (this.awU < 0)
      qI();
    return this.awU;
  }

  public int qI()
  {
    int i = c();
    this.awU = i;
    return i;
  }

  public String toString()
  {
    return po.g(this);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.pn
 * JD-Core Version:    0.6.2
 */