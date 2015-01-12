package com.ubercab.library.map;

import android.graphics.Bitmap;
import com.ubercab.library.map.internal.model.IUberBitmapDescriptorFactory;
import com.ubercab.library.vendor.baidu.map.model.BaiduBitmapDescriptorFactoryAdapter;
import com.ubercab.library.vendor.google.map.model.GoogleBitmapDescriptorFactoryAdapter;

public class UberBitmapDescriptorFactory
{
  private final IUberBitmapDescriptorFactory mBitmapDescriptorFactory;

  public UberBitmapDescriptorFactory()
  {
    String str = UberMapInitializer.getMapVendor().getName();
    int i = -1;
    switch (str.hashCode())
    {
    default:
    case 93498907:
    case -1240244679:
    }
    while (true)
      switch (i)
      {
      default:
        throw new RuntimeException("Unknown map vendor: " + str);
        if (str.equals("baidu"))
        {
          i = 0;
          continue;
          if (str.equals("google"))
            i = 1;
        }
        break;
      case 0:
      case 1:
      }
    this.mBitmapDescriptorFactory = new BaiduBitmapDescriptorFactoryAdapter();
    return;
    this.mBitmapDescriptorFactory = new GoogleBitmapDescriptorFactoryAdapter();
  }

  public UberBitmapDescriptor fromBitmap(Bitmap paramBitmap)
  {
    return new UberBitmapDescriptor(this.mBitmapDescriptorFactory.fromBitmap(paramBitmap));
  }

  public UberBitmapDescriptor fromResource(int paramInt)
  {
    return new UberBitmapDescriptor(this.mBitmapDescriptorFactory.fromResource(paramInt));
  }

  IUberBitmapDescriptorFactory getBitmapDescriptorFactory()
  {
    return this.mBitmapDescriptorFactory;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.map.UberBitmapDescriptorFactory
 * JD-Core Version:    0.6.2
 */