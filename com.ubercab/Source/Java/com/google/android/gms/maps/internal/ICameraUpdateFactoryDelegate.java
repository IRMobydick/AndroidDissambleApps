package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.a;
import com.google.android.gms.maps.model.g;
import com.google.android.gms.maps.model.i;

public abstract interface ICameraUpdateFactoryDelegate extends IInterface
{
  public abstract d newCameraPosition(CameraPosition paramCameraPosition)
    throws RemoteException;

  public abstract d newLatLng(LatLng paramLatLng)
    throws RemoteException;

  public abstract d newLatLngBounds(LatLngBounds paramLatLngBounds, int paramInt)
    throws RemoteException;

  public abstract d newLatLngBoundsWithSize(LatLngBounds paramLatLngBounds, int paramInt1, int paramInt2, int paramInt3)
    throws RemoteException;

  public abstract d newLatLngZoom(LatLng paramLatLng, float paramFloat)
    throws RemoteException;

  public abstract d scrollBy(float paramFloat1, float paramFloat2)
    throws RemoteException;

  public abstract d zoomBy(float paramFloat)
    throws RemoteException;

  public abstract d zoomByWithFocus(float paramFloat, int paramInt1, int paramInt2)
    throws RemoteException;

  public abstract d zoomIn()
    throws RemoteException;

  public abstract d zoomOut()
    throws RemoteException;

  public abstract d zoomTo(float paramFloat)
    throws RemoteException;

