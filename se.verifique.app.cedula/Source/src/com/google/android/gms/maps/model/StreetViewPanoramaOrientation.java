package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.kt;
import com.google.android.gms.internal.kv;
import com.google.android.gms.internal.kx;

public class StreetViewPanoramaOrientation
  implements SafeParcelable
{
  public static final n a = new n();
  public final float b;
  public final float c;
  private final int d;

  public StreetViewPanoramaOrientation(float paramFloat1, float paramFloat2)
  {
    this(1, paramFloat1, paramFloat2);
  }

  StreetViewPanoramaOrientation(int paramInt, float paramFloat1, float paramFloat2)
  {
    if ((-90.0F <= paramFloat1) && (paramFloat1 <= 90.0F));
    for (boolean bool = true; ; bool = false)
    {
      kx.b(bool, "Tilt needs to be between -90 and 90 inclusive");
      this.d = paramInt;
      this.b = (0.0F + paramFloat1);
      if (paramFloat2 <= 0.0D)
        paramFloat2 = 360.0F + paramFloat2 % 360.0F;
      this.c = (paramFloat2 % 360.0F);
      return;
    }
  }

  int a()
  {
    return this.d;
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
      if (!(paramObject instanceof StreetViewPanoramaOrientation))
      {
        i = 0;
        continue;
      }
      StreetViewPanoramaOrientation localStreetViewPanoramaOrientation = (StreetViewPanoramaOrientation)paramObject;
      if ((Float.floatToIntBits(this.b) == Float.floatToIntBits(localStreetViewPanoramaOrientation.b)) && (Float.floatToIntBits(this.c) == Float.floatToIntBits(localStreetViewPanoramaOrientation.c)))
        continue;
      i = 0;
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Float.valueOf(this.b);
    arrayOfObject[1] = Float.valueOf(this.c);
    return kt.a(arrayOfObject);
  }

  public String toString()
  {
    return kt.a(this).a("tilt", Float.valueOf(this.b)).a("bearing", Float.valueOf(this.c)).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    n.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.StreetViewPanoramaOrientation
 * JD-Core Version:    0.6.0
 */