package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;

public class b
  implements Parcelable.Creator
{
  static void a(WalletFragmentOptions paramWalletFragmentOptions, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramWalletFragmentOptions.a);
    c.a(paramParcel, 2, paramWalletFragmentOptions.a());
    c.a(paramParcel, 3, paramWalletFragmentOptions.b());
    c.a(paramParcel, 4, paramWalletFragmentOptions.c(), paramInt, false);
    c.a(paramParcel, 5, paramWalletFragmentOptions.d());
    c.a(paramParcel, i);
  }

  public WalletFragmentOptions a(Parcel paramParcel)
  {
    int i = 1;
    int j = 0;
    int k = a.b(paramParcel);
    WalletFragmentStyle localWalletFragmentStyle = null;
    int m = i;
    int n = 0;
    while (paramParcel.dataPosition() < k)
    {
      int i1 = a.a(paramParcel);
      switch (a.a(i1))
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
      throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + k, paramParcel);
    return new WalletFragmentOptions(n, m, j, localWalletFragmentStyle, i);
  }

  public WalletFragmentOptions[] a(int paramInt)
  {
    return new WalletFragmentOptions[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.fragment.b
 * JD-Core Version:    0.6.0
 */