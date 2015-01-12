package com.ubercab.client.core.network.events;

import com.ubercab.client.core.model.Ping;
import retrofit.RetrofitError;
import retrofit.client.Response;

public final class UpdatePaymentProfileResponseEvent extends CnApiResponseEvent
{
  public UpdatePaymentProfileResponseEvent(Ping paramPing, Response paramResponse)
  {
    super(paramPing, paramResponse);
  }

  public UpdatePaymentProfileResponseEvent(RetrofitError paramRetrofitError)
  {
    super(paramRetrofitError);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.network.events.UpdatePaymentProfileResponseEvent
 * JD-Core Version:    0.6.2
 */