package com.ubercab.client.core.network.events;

import com.ubercab.client.core.model.LocationTagAddResponse;
import retrofit.RetrofitError;
import retrofit.client.Response;

public final class LocationTagAddResponseEvent extends ResponseEvent<LocationTagAddResponse>
{
  public LocationTagAddResponseEvent(LocationTagAddResponse paramLocationTagAddResponse, Response paramResponse)
  {
    super(paramLocationTagAddResponse, paramResponse);
  }

  public LocationTagAddResponseEvent(RetrofitError paramRetrofitError)
  {
    super(paramRetrofitError);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.network.events.LocationTagAddResponseEvent
 * JD-Core Version:    0.6.2
 */