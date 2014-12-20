package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class GroundOverlayOptions
  implements SafeParcelable
{
  public static final d a = new d();
  private final int b;
  private a c;
  private LatLng d;
  private float e;
  private float f;
  private LatLngBounds g;
  private float h;
  private float i;
  private boolean j = true;
  private float k = 0.0F;
  private float l = 0.5F;
  private float m = 0.5F;

  public GroundOverlayOptions()
  {
    this.b = 1;
  }

  GroundOverlayOptions(int paramInt, IBinder paramIBinder, LatLng paramLatLng, float paramFloat1, float paramFloat2, LatLngBounds paramLatLngBounds, float paramFloat3, float paramFloat4, boolean paramBoolean, float paramFloat5, float paramFloat6, float paramFloat7)
  {
    this.b = paramInt;
    this.c = new a(com.google.android.gms.a.b.a(paramIBinder));
    this.d = paramLatLng;
    this.e = paramFloat1;
    this.f = paramFloat2;
    this.g = paramLatLngBounds;
    this.h = paramFloat3;
    this.i = paramFloat4;
    this.j = paramBoolean;
    this.k = paramFloat5;
    this.l = paramFloat6;
    this.m = paramFloat7;
  }

  IBinder a()
  {
    return this.c.a().asBinder();
  }

  int b()
  {
    return this.b;
  }

  public LatLng c()
  {
    return this.d;
  }

  public float d()
  {
    return this.e;
  }

  public int describeContents()
  {
    return 0;
  }

  public float e()
  {
    return this.f;
  }

  public LatLngBounds f()
  {
    return this.g;
  }

  public float g()
  {
    return this.h;
  }

  public float h()
  {
    return this.i;
  }

  public float i()
  {
    return this.k;
  }

  public float j()
  {
    return this.l;
  }

  public float k()
  {
    return this.m;
  }

  public boolean l()
  {
    return this.j;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (com.google.android.gms.maps.a.b.a())
      v.a(this, paramParcel, paramInt);
    while (true)
    {
      return;
      d.a(this, paramParcel, paramInt);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.GroundOverlayOptions
 * JD-Core Version:    0.6.0
 */