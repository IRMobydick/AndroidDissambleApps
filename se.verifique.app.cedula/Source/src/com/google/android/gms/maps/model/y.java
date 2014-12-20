package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.c;

public class y
{
  static void a(MarkerOptions paramMarkerOptions, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramMarkerOptions.a());
    c.a(paramParcel, 2, paramMarkerOptions.c(), paramInt, false);
    c.a(paramParcel, 3, paramMarkerOptions.d(), false);
    c.a(paramParcel, 4, paramMarkerOptions.e(), false);
    c.a(paramParcel, 5, paramMarkerOptions.b(), false);
    c.a(paramParcel, 6, paramMarkerOptions.f());
    c.a(paramParcel, 7, paramMarkerOptions.g());
    c.a(paramParcel, 8, paramMarkerOptions.h());
    c.a(paramParcel, 9, paramMarkerOptions.i());
    c.a(paramParcel, i);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.y
 * JD-Core Version:    0.6.0
 */