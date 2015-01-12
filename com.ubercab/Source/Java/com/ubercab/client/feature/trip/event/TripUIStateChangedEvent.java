package com.ubercab.client.feature.trip.event;

public final class TripUIStateChangedEvent
{
  private final int mState;

  public TripUIStateChangedEvent(int paramInt)
  {
    this.mState = paramInt;
  }

  public int getState()
  {
    return this.mState;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.event.TripUIStateChangedEvent
 * JD-Core Version:    0.6.2
 */