package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.Tile;
import com.google.android.gms.maps.model.u;

public abstract interface i extends IInterface
{
  public abstract Tile getTile(int paramInt1, int paramInt2, int paramInt3)
    throws RemoteException;

  public static abstract class a extends Binder
    implements i
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.maps.model.internal.ITileProviderDelegate");
    }

    public static i by(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
      if ((localIInterface != null) && ((localIInterface instanceof i)))
        return (i)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
        return true;
      case 1:
      }
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
      Tile localTile = getTile(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      if (localTile != null)
      {
        paramParcel2.writeInt(1);
        localTile.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    }

    private static class a
      implements i
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

      public Tile getTile(int paramInt1, int paramInt2, int paramInt3)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          localParcel1.writeInt(paramInt3);
          this.lb.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            Tile localTile2 = Tile.CREATOR.cU(localParcel2);
            localTile1 = localTile2;
            return localTile1;
          }
          Tile localTile1 = null;
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
 * Qualified Name:     com.google.android.gms.maps.model.internal.i
 * JD-Core Version:    0.6.2
 */