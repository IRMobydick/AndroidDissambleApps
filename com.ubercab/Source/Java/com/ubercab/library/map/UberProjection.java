package com.ubercab.library.map;

import android.graphics.Point;
import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.map.internal.model.IUberProjection;

public class UberProjection
{
  private final IUberProjection mProjection;

  public UberProjection(IUberProjection paramIUberProjection)
  {
    this.mProjection = paramIUberProjection;
  }

  public UberLatLng fromScreenLocation(Point paramPoint)
  {
    return this.mProjection.fromScreenLocation(paramPoint);
  }

  IUberProjection getProjection()
  {
    return this.mProjection;
  }

  public Point toScreenLocation(UberLatLng paramUberLatLng)
  {
    return this.mProjection.toScreenLocation(paramUberLatLng);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.map.UberProjection
 * JD-Core Version:    0.6.2
 */