package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DataReadResult;

public abstract interface km extends IInterface
{
  public abstract void a(DataReadResult paramDataReadResult)
    throws RemoteException;

  public static abstract class a extends Binder
    implements km
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.fitness.internal.IDataReadCallback");
    }

    public static km ap(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IDataReadCallback");
      if ((localIInterface != null) && ((localIInterface instanceof km)))
        return (km)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.fitness.internal.IDataReadCallback");
        return true;
      case 1:
      }
      paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IDataReadCallback");
      if (paramParcel1.readInt() != 0);
      for (DataReadResult localDataReadResult = (DataReadResult)DataReadResult.CREATOR.createFromParcel(paramParcel1); ; localDataReadResult = null)
      {
        a(localDataReadResult);
        return true;
      }
    }

    private static class a
      implements km
    {
      private IBinder lb;

      a(IBinder paramIBinder)
      {
        this.lb = paramIBinder;
      }

      public void a(DataReadResult paramDataReadResult)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IDataReadCallback");
          if (paramDataReadResult != null)
          {
            localParcel.writeInt(1);
            paramDataReadResult.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            this.lb.transact(1, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
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
 * Qualified Name:     com.google.android.gms.internal.km
 * JD-Core Version:    0.6.2
 */