package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class hr
  implements Parcelable.Creator<hq>
{
  static void a(hq paramhq, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.a(paramParcel, 1, paramhq.name, false);
    b.c(paramParcel, 1000, paramhq.BR);
    b.a(paramParcel, 2, paramhq.Co, false);
    b.a(paramParcel, 3, paramhq.Cp);
    b.c(paramParcel, 4, paramhq.weight);
    b.a(paramParcel, 5, paramhq.Cq);
    b.a(paramParcel, 6, paramhq.Cr, false);
    b.a(paramParcel, 7, paramhq.Cs, paramInt, false);
    b.a(paramParcel, 8, paramhq.Ct, false);
    b.a(paramParcel, 11, paramhq.Cu, false);
    b.H(paramParcel, i);
  }

  public hq[] Q(int paramInt)
  {
    return new hq[paramInt];
  }

  public hq r(Parcel paramParcel)
  {
    boolean bool1 = false;
    String str1 = null;
    int i = a.C(paramParcel);
    int j = 1;
    int[] arrayOfInt = null;
    hk[] arrayOfhk = null;
    String str2 = null;
    boolean bool2 = false;
    String str3 = null;
    String str4 = null;
    int k = 0;
    while (paramParcel.dataPosition() < i)
    {
      int m = a.B(paramParcel);
      switch (a.aD(m))
      {
      default:
        a.b(paramParcel, m);
        break;
      case 1:
        str4 = a.o(paramParcel, m);
        break;
      case 1000:
        k = a.g(paramParcel, m);
        break;
      case 2:
        str3 = a.o(paramParcel, m);
        break;
      case 3:
        bool2 = a.c(paramParcel, m);
        break;
      case 4:
        j = a.g(paramParcel, m);
        break;
      case 5:
        bool1 = a.c(paramParcel, m);
        break;
      case 6:
        str2 = a.o(paramParcel, m);
        break;
      case 7:
        arrayOfhk = (hk[])a.b(paramParcel, m, hk.CREATOR);
        break;
      case 8:
        arrayOfInt = a.u(paramParcel, m);
        break;
      case 11:
        str1 = a.o(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new hq(k, str4, str3, bool2, j, bool1, str2, arrayOfhk, arrayOfInt, str1);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hr
 * JD-Core Version:    0.6.2
 */