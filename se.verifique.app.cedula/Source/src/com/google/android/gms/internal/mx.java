package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class mx
  implements Parcelable.Creator
{
  static void a(ka paramka, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramka.c, false);
    c.a(paramParcel, 1000, paramka.b);
    c.a(paramParcel, 2, paramka.d, false);
    c.a(paramParcel, i);
  }

  public ka a(Parcel paramParcel)
  {
    String str1 = null;
    int i = a.b(paramParcel);
    int j = 0;
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
        str2 = a.o(paramParcel, k);
        break;
      case 1000:
        j = a.g(paramParcel, k);
        break;
      case 2:
        str1 = a.o(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new ka(j, str2, str1);
  }

  public ka[] a(int paramInt)
  {
    return new ka[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.mx
 * JD-Core Version:    0.6.0
 */