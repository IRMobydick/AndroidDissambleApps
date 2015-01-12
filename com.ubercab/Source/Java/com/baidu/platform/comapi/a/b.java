package com.baidu.platform.comapi.a;

public class b
{
  private int a;
  private int b;

  public b(int paramInt1, int paramInt2)
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
    if (paramObject == null);
    while (paramObject.getClass() != getClass())
      return false;
    if ((this.a == ((b)paramObject).a) && (this.b == ((b)paramObject).b));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public String toString()
  {
    return "GeoPoint: Latitude: " + this.a + ", Longitude: " + this.b;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.platform.comapi.a.b
 * JD-Core Version:    0.6.2
 */