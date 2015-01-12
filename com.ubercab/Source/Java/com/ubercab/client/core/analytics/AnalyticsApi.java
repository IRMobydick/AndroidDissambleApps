package com.ubercab.client.core.analytics;

import java.util.Map;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;

@Deprecated
public abstract interface AnalyticsApi
{
  public static final String URL = "https://events.uber.com";

  @POST("/mobile/event/")
  public abstract void event(@Body Map<String, Object> paramMap, Callback<Void> paramCallback);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.analytics.AnalyticsApi
 * JD-Core Version:    0.6.2
 */