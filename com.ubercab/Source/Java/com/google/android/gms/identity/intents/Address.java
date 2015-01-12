package com.google.android.gms.identity.intents;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.BaseImplementation.a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.o;
import com.google.android.gms.internal.lm;

public final class Address
{
  public static final Api<AddressOptions> API = new Api(CV, CU, new Scope[0]);
  static final Api.c<lm> CU = new Api.c();
  private static final Api.b<lm, AddressOptions> CV = new Api.b()
  {
    public lm a(Context paramAnonymousContext, Looper paramAnonymousLooper, ClientSettings paramAnonymousClientSettings, Address.AddressOptions paramAnonymousAddressOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      o.b(paramAnonymousContext instanceof Activity, "An Activity must be used for Address APIs");
      if (paramAnonymousAddressOptions == null)
        paramAnonymousAddressOptions = new Address.AddressOptions();
      return new lm((Activity)paramAnonymousContext, paramAnonymousLooper, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener, paramAnonymousClientSettings.getAccountName(), paramAnonymousAddressOptions.theme);
    }

    public int getPriority()
    {
      return 2147483647;
    }
  };

  public static void requestUserAddress(GoogleApiClient paramGoogleApiClient, UserAddressRequest paramUserAddressRequest, final int paramInt)
  {
    paramGoogleApiClient.a(new a()
    {
      protected void a(lm paramAnonymouslm)
        throws RemoteException
      {
        paramAnonymouslm.a(this.adI, paramInt);
        b(Status.Jv);
      }
    });
  }

  public static final class AddressOptions
    implements Api.ApiOptions.HasOptions
  {
    public final int theme;

    public AddressOptions()
    {
      this.theme = 0;
    }

    public AddressOptions(int paramInt)
    {
      this.theme = paramInt;
    }
  }

  private static abstract class a extends BaseImplementation.a<Status, lm>
  {
    public a()
    {
      super();
    }

    public Status d(Status paramStatus)
    {
      return paramStatus;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.identity.intents.Address
 * JD-Core Version:    0.6.2
 */