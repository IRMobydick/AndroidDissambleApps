package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.a.b;

public final class CircleOptions
  implements SafeParcelable
{
  public static final c a = new c();
  private final int b;
  private LatLng c = null;
  private double d = 0.0D;
  private float e = 10.0F;
  private int f = -16777216;
  private int g = 0;
  private float h = 0.0F;
  private boolean i = true;

  public CircleOptions()
  {
    this.b = 1;
  }

  CircleOptions(int paramInt1, LatLng paramLatLng, double paramDouble, float paramFloat1, int paramInt2, int paramInt3, float paramFloat2, boolean paramBoolean)
  {
    this.b = paramInt1;
    this.c = paramLatLng;
    this.d = paramDouble;
    this.e = paramFloat1;
    this.f = paramInt2;
    this.g = paramInt3;
    this.h = paramFloat2;
    this.i = paramBoolean;
  }

  int a()
  {
    return this.b;
  }

  public LatLng b()
  {
    return this.c;
  }

  public double c()
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

  public int e()
  {
    return this.f;
  }

  public int f()
  {
    return this.g;
  }

  public float g()
  {
    return this.h;
  }

  public boolean h()
  {
    return this.i;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (b.a())
      u.a(this, paramParcel, paramInt);
    while (true)
    {
      return;
      c.a(this, paramParcel, paramInt);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.CircleOptions
 * JD-Core Version:    0.6.0
 */