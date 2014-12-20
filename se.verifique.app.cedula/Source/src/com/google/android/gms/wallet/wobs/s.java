package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class s
  implements Parcelable.Creator
{
  static void a(p paramp, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramp.a());
    c.a(paramParcel, 2, paramp.a, false);
    c.a(paramParcel, 3, paramp.b, false);
    c.a(paramParcel, 4, paramp.c, paramInt, false);
    c.a(paramParcel, 5, paramp.d, paramInt, false);
    c.a(paramParcel, 6, paramp.e, paramInt, false);
    c.a(paramParcel, i);
  }

  public p a(Parcel paramParcel)
  {
    n localn1 = null;
    int i = a.b(paramParcel);
    int j = 0;
    n localn2 = null;
    l locall = null;
    String str1 = null;
    String str2 = null;
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
        str2 = a.o(paramParcel, k);
        break;
      case 3:
        str1 = a.o(paramParcel, k);
        break;
      case 4:
        locall = (l)a.a(paramParcel, k, l.CREATOR);
        break;
      case 5:
        localn2 = (n)a.a(paramParcel, k, n.CREATOR);
        break;
      case 6:
        localn1 = (n)a.a(paramParcel, k, n.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new p(j, str2, str1, locall, localn2, localn1);
  }

  public p[] a(int paramInt)
  {
    return new p[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.wobs.s
 * JD-Core Version:    0.6.0
 */