package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class md
  implements Parcelable.Creator<mc>
{
  static void a(mc parammc, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.a(paramParcel, 1, parammc.getRequestId(), false);
    b.c(paramParcel, 1000, parammc.getVersionCode());
    b.a(paramParcel, 2, parammc.getExpirationTime());
    b.a(paramParcel, 3, parammc.ma());
    b.a(paramParcel, 4, parammc.getLatitude());
    b.a(paramParcel, 5, parammc.getLongitude());
    b.a(paramParcel, 6, parammc.mb());
    b.c(paramParcel, 7, parammc.mc());
    b.c(paramParcel, 8, parammc.getNotificationResponsiveness());
    b.c(paramParcel, 9, parammc.md());
    b.H(paramParcel, i);
  }

  public mc cw(Parcel paramParcel)
  {
    int i = a.C(paramParcel);
    int j = 0;
    String str = null;
    int k = 0;
    short s = 0;
    double d1 = 0.0D;
    double d2 = 0.0D;
    float f = 0.0F;
    long l = 0L;
    int m = 0;
    int n = -1;
    while (paramParcel.dataPosition() < i)
    {
      int i1 = a.B(paramParcel);
      switch (a.aD(i1))
      {
      default:
        a.b(paramParcel, i1);
        break;
      case 1:
        str = a.o(paramParcel, i1);
        break;
      case 1000:
        j = a.g(paramParcel, i1);
        break;
      case 2:
        l = a.i(paramParcel, i1);
        break;
      case 3:
        s = a.f(paramParcel, i1);
        break;
      case 4:
        d1 = a.m(paramParcel, i1);
        break;
      case 5:
        d2 = a.m(paramParcel, i1);
        break;
      case 6:
        f = a.l(paramParcel, i1);
        break;
      case 7:
        k = a.g(paramParcel, i1);
        break;
      case 8:
        m = a.g(paramParcel, i1);
        break;
      case 9:
        n = a.g(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new mc(j, str, k, s, d1, d2, f, l, m, n);
  }

  public mc[] em(int paramInt)
  {
    return new mc[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.md
 * JD-Core Version:    0.6.2
 */