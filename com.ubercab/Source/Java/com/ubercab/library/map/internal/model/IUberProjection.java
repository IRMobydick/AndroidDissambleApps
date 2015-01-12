package com.ubercab.library.map.internal.model;

import android.graphics.Point;
import com.ubercab.library.location.model.UberLatLng;

public abstract interface IUberProjection
{
  public abstract UberLatLng fromScreenLocation(Point paramPoint);

  public abstract Point toScreenLocation(UberLatLng paramUberLatLng);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.map.internal.model.IUberProjection
 * JD-Core Version:    0.6.2
 */