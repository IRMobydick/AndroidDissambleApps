package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.c;

public class z
{
  static void a(PolygonOptions paramPolygonOptions, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramPolygonOptions.a());
    c.b(paramParcel, 2, paramPolygonOptions.c(), false);
    c.c(paramParcel, 3, paramPolygonOptions.b(), false);
    c.a(paramParcel, 4, paramPolygonOptions.d());
    c.a(paramParcel, 5, paramPolygonOptions.e());
    c.a(paramParcel, 6, paramPolygonOptions.f());
    c.a(paramParcel, 7, paramPolygonOptions.g());
    c.a(paramParcel, 8, paramPolygonOptions.h());
    c.a(paramParcel, 9, paramPolygonOptions.i());
    c.a(paramParcel, i);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.z
 * JD-Core Version:    0.6.0
 */