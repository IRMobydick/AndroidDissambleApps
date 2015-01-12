package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.model.internal.a.a;

public abstract interface c extends IInterface
{
  public abstract IMapViewDelegate a(d paramd, GoogleMapOptions paramGoogleMapOptions)
    throws RemoteException;

  public abstract IStreetViewPanoramaViewDelegate a(d paramd, StreetViewPanoramaOptions paramStreetViewPanoramaOptions)
    throws RemoteException;

  public abstract void a(d paramd, int paramInt)
    throws RemoteException;

  public abstract void i(d paramd)
    throws RemoteException;

  public abstract IMapFragmentDelegate j(d paramd)
    throws RemoteException;

  public abstract IStreetViewPanoramaFragmentDelegate k(d paramd)
    throws RemoteException;

  public abstract ICameraUpdateFactoryDelegate mI()
    throws RemoteException;

  public abstract com.google.android.gms.maps.model.internal.a mJ()
    throws RemoteException;

  public static abstract class a extends Binder
    implements c
  {
    public static c aP(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
      if ((localIInterface != null) && ((localIInterface instanceof c)))
        return (c)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.maps.internal.ICreator");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICreator");
        i(d.a.am(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICreator");
        IMapFragmentDelegate localIMapFragmentDelegate = j(d.a.am(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        IBinder localIBinder6 = null;
        if (localIMapFragmentDelegate != null)
          localIBinder6 = localIMapFragmentDelegate.asBinder();
        paramParcel2.writeStrongBinder(localIBinder6);
        return true;
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICreator");
        d locald2 = d.a.am(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0);
        for (GoogleMapOptions localGoogleMapOptions = GoogleMapOptions.CREATOR.cG(paramParcel1); ; localGoogleMapOptions = null)
        {
          IMapViewDelegate localIMapViewDelegate = a(locald2, localGoogleMapOptions);
          paramParcel2.writeNoException();
          IBinder localIBinder5 = null;
          if (localIMapViewDelegate != null)
            localIBinder5 = localIMapViewDelegate.asBinder();
          paramParcel2.writeStrongBinder(localIBinder5);
          return true;
        }
      case 4:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICreator");
        ICameraUpdateFactoryDelegate localICameraUpdateFactoryDelegate = mI();
        paramParcel2.writeNoException();
        IBinder localIBinder4 = null;
        if (localICameraUpdateFactoryDelegate != null)
          localIBinder4 = localICameraUpdateFactoryDelegate.asBinder();
        paramParcel2.writeStrongBinder(localIBinder4);
        return true;
      case 5:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICreator");
        com.google.android.gms.maps.model.internal.a locala = mJ();
        paramParcel2.writeNoException();
        IBinder localIBinder3 = null;
        if (locala != null)
          localIBinder3 = locala.asBinder();
        paramParcel2.writeStrongBinder(localIBinder3);
        return true;
      case 6:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICreator");
        a(d.a.am(paramParcel1.readStrongBinder()), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 7:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICreator");
        d locald1 = d.a.am(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0);
        for (StreetViewPanoramaOptions localStreetViewPanoramaOptions = StreetViewPanoramaOptions.CREATOR.cH(paramParcel1); ; localStreetViewPanoramaOptions = null)
        {
          IStreetViewPanoramaViewDelegate localIStreetViewPanoramaViewDelegate = a(locald1, localStreetViewPanoramaOptions);
          paramParcel2.writeNoException();
          IBinder localIBinder2 = null;
          if (localIStreetViewPanoramaViewDelegate != null)
            localIBinder2 = localIStreetViewPanoramaViewDelegate.asBinder();
          paramParcel2.writeStrongBinder(localIBinder2);
          return true;
        }
      case 8:
      }
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICreator");
      IStreetViewPanoramaFragmentDelegate localIStreetViewPanoramaFragmentDelegate = k(d.a.am(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      IBinder localIBinder1 = null;
      if (localIStreetViewPanoramaFragmentDelegate != null)
        localIBinder1 = localIStreetViewPanoramaFragmentDelegate.asBinder();
      paramParcel2.writeStrongBinder(localIBinder1);
      return true;
    }

    private static class a
      implements c
    {
      private IBinder lb;

      a(IBinder paramIBinder)
      {
        this.lb = paramIBinder;
      }

      public IMapViewDelegate a(d paramd, GoogleMapOptions paramGoogleMapOptions)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
          IBinder localIBinder;
          if (paramd != null)
          {
            localIBinder = paramd.asBinder();
            localParcel1.writeStrongBinder(localIBinder);
            if (paramGoogleMapOptions == null)
              break label96;
            localParcel1.writeInt(1);
            paramGoogleMapOptions.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.lb.transact(3, localParcel1, localParcel2, 0);
            localParcel2.readException();
            IMapViewDelegate localIMapViewDelegate = IMapViewDelegate.a.aU(localParcel2.readStrongBinder());
            return localIMapViewDelegate;
            localIBinder = null;
            break;
            label96: localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public IStreetViewPanoramaViewDelegate a(d paramd, StreetViewPanoramaOptions paramStreetViewPanoramaOptions)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
          IBinder localIBinder;
          if (paramd != null)
          {
            localIBinder = paramd.asBinder();
            localParcel1.writeStrongBinder(localIBinder);
            if (paramStreetViewPanoramaOptions == null)
              break label97;
            localParcel1.writeInt(1);
            paramStreetViewPanoramaOptions.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.lb.transact(7, localParcel1, localParcel2, 0);
            localParcel2.readException();
            IStreetViewPanoramaViewDelegate localIStreetViewPanoramaViewDelegate = IStreetViewPanoramaViewDelegate.a.bn(localParcel2.readStrongBinder());
            return localIStreetViewPanoramaViewDelegate;
            localIBinder = null;
            break;
            label97: localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void a(d paramd, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
          if (paramd != null);
          for (IBinder localIBinder = paramd.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            localParcel1.writeInt(paramInt);
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

      public IBinder asBinder()
      {
        return this.lb;
      }

      public void i(d paramd)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
          if (paramd != null);
          for (IBinder localIBinder = paramd.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.lb.transact(1, localParcel1, localParcel2, 0);
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

      public IMapFragmentDelegate j(d paramd)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
          if (paramd != null);
          for (IBinder localIBinder = paramd.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.lb.transact(2, localParcel1, localParcel2, 0);
            localParcel2.readException();
            IMapFragmentDelegate localIMapFragmentDelegate = IMapFragmentDelegate.a.aT(localParcel2.readStrongBinder());
            return localIMapFragmentDelegate;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public IStreetViewPanoramaFragmentDelegate k(d paramd)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
          if (paramd != null);
          for (IBinder localIBinder = paramd.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.lb.transact(8, localParcel1, localParcel2, 0);
            localParcel2.readException();
            IStreetViewPanoramaFragmentDelegate localIStreetViewPanoramaFragmentDelegate = IStreetViewPanoramaFragmentDelegate.a.bm(localParcel2.readStrongBinder());
            return localIStreetViewPanoramaFragmentDelegate;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public ICameraUpdateFactoryDelegate mI()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
          this.lb.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          ICameraUpdateFactoryDelegate localICameraUpdateFactoryDelegate = ICameraUpdateFactoryDelegate.a.aN(localParcel2.readStrongBinder());
          return localICameraUpdateFactoryDelegate;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public com.google.android.gms.maps.model.internal.a mJ()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
          this.lb.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          com.google.android.gms.maps.model.internal.a locala = a.a.bp(localParcel2.readStrongBinder());
          return locala;
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
 * Qualified Name:     com.google.android.gms.maps.internal.c
 * JD-Core Version:    0.6.2
 */