package com.ubercab.library.vendor.baidu.map.model;

import com.baidu.mapapi.map.MapStatusUpdate;
import com.ubercab.library.map.internal.model.IUberCameraUpdate;

public class BaiduCameraUpdateAdapter
  implements IUberCameraUpdate
{
  private final MapStatusUpdate mMapStatusUpdate;

  public BaiduCameraUpdateAdapter(MapStatusUpdate paramMapStatusUpdate)
  {
    this.mMapStatusUpdate = paramMapStatusUpdate;
  }

  public MapStatusUpdate getMapStatusUpdate()
  {
    return this.mMapStatusUpdate;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.vendor.baidu.map.model.BaiduCameraUpdateAdapter
 * JD-Core Version:    0.6.2
 */