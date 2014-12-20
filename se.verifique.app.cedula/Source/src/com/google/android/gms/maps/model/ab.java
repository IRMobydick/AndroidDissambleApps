package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.c;

public class ab
{
  static void a(Tile paramTile, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramTile.a());
    c.a(paramParcel, 2, paramTile.b);
    c.a(paramParcel, 3, paramTile.c);
    c.a(paramParcel, 4, paramTile.d, false);
    c.a(paramParcel, i);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.ab
 * JD-Core Version:    0.6.0
 */