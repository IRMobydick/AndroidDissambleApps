package com.ubercab.client.core.network.events;

import com.ubercab.client.core.model.CombinedLocationHistoryResponse;
import retrofit.RetrofitError;
import retrofit.client.Response;

public final class CombinedLocationHistoryResponseEvent extends ResponseEvent<CombinedLocationHistoryResponse>
{
  public CombinedLocationHistoryResponseEvent(CombinedLocationHistoryResponse paramCombinedLocationHistoryResponse, Response paramResponse)
  {
    super(paramCombinedLocationHistoryResponse, paramResponse);
  }

  public CombinedLocationHistoryResponseEvent(RetrofitError paramRetrofitError)
  {
    super(paramRetrofitError);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.network.events.CombinedLocationHistoryResponseEvent
 * JD-Core Version:    0.6.2
 */