package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface ov extends IInterface
{
  public abstract void b(int paramInt1, int paramInt2, Bundle paramBundle)
    throws RemoteException;

  public static abstract class a extends Binder
    implements ov
  {
    public static ov bN(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IWalletInternalServiceCallbacks");
      if ((localIInterface != null) && ((localIInterface instanceof ov)))
        return (ov)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.wallet.internal.IWalletInternalServiceCallbacks");
        return true;
      case 1:
      }
      paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IWalletInternalServiceCallbacks");
      int i = paramParcel1.readInt();
      int j = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0);
      for (Bundle localBundle = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle = null)
      {
        b(i, j, localBundle);
        paramParcel2.writeNoException();
        return true;
      }
    }

    private static class a
      implements ov
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

      public void b(int paramInt1, int paramInt2, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletInternalServiceCallbacks");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
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
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ov
 * JD-Core Version:    0.6.2
 */