package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;

public final class hd
{
  public static final Api.c<hy> BN = new Api.c();
  private static final Api.b<hy, Api.ApiOptions.NoOptions> BO = new Api.b()
  {
    public hy a(Context paramAnonymousContext, Looper paramAnonymousLooper, ClientSettings paramAnonymousClientSettings, Api.ApiOptions.NoOptions paramAnonymousNoOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new hy(paramAnonymousContext, paramAnonymousLooper, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
    }

    public int getPriority()
    {
      return 2147483647;
    }
  };
  public static final Api<Api.ApiOptions.NoOptions> BP = new Api(BO, BN, new Scope[0]);
  public static final hu BQ = new hz();
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hd
 * JD-Core Version:    0.6.2
 */