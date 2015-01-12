package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;

public abstract interface kq extends IInterface
{
  public abstract void a(ListSubscriptionsResult paramListSubscriptionsResult)
    throws RemoteException;

  public static abstract class a extends Binder
    implements kq
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
    }

    public static kq at(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
      if ((localIInterface != null) && ((localIInterface instanceof kq)))
        return (kq)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
        return true;
      case 1:
      }
      paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
      if (paramParcel1.readInt() != 0);
      for (ListSubscriptionsResult localListSubscriptionsResult = (ListSubscriptionsResult)ListSubscriptionsResult.CREATOR.createFromParcel(paramParcel1); ; localListSubscriptionsResult = null)
      {
        a(localListSubscriptionsResult);
        paramParcel2.writeNoException();
        return true;
      }
    }

    private static class a
      implements kq
    {
      private IBinder lb;

      a(IBinder paramIBinder)
      {
        this.lb = paramIBinder;
      }

      public void a(ListSubscriptionsResult paramListSubscriptionsResult)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
          if (paramListSubscriptionsResult != null)
          {
            localParcel1.writeInt(1);
            paramListSubscriptionsResult.writeToParcel(localParcel1, 0);
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
 * Qualified Name:     com.google.android.gms.internal.kq
 * JD-Core Version:    0.6.2
 */