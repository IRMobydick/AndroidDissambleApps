package com.ubercab.library.vendor.google.map.model;

import com.google.android.gms.maps.CameraUpdate;
import com.ubercab.library.map.internal.model.IUberCameraUpdate;

public class GoogleCameraUpdateAdapter
  implements IUberCameraUpdate
{
  private final CameraUpdate mCameraUpdate;

  public GoogleCameraUpdateAdapter(CameraUpdate paramCameraUpdate)
  {
    this.mCameraUpdate = paramCameraUpdate;
  }

  public CameraUpdate getCameraUpdate()
  {
    return this.mCameraUpdate;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.vendor.google.map.model.GoogleCameraUpdateAdapter
 * JD-Core Version:    0.6.2
 */