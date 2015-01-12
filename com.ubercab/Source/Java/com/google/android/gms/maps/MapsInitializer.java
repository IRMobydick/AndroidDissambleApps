package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.o;
import com.google.android.gms.maps.internal.c;
import com.google.android.gms.maps.internal.u;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class MapsInitializer
{
  public static void a(c paramc)
  {
    try
    {
      CameraUpdateFactory.a(paramc.mI());
      BitmapDescriptorFactory.a(paramc.mJ());
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public static int initialize(Context paramContext)
  {
    o.i(paramContext);
    try
    {
      c localc = u.S(paramContext);
      a(localc);
      return 0;
    }
    catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
    {
      return localGooglePlayServicesNotAvailableException.errorCode;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.MapsInitializer
 * JD-Core Version:    0.6.2
 */