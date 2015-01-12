package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class m
  implements Parcelable.Creator<l>
{
  static void a(l paraml, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1, paraml.getVersionCode());
    b.a(paramParcel, 2, paraml.auK);
    b.a(paramParcel, 3, paraml.auL);
    b.H(paramParcel, i);
  }

  public l dM(Parcel paramParcel)
  {
    long l1 = 0L;
    int i = a.C(paramParcel);
    int j = 0;
    long l2 = l1;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.B(paramParcel);
      switch (a.aD(k))
      {
      default:
        a.b(paramParcel, k);
        break;
      case 1:
        j = a.g(paramParcel, k);
        break;
      case 2:
        l2 = a.i(paramParcel, k);
        break;
      case 3:
        l1 = a.i(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new l(j, l2, l1);
  }

  public l[] fP(int paramInt)
  {
    return new l[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.wobs.m
 * JD-Core Version:    0.6.2
 */