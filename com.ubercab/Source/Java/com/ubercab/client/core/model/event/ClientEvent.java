package com.ubercab.client.core.model.event;

import com.ubercab.client.core.model.Client;

public final class ClientEvent
{
  private final Client mClient;

  public ClientEvent(Client paramClient)
  {
    this.mClient = paramClient;
  }

  public Client getClient()
  {
    return this.mClient;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.event.ClientEvent
 * JD-Core Version:    0.6.2
 */