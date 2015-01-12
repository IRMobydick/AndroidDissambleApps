package com.ubercab.client.core.vendor.google.network;

import com.ubercab.client.core.vendor.google.model.DirectionsResponse;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public abstract interface DirectionsApi
{
  public static final String PARAM_MODE_DRIVING = "driving";
  public static final String URL = "https://maps.googleapis.com";

  @GET("/maps/api/directions/json")
  public abstract void directions(@Query("origin") String paramString1, @Query("destination") String paramString2, @Query("mode") String paramString3, @Query("language") String paramString4, Callback<DirectionsResponse> paramCallback);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.vendor.google.network.DirectionsApi
 * JD-Core Version:    0.6.2
 */