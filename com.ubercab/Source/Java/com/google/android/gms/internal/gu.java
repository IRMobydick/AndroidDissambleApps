package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class gu
  implements Parcelable.Creator<gt>
{
  static void a(gt paramgt, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1, paramgt.versionCode);
    b.a(paramParcel, 2, paramgt.wD, false);
    b.c(paramParcel, 3, paramgt.wE);
    b.c(paramParcel, 4, paramgt.wF);
    b.a(paramParcel, 5, paramgt.wG);
    b.H(paramParcel, i);
  }

  public gt j(Parcel paramParcel)
  {
    boolean bool = false;
    int i = a.C(paramParcel);
    String str = null;
    int j = 0;
    int k = 0;
    int m = 0;
    while (paramParcel.dataPosition() < i)
    {
      int n = a.B(paramParcel);
      switch (a.aD(n))
      {
      default:
        a.b(paramParcel, n);
        break;
      case 1:
        m = a.g(paramParcel, n);
        break;
      case 2:
        str = a.o(paramParcel, n);
        break;
      case 3:
        k = a.g(paramParcel, n);
        break;
      case 4:
        j = a.g(paramParcel, n);
        break;
      case 5:
        bool = a.c(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new gt(m, str, k, j, bool);
  }

  public gt[] v(int paramInt)
  {
    return new gt[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gu
 * JD-Core Version:    0.6.2
 */