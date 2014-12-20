package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class s
  implements Parcelable.Creator
{
  static void a(VisibleRegion paramVisibleRegion, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramVisibleRegion.a());
    c.a(paramParcel, 2, paramVisibleRegion.b, paramInt, false);
    c.a(paramParcel, 3, paramVisibleRegion.c, paramInt, false);
    c.a(paramParcel, 4, paramVisibleRegion.d, paramInt, false);
    c.a(paramParcel, 5, paramVisibleRegion.e, paramInt, false);
    c.a(paramParcel, 6, paramVisibleRegion.f, paramInt, false);
    c.a(paramParcel, i);
  }

  public VisibleRegion a(Parcel paramParcel)
  {
    LatLngBounds localLatLngBounds = null;
    int i = a.b(paramParcel);
    int j = 0;
    LatLng localLatLng1 = null;
    LatLng localLatLng2 = null;
    LatLng localLatLng3 = null;
    LatLng localLatLng4 = null;
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
        localLatLng4 = (LatLng)a.a(paramParcel, k, LatLng.a);
        break;
      case 3:
        localLatLng3 = (LatLng)a.a(paramParcel, k, LatLng.a);
        break;
      case 4:
        localLatLng2 = (LatLng)a.a(paramParcel, k, LatLng.a);
        break;
      case 5:
        localLatLng1 = (LatLng)a.a(paramParcel, k, LatLng.a);
        break;
      case 6:
        localLatLngBounds = (LatLngBounds)a.a(paramParcel, k, LatLngBounds.a);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new VisibleRegion(j, localLatLng4, localLatLng3, localLatLng2, localLatLng1, localLatLngBounds);
  }

  public VisibleRegion[] a(int paramInt)
  {
    return new VisibleRegion[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.s
 * JD-Core Version:    0.6.0
 */