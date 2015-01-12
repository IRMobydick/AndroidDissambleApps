package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class mi
  implements Parcelable.Creator<mh>
{
  static void a(mh parammh, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1, parammh.mc());
    b.c(paramParcel, 1000, parammh.getVersionCode());
    b.c(paramParcel, 2, parammh.mg());
    b.a(paramParcel, 3, parammh.mh(), paramInt, false);
    b.H(paramParcel, i);
  }

  public mh cy(Parcel paramParcel)
  {
    int i = 0;
    int j = a.C(paramParcel);
    int k = -1;
    mj localmj = null;
    int m = 0;
    while (paramParcel.dataPosition() < j)
    {
      int n = a.B(paramParcel);
      switch (a.aD(n))
      {
      default:
        a.b(paramParcel, n);
        break;
      case 1:
        i = a.g(paramParcel, n);
        break;
      case 1000:
        m = a.g(paramParcel, n);
        break;
      case 2:
        k = a.g(paramParcel, n);
        break;
      case 3:
        localmj = (mj)a.a(paramParcel, n, mj.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    return new mh(m, i, k, localmj);
  }

  public mh[] eo(int paramInt)
  {
    return new mh[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.mi
 * JD-Core Version:    0.6.2
 */