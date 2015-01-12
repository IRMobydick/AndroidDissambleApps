package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

final class pp
{
  final byte[] awV;
  final int tag;

  pp(int paramInt, byte[] paramArrayOfByte)
  {
    this.tag = paramInt;
    this.awV = paramArrayOfByte;
  }

  void a(pg parampg)
    throws IOException
  {
    parampg.gA(this.tag);
    parampg.t(this.awV);
  }

  int c()
  {
    return 0 + pg.gB(this.tag) + this.awV.length;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    pp localpp;
    do
    {
      return true;
      if (!(paramObject instanceof pp))
        return false;
      localpp = (pp)paramObject;
    }
    while ((this.tag == localpp.tag) && (Arrays.equals(this.awV, localpp.awV)));
    return false;
  }

  public int hashCode()
  {
    return 31 * (527 + this.tag) + Arrays.hashCode(this.awV);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.pp
 * JD-Core Version:    0.6.2
 */