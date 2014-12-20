package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.c;

public class w
{
  static void a(LatLngBounds paramLatLngBounds, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramLatLngBounds.a());
    c.a(paramParcel, 2, paramLatLngBounds.b, paramInt, false);
    c.a(paramParcel, 3, paramLatLngBounds.c, paramInt, false);
    c.a(paramParcel, i);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.w
 * JD-Core Version:    0.6.0
 */