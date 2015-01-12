package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface ek extends IInterface
{
  public abstract void finishPurchase()
    throws RemoteException;

  public abstract String getProductId()
    throws RemoteException;

  public abstract Intent getPurchaseData()
    throws RemoteException;

  public abstract int getResultCode()
    throws RemoteException;

  public abstract boolean isVerified()
    throws RemoteException;

  public static abstract class a extends Binder
    implements ek
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
    }

    public static ek w(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
      if ((localIInterface != null) && ((localIInterface instanceof ek)))
        return (ek)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
        String str = getProductId();
        paramParcel2.writeNoException();
        paramParcel2.writeString(str);
        return true;
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
        Intent localIntent = getPurchaseData();
        paramParcel2.writeNoException();
        if (localIntent != null)
        {
          paramParcel2.writeInt(1);
          localIntent.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
        int j = getResultCode();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(j);
        return true;
      case 4:
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
        boolean bool = isVerified();
        paramParcel2.writeNoException();
        int i = 0;
        if (bool)
          i = 1;
        paramParcel2.writeInt(i);
        return true;
      case 5:
      }
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
      finishPurchase();
      paramParcel2.writeNoException();
      return true;
    }

    private static class a
      implements ek
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

      public void finishPurchase()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
          this.lb.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public String getProductId()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
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

      public Intent getPurchaseData()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
          this.lb.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            localIntent = (Intent)Intent.CREATOR.createFromParcel(localParcel2);
            return localIntent;
          }
          Intent localIntent = null;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public int getResultCode()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
          this.lb.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public boolean isVerified()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
          this.lb.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          boolean bool = false;
          if (i != 0)
            bool = true;
          return bool;
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
 * Qualified Name:     com.google.android.gms.internal.ek
 * JD-Core Version:    0.6.2
 */