package com.ubercab.client.feature.search.event;

import com.ubercab.client.core.location.RiderLocation;

public final class LocationSelectedEvent
{
  private RiderLocation mLocation;

  public LocationSelectedEvent(RiderLocation paramRiderLocation)
  {
    this.mLocation = paramRiderLocation;
  }

  public RiderLocation getLocation()
  {
    return this.mLocation;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.search.event.LocationSelectedEvent
 * JD-Core Version:    0.6.2
 */