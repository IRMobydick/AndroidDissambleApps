package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class jc
  implements Parcelable.Creator
{
  static void a(fr paramfr, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramfr.c, paramInt, false);
    c.a(paramParcel, 1000, paramfr.b);
    c.a(paramParcel, 2, paramfr.d);
    c.a(paramParcel, 3, paramfr.e);
    c.a(paramParcel, 4, paramfr.f, false);
    c.a(paramParcel, 5, paramfr.g, paramInt, false);
    c.a(paramParcel, i);
  }

  public fr a(Parcel paramParcel)
  {
    int i = 0;
    fg localfg = null;
    int j = a.b(paramParcel);
    long l = 0L;
    String str = null;
    fi localfi = null;
    int k = 0;
    while (paramParcel.dataPosition() < j)
    {
      int m = a.a(paramParcel);
      switch (a.a(m))
      {
      default:
        a.b(paramParcel, m);
        break;
      case 1:
        localfi = (fi)a.a(paramParcel, m, fi.a);
        break;
      case 1000:
        k = a.g(paramParcel, m);
        break;
      case 2:
        l = a.i(paramParcel, m);
        break;
      case 3:
        i = a.g(paramParcel, m);
        break;
      case 4:
        str = a.o(paramParcel, m);
        break;
      case 5:
        localfg = (fg)a.a(paramParcel, m, fg.a);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new b("Overread allowed size end=" + j, paramParcel);
    return new fr(k, localfi, l, i, str, localfg);
  }

  public fr[] a(int paramInt)
  {
    return new fr[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jc
 * JD-Core Version:    0.6.0
 */