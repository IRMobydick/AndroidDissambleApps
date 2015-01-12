package com.ubercab.library.map;

import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.map.internal.model.IUberPolyline;
import java.util.List;

public class UberPolyline
{
  private final IUberPolyline mPolyline;

  public UberPolyline(IUberPolyline paramIUberPolyline)
  {
    this.mPolyline = paramIUberPolyline;
  }

  public List<UberLatLng> getPoints()
  {
    return this.mPolyline.getPoints();
  }

  IUberPolyline getPolyline()
  {
    return this.mPolyline;
  }

  public void remove()
  {
    this.mPolyline.remove();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.map.UberPolyline
 * JD-Core Version:    0.6.2
 */