package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.c;

public abstract interface IStreetViewPanoramaFragmentDelegate extends IInterface
{
  public abstract IStreetViewPanoramaDelegate getStreetViewPanorama()
    throws RemoteException;

  public abstract boolean isReady()
    throws RemoteException;

  public abstract void onCreate(Bundle paramBundle)
    throws RemoteException;

  public abstract d onCreateView(d paramd1, d paramd2, Bundle paramBundle)
    throws RemoteException;

  public abstract void onDestroy()
    throws RemoteException;

  public abstract void onDestroyView()
    throws RemoteException;

  public abstract void onInflate(d paramd, StreetViewPanoramaOptions paramStreetViewPanoramaOptions, Bundle paramBundle)
    throws RemoteException;

  public abstract void onLowMemory()
    throws RemoteException;

  public abstract void onPause()
    throws RemoteException;

  public abstract void onResume()
    throws RemoteException;

  public abstract void onSaveInstanceState(Bundle paramBundle)
    throws RemoteException;

  public static abstract class a extends Binder
    implements IStreetViewPanoramaFragmentDelegate
  {
    public static IStreetViewPanoramaFragmentDelegate bm(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
      if ((localIInterface != null) && ((localIInterface instanceof IStreetViewPanoramaFragmentDelegate)))
        return (IStreetViewPanoramaFragmentDelegate)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
        IStreetViewPanoramaDelegate localIStreetViewPanoramaDelegate = getStreetViewPanorama();
        paramParcel2.writeNoException();
        if (localIStreetViewPanoramaDelegate != null);
        for (IBinder localIBinder2 = localIStreetViewPanoramaDelegate.asBinder(); ; localIBinder2 = null)
        {
          paramParcel2.writeStrongBinder(localIBinder2);
          return true;
        }
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
        d locald4 = d.a.am(paramParcel1.readStrongBinder());
        StreetViewPanoramaOptions localStreetViewPanoramaOptions;
        if (paramParcel1.readInt() != 0)
        {
          localStreetViewPanoramaOptions = StreetViewPanoramaOptions.CREATOR.cH(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label244;
        }
        for (Bundle localBundle4 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle4 = null)
        {
          onInflate(locald4, localStreetViewPanoramaOptions, localBundle4);
          paramParcel2.writeNoException();
          return true;
          localStreetViewPanoramaOptions = null;
          break;
        }
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
        if (paramParcel1.readInt() != 0);
        for (Bundle localBundle3 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle3 = null)
        {
          onCreate(localBundle3);
          paramParcel2.writeNoException();
          return true;
        }
      case 4:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
        d locald1 = d.a.am(paramParcel1.readStrongBinder());
        d locald2 = d.a.am(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0);
        for (Bundle localBundle2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle2 = null)
        {
          d locald3 = onCreateView(locald1, locald2, localBundle2);
          paramParcel2.writeNoException();
          IBinder localIBinder1 = null;
          if (locald3 != null)
            localIBinder1 = locald3.asBinder();
          paramParcel2.writeStrongBinder(localIBinder1);
          return true;
        }
      case 5:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
        onResume();
        paramParcel2.writeNoException();
        return true;
      case 6:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
        onPause();
        paramParcel2.writeNoException();
        return true;
      case 7:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
        onDestroyView();
        paramParcel2.writeNoException();
        return true;
      case 8:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
        onDestroy();
        paramParcel2.writeNoException();
        return true;
      case 9:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
        onLowMemory();
        paramParcel2.writeNoException();
        return true;
      case 10:
        label244: paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
        if (paramParcel1.readInt() != 0);
        for (Bundle localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle1 = null)
        {
          onSaveInstanceState(localBundle1);
          paramParcel2.writeNoException();
          if (localBundle1 == null)
            break;
          paramParcel2.writeInt(1);
          localBundle1.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 11:
      }
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
      boolean bool = isReady();
      paramParcel2.writeNoException();
      if (bool);
      for (int i = 1; ; i = 0)
      {
        paramParcel2.writeInt(i);
        return true;
      }
    }

    private static class a
      implements IStreetViewPanoramaFragmentDelegate
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

      public IStreetViewPanoramaDelegate getStreetViewPanorama()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
          this.lb.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          IStreetViewPanoramaDelegate localIStreetViewPanoramaDelegate = IStreetViewPanoramaDelegate.a.bl(localParcel2.readStrongBinder());
          return localIStreetViewPanoramaDelegate;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public boolean isReady()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
          this.lb.transact(11, localParcel1, localParcel2, 0);
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

      public void onCreate(Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.lb.transact(3, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public d onCreateView(d paramd1, d paramd2, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
          IBinder localIBinder1;
          if (paramd1 != null)
          {
            localIBinder1 = paramd1.asBinder();
            localParcel1.writeStrongBinder(localIBinder1);
            IBinder localIBinder2 = null;
            if (paramd2 != null)
              localIBinder2 = paramd2.asBinder();
            localParcel1.writeStrongBinder(localIBinder2);
            if (paramBundle == null)
              break label125;
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.lb.transact(4, localParcel1, localParcel2, 0);
            localParcel2.readException();
            d locald = d.a.am(localParcel2.readStrongBinder());
            return locald;
            localIBinder1 = null;
            break;
            label125: localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void onDestroy()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
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

      public void onDestroyView()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
          this.lb.transact(7, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void onInflate(d paramd, StreetViewPanoramaOptions paramStreetViewPanoramaOptions, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
            IBinder localIBinder;
            if (paramd != null)
            {
              localIBinder = paramd.asBinder();
              localParcel1.writeStrongBinder(localIBinder);
              if (paramStreetViewPanoramaOptions != null)
              {
                localParcel1.writeInt(1);
                paramStreetViewPanoramaOptions.writeToParcel(localParcel1, 0);
                if (paramBundle == null)
                  break label132;
                localParcel1.writeInt(1);
                paramBundle.writeToParcel(localParcel1, 0);
                this.lb.transact(2, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localIBinder = null;
              continue;
            }
            localParcel1.writeInt(0);
            continue;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          label132: localParcel1.writeInt(0);
        }
      }

      public void onLowMemory()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
          this.lb.transact(9, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void onPause()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
          this.lb.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void onResume()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
          this.lb.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void onSaveInstanceState(Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.lb.transact(10, localParcel1, localParcel2, 0);
            localParcel2.readException();
            if (localParcel2.readInt() != 0)
              paramBundle.readFromParcel(localParcel2);
            return;
            localParcel1.writeInt(0);
          }
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
 * Qualified Name:     com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
 * JD-Core Version:    0.6.2
 */