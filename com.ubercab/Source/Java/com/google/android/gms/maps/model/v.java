package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;

public class v
{
  static void a(Tile paramTile, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1, paramTile.getVersionCode());
    b.c(paramParcel, 2, paramTile.width);
    b.c(paramParcel, 3, paramTile.height);
    b.a(paramParcel, 4, paramTile.data, false);
    b.H(paramParcel, i);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.v
 * JD-Core Version:    0.6.2
 */