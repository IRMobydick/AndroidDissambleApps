package com.ubercab.library.map.internal.model;

import com.ubercab.library.location.model.UberLatLng;

public abstract interface IUberPolygonOptions
{
  public abstract IUberPolygonOptions fillColor(int paramInt);

  public abstract IUberPolygonOptions points(Iterable<UberLatLng> paramIterable);

  public abstract IUberPolygonOptions stroke(float paramFloat, int paramInt);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.map.internal.model.IUberPolygonOptions
 * JD-Core Version:    0.6.2
 */