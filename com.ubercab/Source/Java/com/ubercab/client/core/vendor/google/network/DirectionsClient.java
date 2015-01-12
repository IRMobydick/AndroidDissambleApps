package com.ubercab.client.core.vendor.google.network;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.otto.Bus;
import com.ubercab.client.core.location.RiderLocation;
import com.ubercab.client.core.network.RetrofitCallbackBusAdapter;
import com.ubercab.client.core.vendor.google.network.event.DirectionsResponseEvent;
import com.ubercab.library.location.model.UberLatLng;
import java.util.Locale;
import retrofit.RestAdapter;
import retrofit.RestAdapter.Builder;
import retrofit.client.OkClient;

public final class DirectionsClient
{
  private static final String FORMAT_PARAM_LATLNG = "%s,%s";
  private final Bus mBus;
  private final DirectionsApi mDirectionsApi;

  public DirectionsClient(Bus paramBus, OkHttpClient paramOkHttpClient)
  {
    this.mBus = paramBus;
    this.mDirectionsApi = ((DirectionsApi)new RestAdapter.Builder().setClient(new OkClient(paramOkHttpClient)).setEndpoint("https://maps.googleapis.com").build().create(DirectionsApi.class));
  }

  private static String getLatLngParam(RiderLocation paramRiderLocation)
  {
    UberLatLng localUberLatLng = paramRiderLocation.getUberLatLng();
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Double.valueOf(localUberLatLng.getLatitude());
    arrayOfObject[1] = Double.valueOf(localUberLatLng.getLongitude());
    return String.format("%s,%s", arrayOfObject);
  }

  public void directions(RiderLocation paramRiderLocation1, RiderLocation paramRiderLocation2)
  {
    RetrofitCallbackBusAdapter localRetrofitCallbackBusAdapter = new RetrofitCallbackBusAdapter(this.mBus, DirectionsResponseEvent.class);
    this.mDirectionsApi.directions(getLatLngParam(paramRiderLocation1), getLatLngParam(paramRiderLocation2), "driving", Locale.getDefault().getLanguage(), localRetrofitCallbackBusAdapter);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.vendor.google.network.DirectionsClient
 * JD-Core Version:    0.6.2
 */