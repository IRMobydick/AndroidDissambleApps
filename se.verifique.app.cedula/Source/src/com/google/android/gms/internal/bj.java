package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import java.util.Iterator;
import java.util.List;

public final class bj
{
  private final ds a;
  private final bv b;
  private final Context c;
  private final Object d = new Object();
  private final bm e;
  private boolean f = false;
  private bp g;

  public bj(Context paramContext, ds paramds, bv parambv, bm parambm)
  {
    this.c = paramContext;
    this.a = paramds;
    this.b = parambv;
    this.e = parambm;
  }

  public br a(long paramLong1, long paramLong2)
  {
    hi.a("Starting mediation.");
    Iterator localIterator1 = this.e.a.iterator();
    br localbr;
    while (true)
    {
      if (localIterator1.hasNext())
      {
        bl localbl = (bl)localIterator1.next();
        hi.c("Trying mediation network: " + localbl.b);
        Iterator localIterator2 = localbl.c.iterator();
        while (localIterator2.hasNext())
        {
          String str = (String)localIterator2.next();
          synchronized (this.d)
          {
            if (this.f)
            {
              localbr = new br(-1);
              break label258;
            }
            this.g = new bp(this.c, str, this.b, this.e, localbl, this.a.d, this.a.e, this.a.l);
            localbr = this.g.a(paramLong1, paramLong2);
            if (localbr.a == 0)
              hi.a("Adapter succeeded.");
          }
          if (localbr.c == null)
            continue;
          hh.a.post(new bk(this, localbr));
        }
        continue;
      }
      localbr = new br(1);
    }
    label258: return localbr;
  }

  public void a()
  {
    synchronized (this.d)
    {
      this.f = true;
      if (this.g != null)
        this.g.a();
      return;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.bj
 * JD-Core Version:    0.6.0
 */