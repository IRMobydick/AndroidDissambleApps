package com.ubercab.client.core.network.events;

import com.ubercab.client.core.model.LocationSearchResult;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class LocationDetailResponseEvent extends ResponseEvent<LocationSearchResult>
{
  private final String mRequestReference;
  private final String mRequestType;

  public LocationDetailResponseEvent(String paramString1, String paramString2, LocationSearchResult paramLocationSearchResult, Response paramResponse)
  {
    super(paramLocationSearchResult, paramResponse);
    this.mRequestReference = paramString1;
    this.mRequestType = paramString2;
  }

  public LocationDetailResponseEvent(String paramString1, String paramString2, RetrofitError paramRetrofitError)
  {
    super(paramRetrofitError);
    this.mRequestReference = paramString1;
    this.mRequestType = paramString2;
  }

  public String getRequestReference()
  {
    return this.mRequestReference;
  }

  public String getRequestType()
  {
    return this.mRequestType;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.network.events.LocationDetailResponseEvent
 * JD-Core Version:    0.6.2
 */