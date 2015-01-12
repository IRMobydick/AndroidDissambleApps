package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class lt
  implements Parcelable.Creator<ls>
{
  static void a(ls paramls, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1, paramls.uid);
    b.c(paramParcel, 1000, paramls.getVersionCode());
    b.a(paramParcel, 2, paramls.packageName, false);
    b.H(paramParcel, i);
  }

  public ls cu(Parcel paramParcel)
  {
    int i = 0;
    int j = a.C(paramParcel);
    String str = null;
    int k = 0;
    while (paramParcel.dataPosition() < j)
    {
      int m = a.B(paramParcel);
      switch (a.aD(m))
      {
      default:
        a.b(paramParcel, m);
        break;
      case 1:
        i = a.g(paramParcel, m);
        break;
      case 1000:
        k = a.g(paramParcel, m);
        break;
      case 2:
        str = a.o(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    return new ls(k, i, str);
  }

  public ls[] ei(int paramInt)
  {
    return new ls[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.lt
 * JD-Core Version:    0.6.2
 */