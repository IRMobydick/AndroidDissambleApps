package com.google.android.gms.internal;

import java.io.IOException;

public abstract class ph<M extends ph<M>> extends pn
{
  protected pj awJ;

  public final <T> T a(pi<M, T> parampi)
  {
    if (this.awJ == null);
    pk localpk;
    do
    {
      return null;
      localpk = this.awJ.gE(pq.gI(parampi.tag));
    }
    while (localpk == null);
    return localpk.b(parampi);
  }

  public void a(pg parampg)
    throws IOException
  {
    if (this.awJ == null);
    while (true)
    {
      return;
      for (int i = 0; i < this.awJ.size(); i++)
        this.awJ.gF(i).a(parampg);
    }
  }

  protected final boolean a(pf parampf, int paramInt)
    throws IOException
  {
    int i = parampf.getPosition();
    if (!parampf.gn(paramInt))
      return false;
    int j = pq.gI(paramInt);
    pp localpp = new pp(paramInt, parampf.r(i, parampf.getPosition() - i));
    pk localpk = null;
    if (this.awJ == null)
      this.awJ = new pj();
    while (true)
    {
      if (localpk == null)
      {
        localpk = new pk();
        this.awJ.a(j, localpk);
      }
      localpk.a(localpp);
      return true;
      localpk = this.awJ.gE(j);
    }
  }

  protected final boolean a(M paramM)
  {
    if ((this.awJ == null) || (this.awJ.isEmpty()))
      return (paramM.awJ == null) || (paramM.awJ.isEmpty());
    return this.awJ.equals(paramM.awJ);
  }

  protected int c()
  {
    int i = 0;
    if (this.awJ != null)
    {
      j = 0;
      while (i < this.awJ.size())
      {
        j += this.awJ.gF(i).c();
        i++;
      }
    }
    int j = 0;
    return j;
  }

  protected final int qz()
  {
    if ((this.awJ == null) || (this.awJ.isEmpty()))
      return 0;
    return this.awJ.hashCode();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ph
 * JD-Core Version:    0.6.2
 */