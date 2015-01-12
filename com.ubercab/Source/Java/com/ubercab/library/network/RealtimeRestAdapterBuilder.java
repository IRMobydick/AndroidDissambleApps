package com.ubercab.library.network;

import com.google.gson.Gson;
import com.ubercab.library.app.BuildConfigProxy;
import java.util.concurrent.ExecutorService;
import retrofit.RequestInterceptor;
import retrofit.RequestInterceptor.RequestFacade;
import retrofit.RestAdapter;
import retrofit.RestAdapter.Builder;
import retrofit.converter.GsonConverter;

public class RealtimeRestAdapterBuilder
{
  private BuildConfigProxy mBuildConfig;
  private Gson mGson;
  private RestAdapter.Builder mRestAdapterBuilder;
  private UserDataProvider mUserDataProvider;

  public RealtimeRestAdapterBuilder(UberRetrofitClient paramUberRetrofitClient, BuildConfigProxy paramBuildConfigProxy, UberEndpoint paramUberEndpoint, ExecutorService paramExecutorService, Gson paramGson)
  {
    this.mBuildConfig = paramBuildConfigProxy;
    this.mGson = paramGson;
    this.mRestAdapterBuilder = new RestAdapter.Builder().setClient(paramUberRetrofitClient).setEndpoint(paramUberEndpoint).setExecutors(paramExecutorService, paramExecutorService);
  }

  public RestAdapter build()
  {
    if (this.mUserDataProvider == null)
      throw new RuntimeException("You must set a UserDataProvider before attempting to build a RestAdapter.");
    RequestInterceptor local1 = new RequestInterceptor()
    {
      public void intercept(RequestInterceptor.RequestFacade paramAnonymousRequestFacade)
      {
        paramAnonymousRequestFacade.addHeader("X-Uber-Token", RealtimeRestAdapterBuilder.this.mUserDataProvider.getToken());
        paramAnonymousRequestFacade.addHeader("X-Uber-Id", RealtimeRestAdapterBuilder.this.mUserDataProvider.getUserUuid());
        paramAnonymousRequestFacade.addHeader("X-Uber-Origin", "android-" + RealtimeRestAdapterBuilder.this.mBuildConfig.getAppName());
      }
    };
    return this.mRestAdapterBuilder.setConverter(new GsonConverter(this.mGson)).setRequestInterceptor(local1).build();
  }

  public RealtimeRestAdapterBuilder setGson(Gson paramGson)
  {
    this.mGson = paramGson;
    return this;
  }

  public RealtimeRestAdapterBuilder setUserDataProvider(UserDataProvider paramUserDataProvider)
  {
    this.mUserDataProvider = paramUserDataProvider;
    return this;
  }

  public static abstract interface UserDataProvider
  {
    public abstract String getToken();

    public abstract String getUserUuid();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.network.RealtimeRestAdapterBuilder
 * JD-Core Version:    0.6.2
 */