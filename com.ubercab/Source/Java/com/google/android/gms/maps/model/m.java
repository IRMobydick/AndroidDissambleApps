package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class m
  implements Parcelable.Creator<PolygonOptions>
{
  static void a(PolygonOptions paramPolygonOptions, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1, paramPolygonOptions.getVersionCode());
    b.c(paramParcel, 2, paramPolygonOptions.getPoints(), false);
    b.d(paramParcel, 3, paramPolygonOptions.mQ(), false);
    b.a(paramParcel, 4, paramPolygonOptions.getStrokeWidth());
    b.c(paramParcel, 5, paramPolygonOptions.getStrokeColor());
    b.c(paramParcel, 6, paramPolygonOptions.getFillColor());
    b.a(paramParcel, 7, paramPolygonOptions.getZIndex());
    b.a(paramParcel, 8, paramPolygonOptions.isVisible());
    b.a(paramParcel, 9, paramPolygonOptions.isGeodesic());
    b.H(paramParcel, i);
  }

  public PolygonOptions cO(Parcel paramParcel)
  {
    float f1 = 0.0F;
    boolean bool1 = false;
    int i = a.C(paramParcel);
    ArrayList localArrayList1 = null;
    ArrayList localArrayList2 = new ArrayList();
    boolean bool2 = false;
    int j = 0;
    int k = 0;
    float f2 = 0.0F;
    int m = 0;
    while (paramParcel.dataPosition() < i)
    {
      int n = a.B(paramParcel);
      switch (a.aD(n))
      {
      default:
        a.b(paramParcel, n);
        break;
      case 1:
        m = a.g(paramParcel, n);
        break;
      case 2:
        localArrayList1 = a.c(paramParcel, n, LatLng.CREATOR);
        break;
      case 3:
        a.a(paramParcel, n, localArrayList2, getClass().getClassLoader());
        break;
      case 4:
        f2 = a.l(paramParcel, n);
        break;
      case 5:
        k = a.g(paramParcel, n);
        break;
      case 6:
        j = a.g(paramParcel, n);
        break;
      case 7:
        f1 = a.l(paramParcel, n);
        break;
      case 8:
        bool2 = a.c(paramParcel, n);
        break;
      case 9:
        bool1 = a.c(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new PolygonOptions(m, localArrayList1, localArrayList2, f2, k, j, f1, bool2, bool1);
  }

  public PolygonOptions[] eE(int paramInt)
  {
    return new PolygonOptions[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.m
 * JD-Core Version:    0.6.2
 */