package com.ubercab.client.core.model;

import com.ubercab.client.core.location.RiderLocation;
import com.ubercab.library.location.model.UberLatLng;

public final class FareEstimateLocation
{
  private Double latitude;
  private Double longitude;

  public static boolean isLocationEqual(FareEstimateLocation paramFareEstimateLocation, RiderLocation paramRiderLocation)
  {
    if ((paramFareEstimateLocation == null) || (paramRiderLocation == null));
    UberLatLng localUberLatLng;
    do
    {
      return false;
      localUberLatLng = paramRiderLocation.getUberLatLng();
    }
    while ((localUberLatLng == null) || (paramFareEstimateLocation.getLatitude() == null) || (paramFareEstimateLocation.getLongitude() == null) || (paramFareEstimateLocation.getLatitude().doubleValue() != localUberLatLng.getLatitude()) || (paramFareEstimateLocation.getLongitude().doubleValue() != localUberLatLng.getLongitude()));
    return true;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    FareEstimateLocation localFareEstimateLocation;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localFareEstimateLocation = (FareEstimateLocation)paramObject;
      if (this.latitude != null)
      {
        if (this.latitude.equals(localFareEstimateLocation.latitude));
      }
      else
        while (localFareEstimateLocation.latitude != null)
          return false;
      if (this.longitude == null)
        break;
    }
    while (this.longitude.equals(localFareEstimateLocation.longitude));
    while (true)
    {
      return false;
      if (localFareEstimateLocation.longitude == null)
        break;
    }
  }

  public Double getLatitude()
  {
    return this.latitude;
  }

  public Double getLongitude()
  {
    return this.longitude;
  }

  public int hashCode()
  {
    if (this.latitude != null);
    for (int i = this.latitude.hashCode(); ; i = 0)
    {
      int j = i * 31;
      Double localDouble = this.longitude;
      int k = 0;
      if (localDouble != null)
        k = this.longitude.hashCode();
      return j + k;
    }
  }

  public void setLatitude(Double paramDouble)
  {
    this.latitude = paramDouble;
  }

  public void setLongitude(Double paramDouble)
  {
    this.longitude = paramDouble;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.FareEstimateLocation
 * JD-Core Version:    0.6.2
 */