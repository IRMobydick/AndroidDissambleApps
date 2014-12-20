package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class fs extends Binder
  implements fq
{
  public fs()
  {
    attachInterface(this, "com.google.android.gms.ads.internal.request.IAdRequestService");
  }

  public static fq a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null)
      localObject = null;
    while (true)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
      if ((localIInterface != null) && ((localIInterface instanceof fq)))
      {
        localObject = (fq)localIInterface;
        continue;
      }
      localObject = new ft(paramIBinder);
    }
  }

  public IBinder asBinder()
  {
    return this;
  }

  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    boolean bool;
    switch (paramInt1)
    {
    default:
    case 1598968902:
      for (bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2); ; bool = true)
      {
        return bool;
        paramParcel2.writeString("com.google.android.gms.ads.internal.request.IAdRequestService");
      }
    case 1:
    }
    paramParcel1.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
    ds localds;
    if (paramParcel1.readInt() != 0)
    {
      localds = ds.a.a(paramParcel1);
      label76: du localdu = a(localds);
      paramParcel2.writeNoException();
      if (localdu == null)
        break label117;
      paramParcel2.writeInt(1);
      localdu.writeToParcel(paramParcel2, 1);
    }
    while (true)
    {
      bool = true;
      break;
      localds = null;
      break label76;
      label117: paramParcel2.writeInt(0);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fs
 * JD-Core Version:    0.6.0
 */