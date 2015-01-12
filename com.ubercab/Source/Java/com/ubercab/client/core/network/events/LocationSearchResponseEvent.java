package com.ubercab.client.core.network.events;

import com.ubercab.client.core.model.LocationSearchResponse;
import retrofit.RetrofitError;
import retrofit.client.Response;

public final class LocationSearchResponseEvent extends ResponseEvent<LocationSearchResponse>
{
  private String mQuery;

  public LocationSearchResponseEvent(String paramString, LocationSearchResponse paramLocationSearchResponse, Response paramResponse)
  {
    super(paramLocationSearchResponse, paramResponse);
    this.mQuery = paramString;
  }

  public LocationSearchResponseEvent(String paramString, RetrofitError paramRetrofitError)
  {
    super(paramRetrofitError);
    this.mQuery = paramString;
  }

  public String getQuery()
  {
    return this.mQuery;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.network.events.LocationSearchResponseEvent
 * JD-Core Version:    0.6.2
 */