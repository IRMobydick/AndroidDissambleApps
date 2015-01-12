package com.ubercab.library.vendor.google.map.model;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.location.model.UberLatLngBounds;
import com.ubercab.library.map.internal.model.IUberCameraUpdate;
import com.ubercab.library.map.internal.model.IUberCameraUpdateFactory;
import com.ubercab.library.vendor.google.GoogleUtils;

public class GoogleCameraUpdateFactoryAdapter
  implements IUberCameraUpdateFactory
{
  public IUberCameraUpdate newLatLng(UberLatLng paramUberLatLng)
  {
    return new GoogleCameraUpdateAdapter(CameraUpdateFactory.newLatLng(GoogleUtils.convertLatLng(paramUberLatLng)));
  }

  public IUberCameraUpdate newLatLngBounds(UberLatLngBounds paramUberLatLngBounds, int paramInt)
  {
    return new GoogleCameraUpdateAdapter(CameraUpdateFactory.newLatLngBounds(GoogleUtils.convertLatLngBounds(paramUberLatLngBounds), paramInt));
  }

  public IUberCameraUpdate newLatLngZoom(UberLatLng paramUberLatLng, float paramFloat)
  {
    return new GoogleCameraUpdateAdapter(CameraUpdateFactory.newLatLngZoom(GoogleUtils.convertLatLng(paramUberLatLng), paramFloat));
  }

  public IUberCameraUpdate zoomIn()
  {
    return new GoogleCameraUpdateAdapter(CameraUpdateFactory.zoomIn());
  }

  public IUberCameraUpdate zoomOut()
  {
    return new GoogleCameraUpdateAdapter(CameraUpdateFactory.zoomOut());
  }

  public IUberCameraUpdate zoomTo(float paramFloat)
  {
    return new GoogleCameraUpdateAdapter(CameraUpdateFactory.zoomTo(paramFloat));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.vendor.google.map.model.GoogleCameraUpdateFactoryAdapter
 * JD-Core Version:    0.6.2
 */