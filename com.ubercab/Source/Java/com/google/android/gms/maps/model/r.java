package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class r
  implements Parcelable.Creator<StreetViewPanoramaLink>
{
  static void a(StreetViewPanoramaLink paramStreetViewPanoramaLink, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1, paramStreetViewPanoramaLink.getVersionCode());
    b.a(paramParcel, 2, paramStreetViewPanoramaLink.panoId, false);
    b.a(paramParcel, 3, paramStreetViewPanoramaLink.bearing);
    b.H(paramParcel, i);
  }

  public StreetViewPanoramaLink cR(Parcel paramParcel)
  {
    int i = a.C(paramParcel);
    int j = 0;
    String str = null;
    float f = 0.0F;
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
        str = a.o(paramParcel, k);
        break;
      case 3:
        f = a.l(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new StreetViewPanoramaLink(j, str, f);
  }

  public StreetViewPanoramaLink[] eH(int paramInt)
  {
    return new StreetViewPanoramaLink[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.r
 * JD-Core Version:    0.6.2
 */