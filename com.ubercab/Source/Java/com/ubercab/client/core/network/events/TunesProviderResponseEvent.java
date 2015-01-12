package com.ubercab.client.core.network.events;

import com.ubercab.client.core.model.TunesProvider;
import retrofit.RetrofitError;
import retrofit.client.Response;

public final class TunesProviderResponseEvent extends ResponseEvent<TunesProvider>
{
  public TunesProviderResponseEvent(TunesProvider paramTunesProvider, Response paramResponse)
  {
    super(paramTunesProvider, paramResponse);
  }

  public TunesProviderResponseEvent(RetrofitError paramRetrofitError)
  {
    super(paramRetrofitError);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.network.events.TunesProviderResponseEvent
 * JD-Core Version:    0.6.2
 */