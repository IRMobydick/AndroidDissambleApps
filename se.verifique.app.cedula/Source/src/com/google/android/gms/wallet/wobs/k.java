package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class k
  implements Parcelable.Creator
{
  static void a(g paramg, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramg.a());
    c.a(paramParcel, 2, paramg.a);
    c.a(paramParcel, 3, paramg.b, false);
    c.a(paramParcel, 4, paramg.c);
    c.a(paramParcel, 5, paramg.d, false);
    c.a(paramParcel, 6, paramg.e);
    c.a(paramParcel, 7, paramg.f);
    c.a(paramParcel, i);
  }

  public g a(Parcel paramParcel)
  {
    String str1 = null;
    int i = 0;
    int j = a.b(paramParcel);
    double d = 0.0D;
    long l = 0L;
    int k = -1;
    String str2 = null;
    int m = 0;
    while (paramParcel.dataPosition() < j)
    {
      int n = a.a(paramParcel);
      switch (a.a(n))
      {
      default:
        a.b(paramParcel, n);
        break;
      case 1:
        m = a.g(paramParcel, n);
        break;
      case 2:
        i = a.g(paramParcel, n);
        break;
      case 3:
        str2 = a.o(paramParcel, n);
        break;
      case 4:
        d = a.m(paramParcel, n);
        break;
      case 5:
        str1 = a.o(paramParcel, n);
        break;
      case 6:
        l = a.i(paramParcel, n);
        break;
      case 7:
        k = a.g(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new b("Overread allowed size end=" + j, paramParcel);
    return new g(m, i, str2, d, str1, l, k);
  }

  public g[] a(int paramInt)
  {
    return new g[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.wobs.k
 * JD-Core Version:    0.6.0
 */