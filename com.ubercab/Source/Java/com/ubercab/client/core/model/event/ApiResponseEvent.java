package com.ubercab.client.core.model.event;

import com.ubercab.client.core.model.ApiResponse;

public final class ApiResponseEvent
{
  private final ApiResponse mApiRespone;

  public ApiResponseEvent(ApiResponse paramApiResponse)
  {
    this.mApiRespone = paramApiResponse;
  }

  public ApiResponse getIsForceUpgrade()
  {
    return this.mApiRespone;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.event.ApiResponseEvent
 * JD-Core Version:    0.6.2
 */