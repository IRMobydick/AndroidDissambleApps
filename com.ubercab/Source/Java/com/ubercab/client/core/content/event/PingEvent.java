package com.ubercab.client.core.content.event;

import com.ubercab.client.core.model.Ping;

public final class PingEvent
{
  private final Ping mPing;
  private final long mPingTime;

  public PingEvent(Ping paramPing, long paramLong)
  {
    this.mPing = paramPing;
    this.mPingTime = paramLong;
  }

  public Ping getPing()
  {
    return this.mPing;
  }

  public long getPingTime()
  {
    return this.mPingTime;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.content.event.PingEvent
 * JD-Core Version:    0.6.2
 */