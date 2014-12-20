package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.kt;
import com.google.android.gms.internal.kv;
import com.google.android.gms.maps.a.b;

public final class VisibleRegion
  implements SafeParcelable
{
  public static final s a = new s();
  public final LatLng b;
  public final LatLng c;
  public final LatLng d;
  public final LatLng e;
  public final LatLngBounds f;
  private final int g;

  VisibleRegion(int paramInt, LatLng paramLatLng1, LatLng paramLatLng2, LatLng paramLatLng3, LatLng paramLatLng4, LatLngBounds paramLatLngBounds)
  {
    this.g = paramInt;
    this.b = paramLatLng1;
    this.c = paramLatLng2;
    this.d = paramLatLng3;
    this.e = paramLatLng4;
    this.f = paramLatLngBounds;
  }

  int a()
  {
    return this.g;
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
      if (!(paramObject instanceof VisibleRegion))
      {
        i = 0;
        continue;
      }
      VisibleRegion localVisibleRegion = (VisibleRegion)paramObject;
      if ((this.b.equals(localVisibleRegion.b)) && (this.c.equals(localVisibleRegion.c)) && (this.d.equals(localVisibleRegion.d)) && (this.e.equals(localVisibleRegion.e)) && (this.f.equals(localVisibleRegion.f)))
        continue;
      i = 0;
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = this.b;
    arrayOfObject[1] = this.c;
    arrayOfObject[2] = this.d;
    arrayOfObject[3] = this.e;
    arrayOfObject[4] = this.f;
    return kt.a(arrayOfObject);
  }

  public String toString()
  {
    return kt.a(this).a("nearLeft", this.b).a("nearRight", this.c).a("farLeft", this.d).a("farRight", this.e).a("latLngBounds", this.f).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (b.a())
      ad.a(this, paramParcel, paramInt);
    while (true)
    {
      return;
      s.a(this, paramParcel, paramInt);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.VisibleRegion
 * JD-Core Version:    0.6.0
 */