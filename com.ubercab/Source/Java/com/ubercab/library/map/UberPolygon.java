package com.ubercab.library.map;

import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.map.internal.model.IUberPolygon;
import java.util.List;

public class UberPolygon
{
  private final IUberPolygon mPolygon;

  public UberPolygon(IUberPolygon paramIUberPolygon)
  {
    this.mPolygon = paramIUberPolygon;
  }

  public UberLatLng getCenter()
  {
    return this.mPolygon.getCenter();
  }

  public List<UberLatLng> getPoints()
  {
    return this.mPolygon.getPoints();
  }

  IUberPolygon getPolygon()
  {
    return this.mPolygon;
  }

  public void remove()
  {
    this.mPolygon.remove();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.map.UberPolygon
 * JD-Core Version:    0.6.2
 */