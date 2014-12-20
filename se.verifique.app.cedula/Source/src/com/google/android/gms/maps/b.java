package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public class b
  implements Parcelable.Creator
{
  static void a(StreetViewPanoramaOptions paramStreetViewPanoramaOptions, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramStreetViewPanoramaOptions.a());
    c.a(paramParcel, 2, paramStreetViewPanoramaOptions.g(), paramInt, false);
    c.a(paramParcel, 3, paramStreetViewPanoramaOptions.j(), false);
    c.a(paramParcel, 4, paramStreetViewPanoramaOptions.h(), paramInt, false);
    c.a(paramParcel, 5, paramStreetViewPanoramaOptions.i(), false);
    c.a(paramParcel, 6, paramStreetViewPanoramaOptions.b());
    c.a(paramParcel, 7, paramStreetViewPanoramaOptions.c());
    c.a(paramParcel, 8, paramStreetViewPanoramaOptions.d());
    c.a(paramParcel, 9, paramStreetViewPanoramaOptions.e());
    c.a(paramParcel, 10, paramStreetViewPanoramaOptions.f());
    c.a(paramParcel, i);
  }

  public StreetViewPanoramaOptions a(Parcel paramParcel)
  {
    Integer localInteger = null;
    byte b1 = 0;
    int i = a.b(paramParcel);
    byte b2 = 0;
    byte b3 = 0;
    byte b4 = 0;
    byte b5 = 0;
    LatLng localLatLng = null;
    String str = null;
    StreetViewPanoramaCamera localStreetViewPanoramaCamera = null;
    int j = 0;
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
        localStreetViewPanoramaCamera = (StreetViewPanoramaCamera)a.a(paramParcel, k, StreetViewPanoramaCamera.a);
        break;
      case 3:
        str = a.o(paramParcel, k);
        break;
      case 4:
        localLatLng = (LatLng)a.a(paramParcel, k, LatLng.a);
        break;
      case 5:
        localInteger = a.h(paramParcel, k);
        break;
      case 6:
        b5 = a.e(paramParcel, k);
        break;
      case 7:
        b4 = a.e(paramParcel, k);
        break;
      case 8:
        b3 = a.e(paramParcel, k);
        break;
      case 9:
        b2 = a.e(paramParcel, k);
        break;
      case 10:
        b1 = a.e(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + i, paramParcel);
    return new StreetViewPanoramaOptions(j, localStreetViewPanoramaCamera, str, localLatLng, localInteger, b5, b4, b3, b2, b1);
  }

  public StreetViewPanoramaOptions[] a(int paramInt)
  {
    return new StreetViewPanoramaOptions[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.b
 * JD-Core Version:    0.6.0
 */