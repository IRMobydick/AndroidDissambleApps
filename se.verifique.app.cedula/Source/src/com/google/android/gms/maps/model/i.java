package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.ArrayList;

public class i
  implements Parcelable.Creator
{
  static void a(PolylineOptions paramPolylineOptions, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramPolylineOptions.a());
    c.b(paramParcel, 2, paramPolylineOptions.b(), false);
    c.a(paramParcel, 3, paramPolylineOptions.c());
    c.a(paramParcel, 4, paramPolylineOptions.d());
    c.a(paramParcel, 5, paramPolylineOptions.e());
    c.a(paramParcel, 6, paramPolylineOptions.f());
    c.a(paramParcel, 7, paramPolylineOptions.g());
    c.a(paramParcel, i);
  }

  public PolylineOptions a(Parcel paramParcel)
  {
    float f1 = 0.0F;
    boolean bool1 = false;
    int i = a.b(paramParcel);
    ArrayList localArrayList = null;
    boolean bool2 = false;
    int j = 0;
    float f2 = 0.0F;
    int k = 0;
    while (paramParcel.dataPosition() < i)
    {
      int m = a.a(paramParcel);
      switch (a.a(m))
      {
      default:
        a.b(paramParcel, m);
        break;
      case 1:
        k = a.g(paramParcel, m);
        break;
      case 2:
        localArrayList = a.c(paramParcel, m, LatLng.a);
        break;
      case 3:
        f2 = a.l(paramParcel, m);
        break;
      case 4:
        j = a.g(paramParcel, m);
        break;
      case 5:
        f1 = a.l(paramParcel, m);
        break;
      case 6:
        bool2 = a.c(paramParcel, m);
        break;
      case 7:
        bool1 = a.c(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new PolylineOptions(k, localArrayList, f2, j, f1, bool2, bool1);
  }

  public PolylineOptions[] a(int paramInt)
  {
    return new PolylineOptions[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.i
 * JD-Core Version:    0.6.0
 */