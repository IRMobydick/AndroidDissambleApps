package com.baidu.mapapi.utils;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.a;
import com.baidu.platform.comapi.a.b;
import com.baidu.platform.comapi.a.d;

public class CoordinateConverter
{
  private LatLng a;
  private CoordType b;

  private static LatLng a(LatLng paramLatLng)
  {
    return a(paramLatLng, "wgs84");
  }

  private static LatLng a(LatLng paramLatLng, String paramString)
  {
    if (paramLatLng == null);
    d locald;
    do
    {
      return null;
      locald = a.a((float)paramLatLng.longitude, (float)paramLatLng.latitude, paramString);
    }
    while (locald == null);
    return a.a(new b(locald.b(), locald.a()));
  }

  private static LatLng b(LatLng paramLatLng)
  {
    return a(paramLatLng, "gcj02");
  }

  public LatLng convert()
  {
    if (this.a == null)
      return null;
    if (this.b == null)
      this.b = CoordType.GPS;
    switch (1.a[this.b.ordinal()])
    {
    default:
      return null;
    case 1:
      return b(this.a);
    case 2:
    }
    return a(this.a);
  }

  public CoordinateConverter coord(LatLng paramLatLng)
  {
    this.a = paramLatLng;
    return this;
  }

  public CoordinateConverter from(CoordType paramCoordType)
  {
    this.b = paramCoordType;
    return this;
  }

  public static enum CoordType
  {
    static
    {
      COMMON = new CoordType("COMMON", 1);
      CoordType[] arrayOfCoordType = new CoordType[2];
      arrayOfCoordType[0] = GPS;
      arrayOfCoordType[1] = COMMON;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.utils.CoordinateConverter
 * JD-Core Version:    0.6.2
 */