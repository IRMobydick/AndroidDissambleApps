package com.ubercab.client.core.model;

import java.util.List;

public class LocationAutocompleteResponse
{
  List<LocationSearchResult> predictions;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    LocationAutocompleteResponse localLocationAutocompleteResponse;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localLocationAutocompleteResponse = (LocationAutocompleteResponse)paramObject;
      if (this.predictions == null)
        break;
    }
    while (this.predictions.equals(localLocationAutocompleteResponse.predictions));
    while (true)
    {
      return false;
      if (localLocationAutocompleteResponse.predictions == null)
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
 * Qualified Name:     com.ubercab.client.core.model.LocationAutocompleteResponse
 * JD-Core Version:    0.6.2
 */