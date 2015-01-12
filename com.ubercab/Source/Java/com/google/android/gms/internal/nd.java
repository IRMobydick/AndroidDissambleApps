package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.e.e;
import com.google.android.gms.common.internal.l;

public class nd extends e<nb>
{
  public nd(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, (String[])null);
  }

  protected void a(l paraml, e.e parame)
    throws RemoteException
  {
    Bundle localBundle = new Bundle();
    paraml.a(parame, 6171000, getContext().getPackageName(), localBundle);
  }

  public nb bB(IBinder paramIBinder)
  {
    return nb.a.bA(paramIBinder);
  }

  protected String getServiceDescriptor()
  {
    return "com.google.android.gms.panorama.internal.IPanoramaService";
  }

  protected String getStartServiceAction()
  {
    return "com.google.android.gms.panorama.service.START";
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.nd
 * JD-Core Version:    0.6.2
 */