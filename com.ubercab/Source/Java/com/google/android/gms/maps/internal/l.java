package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.f;
import com.google.android.gms.maps.model.internal.f.a;

public abstract interface l extends IInterface
{
  public abstract boolean a(f paramf)
    throws RemoteException;

  public static abstract class a extends Binder
    implements l
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.maps.internal.IOnMarkerClickListener");
    }

    public static l bc(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnMarkerClickListener");
      if ((localIInterface != null) && ((localIInterface instanceof l)))
        return (l)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.maps.internal.IOnMarkerClickListener");
        return true;
      case 1:
      }
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerClickListener");
      boolean bool = a(f.a.bu(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      if (bool);
      for (int i = 1; ; i = 0)
      {
        paramParcel2.writeInt(i);
        return true;
      }
    }

    private static class a
      implements l
    {
      private IBinder lb;

      a(IBinder paramIBinder)
      {
        this.lb = paramIBinder;
      }

      public boolean a(f paramf)
        throws RemoteException
      {
        boolean bool = true;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMarkerClickListener");
          IBinder localIBinder;
          if (paramf != null)
          {
            localIBinder = paramf.asBinder();
            localParcel1.writeStrongBinder(localIBinder);
            this.lb.transact(1, localParcel1, localParcel2, 0);
            localParcel2.readException();
            int i = localParcel2.readInt();
            if (i == 0)
              break label84;
          }
          while (true)
          {
            return bool;
            localIBinder = null;
            break;
            label84: bool = false;
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
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.l
 * JD-Core Version:    0.6.2
 */