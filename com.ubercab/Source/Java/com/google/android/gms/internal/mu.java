package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class mu
  implements Parcelable.Creator<mt>
{
  static void a(mt parammt, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.a(paramParcel, 1, parammt.uO, false);
    b.c(paramParcel, 1000, parammt.BR);
    b.c(paramParcel, 2, parammt.aig);
    b.H(paramParcel, i);
  }

  public mt cE(Parcel paramParcel)
  {
    int i = 0;
    int j = a.C(paramParcel);
    String str = null;
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
        str = a.o(paramParcel, m);
        break;
      case 1000:
        k = a.g(paramParcel, m);
        break;
      case 2:
        i = a.g(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    return new mt(k, str, i);
  }

  public mt[] eu(int paramInt)
  {
    return new mt[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.mu
 * JD-Core Version:    0.6.2
 */