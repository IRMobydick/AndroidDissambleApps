package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ht
  implements Parcelable.Creator<hs>
{
  static void a(hs paramhs, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.a(paramParcel, 1, paramhs.CD, paramInt, false);
    b.c(paramParcel, 1000, paramhs.BR);
    b.a(paramParcel, 2, paramhs.CE);
    b.c(paramParcel, 3, paramhs.CF);
    b.a(paramParcel, 4, paramhs.oT, false);
    b.a(paramParcel, 5, paramhs.CG, paramInt, false);
    b.H(paramParcel, i);
  }

  public hs[] R(int paramInt)
  {
    return new hs[paramInt];
  }

  public hs s(Parcel paramParcel)
  {
    int i = 0;
    he localhe = null;
    int j = a.C(paramParcel);
    long l = 0L;
    String str = null;
    hg localhg = null;
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
        localhg = (hg)a.a(paramParcel, m, hg.CREATOR);
        break;
      case 1000:
        k = a.g(paramParcel, m);
        break;
      case 2:
        l = a.i(paramParcel, m);
        break;
      case 3:
        i = a.g(paramParcel, m);
        break;
      case 4:
        str = a.o(paramParcel, m);
        break;
      case 5:
        localhe = (he)a.a(paramParcel, m, he.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    return new hs(k, localhg, l, i, str, localhe);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ht
 * JD-Core Version:    0.6.2
 */