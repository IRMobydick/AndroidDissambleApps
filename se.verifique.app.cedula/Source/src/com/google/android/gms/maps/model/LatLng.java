package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.a.b;

public final class LatLng
  implements SafeParcelable
{
  public static final f a = new f();
  public final double b;
  public final double c;
  private final int d;

  LatLng(int paramInt, double paramDouble1, double paramDouble2)
  {
    this.d = paramInt;
    if ((-180.0D <= paramDouble2) && (paramDouble2 < 180.0D));
    for (this.c = paramDouble2; ; this.c = ((360.0D + (paramDouble2 - 180.0D) % 360.0D) % 360.0D - 180.0D))
    {
      this.b = Math.max(-90.0D, Math.min(90.0D, paramDouble1));
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
      if (!(paramObject instanceof LatLng))
      {
        i = 0;
        continue;
      }
      LatLng localLatLng = (LatLng)paramObject;
      if ((Double.doubleToLongBits(this.b) == Double.doubleToLongBits(localLatLng.b)) && (Double.doubleToLongBits(this.c) == Double.doubleToLongBits(localLatLng.c)))
        continue;
      i = 0;
    }
  }

  public int hashCode()
  {
    long l1 = Double.doubleToLongBits(this.b);
    int i = 31 + (int)(l1 ^ l1 >>> 32);
    long l2 = Double.doubleToLongBits(this.c);
    return i * 31 + (int)(l2 ^ l2 >>> 32);
  }

  public String toString()
  {
    return "lat/lng: (" + this.b + "," + this.c + ")";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (b.a())
      x.a(this, paramParcel, paramInt);
    while (true)
    {
      return;
      f.a(this, paramParcel, paramInt);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.LatLng
 * JD-Core Version:    0.6.0
 */