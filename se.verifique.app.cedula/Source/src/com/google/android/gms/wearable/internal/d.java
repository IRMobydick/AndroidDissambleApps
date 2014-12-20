package com.google.android.gms.wearable.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;

public abstract class d extends Binder
  implements c
{
  public static c a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null)
      localObject = null;
    while (true)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableListener");
      if ((localIInterface != null) && ((localIInterface instanceof c)))
      {
        localObject = (c)localIInterface;
        continue;
      }
      localObject = new e(paramIBinder);
    }
  }

  public IBinder asBinder()
  {
    return this;
  }

  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject = null;
    boolean bool;
    switch (paramInt1)
    {
    default:
      bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902:
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      return bool;
      paramParcel2.writeString("com.google.android.gms.wearable.internal.IWearableListener");
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
      if (paramParcel1.readInt() != 0)
        localObject = DataHolder.a.a(paramParcel1);
      a((DataHolder)localObject);
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
      if (paramParcel1.readInt() != 0)
        localObject = (af)af.CREATOR.createFromParcel(paramParcel1);
      a((af)localObject);
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
      if (paramParcel1.readInt() != 0)
        localObject = (ai)ai.CREATOR.createFromParcel(paramParcel1);
      a((ai)localObject);
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
      if (paramParcel1.readInt() != 0)
        localObject = (ai)ai.CREATOR.createFromParcel(paramParcel1);
      b((ai)localObject);
      bool = true;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.d
 * JD-Core Version:    0.6.0
 */