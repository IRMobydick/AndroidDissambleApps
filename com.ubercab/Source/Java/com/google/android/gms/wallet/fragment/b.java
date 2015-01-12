package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;

public class b
  implements Parcelable.Creator<WalletFragmentOptions>
{
  static void a(WalletFragmentOptions paramWalletFragmentOptions, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.b.D(paramParcel);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 1, paramWalletFragmentOptions.BR);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 2, paramWalletFragmentOptions.getEnvironment());
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 3, paramWalletFragmentOptions.getTheme());
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 4, paramWalletFragmentOptions.getFragmentStyle(), paramInt, false);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 5, paramWalletFragmentOptions.getMode());
    com.google.android.gms.common.internal.safeparcel.b.H(paramParcel, i);
  }

  public WalletFragmentOptions dE(Parcel paramParcel)
  {
    int i = 1;
    int j = 0;
    int k = a.C(paramParcel);
    WalletFragmentStyle localWalletFragmentStyle = null;
    int m = i;
    int n = 0;
    while (paramParcel.dataPosition() < k)
    {
      int i1 = a.B(paramParcel);
      switch (a.aD(i1))
      {
      default:
        a.b(paramParcel, i1);
        break;
      case 1:
        n = a.g(paramParcel, i1);
        break;
      case 2:
        m = a.g(paramParcel, i1);
        break;
      case 3:
        j = a.g(paramParcel, i1);
        break;
      case 4:
        localWalletFragmentStyle = (WalletFragmentStyle)a.a(paramParcel, i1, WalletFragmentStyle.CREATOR);
        break;
      case 5:
        i = a.g(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    return new WalletFragmentOptions(n, m, j, localWalletFragmentStyle, i);
  }

  public WalletFragmentOptions[] fG(int paramInt)
  {
    return new WalletFragmentOptions[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.fragment.b
 * JD-Core Version:    0.6.2
 */