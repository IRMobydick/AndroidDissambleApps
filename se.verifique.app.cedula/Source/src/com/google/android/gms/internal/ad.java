package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.a.a;

class ad
  implements ab
{
  private IBinder a;

  ad(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }

  public IBinder a(a parama, al paramal, String paramString, bv parambv, int paramInt)
  {
    IBinder localIBinder1 = null;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManagerCreator");
      IBinder localIBinder2;
      if (parama != null)
      {
        localIBinder2 = parama.asBinder();
        localParcel1.writeStrongBinder(localIBinder2);
        if (paramal == null)
          break label137;
        localParcel1.writeInt(1);
        paramal.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        localParcel1.writeString(paramString);
        if (parambv != null)
          localIBinder1 = parambv.asBinder();
        localParcel1.writeStrongBinder(localIBinder1);
        localParcel1.writeInt(paramInt);
        this.a.transact(1, localParcel1, localParcel2, 0);
        localParcel2.readException();
        IBinder localIBinder3 = localParcel2.readStrongBinder();
        return localIBinder3;
        localIBinder2 = null;
        break;
        label137: localParcel1.writeInt(0);
      }
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
 * Qualified Name:     com.google.android.gms.internal.ad
 * JD-Core Version:    0.6.0
 */