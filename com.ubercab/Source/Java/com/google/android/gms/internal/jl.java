package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class jl
  implements Parcelable.Creator<jm.b>
{
  static void a(jm.b paramb, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1, paramb.versionCode);
    b.a(paramParcel, 2, paramb.fv, false);
    b.a(paramParcel, 3, paramb.MM, paramInt, false);
    b.H(paramParcel, i);
  }

  public jm.b J(Parcel paramParcel)
  {
    ji.a locala = null;
    int i = a.C(paramParcel);
    int j = 0;
    String str = null;
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
        str = a.o(paramParcel, k);
        break;
      case 3:
        locala = (ji.a)a.a(paramParcel, k, ji.a.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new jm.b(j, str, locala);
  }

  public jm.b[] aJ(int paramInt)
  {
    return new jm.b[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jl
 * JD-Core Version:    0.6.2
 */