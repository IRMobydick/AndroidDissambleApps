package com.ubercab.library.network.cn;

import com.ubercab.library.network.cn.model.CnFile;
import java.util.Map;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

public abstract interface CnApi
{
  @GET("/cn.txt")
  public abstract void cnFile(Callback<CnFile> paramCallback);

  @POST("/mobile_logs")
  public abstract void uploadMobileLogs(@Body Map<String, String> paramMap, Callback<Void> paramCallback);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.network.cn.CnApi
 * JD-Core Version:    0.6.2
 */