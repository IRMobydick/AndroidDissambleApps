package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationServices.a;

public class lu
  implements FusedLocationProviderApi
{
  public Location getLastLocation(GoogleApiClient paramGoogleApiClient)
  {
    lz locallz = LocationServices.e(paramGoogleApiClient);
    try
    {
      Location localLocation = locallz.getLastLocation();
      return localLocation;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public PendingResult<Status> removeLocationUpdates(GoogleApiClient paramGoogleApiClient, final PendingIntent paramPendingIntent)
  {
    return paramGoogleApiClient.b(new a(paramPendingIntent)
    {
      protected void a(lz paramAnonymouslz)
        throws RemoteException
      {
        paramAnonymouslz.removeLocationUpdates(paramPendingIntent);
        b(Status.Jv);
      }
    });
  }

  public PendingResult<Status> removeLocationUpdates(GoogleApiClient paramGoogleApiClient, final LocationListener paramLocationListener)
  {
    return paramGoogleApiClient.b(new a(paramLocationListener)
    {
      protected void a(lz paramAnonymouslz)
        throws RemoteException
      {
        paramAnonymouslz.removeLocationUpdates(paramLocationListener);
        b(Status.Jv);
      }
    });
  }

  public PendingResult<Status> requestLocationUpdates(GoogleApiClient paramGoogleApiClient, final LocationRequest paramLocationRequest, final PendingIntent paramPendingIntent)
  {
    return paramGoogleApiClient.b(new a(paramLocationRequest)
    {
      protected void a(lz paramAnonymouslz)
        throws RemoteException
      {
        paramAnonymouslz.requestLocationUpdates(paramLocationRequest, paramPendingIntent);
        b(Status.Jv);
      }
    });
  }

  public PendingResult<Status> requestLocationUpdates(GoogleApiClient paramGoogleApiClient, final LocationRequest paramLocationRequest, final LocationListener paramLocationListener)
  {
    return paramGoogleApiClient.b(new a(paramLocationRequest)
    {
      protected void a(lz paramAnonymouslz)
        throws RemoteException
      {
        paramAnonymouslz.requestLocationUpdates(paramLocationRequest, paramLocationListener, null);
        b(Status.Jv);
      }
    });
  }

  public PendingResult<Status> requestLocationUpdates(GoogleApiClient paramGoogleApiClient, final LocationRequest paramLocationRequest, final LocationListener paramLocationListener, final Looper paramLooper)
  {
    return paramGoogleApiClient.b(new a(paramLocationRequest)
    {
      protected void a(lz paramAnonymouslz)
        throws RemoteException
      {
        paramAnonymouslz.requestLocationUpdates(paramLocationRequest, paramLocationListener, paramLooper);
        b(Status.Jv);
      }
    });
  }

  public PendingResult<Status> setMockLocation(GoogleApiClient paramGoogleApiClient, final Location paramLocation)
  {
    return paramGoogleApiClient.b(new a(paramLocation)
    {
      protected void a(lz paramAnonymouslz)
        throws RemoteException
      {
        paramAnonymouslz.setMockLocation(paramLocation);
        b(Status.Jv);
      }
    });
  }

  public PendingResult<Status> setMockMode(GoogleApiClient paramGoogleApiClient, final boolean paramBoolean)
  {
    return paramGoogleApiClient.b(new a(paramBoolean)
    {
      protected void a(lz paramAnonymouslz)
        throws RemoteException
      {
        paramAnonymouslz.setMockMode(paramBoolean);
        b(Status.Jv);
      }
    });
  }

  private static abstract class a extends LocationServices.a<Status>
  {
    public Status d(Status paramStatus)
    {
      return paramStatus;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.lu
 * JD-Core Version:    0.6.2
 */