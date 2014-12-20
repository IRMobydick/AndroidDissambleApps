package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class j
  implements Parcelable.Creator
{
  static void a(StreetViewPanoramaCamera paramStreetViewPanoramaCamera, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramStreetViewPanoramaCamera.a());
    c.a(paramParcel, 2, paramStreetViewPanoramaCamera.b);
    c.a(paramParcel, 3, paramStreetViewPanoramaCamera.c);
    c.a(paramParcel, 4, paramStreetViewPanoramaCamera.d);
    c.a(paramParcel, i);
  }

  public StreetViewPanoramaCamera a(Parcel paramParcel)
  {
    float f1 = 0.0F;
    int i = a.b(paramParcel);
    float f2 = 0.0F;
    int j = 0;
    float f3 = 0.0F;
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
        f2 = a.l(paramParcel, k);
        break;
      case 3:
        f3 = a.l(paramParcel, k);
        break;
      case 4:
        f1 = a.l(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new StreetViewPanoramaCamera(j, f2, f3, f1);
  }

  public StreetViewPanoramaCamera[] a(int paramInt)
  {
    return new StreetViewPanoramaCamera[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.j
 * JD-Core Version:    0.6.0
 */