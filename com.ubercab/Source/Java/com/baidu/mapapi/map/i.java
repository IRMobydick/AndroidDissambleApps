package com.baidu.mapapi.map;

import android.graphics.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class i<T extends a>
{
  private final d a;
  private final int b;
  private List<T> c;
  private List<i<T>> d = null;

  private i(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, int paramInt)
  {
    this(new d(paramDouble1, paramDouble2, paramDouble3, paramDouble4), paramInt);
  }

  public i(d paramd)
  {
    this(paramd, 0);
  }

  private i(d paramd, int paramInt)
  {
    this.a = paramd;
    this.b = paramInt;
  }

  private void a()
  {
    this.d = new ArrayList(4);
    this.d.add(new i(this.a.a, this.a.e, this.a.b, this.a.f, 1 + this.b));
    this.d.add(new i(this.a.e, this.a.c, this.a.b, this.a.f, 1 + this.b));
    this.d.add(new i(this.a.a, this.a.e, this.a.f, this.a.d, 1 + this.b));
    this.d.add(new i(this.a.e, this.a.c, this.a.f, this.a.d, 1 + this.b));
    List localList = this.c;
    this.c = null;
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      a(locala.a().x, locala.a().y, locala);
    }
  }

  private void a(double paramDouble1, double paramDouble2, T paramT)
  {
    if (this.d != null)
      if (paramDouble2 < this.a.f)
        if (paramDouble1 < this.a.e)
          ((i)this.d.get(0)).a(paramDouble1, paramDouble2, paramT);
    do
    {
      return;
      ((i)this.d.get(1)).a(paramDouble1, paramDouble2, paramT);
      return;
      if (paramDouble1 < this.a.e)
      {
        ((i)this.d.get(2)).a(paramDouble1, paramDouble2, paramT);
        return;
      }
      ((i)this.d.get(3)).a(paramDouble1, paramDouble2, paramT);
      return;
      if (this.c == null)
        this.c = new ArrayList();
      this.c.add(paramT);
    }
    while ((this.c.size() <= 40) || (this.b >= 40));
    a();
  }

  private void a(d paramd, Collection<T> paramCollection)
  {
    if (!this.a.a(paramd));
    while (true)
    {
      return;
      if (this.d != null)
      {
        Iterator localIterator2 = this.d.iterator();
        while (localIterator2.hasNext())
          ((i)localIterator2.next()).a(paramd, paramCollection);
      }
      else if (this.c != null)
      {
        if (paramd.b(this.a))
        {
          paramCollection.addAll(this.c);
          return;
        }
        Iterator localIterator1 = this.c.iterator();
        while (localIterator1.hasNext())
        {
          a locala = (a)localIterator1.next();
          if (paramd.a(locala.a()))
            paramCollection.add(locala);
        }
      }
    }
  }

  public Collection<T> a(d paramd)
  {
    ArrayList localArrayList = new ArrayList();
    a(paramd, localArrayList);
    return localArrayList;
  }

  public void a(T paramT)
  {
    Point localPoint = paramT.a();
    if (this.a.a(localPoint.x, localPoint.y))
      a(localPoint.x, localPoint.y, paramT);
  }

  static abstract class a
  {
    abstract Point a();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.map.i
 * JD-Core Version:    0.6.2
 */