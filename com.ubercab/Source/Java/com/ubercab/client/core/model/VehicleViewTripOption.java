package com.ubercab.client.core.model;

import java.util.List;

public class VehicleViewTripOption
{
  List<VehicleViewTripOptionChoice> choices;
  Integer defaultChoiceIndex;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    VehicleViewTripOption localVehicleViewTripOption;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localVehicleViewTripOption = (VehicleViewTripOption)paramObject;
      if (this.choices != null)
      {
        if (this.choices.equals(localVehicleViewTripOption.choices));
      }
      else
        while (localVehicleViewTripOption.choices != null)
          return false;
      if (this.defaultChoiceIndex == null)
        break;
    }
    while (this.defaultChoiceIndex.equals(localVehicleViewTripOption.defaultChoiceIndex));
    while (true)
    {
      return false;
      if (localVehicleViewTripOption.defaultChoiceIndex == null)
        break;
    }
  }

  public List<VehicleViewTripOptionChoice> getChoices()
  {
    return this.choices;
  }

  public int getDefaultChoiceIndex()
  {
    if (this.defaultChoiceIndex == null)
      return 0;
    return this.defaultChoiceIndex.intValue();
  }

  public int hashCode()
  {
    if (this.defaultChoiceIndex != null);
    for (int i = this.defaultChoiceIndex.hashCode(); ; i = 0)
    {
      int j = i * 31;
      List localList = this.choices;
      int k = 0;
      if (localList != null)
        k = this.choices.hashCode();
      return j + k;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.VehicleViewTripOption
 * JD-Core Version:    0.6.2
 */