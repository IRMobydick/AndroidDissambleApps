package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.n.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class StreetViewPanoramaLocation
  implements SafeParcelable
{
  public static final s CREATOR = new s();
  private final int BR;
  public final StreetViewPanoramaLink[] links;
  public final String panoId;
  public final LatLng position;

  StreetViewPanoramaLocation(int paramInt, StreetViewPanoramaLink[] paramArrayOfStreetViewPanoramaLink, LatLng paramLatLng, String paramString)
  {
    this.BR = paramInt;
    this.links = paramArrayOfStreetViewPanoramaLink;
    this.position = paramLatLng;
    this.panoId = paramString;
  }

  public StreetViewPanoramaLocation(StreetViewPanoramaLink[] paramArrayOfStreetViewPanoramaLink, LatLng paramLatLng, String paramString)
  {
    this(1, paramArrayOfStreetViewPanoramaLink, paramLatLng, paramString);
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    StreetViewPanoramaLocation localStreetViewPanoramaLocation;
    do
    {
      return true;
      if (!(paramObject instanceof StreetViewPanoramaLocation))
        return false;
      localStreetViewPanoramaLocation = (StreetViewPanoramaLocation)paramObject;
    }
    while ((this.panoId.equals(localStreetViewPanoramaLocation.panoId)) && (this.position.equals(localStreetViewPanoramaLocation.position)));
    return false;
  }

  int getVersionCode()
  {
    return this.BR;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.position;
    arrayOfObject[1] = this.panoId;
    return n.hashCode(arrayOfObject);
  }

  public String toString()
  {
    return n.h(this).a("panoId", this.panoId).a("position", this.position.toString()).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    s.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.StreetViewPanoramaLocation
 * JD-Core Version:    0.6.2
 */