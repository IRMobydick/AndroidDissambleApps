package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;

public abstract interface br extends IInterface
{
  public abstract void as()
    throws RemoteException;

  public abstract String bt()
    throws RemoteException;

  public abstract d bu()
    throws RemoteException;

  public abstract d bv()
    throws RemoteException;

  public abstract String bw()
    throws RemoteException;

  public abstract double bx()
    throws RemoteException;

  public abstract String by()
    throws RemoteException;

  public abstract String bz()
    throws RemoteException;

  public abstract String getBody()
    throws RemoteException;

  public abstract void i(int paramInt)
    throws RemoteException;

  public static abstract class a extends Binder
    implements br
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
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
        paramParcel2.writeString("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
        i(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
        as();
        paramParcel2.writeNoException();
        return true;
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
        String str5 = bt();
        paramParcel2.writeNoException();
        paramParcel2.writeString(str5);
        return true;
      case 4:
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
        d locald2 = bu();
        paramParcel2.writeNoException();
        IBinder localIBinder2 = null;
        if (locald2 != null)
          localIBinder2 = locald2.asBinder();
        paramParcel2.writeStrongBinder(localIBinder2);
        return true;
      case 5:
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
        String str4 = getBody();
        paramParcel2.writeNoException();
        paramParcel2.writeString(str4);
        return true;
      case 6:
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
        d locald1 = bv();
        paramParcel2.writeNoException();
        IBinder localIBinder1 = null;
        if (locald1 != null)
          localIBinder1 = locald1.asBinder();
        paramParcel2.writeStrongBinder(localIBinder1);
        return true;
      case 7:
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
        String str3 = bw();
        paramParcel2.writeNoException();
        paramParcel2.writeString(str3);
        return true;
      case 8:
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
        double d = bx();
        paramParcel2.writeNoException();
        paramParcel2.writeDouble(d);
        return true;
      case 9:
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
        String str2 = by();
        paramParcel2.writeNoException();
        paramParcel2.writeString(str2);
        return true;
      case 10:
      }
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
      String str1 = bz();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str1);
      return true;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.br
 * JD-Core Version:    0.6.2
 */