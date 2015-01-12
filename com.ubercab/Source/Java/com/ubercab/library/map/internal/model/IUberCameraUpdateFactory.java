package com.ubercab.library.map.internal.model;

import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.location.model.UberLatLngBounds;

public abstract interface IUberCameraUpdateFactory
{
  public abstract IUberCameraUpdate newLatLng(UberLatLng paramUberLatLng);

  public abstract IUberCameraUpdate newLatLngBounds(UberLatLngBounds paramUberLatLngBounds, int paramInt);

  public abstract IUberCameraUpdate newLatLngZoom(UberLatLng paramUberLatLng, float paramFloat);

  public abstract IUberCameraUpdate zoomIn();

  public abstract IUberCameraUpdate zoomOut();

  public abstract IUberCameraUpdate zoomTo(float paramFloat);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.map.internal.model.IUberCameraUpdateFactory
 * JD-Core Version:    0.6.2
 */