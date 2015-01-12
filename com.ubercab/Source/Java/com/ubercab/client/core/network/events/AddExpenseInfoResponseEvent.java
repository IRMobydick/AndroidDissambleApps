package com.ubercab.client.core.network.events;

import com.ubercab.client.core.model.Ping;
import retrofit.RetrofitError;
import retrofit.client.Response;

public final class AddExpenseInfoResponseEvent extends CnResponseEvent<Ping>
{
  public AddExpenseInfoResponseEvent(Ping paramPing, Response paramResponse)
  {
    super(paramPing, paramResponse);
  }

  public AddExpenseInfoResponseEvent(RetrofitError paramRetrofitError)
  {
    super(paramRetrofitError);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.network.events.AddExpenseInfoResponseEvent
 * JD-Core Version:    0.6.2
 */