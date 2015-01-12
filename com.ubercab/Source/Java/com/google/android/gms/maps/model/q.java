package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class q
  implements Parcelable.Creator<StreetViewPanoramaCamera>
{
  static void a(StreetViewPanoramaCamera paramStreetViewPanoramaCamera, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1, paramStreetViewPanoramaCamera.getVersionCode());
    b.a(paramParcel, 2, paramStreetViewPanoramaCamera.zoom);
    b.a(paramParcel, 3, paramStreetViewPanoramaCamera.tilt);
    b.a(paramParcel, 4, paramStreetViewPanoramaCamera.bearing);
    b.H(paramParcel, i);
  }

  public StreetViewPanoramaCamera cQ(Parcel paramParcel)
  {
    float f1 = 0.0F;
    int i = a.C(paramParcel);
    float f2 = 0.0F;
    int j = 0;
    float f3 = 0.0F;
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
        f3 = a.l(paramParcel, k);
        break;
      case 4:
        f1 = a.l(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new StreetViewPanoramaCamera(j, f2, f3, f1);
  }

  public StreetViewPanoramaCamera[] eG(int paramInt)
  {
    return new StreetViewPanoramaCamera[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.q
 * JD-Core Version:    0.6.2
 */