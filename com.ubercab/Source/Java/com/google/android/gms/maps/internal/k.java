package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.i;

public abstract interface k extends IInterface
{
  public abstract void onMapLongClick(LatLng paramLatLng)
    throws RemoteException;

  public static abstract class a extends Binder
    implements k
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.maps.internal.IOnMapLongClickListener");
    }

    public static k bb(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnMapLongClickListener");
      if ((localIInterface != null) && ((localIInterface instanceof k)))
        return (k)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.maps.internal.IOnMapLongClickListener");
        return true;
      case 1:
      }
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IOnMapLongClickListener");
      if (paramParcel1.readInt() != 0);
      for (LatLng localLatLng = LatLng.CREATOR.cM(paramParcel1); ; localLatLng = null)
      {
        onMapLongClick(localLatLng);
        paramParcel2.writeNoException();
        return true;
      }
    }

    private static class a
      implements k
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

      public void onMapLongClick(LatLng paramLatLng)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMapLongClickListener");
          if (paramLatLng != null)
          {
            localParcel1.writeInt(1);
            paramLatLng.writeToParcel(localParcel1, 0);
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
 * Qualified Name:     com.google.android.gms.maps.internal.k
 * JD-Core Version:    0.6.2
 */