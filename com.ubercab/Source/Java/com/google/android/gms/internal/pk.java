package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class pk
{
  private pi<?, ?> awQ;
  private Object awR;
  private List<pp> awS = new ArrayList();

  private byte[] toByteArray()
    throws IOException
  {
    byte[] arrayOfByte = new byte[c()];
    a(pg.q(arrayOfByte));
    return arrayOfByte;
  }

  void a(pg parampg)
    throws IOException
  {
    if (this.awR != null)
      this.awQ.a(this.awR, parampg);
    while (true)
    {
      return;
      Iterator localIterator = this.awS.iterator();
      while (localIterator.hasNext())
        ((pp)localIterator.next()).a(parampg);
    }
  }

  void a(pp parampp)
  {
    this.awS.add(parampp);
  }

  <T> T b(pi<?, T> parampi)
  {
    if (this.awR != null)
    {
      if (this.awQ != parampi)
        throw new IllegalStateException("Tried to getExtension with a differernt Extension.");
    }
    else
    {
      this.awQ = parampi;
      this.awR = parampi.l(this.awS);
      this.awS = null;
    }
    return this.awR;
  }

  int c()
  {
    int i;
    if (this.awR != null)
      i = this.awQ.A(this.awR);
    while (true)
    {
      return i;
      Iterator localIterator = this.awS.iterator();
      i = 0;
      while (localIterator.hasNext())
        i += ((pp)localIterator.next()).c();
    }
  }

  public boolean equals(Object paramObject)
  {
    boolean bool2;
    if (paramObject == this)
      bool2 = true;
    pk localpk;
    pi localpi1;
    pi localpi2;
    do
    {
      boolean bool1;
      do
      {
        return bool2;
        bool1 = paramObject instanceof pk;
        bool2 = false;
      }
      while (!bool1);
      localpk = (pk)paramObject;
      if ((this.awR == null) || (localpk.awR == null))
        break;
      localpi1 = this.awQ;
      localpi2 = localpk.awQ;
      bool2 = false;
    }
    while (localpi1 != localpi2);
    if (!this.awQ.awK.isArray())
      return this.awR.equals(localpk.awR);
    if ((this.awR instanceof byte[]))
      return Arrays.equals((byte[])this.awR, (byte[])localpk.awR);
    if ((this.awR instanceof int[]))
      return Arrays.equals((int[])this.awR, (int[])localpk.awR);
    if ((this.awR instanceof long[]))
      return Arrays.equals((long[])this.awR, (long[])localpk.awR);
    if ((this.awR instanceof float[]))
      return Arrays.equals((float[])this.awR, (float[])localpk.awR);
    if ((this.awR instanceof double[]))
      return Arrays.equals((double[])this.awR, (double[])localpk.awR);
    if ((this.awR instanceof boolean[]))
      return Arrays.equals((boolean[])this.awR, (boolean[])localpk.awR);
    return Arrays.deepEquals((Object[])this.awR, (Object[])localpk.awR);
    if ((this.awS != null) && (localpk.awS != null))
      return this.awS.equals(localpk.awS);
    try
    {
      boolean bool3 = Arrays.equals(toByteArray(), localpk.toByteArray());
      return bool3;
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException(localIOException);
    }
  }

  public int hashCode()
  {
    try
    {
      int i = Arrays.hashCode(toByteArray());
      return i + 527;
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException(localIOException);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.pk
 * JD-Core Version:    0.6.2
 */