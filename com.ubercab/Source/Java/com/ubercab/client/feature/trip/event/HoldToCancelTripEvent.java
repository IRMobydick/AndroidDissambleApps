package com.ubercab.client.feature.trip.event;

public final class HoldToCancelTripEvent
{
  private final boolean mIsCanceling;

  public HoldToCancelTripEvent(boolean paramBoolean)
  {
    this.mIsCanceling = paramBoolean;
  }

  public boolean isCanceling()
  {
    return this.mIsCanceling;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.event.HoldToCancelTripEvent
 * JD-Core Version:    0.6.2
 */