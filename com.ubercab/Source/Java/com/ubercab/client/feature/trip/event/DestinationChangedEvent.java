package com.ubercab.client.feature.trip.event;

import com.ubercab.client.core.location.RiderLocation;

public final class DestinationChangedEvent
{
  private final RiderLocation mLocation;

  public DestinationChangedEvent(RiderLocation paramRiderLocation)
  {
    this.mLocation = paramRiderLocation;
  }

  public RiderLocation getLocation()
  {
    return this.mLocation;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.event.DestinationChangedEvent
 * JD-Core Version:    0.6.2
 */