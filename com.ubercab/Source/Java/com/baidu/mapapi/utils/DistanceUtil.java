package com.baidu.mapapi.utils;

import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.a.d;

public class DistanceUtil
{
  public static double getDistance(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    if ((paramLatLng1 == null) || (paramLatLng2 == null));
    d locald1;
    d locald2;
    do
    {
      return -1.0D;
      locald1 = com.baidu.mapapi.model.a.b(paramLatLng1);
      locald2 = com.baidu.mapapi.model.a.b(paramLatLng2);
    }
    while ((locald1 == null) || (locald2 == null));
    return com.baidu.platform.comjni.tools.a.a(locald1, locald2);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.utils.DistanceUtil
 * JD-Core Version:    0.6.2
 */