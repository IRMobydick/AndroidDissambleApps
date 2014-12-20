package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class lj
  implements Parcelable.Creator
{
  static void a(ib.b paramb, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramb.b);
    c.a(paramParcel, 2, paramb.c, false);
    c.a(paramParcel, 3, paramb.d, paramInt, false);
    c.a(paramParcel, i);
  }

  public ib.b a(Parcel paramParcel)
  {
    hy.a locala = null;
    int i = a.b(paramParcel);
    int j = 0;
    String str = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.a(paramParcel);
      switch (a.a(k))
      {
      default:
        a.b(paramParcel, k);
        break;
      case 1:
        j = a.g(paramParcel, k);
        break;
      case 2:
        str = a.o(paramParcel, k);
        break;
      case 3:
        locala = (hy.a)a.a(paramParcel, k, hy.a.i);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new ib.b(j, str, locala);
  }

  public ib.b[] a(int paramInt)
  {
    return new ib.b[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.lj
 * JD-Core Version:    0.6.0
 */