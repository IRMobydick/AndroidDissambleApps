package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public abstract interface nh extends IInterface
{
  public abstract void a(String paramString, nm paramnm, ni paramni)
    throws RemoteException;

  public abstract void a(String paramString, nm paramnm, List<ni> paramList)
    throws RemoteException;

  public abstract void a(String paramString, nm paramnm, byte[] paramArrayOfByte)
    throws RemoteException;

  public static abstract class a extends Binder
    implements nh
  {
    public static nh bC(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.playlog.internal.IPlayLogService");
      if ((localIInterface != null) && ((localIInterface instanceof nh)))
        return (nh)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.playlog.internal.IPlayLogService");
        return true;
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.playlog.internal.IPlayLogService");
        String str3 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0);
        for (nm localnm3 = nm.CREATOR.cY(paramParcel1); ; localnm3 = null)
        {
          int k = paramParcel1.readInt();
          ni localni = null;
          if (k != 0)
            localni = ni.CREATOR.cX(paramParcel1);
          a(str3, localnm3, localni);
          return true;
        }
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.playlog.internal.IPlayLogService");
        String str2 = paramParcel1.readString();
        int j = paramParcel1.readInt();
        nm localnm2 = null;
        if (j != 0)
          localnm2 = nm.CREATOR.cY(paramParcel1);
        a(str2, localnm2, paramParcel1.createTypedArrayList(ni.CREATOR));
        return true;
      case 4:
      }
      paramParcel1.enforceInterface("com.google.android.gms.playlog.internal.IPlayLogService");
      String str1 = paramParcel1.readString();
      int i = paramParcel1.readInt();
      nm localnm1 = null;
      if (i != 0)
        localnm1 = nm.CREATOR.cY(paramParcel1);
      a(str1, localnm1, paramParcel1.createByteArray());
      return true;
    }

    private static class a
      implements nh
    {
      private IBinder lb;

      a(IBinder paramIBinder)
      {
        this.lb = paramIBinder;
      }

      public void a(String paramString, nm paramnm, ni paramni)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
            localParcel.writeString(paramString);
            if (paramnm != null)
            {
              localParcel.writeInt(1);
              paramnm.writeToParcel(localParcel, 0);
              if (paramni != null)
              {
                localParcel.writeInt(1);
                paramni.writeToParcel(localParcel, 0);
                this.lb.transact(2, localParcel, null, 1);
              }
            }
            else
            {
              localParcel.writeInt(0);
              continue;
            }
          }
          finally
          {
            localParcel.recycle();
          }
          localParcel.writeInt(0);
        }
      }

      public void a(String paramString, nm paramnm, List<ni> paramList)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
          localParcel.writeString(paramString);
          if (paramnm != null)
          {
            localParcel.writeInt(1);
            paramnm.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            localParcel.writeTypedList(paramList);
            this.lb.transact(3, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void a(String paramString, nm paramnm, byte[] paramArrayOfByte)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
          localParcel.writeString(paramString);
          if (paramnm != null)
          {
            localParcel.writeInt(1);
            paramnm.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            localParcel.writeByteArray(paramArrayOfByte);
            this.lb.transact(4, localParcel, null, 1);
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
 * Qualified Name:     com.google.android.gms.internal.nh
 * JD-Core Version:    0.6.2
 */