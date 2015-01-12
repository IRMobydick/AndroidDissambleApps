package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class y
  implements Parcelable.Creator<x>
{
  static void a(x paramx, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1, paramx.versionCode);
    b.a(paramParcel, 2, paramx.lX);
    b.a(paramParcel, 3, paramx.mh);
    b.H(paramParcel, i);
  }

  public x a(Parcel paramParcel)
  {
    boolean bool1 = false;
    int i = a.C(paramParcel);
    boolean bool2 = false;
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
        j = a.g(paramParcel, k);
        break;
      case 2:
        bool2 = a.c(paramParcel, k);
        break;
      case 3:
        bool1 = a.c(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new x(j, bool2, bool1);
  }

  public x[] b(int paramInt)
  {
    return new x[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.y
 * JD-Core Version:    0.6.2
 */