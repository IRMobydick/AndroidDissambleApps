package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class mg
  implements Parcelable.Creator<mf>
{
  static void a(mf parammf, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.a(paramParcel, 1, parammf.me());
    b.c(paramParcel, 1000, parammf.BR);
    b.c(paramParcel, 2, parammf.mf(), false);
    b.H(paramParcel, i);
  }

  public mf cx(Parcel paramParcel)
  {
    boolean bool = false;
    int i = a.C(paramParcel);
    ArrayList localArrayList = null;
    int j = 0;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.B(paramParcel);
      switch (a.aD(k))
      {
      default:
        a.b(paramParcel, k);
        break;
      case 1:
        bool = a.c(paramParcel, k);
        break;
      case 1000:
        j = a.g(paramParcel, k);
        break;
      case 2:
        localArrayList = a.c(paramParcel, k, mp.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new mf(j, bool, localArrayList);
  }

  public mf[] en(int paramInt)
  {
    return new mf[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.mg
 * JD-Core Version:    0.6.2
 */