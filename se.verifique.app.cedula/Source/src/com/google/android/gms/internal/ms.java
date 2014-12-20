package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class ms
  implements Parcelable.Creator
{
  static void a(jq paramjq, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1000, paramjq.c);
    c.a(paramParcel, 2, paramjq.a(), paramInt, false);
    c.a(paramParcel, 3, paramjq.b());
    c.a(paramParcel, 4, paramjq.c());
    c.a(paramParcel, i);
  }

  public jq a(Parcel paramParcel)
  {
    int i = a.b(paramParcel);
    int j = 0;
    jm localjm = null;
    long l = jq.b;
    int k = 102;
    while (paramParcel.dataPosition() < i)
    {
      int m = a.a(paramParcel);
      switch (a.a(m))
      {
      default:
        a.b(paramParcel, m);
        break;
      case 1000:
        j = a.g(paramParcel, m);
        break;
      case 2:
        localjm = (jm)a.a(paramParcel, m, jm.a);
        break;
      case 3:
        l = a.i(paramParcel, m);
        break;
      case 4:
        k = a.g(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new jq(j, localjm, l, k);
  }

  public jq[] a(int paramInt)
  {
    return new jq[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ms
 * JD-Core Version:    0.6.0
 */