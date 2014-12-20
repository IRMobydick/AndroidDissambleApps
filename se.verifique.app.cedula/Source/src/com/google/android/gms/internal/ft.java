package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;

class ft
  implements fq
{
  private IBinder a;

  ft(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }

  public du a(ds paramds)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
        if (paramds == null)
          continue;
        localParcel1.writeInt(1);
        paramds.writeToParcel(localParcel1, 0);
        this.a.transact(1, localParcel1, localParcel2, 0);
        localParcel2.readException();
        if (localParcel2.readInt() != 0)
        {
          du localdu2 = du.a.a(localParcel2);
          localdu1 = localdu2;
          return localdu1;
          localParcel1.writeInt(0);
          continue;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      du localdu1 = null;
    }
  }

  public IBinder asBinder()
  {
    return this.a;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ft
 * JD-Core Version:    0.6.0
 */