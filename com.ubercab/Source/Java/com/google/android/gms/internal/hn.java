package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class hn
  implements Parcelable.Creator<hm.a>
{
  static void a(hm.a parama, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.a(paramParcel, 1, parama.Cj, paramInt, false);
    b.c(paramParcel, 1000, parama.BR);
    b.H(paramParcel, i);
  }

  public hm.a[] M(int paramInt)
  {
    return new hm.a[paramInt];
  }

  public hm.a p(Parcel paramParcel)
  {
    int i = a.C(paramParcel);
    int j = 0;
    Account localAccount = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.B(paramParcel);
      switch (a.aD(k))
      {
      default:
        a.b(paramParcel, k);
        break;
      case 1:
        localAccount = (Account)a.a(paramParcel, k, Account.CREATOR);
        break;
      case 1000:
        j = a.g(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new hm.a(j, localAccount);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hn
 * JD-Core Version:    0.6.2
 */