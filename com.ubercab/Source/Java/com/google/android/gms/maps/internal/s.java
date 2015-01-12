package com.google.android.gms.maps.internal;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;

public abstract interface s extends IInterface
{
  public abstract void h(d paramd)
    throws RemoteException;

  public abstract void onSnapshotReady(Bitmap paramBitmap)
    throws RemoteException;

  public static abstract class a extends Binder
    implements s
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.maps.internal.ISnapshotReadyCallback");
    }

    public static s bk(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
      if ((localIInterface != null) && ((localIInterface instanceof s)))
        return (s)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
        if (paramParcel1.readInt() != 0);
        for (Bitmap localBitmap = (Bitmap)Bitmap.CREATOR.createFromParcel(paramParcel1); ; localBitmap = null)
        {
          onSnapshotReady(localBitmap);
          paramParcel2.writeNoException();
          return true;
        }
      case 2:
      }
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
      h(d.a.am(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }

    private static class a
      implements s
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

      public void h(d paramd)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
          if (paramd != null);
          for (IBinder localIBinder = paramd.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.lb.transact(2, localParcel1, localParcel2, 0);
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

      public void onSnapshotReady(Bitmap paramBitmap)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
          if (paramBitmap != null)
          {
            localParcel1.writeInt(1);
            paramBitmap.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.lb.transact(1, localParcel1, localParcel2, 0);
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
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.s
 * JD-Core Version:    0.6.2
 */