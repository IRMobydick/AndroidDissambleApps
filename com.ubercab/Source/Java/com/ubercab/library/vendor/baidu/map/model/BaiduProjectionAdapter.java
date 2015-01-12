package com.ubercab.library.vendor.baidu.map.model;

import android.graphics.Point;
import com.baidu.mapapi.map.Projection;
import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.map.internal.model.IUberProjection;
import com.ubercab.library.vendor.baidu.BaiduUtils;

public class BaiduProjectionAdapter
  implements IUberProjection
{
  private final Projection mProjection;

  public BaiduProjectionAdapter(Projection paramProjection)
  {
    this.mProjection = paramProjection;
  }

  public UberLatLng fromScreenLocation(Point paramPoint)
  {
    if (this.mProjection == null)
      return null;
    return BaiduUtils.convertLatLng(this.mProjection.fromScreenLocation(paramPoint));
  }

  public Point toScreenLocation(UberLatLng paramUberLatLng)
  {
    if (this.mProjection == null)
      return null;
    return this.mProjection.toScreenLocation(BaiduUtils.convertLatLng(paramUberLatLng));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.vendor.baidu.map.model.BaiduProjectionAdapter
 * JD-Core Version:    0.6.2
 */