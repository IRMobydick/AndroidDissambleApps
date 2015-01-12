package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.internal.jr;
import java.util.ArrayList;

public class e
  implements Parcelable.Creator<d>
{
  static void a(d paramd, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.b.D(paramParcel);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 1, paramd.getVersionCode());
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 2, paramd.auz, false);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 3, paramd.auA, false);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 4, paramd.auB, false);
    com.google.android.gms.common.internal.safeparcel.b.H(paramParcel, i);
  }

  public d dI(Parcel paramParcel)
  {
    String str1 = null;
    int i = a.C(paramParcel);
    int j = 0;
    ArrayList localArrayList = jr.hz();
    String str2 = null;
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
        str2 = a.o(paramParcel, k);
        break;
      case 3:
        str1 = a.o(paramParcel, k);
        break;
      case 4:
        localArrayList = a.c(paramParcel, k, b.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new d(j, str2, str1, localArrayList);
  }

  public d[] fL(int paramInt)
  {
    return new d[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.wobs.e
 * JD-Core Version:    0.6.2
 */