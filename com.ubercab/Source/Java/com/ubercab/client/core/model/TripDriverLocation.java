package com.ubercab.client.core.model;

import com.ubercab.library.location.model.UberLatLng;

public class TripDriverLocation
{
  private double latitude;
  private double longitude;

  public TripDriverLocation()
  {
  }

  TripDriverLocation(double paramDouble1, double paramDouble2)
  {
    this.latitude = paramDouble1;
    this.longitude = paramDouble2;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    TripDriverLocation localTripDriverLocation;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localTripDriverLocation = (TripDriverLocation)paramObject;
      if (Double.compare(localTripDriverLocation.latitude, this.latitude) != 0)
        return false;
    }
    while (Double.compare(localTripDriverLocation.longitude, this.longitude) == 0);
    return false;
  }

  public double getLatitude()
  {
    return this.latitude;
  }

  public double getLongitude()
  {
    return this.longitude;
  }

  public UberLatLng getUberLatLng()
  {
    return new UberLatLng(this.latitude, this.longitude);
  }

  public int hashCode()
  {
    long l1 = Double.doubleToLongBits(this.latitude);
    int i = (int)(l1 ^ l1 >>> 32);
    long l2 = Double.doubleToLongBits(this.longitude);
    return i * 31 + (int)(l2 ^ l2 >>> 32);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.TripDriverLocation
 * JD-Core Version:    0.6.2
 */