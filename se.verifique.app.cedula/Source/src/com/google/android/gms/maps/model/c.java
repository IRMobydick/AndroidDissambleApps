package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c
  implements Parcelable.Creator
{
  static void a(CircleOptions paramCircleOptions, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.c.a(paramParcel);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 1, paramCircleOptions.a());
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 2, paramCircleOptions.b(), paramInt, false);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 3, paramCircleOptions.c());
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 4, paramCircleOptions.d());
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 5, paramCircleOptions.e());
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 6, paramCircleOptions.f());
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 7, paramCircleOptions.g());
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 8, paramCircleOptions.h());
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, i);
  }

  public CircleOptions a(Parcel paramParcel)
  {
    float f1 = 0.0F;
    boolean bool = false;
    int i = a.b(paramParcel);
    LatLng localLatLng = null;
    double d = 0.0D;
    int j = 0;
    int k = 0;
    float f2 = 0.0F;
    int m = 0;
    while (paramParcel.dataPosition() < i)
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
      case 2:
        localLatLng = (LatLng)a.a(paramParcel, n, LatLng.a);
        break;
      case 3:
        d = a.m(paramParcel, n);
        break;
      case 4:
        f2 = a.l(paramParcel, n);
        break;
      case 5:
        k = a.g(paramParcel, n);
        break;
      case 6:
        j = a.g(paramParcel, n);
        break;
      case 7:
        f1 = a.l(paramParcel, n);
        break;
      case 8:
        bool = a.c(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new CircleOptions(m, localLatLng, d, f2, k, j, f1, bool);
  }

  public CircleOptions[] a(int paramInt)
  {
    return new CircleOptions[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.c
 * JD-Core Version:    0.6.0
 */