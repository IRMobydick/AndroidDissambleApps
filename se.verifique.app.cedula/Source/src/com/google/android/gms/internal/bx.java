package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;

class bx
  implements bv
{
  private IBinder a;

  bx(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }

  public by a(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
      localParcel1.writeString(paramString);
      this.a.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      by localby = bz.a(localParcel2.readStrongBinder());
      return localby;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public IBinder asBinder()
  {
    return this.a;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.bx
 * JD-Core Version:    0.6.0
 */