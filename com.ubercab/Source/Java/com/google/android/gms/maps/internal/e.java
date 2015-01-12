package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.a;

public abstract interface e extends IInterface
{
  public abstract void onCameraChange(CameraPosition paramCameraPosition)
    throws RemoteException;

  public static abstract class a extends Binder
    implements e
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.maps.internal.IOnCameraChangeListener");
    }

    public static e aV(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnCameraChangeListener");
      if ((localIInterface != null) && ((localIInterface instanceof e)))
        return (e)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.maps.internal.IOnCameraChangeListener");
        return true;
      case 1:
      }
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IOnCameraChangeListener");
      if (paramParcel1.readInt() != 0);
      for (CameraPosition localCameraPosition = CameraPosition.CREATOR.cI(paramParcel1); ; localCameraPosition = null)
      {
        onCameraChange(localCameraPosition);
        paramParcel2.writeNoException();
        return true;
      }
    }

    private static class a
      implements e
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

      public void onCameraChange(CameraPosition paramCameraPosition)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IOnCameraChangeListener");
          if (paramCameraPosition != null)
          {
            localParcel1.writeInt(1);
            paramCameraPosition.writeToParcel(localParcel1, 0);
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
 * Qualified Name:     com.google.android.gms.maps.internal.e
 * JD-Core Version:    0.6.2
 */