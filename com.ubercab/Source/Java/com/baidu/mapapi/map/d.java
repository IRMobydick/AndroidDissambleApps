package com.baidu.mapapi.map;

import android.graphics.Point;

class d
{
  public final double a;
  public final double b;
  public final double c;
  public final double d;
  public final double e;
  public final double f;

  public d(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    this.a = paramDouble1;
    this.b = paramDouble3;
    this.c = paramDouble2;
    this.d = paramDouble4;
    this.e = ((paramDouble1 + paramDouble2) / 2.0D);
    this.f = ((paramDouble3 + paramDouble4) / 2.0D);
  }

  public boolean a(double paramDouble1, double paramDouble2)
  {
    return (this.a <= paramDouble1) && (paramDouble1 <= this.c) && (this.b <= paramDouble2) && (paramDouble2 <= this.d);
  }

  public boolean a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    return (paramDouble1 < this.c) && (this.a < paramDouble2) && (paramDouble3 < this.d) && (this.b < paramDouble4);
  }

  public boolean a(Point paramPoint)
  {
    return a(paramPoint.x, paramPoint.y);
  }

  public boolean a(d paramd)
  {
    return a(paramd.a, paramd.c, paramd.b, paramd.d);
  }

  public boolean b(d paramd)
  {
    return (paramd.a >= this.a) && (paramd.c <= this.c) && (paramd.b >= this.b) && (paramd.d <= this.d);
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("minX: " + this.a);
    localStringBuilder.append(" minY: " + this.b);
    localStringBuilder.append(" maxX: " + this.c);
    localStringBuilder.append(" maxY: " + this.d);
    localStringBuilder.append(" midX: " + this.e);
    localStringBuilder.append(" midY: " + this.f);
    return localStringBuilder.toString();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.map.d
 * JD-Core Version:    0.6.2
 */