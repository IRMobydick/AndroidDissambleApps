package com.ubercab.client.core.network.events;

import com.ubercab.client.core.model.Ping;
import retrofit.RetrofitError;
import retrofit.client.Response;

public final class PayBillResponseEvent extends CnApiResponseEvent
{
  public PayBillResponseEvent(Ping paramPing, Response paramResponse)
  {
    super(paramPing, paramResponse);
  }

  public PayBillResponseEvent(RetrofitError paramRetrofitError)
  {
    super(paramRetrofitError);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.network.events.PayBillResponseEvent
 * JD-Core Version:    0.6.2
 */