package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.StatusCreator;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.MaskedWallet;

public abstract interface ow extends IInterface
{
  public abstract void a(int paramInt, FullWallet paramFullWallet, Bundle paramBundle)
    throws RemoteException;

  public abstract void a(int paramInt, MaskedWallet paramMaskedWallet, Bundle paramBundle)
    throws RemoteException;

  public abstract void a(int paramInt, boolean paramBoolean, Bundle paramBundle)
    throws RemoteException;

  public abstract void a(Status paramStatus, op paramop, Bundle paramBundle)
    throws RemoteException;

  public abstract void i(int paramInt, Bundle paramBundle)
    throws RemoteException;

  public static abstract class a extends Binder
    implements ow
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
    }

    public static ow bO(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
      if ((localIInterface != null) && ((localIInterface instanceof ow)))
        return (ow)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
        int m = paramParcel1.readInt();
        MaskedWallet localMaskedWallet;
        if (paramParcel1.readInt() != 0)
        {
          localMaskedWallet = (MaskedWallet)MaskedWallet.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label154;
        }
        for (Bundle localBundle5 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle5 = null)
        {
          a(m, localMaskedWallet, localBundle5);
          paramParcel2.writeNoException();
          return true;
          localMaskedWallet = null;
          break;
        }
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
        int k = paramParcel1.readInt();
        FullWallet localFullWallet;
        if (paramParcel1.readInt() != 0)
        {
          localFullWallet = (FullWallet)FullWallet.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label236;
        }
        for (Bundle localBundle4 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle4 = null)
        {
          a(k, localFullWallet, localBundle4);
          paramParcel2.writeNoException();
          return true;
          localFullWallet = null;
          break;
        }
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
        int j = paramParcel1.readInt();
        boolean bool;
        if (paramParcel1.readInt() != 0)
        {
          bool = true;
          if (paramParcel1.readInt() == 0)
            break label307;
        }
        for (Bundle localBundle3 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle3 = null)
        {
          a(j, bool, localBundle3);
          paramParcel2.writeNoException();
          return true;
          bool = false;
          break;
        }
      case 4:
        label154: label236: paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
        label307: int i = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0);
        for (Bundle localBundle2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle2 = null)
        {
          i(i, localBundle2);
          paramParcel2.writeNoException();
          return true;
        }
      case 5:
      }
      paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
      Status localStatus;
      op localop;
      if (paramParcel1.readInt() != 0)
      {
        localStatus = Status.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0)
          break label452;
        localop = (op)op.CREATOR.createFromParcel(paramParcel1);
        label409: if (paramParcel1.readInt() == 0)
          break label458;
      }
      label452: label458: for (Bundle localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle1 = null)
      {
        a(localStatus, localop, localBundle1);
        paramParcel2.writeNoException();
        return true;
        localStatus = null;
        break;
        localop = null;
        break label409;
      }
    }

    private static class a
      implements ow
    {
      private IBinder lb;

      a(IBinder paramIBinder)
      {
        this.lb = paramIBinder;
      }

      public void a(int paramInt, FullWallet paramFullWallet, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
            localParcel1.writeInt(paramInt);
            if (paramFullWallet != null)
            {
              localParcel1.writeInt(1);
              paramFullWallet.writeToParcel(localParcel1, 0);
              if (paramBundle != null)
              {
                localParcel1.writeInt(1);
                paramBundle.writeToParcel(localParcel1, 0);
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

      public void a(int paramInt, MaskedWallet paramMaskedWallet, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
            localParcel1.writeInt(paramInt);
            if (paramMaskedWallet != null)
            {
              localParcel1.writeInt(1);
              paramMaskedWallet.writeToParcel(localParcel1, 0);
              if (paramBundle != null)
              {
                localParcel1.writeInt(1);
                paramBundle.writeToParcel(localParcel1, 0);
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

      public void a(int paramInt, boolean paramBoolean, Bundle paramBundle)
        throws RemoteException
      {
        int i = 1;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
          localParcel1.writeInt(paramInt);
          if (paramBoolean)
          {
            localParcel1.writeInt(i);
            if (paramBundle == null)
              break label92;
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.lb.transact(3, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            i = 0;
            break;
            label92: localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void a(Status paramStatus, op paramop, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
            if (paramStatus != null)
            {
              localParcel1.writeInt(1);
              paramStatus.writeToParcel(localParcel1, 0);
              if (paramop != null)
              {
                localParcel1.writeInt(1);
                paramop.writeToParcel(localParcel1, 0);
                if (paramBundle == null)
                  break label133;
                localParcel1.writeInt(1);
                paramBundle.writeToParcel(localParcel1, 0);
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
          continue;
          label133: localParcel1.writeInt(0);
        }
      }

      public IBinder asBinder()
      {
        return this.lb;
      }

      public void i(int paramInt, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
          localParcel1.writeInt(paramInt);
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
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
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ow
 * JD-Core Version:    0.6.2
 */