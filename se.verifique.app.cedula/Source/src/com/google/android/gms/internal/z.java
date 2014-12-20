package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.a.a;

public abstract class z extends Binder
  implements y
{
  public z()
  {
    attachInterface(this, "com.google.android.gms.ads.internal.client.IAdManager");
  }

  public static y a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null)
      localObject = null;
    while (true)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
      if ((localIInterface != null) && ((localIInterface instanceof y)))
      {
        localObject = (y)localIInterface;
        continue;
      }
      localObject = new aa(paramIBinder);
    }
  }

  public IBinder asBinder()
  {
    return this;
  }

  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject = null;
    int i = 0;
    int j = 1;
    switch (paramInt1)
    {
    default:
      j = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
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
    case 10:
    case 11:
    case 12:
    case 13:
    case 14:
    case 15:
    }
    while (true)
    {
      return j;
      paramParcel2.writeString("com.google.android.gms.ads.internal.client.IAdManager");
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
      a locala = a();
      paramParcel2.writeNoException();
      if (locala != null)
        localObject = locala.asBinder();
      paramParcel2.writeStrongBinder((IBinder)localObject);
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
      b();
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
      boolean bool2 = c();
      paramParcel2.writeNoException();
      if (bool2);
      int m;
      for (int k = j; ; m = 0)
      {
        paramParcel2.writeInt(k);
        break;
      }
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
      if (paramParcel1.readInt() != 0)
        localObject = ai.a.a(paramParcel1);
      boolean bool1 = a((ai)localObject);
      paramParcel2.writeNoException();
      if (bool1)
        i = j;
      paramParcel2.writeInt(i);
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
      d();
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
      e();
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
      a(w.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
      a(af.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
      f();
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
      g();
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
      h();
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
      al localal = i();
      paramParcel2.writeNoException();
      if (localal != null)
      {
        paramParcel2.writeInt(j);
        localal.writeToParcel(paramParcel2, j);
        continue;
      }
      paramParcel2.writeInt(0);
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
      if (paramParcel1.readInt() != 0)
        localObject = al.a.a(paramParcel1);
      a((al)localObject);
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
      a(ec.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
      a(ek.a(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.z
 * JD-Core Version:    0.6.0
 */