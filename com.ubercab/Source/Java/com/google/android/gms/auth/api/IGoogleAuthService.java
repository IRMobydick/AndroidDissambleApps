package com.google.android.gms.auth.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface IGoogleAuthService extends IInterface
{
  public abstract void sendConnection(IGoogleAuthApiCallbacks paramIGoogleAuthApiCallbacks, GoogleAuthApiRequest paramGoogleAuthApiRequest)
    throws RemoteException;

  public static abstract class Stub extends Binder
    implements IGoogleAuthService
  {
    public Stub()
    {
      attachInterface(this, "com.google.android.gms.auth.api.IGoogleAuthService");
    }

    public static IGoogleAuthService asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.auth.api.IGoogleAuthService");
      if ((localIInterface != null) && ((localIInterface instanceof IGoogleAuthService)))
        return (IGoogleAuthService)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.auth.api.IGoogleAuthService");
        return true;
      case 1:
      }
      paramParcel1.enforceInterface("com.google.android.gms.auth.api.IGoogleAuthService");
      IGoogleAuthApiCallbacks localIGoogleAuthApiCallbacks = IGoogleAuthApiCallbacks.Stub.asInterface(paramParcel1.readStrongBinder());
      if (paramParcel1.readInt() != 0);
      for (GoogleAuthApiRequest localGoogleAuthApiRequest = GoogleAuthApiRequest.CREATOR.createFromParcel(paramParcel1); ; localGoogleAuthApiRequest = null)
      {
        sendConnection(localIGoogleAuthApiCallbacks, localGoogleAuthApiRequest);
        paramParcel2.writeNoException();
        return true;
      }
    }

    private static class a
      implements IGoogleAuthService
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

      public void sendConnection(IGoogleAuthApiCallbacks paramIGoogleAuthApiCallbacks, GoogleAuthApiRequest paramGoogleAuthApiRequest)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.auth.api.IGoogleAuthService");
          IBinder localIBinder;
          if (paramIGoogleAuthApiCallbacks != null)
          {
            localIBinder = paramIGoogleAuthApiCallbacks.asBinder();
            localParcel1.writeStrongBinder(localIBinder);
            if (paramGoogleAuthApiRequest == null)
              break label84;
            localParcel1.writeInt(1);
            paramGoogleAuthApiRequest.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.lb.transact(1, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            localIBinder = null;
            break;
            label84: localParcel1.writeInt(0);
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
 * Qualified Name:     com.google.android.gms.auth.api.IGoogleAuthService
 * JD-Core Version:    0.6.2
 */