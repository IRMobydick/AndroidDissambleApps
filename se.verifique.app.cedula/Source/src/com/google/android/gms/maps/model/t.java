package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.c;

public class t
{
  static void a(CameraPosition paramCameraPosition, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramCameraPosition.a());
    c.a(paramParcel, 2, paramCameraPosition.b, paramInt, false);
    c.a(paramParcel, 3, paramCameraPosition.c);
    c.a(paramParcel, 4, paramCameraPosition.d);
    c.a(paramParcel, 5, paramCameraPosition.e);
    c.a(paramParcel, i);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.t
 * JD-Core Version:    0.6.0
 */