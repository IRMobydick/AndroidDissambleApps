package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class an
  implements Parcelable.Creator
{
  static void a(aw paramaw, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramaw.b);
    c.a(paramParcel, 2, paramaw.c);
    c.a(paramParcel, 3, paramaw.d);
    c.a(paramParcel, 4, paramaw.e);
    c.a(paramParcel, 5, paramaw.f);
    c.a(paramParcel, 6, paramaw.g);
    c.a(paramParcel, 7, paramaw.h);
    c.a(paramParcel, 8, paramaw.i);
    c.a(paramParcel, 9, paramaw.j);
    c.a(paramParcel, 10, paramaw.k, false);
    c.a(paramParcel, 11, paramaw.l);
    c.a(paramParcel, 12, paramaw.m, false);
    c.a(paramParcel, 13, paramaw.n);
    c.a(paramParcel, 14, paramaw.o);
    c.a(paramParcel, 15, paramaw.p, false);
    c.a(paramParcel, i);
  }

  public aw a(Parcel paramParcel)
  {
    int i = a.b(paramParcel);
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    String str1 = null;
    int i6 = 0;
    String str2 = null;
    int i7 = 0;
    int i8 = 0;
    String str3 = null;
    while (paramParcel.dataPosition() < i)
    {
      int i9 = a.a(paramParcel);
      switch (a.a(i9))
      {
      default:
        a.b(paramParcel, i9);
        break;
      case 1:
        j = a.g(paramParcel, i9);
        break;
      case 2:
        k = a.g(paramParcel, i9);
        break;
      case 3:
        m = a.g(paramParcel, i9);
        break;
      case 4:
        n = a.g(paramParcel, i9);
        break;
      case 5:
        i1 = a.g(paramParcel, i9);
        break;
      case 6:
        i2 = a.g(paramParcel, i9);
        break;
      case 7:
        i3 = a.g(paramParcel, i9);
        break;
      case 8:
        i4 = a.g(paramParcel, i9);
        break;
      case 9:
        i5 = a.g(paramParcel, i9);
        break;
      case 10:
        str1 = a.o(paramParcel, i9);
        break;
      case 11:
        i6 = a.g(paramParcel, i9);
        break;
      case 12:
        str2 = a.o(paramParcel, i9);
        break;
      case 13:
        i7 = a.g(paramParcel, i9);
        break;
      case 14:
        i8 = a.g(paramParcel, i9);
        break;
      case 15:
        str3 = a.o(paramParcel, i9);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new aw(j, k, m, n, i1, i2, i3, i4, i5, str1, i6, str2, i7, i8, str3);
  }

  public aw[] a(int paramInt)
  {
    return new aw[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.an
 * JD-Core Version:    0.6.0
 */