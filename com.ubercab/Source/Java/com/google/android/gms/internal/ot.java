package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.d;

public abstract interface ot extends IInterface
{
  public abstract void a(Bundle paramBundle, ow paramow)
    throws RemoteException;

  public abstract void a(on paramon, Bundle paramBundle, ow paramow)
    throws RemoteException;

  public abstract void a(FullWalletRequest paramFullWalletRequest, Bundle paramBundle, ow paramow)
    throws RemoteException;

  public abstract void a(MaskedWalletRequest paramMaskedWalletRequest, Bundle paramBundle, ov paramov)
    throws RemoteException;

  public abstract void a(MaskedWalletRequest paramMaskedWalletRequest, Bundle paramBundle, ow paramow)
    throws RemoteException;

  public abstract void a(NotifyTransactionStatusRequest paramNotifyTransactionStatusRequest, Bundle paramBundle)
    throws RemoteException;

  public abstract void a(d paramd, Bundle paramBundle, ow paramow)
    throws RemoteException;

  public abstract void a(String paramString1, String paramString2, Bundle paramBundle, ow paramow)
    throws RemoteException;

  public abstract void p(Bundle paramBundle)
    throws RemoteException;

  public static abstract class a extends Binder
    implements ot
  {
    public static ot bL(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IOwService");
      if ((localIInterface != null) && ((localIInterface instanceof ot)))
        return (ot)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.wallet.internal.IOwService");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
        MaskedWalletRequest localMaskedWalletRequest2;
        if (paramParcel1.readInt() != 0)
        {
          localMaskedWalletRequest2 = (MaskedWalletRequest)MaskedWalletRequest.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label181;
        }
        for (Bundle localBundle9 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle9 = null)
        {
          a(localMaskedWalletRequest2, localBundle9, ow.a.bO(paramParcel1.readStrongBinder()));
          return true;
          localMaskedWalletRequest2 = null;
          break;
        }
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
        FullWalletRequest localFullWalletRequest;
        if (paramParcel1.readInt() != 0)
        {
          localFullWalletRequest = (FullWalletRequest)FullWalletRequest.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label258;
        }
        for (Bundle localBundle8 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle8 = null)
        {
          a(localFullWalletRequest, localBundle8, ow.a.bO(paramParcel1.readStrongBinder()));
          return true;
          localFullWalletRequest = null;
          break;
        }
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
        String str1 = paramParcel1.readString();
        String str2 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0);
        for (Bundle localBundle7 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle7 = null)
        {
          a(str1, str2, localBundle7, ow.a.bO(paramParcel1.readStrongBinder()));
          return true;
        }
      case 4:
        paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
        NotifyTransactionStatusRequest localNotifyTransactionStatusRequest;
        if (paramParcel1.readInt() != 0)
        {
          localNotifyTransactionStatusRequest = (NotifyTransactionStatusRequest)NotifyTransactionStatusRequest.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label392;
        }
        for (Bundle localBundle6 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle6 = null)
        {
          a(localNotifyTransactionStatusRequest, localBundle6);
          return true;
          localNotifyTransactionStatusRequest = null;
          break;
        }
      case 5:
        paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
        if (paramParcel1.readInt() != 0);
        for (Bundle localBundle5 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle5 = null)
        {
          a(localBundle5, ow.a.bO(paramParcel1.readStrongBinder()));
          return true;
        }
      case 6:
        paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
        d locald;
        if (paramParcel1.readInt() != 0)
        {
          locald = (d)d.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label517;
        }
        for (Bundle localBundle4 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle4 = null)
        {
          a(locald, localBundle4, ow.a.bO(paramParcel1.readStrongBinder()));
          return true;
          locald = null;
          break;
        }
      case 7:
        paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
        MaskedWalletRequest localMaskedWalletRequest1;
        if (paramParcel1.readInt() != 0)
        {
          localMaskedWalletRequest1 = (MaskedWalletRequest)MaskedWalletRequest.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label594;
        }
        for (Bundle localBundle3 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle3 = null)
        {
          a(localMaskedWalletRequest1, localBundle3, ov.a.bN(paramParcel1.readStrongBinder()));
          return true;
          localMaskedWalletRequest1 = null;
          break;
        }
      case 8:
        label181: label594: paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
        label258: label392: on localon;
        label517: if (paramParcel1.readInt() != 0)
        {
          localon = (on)on.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label671;
        }
        label671: for (Bundle localBundle2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle2 = null)
        {
          a(localon, localBundle2, ow.a.bO(paramParcel1.readStrongBinder()));
          return true;
          localon = null;
          break;
        }
      case 9:
      }
      paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
      if (paramParcel1.readInt() != 0);
      for (Bundle localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle1 = null)
      {
        p(localBundle1);
        return true;
      }
    }

    private static class a
      implements ot
    {
      private IBinder lb;

      a(IBinder paramIBinder)
      {
        this.lb = paramIBinder;
      }

      public void a(Bundle paramBundle, ow paramow)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
          if (paramBundle != null)
          {
            localParcel.writeInt(1);
            paramBundle.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            IBinder localIBinder = null;
            if (paramow != null)
              localIBinder = paramow.asBinder();
            localParcel.writeStrongBinder(localIBinder);
            this.lb.transact(5, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void a(on paramon, Bundle paramBundle, ow paramow)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
            if (paramon != null)
            {
              localParcel.writeInt(1);
              paramon.writeToParcel(localParcel, 0);
              if (paramBundle != null)
              {
                localParcel.writeInt(1);
                paramBundle.writeToParcel(localParcel, 0);
                IBinder localIBinder = null;
                if (paramow != null)
                  localIBinder = paramow.asBinder();
                localParcel.writeStrongBinder(localIBinder);
                this.lb.transact(8, localParcel, null, 1);
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

      public void a(FullWalletRequest paramFullWalletRequest, Bundle paramBundle, ow paramow)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
            if (paramFullWalletRequest != null)
            {
              localParcel.writeInt(1);
              paramFullWalletRequest.writeToParcel(localParcel, 0);
              if (paramBundle != null)
              {
                localParcel.writeInt(1);
                paramBundle.writeToParcel(localParcel, 0);
                IBinder localIBinder = null;
                if (paramow != null)
                  localIBinder = paramow.asBinder();
                localParcel.writeStrongBinder(localIBinder);
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

      public void a(MaskedWalletRequest paramMaskedWalletRequest, Bundle paramBundle, ov paramov)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
            if (paramMaskedWalletRequest != null)
            {
              localParcel.writeInt(1);
              paramMaskedWalletRequest.writeToParcel(localParcel, 0);
              if (paramBundle != null)
              {
                localParcel.writeInt(1);
                paramBundle.writeToParcel(localParcel, 0);
                IBinder localIBinder = null;
                if (paramov != null)
                  localIBinder = paramov.asBinder();
                localParcel.writeStrongBinder(localIBinder);
                this.lb.transact(7, localParcel, null, 1);
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

      public void a(MaskedWalletRequest paramMaskedWalletRequest, Bundle paramBundle, ow paramow)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
            if (paramMaskedWalletRequest != null)
            {
              localParcel.writeInt(1);
              paramMaskedWalletRequest.writeToParcel(localParcel, 0);
              if (paramBundle != null)
              {
                localParcel.writeInt(1);
                paramBundle.writeToParcel(localParcel, 0);
                IBinder localIBinder = null;
                if (paramow != null)
                  localIBinder = paramow.asBinder();
                localParcel.writeStrongBinder(localIBinder);
                this.lb.transact(1, localParcel, null, 1);
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

      public void a(NotifyTransactionStatusRequest paramNotifyTransactionStatusRequest, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
            if (paramNotifyTransactionStatusRequest != null)
            {
              localParcel.writeInt(1);
              paramNotifyTransactionStatusRequest.writeToParcel(localParcel, 0);
              if (paramBundle != null)
              {
                localParcel.writeInt(1);
                paramBundle.writeToParcel(localParcel, 0);
                this.lb.transact(4, localParcel, null, 1);
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

      public void a(d paramd, Bundle paramBundle, ow paramow)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
            if (paramd != null)
            {
              localParcel.writeInt(1);
              paramd.writeToParcel(localParcel, 0);
              if (paramBundle != null)
              {
                localParcel.writeInt(1);
                paramBundle.writeToParcel(localParcel, 0);
                IBinder localIBinder = null;
                if (paramow != null)
                  localIBinder = paramow.asBinder();
                localParcel.writeStrongBinder(localIBinder);
                this.lb.transact(6, localParcel, null, 1);
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

      public void a(String paramString1, String paramString2, Bundle paramBundle, ow paramow)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
          localParcel.writeString(paramString1);
          localParcel.writeString(paramString2);
          if (paramBundle != null)
          {
            localParcel.writeInt(1);
            paramBundle.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            IBinder localIBinder = null;
            if (paramow != null)
              localIBinder = paramow.asBinder();
            localParcel.writeStrongBinder(localIBinder);
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

      public IBinder asBinder()
      {
        return this.lb;
      }

      public void p(Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
          if (paramBundle != null)
          {
            localParcel.writeInt(1);
            paramBundle.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            this.lb.transact(9, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
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
 * Qualified Name:     com.google.android.gms.internal.ot
 * JD-Core Version:    0.6.2
 */