package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;

public class d
{
  static void a(CircleOptions paramCircleOptions, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1, paramCircleOptions.getVersionCode());
    b.a(paramParcel, 2, paramCircleOptions.getCenter(), paramInt, false);
    b.a(paramParcel, 3, paramCircleOptions.getRadius());
    b.a(paramParcel, 4, paramCircleOptions.getStrokeWidth());
    b.c(paramParcel, 5, paramCircleOptions.getStrokeColor());
    b.c(paramParcel, 6, paramCircleOptions.getFillColor());
    b.a(paramParcel, 7, paramCircleOptions.getZIndex());
    b.a(paramParcel, 8, paramCircleOptions.isVisible());
    b.H(paramParcel, i);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.d
 * JD-Core Version:    0.6.2
 */