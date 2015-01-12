package com.ubercab.client.core.model;

public final class LocationTagAddResponse
{
  private LocationSearchResult result;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    LocationTagAddResponse localLocationTagAddResponse;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localLocationTagAddResponse = (LocationTagAddResponse)paramObject;
      if (this.result == null)
        break;
    }
    while (this.result.equals(localLocationTagAddResponse.result));
    while (true)
    {
      return false;
      if (localLocationTagAddResponse.result == null)
        break;
    }
  }

  public LocationSearchResult getResult()
  {
    return this.result;
  }

  public int hashCode()
  {
    if (this.result != null)
      return this.result.hashCode();
    return 0;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.LocationTagAddResponse
 * JD-Core Version:    0.6.2
 */