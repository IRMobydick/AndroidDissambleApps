package com.ubercab.client.feature.notification.data;

import com.ubercab.client.core.model.CnLocation;

public final class TripDestinationData
{
  private String address;
  private double latitude;
  private double longitude;

  public static TripDestinationData createFakeTripDestinationData()
  {
    TripDestinationData localTripDestinationData = new TripDestinationData();
    localTripDestinationData.setAddress("50 Stow Lake Drive");
    localTripDestinationData.setLatitude(37.768999999999998D);
    localTripDestinationData.setLongitude(-122.4773D);
    return localTripDestinationData;
  }

  public static TripDestinationData fromCnLocation(CnLocation paramCnLocation)
  {
    TripDestinationData localTripDestinationData = new TripDestinationData();
    localTripDestinationData.setAddress(paramCnLocation.getAddress());
    localTripDestinationData.setLatitude(paramCnLocation.getLatitude());
    localTripDestinationData.setLongitude(paramCnLocation.getLongitude());
    return localTripDestinationData;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    TripDestinationData localTripDestinationData;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localTripDestinationData = (TripDestinationData)paramObject;
      if (Double.compare(localTripDestinationData.latitude, this.latitude) != 0)
        return false;
      if (Double.compare(localTripDestinationData.longitude, this.longitude) != 0)
        return false;
      if (this.address == null)
        break;
    }
    while (this.address.equals(localTripDestinationData.address));
    while (true)
    {
      return false;
      if (localTripDestinationData.address == null)
        break;
    }
  }

  public String getAddress()
  {
    return this.address;
  }

  public double getLatitude()
  {
    return this.latitude;
  }

  public double getLongitude()
  {
    return this.longitude;
  }

  public int hashCode()
  {
    long l1 = Double.doubleToLongBits(this.latitude);
    int i = (int)(l1 ^ l1 >>> 32);
    long l2 = Double.doubleToLongBits(this.longitude);
    int j = 31 * (i * 31 + (int)(l2 ^ l2 >>> 32));
    if (this.address != null);
    for (int k = this.address.hashCode(); ; k = 0)
      return j + k;
  }

  public void setAddress(String paramString)
  {
    this.address = paramString;
  }

  public void setLatitude(double paramDouble)
  {
    this.latitude = paramDouble;
  }

  public void setLongitude(double paramDouble)
  {
    this.longitude = paramDouble;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.notification.data.TripDestinationData
 * JD-Core Version:    0.6.2
 */