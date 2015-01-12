package com.ubercab.client.feature.surge.event;

public final class SurgeAcceptedEvent
{
  private final long mFareId;

  public SurgeAcceptedEvent(long paramLong)
  {
    this.mFareId = paramLong;
  }

  public long getFareId()
  {
    return this.mFareId;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.surge.event.SurgeAcceptedEvent
 * JD-Core Version:    0.6.2
 */