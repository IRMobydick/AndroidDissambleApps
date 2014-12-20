package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class jb
  implements Parcelable.Creator
{
  static void a(fp paramfp, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramfp.c, false);
    c.a(paramParcel, 1000, paramfp.b);
    c.a(paramParcel, 2, paramfp.d, false);
    c.a(paramParcel, 3, paramfp.e);
    c.a(paramParcel, 4, paramfp.f);
    c.a(paramParcel, 5, paramfp.g);
    c.a(paramParcel, 6, paramfp.h, false);
    c.a(paramParcel, 7, paramfp.i, paramInt, false);
    c.a(paramParcel, 8, paramfp.j, false);
    c.a(paramParcel, 11, paramfp.k, false);
    c.a(paramParcel, i);
  }

  public fp a(Parcel paramParcel)
  {
    boolean bool1 = false;
    String str1 = null;
    int i = a.b(paramParcel);
    int j = 1;
    int[] arrayOfInt = null;
    fm[] arrayOffm = null;
    String str2 = null;
    boolean bool2 = false;
    String str3 = null;
    String str4 = null;
    int k = 0;
    while (paramParcel.dataPosition() < i)
    {
      int m = a.a(paramParcel);
      switch (a.a(m))
      {
      default:
        a.b(paramParcel, m);
        break;
      case 1:
        str4 = a.o(paramParcel, m);
        break;
      case 1000:
        k = a.g(paramParcel, m);
        break;
      case 2:
        str3 = a.o(paramParcel, m);
        break;
      case 3:
        bool2 = a.c(paramParcel, m);
        break;
      case 4:
        j = a.g(paramParcel, m);
        break;
      case 5:
        bool1 = a.c(paramParcel, m);
        break;
      case 6:
        str2 = a.o(paramParcel, m);
        break;
      case 7:
        arrayOffm = (fm[])a.b(paramParcel, m, fm.a);
        break;
      case 8:
        arrayOfInt = a.u(paramParcel, m);
        break;
      case 11:
        str1 = a.o(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new fp(k, str4, str3, bool2, j, bool1, str2, arrayOffm, arrayOfInt, str1);
  }

  public fp[] a(int paramInt)
  {
    return new fp[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jb
 * JD-Core Version:    0.6.0
 */