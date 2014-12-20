package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;

public class b
  implements Parcelable.Creator
{
  static void a(CameraPosition paramCameraPosition, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramCameraPosition.a());
    c.a(paramParcel, 2, paramCameraPosition.b, paramInt, false);
    c.a(paramParcel, 3, paramCameraPosition.c);
    c.a(paramParcel, 4, paramCameraPosition.d);
    c.a(paramParcel, 5, paramCameraPosition.e);
    c.a(paramParcel, i);
  }

  public CameraPosition a(Parcel paramParcel)
  {
    float f1 = 0.0F;
    int i = a.b(paramParcel);
    int j = 0;
    LatLng localLatLng = null;
    float f2 = 0.0F;
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
        localLatLng = (LatLng)a.a(paramParcel, k, LatLng.a);
        break;
      case 3:
        f3 = a.l(paramParcel, k);
        break;
      case 4:
        f2 = a.l(paramParcel, k);
        break;
      case 5:
        f1 = a.l(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + i, paramParcel);
    return new CameraPosition(j, localLatLng, f3, f2, f1);
  }

  public CameraPosition[] a(int paramInt)
  {
    return new CameraPosition[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.b
 * JD-Core Version:    0.6.0
 */