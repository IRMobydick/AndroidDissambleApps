package com.ubercab.client.core.model;

public class TripVehicleType
{
  Integer capacity;
  String id;
  String make;
  String model;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    TripVehicleType localTripVehicleType;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localTripVehicleType = (TripVehicleType)paramObject;
      if (this.capacity != null)
      {
        if (this.capacity.equals(localTripVehicleType.capacity));
      }
      else
        while (localTripVehicleType.capacity != null)
          return false;
      if (this.id != null)
      {
        if (this.id.equals(localTripVehicleType.id));
      }
      else
        while (localTripVehicleType.id != null)
          return false;
      if (this.make != null)
      {
        if (this.make.equals(localTripVehicleType.make));
      }
      else
        while (localTripVehicleType.make != null)
          return false;
      if (this.model == null)
        break;
    }
    while (this.model.equals(localTripVehicleType.model));
    while (true)
    {
      return false;
      if (localTripVehicleType.model == null)
        break;
    }
  }

  public int getCapacity()
  {
    if (this.capacity == null)
      return 0;
    return this.capacity.intValue();
  }

  public String getId()
  {
    return this.id;
  }

  public String getMake()
  {
    return this.make;
  }

  public String getModel()
  {
    return this.model;
  }

  public int hashCode()
  {
    int i;
    int k;
    label35: int m;
    if (this.capacity != null)
    {
      i = this.capacity.hashCode();
      int j = i * 31;
      if (this.id == null)
        break label103;
      k = this.id.hashCode();
      m = 31 * (j + k);
      if (this.make == null)
        break label108;
    }
    label103: label108: for (int n = this.make.hashCode(); ; n = 0)
    {
      int i1 = 31 * (m + n);
      String str = this.model;
      int i2 = 0;
      if (str != null)
        i2 = this.model.hashCode();
      return i1 + i2;
      i = 0;
      break;
      k = 0;
      break label35;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.TripVehicleType
 * JD-Core Version:    0.6.2
 */