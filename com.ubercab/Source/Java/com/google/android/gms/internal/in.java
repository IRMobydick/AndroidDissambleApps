package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.cast.LaunchOptions;

public abstract interface in extends IInterface
{
  public abstract void a(double paramDouble1, double paramDouble2, boolean paramBoolean)
    throws RemoteException;

  public abstract void a(String paramString, LaunchOptions paramLaunchOptions)
    throws RemoteException;

  public abstract void a(String paramString1, String paramString2, long paramLong)
    throws RemoteException;

  public abstract void a(String paramString, byte[] paramArrayOfByte, long paramLong)
    throws RemoteException;

  public abstract void a(boolean paramBoolean1, double paramDouble, boolean paramBoolean2)
    throws RemoteException;

  public abstract void aH(String paramString)
    throws RemoteException;

  public abstract void aI(String paramString)
    throws RemoteException;

  public abstract void aJ(String paramString)
    throws RemoteException;

  public abstract void disconnect()
    throws RemoteException;

  public abstract void f(String paramString, boolean paramBoolean)
    throws RemoteException;

  public abstract void fD()
    throws RemoteException;

  public abstract void fP()
    throws RemoteException;

  public abstract void l(String paramString1, String paramString2)
    throws RemoteException;

  public static abstract class a extends Binder
    implements in
  {
    public static in M(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.cast.internal.ICastDeviceController");
      if ((localIInterface != null) && ((localIInterface instanceof in)))
        return (in)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.cast.internal.ICastDeviceController");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
        disconnect();
        return true;
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
        String str2 = paramParcel1.readString();
        int j = paramParcel1.readInt();
        boolean bool4 = false;
        if (j != 0)
          bool4 = true;
        f(str2, bool4);
        return true;
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
        l(paramParcel1.readString(), paramParcel1.readString());
        return true;
      case 4:
        paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
        fP();
        return true;
      case 5:
        paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
        aH(paramParcel1.readString());
        return true;
      case 6:
        paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
        fD();
        return true;
      case 7:
        paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
        double d2 = paramParcel1.readDouble();
        double d3 = paramParcel1.readDouble();
        if (paramParcel1.readInt() != 0);
        for (boolean bool3 = true; ; bool3 = false)
        {
          a(d2, d3, bool3);
          return true;
        }
      case 8:
        paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
        if (paramParcel1.readInt() != 0);
        for (boolean bool1 = true; ; bool1 = false)
        {
          double d1 = paramParcel1.readDouble();
          int i = paramParcel1.readInt();
          boolean bool2 = false;
          if (i != 0)
            bool2 = true;
          a(bool1, d1, bool2);
          return true;
        }
      case 9:
        paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
        a(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readLong());
        return true;
      case 10:
        paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
        a(paramParcel1.readString(), paramParcel1.createByteArray(), paramParcel1.readLong());
        return true;
      case 11:
        paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
        aI(paramParcel1.readString());
        return true;
      case 12:
        paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
        aJ(paramParcel1.readString());
        return true;
      case 13:
      }
      paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
      String str1 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0);
      for (LaunchOptions localLaunchOptions = (LaunchOptions)LaunchOptions.CREATOR.createFromParcel(paramParcel1); ; localLaunchOptions = null)
      {
        a(str1, localLaunchOptions);
        return true;
      }
    }

    private static class a
      implements in
    {
      private IBinder lb;

      a(IBinder paramIBinder)
      {
        this.lb = paramIBinder;
      }

      public void a(double paramDouble1, double paramDouble2, boolean paramBoolean)
        throws RemoteException
      {
        int i = 1;
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
          localParcel.writeDouble(paramDouble1);
          localParcel.writeDouble(paramDouble2);
          if (paramBoolean);
          while (true)
          {
            localParcel.writeInt(i);
            this.lb.transact(7, localParcel, null, 1);
            return;
            i = 0;
          }
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void a(String paramString, LaunchOptions paramLaunchOptions)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
          localParcel.writeString(paramString);
          if (paramLaunchOptions != null)
          {
            localParcel.writeInt(1);
            paramLaunchOptions.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            this.lb.transact(13, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void a(String paramString1, String paramString2, long paramLong)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
          localParcel.writeString(paramString1);
          localParcel.writeString(paramString2);
          localParcel.writeLong(paramLong);
          this.lb.transact(9, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void a(String paramString, byte[] paramArrayOfByte, long paramLong)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
          localParcel.writeString(paramString);
          localParcel.writeByteArray(paramArrayOfByte);
          localParcel.writeLong(paramLong);
          this.lb.transact(10, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void a(boolean paramBoolean1, double paramDouble, boolean paramBoolean2)
        throws RemoteException
      {
        int i = 1;
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
          int j;
          if (paramBoolean1)
          {
            j = i;
            localParcel.writeInt(j);
            localParcel.writeDouble(paramDouble);
            if (!paramBoolean2)
              break label76;
          }
          while (true)
          {
            localParcel.writeInt(i);
            this.lb.transact(8, localParcel, null, 1);
            return;
            j = 0;
            break;
            label76: i = 0;
          }
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void aH(String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
          localParcel.writeString(paramString);
          this.lb.transact(5, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void aI(String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
          localParcel.writeString(paramString);
          this.lb.transact(11, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void aJ(String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
          localParcel.writeString(paramString);
          this.lb.transact(12, localParcel, null, 1);
          return;
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

      public void disconnect()
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
          this.lb.transact(1, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void f(String paramString, boolean paramBoolean)
        throws RemoteException
      {
        int i = 1;
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
          localParcel.writeString(paramString);
          if (paramBoolean);
          while (true)
          {
            localParcel.writeInt(i);
            this.lb.transact(2, localParcel, null, 1);
            return;
            i = 0;
          }
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void fD()
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
          this.lb.transact(6, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void fP()
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
          this.lb.transact(4, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void l(String paramString1, String paramString2)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
          localParcel.writeString(paramString1);
          localParcel.writeString(paramString2);
          this.lb.transact(3, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.in
 * JD-Core Version:    0.6.2
 */