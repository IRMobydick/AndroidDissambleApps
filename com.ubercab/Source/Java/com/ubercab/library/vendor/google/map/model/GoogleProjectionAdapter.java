package com.ubercab.library.vendor.google.map.model;

import android.graphics.Point;
import com.google.android.gms.maps.Projection;
import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.map.internal.model.IUberProjection;
import com.ubercab.library.vendor.google.GoogleUtils;

public class GoogleProjectionAdapter
  implements IUberProjection
{
  private final Projection mProjection;

  public GoogleProjectionAdapter(Projection paramProjection)
  {
    this.mProjection = paramProjection;
  }

  public UberLatLng fromScreenLocation(Point paramPoint)
  {
    return GoogleUtils.convertLatLng(this.mProjection.fromScreenLocation(paramPoint));
  }

  public Point toScreenLocation(UberLatLng paramUberLatLng)
  {
    return this.mProjection.toScreenLocation(GoogleUtils.convertLatLng(paramUberLatLng));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.vendor.google.map.model.GoogleProjectionAdapter
 * JD-Core Version:    0.6.2
 */