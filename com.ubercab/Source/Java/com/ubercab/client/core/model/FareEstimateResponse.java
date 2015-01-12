package com.ubercab.client.core.model;

import java.util.Map;

public final class FareEstimateResponse
{
  private FareEstimateLocation destinationLocation;
  private FareEstimateLocation pickupLocation;
  private Map<String, FareEstimateVehicleViewData> vehicleViews;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    FareEstimateResponse localFareEstimateResponse;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localFareEstimateResponse = (FareEstimateResponse)paramObject;
      if (this.destinationLocation != null)
      {
        if (this.destinationLocation.equals(localFareEstimateResponse.destinationLocation));
      }
      else
        while (localFareEstimateResponse.destinationLocation != null)
          return false;
      if (this.pickupLocation != null)
      {
        if (this.pickupLocation.equals(localFareEstimateResponse.pickupLocation));
      }
      else
        while (localFareEstimateResponse.pickupLocation != null)
          return false;
      if (this.vehicleViews == null)
        break;
    }
    while (this.vehicleViews.equals(localFareEstimateResponse.vehicleViews));
    while (true)
    {
      return false;
      if (localFareEstimateResponse.vehicleViews == null)
        break;
    }
  }

  public FareEstimateLocation getDestinationLocation()
  {
    return this.destinationLocation;
  }

  public FareEstimateLocation getPickupLocation()
  {
    return this.pickupLocation;
  }

  public Map<String, FareEstimateVehicleViewData> getVehicleViews()
  {
    return this.vehicleViews;
  }

  public int hashCode()
  {
    int i;
    int j;
    if (this.vehicleViews != null)
    {
      i = this.vehicleViews.hashCode();
      j = i * 31;
      if (this.pickupLocation == null)
        break label79;
    }
    label79: for (int k = this.pickupLocation.hashCode(); ; k = 0)
    {
      int m = 31 * (j + k);
      FareEstimateLocation localFareEstimateLocation = this.destinationLocation;
      int n = 0;
      if (localFareEstimateLocation != null)
        n = this.destinationLocation.hashCode();
      return m + n;
      i = 0;
      break;
    }
  }

  void setDestinationLocation(FareEstimateLocation paramFareEstimateLocation)
  {
    this.destinationLocation = paramFareEstimateLocation;
  }

  void setPickupLocation(FareEstimateLocation paramFareEstimateLocation)
  {
    this.pickupLocation = paramFareEstimateLocation;
  }

  void setVehicleViews(Map<String, FareEstimateVehicleViewData> paramMap)
  {
    this.vehicleViews = paramMap;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.FareEstimateResponse
 * JD-Core Version:    0.6.2
 */