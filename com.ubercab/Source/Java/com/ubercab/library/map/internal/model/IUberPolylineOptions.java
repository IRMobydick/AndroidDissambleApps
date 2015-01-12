package com.ubercab.library.map.internal.model;

import com.ubercab.library.location.model.UberLatLng;

public abstract interface IUberPolylineOptions
{
  public abstract IUberPolylineOptions color(int paramInt);

  public abstract IUberPolylineOptions points(Iterable<UberLatLng> paramIterable);

  public abstract IUberPolylineOptions width(float paramFloat);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.map.internal.model.IUberPolylineOptions
 * JD-Core Version:    0.6.2
 */