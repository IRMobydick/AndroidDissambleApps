package com.ubercab.library.map;

import com.ubercab.library.map.internal.model.IUberCameraUpdate;

public class UberCameraUpdate
{
  private final IUberCameraUpdate mCameraUpdate;

  public UberCameraUpdate(IUberCameraUpdate paramIUberCameraUpdate)
  {
    this.mCameraUpdate = paramIUberCameraUpdate;
  }

  IUberCameraUpdate getCameraUpdate()
  {
    return this.mCameraUpdate;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.map.UberCameraUpdate
 * JD-Core Version:    0.6.2
 */