package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.kt;
import com.google.android.gms.internal.kv;
import com.google.android.gms.internal.kx;
import com.google.android.gms.maps.a.b;

public final class LatLngBounds
  implements SafeParcelable
{
  public static final e a = new e();
  public final LatLng b;
  public final LatLng c;
  private final int d;

  LatLngBounds(int paramInt, LatLng paramLatLng1, LatLng paramLatLng2)
  {
    kx.a(paramLatLng1, "null southwest");
    kx.a(paramLatLng2, "null northeast");
    if (paramLatLng2.b >= paramLatLng1.b);
    for (boolean bool = true; ; bool = false)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Double.valueOf(paramLatLng1.b);
      arrayOfObject[1] = Double.valueOf(paramLatLng2.b);
      kx.b(bool, "southern latitude exceeds northern latitude (%s > %s)", arrayOfObject);
      this.d = paramInt;
      this.b = paramLatLng1;
      this.c = paramLatLng2;
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
      if (!(paramObject instanceof LatLngBounds))
      {
        i = 0;
        continue;
      }
      LatLngBounds localLatLngBounds = (LatLngBounds)paramObject;
      if ((this.b.equals(localLatLngBounds.b)) && (this.c.equals(localLatLngBounds.c)))
        continue;
      i = 0;
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.b;
    arrayOfObject[1] = this.c;
    return kt.a(arrayOfObject);
  }

  public String toString()
  {
    return kt.a(this).a("southwest", this.b).a("northeast", this.c).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (b.a())
      w.a(this, paramParcel, paramInt);
    while (true)
    {
      return;
      e.a(this, paramParcel, paramInt);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.LatLngBounds
 * JD-Core Version:    0.6.0
 */