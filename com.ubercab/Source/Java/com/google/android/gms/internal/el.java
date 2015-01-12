package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface el extends IInterface
{
  public abstract void a(ek paramek)
    throws RemoteException;

  public abstract boolean isValidPurchase(String paramString)
    throws RemoteException;

  public static abstract class a extends Binder
    implements el
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
    }

    public static el x(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
      if ((localIInterface != null) && ((localIInterface instanceof el)))
        return (el)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
        boolean bool = isValidPurchase(paramParcel1.readString());
        paramParcel2.writeNoException();
        if (bool);
        for (int i = 1; ; i = 0)
        {
          paramParcel2.writeInt(i);
          return true;
        }
      case 2:
      }
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
      a(ek.a.w(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }

    private static class a
      implements el
    {
      private IBinder lb;

      a(IBinder paramIBinder)
      {
        this.lb = paramIBinder;
      }

      public void a(ek paramek)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
          if (paramek != null);
          for (IBinder localIBinder = paramek.asBinder(); ; localIBinder = null)
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

      public IBinder asBinder()
      {
        return this.lb;
      }

      public boolean isValidPurchase(String paramString)
        throws RemoteException
      {
        boolean bool = true;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
          localParcel1.writeString(paramString);
          this.lb.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0)
            return bool;
          bool = false;
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
 * Qualified Name:     com.google.android.gms.internal.el
 * JD-Core Version:    0.6.2
 */