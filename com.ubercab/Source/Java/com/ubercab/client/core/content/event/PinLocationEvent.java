package com.ubercab.client.core.content.event;

import com.ubercab.client.core.location.RiderLocation;

public final class PinLocationEvent
{
  private RiderLocation mLocation;

  public PinLocationEvent(RiderLocation paramRiderLocation)
  {
    this.mLocation = paramRiderLocation;
  }

  public RiderLocation getLocation()
  {
    return this.mLocation;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.content.event.PinLocationEvent
 * JD-Core Version:    0.6.2
 */