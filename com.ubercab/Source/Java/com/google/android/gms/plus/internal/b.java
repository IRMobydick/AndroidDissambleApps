package com.google.android.gms.plus.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.StatusCreator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.f;
import com.google.android.gms.internal.jp;
import com.google.android.gms.internal.jq;
import com.google.android.gms.internal.nz;
import com.google.android.gms.internal.oa;

public abstract interface b extends IInterface
{
  public abstract void a(int paramInt, Bundle paramBundle1, Bundle paramBundle2)
    throws RemoteException;

  public abstract void a(int paramInt, Bundle paramBundle, ParcelFileDescriptor paramParcelFileDescriptor)
    throws RemoteException;

  public abstract void a(int paramInt, Bundle paramBundle, jp paramjp)
    throws RemoteException;

  public abstract void a(int paramInt, nz paramnz)
    throws RemoteException;

  public abstract void a(DataHolder paramDataHolder, String paramString)
    throws RemoteException;

  public abstract void a(DataHolder paramDataHolder, String paramString1, String paramString2)
    throws RemoteException;

  public abstract void aB(Status paramStatus)
    throws RemoteException;

  public abstract void ce(String paramString)
    throws RemoteException;

  public abstract void cf(String paramString)
    throws RemoteException;

  public abstract void h(int paramInt, Bundle paramBundle)
    throws RemoteException;

  public static abstract class a extends Binder
    implements b
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.plus.internal.IPlusCallbacks");
    }

    public static b bE(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
      if ((localIInterface != null) && ((localIInterface instanceof b)))
        return (b)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.plus.internal.IPlusCallbacks");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
        int i5 = paramParcel1.readInt();
        Bundle localBundle4;
        if (paramParcel1.readInt() != 0)
        {
          localBundle4 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label194;
        }
        for (Bundle localBundle5 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle5 = null)
        {
          a(i5, localBundle4, localBundle5);
          paramParcel2.writeNoException();
          return true;
          localBundle4 = null;
          break;
        }
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
        int i4 = paramParcel1.readInt();
        Bundle localBundle3;
        if (paramParcel1.readInt() != 0)
        {
          localBundle3 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label276;
        }
        for (ParcelFileDescriptor localParcelFileDescriptor = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(paramParcel1); ; localParcelFileDescriptor = null)
        {
          a(i4, localBundle3, localParcelFileDescriptor);
          paramParcel2.writeNoException();
          return true;
          localBundle3 = null;
          break;
        }
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
        ce(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 4:
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
        int i3 = paramParcel1.readInt();
        DataHolder localDataHolder2 = null;
        if (i3 != 0)
          localDataHolder2 = DataHolder.CREATOR.z(paramParcel1);
        a(localDataHolder2, paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 5:
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
        int i1 = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0);
        for (Bundle localBundle2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle2 = null)
        {
          int i2 = paramParcel1.readInt();
          jp localjp = null;
          if (i2 != 0)
            localjp = jp.CREATOR.M(paramParcel1);
          a(i1, localBundle2, localjp);
          paramParcel2.writeNoException();
          return true;
        }
      case 6:
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
        int n = paramParcel1.readInt();
        DataHolder localDataHolder1 = null;
        if (n != 0)
          localDataHolder1 = DataHolder.CREATOR.z(paramParcel1);
        a(localDataHolder1, paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 7:
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
        int m = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0);
        for (Bundle localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle1 = null)
        {
          h(m, localBundle1);
          paramParcel2.writeNoException();
          return true;
        }
      case 8:
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
        cf(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 9:
        label194: paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
        label276: int j = paramParcel1.readInt();
        int k = paramParcel1.readInt();
        nz localnz = null;
        if (k != 0)
          localnz = nz.CREATOR.dd(paramParcel1);
        a(j, localnz);
        paramParcel2.writeNoException();
        return true;
      case 10:
      }
      paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
      int i = paramParcel1.readInt();
      Status localStatus = null;
      if (i != 0)
        localStatus = Status.CREATOR.createFromParcel(paramParcel1);
      aB(localStatus);
      paramParcel2.writeNoException();
      return true;
    }

    private static class a
      implements b
    {
      private IBinder lb;

      a(IBinder paramIBinder)
      {
        this.lb = paramIBinder;
      }

      public void a(int paramInt, Bundle paramBundle1, Bundle paramBundle2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
            localParcel1.writeInt(paramInt);
            if (paramBundle1 != null)
            {
              localParcel1.writeInt(1);
              paramBundle1.writeToParcel(localParcel1, 0);
              if (paramBundle2 != null)
              {
                localParcel1.writeInt(1);
                paramBundle2.writeToParcel(localParcel1, 0);
                this.lb.transact(1, localParcel1, localParcel2, 0);
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
          localParcel1.writeInt(0);
        }
      }

      public void a(int paramInt, Bundle paramBundle, ParcelFileDescriptor paramParcelFileDescriptor)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
            localParcel1.writeInt(paramInt);
            if (paramBundle != null)
            {
              localParcel1.writeInt(1);
              paramBundle.writeToParcel(localParcel1, 0);
              if (paramParcelFileDescriptor != null)
              {
                localParcel1.writeInt(1);
                paramParcelFileDescriptor.writeToParcel(localParcel1, 0);
                this.lb.transact(2, localParcel1, localParcel2, 0);
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
          localParcel1.writeInt(0);
        }
      }

      public void a(int paramInt, Bundle paramBundle, jp paramjp)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
            localParcel1.writeInt(paramInt);
            if (paramBundle != null)
            {
              localParcel1.writeInt(1);
              paramBundle.writeToParcel(localParcel1, 0);
              if (paramjp != null)
              {
                localParcel1.writeInt(1);
                paramjp.writeToParcel(localParcel1, 0);
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
          localParcel1.writeInt(0);
        }
      }

      public void a(int paramInt, nz paramnz)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
          localParcel1.writeInt(paramInt);
          if (paramnz != null)
          {
            localParcel1.writeInt(1);
            paramnz.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.lb.transact(9, localParcel1, localParcel2, 0);
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

      public void a(DataHolder paramDataHolder, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
          if (paramDataHolder != null)
          {
            localParcel1.writeInt(1);
            paramDataHolder.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            localParcel1.writeString(paramString);
            this.lb.transact(4, localParcel1, localParcel2, 0);
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

      public void a(DataHolder paramDataHolder, String paramString1, String paramString2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
          if (paramDataHolder != null)
          {
            localParcel1.writeInt(1);
            paramDataHolder.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            this.lb.transact(6, localParcel1, localParcel2, 0);
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

      public void aB(Status paramStatus)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
          if (paramStatus != null)
          {
            localParcel1.writeInt(1);
            paramStatus.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.lb.transact(10, localParcel1, localParcel2, 0);
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

      public void ce(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
          localParcel1.writeString(paramString);
          this.lb.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void cf(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
          localParcel1.writeString(paramString);
          this.lb.transact(8, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void h(int paramInt, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
          localParcel1.writeInt(paramInt);
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.lb.transact(7, localParcel1, localParcel2, 0);
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
 * Qualified Name:     com.google.android.gms.plus.internal.b
 * JD-Core Version:    0.6.2
 */