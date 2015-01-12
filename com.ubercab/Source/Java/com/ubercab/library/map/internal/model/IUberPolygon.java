package com.ubercab.library.map.internal.model;

import com.ubercab.library.location.model.UberLatLng;
import java.util.List;

public abstract interface IUberPolygon
{
  public abstract UberLatLng getCenter();

  public abstract List<UberLatLng> getPoints();

  public abstract void remove();
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.map.internal.model.IUberPolygon
 * JD-Core Version:    0.6.2
 */