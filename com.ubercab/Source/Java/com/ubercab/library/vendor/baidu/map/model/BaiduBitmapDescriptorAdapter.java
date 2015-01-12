package com.ubercab.library.vendor.baidu.map.model;

import com.baidu.mapapi.map.BitmapDescriptor;
import com.ubercab.library.map.internal.model.IUberBitmapDescriptor;

public class BaiduBitmapDescriptorAdapter
  implements IUberBitmapDescriptor
{
  private final BitmapDescriptor mBitmapDescriptor;

  public BaiduBitmapDescriptorAdapter(BitmapDescriptor paramBitmapDescriptor)
  {
    this.mBitmapDescriptor = paramBitmapDescriptor;
  }

  public BitmapDescriptor getBitmapDescriptor()
  {
    return this.mBitmapDescriptor;
  }

  public void recycle()
  {
    this.mBitmapDescriptor.recycle();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.vendor.baidu.map.model.BaiduBitmapDescriptorAdapter
 * JD-Core Version:    0.6.2
 */