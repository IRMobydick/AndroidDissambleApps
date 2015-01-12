package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class oo
  implements Parcelable.Creator<on>
{
  static void a(on paramon, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1, paramon.getVersionCode());
    b.a(paramParcel, 2, paramon.atN, false);
    b.H(paramParcel, i);
  }

  public on dB(Parcel paramParcel)
  {
    int i = a.C(paramParcel);
    int j = 0;
    int[] arrayOfInt = null;
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
        arrayOfInt = a.u(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new on(j, arrayOfInt);
  }

  public on[] fC(int paramInt)
  {
    return new on[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.oo
 * JD-Core Version:    0.6.2
 */