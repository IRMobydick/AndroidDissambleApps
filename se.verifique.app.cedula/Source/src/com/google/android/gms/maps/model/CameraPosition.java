package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.kt;
import com.google.android.gms.internal.kv;
import com.google.android.gms.internal.kx;

public final class CameraPosition
  implements SafeParcelable
{
  public static final b a = new b();
  public final LatLng b;
  public final float c;
  public final float d;
  public final float e;
  private final int f;

  CameraPosition(int paramInt, LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    kx.a(paramLatLng, "null camera target");
    if ((0.0F <= paramFloat2) && (paramFloat2 <= 90.0F));
    for (boolean bool = true; ; bool = false)
    {
      kx.b(bool, "Tilt needs to be between 0 and 90 inclusive");
      this.f = paramInt;
      this.b = paramLatLng;
      this.c = paramFloat1;
      this.d = (paramFloat2 + 0.0F);
      if (paramFloat3 <= 0.0D)
        paramFloat3 = 360.0F + paramFloat3 % 360.0F;
      this.e = (paramFloat3 % 360.0F);
      return;
    }
  }

  int a()
  {
    return this.f;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    int i = 1;
    if (this == paramObject);
    while (true)
    {
      return i;
      if (!(paramObject instanceof CameraPosition))
      {
        i = 0;
        continue;
      }
      CameraPosition localCameraPosition = (CameraPosition)paramObject;
      if ((this.b.equals(localCameraPosition.b)) && (Float.floatToIntBits(this.c) == Float.floatToIntBits(localCameraPosition.c)) && (Float.floatToIntBits(this.d) == Float.floatToIntBits(localCameraPosition.d)) && (Float.floatToIntBits(this.e) == Float.floatToIntBits(localCameraPosition.e)))
        continue;
      i = 0;
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = this.b;
    arrayOfObject[1] = Float.valueOf(this.c);
    arrayOfObject[2] = Float.valueOf(this.d);
    arrayOfObject[3] = Float.valueOf(this.e);
    return kt.a(arrayOfObject);
  }

  public String toString()
  {
    return kt.a(this).a("target", this.b).a("zoom", Float.valueOf(this.c)).a("tilt", Float.valueOf(this.d)).a("bearing", Float.valueOf(this.e)).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (com.google.android.gms.maps.a.b.a())
      t.a(this, paramParcel, paramInt);
    while (true)
    {
      return;
      b.a(this, paramParcel, paramInt);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.CameraPosition
 * JD-Core Version:    0.6.0
 */