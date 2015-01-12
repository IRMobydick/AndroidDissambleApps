package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class pi<M extends ph<M>, T>
{
  protected final Class<T> awK;
  protected final boolean awL;
  protected final int tag;
  protected final int type;

  private pi(int paramInt1, Class<T> paramClass, int paramInt2, boolean paramBoolean)
  {
    this.type = paramInt1;
    this.awK = paramClass;
    this.tag = paramInt2;
    this.awL = paramBoolean;
  }

  public static <M extends ph<M>, T extends pn> pi<M, T> a(int paramInt1, Class<T> paramClass, int paramInt2)
  {
    return new pi(paramInt1, paramClass, paramInt2, false);
  }

  private T m(List<pp> paramList)
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    for (int j = 0; j < paramList.size(); j++)
    {
      pp localpp = (pp)paramList.get(j);
      if (localpp.awV.length != 0)
        a(localpp, localArrayList);
    }
    int k = localArrayList.size();
    Object localObject;
    if (k == 0)
      localObject = null;
    while (true)
    {
      return localObject;
      localObject = this.awK.cast(Array.newInstance(this.awK.getComponentType(), k));
      while (i < k)
      {
        Array.set(localObject, i, localArrayList.get(i));
        i++;
      }
    }
  }

  private T n(List<pp> paramList)
  {
    if (paramList.isEmpty())
      return null;
    pp localpp = (pp)paramList.get(-1 + paramList.size());
    return this.awK.cast(u(pf.p(localpp.awV)));
  }

  int A(Object paramObject)
  {
    if (this.awL)
      return B(paramObject);
    return C(paramObject);
  }

  protected int B(Object paramObject)
  {
    int i = 0;
    int j = Array.getLength(paramObject);
    for (int k = 0; k < j; k++)
      if (Array.get(paramObject, k) != null)
        i += C(Array.get(paramObject, k));
    return i;
  }

  protected int C(Object paramObject)
  {
    int i = pq.gI(this.tag);
    switch (this.type)
    {
    default:
      throw new IllegalArgumentException("Unknown type " + this.type);
    case 10:
      return pg.b(i, (pn)paramObject);
    case 11:
    }
    return pg.c(i, (pn)paramObject);
  }

  protected void a(pp parampp, List<Object> paramList)
  {
    paramList.add(u(pf.p(parampp.awV)));
  }

  void a(Object paramObject, pg parampg)
    throws IOException
  {
    if (this.awL)
    {
      c(paramObject, parampg);
      return;
    }
    b(paramObject, parampg);
  }

  protected void b(Object paramObject, pg parampg)
  {
    try
    {
      parampg.gA(this.tag);
      switch (this.type)
      {
      default:
        throw new IllegalArgumentException("Unknown type " + this.type);
      case 10:
      case 11:
      }
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException(localIOException);
    }
    pn localpn = (pn)paramObject;
    int i = pq.gI(this.tag);
    parampg.b(localpn);
    parampg.w(i, 4);
    return;
    parampg.c((pn)paramObject);
  }

  protected void c(Object paramObject, pg parampg)
  {
    int i = Array.getLength(paramObject);
    for (int j = 0; j < i; j++)
    {
      Object localObject = Array.get(paramObject, j);
      if (localObject != null)
        b(localObject, parampg);
    }
  }

  final T l(List<pp> paramList)
  {
    if (paramList == null)
      return null;
    if (this.awL)
      return m(paramList);
    return n(paramList);
  }

  protected Object u(pf parampf)
  {
    Class localClass;
    if (this.awL)
      localClass = this.awK.getComponentType();
    try
    {
      switch (this.type)
      {
      default:
        throw new IllegalArgumentException("Unknown type " + this.type);
      case 10:
      case 11:
      }
    }
    catch (InstantiationException localInstantiationException)
    {
      while (true)
      {
        throw new IllegalArgumentException("Error creating instance of class " + localClass, localInstantiationException);
        localClass = this.awK;
      }
      pn localpn2 = (pn)localClass.newInstance();
      parampf.a(localpn2, pq.gI(this.tag));
      return localpn2;
      pn localpn1 = (pn)localClass.newInstance();
      parampf.a(localpn1);
      return localpn1;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new IllegalArgumentException("Error creating instance of class " + localClass, localIllegalAccessException);
    }
    catch (IOException localIOException)
    {
      throw new IllegalArgumentException("Error reading extension field", localIOException);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.pi
 * JD-Core Version:    0.6.2
 */