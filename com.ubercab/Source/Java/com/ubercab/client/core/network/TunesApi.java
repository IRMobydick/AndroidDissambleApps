package com.ubercab.client.core.network;

import com.ubercab.client.core.model.TunesProvider;
import java.util.Map;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

public abstract interface TunesApi
{
  @POST("/rt/utunes/rider/handshake")
  public abstract void handshake(@Header("accept-language") String paramString, @Body Map<String, String> paramMap, Callback<Object> paramCallback);

  @GET("/rt/utunes/providers/{id}")
  public abstract void provider(@Path("id") String paramString1, @Header("accept-language") String paramString2, @Query("latitude") double paramDouble1, @Query("longitude") double paramDouble2, @Query("city_name") String paramString3, Callback<TunesProvider> paramCallback);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.network.TunesApi
 * JD-Core Version:    0.6.2
 */