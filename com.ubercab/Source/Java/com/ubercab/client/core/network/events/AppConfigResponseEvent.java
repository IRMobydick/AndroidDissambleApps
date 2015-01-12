package com.ubercab.client.core.network.events;

import com.ubercab.client.core.model.AppConfig;
import retrofit.RetrofitError;
import retrofit.client.Response;

public final class AppConfigResponseEvent extends ResponseEvent<AppConfig>
{
  public AppConfigResponseEvent(AppConfig paramAppConfig, Response paramResponse)
  {
    super(paramAppConfig, paramResponse);
  }

  public AppConfigResponseEvent(RetrofitError paramRetrofitError)
  {
    super(paramRetrofitError);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.network.events.AppConfigResponseEvent
 * JD-Core Version:    0.6.2
 */