package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.common.internal.o;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.p.a;
import com.google.android.gms.maps.internal.q.a;
import com.google.android.gms.maps.internal.r.a;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

public class StreetViewPanorama
{
  private final IStreetViewPanoramaDelegate ajb;

  protected StreetViewPanorama(IStreetViewPanoramaDelegate paramIStreetViewPanoramaDelegate)
  {
    this.ajb = ((IStreetViewPanoramaDelegate)o.i(paramIStreetViewPanoramaDelegate));
  }

  public void animateTo(StreetViewPanoramaCamera paramStreetViewPanoramaCamera, long paramLong)
  {
    try
    {
      this.ajb.animateTo(paramStreetViewPanoramaCamera, paramLong);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public StreetViewPanoramaLocation getLocation()
  {
    try
    {
      StreetViewPanoramaLocation localStreetViewPanoramaLocation = this.ajb.getStreetViewPanoramaLocation();
      return localStreetViewPanoramaLocation;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public StreetViewPanoramaCamera getPanoramaCamera()
  {
    try
    {
      StreetViewPanoramaCamera localStreetViewPanoramaCamera = this.ajb.getPanoramaCamera();
      return localStreetViewPanoramaCamera;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public boolean isPanningGesturesEnabled()
  {
    try
    {
      boolean bool = this.ajb.isPanningGesturesEnabled();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public boolean isStreetNamesEnabled()
  {
    try
    {
      boolean bool = this.ajb.isStreetNamesEnabled();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public boolean isUserNavigationEnabled()
  {
    try
    {
      boolean bool = this.ajb.isUserNavigationEnabled();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public boolean isZoomGesturesEnabled()
  {
    try
    {
      boolean bool = this.ajb.isZoomGesturesEnabled();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  IStreetViewPanoramaDelegate mC()
  {
    return this.ajb;
  }

  public Point orientationToPoint(StreetViewPanoramaOrientation paramStreetViewPanoramaOrientation)
  {
    try
    {
      d locald = this.ajb.orientationToPoint(paramStreetViewPanoramaOrientation);
      if (locald == null)
        return null;
      Point localPoint = (Point)e.f(locald);
      return localPoint;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public StreetViewPanoramaOrientation pointToOrientation(Point paramPoint)
  {
    try
    {
      StreetViewPanoramaOrientation localStreetViewPanoramaOrientation = this.ajb.pointToOrientation(e.k(paramPoint));
      return localStreetViewPanoramaOrientation;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setOnStreetViewPanoramaCameraChangeListener(final OnStreetViewPanoramaCameraChangeListener paramOnStreetViewPanoramaCameraChangeListener)
  {
    if (paramOnStreetViewPanoramaCameraChangeListener == null);
    try
    {
      this.ajb.setOnStreetViewPanoramaCameraChangeListener(null);
      return;
      this.ajb.setOnStreetViewPanoramaCameraChangeListener(new p.a()
      {
        public void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera paramAnonymousStreetViewPanoramaCamera)
        {
          paramOnStreetViewPanoramaCameraChangeListener.onStreetViewPanoramaCameraChange(paramAnonymousStreetViewPanoramaCamera);
        }
      });
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setOnStreetViewPanoramaChangeListener(final OnStreetViewPanoramaChangeListener paramOnStreetViewPanoramaChangeListener)
  {
    if (paramOnStreetViewPanoramaChangeListener == null);
    try
    {
      this.ajb.setOnStreetViewPanoramaChangeListener(null);
      return;
      this.ajb.setOnStreetViewPanoramaChangeListener(new q.a()
      {
        public void onStreetViewPanoramaChange(StreetViewPanoramaLocation paramAnonymousStreetViewPanoramaLocation)
        {
          paramOnStreetViewPanoramaChangeListener.onStreetViewPanoramaChange(paramAnonymousStreetViewPanoramaLocation);
        }
      });
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setOnStreetViewPanoramaClickListener(final OnStreetViewPanoramaClickListener paramOnStreetViewPanoramaClickListener)
  {
    if (paramOnStreetViewPanoramaClickListener == null);
    try
    {
      this.ajb.setOnStreetViewPanoramaClickListener(null);
      return;
      this.ajb.setOnStreetViewPanoramaClickListener(new r.a()
      {
        public void onStreetViewPanoramaClick(StreetViewPanoramaOrientation paramAnonymousStreetViewPanoramaOrientation)
        {
          paramOnStreetViewPanoramaClickListener.onStreetViewPanoramaClick(paramAnonymousStreetViewPanoramaOrientation);
        }
      });
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public void setPanningGesturesEnabled(boolean paramBoolean)
  {
    try
    {
      this.ajb.enablePanning(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public void setPosition(LatLng paramLatLng)
  {
    try
    {
      this.ajb.setPosition(paramLatLng);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public void setPosition(LatLng paramLatLng, int paramInt)
  {
    try
    {
      this.ajb.setPositionWithRadius(paramLatLng, paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public void setPosition(String paramString)
  {
    try
    {
      this.ajb.setPositionWithID(paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public void setStreetNamesEnabled(boolean paramBoolean)
  {
    try
    {
      this.ajb.enableStreetNames(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public void setUserNavigationEnabled(boolean paramBoolean)
  {
    try
    {
      this.ajb.enableUserNavigation(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public void setZoomGesturesEnabled(boolean paramBoolean)
  {
    try
    {
      this.ajb.enableZoom(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public static abstract interface OnStreetViewPanoramaCameraChangeListener
  {
    public abstract void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera paramStreetViewPanoramaCamera);
  }

  public static abstract interface OnStreetViewPanoramaChangeListener
  {
    public abstract void onStreetViewPanoramaChange(StreetViewPanoramaLocation paramStreetViewPanoramaLocation);
  }

  public static abstract interface OnStreetViewPanoramaClickListener
  {
    public abstract void onStreetViewPanoramaClick(StreetViewPanoramaOrientation paramStreetViewPanoramaOrientation);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.StreetViewPanorama
 * JD-Core Version:    0.6.2
 */