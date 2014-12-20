package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class r
  implements Parcelable.Creator
{
  static void a(al paramal, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramal.b);
    c.a(paramParcel, 2, paramal.c, false);
    c.a(paramParcel, 3, paramal.d);
    c.a(paramParcel, 4, paramal.e);
    c.a(paramParcel, 5, paramal.f);
    c.a(paramParcel, 6, paramal.g);
    c.a(paramParcel, 7, paramal.h);
    c.a(paramParcel, 8, paramal.i, paramInt, false);
    c.a(paramParcel, i);
  }

  public al a(Parcel paramParcel)
  {
    al[] arrayOfal = null;
    int i = 0;
    int j = a.b(paramParcel);
    int k = 0;
    boolean bool = false;
    int m = 0;
    int n = 0;
    String str = null;
    int i1 = 0;
    while (paramParcel.dataPosition() < j)
    {
      int i2 = a.a(paramParcel);
      switch (a.a(i2))
      {
      default:
        a.b(paramParcel, i2);
        break;
      case 1:
        i1 = a.g(paramParcel, i2);
        break;
      case 2:
        str = a.o(paramParcel, i2);
        break;
      case 3:
        n = a.g(paramParcel, i2);
        break;
      case 4:
        m = a.g(paramParcel, i2);
        break;
      case 5:
        bool = a.c(paramParcel, i2);
        break;
      case 6:
        k = a.g(paramParcel, i2);
        break;
      case 7:
        i = a.g(paramParcel, i2);
        break;
      case 8:
        arrayOfal = (al[])a.b(paramParcel, i2, al.a);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new b("Overread allowed size end=" + j, paramParcel);
    return new al(i1, str, n, m, bool, k, i, arrayOfal);
  }

  public al[] a(int paramInt)
  {
    return new al[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.r
 * JD-Core Version:    0.6.0
 */