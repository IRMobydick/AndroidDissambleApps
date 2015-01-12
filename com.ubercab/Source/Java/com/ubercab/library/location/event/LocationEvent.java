package com.ubercab.library.location.event;

import com.ubercab.library.location.model.UberLocation;

public final class LocationEvent
{
  private UberLocation mLocation;

  public LocationEvent(UberLocation paramUberLocation)
  {
    this.mLocation = paramUberLocation;
  }

  public UberLocation getLocation()
  {
    return this.mLocation;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.location.event.LocationEvent
 * JD-Core Version:    0.6.2
 */