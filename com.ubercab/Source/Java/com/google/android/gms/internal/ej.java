package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;

public abstract interface ej extends IInterface
{
  public abstract IBinder b(d paramd)
    throws RemoteException;

  public static abstract class a extends Binder
    implements ej
  {
    public static ej v(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
      if ((localIInterface != null) && ((localIInterface instanceof ej)))
        return (ej)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
        return true;
      case 1:
      }
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
      IBinder localIBinder = b(d.a.am(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramParcel2.writeStrongBinder(localIBinder);
      return true;
    }

    private static class a
      implements ej
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

      public IBinder b(d paramd)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
          if (paramd != null);
          for (IBinder localIBinder1 = paramd.asBinder(); ; localIBinder1 = null)
          {
            localParcel1.writeStrongBinder(localIBinder1);
            this.lb.transact(1, localParcel1, localParcel2, 0);
            localParcel2.readException();
            IBinder localIBinder2 = localParcel2.readStrongBinder();
            return localIBinder2;
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
 * Qualified Name:     com.google.android.gms.internal.ej
 * JD-Core Version:    0.6.2
 */