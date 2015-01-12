package com.ubercab.client.core.model.event;

import com.ubercab.client.core.model.Session;

public final class SessionEvent
{
  private final Session mSession;

  public SessionEvent(Session paramSession)
  {
    this.mSession = paramSession;
  }

  public Session getSession()
  {
    return this.mSession;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.event.SessionEvent
 * JD-Core Version:    0.6.2
 */