package com.ubercab.client.core.network;

import com.squareup.otto.Bus;
import com.ubercab.client.core.content.RiderLocationProvider;
import com.ubercab.client.core.location.RiderLocation;
import com.ubercab.client.core.model.TunesProvider;
import com.ubercab.client.core.network.events.TunesHandshakeResponseEvent;
import com.ubercab.client.core.network.events.TunesProviderResponseEvent;
import com.ubercab.common.collect.ImmutableMap;
import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.util.DeviceUtils;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public final class TunesClient
{
  private static final String PARAM_ACCESS_TOKEN = "access_token";
  private static final String PARAM_PROVIDER_ID = "provider_id";
  private static final String PARAM_TRIP_UUID = "trip_uuid";
  private final TunesApi mApi;
  private final Bus mBus;
  private final RiderLocationProvider mLocationProvider;

  public TunesClient(Bus paramBus, TunesApi paramTunesApi, RiderLocationProvider paramRiderLocationProvider)
  {
    this.mBus = paramBus;
    this.mApi = paramTunesApi;
    this.mLocationProvider = paramRiderLocationProvider;
  }

  public void handshake(String paramString1, String paramString2, String paramString3)
  {
    Callback local2 = new Callback()
    {
      public void failure(RetrofitError paramAnonymousRetrofitError)
      {
        TunesClient.this.mBus.post(new TunesHandshakeResponseEvent(paramAnonymousRetrofitError));
      }

      public void success(Object paramAnonymousObject, Response paramAnonymousResponse)
      {
        TunesClient.this.mBus.post(new TunesHandshakeResponseEvent(paramAnonymousResponse));
      }
    };
    ImmutableMap localImmutableMap = ImmutableMap.of("access_token", paramString3, "provider_id", paramString2, "trip_uuid", paramString1);
    String str = DeviceUtils.getDeviceLanguage();
    this.mApi.handshake(str, localImmutableMap, local2);
  }

  public void provider(String paramString1, String paramString2)
  {
    Callback local1 = new Callback()
    {
      public void failure(RetrofitError paramAnonymousRetrofitError)
      {
        TunesClient.this.mBus.post(new TunesProviderResponseEvent(paramAnonymousRetrofitError));
      }

      public void success(TunesProvider paramAnonymousTunesProvider, Response paramAnonymousResponse)
      {
        TunesClient.this.mBus.post(new TunesProviderResponseEvent(paramAnonymousTunesProvider, paramAnonymousResponse));
      }
    };
    String str = DeviceUtils.getDeviceLanguage();
    UberLatLng localUberLatLng = this.mLocationProvider.getDeviceLocation().getUberLatLng();
    this.mApi.provider(paramString1, str, localUberLatLng.getLatitude(), localUberLatLng.getLongitude(), paramString2, local1);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.network.TunesClient
 * JD-Core Version:    0.6.2
 */