package com.ubercab.client.core.network.events;

import com.ubercab.client.core.model.LocationTagDeleteResponse;
import retrofit.RetrofitError;
import retrofit.client.Response;

public final class LocationTagDeleteResponseEvent extends ResponseEvent<LocationTagDeleteResponse>
{
  public LocationTagDeleteResponseEvent(LocationTagDeleteResponse paramLocationTagDeleteResponse, Response paramResponse)
  {
    super(paramLocationTagDeleteResponse, paramResponse);
  }

  public LocationTagDeleteResponseEvent(RetrofitError paramRetrofitError)
  {
    super(paramRetrofitError);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.network.events.LocationTagDeleteResponseEvent
 * JD-Core Version:    0.6.2
 */