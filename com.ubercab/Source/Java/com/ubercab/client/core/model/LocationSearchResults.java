package com.ubercab.client.core.model;

import java.util.ArrayList;
import java.util.List;

public class LocationSearchResults
{
  LocationSearchResult primaryResult;

  @Deprecated
  LocationSearchResult primary_result;
  List<LocationSearchResult> secondaryResults;

  @Deprecated
  List<LocationSearchResult> secondary_results;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    LocationSearchResults localLocationSearchResults;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localLocationSearchResults = (LocationSearchResults)paramObject;
      if (this.primaryResult != null)
      {
        if (this.primaryResult.equals(localLocationSearchResults.primaryResult));
      }
      else
        while (localLocationSearchResults.primaryResult != null)
          return false;
      if (this.primary_result != null)
      {
        if (this.primary_result.equals(localLocationSearchResults.primary_result));
      }
      else
        while (localLocationSearchResults.primary_result != null)
          return false;
      if (this.secondaryResults != null)
      {
        if (this.secondaryResults.equals(localLocationSearchResults.secondaryResults));
      }
      else
        while (localLocationSearchResults.secondaryResults != null)
          return false;
      if (this.secondary_results == null)
        break;
    }
    while (this.secondary_results.equals(localLocationSearchResults.secondary_results));
    while (true)
    {
      return false;
      if (localLocationSearchResults.secondary_results == null)
        break;
    }
  }

  public List<LocationSearchResult> getAllResults()
  {
    ArrayList localArrayList = new ArrayList();
    LocationSearchResult localLocationSearchResult = getPrimaryResult();
    if (localLocationSearchResult != null)
      localArrayList.add(localLocationSearchResult);
    List localList = getSecondaryResults();
    if (localList != null)
      localArrayList.addAll(localList);
    return localArrayList;
  }

  public LocationSearchResult getPrimaryResult()
  {
    if (this.primaryResult != null)
      return this.primaryResult;
    return this.primary_result;
  }

  public List<LocationSearchResult> getSecondaryResults()
  {
    if (this.secondaryResults != null)
      return this.secondaryResults;
    if (this.secondary_results != null)
      return this.secondary_results;
    return null;
  }

  public int hashCode()
  {
    int i;
    int k;
    label37: int m;
    if (this.primary_result != null)
    {
      i = this.primary_result.hashCode();
      int j = i * 31;
      if (this.secondary_results == null)
        break label107;
      k = this.secondary_results.hashCode();
      m = 31 * (j + k);
      if (this.primaryResult == null)
        break label112;
    }
    label107: label112: for (int n = this.primaryResult.hashCode(); ; n = 0)
    {
      int i1 = 31 * (m + n);
      List localList = this.secondaryResults;
      int i2 = 0;
      if (localList != null)
        i2 = this.secondaryResults.hashCode();
      return i1 + i2;
      i = 0;
      break;
      k = 0;
      break label37;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.LocationSearchResults
 * JD-Core Version:    0.6.2
 */