package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class im
  implements Parcelable.Creator<il>
{
  static void a(il paramil, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1, paramil.getVersionCode());
    b.a(paramParcel, 2, paramil.fE());
    b.a(paramParcel, 3, paramil.fM());
    b.c(paramParcel, 4, paramil.fN());
    b.a(paramParcel, 5, paramil.getApplicationMetadata(), paramInt, false);
    b.c(paramParcel, 6, paramil.fO());
    b.H(paramParcel, i);
  }

  public il[] ah(int paramInt)
  {
    return new il[paramInt];
  }

  public il x(Parcel paramParcel)
  {
    int i = 0;
    int j = a.C(paramParcel);
    double d = 0.0D;
    ApplicationMetadata localApplicationMetadata = null;
    int k = 0;
    boolean bool = false;
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
        m = a.g(paramParcel, n);
        break;
      case 2:
        d = a.m(paramParcel, n);
        break;
      case 3:
        bool = a.c(paramParcel, n);
        break;
      case 4:
        k = a.g(paramParcel, n);
        break;
      case 5:
        localApplicationMetadata = (ApplicationMetadata)a.a(paramParcel, n, ApplicationMetadata.CREATOR);
        break;
      case 6:
        i = a.g(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    return new il(m, d, bool, k, localApplicationMetadata, i);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.im
 * JD-Core Version:    0.6.2
 */