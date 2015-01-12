package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface ILocationSourceDelegate extends IInterface
{
  public abstract void activate(h paramh)
    throws RemoteException;

  public abstract void deactivate()
    throws RemoteException;

  public static abstract class a extends Binder
    implements ILocationSourceDelegate
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.maps.internal.ILocationSourceDelegate");
    }

    public static ILocationSourceDelegate aS(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.ILocationSourceDelegate");
      if ((localIInterface != null) && ((localIInterface instanceof ILocationSourceDelegate)))
        return (ILocationSourceDelegate)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.maps.internal.ILocationSourceDelegate");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ILocationSourceDelegate");
        activate(h.a.aY(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 2:
      }
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ILocationSourceDelegate");
      deactivate();
      paramParcel2.writeNoException();
      return true;
    }

    private static class a
      implements ILocationSourceDelegate
    {
      private IBinder lb;

      a(IBinder paramIBinder)
      {
        this.lb = paramIBinder;
      }

      public void activate(h paramh)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.ILocationSourceDelegate");
          if (paramh != null);
          for (IBinder localIBinder = paramh.asBinder(); ; localIBinder = null)
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

      public IBinder asBinder()
      {
        return this.lb;
      }

      public void deactivate()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.ILocationSourceDelegate");
          this.lb.transact(2, localParcel1, localParcel2, 0);
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
 * Qualified Name:     com.google.android.gms.maps.internal.ILocationSourceDelegate
 * JD-Core Version:    0.6.2
 */