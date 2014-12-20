package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;

class e
  implements c
{
  private IBinder a;

  e(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }

  public void a(DataHolder paramDataHolder)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
      if (paramDataHolder != null)
      {
        localParcel.writeInt(1);
        paramDataHolder.writeToParcel(localParcel, 0);
      }
      while (true)
      {
        this.a.transact(1, localParcel, null, 1);
        return;
        localParcel.writeInt(0);
      }
    }
    finally
    {
      localParcel.recycle();
    }
    throw localObject;
  }

  public void a(af paramaf)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
      if (paramaf != null)
      {
        localParcel.writeInt(1);
        paramaf.writeToParcel(localParcel, 0);
      }
      while (true)
      {
        this.a.transact(2, localParcel, null, 1);
        return;
        localParcel.writeInt(0);
      }
    }
    finally
    {
      localParcel.recycle();
    }
    throw localObject;
  }

  public void a(ai paramai)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
      if (paramai != null)
      {
        localParcel.writeInt(1);
        paramai.writeToParcel(localParcel, 0);
      }
      while (true)
      {
        this.a.transact(3, localParcel, null, 1);
        return;
        localParcel.writeInt(0);
      }
    }
    finally
    {
      localParcel.recycle();
    }
    throw localObject;
  }

  public IBinder asBinder()
  {
    return this.a;
  }

  public void b(ai paramai)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
      if (paramai != null)
      {
        localParcel.writeInt(1);
        paramai.writeToParcel(localParcel, 0);
      }
      while (true)
      {
        this.a.transact(4, localParcel, null, 1);
        return;
        localParcel.writeInt(0);
      }
    }
    finally
    {
      localParcel.recycle();
    }
    throw localObject;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.e
 * JD-Core Version:    0.6.0
 */