package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;

public class p
{
  static void a(PolylineOptions paramPolylineOptions, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1, paramPolylineOptions.getVersionCode());
    b.c(paramParcel, 2, paramPolylineOptions.getPoints(), false);
    b.a(paramParcel, 3, paramPolylineOptions.getWidth());
    b.c(paramParcel, 4, paramPolylineOptions.getColor());
    b.a(paramParcel, 5, paramPolylineOptions.getZIndex());
    b.a(paramParcel, 6, paramPolylineOptions.isVisible());
    b.a(paramParcel, 7, paramPolylineOptions.isGeodesic());
    b.H(paramParcel, i);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.p
 * JD-Core Version:    0.6.2
 */