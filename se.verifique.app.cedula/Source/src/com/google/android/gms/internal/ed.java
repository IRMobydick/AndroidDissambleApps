package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;

class ed
  implements eb
{
  private IBinder a;

  ed(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }

  public void a(dy paramdy)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
      if (paramdy != null)
      {
        localIBinder = paramdy.asBinder();
        localParcel1.writeStrongBinder(localIBinder);
        this.a.transact(1, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
      IBinder localIBinder = null;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }

  public IBinder asBinder()
  {
    return this.a;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ed
 * JD-Core Version:    0.6.0
 */