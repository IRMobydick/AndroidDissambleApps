package com.ubercab.library.vendor.baidu.map.model;

import com.baidu.mapapi.map.MarkerOptions;
import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.map.internal.model.IUberBitmapDescriptor;
import com.ubercab.library.map.internal.model.IUberMarkerOptions;
import com.ubercab.library.vendor.baidu.BaiduUtils;

public class BaiduMarkerOptionsAdapter
  implements IUberMarkerOptions
{
  private MarkerOptions mMarkerOptions = new MarkerOptions();

  public IUberMarkerOptions alpha(float paramFloat)
  {
    return this;
  }

  public IUberMarkerOptions anchor(float paramFloat1, float paramFloat2)
  {
    this.mMarkerOptions = this.mMarkerOptions.anchor(paramFloat1, paramFloat2);
    return this;
  }

  public MarkerOptions getMarkerOptions()
  {
    return this.mMarkerOptions;
  }

  public IUberMarkerOptions icon(IUberBitmapDescriptor paramIUberBitmapDescriptor)
  {
    this.mMarkerOptions = this.mMarkerOptions.icon(((BaiduBitmapDescriptorAdapter)paramIUberBitmapDescriptor).getBitmapDescriptor());
    return this;
  }

  public IUberMarkerOptions position(UberLatLng paramUberLatLng)
  {
    this.mMarkerOptions = this.mMarkerOptions.position(BaiduUtils.convertLatLng(paramUberLatLng));
    return this;
  }

  public IUberMarkerOptions rotation(float paramFloat)
  {
    this.mMarkerOptions = this.mMarkerOptions.rotate(paramFloat);
    return this;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.vendor.baidu.map.model.BaiduMarkerOptionsAdapter
 * JD-Core Version:    0.6.2
 */