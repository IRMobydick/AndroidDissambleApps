package com.google.android.gms.wallet.fragment;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c
  implements Parcelable.Creator
{
  static void a(WalletFragmentStyle paramWalletFragmentStyle, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.c.a(paramParcel);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 1, paramWalletFragmentStyle.a);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 2, paramWalletFragmentStyle.b, false);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 3, paramWalletFragmentStyle.c);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, i);
  }

  public WalletFragmentStyle a(Parcel paramParcel)
  {
    int i = 0;
    int j = a.b(paramParcel);
    Bundle localBundle = null;
    int k = 0;
    while (paramParcel.dataPosition() < j)
    {
      int m = a.a(paramParcel);
      switch (a.a(m))
      {
      default:
        a.b(paramParcel, m);
        break;
      case 1:
        k = a.g(paramParcel, m);
        break;
      case 2:
        localBundle = a.q(paramParcel, m);
        break;
      case 3:
        i = a.g(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new b("Overread allowed size end=" + j, paramParcel);
    return new WalletFragmentStyle(k, localBundle, i);
  }

  public WalletFragmentStyle[] a(int paramInt)
  {
    return new WalletFragmentStyle[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.fragment.c
 * JD-Core Version:    0.6.0
 */