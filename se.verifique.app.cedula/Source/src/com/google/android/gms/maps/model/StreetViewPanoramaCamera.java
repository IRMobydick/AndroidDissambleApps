package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.kt;
import com.google.android.gms.internal.kv;
import com.google.android.gms.internal.kx;

public class StreetViewPanoramaCamera
  implements SafeParcelable
{
  public static final j a = new j();
  public final float b;
  public final float c;
  public final float d;
  private final int e;
  private StreetViewPanoramaOrientation f;

  StreetViewPanoramaCamera(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    boolean bool;
    float f1;
    if ((-90.0F <= paramFloat2) && (paramFloat2 <= 90.0F))
    {
      bool = true;
      kx.b(bool, "Tilt needs to be between -90 and 90 inclusive");
      this.e = paramInt;
      this.b = paramFloat1;
      this.c = (0.0F + paramFloat2);
      if (paramFloat3 > 0.0D)
        break label102;
      f1 = 360.0F + paramFloat3 % 360.0F;
    }
    while (true)
    {
      this.d = (f1 % 360.0F);
      this.f = new m().a(paramFloat2).b(paramFloat3).a();
      return;
      bool = false;
      break;
      label102: f1 = paramFloat3;
    }
  }

  int a()
  {
    return this.e;
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
      if (!(paramObject instanceof StreetViewPanoramaCamera))
      {
        i = 0;
        continue;
      }
      StreetViewPanoramaCamera localStreetViewPanoramaCamera = (StreetViewPanoramaCamera)paramObject;
      if ((Float.floatToIntBits(this.b) == Float.floatToIntBits(localStreetViewPanoramaCamera.b)) && (Float.floatToIntBits(this.c) == Float.floatToIntBits(localStreetViewPanoramaCamera.c)) && (Float.floatToIntBits(this.d) == Float.floatToIntBits(localStreetViewPanoramaCamera.d)))
        continue;
      i = 0;
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Float.valueOf(this.b);
    arrayOfObject[1] = Float.valueOf(this.c);
    arrayOfObject[2] = Float.valueOf(this.d);
    return kt.a(arrayOfObject);
  }

  public String toString()
  {
    return kt.a(this).a("zoom", Float.valueOf(this.b)).a("tilt", Float.valueOf(this.c)).a("bearing", Float.valueOf(this.d)).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    j.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.StreetViewPanoramaCamera
 * JD-Core Version:    0.6.0
 */