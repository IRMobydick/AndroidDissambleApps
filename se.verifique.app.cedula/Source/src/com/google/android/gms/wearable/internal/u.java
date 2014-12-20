package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class u
  implements Parcelable.Creator
{
  static void a(r paramr, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.c.a(paramParcel);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 1, paramr.a);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 2, paramr.b);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 3, paramr.c, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, i);
  }

  public r a(Parcel paramParcel)
  {
    int i = 0;
    int j = a.b(paramParcel);
    com.google.android.gms.wearable.c localc = null;
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
        localc = (com.google.android.gms.wearable.c)a.a(paramParcel, m, com.google.android.gms.wearable.c.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new b("Overread allowed size end=" + j, paramParcel);
    return new r(k, i, localc);
  }

  public r[] a(int paramInt)
  {
    return new r[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.u
 * JD-Core Version:    0.6.0
 */