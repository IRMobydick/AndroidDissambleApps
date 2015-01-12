package com.ubercab.client.core.model.event;

import com.ubercab.client.core.model.Trip;

public final class TripEvent
{
  private final Trip mTrip;

  public TripEvent(Trip paramTrip)
  {
    this.mTrip = paramTrip;
  }

  public Trip getTrip()
  {
    return this.mTrip;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.event.TripEvent
 * JD-Core Version:    0.6.2
 */