package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.kt;
import com.google.android.gms.internal.kv;

public class StreetViewPanoramaLocation
  implements SafeParcelable
{
  public static final l a = new l();
  public final StreetViewPanoramaLink[] b;
  public final LatLng c;
  public final String d;
  private final int e;

  StreetViewPanoramaLocation(int paramInt, StreetViewPanoramaLink[] paramArrayOfStreetViewPanoramaLink, LatLng paramLatLng, String paramString)
  {
    this.e = paramInt;
    this.b = paramArrayOfStreetViewPanoramaLink;
    this.c = paramLatLng;
    this.d = paramString;
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
      if (!(paramObject instanceof StreetViewPanoramaLocation))
      {
        i = 0;
        continue;
      }
      StreetViewPanoramaLocation localStreetViewPanoramaLocation = (StreetViewPanoramaLocation)paramObject;
      if ((this.d.equals(localStreetViewPanoramaLocation.d)) && (this.c.equals(localStreetViewPanoramaLocation.c)))
        continue;
      i = 0;
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.c;
    arrayOfObject[1] = this.d;
    return kt.a(arrayOfObject);
  }

  public String toString()
  {
    return kt.a(this).a("panoId", this.d).a("position", this.c.toString()).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    l.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.StreetViewPanoramaLocation
 * JD-Core Version:    0.6.0
 */