package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.a;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.e.b;
import com.google.android.gms.common.internal.e.e;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.o;
import com.google.android.gms.location.LocationClient.OnAddGeofencesResultListener;
import com.google.android.gms.location.LocationClient.OnRemoveGeofencesResultListener;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.List;

public class lz extends e<lx>
{
  private final me<lx> Dh = new c(null);
  private final ly aeW = new ly(paramContext, this.Dh);
  private final mw aeX;
  private final lp aeY;
  private final ie aeZ;
  private final String afa;

  public lz(Context paramContext, Looper paramLooper, String paramString1, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString2)
  {
    this(paramContext, paramLooper, paramString1, paramConnectionCallbacks, paramOnConnectionFailedListener, paramString2, null);
  }

  public lz(Context paramContext, Looper paramLooper, String paramString1, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString2, String paramString3)
  {
    this(paramContext, paramLooper, paramString1, paramConnectionCallbacks, paramOnConnectionFailedListener, paramString2, paramString3, null);
  }

  public lz(Context paramContext, Looper paramLooper, String paramString1, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString2, String paramString3, String paramString4)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, new String[0]);
    this.afa = paramString2;
    this.aeX = new mw(paramString1, this.Dh, paramString3);
    this.aeY = lp.a(paramContext, paramString3, paramString4, this.Dh);
    this.aeZ = ie.a(paramContext, this.Dh);
  }

  public lz(Context paramContext, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString)
  {
    super(paramContext, paramConnectionCallbacks, paramOnConnectionFailedListener, new String[0]);
    this.afa = paramString;
    this.aeX = new mw(paramContext.getPackageName(), this.Dh, null);
    this.aeY = lp.a(paramContext, null, null, this.Dh);
    this.aeZ = ie.a(paramContext, this.Dh);
  }

  protected void a(l paraml, e.e parame)
    throws RemoteException
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("client_name", this.afa);
    paraml.e(parame, 6171000, getContext().getPackageName(), localBundle);
  }

  public void a(ma paramma, LocationListener paramLocationListener)
    throws RemoteException
  {
    a(paramma, paramLocationListener, null);
  }

  public void a(ma paramma, LocationListener paramLocationListener, Looper paramLooper)
    throws RemoteException
  {
    synchronized (this.aeW)
    {
      this.aeW.a(paramma, paramLocationListener, paramLooper);
      return;
    }
  }

  protected lx aL(IBinder paramIBinder)
  {
    return lx.a.aK(paramIBinder);
  }

  public void addGeofences(List<mc> paramList, PendingIntent paramPendingIntent, LocationClient.OnAddGeofencesResultListener paramOnAddGeofencesResultListener)
    throws RemoteException
  {
    dJ();
    boolean bool;
    if ((paramList != null) && (paramList.size() > 0))
    {
      bool = true;
      o.b(bool, "At least one geofence must be specified.");
      o.b(paramPendingIntent, "PendingIntent must be specified.");
      o.b(paramOnAddGeofencesResultListener, "OnAddGeofencesResultListener not provided.");
      if (paramOnAddGeofencesResultListener != null)
        break label78;
    }
    label78: for (Object localObject = null; ; localObject = new b(paramOnAddGeofencesResultListener, this))
    {
      ((lx)gS()).a(paramList, paramPendingIntent, (lw)localObject, getContext().getPackageName());
      return;
      bool = false;
      break;
    }
  }

  public void b(ma paramma, PendingIntent paramPendingIntent)
    throws RemoteException
  {
    this.aeW.b(paramma, paramPendingIntent);
  }

  public void disconnect()
  {
    synchronized (this.aeW)
    {
      if (isConnected())
      {
        this.aeW.removeAllListeners();
        this.aeW.lY();
      }
      super.disconnect();
      return;
    }
  }

  public Location getLastLocation()
  {
    return this.aeW.getLastLocation();
  }

  protected String getServiceDescriptor()
  {
    return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
  }

  protected String getStartServiceAction()
  {
    return "com.google.android.location.internal.GoogleLocationManagerService.START";
  }

  public void removeActivityUpdates(PendingIntent paramPendingIntent)
    throws RemoteException
  {
    dJ();
    o.i(paramPendingIntent);
    ((lx)gS()).removeActivityUpdates(paramPendingIntent);
  }

  public void removeGeofences(PendingIntent paramPendingIntent, LocationClient.OnRemoveGeofencesResultListener paramOnRemoveGeofencesResultListener)
    throws RemoteException
  {
    dJ();
    o.b(paramPendingIntent, "PendingIntent must be specified.");
    o.b(paramOnRemoveGeofencesResultListener, "OnRemoveGeofencesResultListener not provided.");
    if (paramOnRemoveGeofencesResultListener == null);
    for (Object localObject = null; ; localObject = new b(paramOnRemoveGeofencesResultListener, this))
    {
      ((lx)gS()).a(paramPendingIntent, (lw)localObject, getContext().getPackageName());
      return;
    }
  }

  public void removeGeofences(List<String> paramList, LocationClient.OnRemoveGeofencesResultListener paramOnRemoveGeofencesResultListener)
    throws RemoteException
  {
    dJ();
    boolean bool;
    String[] arrayOfString;
    if ((paramList != null) && (paramList.size() > 0))
    {
      bool = true;
      o.b(bool, "geofenceRequestIds can't be null nor empty.");
      o.b(paramOnRemoveGeofencesResultListener, "OnRemoveGeofencesResultListener not provided.");
      arrayOfString = (String[])paramList.toArray(new String[0]);
      if (paramOnRemoveGeofencesResultListener != null)
        break label83;
    }
    label83: for (Object localObject = null; ; localObject = new b(paramOnRemoveGeofencesResultListener, this))
    {
      ((lx)gS()).a(arrayOfString, (lw)localObject, getContext().getPackageName());
      return;
      bool = false;
      break;
    }
  }

  public void removeLocationUpdates(PendingIntent paramPendingIntent)
    throws RemoteException
  {
    this.aeW.removeLocationUpdates(paramPendingIntent);
  }

  public void removeLocationUpdates(LocationListener paramLocationListener)
    throws RemoteException
  {
    this.aeW.removeLocationUpdates(paramLocationListener);
  }

  public void requestActivityUpdates(long paramLong, PendingIntent paramPendingIntent)
    throws RemoteException
  {
    dJ();
    o.i(paramPendingIntent);
    if (paramLong >= 0L);
    for (boolean bool = true; ; bool = false)
    {
      o.b(bool, "detectionIntervalMillis must be >= 0");
      ((lx)gS()).a(paramLong, true, paramPendingIntent);
      return;
    }
  }

  public void requestLocationUpdates(LocationRequest paramLocationRequest, PendingIntent paramPendingIntent)
    throws RemoteException
  {
    this.aeW.requestLocationUpdates(paramLocationRequest, paramPendingIntent);
  }

  public void requestLocationUpdates(LocationRequest paramLocationRequest, LocationListener paramLocationListener, Looper paramLooper)
    throws RemoteException
  {
    synchronized (this.aeW)
    {
      this.aeW.requestLocationUpdates(paramLocationRequest, paramLocationListener, paramLooper);
      return;
    }
  }

  public void setMockLocation(Location paramLocation)
    throws RemoteException
  {
    this.aeW.setMockLocation(paramLocation);
  }

  public void setMockMode(boolean paramBoolean)
    throws RemoteException
  {
    this.aeW.setMockMode(paramBoolean);
  }

  private final class a extends e<lx>.b<LocationClient.OnAddGeofencesResultListener>
  {
    private final int HF;
    private final String[] afb;

    public a(LocationClient.OnAddGeofencesResultListener paramInt, int paramArrayOfString, String[] arg4)
    {
      super(paramInt);
      this.HF = LocationStatusCodes.ef(paramArrayOfString);
      Object localObject;
      this.afb = localObject;
    }

    protected void a(LocationClient.OnAddGeofencesResultListener paramOnAddGeofencesResultListener)
    {
      if (paramOnAddGeofencesResultListener != null)
        paramOnAddGeofencesResultListener.onAddGeofencesResult(this.HF, this.afb);
    }

    protected void gT()
    {
    }
  }

  private static final class b extends lw.a
  {
    private LocationClient.OnAddGeofencesResultListener afd;
    private LocationClient.OnRemoveGeofencesResultListener afe;
    private lz aff;

    public b(LocationClient.OnAddGeofencesResultListener paramOnAddGeofencesResultListener, lz paramlz)
    {
      this.afd = paramOnAddGeofencesResultListener;
      this.afe = null;
      this.aff = paramlz;
    }

    public b(LocationClient.OnRemoveGeofencesResultListener paramOnRemoveGeofencesResultListener, lz paramlz)
    {
      this.afe = paramOnRemoveGeofencesResultListener;
      this.afd = null;
      this.aff = paramlz;
    }

    public void onAddGeofencesResult(int paramInt, String[] paramArrayOfString)
      throws RemoteException
    {
      if (this.aff == null)
      {
        Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
        return;
      }
      lz locallz1 = this.aff;
      lz locallz2 = this.aff;
      locallz2.getClass();
      locallz1.a(new lz.a(locallz2, this.afd, paramInt, paramArrayOfString));
      this.aff = null;
      this.afd = null;
      this.afe = null;
    }

    public void onRemoveGeofencesByPendingIntentResult(int paramInt, PendingIntent paramPendingIntent)
    {
      if (this.aff == null)
      {
        Log.wtf("LocationClientImpl", "onRemoveGeofencesByPendingIntentResult called multiple times");
        return;
      }
      lz locallz1 = this.aff;
      lz locallz2 = this.aff;
      locallz2.getClass();
      locallz1.a(new lz.d(locallz2, 1, this.afe, paramInt, paramPendingIntent));
      this.aff = null;
      this.afd = null;
      this.afe = null;
    }

    public void onRemoveGeofencesByRequestIdsResult(int paramInt, String[] paramArrayOfString)
    {
      if (this.aff == null)
      {
        Log.wtf("LocationClientImpl", "onRemoveGeofencesByRequestIdsResult called multiple times");
        return;
      }
      lz locallz1 = this.aff;
      lz locallz2 = this.aff;
      locallz2.getClass();
      locallz1.a(new lz.d(locallz2, 2, this.afe, paramInt, paramArrayOfString));
      this.aff = null;
      this.afd = null;
      this.afe = null;
    }
  }

  private final class c
    implements me<lx>
  {
    private c()
    {
    }

    public void dJ()
    {
      lz.b(lz.this);
    }

    public lx lZ()
    {
      return (lx)lz.this.gS();
    }
  }

  private final class d extends e<lx>.b<LocationClient.OnRemoveGeofencesResultListener>
  {
    private final int HF;
    private final String[] afb;
    private final int afg;
    private final PendingIntent mPendingIntent;

    public d(int paramOnRemoveGeofencesResultListener, LocationClient.OnRemoveGeofencesResultListener paramInt1, int paramPendingIntent, PendingIntent arg5)
    {
      super(paramInt1);
      if (paramOnRemoveGeofencesResultListener == localOnRemoveGeofencesResultListener);
      while (true)
      {
        a.I(localOnRemoveGeofencesResultListener);
        this.afg = paramOnRemoveGeofencesResultListener;
        this.HF = LocationStatusCodes.ef(paramPendingIntent);
        Object localObject;
        this.mPendingIntent = localObject;
        this.afb = null;
        return;
        int i = 0;
      }
    }

    public d(int paramOnRemoveGeofencesResultListener, LocationClient.OnRemoveGeofencesResultListener paramInt1, int paramArrayOfString, String[] arg5)
    {
      super(paramInt1);
      if (paramOnRemoveGeofencesResultListener == 2);
      for (boolean bool = true; ; bool = false)
      {
        a.I(bool);
        this.afg = paramOnRemoveGeofencesResultListener;
        this.HF = LocationStatusCodes.ef(paramArrayOfString);
        Object localObject;
        this.afb = localObject;
        this.mPendingIntent = null;
        return;
      }
    }

    protected void a(LocationClient.OnRemoveGeofencesResultListener paramOnRemoveGeofencesResultListener)
    {
      if (paramOnRemoveGeofencesResultListener != null);
      switch (this.afg)
      {
      default:
        Log.wtf("LocationClientImpl", "Unsupported action: " + this.afg);
        return;
      case 1:
        paramOnRemoveGeofencesResultListener.onRemoveGeofencesByPendingIntentResult(this.HF, this.mPendingIntent);
        return;
      case 2:
      }
      paramOnRemoveGeofencesResultListener.onRemoveGeofencesByRequestIdsResult(this.HF, this.afb);
    }

    protected void gT()
    {
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.lz
 * JD-Core Version:    0.6.2
 */