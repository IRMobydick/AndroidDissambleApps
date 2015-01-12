package com.ubercab.client.core.network.events;

import com.ubercab.client.core.model.TunesProvider;
import retrofit.RetrofitError;
import retrofit.client.Response;

public final class TunesHandshakeResponseEvent extends ResponseEvent<TunesProvider>
{
  public TunesHandshakeResponseEvent(RetrofitError paramRetrofitError)
  {
    super(paramRetrofitError);
  }

  public TunesHandshakeResponseEvent(Response paramResponse)
  {
    super(null, paramResponse);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.network.events.TunesHandshakeResponseEvent
 * JD-Core Version:    0.6.2
 */