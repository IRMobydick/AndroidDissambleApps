package com.google.android.gms.wallet.fragment;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c
  implements Parcelable.Creator<WalletFragmentStyle>
{
  static void a(WalletFragmentStyle paramWalletFragmentStyle, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1, paramWalletFragmentStyle.BR);
    b.a(paramParcel, 2, paramWalletFragmentStyle.auo, false);
    b.c(paramParcel, 3, paramWalletFragmentStyle.aup);
    b.H(paramParcel, i);
  }

  public WalletFragmentStyle dF(Parcel paramParcel)
  {
    int i = 0;
    int j = a.C(paramParcel);
    Bundle localBundle = null;
    int k = 0;
    while (paramParcel.dataPosition() < j)
    {
      int m = a.B(paramParcel);
      switch (a.aD(m))
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
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    return new WalletFragmentStyle(k, localBundle, i);
  }

  public WalletFragmentStyle[] fH(int paramInt)
  {
    return new WalletFragmentStyle[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.fragment.c
 * JD-Core Version:    0.6.2
 */