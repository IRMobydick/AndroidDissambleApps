package com.google.android.gms.plus;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.internal.e;
import com.google.android.gms.plus.internal.i;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

@Deprecated
public class PlusClient
  implements GooglePlayServicesClient
{
  final e ald;

  PlusClient(e parame)
  {
    this.ald = parame;
  }

  @Deprecated
  public void clearDefaultAccount()
  {
    this.ald.clearDefaultAccount();
  }

  @Deprecated
  public void connect()
  {
    this.ald.connect();
  }

  @Deprecated
  public void disconnect()
  {
    this.ald.disconnect();
  }

  @Deprecated
  public String getAccountName()
  {
    return this.ald.getAccountName();
  }

  @Deprecated
  public Person getCurrentPerson()
  {
    return this.ald.getCurrentPerson();
  }

  @Deprecated
  public boolean isConnected()
  {
    return this.ald.isConnected();
  }

  @Deprecated
  public boolean isConnecting()
  {
    return this.ald.isConnecting();
  }

  @Deprecated
  public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    return this.ald.isConnectionCallbacksRegistered(paramConnectionCallbacks);
  }

  @Deprecated
  public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return this.ald.isConnectionFailedListenerRegistered(paramOnConnectionFailedListener);
  }

  @Deprecated
  public void loadMoments(final OnMomentsLoadedListener paramOnMomentsLoadedListener)
  {
    this.ald.k(new BaseImplementation.b()
    {
      public void a(Moments.LoadMomentsResult paramAnonymousLoadMomentsResult)
      {
        paramOnMomentsLoadedListener.onMomentsLoaded(paramAnonymousLoadMomentsResult.getStatus().gt(), paramAnonymousLoadMomentsResult.getMomentBuffer(), paramAnonymousLoadMomentsResult.getNextPageToken(), paramAnonymousLoadMomentsResult.getUpdated());
      }
    });
  }

  @Deprecated
  public void loadMoments(final OnMomentsLoadedListener paramOnMomentsLoadedListener, int paramInt, String paramString1, Uri paramUri, String paramString2, String paramString3)
  {
    this.ald.a(new BaseImplementation.b()
    {
      public void a(Moments.LoadMomentsResult paramAnonymousLoadMomentsResult)
      {
        paramOnMomentsLoadedListener.onMomentsLoaded(paramAnonymousLoadMomentsResult.getStatus().gt(), paramAnonymousLoadMomentsResult.getMomentBuffer(), paramAnonymousLoadMomentsResult.getNextPageToken(), paramAnonymousLoadMomentsResult.getUpdated());
      }
    }
    , paramInt, paramString1, paramUri, paramString2, paramString3);
  }

  @Deprecated
  public void loadPeople(final OnPeopleLoadedListener paramOnPeopleLoadedListener, Collection<String> paramCollection)
  {
    this.ald.a(new BaseImplementation.b()
    {
      public void a(People.LoadPeopleResult paramAnonymousLoadPeopleResult)
      {
        paramOnPeopleLoadedListener.onPeopleLoaded(paramAnonymousLoadPeopleResult.getStatus().gt(), paramAnonymousLoadPeopleResult.getPersonBuffer(), paramAnonymousLoadPeopleResult.getNextPageToken());
      }
    }
    , paramCollection);
  }

  @Deprecated
  public void loadPeople(final OnPeopleLoadedListener paramOnPeopleLoadedListener, String[] paramArrayOfString)
  {
    this.ald.d(new BaseImplementation.b()
    {
      public void a(People.LoadPeopleResult paramAnonymousLoadPeopleResult)
      {
        paramOnPeopleLoadedListener.onPeopleLoaded(paramAnonymousLoadPeopleResult.getStatus().gt(), paramAnonymousLoadPeopleResult.getPersonBuffer(), paramAnonymousLoadPeopleResult.getNextPageToken());
      }
    }
    , paramArrayOfString);
  }

  @Deprecated
  public void loadVisiblePeople(final OnPeopleLoadedListener paramOnPeopleLoadedListener, int paramInt, String paramString)
  {
    this.ald.a(new BaseImplementation.b()
    {
      public void a(People.LoadPeopleResult paramAnonymousLoadPeopleResult)
      {
        paramOnPeopleLoadedListener.onPeopleLoaded(paramAnonymousLoadPeopleResult.getStatus().gt(), paramAnonymousLoadPeopleResult.getPersonBuffer(), paramAnonymousLoadPeopleResult.getNextPageToken());
      }
    }
    , paramInt, paramString);
  }

  @Deprecated
  public void loadVisiblePeople(final OnPeopleLoadedListener paramOnPeopleLoadedListener, String paramString)
  {
    this.ald.r(new BaseImplementation.b()
    {
      public void a(People.LoadPeopleResult paramAnonymousLoadPeopleResult)
      {
        paramOnPeopleLoadedListener.onPeopleLoaded(paramAnonymousLoadPeopleResult.getStatus().gt(), paramAnonymousLoadPeopleResult.getPersonBuffer(), paramAnonymousLoadPeopleResult.getNextPageToken());
      }
    }
    , paramString);
  }

  e mZ()
  {
    return this.ald;
  }

  @Deprecated
  public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.ald.registerConnectionCallbacks(paramConnectionCallbacks);
  }

  @Deprecated
  public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.ald.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }

  @Deprecated
  public void removeMoment(String paramString)
  {
    this.ald.removeMoment(paramString);
  }

  @Deprecated
  public void revokeAccessAndDisconnect(final OnAccessRevokedListener paramOnAccessRevokedListener)
  {
    this.ald.m(new BaseImplementation.b()
    {
      public void aA(Status paramAnonymousStatus)
      {
        paramOnAccessRevokedListener.onAccessRevoked(paramAnonymousStatus.getStatus().gt());
      }
    });
  }

  @Deprecated
  public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.ald.unregisterConnectionCallbacks(paramConnectionCallbacks);
  }

  @Deprecated
  public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.ald.unregisterConnectionFailedListener(paramOnConnectionFailedListener);
  }

  @Deprecated
  public void writeMoment(Moment paramMoment)
  {
    this.ald.a(null, paramMoment);
  }

  @Deprecated
  public static class Builder
  {
    private final GooglePlayServicesClient.ConnectionCallbacks ali;
    private final GooglePlayServicesClient.OnConnectionFailedListener alj;
    private final i alk;
    private final Context mContext;

    public Builder(Context paramContext, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      this.mContext = paramContext;
      this.ali = paramConnectionCallbacks;
      this.alj = paramOnConnectionFailedListener;
      this.alk = new i(this.mContext);
    }

    public PlusClient build()
    {
      return new PlusClient(new e(this.mContext, this.ali, this.alj, this.alk.nq()));
    }

    public Builder clearScopes()
    {
      this.alk.np();
      return this;
    }

    public Builder setAccountName(String paramString)
    {
      this.alk.ch(paramString);
      return this;
    }

    public Builder setActions(String[] paramArrayOfString)
    {
      this.alk.h(paramArrayOfString);
      return this;
    }

    public Builder setScopes(String[] paramArrayOfString)
    {
      this.alk.g(paramArrayOfString);
      return this;
    }
  }

  @Deprecated
  public static abstract interface OnAccessRevokedListener
  {
    public abstract void onAccessRevoked(ConnectionResult paramConnectionResult);
  }

  @Deprecated
  public static abstract interface OnMomentsLoadedListener
  {
    @Deprecated
    public abstract void onMomentsLoaded(ConnectionResult paramConnectionResult, MomentBuffer paramMomentBuffer, String paramString1, String paramString2);
  }

  @Deprecated
  public static abstract interface OnPeopleLoadedListener
  {
    public abstract void onPeopleLoaded(ConnectionResult paramConnectionResult, PersonBuffer paramPersonBuffer, String paramString);
  }

  @Deprecated
  public static abstract interface OrderBy
  {

    @Deprecated
    public static final int ALPHABETICAL = 0;

    @Deprecated
    public static final int BEST = 1;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.PlusClient
 * JD-Core Version:    0.6.2
 */