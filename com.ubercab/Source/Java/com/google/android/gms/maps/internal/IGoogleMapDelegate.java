package com.google.android.gms.maps.internal;

import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.a;
import com.google.android.gms.maps.model.internal.IPolylineDelegate;
import com.google.android.gms.maps.model.internal.IPolylineDelegate.a;
import com.google.android.gms.maps.model.internal.c.a;
import com.google.android.gms.maps.model.internal.h;
import com.google.android.gms.maps.model.internal.h.a;
import com.google.android.gms.maps.model.w;

public abstract interface IGoogleMapDelegate extends IInterface
{
  public abstract com.google.android.gms.maps.model.internal.b addCircle(CircleOptions paramCircleOptions)
    throws RemoteException;

  public abstract com.google.android.gms.maps.model.internal.c addGroundOverlay(GroundOverlayOptions paramGroundOverlayOptions)
    throws RemoteException;

  public abstract com.google.android.gms.maps.model.internal.f addMarker(MarkerOptions paramMarkerOptions)
    throws RemoteException;

  public abstract com.google.android.gms.maps.model.internal.g addPolygon(PolygonOptions paramPolygonOptions)
    throws RemoteException;

  public abstract IPolylineDelegate addPolyline(PolylineOptions paramPolylineOptions)
    throws RemoteException;

  public abstract h addTileOverlay(TileOverlayOptions paramTileOverlayOptions)
    throws RemoteException;

  public abstract void animateCamera(com.google.android.gms.dynamic.d paramd)
    throws RemoteException;

  public abstract void animateCameraWithCallback(com.google.android.gms.dynamic.d paramd, b paramb)
    throws RemoteException;

  public abstract void animateCameraWithDurationAndCallback(com.google.android.gms.dynamic.d paramd, int paramInt, b paramb)
    throws RemoteException;

  public abstract void clear()
    throws RemoteException;

  public abstract CameraPosition getCameraPosition()
    throws RemoteException;

  public abstract com.google.android.gms.maps.model.internal.d getFocusedBuilding()
    throws RemoteException;

  public abstract int getMapType()
    throws RemoteException;

  public abstract float getMaxZoomLevel()
    throws RemoteException;

  public abstract float getMinZoomLevel()
    throws RemoteException;

  public abstract Location getMyLocation()
    throws RemoteException;

  public abstract IProjectionDelegate getProjection()
    throws RemoteException;

  public abstract IUiSettingsDelegate getUiSettings()
    throws RemoteException;

  public abstract boolean isBuildingsEnabled()
    throws RemoteException;

  public abstract boolean isIndoorEnabled()
    throws RemoteException;

  public abstract boolean isMyLocationEnabled()
    throws RemoteException;

  public abstract boolean isTrafficEnabled()
    throws RemoteException;

  public abstract void moveCamera(com.google.android.gms.dynamic.d paramd)
    throws RemoteException;

  public abstract void setBuildingsEnabled(boolean paramBoolean)
    throws RemoteException;

  public abstract boolean setIndoorEnabled(boolean paramBoolean)
    throws RemoteException;

  public abstract void setInfoWindowAdapter(d paramd)
    throws RemoteException;

  public abstract void setLocationSource(ILocationSourceDelegate paramILocationSourceDelegate)
    throws RemoteException;

  public abstract void setMapType(int paramInt)
    throws RemoteException;

  public abstract void setMyLocationEnabled(boolean paramBoolean)
    throws RemoteException;

  public abstract void setOnCameraChangeListener(e parame)
    throws RemoteException;

  public abstract void setOnIndoorStateChangeListener(f paramf)
    throws RemoteException;

  public abstract void setOnInfoWindowClickListener(g paramg)
    throws RemoteException;

  public abstract void setOnMapClickListener(i parami)
    throws RemoteException;

  public abstract void setOnMapLoadedCallback(j paramj)
    throws RemoteException;

  public abstract void setOnMapLongClickListener(k paramk)
    throws RemoteException;

