package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.BleDevicesResult;

public abstract interface lf extends IInterface
{
  public abstract void a(BleDevicesResult paramBleDevicesResult)
    throws RemoteException;

  public static abstract class a extends Binder
    implements lf
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.fitness.internal.ble.IBleDevicesCallback");
    }

    public static lf ax(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.fitness.internal.ble.IBleDevicesCallback");
      if ((localIInterface != null) && ((localIInterface instanceof lf)))
        return (lf)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.fitness.internal.ble.IBleDevicesCallback");
        return true;
      case 1:
      }
      paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.ble.IBleDevicesCallback");
      if (paramParcel1.readInt() != 0);
      for (BleDevicesResult localBleDevicesResult = (BleDevicesResult)BleDevicesResult.CREATOR.createFromParcel(paramParcel1); ; localBleDevicesResult = null)
      {
        a(localBleDevicesResult);
        paramParcel2.writeNoException();
        return true;
      }
    }

    private static class a
      implements lf
    {
      private IBinder lb;

      a(IBinder paramIBinder)
      {
        this.lb = paramIBinder;
      }

      public void a(BleDevicesResult paramBleDevicesResult)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.fitness.internal.ble.IBleDevicesCallback");
          if (paramBleDevicesResult != null)
          {
            localParcel1.writeInt(1);
            paramBleDevicesResult.writeToParcel(localParcel1, 0);
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

      public IBinder asBinder()
      {
        return this.lb;
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.lf
 * JD-Core Version:    0.6.2
 */