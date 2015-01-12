package com.ubercab.library.network;

import retrofit.Endpoint;
import retrofit.client.Response;

public abstract interface FailoverStrategy extends Endpoint
{
  public abstract void changeEndpoint();

  public abstract boolean interceptResponse(Response paramResponse);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.network.FailoverStrategy
 * JD-Core Version:    0.6.2
 */