package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;

public class e
  implements Parcelable.Creator
{
  static void a(b paramb, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramb.a);
    c.a(paramParcel, 1000, paramb.a());
    c.a(paramParcel, 2, paramb.b);
    c.a(paramParcel, 3, paramb.c);
    c.a(paramParcel, i);
  }

  public b a(Parcel paramParcel)
  {
    int i = 1;
    int j = a.b(paramParcel);
    int k = 0;
    long l = 0L;
    int m = i;
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
      case 1000:
        k = a.g(paramParcel, n);
        break;
      case 2:
        i = a.g(paramParcel, n);
        break;
      case 3:
        l = a.i(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + j, paramParcel);
    return new b(k, m, i, l);
  }

  public b[] a(int paramInt)
  {
    return new b[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.e
 * JD-Core Version:    0.6.0
 */