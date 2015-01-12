package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class hf
  implements Parcelable.Creator<he>
{
  static void a(he paramhe, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.a(paramParcel, 1, paramhe.BS, paramInt, false);
    b.c(paramParcel, 1000, paramhe.BR);
    b.a(paramParcel, 2, paramhe.BT, false);
    b.a(paramParcel, 3, paramhe.BU);
    b.a(paramParcel, 4, paramhe.account, paramInt, false);
    b.H(paramParcel, i);
  }

  public he[] I(int paramInt)
  {
    return new he[paramInt];
  }

  public he l(Parcel paramParcel)
  {
    boolean bool = false;
    Account localAccount = null;
    int i = a.C(paramParcel);
    String str = null;
    hi[] arrayOfhi = null;
    int j = 0;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.B(paramParcel);
      switch (a.aD(k))
      {
      default:
        a.b(paramParcel, k);
        break;
      case 1:
        arrayOfhi = (hi[])a.b(paramParcel, k, hi.CREATOR);
        break;
      case 1000:
        j = a.g(paramParcel, k);
        break;
      case 2:
        str = a.o(paramParcel, k);
        break;
      case 3:
        bool = a.c(paramParcel, k);
        break;
      case 4:
        localAccount = (Account)a.a(paramParcel, k, Account.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new he(j, arrayOfhi, str, bool, localAccount);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hf
 * JD-Core Version:    0.6.2
 */