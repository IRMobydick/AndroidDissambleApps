package com.ubercab.library.vendor.google.map.model;

import com.google.android.gms.maps.model.BitmapDescriptor;
import com.ubercab.library.map.internal.model.IUberBitmapDescriptor;

public class GoogleBitmapDescriptorAdapter
  implements IUberBitmapDescriptor
{
  private final BitmapDescriptor mBitmapDescriptor;

  public GoogleBitmapDescriptorAdapter(BitmapDescriptor paramBitmapDescriptor)
  {
    this.mBitmapDescriptor = paramBitmapDescriptor;
  }

  public BitmapDescriptor getBitmapDescriptor()
  {
    return this.mBitmapDescriptor;
  }

  public void recycle()
  {
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.vendor.google.map.model.GoogleBitmapDescriptorAdapter
 * JD-Core Version:    0.6.2
 */