package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class t
  implements Parcelable.Creator<StreetViewPanoramaOrientation>
{
  static void a(StreetViewPanoramaOrientation paramStreetViewPanoramaOrientation, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1, paramStreetViewPanoramaOrientation.getVersionCode());
    b.a(paramParcel, 2, paramStreetViewPanoramaOrientation.tilt);
    b.a(paramParcel, 3, paramStreetViewPanoramaOrientation.bearing);
    b.H(paramParcel, i);
  }

  public StreetViewPanoramaOrientation cT(Parcel paramParcel)
  {
    float f1 = 0.0F;
    int i = a.C(paramParcel);
    int j = 0;
    float f2 = 0.0F;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.B(paramParcel);
      switch (a.aD(k))
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
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new StreetViewPanoramaOrientation(j, f2, f1);
  }

  public StreetViewPanoramaOrientation[] eJ(int paramInt)
  {
    return new StreetViewPanoramaOrientation[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.t
 * JD-Core Version:    0.6.2
 */