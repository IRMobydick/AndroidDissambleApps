package com.google.android.gms.maps;

import android.os.Parcel;

public class b
{
  static void a(GoogleMapOptions paramGoogleMapOptions, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.b.D(paramParcel);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 1, paramGoogleMapOptions.getVersionCode());
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 2, paramGoogleMapOptions.mr());
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 3, paramGoogleMapOptions.ms());
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 4, paramGoogleMapOptions.getMapType());
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 5, paramGoogleMapOptions.getCamera(), paramInt, false);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 6, paramGoogleMapOptions.mt());
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 7, paramGoogleMapOptions.mu());
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 8, paramGoogleMapOptions.mv());
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 9, paramGoogleMapOptions.mw());
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 10, paramGoogleMapOptions.mx());
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 11, paramGoogleMapOptions.my());
    com.google.android.gms.common.internal.safeparcel.b.H(paramParcel, i);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.b
 * JD-Core Version:    0.6.2
 */