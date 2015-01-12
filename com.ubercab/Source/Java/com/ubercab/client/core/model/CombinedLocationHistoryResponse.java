package com.ubercab.client.core.model;

import java.util.List;

public final class CombinedLocationHistoryResponse
{
  private List<LocationSearchResult> results;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    CombinedLocationHistoryResponse localCombinedLocationHistoryResponse;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localCombinedLocationHistoryResponse = (CombinedLocationHistoryResponse)paramObject;
      if (this.results == null)
        break;
    }
    while (this.results.equals(localCombinedLocationHistoryResponse.results));
    while (true)
    {
      return false;
      if (localCombinedLocationHistoryResponse.results == null)
        break;
    }
  }

  public List<LocationSearchResult> getResults()
  {
    return this.results;
  }

  public int hashCode()
  {
    if (this.results != null)
      return this.results.hashCode();
    return 0;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.CombinedLocationHistoryResponse
 * JD-Core Version:    0.6.2
 */