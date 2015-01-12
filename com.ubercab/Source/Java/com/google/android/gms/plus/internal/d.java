package com.google.android.gms.plus.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.internal.j;
import com.google.android.gms.common.internal.j.a;
import com.google.android.gms.internal.jb;
import com.google.android.gms.internal.jc;
import com.google.android.gms.internal.jp;
import com.google.android.gms.internal.jq;
import java.util.List;

public abstract interface d extends IInterface
{
  public abstract j a(b paramb, int paramInt1, int paramInt2, int paramInt3, String paramString)
    throws RemoteException;

  public abstract void a(jp paramjp)
    throws RemoteException;

  public abstract void a(b paramb)
    throws RemoteException;

  public abstract void a(b paramb, int paramInt, String paramString1, Uri paramUri, String paramString2, String paramString3)
    throws RemoteException;

  public abstract void a(b paramb, Uri paramUri, Bundle paramBundle)
    throws RemoteException;

  public abstract void a(b paramb, jp paramjp)
    throws RemoteException;

  public abstract void a(b paramb, String paramString)
    throws RemoteException;

  public abstract void a(b paramb, String paramString1, String paramString2)
    throws RemoteException;

  public abstract void a(b paramb, List<String> paramList)
    throws RemoteException;

  public abstract void a(String paramString, jb paramjb1, jb paramjb2)
    throws RemoteException;

  public abstract void b(b paramb)
    throws RemoteException;

  public abstract void b(b paramb, String paramString)
    throws RemoteException;

  public abstract void c(b paramb, String paramString)
    throws RemoteException;

  public abstract void clearDefaultAccount()
    throws RemoteException;

  public abstract void d(b paramb, String paramString)
    throws RemoteException;

  public abstract void e(b paramb, String paramString)
    throws RemoteException;

  public abstract String getAccountName()
    throws RemoteException;

  public abstract String nb()
    throws RemoteException;

  public abstract boolean nc()
    throws RemoteException;

  public abstract String nd()
    throws RemoteException;

  public abstract void removeMoment(String paramString)
    throws RemoteException;

