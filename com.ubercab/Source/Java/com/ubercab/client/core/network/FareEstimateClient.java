package com.ubercab.client.core.network;

import android.text.TextUtils;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.otto.Bus;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.core.model.FareEstimateResponse;
import com.ubercab.client.core.network.events.FareEstimateResponseEvent;
import com.ubercab.library.location.model.UberLatLng;
import java.util.List;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RestAdapter.Builder;
import retrofit.RetrofitError;
import retrofit.client.OkClient;
import retrofit.client.Response;

public class FareEstimateClient
{
  private final FareEstimateApi mApi;
  private final Bus mBus;
  private final SessionPreferences mSessionPreferences;

  public FareEstimateClient(Bus paramBus, OkHttpClient paramOkHttpClient, SessionPreferences paramSessionPreferences)
  {
    this.mApi = ((FareEstimateApi)new RestAdapter.Builder().setClient(new OkClient(paramOkHttpClient)).setEndpoint("https://cn.uber.com/rt").build().create(FareEstimateApi.class));
    this.mBus = paramBus;
    this.mSessionPreferences = paramSessionPreferences;
  }

  private String ensureToken()
  {
    String str = this.mSessionPreferences.getToken();
    if (TextUtils.isEmpty(str))
      throw new IllegalStateException("Token is required");
    return str;
  }

  public void fareEstimates(UberLatLng paramUberLatLng1, UberLatLng paramUberLatLng2, List<String> paramList, String paramString)
  {
    Callback local1 = new Callback()
    {
      public void failure(RetrofitError paramAnonymousRetrofitError)
      {
        FareEstimateClient.this.mBus.post(new FareEstimateResponseEvent(paramAnonymousRetrofitError));
      }

      public void success(FareEstimateResponse paramAnonymousFareEstimateResponse, Response paramAnonymousResponse)
      {
        FareEstimateClient.this.mBus.post(new FareEstimateResponseEvent(paramAnonymousFareEstimateResponse, paramAnonymousResponse));
      }
    };
    this.mApi.fareEstimates(ensureToken(), paramUberLatLng1.getLatitude(), paramUberLatLng1.getLongitude(), paramUberLatLng2.getLatitude(), paramUberLatLng2.getLongitude(), paramList, paramString, local1);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.network.FareEstimateClient
 * JD-Core Version:    0.6.2
 */