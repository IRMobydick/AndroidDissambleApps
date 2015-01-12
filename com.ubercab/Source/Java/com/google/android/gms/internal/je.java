package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class je
  implements Parcelable.Creator<jd>
{
  static void a(jd paramjd, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1, paramjd.getVersionCode());
    b.a(paramParcel, 2, paramjd.ha(), paramInt, false);
    b.H(paramParcel, i);
  }

  public jd F(Parcel paramParcel)
  {
    int i = a.C(paramParcel);
    int j = 0;
    jf localjf = null;
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
        localjf = (jf)a.a(paramParcel, k, jf.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new jd(j, localjf);
  }

  public jd[] aF(int paramInt)
  {
    return new jd[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.je
 * JD-Core Version:    0.6.2
 */