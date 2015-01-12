package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;

public class z
{
  static void a(VisibleRegion paramVisibleRegion, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1, paramVisibleRegion.getVersionCode());
    b.a(paramParcel, 2, paramVisibleRegion.nearLeft, paramInt, false);
    b.a(paramParcel, 3, paramVisibleRegion.nearRight, paramInt, false);
    b.a(paramParcel, 4, paramVisibleRegion.farLeft, paramInt, false);
    b.a(paramParcel, 5, paramVisibleRegion.farRight, paramInt, false);
    b.a(paramParcel, 6, paramVisibleRegion.latLngBounds, paramInt, false);
    b.H(paramParcel, i);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.z
 * JD-Core Version:    0.6.2
 */