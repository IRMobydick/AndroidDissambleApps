package com.ubercab.client.core.network;

import com.ubercab.client.core.model.ClientSignupResponse;
import java.util.Map;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;

public abstract interface SignupApi
{
  @POST("/signup/clients/create")
  public abstract void create(@Body Map<String, Object> paramMap, Callback<ClientSignupResponse> paramCallback);

  @POST("/signup/clients/validate")
  public abstract void validate(@Body Map<String, Object> paramMap, Callback<Map<String, Object>> paramCallback);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.network.SignupApi
 * JD-Core Version:    0.6.2
 */