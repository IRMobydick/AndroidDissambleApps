package com.ubercab.client.core.network;

import com.squareup.otto.Bus;
import com.ubercab.client.core.app.RiderPreferences;
import com.ubercab.client.core.model.AppConfig;
import com.ubercab.client.core.network.events.AppConfigResponseEvent;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class AppConfigClient
{
  private static final String RIDER_CLIENT_NAME = "client";
  private AppConfig mAnonymousAppConfig;
  private final AppConfigApi mApi;
  private final Bus mBus;
  private final RiderPreferences mRiderPreferences;

  public AppConfigClient(Bus paramBus, AppConfigApi paramAppConfigApi, RiderPreferences paramRiderPreferences)
  {
    this.mApi = paramAppConfigApi;
    this.mBus = paramBus;
    this.mRiderPreferences = paramRiderPreferences;
  }

  private void injectEmployeeSettings(AppConfig paramAppConfig)
  {
    if (paramAppConfig == null)
      return;
    if ((this.mRiderPreferences.isPayTmSignupEnabled()) || (paramAppConfig.isPayTmSignupEnabled().booleanValue()));
    for (boolean bool = true; ; bool = false)
    {
      paramAppConfig.setPayTmSignupEnabled(bool);
      return;
    }
  }

  public void getAnonymousAppConfig()
  {
    Callback local1 = new Callback()
    {
      public void failure(RetrofitError paramAnonymousRetrofitError)
      {
        AppConfigClient.this.mBus.post(new AppConfigResponseEvent(paramAnonymousRetrofitError));
      }

      public void success(AppConfig paramAnonymousAppConfig, Response paramAnonymousResponse)
      {
        AppConfigClient.this.injectEmployeeSettings(paramAnonymousAppConfig);
        AppConfigClient.access$102(AppConfigClient.this, paramAnonymousAppConfig);
        AppConfigClient.this.mBus.post(new AppConfigResponseEvent(paramAnonymousAppConfig, paramAnonymousResponse));
      }
    };
    this.mApi.getAppConfig("client", local1);
  }

  public AppConfig getLastAnonymousAppConfig()
  {
    if (this.mAnonymousAppConfig != null)
      return this.mAnonymousAppConfig;
    return new AppConfig();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.network.AppConfigClient
 * JD-Core Version:    0.6.2
 */