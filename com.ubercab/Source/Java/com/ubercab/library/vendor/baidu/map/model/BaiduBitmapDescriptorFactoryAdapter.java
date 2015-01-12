package com.ubercab.library.vendor.baidu.map.model;

import android.graphics.Bitmap;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.ubercab.library.map.internal.model.IUberBitmapDescriptor;
import com.ubercab.library.map.internal.model.IUberBitmapDescriptorFactory;

public class BaiduBitmapDescriptorFactoryAdapter
  implements IUberBitmapDescriptorFactory
{
  public IUberBitmapDescriptor fromBitmap(Bitmap paramBitmap)
  {
    return new BaiduBitmapDescriptorAdapter(BitmapDescriptorFactory.fromBitmap(paramBitmap));
  }

  public IUberBitmapDescriptor fromResource(int paramInt)
  {
    return new BaiduBitmapDescriptorAdapter(BitmapDescriptorFactory.fromResource(paramInt));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.vendor.baidu.map.model.BaiduBitmapDescriptorFactoryAdapter
 * JD-Core Version:    0.6.2
 */