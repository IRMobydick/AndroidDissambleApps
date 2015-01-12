package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@ez
public class al
{
  private final Object mw = new Object();
  private int np;
  private List<ak> nq = new LinkedList();

  public boolean a(ak paramak)
  {
    synchronized (this.mw)
    {
      return this.nq.contains(paramak);
    }
  }

  public ak aU()
  {
    Object localObject4;
    for (Object localObject1 = null; ; localObject1 = localObject4)
    {
      synchronized (this.mw)
      {
        if (this.nq.size() == 0)
        {
          gs.S("Queue empty");
          return null;
        }
        if (this.nq.size() >= 2)
        {
          i = -2147483648;
          Iterator localIterator = this.nq.iterator();
          if (localIterator.hasNext())
          {
            ak localak1 = (ak)localIterator.next();
            int j = localak1.getScore();
            if (j <= i)
              break label150;
            localObject4 = localak1;
            k = j;
            break label160;
          }
          this.nq.remove(localObject1);
          return localObject1;
        }
      }
      ak localak2 = (ak)this.nq.get(0);
      localak2.aP();
      return localak2;
      label150: int k = i;
      localObject4 = localObject1;
      label160: int i = k;
    }
  }

  public boolean b(ak paramak)
  {
    synchronized (this.mw)
    {
      Iterator localIterator = this.nq.iterator();
      while (localIterator.hasNext())
      {
        ak localak = (ak)localIterator.next();
        if ((paramak != localak) && (localak.aO().equals(paramak.aO())))
        {
          this.nq.remove(paramak);
          return true;
        }
      }
      return false;
    }
  }

  public void c(ak paramak)
  {
    synchronized (this.mw)
    {
      if (this.nq.size() >= 10)
      {
        gs.S("Queue is full, current size = " + this.nq.size());
        this.nq.remove(0);
      }
      int i = this.np;
      this.np = (i + 1);
      paramak.c(i);
      this.nq.add(paramak);
      return;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.al
 * JD-Core Version:    0.6.2
 */