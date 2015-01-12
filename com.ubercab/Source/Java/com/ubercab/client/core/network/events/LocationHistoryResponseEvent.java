package com.ubercab.client.core.network.events;

import com.ubercab.client.core.model.LocationHistoryResponse;
import retrofit.RetrofitError;
import retrofit.client.Response;

public final class LocationHistoryResponseEvent extends ResponseEvent<LocationHistoryResponse>
{
  public LocationHistoryResponseEvent(LocationHistoryResponse paramLocationHistoryResponse, Response paramResponse)
  {
    super(paramLocationHistoryResponse, paramResponse);
  }

  public LocationHistoryResponseEvent(RetrofitError paramRetrofitError)
  {
    super(paramRetrofitError);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.network.events.LocationHistoryResponseEvent
 * JD-Core Version:    0.6.2
 */