package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class n
  implements Parcelable.Creator
{
  static void a(StreetViewPanoramaOrientation paramStreetViewPanoramaOrientation, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramStreetViewPanoramaOrientation.a());
    c.a(paramParcel, 2, paramStreetViewPanoramaOrientation.b);
    c.a(paramParcel, 3, paramStreetViewPanoramaOrientation.c);
    c.a(paramParcel, i);
  }

  public StreetViewPanoramaOrientation a(Parcel paramParcel)
  {
    float f1 = 0.0F;
    int i = a.b(paramParcel);
    int j = 0;
    float f2 = 0.0F;
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
        f1 = a.l(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new StreetViewPanoramaOrientation(j, f2, f1);
  }

  public StreetViewPanoramaOrientation[] a(int paramInt)
  {
    return new StreetViewPanoramaOrientation[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.n
 * JD-Core Version:    0.6.0
 */