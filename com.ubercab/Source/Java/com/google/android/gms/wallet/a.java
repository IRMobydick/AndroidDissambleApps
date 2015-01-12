package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class a
  implements Parcelable.Creator<Address>
{
  static void a(Address paramAddress, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1, paramAddress.getVersionCode());
    b.a(paramParcel, 2, paramAddress.name, false);
    b.a(paramParcel, 3, paramAddress.adN, false);
    b.a(paramParcel, 4, paramAddress.adO, false);
    b.a(paramParcel, 5, paramAddress.adP, false);
    b.a(paramParcel, 6, paramAddress.uW, false);
    b.a(paramParcel, 7, paramAddress.ast, false);
    b.a(paramParcel, 8, paramAddress.asu, false);
    b.a(paramParcel, 9, paramAddress.adU, false);
    b.a(paramParcel, 10, paramAddress.adW, false);
    b.a(paramParcel, 11, paramAddress.adX);
    b.a(paramParcel, 12, paramAddress.adY, false);
    b.H(paramParcel, i);
  }

  public Address dn(Parcel paramParcel)
  {
    int i = com.google.android.gms.common.internal.safeparcel.a.C(paramParcel);
    int j = 0;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    String str6 = null;
    String str7 = null;
    String str8 = null;
    String str9 = null;
    boolean bool = false;
    String str10 = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = com.google.android.gms.common.internal.safeparcel.a.B(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.aD(k))
      {
      default:
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
        break;
      case 1:
        j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
        break;
      case 2:
        str1 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
        break;
      case 3:
        str2 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
        break;
      case 4:
        str3 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
        break;
      case 5:
        str4 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
        break;
      case 6:
        str5 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
        break;
      case 7:
        str6 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
        break;
      case 8:
        str7 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
        break;
      case 9:
        str8 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
        break;
      case 10:
        str9 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
        break;
      case 11:
        bool = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, k);
        break;
      case 12:
        str10 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new Address(j, str1, str2, str3, str4, str5, str6, str7, str8, str9, bool, str10);
  }

  public Address[] fo(int paramInt)
  {
    return new Address[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.a
 * JD-Core Version:    0.6.2
 */