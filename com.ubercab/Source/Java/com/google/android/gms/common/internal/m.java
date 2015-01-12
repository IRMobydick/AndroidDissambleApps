package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;

public abstract interface m extends IInterface
{
  public abstract d a(d paramd, int paramInt1, int paramInt2)
    throws RemoteException;

  public static abstract class a extends Binder
    implements m
  {
    public static m R(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
      if ((localIInterface != null) && ((localIInterface instanceof m)))
        return (m)localIInterface;
      return new a(paramIBinder);
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("com.google.android.gms.common.internal.ISignInButtonCreator");
        return true;
      case 1:
      }
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
      d locald = a(d.a.am(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      if (locald != null);
      for (IBinder localIBinder = locald.asBinder(); ; localIBinder = null)
      {
        paramParcel2.writeStrongBinder(localIBinder);
        return true;
      }
    }

    private static class a
      implements m
    {
      private IBinder lb;

      a(IBinder paramIBinder)
      {
        this.lb = paramIBinder;
      }

      public d a(d paramd, int paramInt1, int paramInt2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.common.internal.ISignInButtonCreator");
          if (paramd != null);
          for (IBinder localIBinder = paramd.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            localParcel1.writeInt(paramInt1);
            localParcel1.writeInt(paramInt2);
            this.lb.transact(1, localParcel1, localParcel2, 0);
            localParcel2.readException();
            d locald = d.a.am(localParcel2.readStrongBinder());
            return locald;
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
 * Qualified Name:     com.google.android.gms.common.internal.m
 * JD-Core Version:    0.6.2
 */