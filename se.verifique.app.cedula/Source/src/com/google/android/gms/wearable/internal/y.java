package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class y
  implements Parcelable.Creator
{
  static void a(v paramv, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramv.a);
    c.a(paramParcel, 2, paramv.b);
    c.a(paramParcel, 3, paramv.c, paramInt, false);
    c.a(paramParcel, i);
  }

  public v a(Parcel paramParcel)
  {
    int i = 0;
    int j = a.b(paramParcel);
    m localm = null;
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
        k = a.g(paramParcel, m);
        break;
      case 2:
        i = a.g(paramParcel, m);
        break;
      case 3:
        localm = (m)a.a(paramParcel, m, m.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new b("Overread allowed size end=" + j, paramParcel);
    return new v(k, i, localm);
  }

  public v[] a(int paramInt)
  {
    return new v[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.y
 * JD-Core Version:    0.6.0
 */