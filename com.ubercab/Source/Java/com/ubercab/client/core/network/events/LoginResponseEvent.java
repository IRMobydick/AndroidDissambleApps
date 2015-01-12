package com.ubercab.client.core.network.events;

import com.ubercab.client.core.model.Ping;
import retrofit.RetrofitError;
import retrofit.client.Response;

public final class LoginResponseEvent extends CnResponseEvent<Ping>
{
  public LoginResponseEvent(Ping paramPing, Response paramResponse)
  {
    super(paramPing, paramResponse);
  }

  public LoginResponseEvent(RetrofitError paramRetrofitError)
  {
    super(paramRetrofitError);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.network.events.LoginResponseEvent
 * JD-Core Version:    0.6.2
 */