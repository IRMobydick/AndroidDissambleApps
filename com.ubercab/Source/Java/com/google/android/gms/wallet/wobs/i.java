package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class i
  implements Parcelable.Creator<f>
{
  static void a(f paramf, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1, paramf.getVersionCode());
    b.a(paramParcel, 2, paramf.label, false);
    b.a(paramParcel, 3, paramf.auC, paramInt, false);
    b.a(paramParcel, 4, paramf.type, false);
    b.a(paramParcel, 5, paramf.atc, paramInt, false);
    b.H(paramParcel, i);
  }

  public f dK(Parcel paramParcel)
  {
    l locall = null;
    int i = a.C(paramParcel);
    int j = 0;
    String str1 = null;
    g localg = null;
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
        localg = (g)a.a(paramParcel, k, g.CREATOR);
        break;
      case 4:
        str1 = a.o(paramParcel, k);
        break;
      case 5:
        locall = (l)a.a(paramParcel, k, l.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new f(j, str2, localg, str1, locall);
  }

  public f[] fN(int paramInt)
  {
    return new f[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.wobs.i
 * JD-Core Version:    0.6.2
 */