package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.maps.model.CameraPosition;

public class a
  implements Parcelable.Creator
{
  static void a(GoogleMapOptions paramGoogleMapOptions, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramGoogleMapOptions.a());
    c.a(paramParcel, 2, paramGoogleMapOptions.b());
    c.a(paramParcel, 3, paramGoogleMapOptions.c());
    c.a(paramParcel, 4, paramGoogleMapOptions.j());
    c.a(paramParcel, 5, paramGoogleMapOptions.k(), paramInt, false);
    c.a(paramParcel, 6, paramGoogleMapOptions.d());
    c.a(paramParcel, 7, paramGoogleMapOptions.e());
    c.a(paramParcel, 8, paramGoogleMapOptions.f());
    c.a(paramParcel, 9, paramGoogleMapOptions.g());
    c.a(paramParcel, 10, paramGoogleMapOptions.h());
    c.a(paramParcel, 11, paramGoogleMapOptions.i());
    c.a(paramParcel, i);
  }

  public GoogleMapOptions a(Parcel paramParcel)
  {
    byte b1 = 0;
    int i = com.google.android.gms.common.internal.safeparcel.a.b(paramParcel);
    CameraPosition localCameraPosition = null;
    byte b2 = 0;
    byte b3 = 0;
    byte b4 = 0;
    byte b5 = 0;
    byte b6 = 0;
    int j = 0;
    byte b7 = 0;
    byte b8 = 0;
    int k = 0;
    while (paramParcel.dataPosition() < i)
    {
      int m = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.a(m))
      {
      default:
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, m);
        break;
      case 1:
        k = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, m);
        break;
      case 2:
        b8 = com.google.android.gms.common.internal.safeparcel.a.e(paramParcel, m);
        break;
      case 3:
        b7 = com.google.android.gms.common.internal.safeparcel.a.e(paramParcel, m);
        break;
      case 4:
        j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, m);
        break;
      case 5:
        localCameraPosition = (CameraPosition)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, m, CameraPosition.a);
        break;
      case 6:
        b6 = com.google.android.gms.common.internal.safeparcel.a.e(paramParcel, m);
        break;
      case 7:
        b5 = com.google.android.gms.common.internal.safeparcel.a.e(paramParcel, m);
        break;
      case 8:
        b4 = com.google.android.gms.common.internal.safeparcel.a.e(paramParcel, m);
        break;
      case 9:
        b3 = com.google.android.gms.common.internal.safeparcel.a.e(paramParcel, m);
        break;
      case 10:
        b2 = com.google.android.gms.common.internal.safeparcel.a.e(paramParcel, m);
        break;
      case 11:
        b1 = com.google.android.gms.common.internal.safeparcel.a.e(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new GoogleMapOptions(k, b8, b7, j, localCameraPosition, b6, b5, b4, b3, b2, b1);
  }

  public GoogleMapOptions[] a(int paramInt)
  {
    return new GoogleMapOptions[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.a
 * JD-Core Version:    0.6.0
 */