package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.a.a;
import com.google.android.gms.a.b;

public abstract class bz extends Binder
  implements by
{
  public bz()
  {
    attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
  }

  public static by a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null)
      localObject = null;
    while (true)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      if ((localIInterface != null) && ((localIInterface instanceof by)))
      {
        localObject = (by)localIInterface;
        continue;
      }
      localObject = new ca(paramIBinder);
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
    case 5:
    case 6:
    case 7:
    case 8:
    case 9:
    }
    while (true)
    {
      return bool;
      paramParcel2.writeString("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      a locala5 = b.a(paramParcel1.readStrongBinder());
      al localal2;
      if (paramParcel1.readInt() != 0)
      {
        localal2 = al.a.a(paramParcel1);
        label153: if (paramParcel1.readInt() == 0)
          break label206;
      }
      label206: for (ai localai3 = ai.a.a(paramParcel1); ; localai3 = null)
      {
        a(locala5, localal2, localai3, paramParcel1.readString(), cc.a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        bool = true;
        break;
        localal2 = null;
        break label153;
      }
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      a locala4 = a();
      paramParcel2.writeNoException();
      if (locala4 != null)
        localObject = locala4.asBinder();
      paramParcel2.writeStrongBinder((IBinder)localObject);
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      a locala3 = b.a(paramParcel1.readStrongBinder());
      if (paramParcel1.readInt() != 0)
        localObject = ai.a.a(paramParcel1);
      a(locala3, (ai)localObject, paramParcel1.readString(), cc.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      b();
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      c();
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      a locala2 = b.a(paramParcel1.readStrongBinder());
      al localal1;
      if (paramParcel1.readInt() != 0)
      {
        localal1 = al.a.a(paramParcel1);
        label385: if (paramParcel1.readInt() == 0)
          break label442;
      }
      label442: for (ai localai2 = ai.a.a(paramParcel1); ; localai2 = null)
      {
        a(locala2, localal1, localai2, paramParcel1.readString(), paramParcel1.readString(), cc.a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        bool = true;
        break;
        localal1 = null;
        break label385;
      }
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      a locala1 = b.a(paramParcel1.readStrongBinder());
      if (paramParcel1.readInt() != 0);
      for (ai localai1 = ai.a.a(paramParcel1); ; localai1 = null)
      {
        a(locala1, localai1, paramParcel1.readString(), paramParcel1.readString(), cc.a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        bool = true;
        break;
      }
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      d();
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      e();
      paramParcel2.writeNoException();
      bool = true;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.bz
 * JD-Core Version:    0.6.0
 */