package com.ubercab.client.core.model;

public class Itinerary
{
  CnLocation destination;
  FareEstimateRange fareEstimateRange;
  String fareEstimateString;
  String fareEstimateTagline;
  String fareId;
  CnLocation pickupLocation;
  String vehicleViewId;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    Itinerary localItinerary;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localItinerary = (Itinerary)paramObject;
      if (this.destination != null)
      {
        if (this.destination.equals(localItinerary.destination));
      }
      else
        while (localItinerary.destination != null)
          return false;
      if (this.fareEstimateString != null)
      {
        if (this.fareEstimateString.equals(localItinerary.fareEstimateString));
      }
      else
        while (localItinerary.fareEstimateString != null)
          return false;
      if (this.fareEstimateTagline != null)
      {
        if (this.fareEstimateTagline.equals(localItinerary.fareEstimateTagline));
      }
      else
        while (localItinerary.fareEstimateTagline != null)
          return false;
      if (this.fareId != null)
      {
        if (this.fareId.equals(localItinerary.fareId));
      }
      else
        while (localItinerary.fareId != null)
          return false;
      if (this.pickupLocation != null)
      {
        if (this.pickupLocation.equals(localItinerary.pickupLocation));
      }
      else
        while (localItinerary.pickupLocation != null)
          return false;
      if (this.vehicleViewId == null)
        break;
    }
    while (this.vehicleViewId.equals(localItinerary.vehicleViewId));
    while (true)
    {
      return false;
      if (localItinerary.vehicleViewId == null)
        break;
    }
  }

  public CnLocation getDestination()
  {
    return this.destination;
  }

  public FareEstimateRange getFareEstimateRange()
  {
    return this.fareEstimateRange;
  }

  public String getFareEstimateString()
  {
    return this.fareEstimateString;
  }

  public String getFareEstimateTagline()
  {
    return this.fareEstimateTagline;
  }

  public String getFareId()
  {
    return this.fareId;
  }

  public CnLocation getPickupLocation()
  {
    return this.pickupLocation;
  }

  public String getVehicleViewId()
  {
    return this.vehicleViewId;
  }

  public int hashCode()
  {
    int i;
    int k;
    label35: int n;
    label59: int i2;
    label85: int i3;
    if (this.fareEstimateString != null)
    {
      i = this.fareEstimateString.hashCode();
      int j = i * 31;
      if (this.fareEstimateTagline == null)
        break label155;
      k = this.fareEstimateTagline.hashCode();
      int m = 31 * (j + k);
      if (this.fareId == null)
        break label160;
      n = this.fareId.hashCode();
      int i1 = 31 * (m + n);
      if (this.vehicleViewId == null)
        break label166;
      i2 = this.vehicleViewId.hashCode();
      i3 = 31 * (i1 + i2);
      if (this.destination == null)
        break label172;
    }
    label155: label160: label166: label172: for (int i4 = this.destination.hashCode(); ; i4 = 0)
    {
      int i5 = 31 * (i3 + i4);
      CnLocation localCnLocation = this.pickupLocation;
      int i6 = 0;
      if (localCnLocation != null)
        i6 = this.pickupLocation.hashCode();
      return i5 + i6;
      i = 0;
      break;
      k = 0;
      break label35;
      n = 0;
      break label59;
      i2 = 0;
      break label85;
    }
  }

  void setDestinationLocation(CnLocation paramCnLocation)
  {
    this.destination = paramCnLocation;
  }

  void setFareEstimateString(String paramString)
  {
    this.fareEstimateString = paramString;
  }

  void setFareEstimateTagline(String paramString)
  {
    this.fareEstimateTagline = paramString;
  }

  void setFareId(String paramString)
  {
    this.fareId = paramString;
  }

  void setPickupLocation(CnLocation paramCnLocation)
  {
    this.pickupLocation = paramCnLocation;
  }

  void setVehicleViewId(String paramString)
  {
    this.vehicleViewId = paramString;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.Itinerary
 * JD-Core Version:    0.6.2
 */