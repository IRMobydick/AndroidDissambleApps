package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.auth.AccountChangeEventsRequestCreator;
import com.google.android.gms.auth.AccountChangeEventsResponse;
import com.google.android.gms.auth.AccountChangeEventsResponseCreator;

public abstract interface r extends IInterface
{
  public abstract Bundle a(String paramString, Bundle paramBundle)
    throws RemoteException;

  public abstract Bundle a(String paramString1, String paramString2, Bundle paramBundle)
    throws RemoteException;

  public abstract AccountChangeEventsResponse a(AccountChangeEventsRequest paramAccountChangeEventsRequest)
    throws RemoteException;

  public static abstract class a extends Binder
    implements r
  {
    public static r a(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.auth.IAuthManagerService");
      if ((localIInterface != null) && ((localIInterface instanceof r)))
        return (r)localIInterface;
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
        paramParcel2.writeString("com.google.android.auth.IAuthManagerService");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.auth.IAuthManagerService");
        String str2 = paramParcel1.readString();
        String str3 = paramParcel1.readString();
        int k = paramParcel1.readInt();
        Bundle localBundle3 = null;
        if (k != 0)
          localBundle3 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        Bundle localBundle4 = a(str2, str3, localBundle3);
        paramParcel2.writeNoException();
        if (localBundle4 != null)
        {
          paramParcel2.writeInt(1);
          localBundle4.writeToParcel(paramParcel2, 1);
        }
        while (true)
        {
          return true;
          paramParcel2.writeInt(0);
        }
      case 2:
        paramParcel1.enforceInterface("com.google.android.auth.IAuthManagerService");
        String str1 = paramParcel1.readString();
        int j = paramParcel1.readInt();
        Bundle localBundle1 = null;
        if (j != 0)
          localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        Bundle localBundle2 = a(str1, localBundle1);
        paramParcel2.writeNoException();
        if (localBundle2 != null)
        {
          paramParcel2.writeInt(1);
          localBundle2.writeToParcel(paramParcel2, 1);
        }
        while (true)
        {
          return true;
          paramParcel2.writeInt(0);
        }
      case 3:
      }
      paramParcel1.enforceInterface("com.google.android.auth.IAuthManagerService");
      int i = paramParcel1.readInt();
      AccountChangeEventsRequest localAccountChangeEventsRequest = null;
      if (i != 0)
        localAccountChangeEventsRequest = AccountChangeEventsRequest.CREATOR.createFromParcel(paramParcel1);
      AccountChangeEventsResponse localAccountChangeEventsResponse = a(localAccountChangeEventsRequest);
      paramParcel2.writeNoException();
      if (localAccountChangeEventsResponse != null)
      {
        paramParcel2.writeInt(1);
        localAccountChangeEventsResponse.writeToParcel(paramParcel2, 1);
      }
      while (true)
      {
        return true;
        paramParcel2.writeInt(0);
      }
    }

    private static class a
      implements r
    {
      private IBinder lb;

      a(IBinder paramIBinder)
      {
        this.lb = paramIBinder;
      }

      public Bundle a(String paramString, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.auth.IAuthManagerService");
            localParcel1.writeString(paramString);
            if (paramBundle != null)
            {
              localParcel1.writeInt(1);
              paramBundle.writeToParcel(localParcel1, 0);
              this.lb.transact(2, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                localBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
                return localBundle;
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
          Bundle localBundle = null;
        }
      }

      public Bundle a(String paramString1, String paramString2, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.auth.IAuthManagerService");
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            if (paramBundle != null)
            {
              localParcel1.writeInt(1);
              paramBundle.writeToParcel(localParcel1, 0);
              this.lb.transact(1, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                localBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
                return localBundle;
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
          Bundle localBundle = null;
        }
      }

      public AccountChangeEventsResponse a(AccountChangeEventsRequest paramAccountChangeEventsRequest)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.auth.IAuthManagerService");
            if (paramAccountChangeEventsRequest != null)
            {
              localParcel1.writeInt(1);
              paramAccountChangeEventsRequest.writeToParcel(localParcel1, 0);
              this.lb.transact(3, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                AccountChangeEventsResponse localAccountChangeEventsResponse2 = AccountChangeEventsResponse.CREATOR.createFromParcel(localParcel2);
                localAccountChangeEventsResponse1 = localAccountChangeEventsResponse2;
                return localAccountChangeEventsResponse1;
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
          AccountChangeEventsResponse localAccountChangeEventsResponse1 = null;
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
 * Qualified Name:     com.google.android.gms.internal.r
 * JD-Core Version:    0.6.2
 */