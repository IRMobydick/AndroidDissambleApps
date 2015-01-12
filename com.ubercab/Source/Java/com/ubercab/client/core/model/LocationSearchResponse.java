package com.ubercab.client.core.model;

import java.util.List;

public class LocationSearchResponse
{
  List<LocationSearchResult> predictions;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    LocationSearchResponse localLocationSearchResponse;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localLocationSearchResponse = (LocationSearchResponse)paramObject;
      if (this.predictions == null)
        break;
    }
    while (this.predictions.equals(localLocationSearchResponse.predictions));
    while (true)
    {
      return false;
      if (localLocationSearchResponse.predictions == null)
        break;
    }
  }

  public List<LocationSearchResult> getPredictions()
  {
    return this.predictions;
  }

  public int hashCode()
  {
    if (this.predictions != null)
      return this.predictions.hashCode();
    return 0;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.LocationSearchResponse
 * JD-Core Version:    0.6.2
 */