  public abstract void setOnMarkerClickListener(l paraml)
    throws RemoteException;

  public abstract void setOnMarkerDragListener(m paramm)
    throws RemoteException;

  public abstract void setOnMyLocationButtonClickListener(n paramn)
    throws RemoteException;

  public abstract void setOnMyLocationChangeListener(o paramo)
    throws RemoteException;

  public abstract void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws RemoteException;

  public abstract void setTrafficEnabled(boolean paramBoolean)
    throws RemoteException;

  public abstract void snapshot(s params, com.google.android.gms.dynamic.d paramd)
    throws RemoteException;

  public abstract void stopAnimation()
    throws RemoteException;

  public static abstract class a extends Binder
    implements IGoogleMapDelegate
  {
    public static IGoogleMapDelegate aQ(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
      if ((localIInterface != null) && ((localIInterface instanceof IGoogleMapDelegate)))
        return (IGoogleMapDelegate)localIInterface;
      return new a(paramIBinder);
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        CameraPosition localCameraPosition = getCameraPosition();
        paramParcel2.writeNoException();
        if (localCameraPosition != null)
        {
          paramParcel2.writeInt(1);
          localCameraPosition.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        float f2 = getMaxZoomLevel();
        paramParcel2.writeNoException();
        paramParcel2.writeFloat(f2);
        return true;
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        float f1 = getMinZoomLevel();
        paramParcel2.writeNoException();
        paramParcel2.writeFloat(f1);
        return true;
      case 4:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        moveCamera(com.google.android.gms.dynamic.d.a.am(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 5:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        animateCamera(com.google.android.gms.dynamic.d.a.am(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 6:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        animateCameraWithCallback(com.google.android.gms.dynamic.d.a.am(paramParcel1.readStrongBinder()), b.a.aO(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 7:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        animateCameraWithDurationAndCallback(com.google.android.gms.dynamic.d.a.am(paramParcel1.readStrongBinder()), paramParcel1.readInt(), b.a.aO(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 8:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        stopAnimation();
        paramParcel2.writeNoException();
        return true;
      case 9:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (paramParcel1.readInt() != 0);
        for (PolylineOptions localPolylineOptions = PolylineOptions.CREATOR.cP(paramParcel1); ; localPolylineOptions = null)
        {
          IPolylineDelegate localIPolylineDelegate = addPolyline(localPolylineOptions);
          paramParcel2.writeNoException();
          IBinder localIBinder9 = null;
          if (localIPolylineDelegate != null)
            localIBinder9 = localIPolylineDelegate.asBinder();
          paramParcel2.writeStrongBinder(localIBinder9);
          return true;
        }
      case 10:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (paramParcel1.readInt() != 0);
        for (PolygonOptions localPolygonOptions = PolygonOptions.CREATOR.cO(paramParcel1); ; localPolygonOptions = null)
        {
          com.google.android.gms.maps.model.internal.g localg = addPolygon(localPolygonOptions);
          paramParcel2.writeNoException();
          IBinder localIBinder8 = null;
          if (localg != null)
            localIBinder8 = localg.asBinder();
          paramParcel2.writeStrongBinder(localIBinder8);
          return true;
        }
      case 11:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (paramParcel1.readInt() != 0);
        for (MarkerOptions localMarkerOptions = MarkerOptions.CREATOR.cN(paramParcel1); ; localMarkerOptions = null)
        {
          com.google.android.gms.maps.model.internal.f localf = addMarker(localMarkerOptions);
          paramParcel2.writeNoException();
          IBinder localIBinder7 = null;
          if (localf != null)
            localIBinder7 = localf.asBinder();
          paramParcel2.writeStrongBinder(localIBinder7);
          return true;
        }
      case 12:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (paramParcel1.readInt() != 0);
        for (GroundOverlayOptions localGroundOverlayOptions = GroundOverlayOptions.CREATOR.cK(paramParcel1); ; localGroundOverlayOptions = null)
        {
          com.google.android.gms.maps.model.internal.c localc = addGroundOverlay(localGroundOverlayOptions);
          paramParcel2.writeNoException();
          IBinder localIBinder6 = null;
          if (localc != null)
            localIBinder6 = localc.asBinder();
          paramParcel2.writeStrongBinder(localIBinder6);
          return true;
        }
      case 13:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (paramParcel1.readInt() != 0);
        for (TileOverlayOptions localTileOverlayOptions = TileOverlayOptions.CREATOR.cV(paramParcel1); ; localTileOverlayOptions = null)
        {
          h localh = addTileOverlay(localTileOverlayOptions);
          paramParcel2.writeNoException();
          IBinder localIBinder5 = null;
          if (localh != null)
            localIBinder5 = localh.asBinder();
          paramParcel2.writeStrongBinder(localIBinder5);
          return true;
        }
      case 14:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        clear();
        paramParcel2.writeNoException();
        return true;
      case 15:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        int i4 = getMapType();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(i4);
        return true;
      case 16:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setMapType(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 17:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        boolean bool9 = isTrafficEnabled();
        paramParcel2.writeNoException();
        int i3 = 0;
        if (bool9)
          i3 = 1;
        paramParcel2.writeInt(i3);
        return true;
      case 18:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        int i2 = paramParcel1.readInt();
        boolean bool8 = false;
        if (i2 != 0)
          bool8 = true;
        setTrafficEnabled(bool8);
        paramParcel2.writeNoException();
        return true;
      case 19:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        boolean bool7 = isIndoorEnabled();
        paramParcel2.writeNoException();
        int i1 = 0;
        if (bool7)
          i1 = 1;
        paramParcel2.writeInt(i1);
        return true;
      case 20:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (paramParcel1.readInt() != 0);
        for (boolean bool5 = true; ; bool5 = false)
        {
          boolean bool6 = setIndoorEnabled(bool5);
          paramParcel2.writeNoException();
          int n = 0;
          if (bool6)
            n = 1;
          paramParcel2.writeInt(n);
          return true;
        }
      case 21:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        boolean bool4 = isMyLocationEnabled();
        paramParcel2.writeNoException();
        int m = 0;
        if (bool4)
          m = 1;
        paramParcel2.writeInt(m);
        return true;
      case 22:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        int k = paramParcel1.readInt();
        boolean bool3 = false;
        if (k != 0)
          bool3 = true;
        setMyLocationEnabled(bool3);
        paramParcel2.writeNoException();
        return true;
      case 23:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        Location localLocation = getMyLocation();
        paramParcel2.writeNoException();
        if (localLocation != null)
        {
          paramParcel2.writeInt(1);
          localLocation.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 24:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setLocationSource(ILocationSourceDelegate.a.aS(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 25:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        IUiSettingsDelegate localIUiSettingsDelegate = getUiSettings();
        paramParcel2.writeNoException();
        IBinder localIBinder4 = null;
        if (localIUiSettingsDelegate != null)
          localIBinder4 = localIUiSettingsDelegate.asBinder();
        paramParcel2.writeStrongBinder(localIBinder4);
        return true;
      case 26:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        IProjectionDelegate localIProjectionDelegate = getProjection();
        paramParcel2.writeNoException();
        IBinder localIBinder3 = null;
        if (localIProjectionDelegate != null)
          localIBinder3 = localIProjectionDelegate.asBinder();
        paramParcel2.writeStrongBinder(localIBinder3);
        return true;
      case 27:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setOnCameraChangeListener(e.a.aV(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 28:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setOnMapClickListener(i.a.aZ(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 29:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setOnMapLongClickListener(k.a.bb(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 30:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setOnMarkerClickListener(l.a.bc(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 31:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setOnMarkerDragListener(m.a.bd(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 32:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setOnInfoWindowClickListener(g.a.aX(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 33:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setInfoWindowAdapter(d.a.aR(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 35:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (paramParcel1.readInt() != 0);
        for (CircleOptions localCircleOptions = CircleOptions.CREATOR.cJ(paramParcel1); ; localCircleOptions = null)
        {
          com.google.android.gms.maps.model.internal.b localb = addCircle(localCircleOptions);
          paramParcel2.writeNoException();
          IBinder localIBinder2 = null;
          if (localb != null)
            localIBinder2 = localb.asBinder();
          paramParcel2.writeStrongBinder(localIBinder2);
          return true;
        }
      case 36:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setOnMyLocationChangeListener(o.a.bf(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 37:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setOnMyLocationButtonClickListener(n.a.be(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 38:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        snapshot(s.a.bk(paramParcel1.readStrongBinder()), com.google.android.gms.dynamic.d.a.am(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 39:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setPadding(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 40:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        boolean bool2 = isBuildingsEnabled();
        paramParcel2.writeNoException();
        int j = 0;
        if (bool2)
          j = 1;
        paramParcel2.writeInt(j);
        return true;
      case 41:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        int i = paramParcel1.readInt();
        boolean bool1 = false;
        if (i != 0)
          bool1 = true;
        setBuildingsEnabled(bool1);
        paramParcel2.writeNoException();
        return true;
      case 42:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setOnMapLoadedCallback(j.a.ba(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 44:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        com.google.android.gms.maps.model.internal.d locald = getFocusedBuilding();
        paramParcel2.writeNoException();
        IBinder localIBinder1 = null;
        if (locald != null)
          localIBinder1 = locald.asBinder();
        paramParcel2.writeStrongBinder(localIBinder1);
        return true;
      case 45:
      }
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
      setOnIndoorStateChangeListener(f.a.aW(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }

    private static class a
      implements IGoogleMapDelegate
    {
      private IBinder lb;

      a(IBinder paramIBinder)
      {
        this.lb = paramIBinder;
      }

      public com.google.android.gms.maps.model.internal.b addCircle(CircleOptions paramCircleOptions)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramCircleOptions != null)
          {
            localParcel1.writeInt(1);
            paramCircleOptions.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.lb.transact(35, localParcel1, localParcel2, 0);
            localParcel2.readException();
            com.google.android.gms.maps.model.internal.b localb = com.google.android.gms.maps.model.internal.b.a.bq(localParcel2.readStrongBinder());
            return localb;
            localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public com.google.android.gms.maps.model.internal.c addGroundOverlay(GroundOverlayOptions paramGroundOverlayOptions)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramGroundOverlayOptions != null)
          {
            localParcel1.writeInt(1);
            paramGroundOverlayOptions.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.lb.transact(12, localParcel1, localParcel2, 0);
            localParcel2.readException();
            com.google.android.gms.maps.model.internal.c localc = c.a.br(localParcel2.readStrongBinder());
            return localc;
            localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public com.google.android.gms.maps.model.internal.f addMarker(MarkerOptions paramMarkerOptions)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramMarkerOptions != null)
          {
            localParcel1.writeInt(1);
            paramMarkerOptions.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.lb.transact(11, localParcel1, localParcel2, 0);
            localParcel2.readException();
            com.google.android.gms.maps.model.internal.f localf = com.google.android.gms.maps.model.internal.f.a.bu(localParcel2.readStrongBinder());
            return localf;
            localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public com.google.android.gms.maps.model.internal.g addPolygon(PolygonOptions paramPolygonOptions)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramPolygonOptions != null)
          {
            localParcel1.writeInt(1);
            paramPolygonOptions.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.lb.transact(10, localParcel1, localParcel2, 0);
            localParcel2.readException();
            com.google.android.gms.maps.model.internal.g localg = com.google.android.gms.maps.model.internal.g.a.bv(localParcel2.readStrongBinder());
            return localg;
            localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public IPolylineDelegate addPolyline(PolylineOptions paramPolylineOptions)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramPolylineOptions != null)
          {
            localParcel1.writeInt(1);
            paramPolylineOptions.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.lb.transact(9, localParcel1, localParcel2, 0);
            localParcel2.readException();
            IPolylineDelegate localIPolylineDelegate = IPolylineDelegate.a.bw(localParcel2.readStrongBinder());
            return localIPolylineDelegate;
            localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public h addTileOverlay(TileOverlayOptions paramTileOverlayOptions)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramTileOverlayOptions != null)
          {
            localParcel1.writeInt(1);
            paramTileOverlayOptions.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.lb.transact(13, localParcel1, localParcel2, 0);
            localParcel2.readException();
            h localh = h.a.bx(localParcel2.readStrongBinder());
            return localh;
            localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void animateCamera(com.google.android.gms.dynamic.d paramd)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramd != null);
          for (IBinder localIBinder = paramd.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.lb.transact(5, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void animateCameraWithCallback(com.google.android.gms.dynamic.d paramd, b paramb)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramd != null);
          for (IBinder localIBinder1 = paramd.asBinder(); ; localIBinder1 = null)
          {
            localParcel1.writeStrongBinder(localIBinder1);
            IBinder localIBinder2 = null;
            if (paramb != null)
              localIBinder2 = paramb.asBinder();
            localParcel1.writeStrongBinder(localIBinder2);
            this.lb.transact(6, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void animateCameraWithDurationAndCallback(com.google.android.gms.dynamic.d paramd, int paramInt, b paramb)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramd != null);
          for (IBinder localIBinder1 = paramd.asBinder(); ; localIBinder1 = null)
          {
            localParcel1.writeStrongBinder(localIBinder1);
            localParcel1.writeInt(paramInt);
            IBinder localIBinder2 = null;
            if (paramb != null)
              localIBinder2 = paramb.asBinder();
            localParcel1.writeStrongBinder(localIBinder2);
            this.lb.transact(7, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public IBinder asBinder()
      {
        return this.lb;
      }

      public void clear()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.lb.transact(14, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public CameraPosition getCameraPosition()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.lb.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            CameraPosition localCameraPosition2 = CameraPosition.CREATOR.cI(localParcel2);
            localCameraPosition1 = localCameraPosition2;
            return localCameraPosition1;
          }
          CameraPosition localCameraPosition1 = null;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public com.google.android.gms.maps.model.internal.d getFocusedBuilding()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.lb.transact(44, localParcel1, localParcel2, 0);
          localParcel2.readException();
          com.google.android.gms.maps.model.internal.d locald = com.google.android.gms.maps.model.internal.d.a.bs(localParcel2.readStrongBinder());
          return locald;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public int getMapType()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.lb.transact(15, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public float getMaxZoomLevel()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.lb.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          float f = localParcel2.readFloat();
          return f;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public float getMinZoomLevel()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.lb.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          float f = localParcel2.readFloat();
          return f;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public Location getMyLocation()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.lb.transact(23, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            localLocation = (Location)Location.CREATOR.createFromParcel(localParcel2);
            return localLocation;
          }
          Location localLocation = null;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public IProjectionDelegate getProjection()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.lb.transact(26, localParcel1, localParcel2, 0);
          localParcel2.readException();
          IProjectionDelegate localIProjectionDelegate = IProjectionDelegate.a.bj(localParcel2.readStrongBinder());
          return localIProjectionDelegate;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public IUiSettingsDelegate getUiSettings()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.lb.transact(25, localParcel1, localParcel2, 0);
          localParcel2.readException();
          IUiSettingsDelegate localIUiSettingsDelegate = IUiSettingsDelegate.a.bo(localParcel2.readStrongBinder());
          return localIUiSettingsDelegate;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public boolean isBuildingsEnabled()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.lb.transact(40, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          boolean bool = false;
          if (i != 0)
            bool = true;
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public boolean isIndoorEnabled()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.lb.transact(19, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          boolean bool = false;
          if (i != 0)
            bool = true;
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public boolean isMyLocationEnabled()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.lb.transact(21, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          boolean bool = false;
          if (i != 0)
            bool = true;
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public boolean isTrafficEnabled()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.lb.transact(17, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          boolean bool = false;
          if (i != 0)
            bool = true;
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void moveCamera(com.google.android.gms.dynamic.d paramd)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramd != null);
          for (IBinder localIBinder = paramd.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.lb.transact(4, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void setBuildingsEnabled(boolean paramBoolean)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          int i = 0;
          if (paramBoolean)
            i = 1;
          localParcel1.writeInt(i);
          this.lb.transact(41, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public boolean setIndoorEnabled(boolean paramBoolean)
        throws RemoteException
      {
        int i = 1;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramBoolean)
          {
            int j = i;
            localParcel1.writeInt(j);
            this.lb.transact(20, localParcel1, localParcel2, 0);
            localParcel2.readException();
            int m = localParcel2.readInt();
            if (m == 0)
              break label80;
          }
          while (true)
          {
            return i;
            int k = 0;
            break;
            label80: i = 0;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void setInfoWindowAdapter(d paramd)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramd != null);
          for (IBinder localIBinder = paramd.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.lb.transact(33, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void setLocationSource(ILocationSourceDelegate paramILocationSourceDelegate)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramILocationSourceDelegate != null);
          for (IBinder localIBinder = paramILocationSourceDelegate.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.lb.transact(24, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void setMapType(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          localParcel1.writeInt(paramInt);
          this.lb.transact(16, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void setMyLocationEnabled(boolean paramBoolean)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          int i = 0;
          if (paramBoolean)
            i = 1;
          localParcel1.writeInt(i);
          this.lb.transact(22, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void setOnCameraChangeListener(e parame)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (parame != null);
          for (IBinder localIBinder = parame.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.lb.transact(27, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void setOnIndoorStateChangeListener(f paramf)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramf != null);
          for (IBinder localIBinder = paramf.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.lb.transact(45, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void setOnInfoWindowClickListener(g paramg)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramg != null);
          for (IBinder localIBinder = paramg.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.lb.transact(32, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void setOnMapClickListener(i parami)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (parami != null);
          for (IBinder localIBinder = parami.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.lb.transact(28, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void setOnMapLoadedCallback(j paramj)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramj != null);
          for (IBinder localIBinder = paramj.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.lb.transact(42, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void setOnMapLongClickListener(k paramk)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramk != null);
          for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.lb.transact(29, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void setOnMarkerClickListener(l paraml)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paraml != null);
          for (IBinder localIBinder = paraml.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.lb.transact(30, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void setOnMarkerDragListener(m paramm)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramm != null);
          for (IBinder localIBinder = paramm.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.lb.transact(31, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void setOnMyLocationButtonClickListener(n paramn)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramn != null);
          for (IBinder localIBinder = paramn.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.lb.transact(37, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void setOnMyLocationChangeListener(o paramo)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramo != null);
          for (IBinder localIBinder = paramo.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.lb.transact(36, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          localParcel1.writeInt(paramInt3);
          localParcel1.writeInt(paramInt4);
          this.lb.transact(39, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void setTrafficEnabled(boolean paramBoolean)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          int i = 0;
          if (paramBoolean)
            i = 1;
          localParcel1.writeInt(i);
          this.lb.transact(18, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void snapshot(s params, com.google.android.gms.dynamic.d paramd)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (params != null);
          for (IBinder localIBinder1 = params.asBinder(); ; localIBinder1 = null)
          {
            localParcel1.writeStrongBinder(localIBinder1);
            IBinder localIBinder2 = null;
            if (paramd != null)
              localIBinder2 = paramd.asBinder();
            localParcel1.writeStrongBinder(localIBinder2);
            this.lb.transact(38, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void stopAnimation()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.lb.transact(8, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.IGoogleMapDelegate
 * JD-Core Version:    0.6.2
 */