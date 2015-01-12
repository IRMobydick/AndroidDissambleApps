package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.n.a;
import com.google.android.gms.common.internal.o;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class StreetViewPanoramaOrientation
  implements SafeParcelable
{
  public static final t CREATOR = new t();
  private final int BR;
  public final float bearing;
  public final float tilt;

  public StreetViewPanoramaOrientation(float paramFloat1, float paramFloat2)
  {
    this(1, paramFloat1, paramFloat2);
  }

  StreetViewPanoramaOrientation(int paramInt, float paramFloat1, float paramFloat2)
  {
    if ((-90.0F <= paramFloat1) && (paramFloat1 <= 90.0F));
    for (boolean bool = true; ; bool = false)
    {
      o.b(bool, "Tilt needs to be between -90 and 90 inclusive");
      this.BR = paramInt;
      this.tilt = (0.0F + paramFloat1);
      if (paramFloat2 <= 0.0D)
        paramFloat2 = 360.0F + paramFloat2 % 360.0F;
      this.bearing = (paramFloat2 % 360.0F);
      return;
    }
  }

  public static Builder builder()
  {
    return new Builder();
  }

  public static Builder builder(StreetViewPanoramaOrientation paramStreetViewPanoramaOrientation)
  {
    return new Builder(paramStreetViewPanoramaOrientation);
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    StreetViewPanoramaOrientation localStreetViewPanoramaOrientation;
    do
    {
      return true;
      if (!(paramObject instanceof StreetViewPanoramaOrientation))
        return false;
      localStreetViewPanoramaOrientation = (StreetViewPanoramaOrientation)paramObject;
    }
    while ((Float.floatToIntBits(this.tilt) == Float.floatToIntBits(localStreetViewPanoramaOrientation.tilt)) && (Float.floatToIntBits(this.bearing) == Float.floatToIntBits(localStreetViewPanoramaOrientation.bearing)));
    return false;
  }

  int getVersionCode()
  {
    return this.BR;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Float.valueOf(this.tilt);
    arrayOfObject[1] = Float.valueOf(this.bearing);
    return n.hashCode(arrayOfObject);
  }

  public String toString()
  {
    return n.h(this).a("tilt", Float.valueOf(this.tilt)).a("bearing", Float.valueOf(this.bearing)).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    t.a(this, paramParcel, paramInt);
  }

  public static final class Builder
  {
    public float bearing;
    public float tilt;

    public Builder()
    {
    }

    public Builder(StreetViewPanoramaOrientation paramStreetViewPanoramaOrientation)
    {
      this.bearing = paramStreetViewPanoramaOrientation.bearing;
      this.tilt = paramStreetViewPanoramaOrientation.tilt;
    }

    public Builder bearing(float paramFloat)
    {
      this.bearing = paramFloat;
      return this;
    }

    public StreetViewPanoramaOrientation build()
    {
      return new StreetViewPanoramaOrientation(this.tilt, this.bearing);
    }

    public Builder tilt(float paramFloat)
    {
      this.tilt = paramFloat;
      return this;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.StreetViewPanoramaOrientation
 * JD-Core Version:    0.6.2
 */