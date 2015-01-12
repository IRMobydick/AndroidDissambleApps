package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface hv extends IInterface
{
  public abstract void a(hm.a parama, hw paramhw)
    throws RemoteException;

  public abstract void a(hw paramhw)
    throws RemoteException;

  public abstract void a(hw paramhw, String paramString, hs[] paramArrayOfhs)
    throws RemoteException;

  public abstract void a(hw paramhw, boolean paramBoolean)
    throws RemoteException;

  public abstract void b(hw paramhw)
    throws RemoteException;

  public static abstract class a extends Binder
    implements hv
  {
    public static hv F(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
      if ((localIInterface != null) && ((localIInterface instanceof hv)))
        return (hv)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
        a(hw.a.G(paramParcel1.readStrongBinder()), paramParcel1.readString(), (hs[])paramParcel1.createTypedArray(hs.CREATOR));
        paramParcel2.writeNoException();
        return true;
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
        a(hw.a.G(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
        b(hw.a.G(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 4:
        paramParcel1.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
        hw localhw = hw.a.G(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0);
        for (boolean bool = true; ; bool = false)
        {
          a(localhw, bool);
          paramParcel2.writeNoException();
          return true;
        }
      case 5:
      }
      paramParcel1.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
      if (paramParcel1.readInt() != 0);
      for (hm.a locala = hm.a.CREATOR.p(paramParcel1); ; locala = null)
      {
        a(locala, hw.a.G(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      }
    }

    private static class a
      implements hv
    {
      private IBinder lb;

      a(IBinder paramIBinder)
      {
        this.lb = paramIBinder;
      }

      public void a(hm.a parama, hw paramhw)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            if (parama != null)
            {
              localParcel1.writeInt(1);
              parama.writeToParcel(localParcel1, 0);
              if (paramhw != null)
              {
                localIBinder = paramhw.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.lb.transact(5, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          IBinder localIBinder = null;
        }
      }

      public void a(hw paramhw)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
          if (paramhw != null);
          for (IBinder localIBinder = paramhw.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.lb.transact(2, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void a(hw paramhw, String paramString, hs[] paramArrayOfhs)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
          if (paramhw != null);
          for (IBinder localIBinder = paramhw.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            localParcel1.writeString(paramString);
            localParcel1.writeTypedArray(paramArrayOfhs, 0);
            this.lb.transact(1, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void a(hw paramhw, boolean paramBoolean)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
          if (paramhw != null);
          for (IBinder localIBinder = paramhw.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            int i = 0;
            if (paramBoolean)
              i = 1;
            localParcel1.writeInt(i);
            this.lb.transact(4, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
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

      public void b(hw paramhw)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
          if (paramhw != null);
          for (IBinder localIBinder = paramhw.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.lb.transact(3, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
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
 * Qualified Name:     com.google.android.gms.internal.hv
 * JD-Core Version:    0.6.2
 */