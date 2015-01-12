package com.google.android.gms.plus.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;

public abstract interface c extends IInterface
{
  public abstract d a(d paramd, int paramInt1, int paramInt2, String paramString, int paramInt3)
    throws RemoteException;

  public abstract d a(d paramd, int paramInt1, int paramInt2, String paramString1, String paramString2)
    throws RemoteException;

  public static abstract class a extends Binder
    implements c
  {
    public static c bF(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
      if ((localIInterface != null) && ((localIInterface instanceof c)))
        return (c)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
        d locald2 = a(d.a.am(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        if (locald2 != null);
        for (IBinder localIBinder2 = locald2.asBinder(); ; localIBinder2 = null)
        {
          paramParcel2.writeStrongBinder(localIBinder2);
          return true;
        }
      case 2:
      }
      paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
      d locald1 = a(d.a.am(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      IBinder localIBinder1 = null;
      if (locald1 != null)
        localIBinder1 = locald1.asBinder();
      paramParcel2.writeStrongBinder(localIBinder1);
      return true;
    }

    private static class a
      implements c
    {
      private IBinder lb;

      a(IBinder paramIBinder)
      {
        this.lb = paramIBinder;
      }

      public d a(d paramd, int paramInt1, int paramInt2, String paramString, int paramInt3)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
          if (paramd != null);
          for (IBinder localIBinder = paramd.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            localParcel1.writeInt(paramInt1);
            localParcel1.writeInt(paramInt2);
            localParcel1.writeString(paramString);
            localParcel1.writeInt(paramInt3);
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

      public d a(d paramd, int paramInt1, int paramInt2, String paramString1, String paramString2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
          if (paramd != null);
          for (IBinder localIBinder = paramd.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            localParcel1.writeInt(paramInt1);
            localParcel1.writeInt(paramInt2);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            this.lb.transact(2, localParcel1, localParcel2, 0);
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
 * Qualified Name:     com.google.android.gms.plus.internal.c
 * JD-Core Version:    0.6.2
 */