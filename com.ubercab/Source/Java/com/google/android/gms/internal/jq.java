package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class jq
  implements Parcelable.Creator<jp>
{
  static void a(jp paramjp, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1, paramjp.getVersionCode());
    b.a(paramParcel, 2, paramjp.hx(), false);
    b.a(paramParcel, 3, paramjp.hy(), paramInt, false);
    b.H(paramParcel, i);
  }

  public jp M(Parcel paramParcel)
  {
    jm localjm = null;
    int i = a.C(paramParcel);
    int j = 0;
    Parcel localParcel = null;
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
        localParcel = a.D(paramParcel, k);
        break;
      case 3:
        localjm = (jm)a.a(paramParcel, k, jm.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new jp(j, localParcel, localjm);
  }

  public jp[] aM(int paramInt)
  {
    return new jp[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jq
 * JD-Core Version:    0.6.2
 */