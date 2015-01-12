package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;

public class n
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
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.n
 * JD-Core Version:    0.6.2
 */