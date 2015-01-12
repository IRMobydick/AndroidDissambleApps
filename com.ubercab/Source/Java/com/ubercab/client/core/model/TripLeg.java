package com.ubercab.client.core.model;

import java.util.List;

public class TripLeg
{
  public static final String STATUS_ARRIVED = "Arrived";
  public static final String STATUS_EN_ROUTE = "EnRoute";
  List<TripLegAction> actions;
  String encodedPolyline;
  String locationEndRef;
  String locationStartRef;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    TripLeg localTripLeg;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localTripLeg = (TripLeg)paramObject;
      if (this.actions != null)
      {
        if (this.actions.equals(localTripLeg.actions));
      }
      else
        while (localTripLeg.actions != null)
          return false;
      if (this.encodedPolyline != null)
      {
        if (this.encodedPolyline.equals(localTripLeg.encodedPolyline));
      }
      else
        while (localTripLeg.encodedPolyline != null)
          return false;
      if (this.locationEndRef != null)
      {
        if (this.locationEndRef.equals(localTripLeg.locationEndRef));
      }
      else
        while (localTripLeg.locationEndRef != null)
          return false;
      if (this.locationStartRef == null)
        break;
    }
    while (this.locationStartRef.equals(localTripLeg.locationStartRef));
    while (true)
    {
      return false;
      if (localTripLeg.locationStartRef == null)
        break;
    }
  }

  public List<TripLegAction> getActions()
  {
    return this.actions;
  }

  public String getEncodedPolyline()
  {
    return this.encodedPolyline;
  }

  public String getLocationEndRef()
  {
    return this.locationEndRef;
  }

  public String getLocationStartRef()
  {
    return this.locationStartRef;
  }

  public int hashCode()
  {
    int i;
    int k;
    label37: int m;
    if (this.actions != null)
    {
      i = this.actions.hashCode();
      int j = i * 31;
      if (this.encodedPolyline == null)
        break label105;
      k = this.encodedPolyline.hashCode();
      m = 31 * (j + k);
      if (this.locationEndRef == null)
        break label110;
    }
    label105: label110: for (int n = this.locationEndRef.hashCode(); ; n = 0)
    {
      int i1 = 31 * (m + n);
      String str = this.locationStartRef;
      int i2 = 0;
      if (str != null)
        i2 = this.locationStartRef.hashCode();
      return i1 + i2;
      i = 0;
      break;
      k = 0;
      break label37;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.TripLeg
 * JD-Core Version:    0.6.2
 */