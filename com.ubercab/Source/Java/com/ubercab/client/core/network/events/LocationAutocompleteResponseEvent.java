package com.ubercab.client.core.network.events;

import com.ubercab.client.core.model.LocationAutocompleteResponse;
import retrofit.RetrofitError;
import retrofit.client.Response;

public final class LocationAutocompleteResponseEvent extends ResponseEvent<LocationAutocompleteResponse>
{
  private String mQuery;

  public LocationAutocompleteResponseEvent(String paramString, LocationAutocompleteResponse paramLocationAutocompleteResponse, Response paramResponse)
  {
    super(paramLocationAutocompleteResponse, paramResponse);
    this.mQuery = paramString;
  }

  public LocationAutocompleteResponseEvent(String paramString, RetrofitError paramRetrofitError)
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
 * Qualified Name:     com.ubercab.client.core.network.events.LocationAutocompleteResponseEvent
 * JD-Core Version:    0.6.2
 */