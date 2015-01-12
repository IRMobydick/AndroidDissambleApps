package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class mo
  implements Parcelable.Creator<mn>
{
  static void a(mn parammn, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1000, parammn.BR);
    b.a(paramParcel, 2, parammn.mh(), paramInt, false);
    b.a(paramParcel, 3, parammn.getInterval());
    b.c(paramParcel, 4, parammn.getPriority());
    b.H(paramParcel, i);
  }

  public mn cB(Parcel paramParcel)
  {
    int i = a.C(paramParcel);
    int j = 0;
    mj localmj = null;
    long l = mn.afA;
    int k = 102;
    while (paramParcel.dataPosition() < i)
    {
      int m = a.B(paramParcel);
      switch (a.aD(m))
      {
      default:
        a.b(paramParcel, m);
        break;
      case 1000:
        j = a.g(paramParcel, m);
        break;
      case 2:
        localmj = (mj)a.a(paramParcel, m, mj.CREATOR);
        break;
      case 3:
        l = a.i(paramParcel, m);
        break;
      case 4:
        k = a.g(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new mn(j, localmj, l, k);
  }

  public mn[] er(int paramInt)
  {
    return new mn[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.mo
 * JD-Core Version:    0.6.2
 */