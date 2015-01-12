package com.google.android.gms.auth.api;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface IGoogleAuthApiCallbacks extends IInterface
{
  public abstract void onConnectionSuccess(GoogleAuthApiResponse paramGoogleAuthApiResponse)
    throws RemoteException;

  public abstract void onError(int paramInt, String paramString, PendingIntent paramPendingIntent)
    throws RemoteException;

  public static abstract class Stub extends Binder
    implements IGoogleAuthApiCallbacks
  {
    public Stub()
    {
      attachInterface(this, "com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
    }

    public static IGoogleAuthApiCallbacks asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
      if ((localIInterface != null) && ((localIInterface instanceof IGoogleAuthApiCallbacks)))
        return (IGoogleAuthApiCallbacks)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
        int k = paramParcel1.readInt();
        GoogleAuthApiResponse localGoogleAuthApiResponse = null;
        if (k != 0)
          localGoogleAuthApiResponse = GoogleAuthApiResponse.CREATOR.createFromParcel(paramParcel1);
        onConnectionSuccess(localGoogleAuthApiResponse);
        paramParcel2.writeNoException();
        return true;
      case 2:
      }
      paramParcel1.enforceInterface("com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
      int i = paramParcel1.readInt();
      String str = paramParcel1.readString();
      int j = paramParcel1.readInt();
      PendingIntent localPendingIntent = null;
      if (j != 0)
        localPendingIntent = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);
      onError(i, str, localPendingIntent);
      paramParcel2.writeNoException();
      return true;
    }

    private static class a
      implements IGoogleAuthApiCallbacks
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

      public void onConnectionSuccess(GoogleAuthApiResponse paramGoogleAuthApiResponse)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
          if (paramGoogleAuthApiResponse != null)
          {
            localParcel1.writeInt(1);
            paramGoogleAuthApiResponse.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.lb.transact(1, localParcel1, localParcel2, 0);
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

      public void onError(int paramInt, String paramString, PendingIntent paramPendingIntent)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
          localParcel1.writeInt(paramInt);
          localParcel1.writeString(paramString);
          if (paramPendingIntent != null)
          {
            localParcel1.writeInt(1);
            paramPendingIntent.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.lb.transact(2, localParcel1, localParcel2, 0);
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
 * Qualified Name:     com.google.android.gms.auth.api.IGoogleAuthApiCallbacks
 * JD-Core Version:    0.6.2
 */