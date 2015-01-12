package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface fm extends IInterface
{
  public abstract fk b(fi paramfi)
    throws RemoteException;

  public static abstract class a extends Binder
    implements fm
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    public static fm D(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
      if ((localIInterface != null) && ((localIInterface instanceof fm)))
        return (fm)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.ads.internal.request.IAdRequestService");
        return true;
      case 1:
      }
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
      fi localfi;
      if (paramParcel1.readInt() != 0)
      {
        localfi = fi.CREATOR.h(paramParcel1);
        fk localfk = b(localfi);
        paramParcel2.writeNoException();
        if (localfk == null)
          break label105;
        paramParcel2.writeInt(1);
        localfk.writeToParcel(paramParcel2, 1);
      }
      while (true)
      {
        return true;
        localfi = null;
        break;
        label105: paramParcel2.writeInt(0);
      }
    }

    private static class a
      implements fm
    {
      private IBinder lb;

      a(IBinder paramIBinder)
      {
        this.lb = paramIBinder;
      }

      public IBinder asBinder()
      {
        return this.lb;
      }

      public fk b(fi paramfi)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
            if (paramfi != null)
            {
              localParcel1.writeInt(1);
              paramfi.writeToParcel(localParcel1, 0);
              this.lb.transact(1, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                fk localfk2 = fk.CREATOR.i(localParcel2);
                localfk1 = localfk2;
                return localfk1;
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
          fk localfk1 = null;
        }
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fm
 * JD-Core Version:    0.6.2
 */