package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.BaseImplementation.a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.o;
import com.google.android.gms.internal.lu;
import com.google.android.gms.internal.lv;
import com.google.android.gms.internal.lz;

public class LocationServices
{
  public static final Api<Api.ApiOptions.NoOptions> API = new Api(CV, CU, new Scope[0]);
  private static final Api.c<lz> CU = new Api.c();
  private static final Api.b<lz, Api.ApiOptions.NoOptions> CV = new Api.b()
  {
    public lz d(Context paramAnonymousContext, Looper paramAnonymousLooper, ClientSettings paramAnonymousClientSettings, Api.ApiOptions.NoOptions paramAnonymousNoOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new lz(paramAnonymousContext, paramAnonymousLooper, paramAnonymousContext.getPackageName(), paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener, "locationServices", paramAnonymousClientSettings.getAccountName());
    }

    public int getPriority()
    {
      return 2147483647;
    }
  };
  public static FusedLocationProviderApi FusedLocationApi = new lu();
  public static GeofencingApi GeofencingApi = new lv();

  public static lz e(GoogleApiClient paramGoogleApiClient)
  {
    boolean bool1 = true;
    boolean bool2;
    lz locallz;
    if (paramGoogleApiClient != null)
    {
      bool2 = bool1;
      o.b(bool2, "GoogleApiClient parameter is required.");
      locallz = (lz)paramGoogleApiClient.a(CU);
      if (locallz == null)
        break label44;
    }
    while (true)
    {
      o.a(bool1, "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
      return locallz;
      bool2 = false;
      break;
      label44: bool1 = false;
    }
  }

  public static abstract class a<R extends Result> extends BaseImplementation.a<R, lz>
  {
    public a()
    {
      super();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.LocationServices
 * JD-Core Version:    0.6.2
 */