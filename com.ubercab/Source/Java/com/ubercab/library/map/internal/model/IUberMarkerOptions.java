package com.ubercab.library.map.internal.model;

import com.ubercab.library.location.model.UberLatLng;

public abstract interface IUberMarkerOptions
{
  public abstract IUberMarkerOptions alpha(float paramFloat);

  public abstract IUberMarkerOptions anchor(float paramFloat1, float paramFloat2);

  public abstract IUberMarkerOptions icon(IUberBitmapDescriptor paramIUberBitmapDescriptor);

  public abstract IUberMarkerOptions position(UberLatLng paramUberLatLng);

  public abstract IUberMarkerOptions rotation(float paramFloat);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.map.internal.model.IUberMarkerOptions
 * JD-Core Version:    0.6.2
 */