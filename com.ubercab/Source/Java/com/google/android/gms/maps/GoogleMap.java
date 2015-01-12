package com.google.android.gms.maps;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.internal.o;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.ILocationSourceDelegate.a;
import com.google.android.gms.maps.internal.b;
import com.google.android.gms.maps.internal.b.a;
import com.google.android.gms.maps.internal.d.a;
import com.google.android.gms.maps.internal.e.a;
import com.google.android.gms.maps.internal.f.a;
import com.google.android.gms.maps.internal.g.a;
import com.google.android.gms.maps.internal.i.a;
import com.google.android.gms.maps.internal.j.a;
import com.google.android.gms.maps.internal.k.a;
import com.google.android.gms.maps.internal.l.a;
import com.google.android.gms.maps.internal.m.a;
import com.google.android.gms.maps.internal.n.a;
import com.google.android.gms.maps.internal.o.a;
import com.google.android.gms.maps.internal.s.a;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.IndoorBuilding;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.internal.c;
import com.google.android.gms.maps.model.internal.f;

public final class GoogleMap
{
  public static final int MAP_TYPE_HYBRID = 4;
  public static final int MAP_TYPE_NONE = 0;
  public static final int MAP_TYPE_NORMAL = 1;
  public static final int MAP_TYPE_SATELLITE = 2;
  public static final int MAP_TYPE_TERRAIN = 3;
  private final IGoogleMapDelegate ain;
  private UiSettings aio;

  protected GoogleMap(IGoogleMapDelegate paramIGoogleMapDelegate)
  {
    this.ain = ((IGoogleMapDelegate)o.i(paramIGoogleMapDelegate));
  }