  public static abstract class a extends Binder
    implements ICameraUpdateFactoryDelegate
  {
    public static ICameraUpdateFactoryDelegate aN(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
      if ((localIInterface != null) && ((localIInterface instanceof ICameraUpdateFactoryDelegate)))
        return (ICameraUpdateFactoryDelegate)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        d locald11 = zoomIn();
        paramParcel2.writeNoException();
        IBinder localIBinder11 = null;
        if (locald11 != null)
          localIBinder11 = locald11.asBinder();
        paramParcel2.writeStrongBinder(localIBinder11);
        return true;
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        d locald10 = zoomOut();
        paramParcel2.writeNoException();
        IBinder localIBinder10 = null;
        if (locald10 != null)
          localIBinder10 = locald10.asBinder();
        paramParcel2.writeStrongBinder(localIBinder10);
        return true;
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        d locald9 = scrollBy(paramParcel1.readFloat(), paramParcel1.readFloat());
        paramParcel2.writeNoException();
        IBinder localIBinder9 = null;
        if (locald9 != null)
          localIBinder9 = locald9.asBinder();
        paramParcel2.writeStrongBinder(localIBinder9);
        return true;
      case 4:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        d locald8 = zoomTo(paramParcel1.readFloat());
        paramParcel2.writeNoException();
        IBinder localIBinder8 = null;
        if (locald8 != null)
          localIBinder8 = locald8.asBinder();
        paramParcel2.writeStrongBinder(localIBinder8);
        return true;
      case 5:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        d locald7 = zoomBy(paramParcel1.readFloat());
        paramParcel2.writeNoException();
        IBinder localIBinder7 = null;
        if (locald7 != null)
          localIBinder7 = locald7.asBinder();
        paramParcel2.writeStrongBinder(localIBinder7);
        return true;
      case 6:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        d locald6 = zoomByWithFocus(paramParcel1.readFloat(), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        IBinder localIBinder6 = null;
        if (locald6 != null)
          localIBinder6 = locald6.asBinder();
        paramParcel2.writeStrongBinder(localIBinder6);
        return true;
      case 7:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        if (paramParcel1.readInt() != 0);
        for (CameraPosition localCameraPosition = CameraPosition.CREATOR.cI(paramParcel1); ; localCameraPosition = null)
        {
          d locald5 = newCameraPosition(localCameraPosition);
          paramParcel2.writeNoException();
          IBinder localIBinder5 = null;
          if (locald5 != null)
            localIBinder5 = locald5.asBinder();
          paramParcel2.writeStrongBinder(localIBinder5);
          return true;
        }
      case 8:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        if (paramParcel1.readInt() != 0);
        for (LatLng localLatLng2 = LatLng.CREATOR.cM(paramParcel1); ; localLatLng2 = null)
        {
          d locald4 = newLatLng(localLatLng2);
          paramParcel2.writeNoException();
          IBinder localIBinder4 = null;
          if (locald4 != null)
            localIBinder4 = locald4.asBinder();
          paramParcel2.writeStrongBinder(localIBinder4);
          return true;
        }
      case 9:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        if (paramParcel1.readInt() != 0);
        for (LatLng localLatLng1 = LatLng.CREATOR.cM(paramParcel1); ; localLatLng1 = null)
        {
          d locald3 = newLatLngZoom(localLatLng1, paramParcel1.readFloat());
          paramParcel2.writeNoException();
          IBinder localIBinder3 = null;
          if (locald3 != null)
            localIBinder3 = locald3.asBinder();
          paramParcel2.writeStrongBinder(localIBinder3);
          return true;
        }
      case 10:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        if (paramParcel1.readInt() != 0);
        for (LatLngBounds localLatLngBounds2 = LatLngBounds.CREATOR.cL(paramParcel1); ; localLatLngBounds2 = null)
        {
          d locald2 = newLatLngBounds(localLatLngBounds2, paramParcel1.readInt());
          paramParcel2.writeNoException();
          IBinder localIBinder2 = null;
          if (locald2 != null)
            localIBinder2 = locald2.asBinder();
          paramParcel2.writeStrongBinder(localIBinder2);
          return true;
        }
      case 11:
      }
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
      if (paramParcel1.readInt() != 0);
      for (LatLngBounds localLatLngBounds1 = LatLngBounds.CREATOR.cL(paramParcel1); ; localLatLngBounds1 = null)
      {
        d locald1 = newLatLngBoundsWithSize(localLatLngBounds1, paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        IBinder localIBinder1 = null;
        if (locald1 != null)
          localIBinder1 = locald1.asBinder();
        paramParcel2.writeStrongBinder(localIBinder1);
        return true;
      }
    }

    private static class a
      implements ICameraUpdateFactoryDelegate
    {
      private IBinder lb;

      a(IBinder paramIBinder)
      {
        this.lb = paramIBinder;
      }

      public IBinder asBinder()
      {
        return this.lb;
      }

      public d newCameraPosition(CameraPosition paramCameraPosition)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
          if (paramCameraPosition != null)
          {
            localParcel1.writeInt(1);
            paramCameraPosition.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.lb.transact(7, localParcel1, localParcel2, 0);
            localParcel2.readException();
            d locald = d.a.am(localParcel2.readStrongBinder());
            return locald;
            localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public d newLatLng(LatLng paramLatLng)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
          if (paramLatLng != null)
          {
            localParcel1.writeInt(1);
            paramLatLng.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.lb.transact(8, localParcel1, localParcel2, 0);
            localParcel2.readException();
            d locald = d.a.am(localParcel2.readStrongBinder());
            return locald;
            localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public d newLatLngBounds(LatLngBounds paramLatLngBounds, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
          if (paramLatLngBounds != null)
          {
            localParcel1.writeInt(1);
            paramLatLngBounds.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            localParcel1.writeInt(paramInt);
            this.lb.transact(10, localParcel1, localParcel2, 0);
            localParcel2.readException();
            d locald = d.a.am(localParcel2.readStrongBinder());
            return locald;
            localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public d newLatLngBoundsWithSize(LatLngBounds paramLatLngBounds, int paramInt1, int paramInt2, int paramInt3)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
          if (paramLatLngBounds != null)
          {
            localParcel1.writeInt(1);
            paramLatLngBounds.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            localParcel1.writeInt(paramInt1);
            localParcel1.writeInt(paramInt2);
            localParcel1.writeInt(paramInt3);
            this.lb.transact(11, localParcel1, localParcel2, 0);
            localParcel2.readException();
            d locald = d.a.am(localParcel2.readStrongBinder());
            return locald;
            localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public d newLatLngZoom(LatLng paramLatLng, float paramFloat)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
          if (paramLatLng != null)
          {
            localParcel1.writeInt(1);
            paramLatLng.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            localParcel1.writeFloat(paramFloat);
            this.lb.transact(9, localParcel1, localParcel2, 0);
            localParcel2.readException();
            d locald = d.a.am(localParcel2.readStrongBinder());
            return locald;
            localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public d scrollBy(float paramFloat1, float paramFloat2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
          localParcel1.writeFloat(paramFloat1);
          localParcel1.writeFloat(paramFloat2);
          this.lb.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          d locald = d.a.am(localParcel2.readStrongBinder());
          return locald;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public d zoomBy(float paramFloat)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
          localParcel1.writeFloat(paramFloat);
          this.lb.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          d locald = d.a.am(localParcel2.readStrongBinder());
          return locald;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public d zoomByWithFocus(float paramFloat, int paramInt1, int paramInt2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
          localParcel1.writeFloat(paramFloat);
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          this.lb.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          d locald = d.a.am(localParcel2.readStrongBinder());
          return locald;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public d zoomIn()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
          this.lb.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          d locald = d.a.am(localParcel2.readStrongBinder());
          return locald;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public d zoomOut()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
          this.lb.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          d locald = d.a.am(localParcel2.readStrongBinder());
          return locald;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public d zoomTo(float paramFloat)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
          localParcel1.writeFloat(paramFloat);
          this.lb.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          d locald = d.a.am(localParcel2.readStrongBinder());
          return locald;
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
 * Qualified Name:     com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate
 * JD-Core Version:    0.6.2
 */