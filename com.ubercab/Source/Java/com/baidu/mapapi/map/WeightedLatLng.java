package com.baidu.mapapi.map;

import android.graphics.Point;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.a;
import com.baidu.platform.comapi.a.b;

public class WeightedLatLng extends i.a
{
  public static final double DEFAULT_INTENSITY = 1.0D;
  private Point a;
  public final double intensity;
  public final LatLng latLng;

  public WeightedLatLng(LatLng paramLatLng)
  {
    this(paramLatLng, 1.0D);
  }

  public WeightedLatLng(LatLng paramLatLng, double paramDouble)
  {
    if (paramLatLng == null)
      throw new IllegalArgumentException("latLng can not be null");
    this.latLng = paramLatLng;
    b localb = a.a(paramLatLng);
    this.a = new Point(localb.b(), localb.a());
    if (paramDouble > 0.0D)
    {
      this.intensity = paramDouble;
      return;
    }
    this.intensity = 1.0D;
  }

  Point a()
  {
    return this.a;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.map.WeightedLatLng
 * JD-Core Version:    0.6.2
 */