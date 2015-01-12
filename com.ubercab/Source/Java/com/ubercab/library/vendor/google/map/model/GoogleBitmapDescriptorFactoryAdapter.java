package com.ubercab.library.vendor.google.map.model;

import android.graphics.Bitmap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.ubercab.library.map.internal.model.IUberBitmapDescriptor;
import com.ubercab.library.map.internal.model.IUberBitmapDescriptorFactory;

public class GoogleBitmapDescriptorFactoryAdapter
  implements IUberBitmapDescriptorFactory
{
  public IUberBitmapDescriptor fromBitmap(Bitmap paramBitmap)
  {
    return new GoogleBitmapDescriptorAdapter(BitmapDescriptorFactory.fromBitmap(paramBitmap));
  }

  public IUberBitmapDescriptor fromResource(int paramInt)
  {
    return new GoogleBitmapDescriptorAdapter(BitmapDescriptorFactory.fromResource(paramInt));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.vendor.google.map.model.GoogleBitmapDescriptorFactoryAdapter
 * JD-Core Version:    0.6.2
 */