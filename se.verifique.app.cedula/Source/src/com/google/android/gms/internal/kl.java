package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class kl extends Binder
  implements kk
{
  public kl()
  {
    attachInterface(this, "com.google.android.gms.common.internal.IGmsCallbacks");
  }

  public static kk a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null)
      localObject = null;
    while (true)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsCallbacks");
      if ((localIInterface != null) && ((localIInterface instanceof kk)))
      {
        localObject = (kk)localIInterface;
        continue;
      }
      localObject = new km(paramIBinder);
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
        paramParcel2.writeString("com.google.android.gms.common.internal.IGmsCallbacks");
      }
    case 1:
    }
    paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsCallbacks");
    int i = paramParcel1.readInt();
    IBinder localIBinder = paramParcel1.readStrongBinder();
    if (paramParcel1.readInt() != 0);
    for (Bundle localBundle = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle = null)
    {
      a(i, localIBinder, localBundle);
      paramParcel2.writeNoException();
      bool = true;
      break;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.kl
 * JD-Core Version:    0.6.0
 */