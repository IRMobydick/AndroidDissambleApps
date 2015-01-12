package com.baidu.platform.comapi.a;

import java.io.Serializable;

public class d
  implements Serializable
{
  public int a;
  public int b;

  public d()
  {
  }

  public d(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }

  public int a()
  {
    return this.a;
  }

  public void a(int paramInt)
  {
    this.a = paramInt;
  }

  public int b()
  {
    return this.b;
  }

  public void b(int paramInt)
  {
    this.b = paramInt;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    d locald;
    do
    {
      return true;
      if (paramObject == null)
        return false;
      if (getClass() != paramObject.getClass())
        return false;
      locald = (d)paramObject;
      if (this.a != locald.a)
        return false;
    }
    while (this.b == locald.b);
    return false;
  }

  public int hashCode()
  {
    return 31 * (31 + this.a) + this.b;
  }

  public String toString()
  {
    return "Point [x=" + this.a + ", y=" + this.b + "]";
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.platform.comapi.a.d
 * JD-Core Version:    0.6.2
 */