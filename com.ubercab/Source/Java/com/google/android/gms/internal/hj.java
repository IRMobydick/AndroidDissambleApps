package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class hj
  implements Parcelable.Creator<hi>
{
  static void a(hi paramhi, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.a(paramParcel, 1, paramhi.Ce, false);
    b.c(paramParcel, 1000, paramhi.BR);
    b.a(paramParcel, 3, paramhi.Cf, paramInt, false);
    b.c(paramParcel, 4, paramhi.Cg);
    b.a(paramParcel, 5, paramhi.Ch, false);
    b.H(paramParcel, i);
  }

  public hi[] K(int paramInt)
  {
    return new hi[paramInt];
  }

  public hi n(Parcel paramParcel)
  {
    byte[] arrayOfByte = null;
    int i = a.C(paramParcel);
    int j = 0;
    int k = -1;
    hq localhq = null;
    String str = null;
    while (paramParcel.dataPosition() < i)
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
        j = a.g(paramParcel, m);
        break;
      case 3:
        localhq = (hq)a.a(paramParcel, m, hq.CREATOR);
        break;
      case 4:
        k = a.g(paramParcel, m);
        break;
      case 5:
        arrayOfByte = a.r(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new hi(j, str, localhq, k, arrayOfByte);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hj
 * JD-Core Version:    0.6.2
 */