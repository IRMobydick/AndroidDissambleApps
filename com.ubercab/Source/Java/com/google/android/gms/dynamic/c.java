package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface c extends IInterface
{
  public abstract void d(d paramd)
    throws RemoteException;

  public abstract void e(d paramd)
    throws RemoteException;

  public abstract Bundle getArguments()
    throws RemoteException;

  public abstract int getId()
    throws RemoteException;

  public abstract boolean getRetainInstance()
    throws RemoteException;

  public abstract String getTag()
    throws RemoteException;

  public abstract int getTargetRequestCode()
    throws RemoteException;

  public abstract boolean getUserVisibleHint()
    throws RemoteException;

  public abstract d getView()
    throws RemoteException;

  public abstract boolean isAdded()
    throws RemoteException;

  public abstract boolean isDetached()
    throws RemoteException;

  public abstract boolean isHidden()
    throws RemoteException;

  public abstract boolean isInLayout()
    throws RemoteException;

  public abstract boolean isRemoving()
    throws RemoteException;

  public abstract boolean isResumed()
    throws RemoteException;

  public abstract boolean isVisible()
    throws RemoteException;

  public abstract d iu()
    throws RemoteException;

  public abstract c iv()
    throws RemoteException;

  public abstract d iw()
    throws RemoteException;

  public abstract c ix()
    throws RemoteException;

  public abstract void setHasOptionsMenu(boolean paramBoolean)
    throws RemoteException;

  public abstract void setMenuVisibility(boolean paramBoolean)
    throws RemoteException;

  public abstract void setRetainInstance(boolean paramBoolean)
    throws RemoteException;

  public abstract void setUserVisibleHint(boolean paramBoolean)
    throws RemoteException;

  public abstract void startActivity(Intent paramIntent)
    throws RemoteException;

  public abstract void startActivityForResult(Intent paramIntent, int paramInt)
    throws RemoteException;

  public static abstract class a extends Binder
    implements c
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.dynamic.IFragmentWrapper");
    }

    public static c al(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
      if ((localIInterface != null) && ((localIInterface instanceof c)))
        return (c)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.dynamic.IFragmentWrapper");
        return true;
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        d locald3 = iu();
        paramParcel2.writeNoException();
        IBinder localIBinder5 = null;
        if (locald3 != null)
          localIBinder5 = locald3.asBinder();
        paramParcel2.writeStrongBinder(localIBinder5);
        return true;
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        Bundle localBundle = getArguments();
        paramParcel2.writeNoException();
        if (localBundle != null)
        {
          paramParcel2.writeInt(1);
          localBundle.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 4:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        int i12 = getId();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(i12);
        return true;
      case 5:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        c localc2 = iv();
        paramParcel2.writeNoException();
        IBinder localIBinder4 = null;
        if (localc2 != null)
          localIBinder4 = localc2.asBinder();
        paramParcel2.writeStrongBinder(localIBinder4);
        return true;
      case 6:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        d locald2 = iw();
        paramParcel2.writeNoException();
        IBinder localIBinder3 = null;
        if (locald2 != null)
          localIBinder3 = locald2.asBinder();
        paramParcel2.writeStrongBinder(localIBinder3);
        return true;
      case 7:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        boolean bool13 = getRetainInstance();
        paramParcel2.writeNoException();
        if (bool13);
        for (int i11 = 1; ; i11 = 0)
        {
          paramParcel2.writeInt(i11);
          return true;
        }
      case 8:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        String str = getTag();
        paramParcel2.writeNoException();
        paramParcel2.writeString(str);
        return true;
      case 9:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        c localc1 = ix();
        paramParcel2.writeNoException();
        IBinder localIBinder2 = null;
        if (localc1 != null)
          localIBinder2 = localc1.asBinder();
        paramParcel2.writeStrongBinder(localIBinder2);
        return true;
      case 10:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        int i10 = getTargetRequestCode();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(i10);
        return true;
      case 11:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        boolean bool12 = getUserVisibleHint();
        paramParcel2.writeNoException();
        int i9 = 0;
        if (bool12)
          i9 = 1;
        paramParcel2.writeInt(i9);
        return true;
      case 12:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        d locald1 = getView();
        paramParcel2.writeNoException();
        IBinder localIBinder1 = null;
        if (locald1 != null)
          localIBinder1 = locald1.asBinder();
        paramParcel2.writeStrongBinder(localIBinder1);
        return true;
      case 13:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        boolean bool11 = isAdded();
        paramParcel2.writeNoException();
        int i8 = 0;
        if (bool11)
          i8 = 1;
        paramParcel2.writeInt(i8);
        return true;
      case 14:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        boolean bool10 = isDetached();
        paramParcel2.writeNoException();
        int i7 = 0;
        if (bool10)
          i7 = 1;
        paramParcel2.writeInt(i7);
        return true;
      case 15:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        boolean bool9 = isHidden();
        paramParcel2.writeNoException();
        int i6 = 0;
        if (bool9)
          i6 = 1;
        paramParcel2.writeInt(i6);
        return true;
      case 16:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        boolean bool8 = isInLayout();
        paramParcel2.writeNoException();
        int i5 = 0;
        if (bool8)
          i5 = 1;
        paramParcel2.writeInt(i5);
        return true;
      case 17:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        boolean bool7 = isRemoving();
        paramParcel2.writeNoException();
        int i4 = 0;
        if (bool7)
          i4 = 1;
        paramParcel2.writeInt(i4);
        return true;
      case 18:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        boolean bool6 = isResumed();
        paramParcel2.writeNoException();
        int i3 = 0;
        if (bool6)
          i3 = 1;
        paramParcel2.writeInt(i3);
        return true;
      case 19:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        boolean bool5 = isVisible();
        paramParcel2.writeNoException();
        int i2 = 0;
        if (bool5)
          i2 = 1;
        paramParcel2.writeInt(i2);
        return true;
      case 20:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        d(d.a.am(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 21:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        int i1 = paramParcel1.readInt();
        boolean bool4 = false;
        if (i1 != 0)
          bool4 = true;
        setHasOptionsMenu(bool4);
        paramParcel2.writeNoException();
        return true;
      case 22:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        int n = paramParcel1.readInt();
        boolean bool3 = false;
        if (n != 0)
          bool3 = true;
        setMenuVisibility(bool3);
        paramParcel2.writeNoException();
        return true;
      case 23:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        int m = paramParcel1.readInt();
        boolean bool2 = false;
        if (m != 0)
          bool2 = true;
        setRetainInstance(bool2);
        paramParcel2.writeNoException();
        return true;
      case 24:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        int k = paramParcel1.readInt();
        boolean bool1 = false;
        if (k != 0)
          bool1 = true;
        setUserVisibleHint(bool1);
        paramParcel2.writeNoException();
        return true;
      case 25:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        int j = paramParcel1.readInt();
        Intent localIntent2 = null;
        if (j != 0)
          localIntent2 = (Intent)Intent.CREATOR.createFromParcel(paramParcel1);
        startActivity(localIntent2);
        paramParcel2.writeNoException();
        return true;
      case 26:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        int i = paramParcel1.readInt();
        Intent localIntent1 = null;
        if (i != 0)
          localIntent1 = (Intent)Intent.CREATOR.createFromParcel(paramParcel1);
        startActivityForResult(localIntent1, paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 27:
      }
      paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
      e(d.a.am(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }

    private static class a
      implements c
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

      public void d(d paramd)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          if (paramd != null);
          for (IBinder localIBinder = paramd.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.lb.transact(20, localParcel1, localParcel2, 0);
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

      public void e(d paramd)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          if (paramd != null);
          for (IBinder localIBinder = paramd.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.lb.transact(27, localParcel1, localParcel2, 0);
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

      public Bundle getArguments()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.lb.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            localBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
            return localBundle;
          }
          Bundle localBundle = null;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public int getId()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.lb.transact(4, localParcel1, localParcel2, 0);
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

      public boolean getRetainInstance()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.lb.transact(7, localParcel1, localParcel2, 0);
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

      public String getTag()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.lb.transact(8, localParcel1, localParcel2, 0);
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

      public int getTargetRequestCode()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.lb.transact(10, localParcel1, localParcel2, 0);
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

      public boolean getUserVisibleHint()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.lb.transact(11, localParcel1, localParcel2, 0);
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

      public d getView()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.lb.transact(12, localParcel1, localParcel2, 0);
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

      public boolean isAdded()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.lb.transact(13, localParcel1, localParcel2, 0);
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

      public boolean isDetached()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.lb.transact(14, localParcel1, localParcel2, 0);
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

      public boolean isHidden()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.lb.transact(15, localParcel1, localParcel2, 0);
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

      public boolean isInLayout()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.lb.transact(16, localParcel1, localParcel2, 0);
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

      public boolean isRemoving()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.lb.transact(17, localParcel1, localParcel2, 0);
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

      public boolean isResumed()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.lb.transact(18, localParcel1, localParcel2, 0);
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

      public boolean isVisible()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.lb.transact(19, localParcel1, localParcel2, 0);
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

      public d iu()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
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

      public c iv()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.lb.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          c localc = c.a.al(localParcel2.readStrongBinder());
          return localc;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public d iw()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.lb.transact(6, localParcel1, localParcel2, 0);
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

      public c ix()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.lb.transact(9, localParcel1, localParcel2, 0);
          localParcel2.readException();
          c localc = c.a.al(localParcel2.readStrongBinder());
          return localc;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void setHasOptionsMenu(boolean paramBoolean)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          int i = 0;
          if (paramBoolean)
            i = 1;
          localParcel1.writeInt(i);
          this.lb.transact(21, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void setMenuVisibility(boolean paramBoolean)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          int i = 0;
          if (paramBoolean)
            i = 1;
          localParcel1.writeInt(i);
          this.lb.transact(22, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void setRetainInstance(boolean paramBoolean)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          int i = 0;
          if (paramBoolean)
            i = 1;
          localParcel1.writeInt(i);
          this.lb.transact(23, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void setUserVisibleHint(boolean paramBoolean)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          int i = 0;
          if (paramBoolean)
            i = 1;
          localParcel1.writeInt(i);
          this.lb.transact(24, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void startActivity(Intent paramIntent)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          if (paramIntent != null)
          {
            localParcel1.writeInt(1);
            paramIntent.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.lb.transact(25, localParcel1, localParcel2, 0);
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

      public void startActivityForResult(Intent paramIntent, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          if (paramIntent != null)
          {
            localParcel1.writeInt(1);
            paramIntent.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            localParcel1.writeInt(paramInt);
            this.lb.transact(26, localParcel1, localParcel2, 0);
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
 * Qualified Name:     com.google.android.gms.dynamic.c
 * JD-Core Version:    0.6.2
 */