  public static abstract class a extends Binder
    implements d
  {
    public static d bG(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusService");
      if ((localIInterface != null) && ((localIInterface instanceof d)))
        return (d)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.plus.internal.IPlusService");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        a(b.a.bE(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        a(b.a.bE(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        b(b.a.bE(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 4:
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        if (paramParcel1.readInt() != 0);
        for (jp localjp2 = jp.CREATOR.M(paramParcel1); ; localjp2 = null)
        {
          a(localjp2);
          paramParcel2.writeNoException();
          return true;
        }
      case 5:
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        String str5 = getAccountName();
        paramParcel2.writeNoException();
        paramParcel2.writeString(str5);
        return true;
      case 6:
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        clearDefaultAccount();
        paramParcel2.writeNoException();
        return true;
      case 8:
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        a(b.a.bE(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 9:
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        b localb3 = b.a.bE(paramParcel1.readStrongBinder());
        Uri localUri2;
        if (paramParcel1.readInt() != 0)
        {
          localUri2 = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label473;
        }
        for (Bundle localBundle = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle = null)
        {
          a(localb3, localUri2, localBundle);
          paramParcel2.writeNoException();
          return true;
          localUri2 = null;
          break;
        }
      case 14:
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        b localb2 = b.a.bE(paramParcel1.readStrongBinder());
        int m = paramParcel1.readInt();
        String str4 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0);
        for (Uri localUri1 = (Uri)Uri.CREATOR.createFromParcel(paramParcel1); ; localUri1 = null)
        {
          a(localb2, m, str4, localUri1, paramParcel1.readString(), paramParcel1.readString());
          paramParcel2.writeNoException();
          return true;
        }
      case 16:
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        j localj = a(b.a.bE(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readString());
        paramParcel2.writeNoException();
        IBinder localIBinder = null;
        if (localj != null)
          localIBinder = localj.asBinder();
        paramParcel2.writeStrongBinder(localIBinder);
        return true;
      case 17:
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        removeMoment(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 18:
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        c(b.a.bE(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 19:
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        b(b.a.bE(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 34:
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        a(b.a.bE(paramParcel1.readStrongBinder()), paramParcel1.createStringArrayList());
        paramParcel2.writeNoException();
        return true;
      case 40:
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        d(b.a.bE(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 41:
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        String str3 = nb();
        paramParcel2.writeNoException();
        paramParcel2.writeString(str3);
        return true;
      case 42:
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        boolean bool = nc();
        paramParcel2.writeNoException();
        if (bool);
        for (int k = 1; ; k = 0)
        {
          paramParcel2.writeInt(k);
          return true;
        }
      case 43:
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        String str2 = nd();
        paramParcel2.writeNoException();
        paramParcel2.writeString(str2);
        return true;
      case 44:
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        e(b.a.bE(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 45:
        label473: paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        b localb1 = b.a.bE(paramParcel1.readStrongBinder());
        int j = paramParcel1.readInt();
        jp localjp1 = null;
        if (j != 0)
          localjp1 = jp.CREATOR.M(paramParcel1);
        a(localb1, localjp1);
        paramParcel2.writeNoException();
        return true;
      case 46:
      }
      paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
      String str1 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0);
      for (jb localjb1 = jb.CREATOR.E(paramParcel1); ; localjb1 = null)
      {
        int i = paramParcel1.readInt();
        jb localjb2 = null;
        if (i != 0)
          localjb2 = jb.CREATOR.E(paramParcel1);
        a(str1, localjb1, localjb2);
        paramParcel2.writeNoException();
        return true;
      }
    }

    private static class a
      implements d
    {
      private IBinder lb;

      a(IBinder paramIBinder)
      {
        this.lb = paramIBinder;
      }

      public j a(b paramb, int paramInt1, int paramInt2, int paramInt3, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
          if (paramb != null);
          for (IBinder localIBinder = paramb.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            localParcel1.writeInt(paramInt1);
            localParcel1.writeInt(paramInt2);
            localParcel1.writeInt(paramInt3);
            localParcel1.writeString(paramString);
            this.lb.transact(16, localParcel1, localParcel2, 0);
            localParcel2.readException();
            j localj = j.a.O(localParcel2.readStrongBinder());
            return localj;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void a(jp paramjp)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
          if (paramjp != null)
          {
            localParcel1.writeInt(1);
            paramjp.writeToParcel(localParcel1, 0);
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

      public void a(b paramb)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
          if (paramb != null);
          for (IBinder localIBinder = paramb.asBinder(); ; localIBinder = null)
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

      public void a(b paramb, int paramInt, String paramString1, Uri paramUri, String paramString2, String paramString3)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
          IBinder localIBinder;
          if (paramb != null)
          {
            localIBinder = paramb.asBinder();
            localParcel1.writeStrongBinder(localIBinder);
            localParcel1.writeInt(paramInt);
            localParcel1.writeString(paramString1);
            if (paramUri == null)
              break label120;
            localParcel1.writeInt(1);
            paramUri.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            localParcel1.writeString(paramString2);
            localParcel1.writeString(paramString3);
            this.lb.transact(14, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            localIBinder = null;
            break;
            label120: localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void a(b paramb, Uri paramUri, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            IBinder localIBinder;
            if (paramb != null)
            {
              localIBinder = paramb.asBinder();
              localParcel1.writeStrongBinder(localIBinder);
              if (paramUri != null)
              {
                localParcel1.writeInt(1);
                paramUri.writeToParcel(localParcel1, 0);
                if (paramBundle == null)
                  break label133;
                localParcel1.writeInt(1);
                paramBundle.writeToParcel(localParcel1, 0);
                this.lb.transact(9, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localIBinder = null;
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
          label133: localParcel1.writeInt(0);
        }
      }

      public void a(b paramb, jp paramjp)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
          IBinder localIBinder;
          if (paramb != null)
          {
            localIBinder = paramb.asBinder();
            localParcel1.writeStrongBinder(localIBinder);
            if (paramjp == null)
              break label85;
            localParcel1.writeInt(1);
            paramjp.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.lb.transact(45, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            localIBinder = null;
            break;
            label85: localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void a(b paramb, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
          if (paramb != null);
          for (IBinder localIBinder = paramb.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            localParcel1.writeString(paramString);
            this.lb.transact(1, localParcel1, localParcel2, 0);
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

      public void a(b paramb, String paramString1, String paramString2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
          if (paramb != null);
          for (IBinder localIBinder = paramb.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
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

      public void a(b paramb, List<String> paramList)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
          if (paramb != null);
          for (IBinder localIBinder = paramb.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            localParcel1.writeStringList(paramList);
            this.lb.transact(34, localParcel1, localParcel2, 0);
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

      public void a(String paramString, jb paramjb1, jb paramjb2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            localParcel1.writeString(paramString);
            if (paramjb1 != null)
            {
              localParcel1.writeInt(1);
              paramjb1.writeToParcel(localParcel1, 0);
              if (paramjb2 != null)
              {
                localParcel1.writeInt(1);
                paramjb2.writeToParcel(localParcel1, 0);
                this.lb.transact(46, localParcel1, localParcel2, 0);
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

      public IBinder asBinder()
      {
        return this.lb;
      }

      public void b(b paramb)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
          if (paramb != null);
          for (IBinder localIBinder = paramb.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.lb.transact(19, localParcel1, localParcel2, 0);
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

      public void b(b paramb, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
          if (paramb != null);
          for (IBinder localIBinder = paramb.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            localParcel1.writeString(paramString);
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

      public void c(b paramb, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
          if (paramb != null);
          for (IBinder localIBinder = paramb.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            localParcel1.writeString(paramString);
            this.lb.transact(18, localParcel1, localParcel2, 0);
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

      public void clearDefaultAccount()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
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

      public void d(b paramb, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
          if (paramb != null);
          for (IBinder localIBinder = paramb.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            localParcel1.writeString(paramString);
            this.lb.transact(40, localParcel1, localParcel2, 0);
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

      public void e(b paramb, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
          if (paramb != null);
          for (IBinder localIBinder = paramb.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            localParcel1.writeString(paramString);
            this.lb.transact(44, localParcel1, localParcel2, 0);
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

      public String getAccountName()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
          this.lb.transact(5, localParcel1, localParcel2, 0);
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

      public String nb()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
          this.lb.transact(41, localParcel1, localParcel2, 0);
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

      public boolean nc()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
          this.lb.transact(42, localParcel1, localParcel2, 0);
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

      public String nd()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
          this.lb.transact(43, localParcel1, localParcel2, 0);
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

      public void removeMoment(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
          localParcel1.writeString(paramString);
          this.lb.transact(17, localParcel1, localParcel2, 0);
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
 * Qualified Name:     com.google.android.gms.plus.internal.d
 * JD-Core Version:    0.6.2
 */