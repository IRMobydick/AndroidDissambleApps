package com.ubercab.library.vendor.baidu.map;

import com.baidu.mapapi.map.BaiduMapOptions;
import com.ubercab.library.map.internal.IUberMapOptions;
import com.ubercab.library.map.internal.model.IUberCameraPosition;
import com.ubercab.library.vendor.baidu.map.model.BaiduCameraPositionAdapter;

public class BaiduMapOptionsAdapter
  implements IUberMapOptions
{
  private final BaiduMapOptions mBaiduMapOptions = new BaiduMapOptions();

  public IUberMapOptions camera(IUberCameraPosition paramIUberCameraPosition)
  {
    this.mBaiduMapOptions.mapStatus(((BaiduCameraPositionAdapter)paramIUberCameraPosition).getMapStatus());
    return this;
  }

  public IUberMapOptions compassEnabled(boolean paramBoolean)
  {
    this.mBaiduMapOptions.compassEnabled(paramBoolean);
    return this;
  }

  BaiduMapOptions getBaiduMapOptions()
  {
    return this.mBaiduMapOptions;
  }

  public IUberMapOptions rotateGesturesEnabled(boolean paramBoolean)
  {
    this.mBaiduMapOptions.rotateGesturesEnabled(paramBoolean);
    return this;
  }

  public IUberMapOptions scrollGesturesEnabled(boolean paramBoolean)
  {
    this.mBaiduMapOptions.scrollGesturesEnabled(paramBoolean);
    return this;
  }

  public IUberMapOptions tiltGesturesEnabled(boolean paramBoolean)
  {
    this.mBaiduMapOptions.overlookingGesturesEnabled(paramBoolean);
    return this;
  }

  public IUberMapOptions zoomControlsEnabled(boolean paramBoolean)
  {
    this.mBaiduMapOptions.zoomControlsEnabled(paramBoolean);
    return this;
  }

  public IUberMapOptions zoomGesturesEnabled(boolean paramBoolean)
  {
    this.mBaiduMapOptions.zoomGesturesEnabled(paramBoolean);
    return this;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.vendor.baidu.map.BaiduMapOptionsAdapter
 * JD-Core Version:    0.6.2
 */