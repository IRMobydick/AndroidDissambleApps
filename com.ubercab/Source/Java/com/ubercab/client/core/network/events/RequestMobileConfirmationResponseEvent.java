package com.ubercab.client.core.network.events;

import com.ubercab.client.core.model.Ping;
import retrofit.RetrofitError;
import retrofit.client.Response;

public final class RequestMobileConfirmationResponseEvent extends CnApiResponseEvent
{
  public RequestMobileConfirmationResponseEvent(Ping paramPing, Response paramResponse)
  {
    super(paramPing, paramResponse);
  }

  public RequestMobileConfirmationResponseEvent(RetrofitError paramRetrofitError)
  {
    super(paramRetrofitError);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.network.events.RequestMobileConfirmationResponseEvent
 * JD-Core Version:    0.6.2
 */