  public final Circle addCircle(CircleOptions paramCircleOptions)
  {
    try
    {
      Circle localCircle = new Circle(this.ain.addCircle(paramCircleOptions));
      return localCircle;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final GroundOverlay addGroundOverlay(GroundOverlayOptions paramGroundOverlayOptions)
  {
    try
    {
      c localc = this.ain.addGroundOverlay(paramGroundOverlayOptions);
      if (localc != null)
      {
        GroundOverlay localGroundOverlay = new GroundOverlay(localc);
        return localGroundOverlay;
      }
      return null;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final Marker addMarker(MarkerOptions paramMarkerOptions)
  {
    try
    {
      f localf = this.ain.addMarker(paramMarkerOptions);
      if (localf != null)
      {
        Marker localMarker = new Marker(localf);
        return localMarker;
      }
      return null;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final Polygon addPolygon(PolygonOptions paramPolygonOptions)
  {
    try
    {
      Polygon localPolygon = new Polygon(this.ain.addPolygon(paramPolygonOptions));
      return localPolygon;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final Polyline addPolyline(PolylineOptions paramPolylineOptions)
  {
    try
    {
      Polyline localPolyline = new Polyline(this.ain.addPolyline(paramPolylineOptions));
      return localPolyline;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final TileOverlay addTileOverlay(TileOverlayOptions paramTileOverlayOptions)
  {
    try
    {
      com.google.android.gms.maps.model.internal.h localh = this.ain.addTileOverlay(paramTileOverlayOptions);
      if (localh != null)
      {
        TileOverlay localTileOverlay = new TileOverlay(localh);
        return localTileOverlay;
      }
      return null;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void animateCamera(CameraUpdate paramCameraUpdate)
  {
    try
    {
      this.ain.animateCamera(paramCameraUpdate.mo());
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void animateCamera(CameraUpdate paramCameraUpdate, int paramInt, CancelableCallback paramCancelableCallback)
  {
    try
    {
      IGoogleMapDelegate localIGoogleMapDelegate = this.ain;
      com.google.android.gms.dynamic.d locald = paramCameraUpdate.mo();
      if (paramCancelableCallback == null);
      for (Object localObject = null; ; localObject = new a(paramCancelableCallback))
      {
        localIGoogleMapDelegate.animateCameraWithDurationAndCallback(locald, paramInt, (b)localObject);
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void animateCamera(CameraUpdate paramCameraUpdate, CancelableCallback paramCancelableCallback)
  {
    try
    {
      IGoogleMapDelegate localIGoogleMapDelegate = this.ain;
      com.google.android.gms.dynamic.d locald = paramCameraUpdate.mo();
      if (paramCancelableCallback == null);
      for (Object localObject = null; ; localObject = new a(paramCancelableCallback))
      {
        localIGoogleMapDelegate.animateCameraWithCallback(locald, (b)localObject);
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void clear()
  {
    try
    {
      this.ain.clear();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final CameraPosition getCameraPosition()
  {
    try
    {
      CameraPosition localCameraPosition = this.ain.getCameraPosition();
      return localCameraPosition;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public IndoorBuilding getFocusedBuilding()
  {
    try
    {
      com.google.android.gms.maps.model.internal.d locald = this.ain.getFocusedBuilding();
      if (locald != null)
      {
        IndoorBuilding localIndoorBuilding = new IndoorBuilding(locald);
        return localIndoorBuilding;
      }
      return null;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final int getMapType()
  {
    try
    {
      int i = this.ain.getMapType();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final float getMaxZoomLevel()
  {
    try
    {
      float f = this.ain.getMaxZoomLevel();
      return f;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final float getMinZoomLevel()
  {
    try
    {
      float f = this.ain.getMinZoomLevel();
      return f;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  @Deprecated
  public final Location getMyLocation()
  {
    try
    {
      Location localLocation = this.ain.getMyLocation();
      return localLocation;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final Projection getProjection()
  {
    try
    {
      Projection localProjection = new Projection(this.ain.getProjection());
      return localProjection;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final UiSettings getUiSettings()
  {
    try
    {
      if (this.aio == null)
        this.aio = new UiSettings(this.ain.getUiSettings());
      UiSettings localUiSettings = this.aio;
      return localUiSettings;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final boolean isBuildingsEnabled()
  {
    try
    {
      boolean bool = this.ain.isBuildingsEnabled();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final boolean isIndoorEnabled()
  {
    try
    {
      boolean bool = this.ain.isIndoorEnabled();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final boolean isMyLocationEnabled()
  {
    try
    {
      boolean bool = this.ain.isMyLocationEnabled();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final boolean isTrafficEnabled()
  {
    try
    {
      boolean bool = this.ain.isTrafficEnabled();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void moveCamera(CameraUpdate paramCameraUpdate)
  {
    try
    {
      this.ain.moveCamera(paramCameraUpdate.mo());
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  IGoogleMapDelegate mq()
  {
    return this.ain;
  }

  public final void setBuildingsEnabled(boolean paramBoolean)
  {
    try
    {
      this.ain.setBuildingsEnabled(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final boolean setIndoorEnabled(boolean paramBoolean)
  {
    try
    {
      boolean bool = this.ain.setIndoorEnabled(paramBoolean);
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setInfoWindowAdapter(final InfoWindowAdapter paramInfoWindowAdapter)
  {
    if (paramInfoWindowAdapter == null);
    try
    {
      this.ain.setInfoWindowAdapter(null);
      return;
      this.ain.setInfoWindowAdapter(new d.a()
      {
        public com.google.android.gms.dynamic.d f(f paramAnonymousf)
        {
          return e.k(paramInfoWindowAdapter.getInfoWindow(new Marker(paramAnonymousf)));
        }

        public com.google.android.gms.dynamic.d g(f paramAnonymousf)
        {
          return e.k(paramInfoWindowAdapter.getInfoContents(new Marker(paramAnonymousf)));
        }
      });
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setLocationSource(final LocationSource paramLocationSource)
  {
    if (paramLocationSource == null);
    try
    {
      this.ain.setLocationSource(null);
      return;
      this.ain.setLocationSource(new ILocationSourceDelegate.a()
      {
        public void activate(final com.google.android.gms.maps.internal.h paramAnonymoush)
        {
          paramLocationSource.activate(new LocationSource.OnLocationChangedListener()
          {
            public void onLocationChanged(Location paramAnonymous2Location)
            {
              try
              {
                paramAnonymoush.l(e.k(paramAnonymous2Location));
                return;
              }
              catch (RemoteException localRemoteException)
              {
                throw new RuntimeRemoteException(localRemoteException);
              }
            }
          });
        }

        public void deactivate()
        {
          paramLocationSource.deactivate();
        }
      });
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setMapType(int paramInt)
  {
    try
    {
      this.ain.setMapType(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setMyLocationEnabled(boolean paramBoolean)
  {
    try
    {
      this.ain.setMyLocationEnabled(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setOnCameraChangeListener(final OnCameraChangeListener paramOnCameraChangeListener)
  {
    if (paramOnCameraChangeListener == null);
    try
    {
      this.ain.setOnCameraChangeListener(null);
      return;
      this.ain.setOnCameraChangeListener(new e.a()
      {
        public void onCameraChange(CameraPosition paramAnonymousCameraPosition)
        {
          paramOnCameraChangeListener.onCameraChange(paramAnonymousCameraPosition);
        }
      });
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setOnIndoorStateChangeListener(final OnIndoorStateChangeListener paramOnIndoorStateChangeListener)
  {
    if (paramOnIndoorStateChangeListener == null);
    try
    {
      this.ain.setOnIndoorStateChangeListener(null);
      return;
      this.ain.setOnIndoorStateChangeListener(new f.a()
      {
        public void a(com.google.android.gms.maps.model.internal.d paramAnonymousd)
        {
          paramOnIndoorStateChangeListener.onIndoorLevelActivated(new IndoorBuilding(paramAnonymousd));
        }

        public void onIndoorBuildingFocused()
        {
          paramOnIndoorStateChangeListener.onIndoorBuildingFocused();
        }
      });
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setOnInfoWindowClickListener(final OnInfoWindowClickListener paramOnInfoWindowClickListener)
  {
    if (paramOnInfoWindowClickListener == null);
    try
    {
      this.ain.setOnInfoWindowClickListener(null);
      return;
      this.ain.setOnInfoWindowClickListener(new g.a()
      {
        public void e(f paramAnonymousf)
        {
          paramOnInfoWindowClickListener.onInfoWindowClick(new Marker(paramAnonymousf));
        }
      });
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setOnMapClickListener(final OnMapClickListener paramOnMapClickListener)
  {
    if (paramOnMapClickListener == null);
    try
    {
      this.ain.setOnMapClickListener(null);
      return;
      this.ain.setOnMapClickListener(new i.a()
      {
        public void onMapClick(LatLng paramAnonymousLatLng)
        {
          paramOnMapClickListener.onMapClick(paramAnonymousLatLng);
        }
      });
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public void setOnMapLoadedCallback(final OnMapLoadedCallback paramOnMapLoadedCallback)
  {
    if (paramOnMapLoadedCallback == null);
    try
    {
      this.ain.setOnMapLoadedCallback(null);
      return;
      this.ain.setOnMapLoadedCallback(new j.a()
      {
        public void onMapLoaded()
          throws RemoteException
        {
          paramOnMapLoadedCallback.onMapLoaded();
        }
      });
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setOnMapLongClickListener(final OnMapLongClickListener paramOnMapLongClickListener)
  {
    if (paramOnMapLongClickListener == null);
    try
    {
      this.ain.setOnMapLongClickListener(null);
      return;
      this.ain.setOnMapLongClickListener(new k.a()
      {
        public void onMapLongClick(LatLng paramAnonymousLatLng)
        {
          paramOnMapLongClickListener.onMapLongClick(paramAnonymousLatLng);
        }
      });
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setOnMarkerClickListener(final OnMarkerClickListener paramOnMarkerClickListener)
  {
    if (paramOnMarkerClickListener == null);
    try
    {
      this.ain.setOnMarkerClickListener(null);
      return;
      this.ain.setOnMarkerClickListener(new l.a()
      {
        public boolean a(f paramAnonymousf)
        {
          return paramOnMarkerClickListener.onMarkerClick(new Marker(paramAnonymousf));
        }
      });
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setOnMarkerDragListener(final OnMarkerDragListener paramOnMarkerDragListener)
  {
    if (paramOnMarkerDragListener == null);
    try
    {
      this.ain.setOnMarkerDragListener(null);
      return;
      this.ain.setOnMarkerDragListener(new m.a()
      {
        public void b(f paramAnonymousf)
        {
          paramOnMarkerDragListener.onMarkerDragStart(new Marker(paramAnonymousf));
        }

        public void c(f paramAnonymousf)
        {
          paramOnMarkerDragListener.onMarkerDragEnd(new Marker(paramAnonymousf));
        }

        public void d(f paramAnonymousf)
        {
          paramOnMarkerDragListener.onMarkerDrag(new Marker(paramAnonymousf));
        }
      });
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setOnMyLocationButtonClickListener(final OnMyLocationButtonClickListener paramOnMyLocationButtonClickListener)
  {
    if (paramOnMyLocationButtonClickListener == null);
    try
    {
      this.ain.setOnMyLocationButtonClickListener(null);
      return;
      this.ain.setOnMyLocationButtonClickListener(new n.a()
      {
        public boolean onMyLocationButtonClick()
          throws RemoteException
        {
          return paramOnMyLocationButtonClickListener.onMyLocationButtonClick();
        }
      });
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  @Deprecated
  public final void setOnMyLocationChangeListener(final OnMyLocationChangeListener paramOnMyLocationChangeListener)
  {
    if (paramOnMyLocationChangeListener == null);
    try
    {
      this.ain.setOnMyLocationChangeListener(null);
      return;
      this.ain.setOnMyLocationChangeListener(new o.a()
      {
        public void g(com.google.android.gms.dynamic.d paramAnonymousd)
        {
          paramOnMyLocationChangeListener.onMyLocationChange((Location)e.f(paramAnonymousd));
        }
      });
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      this.ain.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setTrafficEnabled(boolean paramBoolean)
  {
    try
    {
      this.ain.setTrafficEnabled(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void snapshot(SnapshotReadyCallback paramSnapshotReadyCallback)
  {
    snapshot(paramSnapshotReadyCallback, null);
  }

  public final void snapshot(final SnapshotReadyCallback paramSnapshotReadyCallback, Bitmap paramBitmap)
  {
    com.google.android.gms.dynamic.d locald;
    if (paramBitmap != null)
      locald = e.k(paramBitmap);
    while (true)
    {
      e locale = (e)locald;
      try
      {
        this.ain.snapshot(new s.a()
        {
          public void h(com.google.android.gms.dynamic.d paramAnonymousd)
            throws RemoteException
          {
            paramSnapshotReadyCallback.onSnapshotReady((Bitmap)e.f(paramAnonymousd));
          }

          public void onSnapshotReady(Bitmap paramAnonymousBitmap)
            throws RemoteException
          {
            paramSnapshotReadyCallback.onSnapshotReady(paramAnonymousBitmap);
          }
        }
        , locale);
        return;
        locald = null;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
  }

  public final void stopAnimation()
  {
    try
    {
      this.ain.stopAnimation();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public static abstract interface CancelableCallback
  {
    public abstract void onCancel();

    public abstract void onFinish();
  }

  public static abstract interface InfoWindowAdapter
  {
    public abstract View getInfoContents(Marker paramMarker);

    public abstract View getInfoWindow(Marker paramMarker);
  }

  public static abstract interface OnCameraChangeListener
  {
    public abstract void onCameraChange(CameraPosition paramCameraPosition);
  }

  public static abstract interface OnIndoorStateChangeListener
  {
    public abstract void onIndoorBuildingFocused();

    public abstract void onIndoorLevelActivated(IndoorBuilding paramIndoorBuilding);
  }

  public static abstract interface OnInfoWindowClickListener
  {
    public abstract void onInfoWindowClick(Marker paramMarker);
  }

  public static abstract interface OnMapClickListener
  {
    public abstract void onMapClick(LatLng paramLatLng);
  }

  public static abstract interface OnMapLoadedCallback
  {
    public abstract void onMapLoaded();
  }

  public static abstract interface OnMapLongClickListener
  {
    public abstract void onMapLongClick(LatLng paramLatLng);
  }

  public static abstract interface OnMarkerClickListener
  {
    public abstract boolean onMarkerClick(Marker paramMarker);
  }

  public static abstract interface OnMarkerDragListener
  {
    public abstract void onMarkerDrag(Marker paramMarker);

    public abstract void onMarkerDragEnd(Marker paramMarker);

    public abstract void onMarkerDragStart(Marker paramMarker);
  }

  public static abstract interface OnMyLocationButtonClickListener
  {
    public abstract boolean onMyLocationButtonClick();
  }

  @Deprecated
  public static abstract interface OnMyLocationChangeListener
  {
    public abstract void onMyLocationChange(Location paramLocation);
  }

  public static abstract interface SnapshotReadyCallback
  {
    public abstract void onSnapshotReady(Bitmap paramBitmap);
  }

  private static final class a extends b.a
  {
    private final GoogleMap.CancelableCallback aiF;

    a(GoogleMap.CancelableCallback paramCancelableCallback)
    {
      this.aiF = paramCancelableCallback;
    }

    public void onCancel()
    {
      this.aiF.onCancel();
    }

    public void onFinish()
    {
      this.aiF.onFinish();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.GoogleMap
 * JD-Core Version:    0.6.2
 */