package com.ubercab.client.core.model.event;

import com.ubercab.client.core.model.CnLocation;
import java.util.List;

public final class PlacesEvent
{
  private final List<CnLocation> mPlaces;

  public PlacesEvent(List<CnLocation> paramList)
  {
    this.mPlaces = paramList;
  }

  public List<CnLocation> getPlaces()
  {
    return this.mPlaces;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.event.PlacesEvent
 * JD-Core Version:    0.6.2
 */