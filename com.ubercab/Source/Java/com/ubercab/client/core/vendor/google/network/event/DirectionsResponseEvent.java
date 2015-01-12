package com.ubercab.client.core.vendor.google.network.event;

import com.ubercab.client.core.network.events.ResponseEvent;
import com.ubercab.client.core.vendor.google.model.DirectionsResponse;
import retrofit.RetrofitError;
import retrofit.client.Response;

public final class DirectionsResponseEvent extends ResponseEvent<DirectionsResponse>
{
  public DirectionsResponseEvent(DirectionsResponse paramDirectionsResponse, Response paramResponse)
  {
    super(paramDirectionsResponse, paramResponse);
  }

  public DirectionsResponseEvent(RetrofitError paramRetrofitError)
  {
    super(paramRetrofitError);
  }

  public boolean isSuccess()
  {
    return (super.isSuccess()) && (((DirectionsResponse)getModel()).isSuccess());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.vendor.google.network.event.DirectionsResponseEvent
 * JD-Core Version:    0.6.2
 */