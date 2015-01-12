package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;

public abstract interface es extends IInterface
{
  public abstract void ar()
    throws RemoteException;

  public abstract void as()
    throws RemoteException;

  public abstract void c(d paramd)
    throws RemoteException;

  public abstract String cu()
    throws RemoteException;

  public abstract String cv()
    throws RemoteException;

  public static abstract class a extends Binder
    implements es
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
    }

    public static es z(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
      if ((localIInterface != null) && ((localIInterface instanceof es)))
        return (es)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
        String str2 = cu();
        paramParcel2.writeNoException();
        paramParcel2.writeString(str2);
        return true;
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
        String str1 = cv();
        paramParcel2.writeNoException();
        paramParcel2.writeString(str1);
        return true;
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
        c(d.a.am(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 4:
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
        ar();
        paramParcel2.writeNoException();
        return true;
      case 5:
      }
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
      as();
      paramParcel2.writeNoException();
      return true;
    }

    private static class a
      implements es
    {
      private IBinder lb;

      a(IBinder paramIBinder)
      {
        this.lb = paramIBinder;
      }

      public void ar()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
          this.lb.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void as()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
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

      public IBinder asBinder()
      {
        return this.lb;
      }

      public void c(d paramd)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
          if (paramd != null);
          for (IBinder localIBinder = paramd.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.lb.transact(3, localParcel1, localParcel2, 0);
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

      public String cu()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
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

      public String cv()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
          this.lb.transact(2, localParcel1, localParcel2, 0);
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
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.es
 * JD-Core Version:    0.6.2
 */