package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class a
  implements Parcelable.Creator<CameraPosition>
{
  static void a(CameraPosition paramCameraPosition, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1, paramCameraPosition.getVersionCode());
    b.a(paramParcel, 2, paramCameraPosition.target, paramInt, false);
    b.a(paramParcel, 3, paramCameraPosition.zoom);
    b.a(paramParcel, 4, paramCameraPosition.tilt);
    b.a(paramParcel, 5, paramCameraPosition.bearing);
    b.H(paramParcel, i);
  }

  public CameraPosition cI(Parcel paramParcel)
  {
    float f1 = 0.0F;
    int i = com.google.android.gms.common.internal.safeparcel.a.C(paramParcel);
    int j = 0;
    LatLng localLatLng = null;
    float f2 = 0.0F;
    float f3 = 0.0F;
    while (paramParcel.dataPosition() < i)
    {
      int k = com.google.android.gms.common.internal.safeparcel.a.B(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.aD(k))
      {
      default:
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
        break;
      case 1:
        j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
        break;
      case 2:
        localLatLng = (LatLng)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, LatLng.CREATOR);
        break;
      case 3:
        f3 = com.google.android.gms.common.internal.safeparcel.a.l(paramParcel, k);
        break;
      case 4:
        f2 = com.google.android.gms.common.internal.safeparcel.a.l(paramParcel, k);
        break;
      case 5:
        f1 = com.google.android.gms.common.internal.safeparcel.a.l(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new CameraPosition(j, localLatLng, f3, f2, f1);
  }

  public CameraPosition[] ey(int paramInt)
  {
    return new CameraPosition[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.a
 * JD-Core Version:    0.6.2
 */