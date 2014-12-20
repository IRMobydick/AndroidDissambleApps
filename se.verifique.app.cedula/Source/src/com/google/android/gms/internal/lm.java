package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class lm
  implements Parcelable.Creator
{
  static void a(ie paramie, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramie.a());
    c.a(paramParcel, 2, paramie.e(), false);
    c.a(paramParcel, 3, paramie.f(), paramInt, false);
    c.a(paramParcel, i);
  }

  public ie a(Parcel paramParcel)
  {
    ib localib = null;
    int i = a.b(paramParcel);
    int j = 0;
    Parcel localParcel = null;
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
        localParcel = a.C(paramParcel, k);
        break;
      case 3:
        localib = (ib)a.a(paramParcel, k, ib.a);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new ie(j, localParcel, localib);
  }

  public ie[] a(int paramInt)
  {
    return new ie[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.lm
 * JD-Core Version:    0.6.0
 */