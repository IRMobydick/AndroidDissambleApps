package com.baidu.mapapi.map;

import android.graphics.Point;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.a;
import com.baidu.platform.comapi.a.b;
import com.baidu.platform.comapi.map.e;

public final class Projection
{
  private e a;

  Projection(e parame)
  {
    this.a = parame;
  }

  public LatLng fromScreenLocation(Point paramPoint)
  {
    if (paramPoint != null)
      return a.a(this.a.a(paramPoint.x, paramPoint.y));
    return null;
  }

  public Point toScreenLocation(LatLng paramLatLng)
  {
    if (paramLatLng != null)
    {
      b localb = a.a(paramLatLng);
      return this.a.a(localb);
    }
    return null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.map.Projection
 * JD-Core Version:    0.6.2
 */