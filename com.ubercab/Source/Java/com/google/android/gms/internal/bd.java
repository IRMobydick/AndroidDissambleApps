package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;

public abstract interface bd extends IInterface
{
  public abstract d X()
    throws RemoteException;

  public abstract ay Y()
    throws RemoteException;

  public abstract void a(ay paramay)
    throws RemoteException;

  public abstract void a(bc parambc)
    throws RemoteException;

  public abstract void a(bf parambf)
    throws RemoteException;

  public abstract void a(eh parameh)
    throws RemoteException;

  public abstract void a(el paramel, String paramString)
    throws RemoteException;

  public abstract void a(et paramet)
    throws RemoteException;

  public abstract void a(eu parameu)
    throws RemoteException;

  public abstract boolean a(av paramav)
    throws RemoteException;

  public abstract void aj()
    throws RemoteException;

  public abstract void destroy()
    throws RemoteException;

  public abstract String getMediationAdapterClassName()
    throws RemoteException;

  public abstract boolean isReady()
    throws RemoteException;

  public abstract void pause()
    throws RemoteException;

  public abstract void resume()
    throws RemoteException;

  public abstract void showInterstitial()
    throws RemoteException;

  public abstract void stopLoading()
    throws RemoteException;

  public static abstract class a extends Binder
    implements bd
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.ads.internal.client.IAdManager");
    }

    public static bd f(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
      if ((localIInterface != null) && ((localIInterface instanceof bd)))
        return (bd)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.ads.internal.client.IAdManager");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
        d locald = X();
        paramParcel2.writeNoException();
        IBinder localIBinder = null;
        if (locald != null)
          localIBinder = locald.asBinder();
        paramParcel2.writeStrongBinder(localIBinder);
        return true;
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
        destroy();
        paramParcel2.writeNoException();
        return true;
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
        boolean bool2 = isReady();
        paramParcel2.writeNoException();
        if (bool2);
        for (int m = 1; ; m = 0)
        {
          paramParcel2.writeInt(m);
          return true;
        }
      case 4:
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
        int j = paramParcel1.readInt();
        av localav = null;
        if (j != 0)
          localav = av.CREATOR.b(paramParcel1);
        boolean bool1 = a(localav);
        paramParcel2.writeNoException();
        int k = 0;
        if (bool1)
          k = 1;
        paramParcel2.writeInt(k);
        return true;
      case 5:
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
        pause();
        paramParcel2.writeNoException();
        return true;
      case 6:
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
        resume();
        paramParcel2.writeNoException();
        return true;
      case 7:
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
        a(bc.a.e(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 8:
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
        a(bf.a.h(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 9:
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
        showInterstitial();
        paramParcel2.writeNoException();
        return true;
      case 10:
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
        stopLoading();
        paramParcel2.writeNoException();
        return true;
      case 11:
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
        aj();
        paramParcel2.writeNoException();
        return true;
      case 12:
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
        ay localay2 = Y();
        paramParcel2.writeNoException();
        if (localay2 != null)
        {
          paramParcel2.writeInt(1);
          localay2.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 13:
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
        int i = paramParcel1.readInt();
        ay localay1 = null;
        if (i != 0)
          localay1 = ay.CREATOR.c(paramParcel1);
        a(localay1);
        paramParcel2.writeNoException();
        return true;
      case 14:
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
        a(eh.a.t(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 15:
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
        a(el.a.x(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 16:
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
        a(et.a.A(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 17:
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
        a(eu.a.B(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 18:
      }
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
      String str = getMediationAdapterClassName();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str);
      return true;
    }

    private static class a
      implements bd
    {
      private IBinder lb;

      a(IBinder paramIBinder)
      {
        this.lb = paramIBinder;
      }

      public d X()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
          this.lb.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          d locald = d.a.am(localParcel2.readStrongBinder());
          return locald;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public ay Y()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
          this.lb.transact(12, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            ay localay2 = ay.CREATOR.c(localParcel2);
            localay1 = localay2;
            return localay1;
          }
          ay localay1 = null;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void a(ay paramay)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
          if (paramay != null)
          {
            localParcel1.writeInt(1);
            paramay.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.lb.transact(13, localParcel1, localParcel2, 0);
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

      public void a(bc parambc)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
          if (parambc != null);
          for (IBinder localIBinder = parambc.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.lb.transact(7, localParcel1, localParcel2, 0);
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

      public void a(bf parambf)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
          if (parambf != null);
          for (IBinder localIBinder = parambf.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.lb.transact(8, localParcel1, localParcel2, 0);
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

      public void a(eh parameh)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
          if (parameh != null);
          for (IBinder localIBinder = parameh.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.lb.transact(14, localParcel1, localParcel2, 0);
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

      public void a(el paramel, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
          if (paramel != null);
          for (IBinder localIBinder = paramel.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            localParcel1.writeString(paramString);
            this.lb.transact(15, localParcel1, localParcel2, 0);
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

      public void a(et paramet)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
          if (paramet != null);
          for (IBinder localIBinder = paramet.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.lb.transact(16, localParcel1, localParcel2, 0);
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

      public void a(eu parameu)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
          if (parameu != null);
          for (IBinder localIBinder = parameu.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.lb.transact(17, localParcel1, localParcel2, 0);
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

      public boolean a(av paramav)
        throws RemoteException
      {
        boolean bool = true;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            if (paramav != null)
            {
              localParcel1.writeInt(1);
              paramav.writeToParcel(localParcel1, 0);
              this.lb.transact(4, localParcel1, localParcel2, 0);
              localParcel2.readException();
              int i = localParcel2.readInt();
              if (i != 0)
                return bool;
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
          bool = false;
        }
      }

      public void aj()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
          this.lb.transact(11, localParcel1, localParcel2, 0);
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

      public void destroy()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
          this.lb.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public String getMediationAdapterClassName()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
          this.lb.transact(18, localParcel1, localParcel2, 0);
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

      public boolean isReady()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
          this.lb.transact(3, localParcel1, localParcel2, 0);
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

      public void pause()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
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

      public void resume()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
          this.lb.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void showInterstitial()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
          this.lb.transact(9, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void stopLoading()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
          this.lb.transact(10, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
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
 * Qualified Name:     com.google.android.gms.internal.bd
 * JD-Core Version:    0.6.2
 */