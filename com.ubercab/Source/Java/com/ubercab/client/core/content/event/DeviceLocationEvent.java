package com.ubercab.client.core.content.event;

import com.ubercab.client.core.location.RiderLocation;

public final class DeviceLocationEvent
{
  private RiderLocation mLocation;

  public DeviceLocationEvent(RiderLocation paramRiderLocation)
  {
    this.mLocation = paramRiderLocation;
  }

  public RiderLocation getLocation()
  {
    return this.mLocation;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.content.event.DeviceLocationEvent
 * JD-Core Version:    0.6.2
 */