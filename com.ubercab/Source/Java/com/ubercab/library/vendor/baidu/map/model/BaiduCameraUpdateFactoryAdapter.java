package com.ubercab.library.vendor.baidu.map.model;

import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.location.model.UberLatLngBounds;
import com.ubercab.library.map.internal.model.IUberCameraUpdate;
import com.ubercab.library.map.internal.model.IUberCameraUpdateFactory;
import com.ubercab.library.vendor.baidu.BaiduUtils;

public class BaiduCameraUpdateFactoryAdapter
  implements IUberCameraUpdateFactory
{
  public IUberCameraUpdate newLatLng(UberLatLng paramUberLatLng)
  {
    return new BaiduCameraUpdateAdapter(MapStatusUpdateFactory.newLatLng(BaiduUtils.convertLatLng(paramUberLatLng)));
  }

  public IUberCameraUpdate newLatLngBounds(UberLatLngBounds paramUberLatLngBounds, int paramInt)
  {
    return new BaiduCameraUpdateAdapter(MapStatusUpdateFactory.newLatLngBounds(BaiduUtils.convertLatLngBounds(paramUberLatLngBounds)));
  }

  public IUberCameraUpdate newLatLngZoom(UberLatLng paramUberLatLng, float paramFloat)
  {
    return new BaiduCameraUpdateAdapter(MapStatusUpdateFactory.newLatLngZoom(BaiduUtils.convertLatLng(paramUberLatLng), paramFloat));
  }

  public IUberCameraUpdate zoomIn()
  {
    return new BaiduCameraUpdateAdapter(MapStatusUpdateFactory.zoomIn());
  }

  public IUberCameraUpdate zoomOut()
  {
    return new BaiduCameraUpdateAdapter(MapStatusUpdateFactory.zoomOut());
  }

  public IUberCameraUpdate zoomTo(float paramFloat)
  {
    return new BaiduCameraUpdateAdapter(MapStatusUpdateFactory.zoomTo(paramFloat));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.vendor.baidu.map.model.BaiduCameraUpdateFactoryAdapter
 * JD-Core Version:    0.6.2
 */