package com.ubercab.client.core.model;

import java.util.List;

public class LocationHistoryResponse
{
  LocationSearchResults dropoffs;
  LocationSearchResults pickups;
  List<LocationSearchResult> tagged;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    LocationHistoryResponse localLocationHistoryResponse;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localLocationHistoryResponse = (LocationHistoryResponse)paramObject;
      if (this.dropoffs != null)
      {
        if (this.dropoffs.equals(localLocationHistoryResponse.dropoffs));
      }
      else
        while (localLocationHistoryResponse.dropoffs != null)
          return false;
      if (this.pickups != null)
      {
        if (this.pickups.equals(localLocationHistoryResponse.pickups));
      }
      else
        while (localLocationHistoryResponse.pickups != null)
          return false;
      if (this.tagged == null)
        break;
    }
    while (this.tagged.equals(localLocationHistoryResponse.tagged));
    while (true)
    {
      return false;
      if (localLocationHistoryResponse.tagged == null)
        break;
    }
  }

  public LocationSearchResults getDropoffs()
  {
    return this.dropoffs;
  }

  public LocationSearchResults getPickups()
  {
    return this.pickups;
  }

  public List<LocationSearchResult> getTagged()
  {
    return this.tagged;
  }

  public int hashCode()
  {
    int i;
    int j;
    if (this.pickups != null)
    {
      i = this.pickups.hashCode();
      j = i * 31;
      if (this.dropoffs == null)
        break label79;
    }
    label79: for (int k = this.dropoffs.hashCode(); ; k = 0)
    {
      int m = 31 * (j + k);
      List localList = this.tagged;
      int n = 0;
      if (localList != null)
        n = this.tagged.hashCode();
      return m + n;
      i = 0;
      break;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.LocationHistoryResponse
 * JD-Core Version:    0.6.2
 */