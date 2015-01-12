package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.maps.internal.IProjectionDelegate;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.VisibleRegion;

public final class Projection
{
  private final IProjectionDelegate aja;

  Projection(IProjectionDelegate paramIProjectionDelegate)
  {
    this.aja = paramIProjectionDelegate;
  }

  public LatLng fromScreenLocation(Point paramPoint)
  {
    try
    {
      LatLng localLatLng = this.aja.fromScreenLocation(e.k(paramPoint));
      return localLatLng;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public VisibleRegion getVisibleRegion()
  {
    try
    {
      VisibleRegion localVisibleRegion = this.aja.getVisibleRegion();
      return localVisibleRegion;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public Point toScreenLocation(LatLng paramLatLng)
  {
    try
    {
      Point localPoint = (Point)e.f(this.aja.toScreenLocation(paramLatLng));
      return localPoint;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.Projection
 * JD-Core Version:    0.6.2
 */