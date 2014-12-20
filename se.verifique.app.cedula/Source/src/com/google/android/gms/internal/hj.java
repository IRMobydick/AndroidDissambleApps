package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class hj
  implements Parcelable.Creator
{
  static void a(ev paramev, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramev.b);
    c.a(paramParcel, 2, paramev.c, false);
    c.a(paramParcel, 3, paramev.d);
    c.a(paramParcel, 4, paramev.e);
    c.a(paramParcel, 5, paramev.f);
    c.a(paramParcel, i);
  }

  public ev a(Parcel paramParcel)
  {
    boolean bool = false;
    int i = a.b(paramParcel);
    String str = null;
    int j = 0;
    int k = 0;
    int m = 0;
    while (paramParcel.dataPosition() < i)
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
        str = a.o(paramParcel, n);
        break;
      case 3:
        k = a.g(paramParcel, n);
        break;
      case 4:
        j = a.g(paramParcel, n);
        break;
      case 5:
        bool = a.c(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new ev(m, str, k, j, bool);
  }

  public ev[] a(int paramInt)
  {
    return new ev[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hj
 * JD-Core Version:    0.6.0
 */