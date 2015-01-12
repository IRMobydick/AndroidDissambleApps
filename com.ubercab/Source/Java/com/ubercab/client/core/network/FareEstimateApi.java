package com.ubercab.client.core.network;

import com.ubercab.client.core.model.FareEstimateResponse;
import java.util.List;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Query;

public abstract interface FareEstimateApi
{
  public static final String URL = "https://cn.uber.com/rt";

  @GET("/fare/estimate")
  public abstract void fareEstimates(@Header("x-uber-token") String paramString1, @Query("origin_lat") double paramDouble1, @Query("origin_lng") double paramDouble2, @Query("destination_lat") double paramDouble3, @Query("destination_lng") double paramDouble4, @Query("vehicle_view_ids") List<String> paramList, @Query("dynamic_fare_info") String paramString2, Callback<FareEstimateResponse> paramCallback);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.network.FareEstimateApi
 * JD-Core Version:    0.6.2
 */