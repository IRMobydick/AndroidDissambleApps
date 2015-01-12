package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.a;
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.panorama.Panorama;
import com.google.android.gms.panorama.PanoramaApi;
import com.google.android.gms.panorama.PanoramaApi.PanoramaResult;
import com.google.android.gms.panorama.PanoramaApi.a;

public class nc
  implements PanoramaApi
{
  private static void a(Context paramContext, Uri paramUri)
  {
    paramContext.revokeUriPermission(paramUri, 1);
  }

  private static void a(Context paramContext, nb paramnb, final na paramna, final Uri paramUri, Bundle paramBundle)
    throws RemoteException
  {
    paramContext.grantUriPermission("com.google.android.gms", paramUri, 1);
    na.a local4 = new na.a()
    {
      public void a(int paramAnonymousInt1, Bundle paramAnonymousBundle, int paramAnonymousInt2, Intent paramAnonymousIntent)
        throws RemoteException
      {
        nc.b(this.mV, paramUri);
        paramna.a(paramAnonymousInt1, paramAnonymousBundle, paramAnonymousInt2, paramAnonymousIntent);
      }
    };
    try
    {
      paramnb.a(local4, paramUri, paramBundle, true);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      a(paramContext, paramUri);
      throw localRemoteException;
    }
    catch (RuntimeException localRuntimeException)
    {
      a(paramContext, paramUri);
      throw localRuntimeException;
    }
  }

  public PendingResult<PanoramaApi.PanoramaResult> loadPanoramaInfo(GoogleApiClient paramGoogleApiClient, final Uri paramUri)
  {
    return paramGoogleApiClient.a(new b(paramUri)
    {
      protected void a(Context paramAnonymousContext, nb paramAnonymousnb)
        throws RemoteException
      {
        paramAnonymousnb.a(new nc.c(this), paramUri, null, false);
      }
    });
  }

  public PendingResult<PanoramaApi.PanoramaResult> loadPanoramaInfoAndGrantAccess(GoogleApiClient paramGoogleApiClient, final Uri paramUri)
  {
    return paramGoogleApiClient.a(new b(paramUri)
    {
      protected void a(Context paramAnonymousContext, nb paramAnonymousnb)
        throws RemoteException
      {
        nc.b(paramAnonymousContext, paramAnonymousnb, new nc.c(this), paramUri, null);
      }
    });
  }

  private static final class a extends na.a
  {
    private final BaseImplementation.b<PanoramaApi.a> De;

    public a(BaseImplementation.b<PanoramaApi.a> paramb)
    {
      this.De = paramb;
    }

    public void a(int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
    {
      if (paramBundle != null);
      for (PendingIntent localPendingIntent = (PendingIntent)paramBundle.getParcelable("pendingIntent"); ; localPendingIntent = null)
      {
        Status localStatus = new Status(paramInt1, null, localPendingIntent);
        this.De.b(new mz(localStatus, paramIntent, paramInt2));
        return;
      }
    }
  }

  private static abstract class b extends nc.d<PanoramaApi.PanoramaResult>
  {
    protected PanoramaApi.PanoramaResult az(Status paramStatus)
    {
      return new ne(paramStatus, null);
    }
  }

  private static final class c extends na.a
  {
    private final BaseImplementation.b<PanoramaApi.PanoramaResult> De;

    public c(BaseImplementation.b<PanoramaApi.PanoramaResult> paramb)
    {
      this.De = paramb;
    }

    public void a(int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
    {
      if (paramBundle != null);
      for (PendingIntent localPendingIntent = (PendingIntent)paramBundle.getParcelable("pendingIntent"); ; localPendingIntent = null)
      {
        Status localStatus = new Status(paramInt1, null, localPendingIntent);
        this.De.b(new ne(localStatus, paramIntent));
        return;
      }
    }
  }

  private static abstract class d<R extends Result> extends BaseImplementation.a<R, nd>
  {
    protected d()
    {
      super();
    }

    protected abstract void a(Context paramContext, nb paramnb)
      throws RemoteException;

    protected final void a(nd paramnd)
      throws RemoteException
    {
      a(paramnd.getContext(), (nb)paramnd.gS());
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.nc
 * JD-Core Version:    0.6.2
 */