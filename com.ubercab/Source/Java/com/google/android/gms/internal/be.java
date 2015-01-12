package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;

public abstract interface be extends IInterface
{
  public abstract IBinder a(d paramd, ay paramay, String paramString, ct paramct, int paramInt)
    throws RemoteException;

  public static abstract class a extends Binder
    implements be
  {
    public static be g(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
      if ((localIInterface != null) && ((localIInterface instanceof be)))
        return (be)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        return true;
      case 1:
      }
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
      d locald = d.a.am(paramParcel1.readStrongBinder());
      if (paramParcel1.readInt() != 0);
      for (ay localay = ay.CREATOR.c(paramParcel1); ; localay = null)
      {
        IBinder localIBinder = a(locald, localay, paramParcel1.readString(), ct.a.l(paramParcel1.readStrongBinder()), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeStrongBinder(localIBinder);
        return true;
      }
    }

    private static class a
      implements be
    {
      private IBinder lb;

      a(IBinder paramIBinder)
      {
        this.lb = paramIBinder;
      }

      public IBinder a(d paramd, ay paramay, String paramString, ct paramct, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManagerCreator");
          IBinder localIBinder1;
          if (paramd != null)
          {
            localIBinder1 = paramd.asBinder();
            localParcel1.writeStrongBinder(localIBinder1);
            if (paramay == null)
              break label137;
            localParcel1.writeInt(1);
            paramay.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            localParcel1.writeString(paramString);
            IBinder localIBinder2 = null;
            if (paramct != null)
              localIBinder2 = paramct.asBinder();
            localParcel1.writeStrongBinder(localIBinder2);
            localParcel1.writeInt(paramInt);
            this.lb.transact(1, localParcel1, localParcel2, 0);
            localParcel2.readException();
            IBinder localIBinder3 = localParcel2.readStrongBinder();
            return localIBinder3;
            localIBinder1 = null;
            break;
            label137: localParcel1.writeInt(0);
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
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.be
 * JD-Core Version:    0.6.2
 */