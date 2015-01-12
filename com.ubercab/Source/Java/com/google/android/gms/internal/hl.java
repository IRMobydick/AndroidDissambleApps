package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class hl
  implements Parcelable.Creator<hk>
{
  static void a(hk paramhk, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1, paramhk.id);
    b.c(paramParcel, 1000, paramhk.BR);
    b.a(paramParcel, 2, paramhk.Ci, false);
    b.H(paramParcel, i);
  }

  public hk[] L(int paramInt)
  {
    return new hk[paramInt];
  }

  public hk o(Parcel paramParcel)
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
        i = a.g(paramParcel, m);
        break;
      case 1000:
        k = a.g(paramParcel, m);
        break;
      case 2:
        localBundle = a.q(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    return new hk(k, i, localBundle);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hl
 * JD-Core Version:    0.6.2
 */