package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface s extends IInterface
{
  public abstract boolean a(boolean paramBoolean)
    throws RemoteException;

  public abstract void b(String paramString, boolean paramBoolean)
    throws RemoteException;

  public abstract String c(String paramString)
    throws RemoteException;

  public abstract String getId()
    throws RemoteException;

  public static abstract class a extends Binder
    implements s
  {
    public static s b(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
      if ((localIInterface != null) && ((localIInterface instanceof s)))
        return (s)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        String str3 = getId();
        paramParcel2.writeNoException();
        paramParcel2.writeString(str3);
        return true;
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        if (paramParcel1.readInt() != 0);
        for (boolean bool2 = true; ; bool2 = false)
        {
          boolean bool3 = a(bool2);
          paramParcel2.writeNoException();
          int j = 0;
          if (bool3)
            j = 1;
          paramParcel2.writeInt(j);
          return true;
        }
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        String str2 = c(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(str2);
        return true;
      case 4:
      }
      paramParcel1.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
      String str1 = paramParcel1.readString();
      int i = paramParcel1.readInt();
      boolean bool1 = false;
      if (i != 0)
        bool1 = true;
      b(str1, bool1);
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

      public boolean a(boolean paramBoolean)
        throws RemoteException
      {
        int i = 1;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
          if (paramBoolean)
          {
            int j = i;
            localParcel1.writeInt(j);
            this.lb.transact(2, localParcel1, localParcel2, 0);
            localParcel2.readException();
            int m = localParcel2.readInt();
            if (m == 0)
              break label79;
          }
          while (true)
          {
            return i;
            int k = 0;
            break;
            label79: i = 0;
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

      public void b(String paramString, boolean paramBoolean)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
          localParcel1.writeString(paramString);
          int i = 0;
          if (paramBoolean)
            i = 1;
          localParcel1.writeInt(i);
          this.lb.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public String c(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
          localParcel1.writeString(paramString);
          this.lb.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public String getId()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
          this.lb.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
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
 * Qualified Name:     com.google.android.gms.internal.s
 * JD-Core Version:    0.6.2
 */