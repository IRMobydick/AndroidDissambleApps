package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class mo
  implements Parcelable.Creator
{
  static void a(jh paramjh, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramjh.f(), false);
    c.a(paramParcel, 1000, paramjh.a());
    c.a(paramParcel, 2, paramjh.g());
    c.a(paramParcel, 3, paramjh.b());
    c.a(paramParcel, 4, paramjh.c());
    c.a(paramParcel, 5, paramjh.d());
    c.a(paramParcel, 6, paramjh.e());
    c.a(paramParcel, 7, paramjh.h());
    c.a(paramParcel, 8, paramjh.i());
    c.a(paramParcel, 9, paramjh.j());
    c.a(paramParcel, i);
  }

  public jh a(Parcel paramParcel)
  {
    int i = a.b(paramParcel);
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
      int i1 = a.a(paramParcel);
      switch (a.a(i1))
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
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new jh(j, str, k, s, d1, d2, f, l, m, n);
  }

  public jh[] a(int paramInt)
  {
    return new jh[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.mo
 * JD-Core Version:    0.6.0
 */