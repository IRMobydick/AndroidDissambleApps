package com.ubercab.client.feature.surge.event;

public final class SurgeConfirmNotificationEvent
{
  private final long mFareId;

  public SurgeConfirmNotificationEvent(long paramLong)
  {
    this.mFareId = paramLong;
  }

  public long getFareId()
  {
    return this.mFareId;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.surge.event.SurgeConfirmNotificationEvent
 * JD-Core Version:    0.6.2
 */