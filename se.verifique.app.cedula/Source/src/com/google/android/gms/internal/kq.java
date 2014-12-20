package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class kq extends Binder
  implements ko
{
  public static ko a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null)
      localObject = null;
    while (true)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      if ((localIInterface != null) && ((localIInterface instanceof ko)))
      {
        localObject = (ko)localIInterface;
        continue;
      }
      localObject = new kr(paramIBinder);
    }
  }

  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Bundle localBundle1 = null;
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
    case 10:
    case 11:
    case 12:
    case 13:
    case 14:
    case 15:
    case 16:
    case 17:
    case 18:
    case 19:
    case 20:
    case 21:
    case 22:
    case 23:
    case 24:
    case 25:
    case 26:
    case 27:
    case 28:
    case 30:
    case 31:
    case 32:
    case 33:
    case 34:
    case 35:
    case 36:
    }
    while (true)
    {
      return bool;
      paramParcel2.writeString("com.google.android.gms.common.internal.IGmsServiceBroker");
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      kk localkk21 = kl.a(paramParcel1.readStrongBinder());
      int i16 = paramParcel1.readInt();
      String str26 = paramParcel1.readString();
      String str27 = paramParcel1.readString();
      String[] arrayOfString4 = paramParcel1.createStringArray();
      String str28 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0);
      for (Bundle localBundle6 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle6 = null)
      {
        a(localkk21, i16, str26, str27, arrayOfString4, str28, localBundle6);
        paramParcel2.writeNoException();
        bool = true;
        break;
      }
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      kk localkk20 = kl.a(paramParcel1.readStrongBinder());
      int i15 = paramParcel1.readInt();
      String str25 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0)
        localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      a(localkk20, i15, str25, localBundle1);
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      a(kl.a(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      a(kl.a(paramParcel1.readStrongBinder()), paramParcel1.readInt());
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      kk localkk19 = kl.a(paramParcel1.readStrongBinder());
      int i14 = paramParcel1.readInt();
      String str24 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0)
        localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      b(localkk19, i14, str24, localBundle1);
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      kk localkk18 = kl.a(paramParcel1.readStrongBinder());
      int i13 = paramParcel1.readInt();
      String str23 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0)
        localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      c(localkk18, i13, str23, localBundle1);
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      kk localkk17 = kl.a(paramParcel1.readStrongBinder());
      int i12 = paramParcel1.readInt();
      String str22 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0)
        localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      d(localkk17, i12, str22, localBundle1);
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      kk localkk16 = kl.a(paramParcel1.readStrongBinder());
      int i11 = paramParcel1.readInt();
      String str21 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0)
        localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      e(localkk16, i11, str21, localBundle1);
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      kk localkk15 = kl.a(paramParcel1.readStrongBinder());
      int i10 = paramParcel1.readInt();
      String str17 = paramParcel1.readString();
      String str18 = paramParcel1.readString();
      String[] arrayOfString3 = paramParcel1.createStringArray();
      String str19 = paramParcel1.readString();
      IBinder localIBinder2 = paramParcel1.readStrongBinder();
      String str20 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0);
      for (Bundle localBundle5 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle5 = null)
      {
        a(localkk15, i10, str17, str18, arrayOfString3, str19, localIBinder2, str20, localBundle5);
        paramParcel2.writeNoException();
        bool = true;
        break;
      }
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      a(kl.a(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.createStringArray());
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      kk localkk14 = kl.a(paramParcel1.readStrongBinder());
      int i9 = paramParcel1.readInt();
      String str16 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0)
        localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      f(localkk14, i9, str16, localBundle1);
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      kk localkk13 = kl.a(paramParcel1.readStrongBinder());
      int i8 = paramParcel1.readInt();
      String str15 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0)
        localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      g(localkk13, i8, str15, localBundle1);
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      kk localkk12 = kl.a(paramParcel1.readStrongBinder());
      int i7 = paramParcel1.readInt();
      String str14 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0)
        localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      h(localkk12, i7, str14, localBundle1);
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      kk localkk11 = kl.a(paramParcel1.readStrongBinder());
      int i6 = paramParcel1.readInt();
      String str13 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0)
        localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      i(localkk11, i6, str13, localBundle1);
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      kk localkk10 = kl.a(paramParcel1.readStrongBinder());
      int i5 = paramParcel1.readInt();
      String str12 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0)
        localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      j(localkk10, i5, str12, localBundle1);
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      kk localkk9 = kl.a(paramParcel1.readStrongBinder());
      int i4 = paramParcel1.readInt();
      String str11 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0)
        localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      k(localkk9, i4, str11, localBundle1);
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      kk localkk8 = kl.a(paramParcel1.readStrongBinder());
      int i3 = paramParcel1.readInt();
      String str10 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0)
        localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      l(localkk8, i3, str10, localBundle1);
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      kk localkk7 = kl.a(paramParcel1.readStrongBinder());
      int i2 = paramParcel1.readInt();
      String str9 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0)
        localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      m(localkk7, i2, str9, localBundle1);
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      kk localkk6 = kl.a(paramParcel1.readStrongBinder());
      int i1 = paramParcel1.readInt();
      String str8 = paramParcel1.readString();
      IBinder localIBinder1 = paramParcel1.readStrongBinder();
      if (paramParcel1.readInt() != 0);
      for (Bundle localBundle4 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle4 = null)
      {
        a(localkk6, i1, str8, localIBinder1, localBundle4);
        paramParcel2.writeNoException();
        bool = true;
        break;
      }
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      kk localkk5 = kl.a(paramParcel1.readStrongBinder());
      int n = paramParcel1.readInt();
      String str6 = paramParcel1.readString();
      String[] arrayOfString2 = paramParcel1.createStringArray();
      String str7 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0);
      for (Bundle localBundle3 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle3 = null)
      {
        a(localkk5, n, str6, arrayOfString2, str7, localBundle3);
        paramParcel2.writeNoException();
        bool = true;
        break;
      }
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      b(kl.a(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      c(kl.a(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      kk localkk4 = kl.a(paramParcel1.readStrongBinder());
      int m = paramParcel1.readInt();
      String str5 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0)
        localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      n(localkk4, m, str5, localBundle1);
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      d(kl.a(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      kk localkk3 = kl.a(paramParcel1.readStrongBinder());
      int k = paramParcel1.readInt();
      String str4 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0)
        localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      o(localkk3, k, str4, localBundle1);
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      e(kl.a(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      kk localkk2 = kl.a(paramParcel1.readStrongBinder());
      int j = paramParcel1.readInt();
      String str3 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0)
        localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      p(localkk2, j, str3, localBundle1);
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      b(kl.a(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.createStringArray());
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      kk localkk1 = kl.a(paramParcel1.readStrongBinder());
      int i = paramParcel1.readInt();
      String str1 = paramParcel1.readString();
      String str2 = paramParcel1.readString();
      String[] arrayOfString1 = paramParcel1.createStringArray();
      if (paramParcel1.readInt() != 0);
      for (Bundle localBundle2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle2 = null)
      {
        a(localkk1, i, str1, str2, arrayOfString1, localBundle2);
        paramParcel2.writeNoException();
        bool = true;
        break;
      }
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      f(kl.a(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      g(kl.a(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      a(kl.a(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.createStringArray());
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      a(kl.a(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      h(kl.a(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      i(kl.a(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      bool = true;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.kq
 * JD-Core Version:    0.6.0
 */