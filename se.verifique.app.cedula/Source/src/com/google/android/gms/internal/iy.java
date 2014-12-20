package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class iy
  implements Parcelable.Creator
{
  static void a(fk paramfk, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramfk.d, false);
    c.a(paramParcel, 1000, paramfk.c);
    c.a(paramParcel, 3, paramfk.e, paramInt, false);
    c.a(paramParcel, 4, paramfk.f);
    c.a(paramParcel, 5, paramfk.g, false);
    c.a(paramParcel, i);
  }

  public fk a(Parcel paramParcel)
  {
    byte[] arrayOfByte = null;
    int i = a.b(paramParcel);
    int j = 0;
    int k = -1;
    fp localfp = null;
    String str = null;
    while (paramParcel.dataPosition() < i)
    {
      int m = a.a(paramParcel);
      switch (a.a(m))
      {
      default:
        a.b(paramParcel, m);
        break;
      case 1:
        str = a.o(paramParcel, m);
        break;
      case 1000:
        j = a.g(paramParcel, m);
        break;
      case 3:
        localfp = (fp)a.a(paramParcel, m, fp.a);
        break;
      case 4:
        k = a.g(paramParcel, m);
        break;
      case 5:
        arrayOfByte = a.r(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new fk(j, str, localfp, k, arrayOfByte);
  }

  public fk[] a(int paramInt)
  {
    return new fk[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.iy
 * JD-Core Version:    0.6.0
 */