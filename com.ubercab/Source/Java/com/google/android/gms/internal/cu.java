package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;

public abstract interface cu extends IInterface
{
  public abstract void a(d paramd, av paramav, String paramString, cv paramcv)
    throws RemoteException;

  public abstract void a(d paramd, av paramav, String paramString1, String paramString2, cv paramcv)
    throws RemoteException;

  public abstract void a(d paramd, ay paramay, av paramav, String paramString, cv paramcv)
    throws RemoteException;

  public abstract void a(d paramd, ay paramay, av paramav, String paramString1, String paramString2, cv paramcv)
    throws RemoteException;

  public abstract void destroy()
    throws RemoteException;

  public abstract d getView()
    throws RemoteException;

  public abstract void pause()
    throws RemoteException;

  public abstract void resume()
    throws RemoteException;

  public abstract void showInterstitial()
    throws RemoteException;

  public static abstract class a extends Binder
    implements cu
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    public static cu m(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      if ((localIInterface != null) && ((localIInterface instanceof cu)))
        return (cu)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        d locald5 = d.a.am(paramParcel1.readStrongBinder());
        ay localay2;
        if (paramParcel1.readInt() != 0)
        {
          localay2 = ay.CREATOR.c(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label190;
        }
        for (av localav4 = av.CREATOR.b(paramParcel1); ; localav4 = null)
        {
          a(locald5, localay2, localav4, paramParcel1.readString(), cv.a.n(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          return true;
          localay2 = null;
          break;
        }
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        d locald4 = getView();
        paramParcel2.writeNoException();
        IBinder localIBinder = null;
        if (locald4 != null)
          localIBinder = locald4.asBinder();
        paramParcel2.writeStrongBinder(localIBinder);
        return true;
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        d locald3 = d.a.am(paramParcel1.readStrongBinder());
        int i = paramParcel1.readInt();
        av localav3 = null;
        if (i != 0)
          localav3 = av.CREATOR.b(paramParcel1);
        a(locald3, localav3, paramParcel1.readString(), cv.a.n(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 4:
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        showInterstitial();
        paramParcel2.writeNoException();
        return true;
      case 5:
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        destroy();
        paramParcel2.writeNoException();
        return true;
      case 6:
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        d locald2 = d.a.am(paramParcel1.readStrongBinder());
        ay localay1;
        if (paramParcel1.readInt() != 0)
        {
          localay1 = ay.CREATOR.c(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label416;
        }
        for (av localav2 = av.CREATOR.b(paramParcel1); ; localav2 = null)
        {
          a(locald2, localay1, localav2, paramParcel1.readString(), paramParcel1.readString(), cv.a.n(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          return true;
          localay1 = null;
          break;
        }
      case 7:
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        d locald1 = d.a.am(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0);
        for (av localav1 = av.CREATOR.b(paramParcel1); ; localav1 = null)
        {
          a(locald1, localav1, paramParcel1.readString(), paramParcel1.readString(), cv.a.n(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          return true;
        }
      case 8:
        label190: paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        label416: pause();
        paramParcel2.writeNoException();
        return true;
      case 9:
      }
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      resume();
      paramParcel2.writeNoException();
      return true;
    }

    private static class a
      implements cu
    {
      private IBinder lb;

      a(IBinder paramIBinder)
      {
        this.lb = paramIBinder;
      }

      public void a(d paramd, av paramav, String paramString, cv paramcv)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
          IBinder localIBinder1;
          if (paramd != null)
          {
            localIBinder1 = paramd.asBinder();
            localParcel1.writeStrongBinder(localIBinder1);
            if (paramav == null)
              break label121;
            localParcel1.writeInt(1);
            paramav.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            localParcel1.writeString(paramString);
            IBinder localIBinder2 = null;
            if (paramcv != null)
              localIBinder2 = paramcv.asBinder();
            localParcel1.writeStrongBinder(localIBinder2);
            this.lb.transact(3, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            localIBinder1 = null;
            break;
            label121: localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void a(d paramd, av paramav, String paramString1, String paramString2, cv paramcv)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
          IBinder localIBinder1;
          if (paramd != null)
          {
            localIBinder1 = paramd.asBinder();
            localParcel1.writeStrongBinder(localIBinder1);
            if (paramav == null)
              break label129;
            localParcel1.writeInt(1);
            paramav.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            IBinder localIBinder2 = null;
            if (paramcv != null)
              localIBinder2 = paramcv.asBinder();
            localParcel1.writeStrongBinder(localIBinder2);
            this.lb.transact(7, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            localIBinder1 = null;
            break;
            label129: localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void a(d paramd, ay paramay, av paramav, String paramString, cv paramcv)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            IBinder localIBinder1;
            if (paramd != null)
            {
              localIBinder1 = paramd.asBinder();
              localParcel1.writeStrongBinder(localIBinder1);
              if (paramay != null)
              {
                localParcel1.writeInt(1);
                paramay.writeToParcel(localParcel1, 0);
                if (paramav == null)
                  break label163;
                localParcel1.writeInt(1);
                paramav.writeToParcel(localParcel1, 0);
                localParcel1.writeString(paramString);
                IBinder localIBinder2 = null;
                if (paramcv != null)
                  localIBinder2 = paramcv.asBinder();
                localParcel1.writeStrongBinder(localIBinder2);
                this.lb.transact(1, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localIBinder1 = null;
              continue;
            }
            localParcel1.writeInt(0);
            continue;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          label163: localParcel1.writeInt(0);
        }
      }

      public void a(d paramd, ay paramay, av paramav, String paramString1, String paramString2, cv paramcv)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            IBinder localIBinder1;
            if (paramd != null)
            {
              localIBinder1 = paramd.asBinder();
              localParcel1.writeStrongBinder(localIBinder1);
              if (paramay != null)
              {
                localParcel1.writeInt(1);
                paramay.writeToParcel(localParcel1, 0);
                if (paramav == null)
                  break label171;
                localParcel1.writeInt(1);
                paramav.writeToParcel(localParcel1, 0);
                localParcel1.writeString(paramString1);
                localParcel1.writeString(paramString2);
                IBinder localIBinder2 = null;
                if (paramcv != null)
                  localIBinder2 = paramcv.asBinder();
                localParcel1.writeStrongBinder(localIBinder2);
                this.lb.transact(6, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localIBinder1 = null;
              continue;
            }
            localParcel1.writeInt(0);
            continue;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          label171: localParcel1.writeInt(0);
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
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
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

      public d getView()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
          this.lb.transact(2, localParcel1, localParcel2, 0);
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

      public void pause()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
          this.lb.transact(8, localParcel1, localParcel2, 0);
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
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
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

      public void showInterstitial()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
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
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.cu
 * JD-Core Version:    0.6.2
 */