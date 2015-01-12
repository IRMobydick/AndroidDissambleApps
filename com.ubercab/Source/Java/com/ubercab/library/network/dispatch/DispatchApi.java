package com.ubercab.library.network.dispatch;

import com.ubercab.library.network.dispatch.model.DispatchResponse;
import java.util.Map;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.Header;
import retrofit.http.POST;

public abstract interface DispatchApi
{
  @POST("/")
  public abstract void request(@Body Map<String, Object> paramMap, @Header("X-Uber-Token") String paramString, Callback<DispatchResponse> paramCallback);

  @POST("/")
  public abstract void request(@Body Map<String, Object> paramMap, Callback<DispatchResponse> paramCallback);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.network.dispatch.DispatchApi
 * JD-Core Version:    0.6.2
 */