package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognition.a;
import com.google.android.gms.location.ActivityRecognitionApi;

public class lr
  implements ActivityRecognitionApi
{
  public PendingResult<Status> removeActivityUpdates(GoogleApiClient paramGoogleApiClient, final PendingIntent paramPendingIntent)
  {
    return paramGoogleApiClient.b(new a(paramPendingIntent)
    {
      protected void a(lz paramAnonymouslz)
        throws RemoteException
      {
        paramAnonymouslz.removeActivityUpdates(paramPendingIntent);
        b(Status.Jv);
      }
    });
  }

  public PendingResult<Status> requestActivityUpdates(GoogleApiClient paramGoogleApiClient, final long paramLong, PendingIntent paramPendingIntent)
  {
    return paramGoogleApiClient.b(new a(paramLong)
    {
      protected void a(lz paramAnonymouslz)
        throws RemoteException
      {
        paramAnonymouslz.requestActivityUpdates(paramLong, this.aeC);
        b(Status.Jv);
      }
    });
  }

  private static abstract class a extends ActivityRecognition.a<Status>
  {
    public Status d(Status paramStatus)
    {
      return paramStatus;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.lr
 * JD-Core Version:    0.6.2
 */