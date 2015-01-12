package com.ubercab.client.core.network.events;

import com.ubercab.client.core.model.FareEstimateResponse;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class FareEstimateResponseEvent extends ResponseEvent<FareEstimateResponse>
{
  public FareEstimateResponseEvent(FareEstimateResponse paramFareEstimateResponse, Response paramResponse)
  {
    super(paramFareEstimateResponse, paramResponse);
  }

  public FareEstimateResponseEvent(RetrofitError paramRetrofitError)
  {
    super(paramRetrofitError);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.network.events.FareEstimateResponseEvent
 * JD-Core Version:    0.6.2
 */