package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface ct extends IInterface
{
  public abstract cu x(String paramString)
    throws RemoteException;

  public abstract boolean y(String paramString)
    throws RemoteException;

  public static abstract class a extends Binder
    implements ct
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    public static ct l(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
      if ((localIInterface != null) && ((localIInterface instanceof ct)))
        return (ct)localIInterface;
      return new a(paramIBinder);
    }

    public IBinder asBinder()
    {
      return this;
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        cu localcu = x(paramParcel1.readString());
        paramParcel2.writeNoException();
        if (localcu != null);
        for (IBinder localIBinder = localcu.asBinder(); ; localIBinder = null)
        {
          paramParcel2.writeStrongBinder(localIBinder);
          return true;
        }
      case 2:
      }
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
      boolean bool = y(paramParcel1.readString());
      paramParcel2.writeNoException();
      if (bool);
      for (int i = 1; ; i = 0)
      {
        paramParcel2.writeInt(i);
        return true;
      }
    }

    private static class a
      implements ct
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

      public cu x(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
          localParcel1.writeString(paramString);
          this.lb.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          cu localcu = cu.a.m(localParcel2.readStrongBinder());
          return localcu;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public boolean y(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
          localParcel1.writeString(paramString);
          this.lb.transact(2, localParcel1, localParcel2, 0);
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
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ct
 * JD-Core Version:    0.6.2
 */