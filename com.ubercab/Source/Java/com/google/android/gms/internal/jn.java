package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class jn
  implements Parcelable.Creator<jm>
{
  static void a(jm paramjm, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1, paramjm.getVersionCode());
    b.c(paramParcel, 2, paramjm.hu(), false);
    b.a(paramParcel, 3, paramjm.hv(), false);
    b.H(paramParcel, i);
  }

  public jm K(Parcel paramParcel)
  {
    String str = null;
    int i = a.C(paramParcel);
    int j = 0;
    ArrayList localArrayList = null;
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
        localArrayList = a.c(paramParcel, k, jm.a.CREATOR);
        break;
      case 3:
        str = a.o(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new jm(j, localArrayList, str);
  }

  public jm[] aK(int paramInt)
  {
    return new jm[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jn
 * JD-Core Version:    0.6.2
 */