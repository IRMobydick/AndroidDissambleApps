package com.ubercab.library.map;

import com.ubercab.library.map.internal.model.IUberBitmapDescriptor;

public class UberBitmapDescriptor
{
  private final IUberBitmapDescriptor mBitmapDescriptor;

  public UberBitmapDescriptor(IUberBitmapDescriptor paramIUberBitmapDescriptor)
  {
    this.mBitmapDescriptor = paramIUberBitmapDescriptor;
  }

  IUberBitmapDescriptor getBitmapDescriptor()
  {
    return this.mBitmapDescriptor;
  }

  public void recycle()
  {
    this.mBitmapDescriptor.recycle();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.map.UberBitmapDescriptor
 * JD-Core Version:    0.6.2
 */