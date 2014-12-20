package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class mp
  implements Parcelable.Creator
{
  static void a(jk paramjk, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramjk.b());
    c.a(paramParcel, 1000, paramjk.a());
    c.a(paramParcel, 2, paramjk.c());
    c.a(paramParcel, 3, paramjk.d(), paramInt, false);
    c.a(paramParcel, i);
  }

  public jk a(Parcel paramParcel)
  {
    int i = 0;
    int j = a.b(paramParcel);
    int k = -1;
    jm localjm = null;
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
        i = a.g(paramParcel, n);
        break;
      case 1000:
        m = a.g(paramParcel, n);
        break;
      case 2:
        k = a.g(paramParcel, n);
        break;
      case 3:
        localjm = (jm)a.a(paramParcel, n, jm.a);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new b("Overread allowed size end=" + j, paramParcel);
    return new jk(m, i, k, localjm);
  }

  public jk[] a(int paramInt)
  {
    return new jk[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.mp
 * JD-Core Version:    0.6.0
 */