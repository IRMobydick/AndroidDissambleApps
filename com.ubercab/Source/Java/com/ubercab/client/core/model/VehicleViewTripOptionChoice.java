package com.ubercab.client.core.model;

public class VehicleViewTripOptionChoice
{
  String title;
  Object value;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    VehicleViewTripOptionChoice localVehicleViewTripOptionChoice;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localVehicleViewTripOptionChoice = (VehicleViewTripOptionChoice)paramObject;
      if (this.title != null)
      {
        if (this.title.equals(localVehicleViewTripOptionChoice.title));
      }
      else
        while (localVehicleViewTripOptionChoice.title != null)
          return false;
      if (this.value == null)
        break;
    }
    while (this.value.equals(localVehicleViewTripOptionChoice.value));
    while (true)
    {
      return false;
      if (localVehicleViewTripOptionChoice.value == null)
        break;
    }
  }

  public String getTitle()
  {
    return this.title;
  }

  public Object getValue()
  {
    return this.value;
  }

  public int hashCode()
  {
    if (this.title != null);
    for (int i = this.title.hashCode(); ; i = 0)
    {
      int j = i * 31;
      Object localObject = this.value;
      int k = 0;
      if (localObject != null)
        k = this.value.hashCode();
      return j + k;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.VehicleViewTripOptionChoice
 * JD-Core Version:    0.6.2
 */