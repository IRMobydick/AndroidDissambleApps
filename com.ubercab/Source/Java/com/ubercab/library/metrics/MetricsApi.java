package com.ubercab.library.metrics;

import java.util.Map;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;

public abstract interface MetricsApi
{
  @POST("/event/user/")
  public abstract void sendAnalytics(@Body Map<String, Object> paramMap, Callback<Void> paramCallback);

  @POST("/event/monitoring/")
  public abstract void sendMonitoring(@Body Map<String, Object> paramMap, Callback<Void> paramCallback);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.metrics.MetricsApi
 * JD-Core Version:    0.6.2
 */