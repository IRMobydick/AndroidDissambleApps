package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class la
  implements Parcelable.Creator
{
  static void a(ht paramht, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramht.a());
    c.a(paramParcel, 2, paramht.b(), paramInt, false);
    c.a(paramParcel, i);
  }

  public ht a(Parcel paramParcel)
  {
    int i = a.b(paramParcel);
    int j = 0;
    hv localhv = null;
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
        localhv = (hv)a.a(paramParcel, k, hv.a);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new ht(j, localhv);
  }

  public ht[] a(int paramInt)
  {
    return new ht[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.la
 * JD-Core Version:    0.6.0
 */