package com.ubercab.client.core.model;

import java.util.List;
import java.util.Map;

public class NearbyVehicle
{
  String etaString;
  String etaStringShort;
  Integer minEta;
  Map<String, List<VehiclePathPoint>> vehiclePaths;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    NearbyVehicle localNearbyVehicle;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localNearbyVehicle = (NearbyVehicle)paramObject;
      if (this.minEta != null)
      {
        if (this.minEta.equals(localNearbyVehicle.minEta));
      }
      else
        while (localNearbyVehicle.minEta != null)
          return false;
      if (this.etaString != null)
      {
        if (this.etaString.equals(localNearbyVehicle.etaString));
      }
      else
        while (localNearbyVehicle.etaString != null)
          return false;
      if (this.etaStringShort != null)
      {
        if (this.etaStringShort.equals(localNearbyVehicle.etaStringShort));
      }
      else
        while (localNearbyVehicle.etaStringShort != null)
          return false;
      if (this.vehiclePaths == null)
        break;
    }
    while (this.vehiclePaths.equals(localNearbyVehicle.vehiclePaths));
    while (true)
    {
      return false;
      if (localNearbyVehicle.vehiclePaths == null)
        break;
    }
  }

  public String getEtaString()
  {
    return this.etaString;
  }

  public String getEtaStringShort()
  {
    return this.etaStringShort;
  }

  public int getMinEta()
  {
    if (this.minEta != null)
      return this.minEta.intValue();
    return 0;
  }

  public Map<String, List<VehiclePathPoint>> getVehiclePaths()
  {
    return this.vehiclePaths;
  }

  public int hashCode()
  {
    int i;
    int k;
    label35: int m;
    if (this.minEta != null)
    {
      i = this.minEta.hashCode();
      int j = i * 31;
      if (this.etaString == null)
        break label105;
      k = this.etaString.hashCode();
      m = 31 * (j + k);
      if (this.etaStringShort == null)
        break label110;
    }
    label105: label110: for (int n = this.etaStringShort.hashCode(); ; n = 0)
    {
      int i1 = 31 * (m + n);
      Map localMap = this.vehiclePaths;
      int i2 = 0;
      if (localMap != null)
        i2 = this.vehiclePaths.hashCode();
      return i1 + i2;
      i = 0;
      break;
      k = 0;
      break label35;
    }
  }

  public void setVehiclePaths(Map<String, List<VehiclePathPoint>> paramMap)
  {
    this.vehiclePaths = paramMap;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.NearbyVehicle
 * JD-Core Version:    0.6.2
 */