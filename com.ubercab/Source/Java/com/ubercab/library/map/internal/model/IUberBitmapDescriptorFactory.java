package com.ubercab.library.map.internal.model;

import android.graphics.Bitmap;

public abstract interface IUberBitmapDescriptorFactory
{
  public abstract IUberBitmapDescriptor fromBitmap(Bitmap paramBitmap);

  public abstract IUberBitmapDescriptor fromResource(int paramInt);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.map.internal.model.IUberBitmapDescriptorFactory
 * JD-Core Version:    0.6.2
 */