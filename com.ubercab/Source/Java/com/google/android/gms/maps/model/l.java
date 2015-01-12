package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;

public class l
{
  static void a(MarkerOptions paramMarkerOptions, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1, paramMarkerOptions.getVersionCode());
    b.a(paramParcel, 2, paramMarkerOptions.getPosition(), paramInt, false);
    b.a(paramParcel, 3, paramMarkerOptions.getTitle(), false);
    b.a(paramParcel, 4, paramMarkerOptions.getSnippet(), false);
    b.a(paramParcel, 5, paramMarkerOptions.mP(), false);
    b.a(paramParcel, 6, paramMarkerOptions.getAnchorU());
    b.a(paramParcel, 7, paramMarkerOptions.getAnchorV());
    b.a(paramParcel, 8, paramMarkerOptions.isDraggable());
    b.a(paramParcel, 9, paramMarkerOptions.isVisible());
    b.H(paramParcel, i);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.l
 * JD-Core Version:    0.6.2
 */